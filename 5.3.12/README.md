# Faro Web SDK

## 버전
**v5.3.12**

## 개요

Faro Web SDK v5.3.12는 웹 observability SDK의 마이너 업데이트 버전입니다.

## v5.3.12 변경사항

- 새로운 인스트루먼테이션 추가
- 성능 최적화
- 버그 수정

## 설치

```bash
npm install @grafana/faro-web-sdk@5.3.12
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
