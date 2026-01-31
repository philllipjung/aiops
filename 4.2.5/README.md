# Python Message Tracing

## 버전
**v4.2.5**

## 개요

OpenTelemetry을 사용한 메시지 추적 예제입니다. Producer/Consumer 패턴과 추적을 보여줍니다.

## 프로젝트 구조

```
4.2.5/
├── consumer.py      # 메시지 소비자
├── producer.py      # 메시지 생산자
└── tracing.py       # 추적 유틸리티
```

## 실행

```bash
cd /root/aiops/4.2.5

# Producer 실행
python producer.py

# Consumer 실행 (다른 터미널)
python consumer.py
```

## 주요 기능

- 메시지 Producer/Consumer 패턴
- OpenTelemetry 추적
- 분산 시스템 계측

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
