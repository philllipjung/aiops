# Faro Web SDK

## 버전
**v9.4.5.3**

## 개요

Faro Web SDK v9.4.5.3은 패치 버전으로 성능 개선과 버그 수정이 포함되어 있습니다.

## v9.4.5.3 변경사항

- 성능 최적화
- 메모리 사용량 개선
- 타입 정의 수정

## 설치

```bash
npm install @grafana/faro-web-sdk@9.4.5.3
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
