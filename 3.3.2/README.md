# OpenTelemetry Playground (Go)

## 버전
**v3.3.2**

## 개요

Go 기반 OpenTelemetry 플레이그라운드입니다. 다양한 OpenTelemetry 계측 예제를 포함합니다.

## 기술 스택

- **Go 1.18**
- **Fiber** Web Framework
- **OpenTelemetry Go**
- **Google Cloud Pub/Sub**

## 프로젝트 구조

```
3.3.2/
├── go.mod          # Go 모듈 정의
├── api-a/          # API 서비스 A
├── api-b/          # API 서비스 B
├── fib/            # Fibonacci 서비스
└── util/           # 유틸리티
```

## 설치 및 실행

```bash
cd /root/aiops/3.3.2

# 의존성 설치
go mod download

# 실행
go run main.go
```

## 주요 기능

- OpenTelemetry 계측 예제
- Fiber 웹 프레임워크 통합
- 분산 추적 데모

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
