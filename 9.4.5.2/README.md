# Faro Web SDK

## 버전
**v9.4.5.2**

## 개요

Faro Web SDK v9.4.5.2는 AI-powered insights와 고급 모니터링 기능을 포함합니다.

## v9.4.5.2 변경사항

- AI 기반 이상 탐지 개선
- Session replay 안정화
- 버그 수정

## 설치

```bash
npm install @grafana/faro-web-sdk@9.4.5.2
```

## 사용

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  app: { name: 'my-app', version: '1.0.0' },
  ai: { enableAnomalyDetection: true },
});
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
