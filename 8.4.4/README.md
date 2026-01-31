# Faro Web SDK

## 버전
**v8.4.4**

## 개요

Faro Web SDK v8.4.4는 Grafana Cloud 통합과 개선된 observability 기능을 제공합니다.

## v8.4.4 변경사항

- Grafana Cloud 통합 개선
- Smart Sampling 최적화
- Privacy controls 강화

## 설치

```bash
npm install @grafana/faro-web-sdk@8.4.4
```

## 사용

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  app: { name: 'my-app', version: '1.0.0' },
  sampling: { errorSamplingRate: 1.0 },
  privacy: { maskSensitiveData: true },
});
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
