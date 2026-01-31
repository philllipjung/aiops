# Grafana Faro Web SDK

## 버전
**v1.3.2**

## 개요

Grafana Faro Web SDK는 웹 애플리케이션의 모니터링, 오류 추적, 성능 분석을 위한 JavaScript SDK입니다. Grafana Cloud Frontend Observability의 핵심 컴포넌트입니다.

## 주요 기능

- ✅ **자동 오류 추적**: JavaScript 오류 자동 수집
- ✅ **세션 추적**: 사용자 세션 기록
- ✅ **성능 모니터링**: 페이지 로드 시간, API 응답 시간
- ✅ **이벤트 로깅**: 커스텀 이벤트 수집
- ✅ **메타데이터 수집**: 환경 정보 자동 수집

## 기술 스택

- **언어**: TypeScript
- **프레임워크**: React
- **번들러**: Rollup
- **테스트**: Jest, Cypress
- **패키지 관리**: Yarn Workspaces, Lerna

## 디렉토리 구조

```
1.3.2/
├── packages/           # 하위 패키지들
│   ├── console/        # 콘솔 인스트루먼트
│   ├── metadata/       # 메타데이터 인스트루먼트
│   ├── sdk/            # 코어 SDK
│   └── web/            # 웹 SDK
├── demo/               # 데모 애플리케이션
├── docs/               # 문서
├── infra/              # 인프라 설정
├── dashboards/         # Grafana 대시보드
├── cypress/            # E2E 테스트
├── Dockerfile          # Docker 이미지
└── docker-compose.yaml # Docker Compose 설정
```

## 설치

```bash
# 의존성 설치
yarn install

# 개발 서버 시작
yarn start

# 빌드
yarn build
```

## 사용 예시

### SDK 초기화

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  app: {
    name: 'my-app',
    version: '1.0.0',
    environment: 'production',
  },
});
```

### 에러 추적

```typescript
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

## Docker 실행

```bash
# Docker Compose로 실행
docker-compose up -d

# 로그 확인
docker-compose logs -f

# 중지
docker-compose down
```

## 테스트

```bash
# 단위 테스트
yarn test

# E2E 테스트
yarn cypress

# 품질 검사
yarn quality
```

## 관련 링크

- **저장소**: https://github.com/grafana/faro-web-sdk
- **문서**: https://grafana.com/docs/grafana-cloud/frontend-observability/faro/
- **라이선스**: Apache-2.0

---

**마지막 업데이트**: 2026-02-01
