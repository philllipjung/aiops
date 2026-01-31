# Faro Web SDK

## 버전
**v3.8.1**

## 개요

Faro Web SDK v3.8.1은 웹 observability SDK의 안정화 버전입니다.

## 주요 기능

- 오류 추적
- 성능 모니터링
- 사용자 세션 추적

## 설치

```bash
npm install @grafana/faro-web-sdk@3.8.1
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
