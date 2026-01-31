# Kubernetes Deployment

## 버전
**v10.3.2.2**

## 개요

Kubernetes 배포 매니페스트입니다.

## 프로젝트 구조

```
10.3.2.2/
├── deployment.yaml      # Deployment 설정
├── monitor.yaml        # 모니터링 설정
├── prometheus-adapter  # Prometheus 어댑터
└── service.yaml        # Service 설정
```

## 사용

```bash
cd /root/aiops/10.3.2.2

# 배포
kubectl apply -f .

# 확인
kubectl get all
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
