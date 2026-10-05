# simple-board

웹서비스 개발부터 협업, 배포, 운영, 기존 서비스 변경까지 전체 개발 Lifecycle을 경험하기 위한 프로젝트입니다.
아주 간단한 CRUD 게시판을 만들며 전체 개발 흐름을 경험하고, 이후 다른 프로젝트에 적용하는 것을 목표로 합니다.

## 현재 진행 상태

Repository와 협업환경 구성 및 실제 Workflow 검증을 완료했습니다.
Project Kickoff와 MVP 요구사항 문서의 PR 반영 및 Git 정리까지 마쳤으며, 초기 설계도 전체 합의를 완료했습니다. 현재는 설계 문서를 PR로 반영하는 단계입니다.
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

애플리케이션 실행 방법은 Backend 개발 기반을 구축하고 실제 실행을 검증한 뒤 추가합니다.
