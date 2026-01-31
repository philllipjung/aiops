# Helm Chart

## 버전
**v10.3.2.3**

## 개요

Kubernetes Helm Chart입니다.

## 프로젝트 구조

```
10.3.2.3/
├── Chart.yaml          # Helm Chart 메타데이터
├── values.yaml         # 기본 값 설정
├── scale.yaml          # 스케일링 설정
└── templates/          # Kubernetes 매니페스트 템플릿
```

## 사용

```bash
cd /root/aiops/10.3.2.3

# Helm 설치
helm install my-release .

# 업그레이드
helm upgrade my-release .

# 삭제
helm uninstall my-release
```

## 관련 링크

- **저장소**: https://github.com/philllipjung/aiops

---

**마지막 업데이트**: 2026-02-01
