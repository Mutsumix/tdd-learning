# テストの種類と実行タイミング

## テストピラミッド
```
      /\
     /E2E\     <- 少数・遅い・高コスト
    /統合 \
   /      \
  / 単体    \  <- 多数・速い・低コスト
 /__________\
```

## 1. 単体テスト（Unit Test）
- **対象**: 個々のメソッド・クラス
- **実行**: 毎回のコミット
- **時間**: 数秒
- **例**: JUnit

## 2. 統合テスト（Integration Test）
- **対象**: 複数コンポーネントの連携
- **実行**: PR時
- **時間**: 数分
- **例**: DB接続、API連携

## 3. E2Eテスト（End-to-End Test）
- **対象**: システム全体
- **実行**: リリース前
- **時間**: 10分以上
- **例**: Selenium、Cypress

## 4. その他の重要なテスト

### ビルドテスト
```bash
mvn clean compile
mvn package
```

### パフォーマンステスト
- JMH（Java Microbenchmark Harness）
- Apache JMeter

### セキュリティテスト
- OWASP Dependency Check
- SonarQube Security Hotspots

### アクセシビリティテスト
- axe-core
- Pa11y

## CI/CDでの実行順序
1. ビルド検証（即座に失敗を検出）
2. 単体テスト（高速なフィードバック）
3. コード品質チェック（並列実行）
4. 統合テスト（時間がかかる）
5. E2Eテスト（最後に実行）