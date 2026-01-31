# Faro Web SDK

## 버전
**v6.6.3**

## 개요

Faro Web SDK v6.6.3는 OpenTelemetry 지원 및 고급 tracing 기능을 포함한 SDK입니다.

## v6.6.x 기능

- OpenTelemetry 호환
- 고급 tracing
- 메트릭 수집
- 성능 개선

## 설치

```bash
npm install @grafana/faro-web-sdk@6.6.3
```

## 사용

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  app: { name: 'my-app', version: '1.0.0' },
  experimentalFeatures: { opentelemetry: true },
});
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
