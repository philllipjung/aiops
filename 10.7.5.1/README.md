# OpenSearch MCP Server

## 버전
**v10.7.5.1**

## 개요

OpenSearch MCP (Model Context Protocol) 서버입니다. Docker Compose로 OpenSearch와 대시보드를 실행합니다.

## 주요 구성 요소

- **OpenSearch**: 검색 및 분석 엔진
- **OpenSearch Dashboards**: 시각화 대시보드
- **MCP Server**: Model Context Protocol 서버

## 실행

```bash
cd /root/aiops/10.7.5.1

# 전체 스택 시작
docker-compose up -d

# 로그 확인
docker-compose logs -f

# OpenSearch 접속
curl http://localhost:9200

# 대시보드 접속
# http://localhost:5601
```

## 중지

```bash
docker-compose down
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
