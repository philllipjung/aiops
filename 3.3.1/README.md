# Hotrod Go Application

## 버전
**v3.3.1**

## 개요

Pyroscope Hotrod Golang 예제 애플리케이션입니다. Docker 기반 데모 애플리케이션을 포함합니다.

## 기술 스택

- **Go**
- **Docker**
- **Make** 빌드 시스템

## 프로젝트 구조

```
3.3.1/
├── Makefile        # 빌드 설정
└── demo-app/       # 데모 애플리케이션
```

## 빌드 및 실행

```bash
cd /root/aiops/3.3.1

# 빌드
make build

# 실행
docker run -p 8080:8080 demo-app
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
