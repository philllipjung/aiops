# OpenTracing Quickstart (Java/Quarkus)

## 버전
**v3.2.5**

## 개요

Java Quarkus 기반 OpenTracing Quickstart 예제 프로젝트입니다. OpenTelemetry을 사용한 분산 추적을 구현합니다.

## 기술 스택

- **Java**
- **Quarkus** Framework
- **OpenTelemetry** Java Agent
- **Maven** 빌드 도구

## 프로젝트 구조

```
3.2.5/
├── pom.xml          # Maven 설정
├── mvnw             # Maven Wrapper
└── src/             # 소스 코드
```

## 빌드 및 실행

```bash
cd /root/aiops/3.2.5

# 빌드
./mvnw clean install

# 실행
java -jar target/quarkus-app.jar
```

## 주요 기능

- OpenTracing API 사용
- 분산 추적 데모
- Quarkus 확장

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
