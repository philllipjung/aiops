# Faro Web SDK

## 버전
**v5.3.13**

## 개요

Faro Web SDK v5.3.13은 패치 버전으로 버그 수정과 안정성 개선이 포함되어 있습니다.

## v5.3.13 변경사항

- 중요 버그 수정
- 안정성 강화
- 문서 개선

## 설치

```bash
npm install @grafana/faro-web-sdk@5.3.13
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
