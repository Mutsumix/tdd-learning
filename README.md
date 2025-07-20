# TDD学習プロジェクト

## テスト実行方法

### 1. コマンドライン
```bash
# 全てのテストを実行
mvn test

# 特定のテストクラスのみ実行
mvn test -Dtest=CalculatorTest

# 特定のテストメソッドのみ実行
mvn test -Dtest=CalculatorTest#testAddPositiveNumbers
```

### 2. IntelliJ IDEA
1. プロジェクトを開く
2. テストクラスを右クリック → "Run 'CalculatorTest'"
3. または、テストメソッド横の緑の▶ボタンをクリック

### 3. VS Code
1. Java Extension Packをインストール
2. テストファイルを開く
3. テストメソッド上部の "Run Test" リンクをクリック

## プロジェクト構成
- `src/main/java/` - プロダクションコード
- `src/test/java/` - テストコード
- `pom.xml` - Maven設定ファイル

## 使用技術
- Java 11
- JUnit 5
- AssertJ（読みやすいアサーション）
- Maven（ビルドツール）