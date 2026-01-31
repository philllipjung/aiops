# Spring Boot Distributed Tracing

## 버전
**v3.7.2**

## 개요

Spring Boot 3와 OpenTelemetry, Jaeger를 사용한 분산 추적 예제입니다.

## 기술 스택

- **Java**
- **Spring Boot 3**
- **OpenTelemetry** Java
- **Jaeger** Tracing

## 프로젝트 구조

```
3.7.2/
├── pom.xml          # Maven 설정
└── src/             # 소스 코드
```

## 빌드 및 실행

```bash
cd /root/aiops/3.7.2

# 빌드
mvn clean install

# 실행
java -jar target/distributed-service.jar
```

## 주요 기능

- Spring Boot 3 통합
- OpenTelemetry 자동 계측
- Jaeger 추적 시각화

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
