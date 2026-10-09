# simple-board

웹서비스 개발부터 협업, 배포, 운영, 기존 서비스 변경까지 전체 개발 Lifecycle을 경험하기 위한 프로젝트입니다.
아주 간단한 CRUD 게시판을 만들며 전체 개발 흐름을 경험하고, 이후 다른 프로젝트에 적용하는 것을 목표로 합니다.

## MVP 범위

첫 MVP는 회원가입·로그인 없이 누구나 게시글을 작성·조회·수정·삭제하는 게시판입니다.
인증/인가, 작성자 구분 및 작성자별 수정·삭제 권한은 제외합니다. 입력 검증과 조회·삭제 등의 세부 규칙은 요구사항 문서에 확정했습니다.

## Backend 기술 구성

Java 21 / Spring Boot 4.1.1 / Spring Data JPA / Bean Validation / Gradle Groovy DSL·Wrapper / PostgreSQL 18 / Flyway / JUnit·Testcontainers를 사용합니다.

## 프로젝트 문서

- [진행 원칙](AGENTS.md)
- [전체 개발 과정](docs/DEVELOPMENT_PROCESS.md)
- [현재 프로젝트 상태와 다음 작업](docs/PROJECT_STATE.md)
- [Kickoff 결과와 MVP 요구사항](docs/REQUIREMENTS.md)
- [초기 설계](docs/ARCHITECTURE.md)

## 실행 안내

Java 21과 실행 중인 Docker Runtime이 필요합니다. 아래는 macOS의 IntelliJ IDEA Ultimate / OrbStack을 사용하는 실행 방법입니다. Repository 루트를 IntelliJ에서 열고 `backend/build.gradle`을 Gradle 프로젝트로 연결합니다.

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

애플리케이션은 기본 포트 `8080`에서 시작합니다. DB 연결 세션의 시간대는 UTC입니다. 기동 시 Flyway가 Migration을 적용하고 Hibernate가 Entity 매핑을 검증합니다.

Compose의 `.env` 로딩과 IntelliJ 실행 구성의 환경변수 주입은 각각 설정합니다. `.env`를 만들기만 하면 Spring 실행에 자동으로 전달되는 것은 아닙니다.

### 테스트와 Build

`backend` 디렉터리에서 Gradle Wrapper를 사용합니다.

```bash
./gradlew test
./gradlew build
```

테스트는 Testcontainers가 별도의 PostgreSQL을 실행하므로 Docker Runtime이 필요합니다. Compose 개발 DB 실행이나 로컬 비밀번호는 필요하지 않습니다.

테스트 보고서는 `backend/build/reports/tests/test/index.html`, Build의 JAR 출력 경로는 `backend/build/libs/`입니다.
