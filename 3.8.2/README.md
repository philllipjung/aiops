# OpenTelemetry Java Custom Instrumentation

## 버전
**v3.8.2**

## 개요

OpenTelemetry Java 커스텀 계측 예제입니다. Docker 컨테이너로 실행됩니다.

## Dockerfile

```dockerfile
FROM maven:3.8.7-openjdk-18 as build
COPY simple-java /home/app/simple-java
COPY opentelemetry-custom-instrumentation /home/app/opentelemetry-custom-instrumentation
```

## 빌드 및 실행

```bash
cd /root/aiops/3.8.2

# Docker 이미지 빌드
docker build -t otel-java-instr .

# 실행
docker run otel-java-instr
```

## 주요 기능

- OpenTelemetry Java Agent
- 커스텀 계측
- Docker 컨테이너화

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
