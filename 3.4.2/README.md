# TIBCO JMS Messaging

## 버전
**v3.4.2**

## 개요

TIBCO JMS 메시징 예제 프로젝트입니다. 비동기 메시지 소비자를 포함한 Java/JMS 애플리케이션입니다.

## 주요 파일

```
3.4.2/
├── tibjmsAsyncMsgConsumer.java     # 비동기 소비자
├── tibjmsBrowser.java               # JMS 브라우저
├── JNDI/                            # JNDI 설정
└── admin/                           # 관리 도구
```

## 실행

```bash
cd /root/aiops/3.4.2

# 컴파일
javac tibjmsAsyncMsgConsumer.java

# 실행
java tibjmsAsyncMsgConsumer
```

## 주요 기능

- TIBCO Enterprise Message Service
- JNDI 룩업
- 비동기 메시지 수신

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
