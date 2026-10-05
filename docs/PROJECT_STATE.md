# Project State

최종 갱신: 2026-10-06 (Asia/Seoul)

## 현재 Lifecycle 위치

- Phase 2. 요구사항과 설계: 완료
- Phase 3. Backend 개발: 미착수. 첫 단계는 Backend 개발 기반 구축
- 개발환경 확인: 완료
- Repository / 협업환경 구성: 최종 정리까지 완료, 실제 Workflow와 Template 적용 검증 완료
- Project Kickoff: 범위 합의 완료
- MVP 요구사항: 세부 규칙과 검증 시나리오 합의 완료 (2026-10-05)
- Kickoff / 요구사항 문서 반영: [PR #9](https://github.com/yeochang-yoon/simple-board/pull/9) merged, [Issue #8](https://github.com/yeochang-yoon/simple-board/issues/8) completed
- 초기 설계: 전체 합의 완료 (2026-10-05). 저장 구조 / 시간 처리 / 정렬·Index / Transaction·실패 처리 / Migration·검증까지 수용
- 초기 설계 문서 반영: [PR #11](https://github.com/yeochang-yoon/simple-board/pull/11) merged, [Issue #10](https://github.com/yeochang-yoon/simple-board/issues/10) closed / completed, 완료 조건 네 항목 체크
- 이번 종료 정리 범위: [Issue #12](https://github.com/yeochang-yoon/simple-board/issues/12)의 상태 문서 정리만 수행. Phase 3 개발 작업은 시작하지 않음
- 다음 재개 위치: Phase 3 Backend 개발 기반 구축. 프로젝트 생성 → PostgreSQL 실행 → 첫 Flyway Migration → JPA 연결·검증 → Testcontainers 기반 테스트
- 서비스 주제: 아주 간단한 CRUD 게시판 (2026-10-05 사용자 명시 선택)
- 프로젝트 목적: 간단한 기능으로 웹서비스 개발 전체 Lifecycle을 경험한 뒤, 사용자가 원하는 후속 프로젝트에 적용한다.
- 주요 사용자: 게시판에 접근하는 누구나. 회원가입 / 로그인 없이 모든 게시글의 작성·목록 및 상세 조회·수정·삭제가 가능하다.
- 첫 MVP에서 회원가입, 로그인, 인증/인가, 작성자 구분과 작성자별 수정·삭제 권한을 제외한다.
- 애플리케이션 개발은 아직 시작하지 않았다. 입력 제한, 목록 순서, 삭제 방식 등은 [REQUIREMENTS.md](REQUIREMENTS.md)에 확정했다.

Repository / 협업환경 구성의 완료 조건은 첫 기능을 Issue → Branch → PR → Review → Merge 흐름으로 개발할 기반이 준비되는 것이다. 아래의 실제 결과와 최종 정리 종료 조건 재확인으로 이를 충족했다. 아래 Repository 준비 단계의 최종 정리 절차는 완료 이력이며, 현재는 Phase 2를 완료하고 Phase 3 재개를 앞둔 상태다.

## 재개 시 최종 정리 검증 결과 (2026-10-05)

- [PR #7](https://github.com/yeochang-yoon/simple-board/pull/7): merged, AGENTS / README / PROJECT_STATE 반영. Merge Commit `a7c694f2f445c021cca6cb6b259e873a540f1f3b`.
- [Issue #6](https://github.com/yeochang-yoon/simple-board/issues/6): closed / completed, 완료 조건 네 항목 모두 체크.
- Kickoff 문서 수정 전 local main / origin/main / GitHub main은 위 Merge Commit으로 일치했고, ahead / behind는 `0 0`, 미커밋 / 미추적 파일은 없었다.
- 로컬 / 원격 작업 브랜치는 main만 있었고, 삭제된 원격 작업 브랜치의 추적 참조와 열린 Issue / PR도 없었다.
- GitHub 읽기 조회로 Public / 기본 main / Merge commit만 허용 / 원격 브랜치 자동 삭제 / License 보류와 활성 main-protection의 PR 필수 / 승인 0명 / Force Push 및 삭제 차단 / bypass 없음을 재확인했다. gh 인증도 정상으로 확인했다.
- 최종 정리 종료 조건을 모두 충족하여 Project Kickoff를 시작했다. 이 검증을 기록하기 위한 별도 정리 PR을 반복하지 않고 Kickoff의 결정 기록과 함께 문서를 반영한다.

## 단계 완료 근거

| 항목 | 확인 결과 |
|---|---|
| Repository | Public `yeochang-yoon/simple-board`, 기본 브랜치 `main`, HTTPS origin 연결 |
| 기본 파일 | `.gitignore`의 `.DS_Store` 제외, README 목적 / 상태 / 문서 링크 |
| Issue → Branch → PR | Issue #1의 PR #2, Issue #3의 PR #4 / #5로 실제 수행 |
| Review | 사용자 Diff 확인과 README 링크 클릭, PR #4 세 파일 Viewed / 수정사항 없음 확인 |
| Merge | PR #2 / #4 / #5가 Merge commit 방식으로 반영됨 |
| 브랜치 정리 | 첫 원격 / 로컬 수동 정리 실습 완료, 이후 원격 자동 삭제 실제 확인 / 로컬 안전 삭제 |
| Template | PR / Issue Template이 main에 반영됐고 사용자가 새 작성 화면에서 본문 자동 입력 확인 |
| 보호 규칙 | 활성 main-protection: PR 필수, 승인 0명, Force Push / 삭제 차단, 우회 대상 없음 |
| 미룬 구성 | License는 의도적으로 보류, Build / Test / CI는 애플리케이션 개발 단계에서 구성 |

검증 근거는 Repository / GitHub의 실제 결과와 사용자 실습 기록이다. 애플리케이션이나 CI가 아직 없으므로 이 단계 완료를 Build / Test / CI 통과로 표현하지 않는다.

## 완료한 Issue / PR

- [Issue #1](https://github.com/yeochang-yoon/simple-board/issues/1): README와 Repository 준비 상태 정리. `closed` / `completed`.
- [PR #2](https://github.com/yeochang-yoon/simple-board/pull/2): AGENTS / README / 상태 문서 반영. 사용자가 세 파일과 README의 세 링크를 확인하고 Comment Review 후 Merge. Merge Commit `e489155`.
- 첫 브랜치 `docs/repository-setup`: Merge 후 원격 / 로컬에 각각 남음을 사용자가 관찰하고 직접 정리했다.
- [Issue #3](https://github.com/yeochang-yoon/simple-board/issues/3): PR / Issue Template 추가. 네 완료 조건이 체크됐으며 `closed` / `completed`.
- [PR #4](https://github.com/yeochang-yoon/simple-board/pull/4): 두 Template과 상태 문서 반영. 사용자가 세 파일을 Viewed 처리하고 수정사항 없음 확인. 별도 GitHub Review comment는 제출하지 않았다. Merge Commit `65f03e4`.
- PR #4 이후 원격 브랜치 `docs/3-collaboration-templates` 자동 삭제를 사용자 확인과 API 조회로 검증했다. 로컬 main 동기화와 작업 브랜치 안전 삭제도 완료했다.
- 화면 검증: 새 Issue의 `공통 작업`을 선택하면 목적 / 작업 범위 / 완료 조건, 새 PR 작성 화면에는 배경 / 변경 / 검증 / 관련 Issue가 자동 입력됨을 사용자가 직접 확인했다. 검증용 Issue나 PR은 생성하지 않았다.
- [PR #5](https://github.com/yeochang-yoon/simple-board/pull/5): 검증 결과 기록. Merge Commit `af1604f`, `Closes #3`로 Issue #3 종료. 이후 main 동기화와 원격 추적 참조 / 로컬 작업 브랜치 정리 완료.
- 위 세 PR의 Merge 및 두 Issue의 종료를 2026-10-05 최종 GitHub 읽기 조회에서 재확인했다. Issue #1의 옛 체크박스 표시와 별개로 Review / 링크 / Merge 완료 근거는 위 기록으로 확인된다.

## 이번 최종 점검의 시작 상태 (2026-10-05)

이 항목은 최종 정리를 시작할 때의 관찰 기록이다. 새 세션에서 최신 HEAD나 미커밋 상태를 이 값으로 고정하지 않고 실제 Git / GitHub를 다시 조회한다.

- 로컬 main / origin/main / GitHub main: 모두 `af1604f32c38abd710ca4a5f62a9495c995ad405`.
- `git rev-list --left-right --count main...origin/main`: `0 0`, 미Push Commit 없음.
- 로컬 / 원격에 작업 브랜치 없음. `origin/HEAD`는 origin/main을 가리키는 기본 브랜치 참조다.
- 열린 Issue / PR 없음. 완료한 Issue #1 / #3는 closed, PR #2 / #4 / #5는 merged.
- 미커밋 변경: `AGENTS.md`와 이 상태 문서. 반복 작업 자동 처리 후 먼저 결과를 보고하는 원칙 및 PR #5 이후 결과 기록이다.
- 추가로 README의 “Repository / 협업환경 구성 중” 문구도 현재 완료 판단과 맞추어 갱신한다.
- GitHub 설정 재확인: Merge commit만 허용, `delete_branch_on_merge: true`, `license: null`.
- Ruleset `main-protection` (ID `24418157`): active, `refs/heads/main`만 보호, 제외 / bypass 없음, PR 필수 / 승인 0명 / deletion / non_fast_forward 차단.

## Issue #6 최종 정리 작업과 세션 종료 조건 (완료 이력)

사용자는 다음 Lifecycle로 미커밋 문서 변경을 넘기지 않고 이번 단계에서 반영 / 정리하기로 했다. 이번 작업에서는 Codex가 문서 준비와 읽기 점검을 수행하고, 사용자에게 필요한 Git 명령과 GitHub 웹 UI 절차를 한 단계씩 안내한다. Commit / Push / PR / Review / Merge / 동기화 / 브랜치 정리를 대신 실행하지 않는다.

- 최종 정리 범위: AGENTS의 자동 처리 보고 원칙, README 완료 상태, 이 문서의 완료 근거 / 운영 결정 / 다음 재개 위치.
- 최종 정리 Issue: [#6 Repository 준비 단계 최종 정리 및 세션 인계](https://github.com/yeochang-yoon/simple-board/issues/6). 사용자가 등록했고 API로 open / documentation Label / 네 완료 조건을 확인했다. 사용자가 `main`의 `af1604f`에서 작업 브랜치 `docs/6-repository-handoff`를 생성하고 세 문서의 변경을 유지한 것을 실제 Git에서도 확인했다. 이후 Commit / Push / PR / Merge 진행 단계는 실제 Git / GitHub에서 확인한다.
- 최종 정리 Issue → 작업 브랜치 → Commit / Push → PR / Review / Merge로 main에 반영한다.
- Merge 후 원격 작업 브랜치 자동 삭제를 확인하고, main을 동기화한 뒤 Merge 포함 여부를 확인하여 로컬 작업 브랜치를 안전 삭제한다.
- Issue의 종료 시점은 해당 Issue에 기재한 완료 조건을 기준으로 정한다. Merge 후 검증까지 범위에 포함하면 검증 완료 후 종료한다.
- 마지막 확인을 위해 Git / GitHub 상태를 다시 읽으며, 동일한 검증을 기록하기 위해 문서 Commit / PR을 계속 만들지 않는다.

아래를 모두 실제 상태로 확인한 경우, 이번 단계의 최종 정리와 세션 종료 준비가 완료된 것이다.

1. 최종 정리 PR이 merged이고 세 문서가 GitHub main에 반영됐다.
2. 최종 정리 Issue를 포함해 이 단계에 남은 열린 Issue / PR이 없다.
3. `git status --short --branch`에 변경 / 미추적 파일 / ahead / behind가 없다.
4. 현재 브랜치는 main이며 main / origin/main / GitHub main의 Commit SHA가 일치한다.
5. 불필요한 로컬 / 원격 작업 브랜치와 삭제된 원격의 추적 참조가 없다.
6. 새 세션이 AGENTS / 전체 DEVELOPMENT_PROCESS / 이 문서 / README와 실제 GitHub를 읽어 완료 상태 및 다음 작업을 복구할 수 있다.

최종 정리 PR의 번호 / SHA와 이후 Merge Commit은 Issue #6와 해당 브랜치의 실제 Git / GitHub에서 확인한다. 새 세션에서 Issue #6가 완료 종료되고 위 조건을 충족하면 다음 작업은 Project Kickoff다. 조건이 미충족이면 남은 최종 정리부터 이어가며, 이미 완료한 Template 검증이나 첫 브랜치 정리 실습을 반복하지 않는다.

## 확정한 Repository 운영 방식

- 저장소: Public `yeochang-yoon/simple-board`, 기본 main. [.github/pull_request_template.md](../.github/pull_request_template.md), [.github/ISSUE_TEMPLATE/task.md](../.github/ISSUE_TEMPLATE/task.md)를 사용한다.
- Branch 전략: main + 작업별 짧은 브랜치. 목적과 완료 조건은 Issue, 구현 / 검증 / Review는 PR로 다룬다.
- Branch convention: `<종류>/<Issue 번호>-<짧은 설명>`. 종류 docs / feature / fix / chore, 설명은 영문 소문자와 하이픈. 첫 `docs/repository-setup`은 기존 예외였고 이미 삭제됐다. 별도 이름 제한 / CI / Hook은 도입하지 않았다.
- Commit convention: `<type>: <짧은 요약>`, feat / fix / docs / chore / test / refactor. 한글 요약 허용, 필요한 설명은 빈 줄 뒤 본문에 기록. 관련 변경 단위로 나누며 한 Issue에 여러 Commit이 가능하다.
- Issue 연결은 PR 본문에 작성한다. 완료시키면 `Closes #번호`, 일부 작업이나 Merge 후 검증이 남으면 `Refs #번호`로 참조한다.
- Commit 형식 / 변경 단위는 PR Review에서 확인한다. scope / Issue 번호를 Commit 제목에 강제하지 않으며 기존 초기 / Merge Commit 메시지는 유지한다.
- Merge는 Merge commit만 사용한다. 필수 승인 0명이어도 검토는 수행하고 실제 확인 결과를 공유한다. Viewed를 GitHub Approve로 취급하지 않는다.
- 자동 삭제는 원격 작업 브랜치에 적용된다. 로컬 브랜치 삭제와 `fetch --prune`은 별도 정리다.
- Label은 documentation / enhancement / bug 중심, 나머지 기존 Label 유지. 추가 우선순위 / 진행 상태 Label은 없다.
- License 보류: 학습 프로젝트 공개와 Lifecycle 경험이 현재 목적이며 재사용 / 수정 / 배포를 적극 허용할 필요가 생기면 MIT 등을 다시 검토한다. LICENSE 파일을 형식적으로 추가하지 않는다.
- Secret은 Git에 저장하지 않는다. 실제 Secret 설정이 생기면 제외 / 주입 방식을 결정한다.
- CI는 Backend Build / Test와 첫 기능이 준비되는 Phase 3에서 구성한다. main 보호에 필수 CI나 linear history를 아직 요구하지 않는다.

## 사용자와 함께 진행하는 원칙

- 처음 경험하는 코드 / 도구 / 절차 / 검증의 핵심은 사용자가 직접 수행한다. 이미 경험한 반복 작업은 Codex가 처리할 수 있다.
- Codex가 반복 작업을 대신 처리하면 다음 행동을 요청하기 전에 처리 내용과 실제 결과를 짧게 보고한다. 처리 완료 보고 → 필요한 설명 → 다음 작업 안내 순서다.
- GitHub 협업 실습은 현업의 일반적인 방식과 학습 가치를 기준으로 웹 UI / gh CLI를 선택한다. 직접 실습을 무조건 터미널로 안내하지 않는다.
- Issue #6의 최종 정리는 당시 사용자의 요청에 따라 Commit / Push 등도 사용자가 직접 수행했다. 완료된 해당 작업의 절차이며, 이후 작업은 위 일반적인 반복 작업 위임 원칙을 적용한다. 현재 사용자는 관련 명령과 절차를 묶어 안내하고 중요한 판단과 검증을 함께 확인하기를 요청했다.

## 확인한 개발환경

기존에 사용자가 직접 실행하고 공유한 결과를 유지한다. 이번 최종 문서 점검에서 환경을 다시 설치하거나 Docker 실습을 재실행하지 않았다.

- macOS 27.0.1 (Build 26A434), arm64
- Git 2.56.0
- Temurin OpenJDK / javac 21.0.11, LTS, build 21.0.11+10-LTS
- IntelliJ IDEA Ultimate 2026.2.3 (사용자 정보, 애플리케이션 실행 아직 미검증)
- gh 2.102.0, yeochang-yoon 계정 active, Git HTTPS 인증과 실제 Push 확인
- Docker Client / Server 29.4.0, OrbStack / orbstack Context, Server linux/arm64
- `docker run --rm hello-world` 성공과 Hello from Docker 출력 확인. 초기 소켓 오류는 OrbStack 시작 후 해소됨
- Docker Compose v5.1.2
- SSH OpenSSH_10.3p1 / LibreSSL 3.3.6. GitHub는 HTTPS이므로 SSH 인증 설정은 불필요

## 완료한 Project Kickoff / 요구사항과 초기 설계

2026-10-05 사용자가 첫 MVP의 회원·권한 제외 정책까지 명시하여 Kickoff 범위를 합의한 뒤 세부 요구사항 초안을 그대로 채택했다. 사용자 Review 후 PR #9를 Merge하고 Issue #8을 종료했다. Git / GitHub로 실제 반영을 확인하고 초기 설계를 시작했다.

- 확정: 아주 간단한 CRUD 게시판. 폴더 이름이나 이전 대화의 추정이 아니라 사용자의 이번 선택을 근거로 한다.
- 확정: 기능 복잡도를 낮추고 개발 / 협업 / 검증 / 배포 / 운영 / 기존 서비스 변경 전체 경험에 집중한다. Frontend와 전체 서비스 통합도 기존 Lifecycle에 포함한다.
- 확정: 누구나 회원가입 / 로그인 없이 게시글을 작성·조회·수정·삭제한다. 작성자 구분과 작성자별 권한은 없다.
- 확정: 핵심 흐름은 작성 → 목록·상세 확인 → 수정 → 삭제이며, CRUD 외 댓글 / 좋아요 / 첨부파일 / 검색은 첫 MVP 범위에 넣지 않는다.
- [REQUIREMENTS.md](REQUIREMENTS.md)에 제목·본문 검증, 표시 정보, 목록 순서와 페이지 나누기 제외, 삭제·실패 동작, 데이터 보존 및 검증 시나리오를 확정했다.
- 사용자 방향 재확인: 단순 CRUD 범위를 유지하면서 전체 Lifecycle을 경험한다. 기존 REQUIREMENTS와 DEVELOPMENT_PROCESS가 실제 RDBMS / JPA / Migration / Test / CI / HTTP 및 DB 검증 / Container / 배포 / Health·Logging·운영 / Frontend 통합 / 기존 데이터 보존과 변경·재배포를 이미 다루므로 별도 기능 범위를 추가하거나 개발 과정 문서를 변경하지 않는다.
- Backend 기술 구성은 아래 사용자 결정으로 확정했다. Frontend 기술과 배포 대상은 해당 Lifecycle 단계에서 정한다.
- 문서 작업 완료: [PR #9](https://github.com/yeochang-yoon/simple-board/pull/9) merged, [Issue #8](https://github.com/yeochang-yoon/simple-board/issues/8) closed / completed, 완료 조건 네 항목 체크 확인. Commit `22282b4`가 main에 포함되었고 Merge Commit은 `6755fe7a9c6ce74b7e89206e1d85299ebf99964c`다.
- Merge 후 main을 fast-forward 동기화하고 삭제된 원격 작업 브랜치 추적 참조를 prune했다. Commit 포함을 확인한 후 로컬 `docs/8-kickoff-requirements`를 안전 삭제했다. 초기 설계 문서 편집 직전 main / origin/main이 위 Merge Commit으로 일치했고 미커밋 변경은 없었다.
- 2026-10-05 사용자 검토로 [ARCHITECTURE.md](ARCHITECTURE.md)의 Post Entity와 다섯 정보 / 서버에서 관리할 식별자와 시각 / Controller·Service·Repository·Migration 책임 분리 구조를 합의했다. 아래 전체 설계 수용으로 구체적인 DB 타입과 생성 전략도 확정했다.
- 2026-10-05 사용자 검토로 HTTP API 계약의 경로·Method·상태 코드·JSON 요청 / 응답·오류 형식도 합의했다. 실제 HTTP 호출 검증은 Backend 구현 후 수행한다.
- 2026-10-05 사용자가 기술 구성 표 전체를 수용했다. Java 21 / Spring Boot 4.1.1 + MVC + Spring Data JPA / Gradle Groovy DSL + Wrapper / PostgreSQL 18 / Flyway / Spring Boot Test·JUnit + Testcontainers를 확정했다. 입력 검증은 기존 제안대로 Bean Validation을 포함한다. Wrapper / DB 이미지의 정확한 버전 등은 기반 구축 시 파일에 고정하고 실제 실행으로 확인한다.
- 2026-10-05 사용자 선택으로 DB 제품을 PostgreSQL로 확정했다. 이후 여러 Java / Spring Backend 프로젝트에서도 기본 RDBMS로 계속 사용하며 깊게 익히기 위한 결정이다. JPA / Flyway Migration / PostgreSQL Testcontainers 기반 테스트 / Transaction / Index / 실제 DB 검증 / Container / 배포·운영 방향을 유지하며, 고급 기능을 위해 게시판 범위를 늘리지 않는다.
- 2026-10-05 사용자가 저장 구조 / 시간 처리 / 목록 정렬과 Index / Transaction 및 실패 처리 / Migration과 테스트·검증 초안 전체를 수용했다. posts의 Identity PK / varchar 입력 컬럼 / Instant·timestamptz(6) / 애플리케이션 Clock / created_at DESC·id DESC / PK Index부터 시작 / Service Transaction·READ COMMITTED / Flyway·JPA validation / PostgreSQL 테스트 및 실제 HTTP·DB 검증을 구현 기준으로 확정했다.
- 별도 Version / 명시적 Lock 없이 시작해 동시 수정 시 마지막 UPDATE가 앞선 값을 덮어쓸 수 있다는 한계를 사용자가 현재 MVP의 의도적인 범위로 수용했다. 보호가 필요해지면 별도 요구사항 변경으로 처리한다.
- 현재 JDK / javac 21.0.11 실행 결과와 공식 기술 문서의 지원 조건을 확인했다. 실제 애플리케이션 Build / DB 연결 / Migration / Testcontainers는 아직 실행하지 않았다. 설계 수용을 실제 실행 검증으로 취급하지 않는다.
- 초기 설계 문서 반영 완료: [PR #11](https://github.com/yeochang-yoon/simple-board/pull/11) merged, Merge Commit `19996fd3fc2c4ec04cf68d7b71c9f6d2c76afedd`. [Issue #10](https://github.com/yeochang-yoon/simple-board/issues/10)은 closed / completed이며, 종료 정리에서 마지막 Merge 조건까지 체크하여 네 항목 모두 완료 표시를 확인했다.
- PR #11 이후 main을 fast-forward 동기화하고 삭제된 원격 `docs/10-initial-architecture`의 추적 참조를 prune했다. 작업 Commit `8b6303a`가 main에 포함된 것을 확인한 후 로컬 작업 브랜치를 안전 삭제했다.

## 종료 점검과 다음 세션 재개 (2026-10-06)

- Kickoff / MVP 요구사항 / HTTP API 계약 / Backend 기술 선택 / PostgreSQL 선택 이유 / 저장 구조 / 시간 처리 / 정렬·Index / Transaction / Migration / Testcontainers·검증 계획이 관련 문서에 반영됐다. 요구사항 정의와 첫 기능을 시작할 최소 설계는 완료됐다.
- 종료 정리 Issue #12를 시작하기 전 local main / origin/main / GitHub main이 PR #11의 Merge Commit `19996fd`로 일치했고, ahead / behind는 `0 0`, 미커밋 / 미추적 파일과 남은 작업 브랜치, 열린 Issue / PR은 없었다. 이는 정리 시작 전의 확인값이며 최신 HEAD나 열린 작업 상태로 고정하지 않는다.
- 사용자는 종료 상태 정리만 별도 Issue / Branch / Commit / Push / PR로 진행하도록 승인했다. Issue #12와 연결된 종료 정리 PR의 최종 상태는 다음 재개 시 실제 GitHub에서 확인한다. PR Merge는 사용자가 직접 검토하고 진행한다.
- 다음 세션은 AGENTS / 전체 DEVELOPMENT_PROCESS / 이 문서 / REQUIREMENTS / ARCHITECTURE / README와 실제 Git / GitHub 상태를 읽어 복구한다. 종료 정리 PR이 미Merge라면 해당 정리를 먼저 마무리하고, Merge됐다면 main 동기화와 안전한 브랜치 정리 후 Phase 3 Backend 개발 기반 구축을 시작한다. Merge 결과를 기록하기 위한 추가 정리 PR을 반복하지 않는다.
- Phase 3 첫 작업은 기반 구축의 범위와 Issue / 작업 브랜치를 준비하고 Java 21 / Spring Boot 4.1.1 / Gradle Groovy DSL·Wrapper 프로젝트를 생성하는 것이다. 이후 PostgreSQL 실행 → 첫 Flyway Migration → JPA 연결·validation → Testcontainers 기반 테스트와 실제 DB 확인으로 이어간다. 환경별 설정과 Secret 분리, Build / Test / 실행 안내는 DEVELOPMENT_PROCESS의 기반 구축 범위 안에서 함께 구성한다.
- 현재 애플리케이션 코드 / Build 설정 / Compose / Migration SQL / 테스트 코드는 없다. 프로젝트 생성, PostgreSQL 실행, Migration 적용, JPA 연결, Testcontainers 테스트 등 Phase 3 작업은 이번 종료 정리에서 수행하지 않았다.
