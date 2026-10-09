# simple-board

웹서비스 개발부터 협업, 배포, 운영, 기존 서비스 변경까지 전체 개발 Lifecycle을 경험하기 위한 프로젝트입니다.
아주 간단한 CRUD 게시판을 만들며 전체 개발 흐름을 경험하고, 이후 다른 프로젝트에 적용하는 것을 목표로 합니다.

## 현재 진행 상태

Repository와 협업환경 구성 및 실제 Workflow 검증을 완료했습니다.
Project Kickoff와 Phase 2의 MVP 요구사항 정의·초기 설계 및 종료 정리를 완료했고, 관련 문서는 main에 반영됐습니다. Phase 3 Backend 개발 기반 구축은 [Issue #14](https://github.com/yeochang-yoon/simple-board/issues/14)에서 진행 중입니다. IntelliJ에서 `backend` 프로젝트 생성과 Gradle 동기화를 완료했고 생성 파일 및 Git 제외 설정을 점검했습니다.
OrbStack의 PostgreSQL 18.6 컨테이너와 IntelliJ DB 접속·SQL 검증, Spring DB 연결·Flyway V1 적용 및 실제 Schema·이력 검증을 완료했습니다. BaseTimeEntity / Post 상속 매핑의 JPA validation과 별도 PostgreSQL Testcontainers 기반 테스트도 통과했습니다. Gradle Build와 실행 가능한 JAR 생성도 확인했습니다. 최종 검토에서 보완한 DB 연결 세션 UTC 설정도 테스트와 로컬 Spring 연결로 검증했습니다. 다음은 PR Review와 Merge입니다. 상세 진행 상태와 검증 결과는 [PROJECT_STATE.md](docs/PROJECT_STATE.md)에 기록합니다.
Java 21 / Spring Boot 4.1.1 / Gradle Groovy DSL·Wrapper / PostgreSQL 18 / Flyway / Spring Boot Test·JUnit·Testcontainers를 사용합니다. JPA / Migration / 실제 PostgreSQL 테스트부터 배포와 운영까지 기존 Lifecycle에 따라 진행합니다.
첫 MVP는 회원가입·로그인 없이 누구나 게시글을 작성·조회·수정·삭제하는 게시판입니다.
인증/인가, 작성자 구분 및 작성자별 수정·삭제 권한은 제외합니다. 입력 검증과 조회·삭제 등의 세부 규칙은 요구사항 문서에 확정했습니다.

## 프로젝트 문서

- [진행 원칙](AGENTS.md)
- [전체 개발 과정](docs/DEVELOPMENT_PROCESS.md)
- [현재 프로젝트 상태와 다음 작업](docs/PROJECT_STATE.md)
- [Kickoff 결과와 MVP 요구사항](docs/REQUIREMENTS.md)
- [초기 설계](docs/ARCHITECTURE.md)

## 실행 안내

Java 21과 실행 중인 Docker Runtime이 필요합니다. 현재 macOS 환경은 IntelliJ IDEA Ultimate / OrbStack을 사용합니다. Repository 루트를 IntelliJ에서 열고 `backend/build.gradle`을 Gradle 프로젝트로 연결합니다.

### 로컬 DB 준비

Repository 루트에서 `.env.example`을 `.env`로 복사하고 `POSTGRES_PASSWORD`에 로컬 개발용 비밀번호를 입력합니다. DB 이름과 사용자의 기본값은 `simple_board`입니다. `.env`는 Git에서 제외됩니다.

루트에서 다음 명령으로 DB를 시작하고 상태를 확인합니다.

```bash
docker compose up -d postgres
docker compose ps --all
```

DB는 `127.0.0.1:5432`로 접속하며 Named Volume에 데이터를 유지합니다. 작업을 마칠 때 `docker compose stop postgres`로 중지할 수 있습니다.

### IntelliJ에서 Backend 실행

Spring Boot 실행 구성에 다음 값을 지정하고 실행합니다.

- Main class: `io.github.yeochangyoon.simpleboard.BackendApplication`
- Module: Backend의 `main` 모듈
- Active profiles: `local`
- Environment variables의 `.env` 파일 경로: Repository 루트의 `.env`

애플리케이션은 기본 포트 `8080`에서 시작합니다. 공통 Hikari 설정은 새 DB 연결의 세션 시간대를 UTC로 지정합니다. Flyway가 `db/migration`의 SQL을 적용하고 Hibernate는 `ddl-auto=validate`로 Entity 매핑을 검증합니다. 이미 적용한 Migration 파일은 수정하지 않습니다. 현재 게시글 HTTP API는 구현 전입니다.

Compose의 `.env` 로딩과 IntelliJ 실행 구성의 환경변수 주입은 각각 설정합니다. `.env`를 만들기만 하면 Spring 실행에 자동으로 전달되는 것은 아닙니다.

### 테스트와 Build

`backend` 디렉터리에서 Gradle Wrapper를 사용합니다.

```bash
./gradlew test
./gradlew build
```

테스트는 Testcontainers가 별도의 `postgres:18.6-trixie`를 실행하므로 Docker Runtime이 필요합니다. Compose 개발 DB 실행이나 로컬 비밀번호는 필요하지 않습니다. 현재 기반 테스트는 빈 DB의 Flyway 적용과 JPA 컨텍스트 시작, SQL 조회를 통한 DB 세션 시간대 UTC를 확인합니다.

테스트 보고서는 `backend/build/reports/tests/test/index.html`, Build의 JAR 출력 경로는 `backend/build/libs/`입니다. 2026-10-09 테스트와 전체 `build`가 통과했고 `simple-board-0.0.1-SNAPSHOT.jar` 생성을 확인했습니다. 이 파일은 의존성을 포함한 Spring Boot 실행 JAR이며, 함께 생성되는 `-plain.jar`는 의존성을 포함하지 않는 일반 JAR입니다.
