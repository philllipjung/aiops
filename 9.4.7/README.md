# Faro Web SDK

## 버전
**v9.4.7**

## 개요

Faro Web SDK v9.4.7은 최신 안정화 버전으로 안정성과 성능이 개선되었습니다.

## v9.4.7 변경사항

- 안정성 강화
- 성능 최적화
- OpenTelemetry 지원 개선

## 설치

```bash
npm install @grafana/faro-web-sdk@9.4.7
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
