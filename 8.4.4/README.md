# Java Instrumentation Workshop

## 버전
**v8.4.4**

## 개요

Java 계측(Instrumentation) 워크샵 프로젝트입니다.

## 프로젝트 구조

```
8.4.4/
├── docker-compose.yaml         # Docker Compose
├── assets/                     # 리소스
├── instrumented/              # 계측된 버전
├── uninstrumented/            # 미계측 버전
├── workshop.md                 # 워크샵 가이드
└── yaml/                       # YAML 설정
```

## 실행

```bash
cd /root/aiops/8.4.4

# 계측된 버전 실행
docker-compose -f docker-compose.yaml up instrumented

# 미계측 버전 실행
docker-compose -f docker-compose.yaml up uninstrumented
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
