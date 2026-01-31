# AIOps Agent

## 버전
**v10.7.5.1**

## 개요

AIOps Agent는 OpenSearch와 통합하여 애플리케이션 로그, 메트릭, 이벤트를 수집하고 분석하는 에이전트입니다. Fluent Bit 기반 로그 수집과 OpenSearch 기반 데이터 저장을 제공합니다.

## 주요 기능

- ✅ **로그 수집**: Fluent Bit를 통한 실시간 로그 수집
- ✅ **메트릭 수집**: 시스템 및 애플리케이션 메트릭
- ✅ **OpenSearch 통합**: 수집 데이터를 OpenSearch로 전송
- ✅ **에이전트 관리**: 다중 에이전트 지원
- ✅ **Docker 지원**: 컨테이너화된 배포

## 디렉토리 구조

```
10.7.5.1/
├── agents/           # 수집 에이전트 설정
├── opensearch/       # OpenSearch 설정 및 대시보드
├── img/             # 이미지 및 아이콘
├── scripts/         # 배포 및 관리 스크립트
├── Dockerfile       # Docker 이미지 빌드
└── docker-compose.yml # Docker Compose 설정
```

## 설치

### Docker Compose로 실행

```bash
cd /root/aiops/10.7.5.1

# 전체 스택 시작 (OpenSearch + Agent)
docker-compose up -d

# 로그 확인
docker-compose logs -f

# 상태 확인
docker-compose ps
```

### 개별 서비스 시작

```bash
# OpenSearch만 시작
docker-compose up -d opensearch

# Agent만 시작
docker-compose up -d agent
```

## 설정

### OpenSearch 설정

```yaml
# docker-compose.yml
opensearch:
  image: opensearchproject/opensearch:latest
  ports:
    - "9200:9200"
  environment:
    - discovery.type=single-node
    - DISABLE_SECURITY_PLUGIN=true
```

### Agent 설정

```yaml
# docker-compose.yml
agent:
  image: fluent/fluent-bit:latest
  volumes:
    - ./agents:/fluent-bit/etc
```

## 사용 방법

### OpenSearch 대시보드 접속

```
URL: http://localhost:5601
```

### 데이터 수집 확인

```bash
# 인덱스 목록 확인
curl -X GET "localhost:9200/_cat/indices?v"

# 로그 검색
curl -X GET "localhost:9200/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": { "match_all": {} }
}'
```

## 관리 명령어

```bash
# 전체 중지
docker-compose down

# 재시작
docker-compose restart

# 로그 모니터링
docker-compose logs -f agent

# OpenSearch 상태 확인
curl -X GET "localhost:9200/_cluster/health?pretty"
```

## 에이전트 구성

### 로그 수집 설정

```ini
# agents/fluent-bit.conf
[SERVICE]
    Flush         1
    Daemon        off
    Log_Level     info

[INPUT]
    Name              tail
    Path              /var/log/containers/*.log
    Parser            docker
    Tag               kube.*

[OUTPUT]
    Name              opensearch
    Match             *
    Host              opensearch
    Port              9200
    Index             logs
```

## 관련 링크

- **OpenSearch**: https://opensearch.org/
- **Fluent Bit**: https://docs.fluentbit.io/
- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
