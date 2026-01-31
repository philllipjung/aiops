# Faro Web SDK

## 버전
**v9.4.6**

## 개요

Faro Web SDK v9.4.6는 마이너 버전 업그레이드로 새로운 기능이 추가되었습니다.

## v9.4.6 새로운 기능

- 향상된 AI 분석
- 개선된 Session Replay
- 새로운 통합 옵션

## 설치

```bash
npm install @grafana/faro-web-sdk@9.4.6
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
