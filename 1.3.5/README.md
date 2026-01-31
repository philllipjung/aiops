# Istio Bookinfo

## 버전
**v1.3.5**

## 개요

Istio Bookinfo 예제 애플리케이션입니다. 마이크로서비스 데모를 포함합니다.

## 프로젝트 구조

```
1.3.5/
└── bookinfo/    # Bookinfo 애플리케이션
```

## 실행

```bash
cd /root/aiops/1.3.5

# Kubernetes에 배포
kubectl apply -f bookinfo/

# 확인
kubectl get pods -l app=bookinfo
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
