# Grafana Dashboard Demo

## 버전
**v3.3.3**

## 개요

Grafana 대시보드와 설정 예제입니다. Docker Compose로 실행됩니다.

## 프로젝트 구조

```
3.3.3/
├── docker-compose.yml              # Docker Compose
├── grafana-dashboard.json          # Grafana 대시보드
├── configs/                        # 설정 파일
└── consumer/                      # 컨슈머 서비스
```

## 실행

```bash
cd /root/aiops/3.3.3

# 시작
docker-compose up -d

# Grafana 접속
# http://localhost:3000
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
