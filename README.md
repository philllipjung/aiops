# AIOps 저장소

## 개요 (Overview)

이 저장소는 **Grafana Faro Web SDK**를 포함한 AIOps(인공지능 운영) 관련 컴포넌트들의 모노레포입니다. 웹 애플리케이션의 모니터링, 로그 수집, 이벤트 추적 등의 기능을 제공합니다.

### 주요 정보

| 항목 | 설명 |
|------|------|
| **저장소** | https://github.com/philllipjung/aiops.git |
| **원본 프로젝트** | Grafana Faro Web SDK |
| **라이선스** | Apache-2.0 |
| **형태** | Monorepo (Yarn Workspaces + Lerna) |

---

## 디렉토리 구조

```
/root/aiops/
├── 1.3.2/           # Faro Web SDK 메인 패키지
├── 1.3.3/           # 버전 1.3.3
├── 1.3.5/           # 버전 1.3.5
├── 10.3.2.2/        # 컴포넌트 v10.3.2.2
├── 10.3.2.3/        # 컴포넌트 v10.3.2.3
├── 10.7.3/          # 컴포넌트 v10.7.3
├── 10.7.5.1/        # AIOps Agent v10.7.5.1
├── 10.7.5.4/        # AIOps Agent v10.7.5.4
├── 10.7.5.5/        # AIOps Agent v10.7.5.5
├── 10.7.5.6/        # AIOps Agent v10.7.5.6
├── 10.7.5.8/        # AIOps Agent v10.7.5.8
├── 3.2.5/           # transport-fetch v3.2.5
├── 3.3.1/           # 컴포넌트 v3.3.1
├── 3.3.2/           # 컴포넌트 v3.3.2
├── 3.3.3/           # 컴포넌트 v3.3.3
├── 3.4.1/           # transport-xhr-instr v3.4.1
├── 3.4.2/           # transport-xhr-instr v3.4.2
├── 3.4.3/           # transport-xhr-instr v3.4.3
├── 3.4.5/           # transport-xhr-instr v3.4.5
├── 3.7.1/           # e2e-tests v3.7.1
├── 3.7.2/           # e2e-tests v3.7.2
├── 3.7.4/           # e2e-tests v3.7.4
├── 3.8.1/           # web-sdk v3.8.1
├── 3.8.2/           # web-sdk v3.8.2
├── 4.2.4/           # console-instr v4.2.4
├── 4.2.5/           # console-instr v4.2.5
├── 4.2.9/           # console-instr v4.2.9
├── 4.4.4/           # metadata-instr v4.4.4
├── 5.3.1/           # faro-web-sdk v5.3.1
├── 5.3.12/          # faro-web-sdk v5.3.12
├── 5.3.13/          # faro-web-sdk v5.3.13
├── 6.2.1/           # faro-web-sdk v6.2.1
├── 6.6.3/           # faro-web-sdk v6.6.3
├── 6.7.1/           # faro-web-sdk v6.7.1
├── 8.4.2/           # faro-web-sdk v8.4.2
├── 8.4.4/           # faro-web-sdk v8.4.4
├── 9.4.5.1/         # faro-web-sdk v9.4.5.1
├── 9.4.5.2/         # faro-web-sdk v9.4.5.2
├── 9.4.5.3/         # faro-web-sdk v9.4.5.3
├── 9.4.6/           # faro-web-sdk v9.4.6
├── 9.4.7/           # faro-web-sdk v9.4.7
└── .git/            # Git 저장소
```

---

## 주요 컴포넌트

### 1. Faro Web SDK (메인 패키지: 1.3.2)

**위치**: `/root/aiops/1.3.2/`

웹 애플리케이션 모니터링을 위한 JavaScript SDK입니다.

**주요 기능**:
- 자동 오류 추적
- 사용자 세션 추적
- 성능 모니터링
- 이벤트 로깅
- 커스텀 메타데이터 수집

**기술 스택**:
- TypeScript
- React
- Rollup (번들러)
- Jest (테스트)
- Cypress (E2E 테스트)

**디렉토리 구조**:
```
1.3.2/
├── packages/          # 하위 패키지들
├── demo/              # 데모 애플리케이션
├── docs/              # 문서
├── infra/             # 인프라 설정
├── dashboards/        # Grafana 대시보드
├── cypress/           # E2E 테스트
└── docker-compose.yaml # Docker 컴포즈
```

### 2. AIOps Agent (10.7.5.x 시리즈)

**위치**: `/root/aiops/10.7.5.1/`, `/root/aiops/10.7.5.4/`, 등

AIOps 에이전트는 OpenSearch와 통합하여 로그 및 메트릭을 수집합니다.

**주요 기능**:
- OpenSearch 데이터 수집
- 에이전트 기반 모니터링
- 메트릭 수집 및 전송

**구성요소**:
- Dockerfile
- docker-compose.yml
- agents/ (수집 에이전트)
- opensearch/ (OpenSearch 설정)

### 3. Transport Plugins

**XHR Transport** (3.4.x):
- `3.4.1/`, `3.4.2/`, `3.4.3/`, `3.4.5/`
- XMLHttpRequest 기반 데이터 전송

**Fetch Transport** (3.2.5):
- Fetch API 기반 데이터 전송

### 4. Instrumentation Plugins

**Console Instrumentation** (4.2.x):
- `4.2.4/`, `4.2.5/`, `4.2.9/`
- 콘솔 로그 자동 수집

**Metadata Instrumentation** (4.4.4):
- 메타데이터 자동 수집

---

## 설치 및 설정

### 사전 요구사항

```bash
# Node.js 버전
node --version  # v18 이상 권장

# Yarn 설치
npm install -g yarn
```

### 메인 패키지 설치 (1.3.2)

```bash
cd /root/aiops/1.3.2

# 의존성 설치
yarn install

# 개발 서버 시작
yarn start

# 빌드
yarn build

# 테스트
yarn test

# E2E 테스트
yarn cypress
```

### Docker로 실행

```bash
cd /root/aiops/1.3.2

# Docker Compose로 전체 스택 시작
docker-compose up -d

# 로그 확인
docker-compose logs -f

# 중지
docker-compose down
```

---

## 사용 예시

### Faro Web SDK 초기화

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  app: {
    name: 'my-app',
    version: '1.0.0',
  },
});
```

### 에러 추적

```typescript
import { faro } from '@grafana/faro-web-sdk';

try {
  // 코드 실행
} catch (error) {
  faro.api.pushError(error);
}
```

### 커스텀 이벤트

```typescript
faro.api.pushEvent('user_action', {
  action: 'button_click',
  button_id: 'submit',
});
```

---

## 개발 가이드

### 패키지 구조

각 버전 디렉토리는 독립적인 패키지로 구성됩니다:

```bash
# 예: 1.3.2 패키지
cd /root/aiops/1.3.2

# 패키지 목록 확인
yarn workspaces info

# 특정 패키지 시작
yarn workspace @grafana/faro-demo start

# 모든 패키지 빌드
yarn build
```

### 품질 확인

```bash
# 린트 검사
yarn quality:lint

# 포맷팅
yarn quality:format

# 전체 품질 검사
yarn quality

# 순환 의존성 확인
yarn quality:circular-deps
```

### 테스트

```bash
# 단위 테스트
yarn test

# E2E 테스트 (대화형)
yarn cypress

# E2E 테스트 (CI)
yarn quality:e2e:ci
```

---

## Git 작업

### 원격 저장소

```
origin: https://github.com/philllipjung/aiops.git
```

### 커밋 및 푸시

```bash
cd /root/aiops

# 상태 확인
git status

# 변경사항 커밋
git add .
git commit -m "메시지"

# 푸시
git push origin main
```

### 브랜치 관리

```bash
# 새 브랜치 생성
git checkout -b feature/new-feature

# 브랜치 목록
git branch -a

# 브랜치 전환
git checkout main
```

---

## Docker 이미지

### 이미지 빌드

```bash
# 메인 패키지 Dockerfile
cd /root/aiops/1.3.2
docker build -t faro-web-sdk:latest .

# AIOps Agent
cd /root/aiops/10.7.5.1
docker build -t aiops-agent:latest .
```

### Docker Compose

```bash
# 메인 패키지
cd /root/aiops/1.3.2
docker-compose up -d

# AIOps Agent
cd /root/aiops/10.7.5.1
docker-compose up -d
```

---

## 문서

### 공식 문서
- [Grafana Faro Web SDK](https://github.com/grafana/faro-web-sdk)
- [Grafana Faro 문서](https://grafana.com/docs/grafana-cloud/frontend-observability/faro/)

### 프로젝트 문서
- `/root/aiops/1.3.2/docs/`
- `/root/aiops/1.3.2/README.md` (패키지별 README)

---

## 트러블슈팅

### 의존성 설치 실패

```bash
# 캐시 삭제 후 재설치
rm -rf node_modules yarn.lock
yarn cache clean
yarn install
```

### Docker 빌드 실패

```bash
# Docker 캐시 삭제
docker system prune -a

# 재빌드
docker-compose build --no-cache
```

### 포트 충돌

```bash
# 사용 중인 포트 확인
sudo lsof -i :5173

# 포트 변경
# docker-compose.yml 또는 .env 파일에서 PORT 설정 변경
```

---

## 기여

### 커밋 컨벤션

```
feat: 새로운 기능 추가
fix: 버그 수정
docs: 문서 업데이트
style: 코드 포맷팅
refactor: 코드 리팩토링
test: 테스트 추가/수정
chore: 빌드/설정 변경
```

### Pull Request

1. 새 브랜치 생성
2. 변경사항 커밋
3. 원격 저장소에 푸시
4. Pull Request 생성

---

## 라이선스

```
Apache License 2.0
Copyright (c) Grafana Labs
```

---

## 연락처

- **저장소**: https://github.com/philllipjung/aiops
- **이슈 트래커**: https://github.com/philllipjung/aiops/issues

---

## 버전 히스토리

| 버전 | 날짜 | 주요 변경사항 |
|------|------|-------------|
| 1.3.2 | 초기 | 메인 Faro Web SDK |
| 1.3.3 | - | 버그 수정 및 개선 |
| 1.3.5 | - | 기능 추가 |
| 10.7.5.8 | 최신 | AIOps Agent 최신 버전 |

---

**마지막 업데이트**: 2026-02-01
**관리자**: philip
**환경**: Minikube + OpenSearch + Fluent Bit
