# Grafana Faro Web SDK

## 버전
**v1.3.3**

## 개요

Grafana Faro Web SDK v1.3.3는 웹 애플리케이션 모니터링을 위한 JavaScript SDK입니다. 버그 수정과 안정성 개선이 포함된 패치 버전입니다.

## v1.3.3 변경사항

- 버그 수정
- 안정성 개선
- 문서 업데이트

## 설치

```bash
cd /root/aiops/1.3.3
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
