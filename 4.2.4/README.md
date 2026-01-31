# Console Instrumentation

## 버전
**v4.2.4**

## 개요

Console Instrumentation은 브라우저 콘솔 로그 출력을 자동으로 수집하고 Faro를 통해 서버로 전송하는 플러그인입니다. 디버깅 및 모니터링을 위해 콘솔 로그를 중앙 집중화합니다.

## 주요 기능

- ✅ **자동 콘솔 수집**: console.log, console.warn, console.error 자동 수집
- ✅ **스택 추적**: 콘솔 호출 위치 추적
- ✅ **로그 레벨 구분**: info, warn, error 레벨 지원
- ✅ **포맷팅 보존**: 콘솔 포맷 유지
- ✅ **필터링**: 특정 로그 필터링 지원

## 사용 방법

### 설치

```bash
npm install @grafana/console-instr
```

### 설정

```typescript
import { ConsoleInstrumentation } from '@grafana/console-instr';

const consoleInstr = new ConsoleInstrumentation({
  captureAll: true,
  captureLevels: ['log', 'warn', 'error'],
});
```

### Faro SDK와 통합

```typescript
import { Faro } from '@grafana/faro-web-sdk';
import { ConsoleInstrumentation } from '@grafana/console-instr';

const faro = Faro.init({
  url: 'http://localhost:12345/collect',
  instrumentations: [
    new ConsoleInstrumentation(),
  ],
});
```

## API

### 생성자 옵션

| 옵션 | 타입 | 기본값 | 설명 |
|------|------|--------|------|
| `captureAll` | boolean | false | 모든 콘솔 출력 수집 여부 |
| `captureLevels` | string[] | ['error', 'warn'] | 수집할 로그 레벨 |
| `disableStackTrace` | boolean | false | 스택 추적 비활성화 |
| `maxStackTraceLength` | number | 50 | 스택 추적 최대 길이 |

### 지원되는 콘솔 메서드

| 메서드 | 로그 레벨 | 설명 |
|--------|----------|------|
| `console.log()` | info | 일반 정보 |
| `console.info()` | info | 정보 |
| `console.warn()` | warn | 경고 |
| `console.error()` | error | 오러 |
| `console.debug()` | debug | 디버그 |
| `console.trace()` | trace | 추적 |

## 예시

### 기본 사용

```typescript
const consoleInstr = new ConsoleInstrumentation({
  captureAll: true,
});

// 모든 콘솔 출력이 자동으로 수집됨
console.log('Application started');
console.warn('High memory usage');
console.error('Failed to load data');
```

### 특정 레벨만 수집

```typescript
const consoleInstr = new ConsoleInstrumentation({
  captureLevels: ['error', 'warn'], // error와 warn만 수집
});
```

### 스택 추적 설정

```typescript
const consoleInstr = new ConsoleInstrumentation({
  disableStackTrace: false,
  maxStackTraceLength: 100, // 최대 100줄
});
```

## 수집되는 데이터

### 콘솔 로그 이벤트 구조

```json
{
  "type": "console",
  "level": "info",
  "message": "Application started",
  "timestamp": 1234567890,
  "stackTrace": [
    "at Object.start (/app.js:25:10)",
    "at init (/app.js:10:5)"
  ],
  "args": ["Application started", { data: "value" }]
}
```

### 로그 레벨별 예시

```typescript
// Info 레벨
console.log('User logged in', { userId: 123 });

// Warn 레벨
console.warn('API rate limit approaching', { remaining: 100 });

// Error 레벨
console.error('Failed to fetch data', new Error('Network error'));
```

## 고급 설정

### 커스텀 필터

```typescript
const consoleInstr = new ConsoleInstrumentation({
  filter: (level, args) => {
    // 민감한 정보 필터링
    const message = args[0];
    if (typeof message === 'string' && message.includes('password')) {
      return false;
    }
    return true;
  },
});
```

### 커스텀 포맷터

```typescript
const consoleInstr = new ConsoleInstrumentation({
  format: (level, args) => {
    return {
      customLevel: level.toUpperCase(),
      customMessage: args.join(' '),
      timestamp: Date.now(),
    };
  },
});
```

## 주의사항

### 성능 고려사항

- 과도한 콘솔 출력은 성능에 영향을 줄 수 있습니다
- `captureAll: true` 사용 시 주의 필요
- 프로덕션에서는 `captureLevels`를 제한하는 것 권장

### 민감한 정보

- 콘솔 로그에 민감한 정보가 포함될 수 있습니다
- 필터 기능을 사용하여 민감한 데이터 제거 필요

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops
- **Faro Web SDK**: https://github.com/grafana/faro-web-sdk

---

**마지막 업데이트**: 2026-02-01
