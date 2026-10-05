# Project State

최종 갱신: 2026-10-05 (Asia/Seoul)

## 현재 Lifecycle 위치

- Phase 1. 프로젝트 기반 준비
- 개발환경 확인: 완료 (Repository 구성에 필요한 기본 도구 사용 가능, Docker 컨테이너 실행 검증 성공)
- 현재 작업: Repository / 협업환경 구성 (진행 중)
- 이 단계의 완료 조건: 첫 기능을 Issue → Branch → PR → Review → Merge 흐름으로 개발할 수 있는 기반 준비
- 필요한 Repository 운영 판단은 완료했다. Issue #1의 첫 수동 브랜치 정리와 자동 삭제 설정 전환을 마쳤으며, Issue #3의 PR #4 Merge와 원격 작업 브랜치 자동 삭제 동작도 확인했다. 현재 세부 작업은 GitHub 새 Issue / PR 작성 화면에서 Template 적용 검증이다. 화면 검증과 결과 기록 반영이 남아 있으므로 단계 전체를 완료 처리하지 않는다.
- Project Kickoff와 애플리케이션 개발은 아직 시작하지 않았다.

## 최근 상태 복구 확인 (2026-10-05)

- 이전 대화 기억 대신 `AGENTS.md`, 전체 `docs/DEVELOPMENT_PROCESS.md`, 이 문서, README 및 실제 로컬 / GitHub 상태를 읽어 현재 위치를 복구했다.
- 최초 상태 복구 시 모든 브랜치는 `345fd46`을 가리켰고 원격에는 `main`만 있었다. 이후 PR #2와 PR #4를 Merge했다. 현재 로컬 `main`, `origin/main`, GitHub `main`은 PR #4 Merge Commit `65f03e4`로 일치한다. 두 기존 작업 브랜치는 원격 / 로컬에서 삭제됐으며 원격 추적 참조도 정리됐다. 현재 작업 브랜치는 같은 Commit에서 생성한 후속 기록용 `docs/3-template-verification`이다.
- 최초 복구 시 미커밋 변경은 `AGENTS.md`와 `docs/PROJECT_STATE.md` 수정, `README.md` 미추적이었다. 이후 사용자가 세 파일을 Staging했으며, 아래에 실행 결과를 기록했다. 애플리케이션 / 빌드 설정은 없으며, 현재 Issue #3에서 두 Template 초안을 추가했다.
- 최초 상태 복구 시 Issue #1은 열린 상태이며 Label이 없고 완료 조건 체크박스도 모두 미완료였다. 이후 사용자가 웹 UI에서 `documentation`을 적용하고 새로고침 후 유지됨을 확인했다. GitHub API 읽기 조회에서도 Issue #1의 `open` 상태와 `documentation` Label을 확인했다.
- GitHub API 읽기 조회로 Public / 기본 브랜치 `main`, Merge commit만 허용, 활성 `main-protection`의 PR 필수 / 승인 0명 / Force Push 및 삭제 차단 / 우회 대상 없음을 재확인했다. Merge 후 브랜치 자동 삭제는 최초 조회에서는 꺼져 있었으나 수동 정리 실습 후 사용자가 웹 UI에서 켰고, API로 `delete_branch_on_merge: true`를 확인했다.
- 개발환경 완료 판단은 아래에 남긴 기존 사용자 검증 기록을 근거로 유지한다. 이번에는 Docker 실행 등 개발환경 실습을 다시 수행하지 않았다.
- Label 첫 적용 실습과 브랜치 이름 / Commit convention / 브랜치 정리 운영 방식 / License 보류 결정을 완료했다. Issue #1의 문서 검토 / Commit / Push / PR / Review / Merge 및 첫 수동 브랜치 정리를 완료했다. Codex는 Label이나 원격 설정을 변경하지 않았다.

## 확인된 Repository 상태

- `AGENTS.md`와 `docs/DEVELOPMENT_PROCESS.md`를 읽고 진행 원칙을 확인했다.
- 최초 조사 시 위 두 문서와 `.DS_Store`만 존재했다.
- 애플리케이션 코드와 빌드 설정은 아직 없다.
- README에 프로젝트 목적과 진행 문서 링크를 담았으며 문서 Commit `d95c271`에 포함해 Push했다. 제목 `simple-board`는 사용자와 확정한 GitHub 저장소 이름과 일치한다.
- 사용자가 `.gitignore`를 생성하고 `.DS_Store` 제외 규칙을 저장했다. `git check-ignore -v .DS_Store`로 규칙 적용을 확인했다.
- 사용자가 `git init -b main`으로 로컬 Git 저장소를 초기화했다.
- 사용자가 첫 Commit `345fd46` (`Initialize project documentation`)을 생성했다. `.gitignore`, `AGENTS.md`, `docs/DEVELOPMENT_PROCESS.md`, `docs/PROJECT_STATE.md` 네 파일이 포함됐다.
- 첫 Commit 직후 `git status --short --branch`에서 `## main`만 출력되어 작업 폴더가 깨끗한 것을 사용자 출력과 실제 Repository에서 확인했다.
- 사용자가 작업 브랜치 `docs/repository-setup`을 생성했다. 생성 당시 `main`과 같은 첫 Commit `345fd46`을 가리키는 것을 확인했다. PR #2 Merge 후 수동 정리 실습에서 해당 브랜치를 삭제했다. Issue #3의 첫 작업 브랜치도 PR #4 Merge 후 삭제했으며, 현재 체크아웃은 후속 기록용 `docs/3-template-verification`이다.
- 브랜치 생성 당시 README 초안과 상태 문서의 미커밋 변경이 유지됨을 확인했으며, 이후 해당 변경을 Commit / Push했다.
- 2026-10-05 Commit 전 상태 점검: 로컬 `main`, `origin/main`, 현재 `docs/repository-setup`의 HEAD는 모두 `345fd46`이다. 사용자가 세 파일을 Staging한 직후 `git status --short`에서 `M  AGENTS.md`, `A  README.md`, `M  docs/PROJECT_STATE.md`를 확인했다. 이 시점에 Staging 밖의 변경은 없었다.
- 사용자 Commit / Push 완료: `d95c271` (`docs: README 추가 및 협업 준비 상태 정리`), 세 파일 변경 (99줄 추가 / 14줄 삭제, README 생성). 사용자가 상태 문서를 재Staging하고 Commit / 로그 / 작업 폴더를 확인한 뒤 `git push -u origin docs/repository-setup`을 실행했다. 사용자 출력과 실제 Git / GitHub 조회에서 작업 브랜치 Push, upstream 설정 및 깨끗한 작업 폴더를 확인했다. PR에서 실제 진행 상태를 읽을 수 있도록 이 완료 기록을 후속 문서 Commit으로 같은 작업 브랜치에 반영한다. 최신 HEAD는 실제 Git 조회를 기준으로 확인한다.
- Commit 작성자 이름과 이메일이 기존 Git 설정에 존재함을 확인했다. 작성자 이름은 `yeochang-yoon`이다.
- 사용자가 GitHub Public 저장소 `yeochang-yoon/simple-board`를 생성했다. URL: https://github.com/yeochang-yoon/simple-board
- `origin`은 `https://github.com/yeochang-yoon/simple-board.git`으로 연결됐다. 실제 `git remote -v`로 확인했다.
- 사용자가 `git push -u origin main`에 성공했다. 로컬 `main`이 `origin/main`을 추적하며 두 참조가 첫 Commit `345fd46`을 가리키는 것을 실제 `git branch -vv`로 확인했다.
- GitHub 조회 결과는 사용자 출력으로 확인했다: `visibility`는 `PUBLIC`, `defaultBranchRef.name`은 `main`이다.
- 사용자가 문서 정리 작업을 Issue #1로 등록했다: https://github.com/yeochang-yoon/simple-board/issues/1
- 2026-10-05 사용자가 GitHub 웹 UI에서 PR #2를 생성하고 Review / Merge했다: https://github.com/yeochang-yoon/simple-board/pull/2 . Merge Commit은 `e489155`이며 본문의 `Closes #1`로 Issue #1이 `closed` / `completed`로 종료됐다. `documentation` Label은 유지된다.
- 이번 조사 결과를 유지하기 위해 이 상태 문서를 생성했다.

## 확인된 개발환경

- 근거: 사용자가 직접 실행한 명령의 출력과 IDE 정보를 공유했다.
- OS: macOS 27.0.1, BuildVersion 26A434
- CPU 아키텍처: arm64
- Git: 2.56.0 (`git --version` 실행 확인)
- Java 런타임: Temurin OpenJDK 21.0.11 LTS, build 21.0.11+10-LTS
- Java 컴파일러: javac 21.0.11 (런타임과 버전 일치)
- IDE: IntelliJ IDEA Ultimate 2026.2.3 (사용자 제공 정보, 프로젝트 실행은 아직 미검증)
- GitHub CLI: 2.102.0
- GitHub 인증: `gh auth status`에서 `yeochang-yoon` 계정 로그인 및 Active account 확인. Git 연결 방식은 HTTPS다. 최초 `main` Push 성공으로 원격 Git 작업도 확인했다.
- Docker Client: 29.4.0, Context `orbstack`
- Docker Runtime: OrbStack. 앱 시작 후 `docker version`에서 Server 연결 성공을 확인했다.
- Docker Server: Docker Engine - Community 29.4.0, linux/arm64
- Docker 실행 검증: 사용자가 `docker run --rm hello-world` 실행. Docker Hub 이미지 다운로드 및 `Hello from Docker!` 출력 성공.
- 초기 Docker 소켓 오류는 OrbStack 앱 시작 후 해소됐다.
- Docker Compose: v5.1.2 (버전 명령 실행 확인)
- SSH: OpenSSH_10.3p1 / LibreSSL 3.3.6 (클라이언트 실행 확인). 현재 Git 연결은 HTTPS이므로 GitHub SSH 인증 설정은 필요하지 않다.

## 현재 작업과 다음 확인

- 로컬 저장소 초기화, `.gitignore` 적용 검증, 첫 Commit 생성 및 결과 확인은 완료했다.
- 사용자가 README와 상태 문서 Diff를 확인하고 문서 Commit / Push를 완료했다. 첫 PR의 세 파일을 확인해 Viewed 처리했으며, 작업 브랜치 README의 문서 링크 세 개를 직접 클릭해 모두 정상적으로 열림을 확인했다.
- 작업 브랜치 생성 및 변경 파일 유지 확인은 완료했다. 사용자 출력과 실제 `git status --short --branch`, `git branch -vv`로 확인했다.
- GitHub 저장소 이름은 사용자 선택으로 `simple-board`, 공개 범위는 Public으로 확정했다. 생성 대상은 `yeochang-yoon/simple-board`다.
- GitHub 저장소 생성, 원격 연결 및 최초 `main` Push는 완료했다.
- Issue #1 `README 추가 및 Repository 준비 상태 정리` 등록 완료. 사용자 CLI 실행 결과로 번호와 URL을 확인했다.
- 사용자 요청에 따라 첫 PR 전에 Repository / 협업환경 구성의 중요한 운영 방식을 검토했으며, 필요한 판단을 완료했다.
- Branch / PR 운영 방식은 사용자 선택으로 A안 확정: `main` + 작업별 짧은 브랜치 + PR을 통한 반영.
- 작업은 Issue로 목적 / 완료 조건을 정하고, 최신 `main`에서 작업 브랜치를 생성하여 구현 / 검증 / Commit / Push / PR / Review / 수정 / Merge / 브랜치 정리 순서로 진행한다. 한 PR에는 하나의 관련된 작업을 담는다.
- Merge 방식은 사용자 선택으로 확정: Merge commit을 기본으로 사용하고, 현재 GitHub에서도 Merge commit만 허용한다. Squash / Rebase 허용은 끄기로 결정했다.
- Merge 설정 적용 완료: 사용자가 GitHub Settings에서 직접 적용하고 CLI 조회 결과를 공유했다. `allow_merge_commit: true`, `allow_squash_merge: false`, `allow_rebase_merge: false`로 확인했다.
- `main` 보호는 사용자 선택으로 확정: Branch Ruleset 하나로 PR 경유 필수, 필수 승인 0명, Force Push 차단, 삭제 제한, 우회 대상 없음으로 구성한다. 현재는 필수 CI Check와 linear history를 요구하지 않는다.
- 필수 승인 0명은 Review 생략을 뜻하지 않는다. 사용자와 Codex가 변경 내용과 검증 근거를 확인한 뒤 Merge한다. CI 구성은 Build / Test 방법과 첫 기능이 준비되는 Phase 3에서 진행한다.
- Ruleset 적용 완료: 사용자가 `main-protection` (ID `24418157`)을 생성하고 목록 / 활성 규칙 조회 결과를 공유했다. `active`, PR 요구, 승인 0명, `deletion`, `non_fast_forward` 규칙을 확인했다.
- 추가 읽기 조회로 보호 대상이 `refs/heads/main`만 포함하고 제외 대상이 없으며 `bypass_actors: []`임을 확인했다.
- Ruleset의 `allowed_merge_methods`는 세 방법 모두 포함하지만 Repository 자체 허용값은 Merge commit만 켜져 있다. 두 설정이 함께 적용되므로 실제 가능한 PR Merge 방식은 Merge commit뿐이다.
- 2026-10-05 상태 점검에서 GitHub Repository 설정과 Ruleset 상세를 다시 읽어 위 Merge / 보호 설정이 유지됨을 확인했다.
- 운영 규칙 판단이 끝나 Issue #1과 `docs/repository-setup`의 기존 문서 작업을 재개했다. 사용자 문서 검토 → Commit → Push → PR → Review → Merge 및 Issue 종료 확인으로 진행한다.
- 나머지 구성 항목의 읽기 조사 결과: Merge 후 브랜치 자동 삭제 꺼짐, PR / Issue Template과 License 없음, Label 10개 존재. 기본값을 프로젝트의 확정된 정책으로 취급하지 않는다.
- PR Template은 사용자 선택으로 작은 공통 Template 하나 도입을 확정했다. 항목은 배경 / 변경 / 검증 / 관련 Issue다.
- PR Template은 Issue #3에서 `.github/pull_request_template.md`를 생성하고 사용자 내용 확인 / PR #4 Review / Merge로 `main`에 반영했다. 다음은 새 PR 작성 화면에서의 적용 검증이다.
- Issue Template은 사용자 선택으로 목적 / 작업 범위 / 완료 조건을 담은 공통 Markdown Template 하나 도입을 확정했다. Issue #3에서 `.github/ISSUE_TEMPLATE/task.md` 초안을 생성했으며, 기본 브랜치 반영 후 새 Issue 작성 화면에서 동작을 확인한다.
- Label 운영 수준은 사용자 수락으로 확정했다. 기존 `documentation` (문서), `enhancement` (새 기능 / 개선), `bug` (의도와 다른 동작 수정)를 중심으로 시작하고, 나머지 기존 Label은 유지하여 필요할 때 사용한다. 별도 우선순위 / 영역 / 진행 상태 Label은 현재 추가하지 않는다.
- Label 적용 실습 완료: 사용자가 Issue #1의 GitHub 웹 UI에서 `documentation`을 직접 적용하고 새로고침 후에도 유지됨을 확인했다. Codex의 GitHub API 읽기 조회에서도 해당 Label을 확인했다.
- 첫 PR의 변경 파일은 `README.md`, `docs/PROJECT_STATE.md`, `AGENTS.md` 세 파일이다. README와 상태 문서 변경에 더해, 사용자가 확정한 GitHub 웹 UI / CLI 실습 선택 원칙을 `AGENTS.md`에 반영한 변경도 포함한다. 문서 Commit / Push는 완료했다.
- Staging 실행 및 결과 확인 완료: 사용자가 `git add AGENTS.md README.md docs/PROJECT_STATE.md`, `git status --short`, `git diff --cached`를 실행하고 결과를 공유했다. 실제 Index도 세 파일의 Staging 상태와 일치하며 `git diff --cached --check`를 통과했다. 사용자 공유 출력에는 상태 문서 Diff의 시작까지만 포함됐고 Codex는 전체 Staging Diff를 확인했다. 이후 사용자는 추가 진행 기록을 포함한 상태 문서를 다시 Staging / 확인하고 Commit했다.
- 첫 PR 생성 및 Merge 완료: #2 `docs: README 추가 및 Repository 준비 상태 정리`, base `main`, head `docs/repository-setup`, 본문 `Closes #1`. 생성 당시 Draft 아님 / 충돌 없음을 확인했으며 이 대화에 PR을 연결했다. 사용자 웹 UI Review 후 Merge됐고 GitHub API로 `merged: true`, Merge Commit `e489155`를 확인했다.
- Codex의 최초 PR 검토: 제목 / 본문 / 세 파일 Diff와 사용자 확정 정책을 확인했다. README 링크 대상 세 파일은 PR의 HEAD에서 GitHub 읽기 조회에 성공했다. `git diff main...HEAD --check`를 통과했다. 조회 당시 Check Run / Commit Status는 각각 0개이며, 애플리케이션 / Build / Test / CI가 아직 없어 CI 통과로 취급하지 않는다. 생성 준비로 남아 있던 상태 문서 기록을 PR 생성 / Review 단계로 갱신했다. GitHub에 Review 댓글이나 Approve를 게시한 것은 아니다.
- 사용자 Review 완료: Files changed의 세 파일과 README 링크를 확인하고 수정사항이 없다고 공유했다. 웹 UI에서 Comment Review를 게시했으며 API에서도 `COMMENTED`, 검토 Commit `94ff4f2`를 확인했다. 이후 사용자가 직접 Merge했다.
- 첫 수동 브랜치 정리 완료: Merge 후 원격·로컬 작업 브랜치가 각각 남는 것을 확인하고, 웹 UI에서 원격 브랜치를 삭제했다. 이어 `git fetch --prune`, `git switch main`, `git merge --ff-only origin/main`, `git branch --merged main`으로 동기화와 Merge 포함 여부를 확인한 뒤 `git branch -d docs/repository-setup`으로 로컬 브랜치를 삭제했다. 사용자 출력과 실제 조회에서 로컬 / 원격은 `main`만 남고 `e489155`로 일치하며 작업 폴더가 깨끗함을 확인했다. `origin/HEAD`는 `origin/main`을 가리키는 정상적인 기본 브랜치 참조다.
- 자동 삭제 설정 전환 완료: 사용자가 Repository Settings → General → Pull Requests에서 `Automatically delete head branches`를 켜고 완료를 공유했다. GitHub API에서도 `delete_branch_on_merge: true`를 확인했다. 실제 원격 작업 브랜치 자동 삭제 동작은 다음 PR Merge 때 검증한다.
- 다음 작업: 새 Issue 작성 화면과 후속 상태 기록 PR 작성 화면에서 두 Template 적용을 사용자가 직접 검증한다. 로컬 파일 검토와 GitHub 작성 화면 적용 검증을 구분한다.

## Issue #1 진행 상태와 미실행 작업

- 제목: `README 추가 및 Repository 준비 상태 정리`
- 범위: README에 프로젝트 목적 / 현재 단계 / 주요 문서 링크를 추가하고, 상태 문서를 실제 개발환경 및 Repository 상태에 맞춘다. 작업 브랜치의 변경을 PR로 Review하고 `main`에 반영한다.
- 완료 조건: README에서 목적 / 단계를 확인할 수 있고 세 문서 링크가 열리며, 상태 문서가 실제 결과와 일치하고 PR을 검토 / Merge했다. GitHub의 완료 조건 체크박스는 아직 모두 미완료다.
- 현재 위치: 사용자 Review / 실제 링크 확인 / PR #2 Merge / Issue #1 종료 / 로컬 `main` 동기화 / 첫 원격·로컬 작업 브랜치 수동 정리를 완료했다. GitHub의 완료 조건 체크박스 표시는 자동으로 갱신되지 않았으나 실제 Review / Merge / 링크 검증 결과는 위에 기록했다.
- 자동 삭제 설정 전환 및 PR #4의 실제 원격 작업 브랜치 자동 삭제 동작 확인까지 완료했다.
- Template 파일 추가는 Issue #1 범위에 포함하지 않는다. Issue #3과 별도 작업 브랜치로 진행한다.

## Issue #3 진행 상태와 미실행 작업

- 제목: `PR 및 Issue Template 추가`
- URL: https://github.com/yeochang-yoon/simple-board/issues/3
- 사용자가 웹 UI에서 등록했다. GitHub API로 `open`, `documentation` Label, 목적 / 작업 범위 / 네 가지 완료 조건을 확인했다. 완료 조건은 아직 미완료다.
- 첫 작업 브랜치: `docs/3-collaboration-templates`. 로컬 / 원격 `main`이 `e489155`로 일치함을 확인한 뒤 생성했으며, 앞선 Merge / 브랜치 정리 / 설정 전환 기록을 함께 반영했다. PR #4 Merge 후 원격 자동 삭제와 로컬 안전 삭제를 완료했다.
- 준비한 파일: `.github/pull_request_template.md`, `.github/ISSUE_TEMPLATE/task.md`, `docs/PROJECT_STATE.md`. 두 Template은 합의된 항목만 담으며 안내는 HTML 주석으로 작성했다. Issue Template의 YAML frontmatter `name` / `about`은 선택 화면의 이름 / 설명이며 Label은 작업 성격에 맞춰 적용한다.
- 사용자 초안 확인 완료: 두 Template을 확인하고 수정사항이 없다고 공유했다. 이미 경험한 Commit / Push / PR 생성은 Codex가 처리했다.
- Template Commit: `a6a998a` (`docs: PR 및 Issue Template 추가`), 두 파일 / 26줄 추가. `git diff --cached --check`를 통과하고 작업 브랜치를 Push해 upstream을 설정했다. 앞선 Merge / 정리 결과와 이 진행 기록은 같은 PR의 별도 문서 Commit으로 반영한다. 최신 HEAD는 실제 Git / GitHub 조회를 기준으로 확인한다.
- PR #4: https://github.com/yeochang-yoon/simple-board/pull/4 . 제목 `docs: PR 및 Issue Template 추가`, base `main`, head `docs/3-collaboration-templates`. 본문은 합의한 네 항목으로 작성했다. Merge 후 완료 조건 검증이 남아 있으므로 `Refs #3`로 연결해 Issue는 열어두고, 검증을 마친 뒤 종료한다.
- 사용자 PR 검토 완료: 세 파일을 모두 읽고 Viewed 처리했으며 수정사항이 없다고 공유했다. 별도 GitHub Review comment는 제출하지 않았다. 이를 GitHub의 Approve / Comment Review 제출로 기록하지 않는다.
- Merge 전 읽기 재확인: PR #4는 `open`, `merged: false`, 최신 HEAD `09df7a3` (두 Commit / 세 파일), `mergeable: true`, `mergeable_state: clean`이다. Repository는 Merge commit만 허용하고 `delete_branch_on_merge: true`를 유지한다.
- Merge 및 자동 삭제 완료: 사용자가 웹 UI에서 실행 / 확인했고 API에서도 `merged: true`, Merge Commit `65f03e4`, Merge 시각 `2026-10-05T11:31:26Z` (20:31:26 Asia/Seoul), 원격 브랜치 목록에 `main`만 남음을 확인했다. Issue #3는 `Refs #3`를 사용했으므로 `open` 상태를 유지한다.
- 로컬 반복 정리 완료: 검토 기록을 임시 Stash로 보존하고 `git fetch --prune`, `git switch main`, `git merge --ff-only origin/main`을 실행했다. Stash 복원 성공 후 `git branch --merged main`으로 포함 여부를 확인해 기존 로컬 작업 브랜치를 `-d`로 안전 삭제했다. 로컬 `main` / `origin/main`은 `65f03e4`로 일치한다.
- 후속 기록 브랜치: `docs/3-template-verification`, 기준 `65f03e4`. 이미 검토한 PR #4의 내용을 바꾸지 않고 Merge / 자동 삭제 / 화면 검증 결과를 기록하기 위한 같은 Issue의 후속 문서 작업이다. 이 브랜치의 실제 상태 문서 변경으로 새 PR 작성 화면에서 Template 기본 적용을 검증한다.
- 현재 단계: 새 Issue / PR 작성 화면 검증 대기. GitHub 화면 적용과 Repository / 협업환경 구성 전체를 아직 완료 처리하지 않는다.
- 다음 순서: Issue Template 선택 / 본문 확인 → 후속 문서 PR 작성 화면에서 PR Template 본문 확인 → 검증 결과 기록 → 후속 PR Review / Merge 및 Issue 종료. 빈 검증용 Issue / PR은 제출하지 않는다.
- 로컬 검증: `git diff --check`로 상태 문서의 공백 오류가 없음을 확인했다. 새 Template 두 파일은 `git diff --no-index --check /dev/null <파일>`에서 공백 오류 진단이 없음을 확인했다 (새 파일과 `/dev/null` 사이의 차이로 종료 코드는 1). GitHub 화면 적용은 아직 미검증이며 로컬 파일 검토만으로 적용 성공을 판단하지 않는다.

## 진행 원칙 및 미결정 사항

- 처음 경험하는 핵심 절차는 사용자가 직접 수행하고 결과를 확인한다.
- GitHub 협업 실습은 현업의 일반적인 작업 방식과 작업 성격에 맞춰 웹 UI / `gh` CLI를 선택한다. UI 확인과 조작이 자연스러운 작업은 웹 UI, CLI가 효율적이거나 CLI 자체의 학습 가치가 있는 작업은 `gh`로 안내한다. 해당 원칙을 `AGENTS.md`에도 반영했다.
- Repository / 협업환경 구성의 완료 조건을 확인한 뒤 Project Kickoff로 이동한다.
- 현재 필요한 Repository 운영 판단, 첫 수동 브랜치 정리 / 자동 삭제 설정 전환과 실제 자동 삭제 동작 확인은 완료했다. Template의 작성 화면 적용 검증과 결과 기록 반영이 남아 있다.
- 브랜치 이름 규칙 확정: 앞으로 새 작업 브랜치는 `<종류>/<Issue 번호>-<짧은 설명>` 형태로 하고, 종류는 `docs` / `feature` / `fix` / `chore`, 설명은 영문 소문자와 하이픈을 사용한다. 기존 `docs/repository-setup`은 이름을 유지한다. 이전 예시의 Issue 번호와 기능명은 설명용이며 실제 Issue 생성이나 서비스 요구사항 결정이 아니다.
- 브랜치 이름 운영 방식 확정: 사용자가 1번 (문서 convention과 PR 검토)을 선택했다. 이름 규칙을 PR에서 확인하며, GitHub 이름 제한 / 이름 검사 CI / 로컬 Hook은 추가하지 않는다. 실제 필요가 생기면 자동 검사 도입을 다시 검토할 수 있다.
- 2026-10-05 공식 문서 확인: 일반 Branch Ruleset은 Public 저장소에서도 사용 가능하지만, 새 브랜치 이름 형식을 검사하는 metadata restriction은 GitHub Enterprise 요금제의 조직 기능으로 안내된다. 현재 개인 소유 저장소에 같은 기능을 바로 적용할 수 있다고 전제하지 않는다. 참고: https://docs.github.com/en/enterprise-cloud@latest/repositories/configuring-branches-and-merges-in-your-repository/managing-rulesets/available-rules-for-rulesets#metadata-restrictions . 현재 구조에서 정규식 기반 강제가 필요하면 PR의 source branch 이름을 GitHub Actions로 검사하고 필수 Check로 지정하는 대안을 검토할 수 있다. 이는 원격 브랜치 생성 차단과 달리 Merge를 차단하는 방식이며 아직 구현하지 않았다.
- Commit 규칙 확정: 사용자가 제안한 type과 `<type>: <짧은 요약>` 형식을 convention으로 사용하기로 했다. `feat` / `fix` / `docs` / `chore` / `test` / `refactor`를 필요에 따라 사용한다. 요약은 한글을 허용하고, 이유나 주의점이 있으면 빈 줄 뒤 본문에 기록한다. 관련된 변경 단위로 Commit을 나누며 한 Issue에 여러 Commit이 있을 수 있다. scope / Issue 번호는 제목에 필수로 넣지 않고 Issue 연결은 PR 본문에서 한다. 기존 첫 Commit과 GitHub가 생성하는 Merge commit 메시지는 유지한다. 별도 자동 강제는 추가하지 않고 PR Review에서 메시지와 변경 단위를 확인한다. 참고: https://www.conventionalcommits.org/en/v1.0.0/ .
- Merge 후 브랜치 정리 운영 방식 확정: 첫 PR은 사용자가 원격·로컬 작업 브랜치 잔존 확인과 수동 정리를 직접 경험했다. 이후 반복 작업을 줄이기 위해 GitHub의 `Automatically delete head branches`를 켰다. 자동 삭제를 켜도 로컬 브랜치와 원격 추적 참조 정리는 별도로 필요하다.
- 2026-10-05 수동 정리 후 자동 삭제 전환 완료: 사용자 웹 UI 설정 실행과 GitHub API의 `delete_branch_on_merge: true`로 설정 반영을 확인했다. PR #4 Merge 후 실제 원격 작업 브랜치 자동 삭제도 사용자 확인과 API 조회로 검증했다. License 보류 정책도 유지한다.
- License 보류 확정: 현재 Repository 목적은 학습 프로젝트 공개와 개발 Lifecycle 경험이며, 다른 사람의 재사용 / 수정 / 배포를 적극적으로 허용하려는 목적은 아직 없다. Repository 준비를 위해 형식적으로 License를 추가하지 않는다. 나중에 실제 재사용 허용 필요가 생기면 MIT 등의 License를 다시 검토한다. `LICENSE` 파일은 생성하지 않았다.
- Secret은 `docs/DEVELOPMENT_PROCESS.md`의 공통 원칙에 따라 Password / API Key / Token 등을 Git에 저장하지 않는다. 현재 Secret을 사용하는 설정은 없으며 구체적인 주입 / 제외 방식은 필요한 설정이 생길 때 검토한다.
- 서비스 주제와 MVP 범위는 아직 결정하지 않았다. 폴더 이름만으로 게시판 서비스를 확정하지 않는다.
- JDK / Spring 버전, 빌드 도구, DB, Frontend 기술, 배포 대상은 아직 결정하지 않았다.
- 상태 복구 이후 PR #2의 첫 수동 브랜치 정리와 PR #4의 자동 삭제까지 완료했다. 현재는 Issue #3의 Template 작성 화면 검증 단계다.
- 두 Template과 기존 상태 기록은 PR #4로 `main`에 Merge됐다. 이번 Merge / 정리 이후 기록은 `docs/3-template-verification`의 후속 PR로 반영한다. 이 기록을 `main`에 직접 Commit / Push하지 않는다. 진행 상태 복구 시 실제 Git / GitHub와 후속 작업 브랜치의 문서도 함께 확인한다.
- 사용자가 재개를 요청하면 실제 Git / GitHub 상태와 후속 기록 브랜치 / PR 여부를 확인한다. 현재는 새 Issue / PR 작성 화면 검증부터 이어간다. 검증 결과와 상태 기록 반영을 확인한 뒤 Project Kickoff로 이동한다.
