# Flask OpenTelemetry Example

## 버전
**v4.2.4**

## 개요

Flask 웹 프레임워크와 OpenTelemetry을 통합한 Python 예제 애플리케이션입니다. 주사위 게임과 추적 기능을 구현합니다.

## 기술 스택

- **Python**
- **Flask** Web Framework
- **OpenTelemetry** Python SDK

## 코드 구조

```python
from flask import Flask
from opentelemetry import trace

app = Flask(__name__)
tracer = trace.get_tracer("diceroller.tracer")

@app.route("/rolldice")
def roll_dice():
    return str(roll())
```

## 실행

```bash
cd /root/aiops/4.2.4

# 의존성 설치
pip install flask opentelemetry-api

# 실행
python app.py

# 접속
curl http://localhost:5000/rolldice
```

## 주요 기능

- OpenTelemetry Tracing
- Span 생성 및 속성 설정
- Flask 라우트 계측

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
