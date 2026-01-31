# Metadata Instrumentation

## 버전
**v4.4.4**

## 개요

Metadata Instrumentation v4.4.4는 웹 애플리케이션의 메타데이터를 자동으로 수집하는 플러그인입니다.

## 주요 기능

- 환경 정보 자동 수집
- 사용자 에이전트 정보
- 화면 해상도 정보
- 브라우저 정보

## 설치

```bash
npm install @grafana/metadata-instr@4.4.4
```

## 사용

```typescript
import { MetadataInstrumentation } from '@grafana/metadata-instr';

const metaInstr = new MetadataInstrumentation();
```

## 수집되는 메타데이터

- 브라우저 버전
- 운영체제
- 화면 크기
- 사용자 언어
- 타임존

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
