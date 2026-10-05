# Project State

최종 갱신: 2026-10-05 (Asia/Seoul)

## 현재 Lifecycle 위치

- Phase 1. 프로젝트 기반 준비
- 개발환경 확인: 완료
- Repository / 협업환경 구성: 완료 조건 충족, 실제 Workflow와 Template 적용 검증 완료
- 현재 작업: Issue #6의 최종 문서 반영 및 Git / GitHub 정리 (아래 종료 조건 충족 후 종료)
- 다음 Lifecycle 작업: Phase 1의 Project Kickoff (아직 시작하지 않음)
- 서비스 주제 / 사용자 / MVP 범위는 미정이며 애플리케이션 개발도 시작하지 않았다.

Repository / 협업환경 구성의 완료 조건은 첫 기능을 Issue → Branch → PR → Review → Merge 흐름으로 개발할 기반이 준비되는 것이다. 아래의 실제 결과로 이를 충족했다. 다만 이번 최종 문서 정리와 아래 종료 조건 확인을 마치기 전에는 Project Kickoff를 시작하거나 세션 종료 준비가 완료됐다고 판단하지 않는다.

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

## 최종 정리 작업과 세션 종료 조건

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
- 사용자의 이번 최종 정리 요청은 위 일반적인 반복 작업 위임보다 우선한다. 사용자가 직접 실행할 단계는 한 번에 하나씩 안내하고 결과를 확인한다.

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

## 다음 Lifecycle: Project Kickoff

Phase 1의 마지막 작업이며 아직 시작하지 않았다. 전체 Phase 1이 끝난 것으로 표현하거나 Phase 2 요구사항 정의 / 애플리케이션 구현으로 건너뛰지 않는다.

- 먼저 정할 것: 서비스가 해결할 문제, 주요 사용자, 핵심 사용 시나리오, 기본 성격, 첫 MVP 범위, 제외 범위, 이번에 경험할 개발 주제.
- 폴더 이름만으로 게시판 서비스를 확정하지 않는다.
- 서비스 주제 / MVP, JDK / Spring 버전, 빌드 도구, DB, Frontend 기술, 배포 대상은 아직 결정하지 않았다. 설치된 JDK와 프로젝트 기술 선택은 구분한다.
- 최종 정리 종료 조건이 충족되면 Codex가 Kickoff를 리드하고 사용자가 주요 판단에 참여한다.
