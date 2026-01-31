# Faro Web SDK

## 버전
**v5.3.1**

## 개요

Grafana Faro Web SDK v5.3.1은 웹 애플리케이션의 모니터링과 observability를 위한 JavaScript SDK입니다. 이 버전은 improved 성능과 새로운 기능을 포함합니다.

## 새로운 기능 (v5.3.0 시리즈)

- ✅ **향상된 성능**: 메모리 사용량 최적화
- ✅ **새로운 전송 계층**: 개선된 데이터 전송 메커니즘
- ✅ **세션 관리**: 향상된 세션 추적
- ✅ **자동 계측**: 코드 수정 없는 자동 계측

## 설치

```bash
npm install @grafana/faro-web-sdk
```

## 빠른 시작

```typescript
import { Faro } from '@grafana/faro-web-sdk';
import { WebConsole } from '@grafana/faro-web-sdk';
import { TracingInstrumentation } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.your-domain.com/collect',
  app: {
    name: 'my-web-app',
    version: '1.0.0',
    environment: 'production',
  },
  instrumentations: [
    new WebConsole(),
    new TracingInstrumentation(),
  ],
});
```

## 주요 변경사항

### v5.3.1에서의 변경

1. **메모리 누수 수정**
2. **세션 관리 개선**
3. **타입스크립트 타입 개선**

### v5.x 시리즈의 주요 기능

#### 1. 개선된 초기화

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'my-app',
    version: '1.0.0',
  },
  session: {
    persistent: true,
    maxLength: 100,
  },
});
```

#### 2. 커스텀 전송 계층

```typescript
import { TransportCore } from '@grafana/faro-web-sdk';

const customTransport = new TransportCore({
  url: 'https://collector.example.com',
  apiKey: 'your-api-key',
});

const faro = Faro.init({
  transports: [customTransport],
  // ...
});
```

#### 3. 메타데이터 관리

```typescript
// 메타데이터 추가
faro.api.setMeta({
  userId: '12345',
  plan: 'premium',
});

// 메타데이터 가져오기
const meta = faro.api.getMeta();
```

## API

### 핵심 메서드

| 메서드 | 설명 |
|--------|------|
| `init(config)` | Faro SDK 초기화 |
| `api.pushError(error)` | 에러 전송 |
| `api.pushEvent(name, attrs)` | 이벤트 전송 |
| `api.setMeta(meta)` | 메타데이터 설정 |
| `api.getSession()` | 세션 정보 가져오기 |

## 예시

### 에러 추적

```typescript
try {
  riskyOperation();
} catch (error) {
  faro.api.pushError(error, {
    context: 'user-action',
    userId: '12345',
  });
}
```

### 커스텀 이벤트

```typescript
faro.api.pushEvent('button_click', {
  buttonId: 'submit',
  page: '/checkout',
  timestamp: Date.now(),
});
```

### 세션 관리

```typescript
// 현재 세션 가져오기
const session = faro.api.getSession();

// 세션 속성 설정
faro.api.setSession({
  userId: '12345',
  userRole: 'admin',
});
```

## 마이그레이션 가이드

### v4.x에서 v5.3.1로

```typescript
// v4.x
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.example.com',
  apiKey: 'key',
});

// v5.3.1
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'my-app',
    version: '1.0.0',
  },
  // apiKey는 더 이상 사용되지 않음
});
```

## 타입스크립트 지원

```typescript
import { Faro, Meta, Session } from '@grafana/faro-web-sdk';

interface CustomMeta extends Meta {
  userId?: string;
  plan?: string;
}

const faro: Faro<CustomMeta> = Faro.init({
  // ...
});

faro.api.setMeta({
  userId: '12345',
  plan: 'premium',
});
```

## 브라우저 지원

- Chrome 90+
- Firefox 88+
- Safari 14+
- Edge 90+

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops
- **Grafana Faro**: https://github.com/grafana/faro-web-sdk
- **문서**: https://grafana.com/docs/grafana-cloud/frontend-observability/faro/

---

**마지막 업데이트**: 2026-02-01
