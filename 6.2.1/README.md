# Faro Web SDK

## 버전
**v6.2.1**

## 개요

Grafana Faro Web SDK v6.2.1은 웹 observability를 위한 차세대 JavaScript SDK입니다. 이 버전은 향상된 tracing, 메트릭 수집, and 개선된 성능을 제공합니다.

## v6.x 시리즈 새로운 기능

- ✅ **OpenTelemetry 통합**: OpenTelemetry 표준 지원
- ✅ **고급 Tracing**: 분산 추적 지원
- ✅ **메트릭 수집**: 커스텀 메트릭 수집
- ✅ **개선된 성능**: 번들 크기 최적화
- ✅ **Experimental Web Assembly**: WebAssembly 지원 (실험적)

## 설치

```bash
npm install @grafana/faro-web-sdk@6.2.1
```

## 빠른 시작

```typescript
import { Faro } from '@grafana/faro-web-sdk';
import { WebConsole } from '@grafana/faro-web-sdk';
import { TracingInstrumentation } from '@grafana/faro-web-sdk';
import { MetricsInstrumentation } from '@grafana/faro-web-sdk';

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
    new MetricsInstrumentation(),
  ],
});
```

## 주요 변경사항 (v6.x)

### 1. OpenTelemetry 호환

```typescript
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  experimentalFeatures: {
    opentelemetry: true,
  },
});
```

### 2. 고급 Tracing

```typescript
import { TracingInstrumentation } from '@grafana/faro-web-sdk';

const tracing = new TracingInstrumentation({
  enablePropagation: true,
  enableNetworkTracking: true,
  experimentalFeatures: {
    enableLongTask: true,
    enableLayoutShift: true,
  },
});
```

### 3. 메트릭 수집

```typescript
import { MetricsInstrumentation } from '@grafana/faro-web-sdk';

const metrics = new MetricsInstrumentation({
  captureMetrics: true,
  customMetrics: {
    'app.startup.time': () => performance.now(),
    'app.memory.used': () => performance.memory?.usedJSHeapSize,
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
| `api.pushMeasurement(name, value)` | 커스텀 메트릭 전송 |
| `api.createSpan(name)` | 수동 span 생성 |
| `api.setMeta(meta)` | 메타데이터 설정 |

## 예시

### 커스텀 Tracing

```typescript
// 수동 span 생성
const span = faro.api.createSpan('custom-operation');

// 하위 작업 추적
span.startChild('database-query');
// ... DB 작업
span.endChild();

span.end();
```

### 메트릭 전송

```typescript
// 커스텀 메트릭 기록
faro.api.pushMeasurement('api.response.time', 145);

// 여러 속성과 함께
faro.api.pushMeasurement('feature.usage', 1, {
  feature: 'checkout',
  userId: '12345',
  plan: 'premium',
});
```

### 세션 관리

```typescript
// 세션 속성 업데이트
faro.api.setSession({
  userId: '12345',
  userRole: 'admin',
  plan: 'premium',
});

// 세션 종료
faro.api.endSession();
```

## v5.x에서 v6.2.1로 마이그레이션

### 변경사항

```typescript
// v5.x
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'my-app',
  },
});

// v6.2.1 - OpenTelemetry 지원 추가
import { Faro } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'my-app',
    environment: 'production',
  },
  experimentalFeatures: {
    opentelemetry: true,
  },
  instrumentations: [
    new WebConsole(),
    new TracingInstrumentation(),
    new MetricsInstrumentation(), // 새로운 기능
  ],
});
```

### 업데이트된 API

```typescript
// v5.x
faro.api.setUser({ id: '123' });

// v6.2.1 - 세션 기반 API
faro.api.setSession({ userId: '123' });
```

## 타입스크립트

```typescript
import { Faro, FaroAPI, Meta, Session } from '@grafana/faro-web-sdk';

interface CustomMeta extends Meta {
  userId?: string;
  plan?: 'free' | 'premium';
}

interface CustomSession extends Session {
  userId?: string;
  permissions?: string[];
}

const faro: Faro<CustomMeta, CustomSession> = Faro.init({
  // ...
});

faro.api.setMeta({
  userId: '12345',
  plan: 'premium',
});

faro.api.setSession({
  userId: '12345',
  permissions: ['read', 'write'],
});
```

## Experimental Features

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  experimentalFeatures: {
    opentelemetry: true,           // OpenTelemetry 호환
    longTask: true,                // Long Task API
    layoutShift: true,             // Layout Shift 추적
    webAssembly: true,             // WebAssembly 지원
    fmp: true,                     // First Meaningful Paint
  },
});
```

## 성능 최적화

```typescript
// 필요한 기능만 활성화
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: { name: 'my-app' },
  instrumentations: [
    // 필수 인스트루먼트이션만 사용
    new TracingInstrumentation(),
  ],
  // 불필요한 기능 비활성화
  disableConsole: true,
  disableWebVitals: false,
});
```

## 브라우저 지원

- Chrome 100+
- Firefox 95+
- Safari 15+
- Edge 100+

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops
- **Grafana Faro**: https://github.com/grafana/faro-web-sdk
- **OpenTelemetry**: https://opentelemetry.io/

---

**마지막 업데이트**: 2026-02-01
