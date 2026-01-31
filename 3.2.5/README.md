# Transport Fetch

## 버전
**v3.2.5**

## 개요

Transport Fetch는 Faro Web SDK의 Fetch API 기반 데이터 전송 플러그인입니다. 웹 애플리케이션에서 수집된 데이터를 서버로 전송하는 기능을 담당합니다.

## 주요 기능

- ✅ **Fetch API 기반 전송**: 모던 Fetch API 사용
- ✅ **비동기 전송**: 백그라운드에서 데이터 전송
- ✅ **배치 처리**: 여러 이벤트를 한 번에 전송
- ✅ **재시도 메커니즘**: 실패 시 자동 재시도
- ✅ **압축 지원**: 데이터 압축으로 전송 최적화

## 사용 방법

### 설치

```bash
npm install @grafana/transport-fetch
```

### 설정

```typescript
import { TransportFetch } from '@grafana/transport-fetch';

const transport = new TransportFetch({
  url: 'http://localhost:12345/collect',
  apiKey: 'your-api-key',
  batchSize: 50,
  flushInterval: 5000,
});
```

### Faro SDK와 통합

```typescript
import { Faro } from '@grafana/faro-web-sdk';
import { TransportFetch } from '@grafana/transport-fetch';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  transports: [new TransportFetch()],
});
```

## API

### 생성자 옵션

| 옵션 | 타입 | 기본값 | 설명 |
|------|------|--------|------|
| `url` | string | - | 수집 서버 URL |
| `apiKey` | string | - | API 인증 키 |
| `batchSize` | number | 50 | 배치 크기 |
| `flushInterval` | number | 5000 | 플러시 간격 (ms) |
| `compression` | boolean | false | 압축 사용 여부 |

### 메서드

| 메서드 | 설명 |
|--------|------|
| `send(events)` | 이벤트 전송 |
| `flush()` | 즉시 플러시 |
| `pause()` | 전송 일시 중지 |
| `resume()` | 전송 재개 |

## 예시

### 커스텀 전송

```typescript
const transport = new TransportFetch({
  url: 'https://collect.example.com',
  apiKey: 'your-key',
  batchSize: 100,
  flushInterval: 10000,
});

// 이벤트 전송
transport.send([
  { type: 'log', message: 'Hello' },
  { type: 'error', message: 'Error' }
]);
```

### 에러 핸들링

```typescript
const transport = new TransportFetch({
  url: 'http://localhost:12345/collect',
  onError: (error) => {
    console.error('Transport error:', error);
  },
});
```

## 브라우저 지원

- Chrome 90+
- Firefox 88+
- Safari 14+
- Edge 90+

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops
- **Faro Web SDK**: https://github.com/grafana/faro-web-sdk

---

**마지막 업데이트**: 2026-02-01
