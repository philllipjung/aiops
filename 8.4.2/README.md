# Faro Web SDK

## 버전
**v8.4.2**

## 개요

Grafana Faro Web SDK v8.4.2는 웹 애플리케이션 observability를 위한 production-ready JavaScript SDK입니다. 향상된 안정성, 새로운 integration, 그리고 개선된 developer experience를 제공합니다.

## v8.x 시리즈 주요 기능

- ✅ **Grafana Cloud 통합**: Grafana Cloud와 완벽한 통합
- ✅ **Smart Sampling**: 지능형 이벤트 샘플링
- ✅ **Auto-instrumentation**: 코드 수정 없는 자동 계측
- ✅ **Edge Functions Support**: Edge 런타임 지원
- ✅ **Privacy Controls**: 개인정보 보호 기능 강화

## 설치

```bash
npm install @grafana/faro-web-sdk@8.4.2
```

## 빠른 시작

```typescript
import { Faro } from '@grafana/faro-web-sdk';
import { WebConsole } from '@grafana/faro-web-sdk';
import { TracingInstrumentation } from '@grafana/faro-web-sdk';
import { WebVitalsInstrumentation } from '@grafana/faro-web-sdk';

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
    new WebVitalsInstrumentation(),
  ],
});
```

## 주요 변경사항 (v8.x)

### 1. Grafana Cloud Integration

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.your-domain.com/collect',
  // Grafana Cloud 자동 설정
  integrateGrafanaCloud: {
    instanceId: 'your-instance-id',
  },
});
```

### 2. Smart Sampling

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  sampling: {
    // 에러는 100% 수집
    errorSamplingRate: 1.0,
    // 트랜잭션은 10% 샘플링
    transactionSamplingRate: 0.1,
    // 커스텀 이벤트는 5% 샘플링
    eventSamplingRate: 0.05,
  },
});
```

### 3. Privacy Controls

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  privacy: {
    // 민감한 데이터 마스킹
    maskSensitiveData: true,
    // 제외할 필드
    excludeFields: ['password', 'token', 'ssn'],
    // URL 쿼리 파라미터 제거
    stripQueryParams: true,
  },
});
```

### 4. Auto-instrumentation

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  autoInstrumentation: {
    // Fetch API 자동 계측
    fetch: true,
    // XMLHttpRequest 자동 계측
    xhr: true,
    // History 변경 자동 추적
    history: true,
    // DOM 이벤트 자동 추적
    dom: {
      click: true,
      input: true,
    },
  },
});
```

## API

### 핵심 메서드

| 메서드 | 설명 |
|--------|------|
| `init(config)` | Faro SDK 초기화 |
| `api.pushError(error)` | 에러 전송 |
| `api.pushEvent(name, attrs)` | 이벤트 전송 |
| `api.pushLog(log)` | 로그 전송 |
| `api.setUser(user)` | 사용자 설정 |
| `api.setSessionAttr(key, value)` | 세션 속성 설정 |

## 예시

### 사용자 추적

```typescript
// 사용자 설정
faro.api.setUser({
  id: '12345',
  email: 'user@example.com',
  username: 'john_doe',
  name: 'John Doe',
});

// 사용자 속성 업데이트
faro.api.setUserProperty('plan', 'premium');
faro.api.setUserProperty('role', 'admin');
```

### 로그 전송

```typescript
// 로그 레벨별 전송
faro.api.pushLog({
  level: 'info',
  message: 'Application started',
});

faro.api.pushLog({
  level: 'error',
  message: 'Failed to load resource',
  context: {
    resource: '/api/data',
    status: 500,
  },
});
```

### 커스텀 속성

```typescript
// 전역 속성 설정
faro.api.setGlobalProperty('appVersion', '1.0.0');
faro.api.setGlobalProperty('environment', 'production');

// 세션 속성 설정
faro.api.setSessionAttr('customSessionData', { key: 'value' });
```

## v7.x에서 v8.4.2로 마이그레이션

### 변경사항

```typescript
// v7.x
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'my-app',
  },
  instrumentations: [
    new TracingInstrumentation(),
  ],
});

// v8.4.2 - 새로운 API
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'my-app',
    version: '1.0.0',
  },
  // 자동 계측 추가
  autoInstrumentation: {
    fetch: true,
    xhr: true,
  },
  // 프라이버시 설정
  privacy: {
    maskSensitiveData: true,
  },
  instrumentations: [
    new TracingInstrumentation(),
    new WebVitalsInstrumentation(), // 새로운 기능
  ],
});
```

## Experimental Features

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  experimentalFeatures: {
    // Edge Functions 지원
    edgeSupport: true,
    // WebAssembly 최적화
    webAssemblyOptimization: true,
    // Background 전송
    backgroundSync: true,
    // Batch 전송
    batchSending: true,
  },
});
```

## Edge Functions Support

```typescript
// Vercel Edge Functions, Cloudflare Workers 등에서 사용
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'edge-function',
  },
  // Edge 런타임 최적화
  runtime: 'edge',
});
```

## 성능 모니터링

```typescript
import { WebVitalsInstrumentation } from '@grafana/faro-web-sdk';

const webVitals = new WebVitalsInstrumentation({
  // Core Web Vitals 자동 수집
  captureLCP: true,  // Largest Contentful Paint
  captureFID: true,  // First Input Delay
  captureCLS: true,  // Cumulative Layout Shift
  // 추가 메트릭
  captureFCP: true,  // First Contentful Paint
  captureTTFB: true, // Time to First Byte
});
```

## 타입스크립트

```typescript
import { Faro, FaroAPI } from '@grafana/faro-web-sdk';

interface User {
  id: string;
  email: string;
  plan: 'free' | 'premium';
}

declare module '@grafana/faro-web-sdk' {
  export interface FaroUserExtensions extends User {}
}

const faro: FaroAPI = Faro.init({
  // ...
});

// 타입 안전한 사용자 설정
faro.api.setUser({
  id: '12345',
  email: 'user@example.com',
  plan: 'premium',
});
```

## 브라우저 지원

- Chrome 110+
- Firefox 100+
- Safari 16+
- Edge 110+
- Mobile browsers (iOS Safari 16+, Chrome Android 110+)

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops
- **Grafana Faro**: https://github.com/grafana/faro-web-sdk
- **Grafana Cloud**: https://grafana.com/products/cloud/

---

**마지막 업데이트**: 2026-02-01
