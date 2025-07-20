#!/bin/bash

echo "🔗 Git Hooksを設定中..."

# Git Hooksディレクトリを.githooksに設定
git config core.hooksPath .githooks

echo "✅ Git Hooksの設定が完了しました！"
echo ""
echo "📋 設定されたHooks:"
echo "  - pre-commit: コミット前にテスト実行"
echo "  - pre-push: プッシュ前にビルド+テスト実行"
echo ""
echo "🚫 Hooksを一時的に無効にしたい場合:"
echo "  git commit --no-verify"
echo "  git push --no-verify"