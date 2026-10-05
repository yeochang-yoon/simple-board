# Initial Architecture

최종 갱신: 2026-10-06 (Asia/Seoul)

상태: 초기 설계 완료. 2026-10-05 사용자 검토로 Domain / 데이터 / 기본 책임 분리 / HTTP API 계약 / Backend 기술 구성 / 저장 구조 / Transaction / 검증 계획 전체를 수용했고 PR #11로 main에 반영했다. Phase 2는 완료됐으며 Phase 3 Backend 개발 기반 구축은 미착수다. 애플리케이션 구현이나 DB 실행 검증은 아직 수행하지 않았다.

## 설계 기준

- 기능 범위와 검증 기준은 [REQUIREMENTS.md](REQUIREMENTS.md)를 따른다.
- Backend부터 독립적으로 구현·검증·배포·운영하고, 이후 Frontend를 연결한다.
- 실제 RDBMS는 사용자 선택에 따라 PostgreSQL을 사용하며 JPA / Flyway Migration / Testcontainers로 개발하고 검증한다. 기술 구성은 4절에 확정했고, 구체적인 의존성 / 이미지 버전과 세부 설정은 기반 구축에서 파일에 고정하고 실행 검증한다.

## 1. Domain과 데이터 — 합의 완료

핵심 Domain은 게시글이며, `Post` Entity 하나와 게시글 테이블 하나로 시작한다. 회원과 작성자 관계는 없다.

| 정보 | 역할 | 값의 출처 |
|---|---|---|
| id | 특정 글을 조회·수정·삭제할 때 사용할 식별자 | 서버 / DB에서 생성 |
| title | 제목, 필수, 1~100자 | 작성·수정 요청 |
| content | 본문, 필수, 1~5,000자, 줄바꿈 허용 | 작성·수정 요청 |
| createdAt | 작성 시각, 수정해도 유지 | 서버에서 기록 |
| updatedAt | 수정 시각 | 작성 시에는 작성 시각과 같게 기록하고, 수정 시 갱신 |

위 이름과 값의 출처를 합의했고, 물리 테이블명 / DB 타입 / ID 생성 방식 / 시간 타입 / 정렬 동률 처리는 아래 저장 구조에 확정했다.

## 2. 기본 책임 분리 — 합의 완료

요청은 `Controller → Service → Repository → DB`로 이어지고, 결과는 HTTP 응답으로 반환한다.

| 구성 | 맡을 책임 |
|---|---|
| Controller / 요청·응답 DTO | HTTP 요청을 받아 입력을 검증하고 결과를 응답 형식으로 변환한다. Entity를 외부 계약으로 그대로 노출하지 않는다. |
| Service | 글 작성·조회·수정·삭제 흐름과 없는 글 처리를 수행한다. 저장 변경 작업의 Transaction 경계를 둔다. |
| Post Entity | 게시글의 저장 상태와 제목·본문 변경을 표현한다. |
| Repository | JPA를 통해 게시글 저장·검색·삭제를 수행한다. |
| Migration | 테이블 생성과 이후 Schema 변경 이력을 관리한다. |

예를 들어 수정은 Service가 기존 글을 찾고 제목·본문을 바꾼 뒤 Transaction 안에서 저장하는 흐름이다. 잘못된 입력이나 없는 글 요청은 실패 결과를 반환한다. Transaction과 실패 처리 기준은 6절을 따른다.

## 3. HTTP API 계약 — 합의 완료

아래 API 계약을 사용자 검토 후 수용했다. JSON은 계약 예시이며 실제 HTTP 실행 결과가 아니다.

### 3.1 정상 요청과 응답

| 기능 | Method / 경로 | 요청 Body | 성공 응답 |
|---|---|---|---|
| 작성 | POST /api/posts | title, content | 201 Created, 게시글 전체 정보와 Location: /api/posts/{id} |
| 목록 | GET /api/posts | 없음 | 200 OK, 본문을 제외한 게시글 정보의 JSON 배열. 빈 목록은 [] |
| 상세 | GET /api/posts/{id} | 없음 | 200 OK, 게시글 전체 정보 |
| 수정 | PUT /api/posts/{id} | title, content 모두 필수 | 200 OK, 수정된 게시글 전체 정보 |
| 삭제 | DELETE /api/posts/{id} | 없음 | 204 No Content, 응답 Body 없음 |

- 작성·수정 요청은 `Content-Type: application/json`을 사용한다. JSON 응답도 같은 형식이며 204에는 JSON Body를 보내지 않는다.
- `{id}`는 양의 정수 형태의 게시글 식별자다. 구체적인 DB 타입과 생성 전략은 5절의 저장 구조에 확정했다.
- 작성·수정의 입력은 제목과 본문이다. id / createdAt / updatedAt은 서버가 관리하며 사용자 입력으로 지정하거나 덮어쓰지 않는다.
- 수정은 제목과 본문을 함께 바꾸는 PUT을 사용한다. 일부 필드만 보내는 수정은 첫 MVP에 포함하지 않는다. 없는 글의 PUT으로 새 글을 생성하지 않는다.
- 목록은 확정한 최신 작성 순이며 페이지 나누기나 검색 조건은 없다. GET 요청으로 게시글 상태를 변경하지 않는다.
- 시간은 UTC 시각을 나타내는 문자열로 응답한다. 예: `2026-10-05T13:00:00Z`. DB 시간 타입과 소수 초 정밀도는 5절의 저장 구조에 확정했다.

Method와 상태 코드의 의미는 [RFC 9110의 HTTP Method](https://www.rfc-editor.org/rfc/rfc9110.html#section-9.3) 및 [상태 코드](https://www.rfc-editor.org/rfc/rfc9110.html#section-15)를 참고했다. 경로, DTO 구성과 각 작업에 사용할 구체적인 응답은 이 프로젝트에서 합의한 계약이다.

작성 / 수정 요청 예시:

```json
{
  "title": "첫 게시글",
  "content": "게시판을 만들고 있습니다."
}
```

작성 / 상세 / 수정 성공 응답 형태 예시 (작성 직후):

```json
{
  "id": 1,
  "title": "첫 게시글",
  "content": "게시판을 만들고 있습니다.",
  "createdAt": "2026-10-05T13:00:00Z",
  "updatedAt": "2026-10-05T13:00:00Z"
}
```

목록의 각 항목은 위 객체에서 content를 제외한 id / title / createdAt / updatedAt이다. 실제 수정 응답은 바뀐 제목·본문과 갱신된 updatedAt을 반환한다.

### 3.2 실패 응답

| 상황 | HTTP 상태 | 오류 code | 데이터 처리 |
|---|---|---|---|
| 필수 값 누락, 공백만 있는 값, 길이 초과, 잘못된 JSON / 값 타입 / id 형식 | 400 Bad Request | INVALID_REQUEST | 저장·수정·삭제하지 않는다. |
| 유효한 id지만 글이 없거나 이미 삭제됨 | 404 Not Found | POST_NOT_FOUND | 새 글 생성이나 다른 글 변경 없이 실패한다. |
| 예상하지 못한 서버 오류 | 500 Internal Server Error | INTERNAL_ERROR | 실패를 응답하며 상세 원인은 서버 로그로 조사한다. |

요청 형식과 입력 검증 후 대상 글의 존재를 확인한다. 삭제 성공 후 같은 id로 다시 상세 조회·수정·삭제하면 404를 반환한다. 마지막 동작은 확정한 없는 글 처리 요구사항을 따른다.

오류 응답은 code / message / fieldErrors를 갖는 JSON 객체다. code는 클라이언트와 테스트가 오류 종류를 구분하는 고정값이며 message는 사람이 읽는 설명이다. fieldErrors는 입력 항목별 오류 목록이며 항목을 특정할 수 없는 오류와 404 / 500에서는 빈 배열이다. message의 정확한 문구는 API의 고정 계약으로 강제하지 않는다.

제목이 공백만 있는 경우의 오류 Body 예시:

```json
{
  "code": "INVALID_REQUEST",
  "message": "입력값을 확인해주세요.",
  "fieldErrors": [
    {
      "field": "title",
      "message": "제목은 공백만으로 작성할 수 없습니다."
    }
  ]
}
```

경로·상태 코드·요청과 응답 형식의 합의는 완료했다. 실제 HTTP 호출 및 DB 상태 검증은 Backend 구현 후 수행한다.

## 4. Backend 기술 구성 — 합의 완료

2026-10-05 사용자가 아래 기술 구성 표 전체를 수용했다. 기능 범위를 추가하지 않으며 기존 Lifecycle을 실행하기 위한 도구를 선택한다.

| 영역 | 확정한 구성 | 선택 이유 |
|---|---|---|
| Java | Java 21 | 현재 설치된 Temurin JDK / javac 21.0.11을 실제 확인했고, 선택한 Spring Boot의 지원 범위에 포함된다. |
| Backend | Spring Boot 4.1.1, Spring MVC, Spring Data JPA, Bean Validation | 현재 공식 문서가 안내하는 안정 버전을 기준으로 HTTP / JPA / 입력 검증을 구현한다. 관련 라이브러리는 Boot의 의존성 관리를 따른다. |
| Build | Gradle, Groovy DSL, Wrapper | build.gradle에 의존성과 빌드를 기록하고, 로컬 / CI에서 같은 Gradle 버전을 Wrapper로 실행한다. |
| DB | PostgreSQL 18 | 이후 여러 Java / Spring 서비스에서도 먼저 깊게 익힐 주력 RDBMS로 사용자가 선택했다. local / test / production에서 같은 DB 계열을 사용한다. |
| Migration | Flyway, SQL Migration | 실제 DDL을 SQL 파일로 작성하고 적용 이력을 관리한다. PostgreSQL 지원 모듈도 함께 사용한다. |
| Test | Spring Boot Test / JUnit, PostgreSQL Testcontainers | DB를 사용하는 테스트에서 별도의 실제 PostgreSQL을 실행해 JPA / Migration / API 동작을 검증한다. 테스트 DB는 개발 데이터와 분리한다. |

Java 21은 현재 환경에서 불필요한 교체 없이 시작하기 위한 선택이다. PostgreSQL 선택 이유는 사용자의 장기 학습 목표다.

2026-10-05 사용자는 PostgreSQL과 MySQL의 기본 SQL, JPA 추상화, 제약조건, 동시성, Migration, 성능 튜닝 및 운영 차이를 비교한 뒤 PostgreSQL을 선택했다. 이후 숙박 예약 / 티켓 구매 / 주문 등에서도 기본 RDBMS로 계속 사용하며 깊게 익힌다는 목적이다. 현재 게시판은 일반적인 CRUD와 관계형 설계부터 시작하고, PostgreSQL의 고급 기능을 사용하기 위해 MVP 범위를 늘리지 않는다. 실제 DB 검증 / Container / 배포 / 운영 및 기존 데이터가 있는 상태의 변경·재배포 경험은 기존 Lifecycle대로 유지한다.

Schema 생성·변경은 Flyway가 담당하고 JPA는 매핑을 통해 데이터를 다룬다. JPA의 자동 Schema 변경으로 Migration을 대신하지 않는다. 아래 저장 구조와 검증 설정까지 사용자 수용으로 확정했다.

### 공식 문서로 확인한 조건 (2026-10-05)

- [Spring Boot 시스템 요구사항](https://docs.spring.io/spring-boot/system-requirements.html): 현재 안내 버전 4.1.1, Java 17~26 지원, Gradle 8.14 이상 8.x 및 9.x 지원.
- [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html): 프로젝트에 지정한 Gradle 버전을 내려받아 실행하고 로컬 / CI의 실행 버전을 맞춘다.
- [PostgreSQL 버전 정책](https://www.postgresql.org/support/versioning/): PostgreSQL 18은 지원 중이며 조회 시점의 minor 버전은 18.6이다.
- [Flyway PostgreSQL 문서](https://documentation.red-gate.com/flyway/reference/database-driver-reference/postgresql-database): PostgreSQL 18을 검증 버전으로 안내하며 PostgreSQL 지원 모듈을 별도 의존성으로 사용한다.
- [Spring Boot DB 초기화](https://docs.spring.io/spring-boot/how-to/data-initialization.html): Flyway를 통한 DB Migration 구성 방법을 제공한다.
- [Testcontainers PostgreSQL 모듈](https://java.testcontainers.org/modules/databases/postgres/): Java에서 PostgreSQL Container를 실행할 수 있다.

공식 지원 조건 확인과 실제 실행 검증은 구분한다. 아직 애플리케이션을 생성하거나 DB / Migration / Testcontainers를 실행하지 않았다. Gradle Wrapper와 DB 이미지의 정확한 버전 및 라이브러리 의존성은 Backend 기반 구축 시 파일에 고정하고 실제 Build / DB 연결 / Migration / Test로 확인한다.

## 5. PostgreSQL 저장 구조와 JPA 매핑 — 합의 완료

아래는 사용자가 수용한 구현 기준이다. 실제 Migration SQL이나 Entity를 작성·실행한 결과와 구분한다.

### 5.1 테이블과 컬럼

테이블명은 `posts`, Java Entity는 `Post`다. 테이블이 하나이므로 별도 관계나 FK는 없다.

| DB 컬럼 | PostgreSQL 타입 / 제약 | Java 매핑 | 의미 |
|---|---|---|---|
| id | bigint GENERATED ALWAYS AS IDENTITY, PRIMARY KEY | Long, GenerationType.IDENTITY | DB에서 생성하는 식별자 |
| title | varchar(100), NOT NULL, 빈 문자열 금지 CHECK | String | 제목 |
| content | varchar(5000), NOT NULL, 빈 문자열 금지 CHECK | String | 줄바꿈을 포함하는 일반 텍스트 본문 |
| created_at | timestamptz(6), NOT NULL | Instant | 작성 시점 |
| updated_at | timestamptz(6), NOT NULL | Instant | 수정 시점 |

- ID는 Identity의 내부 Sequence로 생성하며 연속 번호나 Commit 순서를 보장하는 값으로 사용하지 않는다. 현재 CRUD에서는 JPA IDENTITY 전략으로 시작한다.
- varchar 길이 제한 / NOT NULL / 빈 문자열 CHECK는 DB에서도 기본적인 저장 규칙을 보호한다. 공백만 있는 입력의 거절과 사용자에게 보여줄 필드 오류는 애플리케이션의 입력 검증에서 담당한다. 이 DB 제약만으로 모든 Validation을 대체하지 않는다.
- Java와 PostgreSQL은 문자열 길이 계산이 다를 수 있다. 구현 시 이모지 등 보조 문자를 포함한 길이 경계를 확인하고, 입력 검증의 문자 수 기준과 DB 제한이 어긋나지 않게 한다. 사용자에게 보이는 길이 단위를 변경할 필요가 발견되면 요구사항부터 확인한다.
- 시간은 특정 지역의 벽시계 값이 아니라 같은 순간을 나타내는 Instant로 다룬다. timestamptz는 원래 지역명이나 입력 Offset을 보존하는 타입이 아니다. DB 연결 / 조회 세션은 UTC로 맞추고 API는 기존 계약대로 UTC 문자열을 반환한다.
- 시간 생성 책임은 애플리케이션 하나로 둔다. Service에서 주입 가능한 Clock으로 시각을 얻고 DB 정밀도에 맞춰 마이크로초 단위로 맞춘 뒤 저장한다. 작성 시 하나의 값을 두 컬럼에 함께 넣고, 수정 시 created_at은 유지하며 updated_at을 다시 기록한다. DB DEFAULT나 Trigger와 중복 관리하지 않는다.

선택 근거: [PostgreSQL Identity](https://www.postgresql.org/docs/18/ddl-identity-columns.html), [문자열 타입](https://www.postgresql.org/docs/18/datatype-character.html), [시간 타입](https://www.postgresql.org/docs/18/datatype-datetime.html). 실제 Hibernate 매핑과 시간 왕복 결과는 PostgreSQL 테스트로 확인한다.

### 5.2 목록 정렬과 Index

- 목록은 `ORDER BY created_at DESC, id DESC`로 조회한다. 작성 시각이 같을 때 큰 ID를 먼저 보여주어 결과를 결정하며, ID를 실제 Commit 순서로 해석하지 않는다. 수정 시 목록 순서는 유지된다.
- 처음에는 PRIMARY KEY가 만드는 B-tree Index로 ID 조회 / 수정 / 삭제를 지원한다.
- 추가 Index는 우선 만들지 않는다. 현재 목록은 전체 행을 조회하므로 `(created_at, id)` Index가 항상 유리하다고 가정하지 않는다. 실제 목록 SQL의 `EXPLAIN (ANALYZE, BUFFERS)`로 Scan / Sort / 실행 비용을 함께 확인한 뒤 필요하면 별도 Migration으로 추가한다.
- 목록 DTO에는 content를 포함하지 않고, 목록 쿼리도 가능한 한 필요한 컬럼만 조회한다. Pagination이나 검색을 새로 추가하지 않는다.

[PostgreSQL Index와 정렬](https://www.postgresql.org/docs/18/indexes-ordering.html)은 전체 행 조회와 일부 행 조회에서 실행 계획의 선택이 달라질 수 있음을 설명한다. 현재 단계에서는 성능 개선을 검증했다고 기록하지 않는다.

## 6. Transaction과 실패 처리 — 합의 완료

- Transaction 경계는 Service에 둔다. 작성 / 수정 / 삭제는 하나의 쓰기 Transaction으로 처리한다. 수정은 존재 확인과 두 필드·수정 시각 변경을 같은 Transaction 안에서 수행한다.
- 목록 / 상세는 `@Transactional(readOnly = true)`로 처리한다. 이는 읽기 의도를 표현하는 설정이며 DB의 모든 쓰기를 차단하는 접근 제어로 취급하지 않는다.
- 격리 수준은 PostgreSQL 기본 READ COMMITTED로 시작한다. 현재 요구사항을 위해 SERIALIZABLE이나 명시적인 비관적 Lock을 추가하지 않는다.
- 입력이 잘못되면 변경 작업에 들어가지 않는다. 없는 글은 합의한 404로 처리한다. 쓰기 흐름의 실패는 Rollback하고, 오류 응답은 기존 API 계약을 따른다. DB 제약 위반을 일괄적으로 사용자 입력 오류 400으로 바꾸지 않는다.
- 동시 편집의 충돌 알림이나 이전 편집 보호는 현재 MVP에 없다. 별도 Version 필드 / 명시적 Lock 없이 시작하므로 동시 수정은 나중에 적용된 UPDATE가 앞선 값을 덮어쓸 수 있다. 사용자는 이 한계를 현재 MVP의 의도적인 범위로 수용했다. Transaction만으로 이를 막는다고 설명하지 않는다. 동시 수정 / 삭제의 추가 계약이 필요하면 해당 문제를 확인하고 별도 요구사항 변경으로 다룬다.

## 7. Migration과 테스트·실제 검증 — 합의 완료

### 7.1 역할과 환경

- Flyway의 첫 SQL Migration에서 posts 테이블과 제약조건을 생성한다. 예시 파일명은 `V1__create_posts.sql`이며 현재 단계에서는 실제 파일을 만들지 않는다.
- Hibernate는 `ddl-auto=validate`로 매핑과 Schema를 검증한다. create / update로 테이블을 변경하지 않는다. 이 validation만으로 모든 CHECK나 Index 정의까지 보장한다고 해석하지 않는다.
- 적용된 Migration은 수정하지 않고 다음 버전 파일로 변경한다. 기존 개발 / 운영 DB를 삭제해 Schema를 맞추지 않는다.
- local은 Docker Compose의 PostgreSQL과 데이터를 유지하는 Volume을 사용한다. Testcontainers는 DB 관련 테스트에서 별도의 실제 PostgreSQL을 실행한다. 테스트가 local / production 데이터에 연결되지 않게 분리한다.
- local / test / production은 PostgreSQL 계열을 유지하고 가능한 한 같은 major 버전을 사용한다. Container 이미지 버전은 기반 구축 때 고정한다. 운영 배포 대상과 연결 / Secret 설정은 해당 Lifecycle 단계에서 결정한다.

### 7.2 확인할 결과

| 검증 | 실제로 확인할 내용 | 진행 시점 |
|---|---|---|
| 기반 구축 검증 | 빈 테스트 DB에 Flyway 적용, 이력 기록, posts Schema, JPA validation, DB 연결 성공 | Backend 기반 구축 |
| 첫 작은 기능 테스트 | PostgreSQL에서 작성 / 조회 결과, 생성 ID와 시간 왕복, DB 제약과 입력 오류 동작 | 첫 Vertical Slice |
| 기능별 검증 | 요구사항의 정상 / 실패 흐름, 수정 전후 시각과 목록 순서, 실패 시 데이터 보존, 삭제 | CRUD 반복 개발 |
| HTTP + SQL 확인 | API 응답과 실제 저장 행 비교, 애플리케이션 재시작 후 데이터 유지 | 첫 기능부터 필요한 범위에서 수행 |
| 실행 계획 | PK Index 정의와 ID / 목록 조회의 실제 Scan / Sort 확인, 추가 Index 필요 판단. 작은 데이터에서 Sequential Scan이 선택되는 것도 정상일 수 있다. | Backend 독립 검증 시 필요한 데이터로 확인 |
| CI / 배포 / 운영 | PostgreSQL 테스트 실행, Container / 배포된 API·DB·Health·로그 결과 | 기존 Lifecycle의 해당 단계 |
| 기존 서비스 변경 | 기존 데이터가 있는 DB에 새 Migration 적용, 데이터 보존과 재배포 확인 | 배포 후 변경 |

첫 작성·조회는 POST 작성 응답과 후속 GET 상세 확인을 잇는 작은 Vertical Slice로 진행한다. 전체 CRUD를 한 번에 구현하지 않는다. 테스트 종류는 보장할 동작에 맞춰 선택하며 같은 흐름을 형식적으로 모든 테스트 계층에 중복하지 않는다. 첫 Transaction Rollback 검증은 실제 변경 후 실패를 발생시키고 새 Transaction으로 기존 데이터가 보존됐는지 확인한다.

첫 Migration / JPA 매핑 / PostgreSQL 테스트 / HTTP·SQL 검증은 사용자가 직접 작성하거나 실행하고 결과를 확인할 수 있도록 안내한다. 이후 동일 패턴의 반복은 Codex가 준비하고 실제 결과를 공유한다.

참고: [Spring Boot DB 초기화](https://docs.spring.io/spring-boot/how-to/data-initialization.html), [Spring Boot Testcontainers](https://docs.spring.io/spring-boot/reference/testing/testcontainers.html).

## 8. 초기 설계 완료 판단과 다음 작업

초기 설계의 완료 조건인 "첫 기능 개발에 필요한 최소 설계"는 사용자 합의로 준비됐다. Domain / API / 저장 구조 / 기술 선택 / Transaction / 검증 기준이 정해졌고, 첫 기능에서 핵심 구조를 처음부터 다시 결정할 필요가 없다. 구현 과정에서 발견되는 문제는 실제 근거에 따라 설계나 요구사항을 변경한다.

1. 초기 설계 문서는 [PR #11](https://github.com/yeochang-yoon/simple-board/pull/11)로 main에 반영됐다. [Issue #10](https://github.com/yeochang-yoon/simple-board/issues/10)은 closed / completed이며 완료 조건 네 항목 모두 체크됐다.
2. PR #11 이후 main 동기화 / 삭제된 원격 브랜치 추적 참조 정리 / Merge된 로컬 작업 브랜치 안전 삭제를 완료했다. 이번 종료 정리는 상태 문서와 완료 표시만 정리한다.
3. 다음 세션은 Phase 3 Backend 개발 기반 구축에서 시작한다. 프로젝트 생성 → PostgreSQL 실행 → 첫 Flyway Migration → JPA 연결·validation → Testcontainers 기반 테스트와 실제 DB 확인 순으로 진행한다. 현재는 미착수이며 첫 Migration과 실행 검증은 사용자가 직접 경험하도록 묶어서 안내한다.

Frontend 기술과 배포 대상은 DEVELOPMENT_PROCESS의 해당 단계에서 결정한다. 설계 합의 완료와 문서 main 반영 완료, 애플리케이션 구현·실행 검증 완료를 각각 구분한다.
