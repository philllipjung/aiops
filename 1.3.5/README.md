# Grafana Faro Web SDK

## 버전
**v1.3.5**

## 개요

Grafana Faro Web SDK v1.3.5는 웹 애플리케이션 모니터링을 위한 JavaScript SDK입니다. 기능 개선과 버그 수정이 포함된 마이너 버전입니다.

## v1.3.5 변경사항

- 새로운 기능 추가
- 성능 최적화
- 타입스크립트 정의 개선

## 설치

```bash
cd /root/aiops/1.3.5
yarn install
```

## 사용

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  app: {
    name: 'my-app',
    version: '1.0.0',
  },
});
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops
- **원본**: https://github.com/grafana/faro-web-sdk

---

**마지막 업데이트**: 2026-02-01
