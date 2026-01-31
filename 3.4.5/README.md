# Transport XHR Instrumentation

## 버전
**v3.4.5**

## 개요

Transport XHR Instrumentation v3.4.5는 XMLHttpRequest 계측 플러그인의 안정화 버전입니다.

## 변경사항

- 안정성 강화
- 메모리 누수 수정

## 설치

```bash
npm install @grafana/transport-xhr-instr@3.4.5
```

## 사용

```typescript
import { XhrInstrumentation } from '@grafana/transport-xhr-instr';

const xhrInstr = new XhrInstrumentation();
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
