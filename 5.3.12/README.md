# Helm Chart

## 버전
**v5.3.12**

## 개요

Kubernetes Helm Chart 프로젝트입니다.

## 프로젝트 구조

```
5.3.12/
├── Makefile          # 빌드 설정
├── ct.yaml           # Chart Testing 설정
├── chart/            # Helm Chart
└── docs/             # 문서
```

## 사용

```bash
cd /root/aiops/5.3.12

# Lint
make lint

# 테스트
ct install
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
