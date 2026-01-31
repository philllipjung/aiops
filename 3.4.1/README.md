# Solace Messaging with OpenTelemetry

## 버전
**v3.4.1**

## 개요

Solace 메시징과 OpenTelemetry 통합을 위한 Docker Compose 설정입니다. Jaeger 추적을 포함한 분산 메시징 예제입니다.

## 주요 구성 요소

- **Jaeger**: 분산 추적 시스템
- **Solace**: 메시지 브로커
- **OpenTelemetry Collector**: 메트릭/추적 수집기

## 프로젝트 구조

```
3.4.1/
├── docker-compose.yaml              # Docker Compose 설정
├── otel-collector-config.yaml       # OTel Collector 설정
├── k8s/                             # Kubernetes 매니페스트
├── manual-instrumentaion/           # 수동 계측 예제
└── Distributed Trace Setup.postman_collection.json
```

## 실행

```bash
cd /root/aiops/3.4.1

# 전체 스택 시작
docker-compose up -d

# 로그 확인
docker-compose logs -f

# 중지
docker-compose down
```

## 주요 기능

- Solace JMS 메시징
- OpenTelemetry 추적
- Jaeger 시각화

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
