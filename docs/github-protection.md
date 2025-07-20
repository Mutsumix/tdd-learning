# GitHub Branch Protection 設定ガイド

## なぜ必要か？
- テストが失敗したコードがmainブランチに入るのを防ぐ
- チーム開発での品質担保

## 設定手順

### 1. Branch Protection Rule の作成
1. Settings → Branches
2. Add rule
3. Branch name pattern: `main`

### 2. 必須設定
- ✅ Require a pull request before merging
  - ✅ Require approvals (1以上)
- ✅ Require status checks to pass before merging
  - 検索ボックスで「test」を選択
  - ✅ Require branches to be up to date before merging
- ✅ Require conversation resolution before merging

### 3. 推奨設定（チーム開発時）
- ✅ Dismiss stale pull request approvals when new commits are pushed
- ✅ Include administrators（管理者も規則に従う）

## 個人開発での簡易設定
個人プロジェクトでは以下だけでもOK：
- ✅ Require status checks to pass before merging
- 「test」を必須チェックに追加

## 効果
- PRのマージボタンが「All checks have passed」になるまで無効化
- mainブランチの品質が保証される