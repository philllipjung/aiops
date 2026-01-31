# Transport XHR Instrumentation

## 버전
**v3.4.1**

## 개요

Transport XHR Instrumentation은 XMLHttpRequest(XHR) 호출을 자동으로 계측하고 모니터링하는 플러그인입니다. 모든 XHR 요청을 추적하여 성능 메트릭과 오류 정보를 수집합니다.

## 주요 기능

- ✅ **자동 XHR 계측**: 코드 수정 없이 자동 추적
- ✅ **요청/응답 로깅**: 모든 XHR 요청과 응답 기록
- ✅ **성능 측정**: 요청 시간, 크기 등의 메트릭 수집
- ✅ **오러 추적**: 실패한 요청 자동 감지
- ✅ **헤더 수집**: 요청/응답 헤더 정보 수집

## 사용 방법

### 설치

```bash
npm install @grafana/transport-xhr-instr
```

### 설정

```typescript
import { XhrInstrumentation } from '@grafana/transport-xhr-instr';

const xhrInstr = new XhrInstrumentation({
  captureHeaders: true,
  captureBody: true,
  propagateTraceContext: true,
});
```

### Faro SDK와 통합

```typescript
import { Faro } from '@grafana/faro-web-sdk';
import { XhrInstrumentation } from '@grafana/transport-xhr-instr';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  instrumentations: [
    new XhrInstrumentation(),
  ],
});
```

## API

### 생성자 옵션

| 옵션 | 타입 | 기본값 | 설명 |
|------|------|--------|------|
| `captureHeaders` | boolean | false | 요청/응답 헤더 수집 여부 |
| `captureBody` | boolean | false | 요청 바디 수집 여부 |
| `propagateTraceContext` | boolean | false | 추적 컨텍스트 전파 여부 |
| `ignoreUrls` | RegExp[] | [] | 무시할 URL 패턴 |

### 수집되는 데이터

| 필드 | 타입 | 설명 |
|------|------|------|
| `url` | string | 요청 URL |
| `method` | string | HTTP 메서드 |
| `status` | number | HTTP 상태 코드 |
| `duration` | number | 요청 시간 (ms) |
| `requestHeaders` | object | 요청 헤더 |
| `responseHeaders` | object | 응답 헤더 |
| `requestBody` | any | 요청 바디 |
| `responseBody` | any | 응답 바디 |

## 예시

### 기본 사용

```typescript
import { XhrInstrumentation } from '@grafana/transport-xhr-instr';

const xhrInstr = new XhrInstrumentation({
  captureHeaders: true,
});

// XHR 호출은 자동으로 추적됨
const xhr = new XMLHttpRequest();
xhr.open('GET', 'https://api.example.com/data');
xhr.send();
```

### URL 필터링

```typescript
const xhrInstr = new XhrInstrumentation({
  ignoreUrls: [
    /https:\/\/analytics\.example\.com/,
    /https:\/\/cdn\.example\.com/,
  ],
});
```

### 커스텀 속성 추가

```typescript
const xhrInstr = new XhrInstrumentation({
  modifyXhr: (xhr) => {
    xhr.setRequestHeader('X-Custom-Header', 'value');
  },
});
```

## 수집되는 이벤트

### 성공한 요청

```json
{
  "type": "xhr",
  "url": "https://api.example.com/data",
  "method": "GET",
  "status": 200,
  "duration": 145,
  "timestamp": 1234567890
}
```

### 실패한 요청

```json
{
  "type": "xhr",
  "url": "https://api.example.com/error",
  "method": "POST",
  "status": 500,
  "duration": 89,
  "error": "Internal Server Error"
}
```

## 고급 설정

### 추적 컨텍스트 전파

```typescript
const xhrInstr = new XhrInstrumentation({
  propagateTraceContext: true,
  traceContextHeaderName: 'traceparent',
});
```

### 바디 크기 제한

```typescript
const xhrInstr = new XhrInstrumentation({
  captureBody: true,
  maxBodySize: 1024, // 1KB 제한
});
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops
- **Faro Web SDK**: https://github.com/grafana/faro-web-sdk

---

**마지막 업데이트**: 2026-02-01
