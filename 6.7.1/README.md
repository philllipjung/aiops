# Cilium Minikube Demo

## 버전
**v6.7.1**

## 개요

Cilium 네트워크 플러그인 데모입니다. Star Wars 테마의 Kubernetes 매니페스트를 포함합니다.

## 프로젝트 구조

```
6.7.1/
├── 00-cleanup-all.sh      # 전체 정리 스크립트
├── 00-cleanup-policy.sh  # 정책 정리 스크립트
├── 00-intro.sh            # 소개 스크립트
├── 01-deathstar.yaml     # Deathstar pod
├── 02-xwing.yaml         # X-wing pod
├── 03-pod-cmdline.sh     # Pod 명령행 데모
└── cilium-minikube.yaml  # Cilium 설정
```

## 실행

```bash
cd /root/aiops/6.7.1

# 정리
./00-cleanup-all.sh

# 배포
kubectl apply -f cilium-minikube.yaml
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
