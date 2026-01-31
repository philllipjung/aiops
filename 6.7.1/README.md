# Faro Web SDK

## 버전
**v6.7.1**

## 개요

Faro Web SDK v6.7.1은 OpenTelemetry와 메트릭 수집 기능이 강화된 버전입니다.

## v6.7.1 변경사항

- 메트릭 API 개선
- OpenTelemetry 통합 강화
- 타입스크립트 정의 개선

## 설치

```bash
npm install @grafana/faro-web-sdk@6.7.1
```

## 사용

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  app: { name: 'my-app', version: '1.0.0' },
});
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
