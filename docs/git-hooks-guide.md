# Git Hooks ガイド

## Git Hooksとは？
コミットやプッシュなどのGit操作時に自動実行されるスクリプト

## 一般的な使用例

### 1. テスト実行
- **pre-commit**: 変更されたファイルのテストのみ実行（高速）
- **pre-push**: 全テスト実行（確実）

### 2. コード品質チェック
- Linter実行（ESLint, Checkstyle等）
- フォーマット確認（Prettier, Google Java Format等）
- 静的解析（SpotBugs, SonarLint等）

### 3. コミットメッセージ規約
```bash
# commit-msg hook
if ! grep -qE "^(feat|fix|docs|style|refactor|test|chore): .+" "$1"; then
    echo "コミットメッセージが規約に従っていません"
    exit 1
fi
```

## 業界での使用状況

### ✅ 非常に一般的
- **Google**: 全プロジェクトでpre-commit hooks必須
- **Facebook**: React等でHusky使用
- **Netflix**: 社内ツールで標準化

### 📊 統計
- 大手企業の90%以上が何らかの形で使用
- オープンソースプロジェクトの60%以上で採用

## メリット・デメリット

### ✅ メリット
- 早期バグ検出
- リモートへの不正なコード防止
- チーム全体のコード品質向上

### ❌ デメリット
- コミット時間が増加
- 設定が複雑になる場合がある
- チーム全員の環境構築が必要

## ベストプラクティス

### 1. 段階的実行
```bash
# 高速チェック（pre-commit）
- 変更ファイルのみ
- 軽量なテスト

# 詳細チェック（pre-push）
- 全体テスト
- 統合テスト
```

### 2. エスケープハッチ
```bash
# 緊急時は無効化可能
git commit --no-verify
git push --no-verify
```

### 3. チーム共有
- `.githooks/`をバージョン管理
- READMEに設定手順記載
- セットアップスクリプト提供

## 現在の設定

### pre-commit
- 単体テスト実行
- 失敗時はコミット中止

### pre-push  
- ビルド確認
- 全テスト実行
- 失敗時はプッシュ中止

## 使用方法
```bash
# 初回設定
./setup-hooks.sh

# 通常のコミット（テストが自動実行される）
git commit -m "feat: add new feature"

# プッシュ（ビルド+テストが自動実行される）
git push
```