# Faro Web SDK

## 버전
**v9.4.5.1**

## 개요

Grafana Faro Web SDK v9.4.5.1은 최신 웹 observability를 위한 JavaScript SDK입니다. AI 기반 모니터링, 고급 분석, 그리고 완전한 OpenTelemetry 지원을 제공합니다.

## v9.x 시리즈 혁신 기능

- ✅ **AI-Powered Insights**: AI 기반 이상 탐지
- ✅ **Full OpenTelemetry Support**: OpenTelemetry 완전 지원
- ✅ **Real User Monitoring (RUM)**: 실제 사용자 모니터링
- ✅ **Session Replay**: 세션 재생 (선택적)
- ✅ **Performance Profiling**: 성능 프로파일링
- ✅ **Multi-tenant Support**: 멀티 테넌트 지원

## 설치

```bash
npm install @grafana/faro-web-sdk@9.4.5.1
```

## 빠른 시작

```typescript
import { Faro } from '@grafana/faro-web-sdk';
import { WebConsole } from '@grafana/faro-web-sdk';
import { TracingInstrumentation } from '@grafana/faro-web-sdk';
import { WebVitalsInstrumentation } from '@grafana/faro-web-sdk';
import { SessionRecording } from '@grafana/faro-web-sdk';

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
    new SessionRecording({
      captureConsole: true,
      captureNetwork: true,
    }),
  ],
});
```

## 주요 변경사항 (v9.x)

### 1. AI-Powered Anomaly Detection

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  ai: {
    enableAnomalyDetection: true,
    anomalyThreshold: 0.95,
    // 이상 징후 자동 탐지
    autoDetect: {
      performance: true,
      errors: true,
      traffic: true,
    },
  },
});
```

### 2. Session Replay

```typescript
import { SessionRecording } from '@grafana/faro-web-sdk';

const sessionRecording = new SessionRecording({
  // 세션 녹화 활성화
  enabled: true,
  // 녹화 빈도 (10초마다 스냅샷)
  snapshotInterval: 10000,
  // DOM 변경 캡처
  captureDom: true,
  // 네트워크 요청 캡처
  captureNetwork: true,
  // 콘솔 로그 캡처
  captureConsole: true,
  // 민감한 정보 마스킹
  privacyOptions: {
    maskInputs: true,
    maskText: ['password', 'secret'],
  },
});
```

### 3. Performance Profiling

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  profiling: {
    // JavaScript 실행 프로파일링
    enableJSProfiling: true,
    // 메모리 프로파일링
    enableMemoryProfiling: true,
    // 렌더링 성능 추적
    enableRenderProfiling: true,
    // 프로파일링 샘플링 레이트
    sampleRate: 0.01, // 1%
  },
});
```

### 4. Multi-tenant Support

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'my-app',
    // 테넌트 ID
    tenantId: 'tenant-123',
  },
  // 테넌트별 데이터 격리
  multiTenant: {
    enabled: true,
    isolateData: true,
    crossTenantReporting: false,
  },
});
```

### 5. Real User Monitoring (RUM)

```typescript
import { RUMInstrumentation } from '@grafana/faro-web-sdk';

const rum = new RUMInstrumentation({
  // Core Web Vitals
  coreWebVitals: true,
  // 사용자 경험 메트릭
  userExperienceMetrics: {
    interactionDelay: true,
    firstInputDelay: true,
    totalBlockingTime: true,
  },
  // 커스텀 RUM 메트릭
  customMetrics: [
    'feature.usage',
    'api.latency',
    'conversion.rate',
  ],
});
```

## API

### 핵심 메서드

| 메서드 | 설명 |
|--------|------|
| `init(config)` | Faro SDK 초기화 |
| `api.pushError(error)` | 에러 전송 |
| `api.pushEvent(name, attrs)` | 이벤트 전송 |
| `api.startRecording()` | 세션 녹화 시작 |
| `api.stopRecording()` | 세션 녹화 중지 |
| `api.takeSnapshot()` | 현재 상태 스냅샷 |
| `api.getProfile()` | 프로필 데이터 가져오기 |

## 예시

### AI 기반 이상 탐지

```typescript
// 자동 이상 탐지 활성화
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  ai: {
    enableAnomalyDetection: true,
    // 사용자 정의 임계값
    customThresholds: {
      errorRate: 0.05,      // 5% 이상 시 알림
      latency: 2000,         // 2초 이상 시 알림
      crashRate: 0.01,       // 1% 이상 시 알림
    },
  },
});

// AI 인사이트 받기
faro.api.getAIInsights().then(insights => {
  console.log('Anomalies detected:', insights.anomalies);
  console.log('Recommendations:', insights.recommendations);
});
```

### 세션 재생

```typescript
// 세션 녹화 제어
faro.api.startRecording();

// 사용자가 특정 액션을 수행할 때 스냅샷
document.getElementById('checkout').addEventListener('click', () => {
  faro.api.takeSnapshot({
    label: 'checkout-start',
    metadata: {
      cartValue: 100,
      itemCount: 3,
    },
  });
});

// 녹화 중지
faro.api.stopRecording();
```

### 성능 프로파일링

```typescript
// CPU 프로파일 시작
const profiler = faro.api.startProfiler('critical-operation');

// 분석할 작업 수행
performCriticalOperation();

// 프로파일 종료 및 전송
profiler.stop().then(profile => {
  console.log('Profile duration:', profile.duration);
  console.log('Memory usage:', profile.memory);
});
```

## v8.x에서 v9.4.5.1로 마이그레이션

### 주요 변경사항

```typescript
// v8.x
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

// v9.4.5.1 - 새로운 기능 추가
import { Faro } from '@grafana/faro-web-sdk';
import { SessionRecording } from '@grafana/faro-web-sdk';
import { RUMInstrumentation } from '@grafana/faro-web-sdk';

const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  app: {
    name: 'my-app',
    version: '1.0.0',
    tenantId: 'tenant-123', // 멀티 테넌트
  },
  // AI 기능
  ai: {
    enableAnomalyDetection: true,
  },
  // 프로파일링
  profiling: {
    enableJSProfiling: true,
  },
  instrumentations: [
    new TracingInstrumentation(),
    new SessionRecording(),    // 새로운 기능
    new RUMInstrumentation(),  // 새로운 기능
  ],
});
```

## Advanced Features

### OpenTelemetry 완전 지원

```typescript
import { Faro } from '@grafana/faro-web-sdk';
import { OTelBridge } from '@grafana/faro-web-sdk';

// OpenTelemetry SDK와 통합
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  experimentalFeatures: {
    openTelemetryBridge: true,
  },
});

// OpenTelemetry API 사용
const bridge = new OTelBridge(faro);
bridge.registerOTelInstrumentations([
  new OTelWebInstrumentation(),
]);
```

### 커스텀 AI 모델

```typescript
const faro = Faro.init({
  url: 'https://collector.example.com/collect',
  ai: {
    enableAnomalyDetection: true,
    // 커스텀 모델 설정
    customModels: {
      errorPrediction: {
        type: 'neural-network',
        threshold: 0.9,
      },
      performanceForecast: {
        type: 'time-series',
        windowSize: 3600, // 1시간
      },
    },
  },
});
```

## 타입스크립트

```typescript
import { Faro, FaroAPI } from '@grafana/faro-web-sdk';

interface AIInsights {
  anomalies: Anomaly[];
  recommendations: Recommendation[];
  confidence: number;
}

interface SessionRecordingOptions {
  captureDom?: boolean;
  captureNetwork?: boolean;
  privacyOptions?: PrivacyOptions;
}

declare module '@grafana/faro-web-sdk' {
  export interface FaroAPIExtensions {
    getAIInsights(): Promise<AIInsights>;
    startRecording(options?: SessionRecordingOptions): void;
    stopRecording(): void;
  }
}

const faro: FaroAPI = Faro.init({
  // ...
});

// 타입 안전한 API 사용
faro.api.getAIInsights().then((insights: AIInsights) => {
  console.log('Confidence:', insights.confidence);
});
```

## 브라우저 지원

- Chrome 120+
- Firefox 110+
- Safari 17+
- Edge 120+
- Mobile browsers (iOS Safari 17+, Chrome Android 120+)

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops
- **Grafana Faro**: https://github.com/grafana/faro-web-sdk
- **OpenTelemetry**: https://opentelemetry.io/
- **Grafana Cloud**: https://grafana.com/products/cloud/

---

**마지막 업데이트**: 2026-02-01
