# AIOps 소스 레파지토리

### 도서 구입 정보

아래의 URL에서 도서 구입이 가능합니다.

| 판매처 | URL |
|------|------|
| **교보문고** | https://www.kyobobook.co.kr/product/detailViewKor.laf?barcode=9791124205174 |
| **도서11번가** | https://www.11st.co.kr/products/9075271629 |
| **알라딘** | https://www.aladin.co.kr/shop/wproduct.aspx?ISBN=9791124205174 |
| **예스이십사** | https://www.yes24.com/product/goods/176919469 |

## 개요 (Overview)

이 저장소는 **AIOps(인공지능 운영)** 관련 다양한 프로젝트와 예제 코드를 포함한 컬렉션입니다. 모니터링, 로그 수집, 분산 추적, 메시징, 컨테이너 오케스트레이션 등 다양한 DevOps 및 AIOps 기술을 다룹니다.

### 주요 정보

| 항목 | 설명 |
|------|------|
| **저장소** | https://github.com/philllipjung/aiops.git |
| **목적** | AIOps 기술 실습 및 예제 |
| **형태** | Multi-project Repository |

---

## 디렉토리 구조

```
/root/aiops/
├── 1.3.2/           # Grafana Faro Web SDK (유일한 Faro 프로젝트)
├── 1.3.3/           # Pyroscope Hotrod (Go)
├── 1.3.5/           # Istio Bookinfo Demo
├── 3.2.5/           # OpenTracing Quickstart (Java/Quarkus)
├── 3.3.1/           # Hotrod Go Application
├── 3.3.2/           # OpenTelemetry Playground (Go)
├── 3.3.3/           # Grafana Dashboard Demo
├── 3.4.1/           # Solace Messaging with OpenTelemetry
├── 3.4.2/           # TIBCO JMS Messaging
├── 3.4.3/           # Python Microservices Demo
├── 3.4.5/           # Trading Example
├── 3.7.1/           # Spring Boot Service
├── 3.7.2/           # Spring Boot Distributed Tracing
├── 3.7.4/           # Gradle Java Project
├── 3.8.1/           # ByteBuddy Java Agent
├── 3.8.2/           # OpenTelemetry Java Custom Instrumentation
├── 4.2.4/           # Flask OpenTelemetry Example (Python)
├── 4.2.5/           # Python Message Tracing
├── 4.2.9/           # Jaeger Python Example
├── 4.4.4/           # Gradle Build Project
├── 5.3.1/           # Golang Tracing Demo
├── 5.3.12/          # Helm Chart
├── 5.3.13/          # Kubernetes Configuration
├── 6.2.1/           # Hello World Demo
├── 6.6.3/           # Kubernetes Helm Setup
├── 6.7.1/           # Cilium Minikube Demo
├── 8.4.2/           # Docker Compose Project
├── 8.4.4/           # Java Instrumentation Workshop
├── 9.4.5.1/         # Java/Maven Project
├── 9.4.5.2/         # Gradle Java Project
├── 9.4.5.3/         # Maven Java Project
├── 9.4.6/           # Maven Java Project
├── 9.4.7/           # Examples
├── 10.3.2.2/        # Kubernetes Deployment
├── 10.3.2.3/        # Helm Chart
├── 10.7.3/          # RAG Documentation
├── 10.7.5.1/        # OpenSearch MCP Server
├── 10.7.5.4/        # MCP Server
├── 10.7.5.5/        # Python MCP Application
├── 10.7.5.6/        # MCP Slack Bot
├── 10.7.5.8/        # MCP Documentation
└── README.md        # 이 파일
```

---

## 주요 카테고리

### 1. 웹 모니터링 (1.3.2)

**Grafana Faro Web SDK** - 유일하게 Faro를 사용하는 프로젝트

**위치**: `/root/aiops/1.3.2/`

웹 애플리케이션 모니터링을 위한 JavaScript SDK입니다.

**주요 기능**:
- 자동 오류 추적
- 사용자 세션 추적
- 성능 모니터링

**기술 스택**:
- TypeScript, React, Rollup, Jest, Cypress

---

### 2. Java/OpenTelemetry (3.x, 4.x, 9.x)

Java 기반 OpenTelemetry 및 분산 추적 예제들

**주요 프로젝트**:
- `3.2.5/` - OpenTracing Quickstart (Quarkus)
- `3.7.1/`, `3.7.2/` - Spring Boot 서비스
- `3.8.1/` - ByteBuddy Java Agent
- `3.8.2/` - OpenTelemetry Java Custom Instrumentation
- `9.4.5.1/`, `9.4.5.2/`, `9.4.5.3/`, `9.4.6/` - Maven/Gradle Java 프로젝트

**기술 스택**: Java, Maven, Gradle, Spring Boot, OpenTelemetry

---

### 3. Go 애플리케이션 (1.x, 3.x, 5.x)

Go 기반 분산 추적 및 모니터링 예제

**주요 프로젝트**:
- `1.3.3/` - Pyroscope Hotrod
- `3.3.1/` - Hotrod Go Application
- `3.3.2/` - OpenTelemetry Playground
- `5.3.1/` - Golang Tracing Demo

**기술 스택**: Go, OpenTelemetry, Jaeger

---

### 4. Python 예제 (4.x, 10.x)

Python 기반 OpenTelemetry 및 추적 예제

**주요 프로젝트**:
- `4.2.4/` - Flask OpenTelemetry Example
- `4.2.5/` - Python Message Tracing
- `4.2.9/` - Jaeger Python Example
- `10.7.5.5/` - Python MCP Application

**기술 스택**: Python, Flask, OpenTelemetry, Jaeger

---

### 5. Kubernetes & Helm (5.x, 6.x, 10.x)

쿠버네티스 및 헬름 차트 예제

**주요 프로젝트**:
- `5.3.12/`, `10.3.2.3/` - Helm Charts
- `5.3.13/`, `10.3.2.2/` - Kubernetes Configurations
- `6.6.3/` - Kubernetes Helm Setup
- `6.7.1/` - Cilium Minikube Demo
- `1.3.5/` - Istio Bookinfo Demo

**기술 스택**: Kubernetes, Helm, Istio, Cilium, Minikube

---

### 6. 메시징 & 이벤트 (3.x)

메시지 브로커 및 이벤트 기반 아키텍처 예제

**주요 프로젝트**:
- `3.4.1/` - Solace Messaging with OpenTelemetry
- `3.4.2/` - TIBCO JMS Messaging
- `3.4.3/` - Python Microservices Demo
- `3.4.5/` - Trading Example

**기술 스택**: Solace, TIBCO, JMS, OpenTelemetry

---

### 7. MCP (Model Context Protocol) Servers (10.7.5.x)

MCP 서버 및 애플리케이션

**주요 프로젝트**:
- `10.7.5.1/` - OpenSearch MCP Server
- `10.7.5.4/` - MCP Server
- `10.7.5.5/` - Python MCP Application
- `10.7.5.6/` - MCP Slack Bot
- `10.7.5.8/` - MCP Documentation
- `10.7.3/` - RAG Documentation

**기술 스택**: Python, MCP, OpenSearch, Slack

---

### 8. Docker & Compose (8.x)

Docker 및 Docker Compose 예제

**주요 프로젝트**:
- `8.4.2/` - Docker Compose Project
- `8.4.4/` - Java Instrumentation Workshop

**기술 스택**: Docker, Docker Compose

---

### 9. 데모 & 예제 (6.x)

다양한 데모 및 예제 코드

**주요 프로젝트**:
- `6.2.1/` - Hello World Demo
- `3.3.3/` - Grafana Dashboard Demo

---

## 빌드 및 실행

### Java/Maven 프로젝트

```bash
cd /root/aiops/3.2.5

# 빌드
mvn clean install

# 실행
java -jar target/*.jar
```

### Java/Gradle 프로젝트

```bash
cd /root/aiops/9.4.5.2

# 빌드
./gradlew build

# 실행
./gradlew run
```

### Go 프로젝트

```bash
cd /root/aiops/3.3.1

# 실행
go run main.go

# 빌드
go build -o app
```

### Python 프로젝트

```bash
cd /root/aiops/4.2.4

# 가상환경 생성
python -m venv venv
source venv/bin/activate

# 의존성 설치
pip install -r requirements.txt

# 실행
python app.py
```

### Kubernetes/Helm

```bash
cd /root/aiops/5.3.12

# Helm 차트 설치
helm install my-release ./chart

# Kubernetes 리소스 적용
kubectl apply -f k8s/
```

### Docker Compose

```bash
cd /root/aiops/8.4.2

# 시작
docker-compose up -d

# 로그 확인
docker-compose logs -f

# 중지
docker-compose down
```

---

## Git 작업

### 원격 저장소

```
origin: https://github.com/philllipjung/aiops.git
```

### 커밋 및 푸시

```bash
cd /root/aiops

# 상태 확인
git status

# 변경사항 커밋
git add .
git commit -m "메시지"

# 푸시
git push origin main
```

---

## 참고 문서

### 각 프로젝트별 README

각 디렉토리에는 프로젝트별 README.md가 있습니다:
- `/root/aiops/1.3.2/README.md` - Grafana Faro Web SDK
- `/root/aiops/3.2.5/README.md` - OpenTracing Quickstart
- `/root/aiops/10.7.5.1/README.md` - OpenSearch MCP Server
- 기타 등등

---

## 라이선스

개별 프로젝트마다 라이선스가 다를 수 있습니다. 각 프로젝트 디렉토리의 LICENSE 파일을 확인하세요.

---

**마지막 업데이트**: 2026-02-01
**관리자**: philip
**환경**: Minikube + OpenSearch + Fluent Bit
