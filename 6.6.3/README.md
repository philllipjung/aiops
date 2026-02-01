# Kubernetes Helm Setup

## 버전
**v6.6.3**

## 개요

Kubernetes와 Helm을 사용한 클러스터 설정 프로젝트입니다.

## 프로젝트 구조

```
6.6.3/
├── helm/                # Helm Charts
├── kind-config.yaml     # Kind 클러스터 설정
├── manifests/           # Kubernetes 매니페스트
└── screenshots/         # 스크샷샷
```

## 사용

```bash
cd /root/aiops/6.6.3

# Helm 차트 설치
helm install release ./helm

# 매니페스트 적용
kubectl apply -f manifests/
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
