# ASCII 藝術生成器

這是一個將圖片轉換為 ASCII 藝術的 Java 應用程式。

## 功能特點

- 支援任意圖片格式
- 可自定義輸出寬度
- 可自定義字符集
- 自動調整圖片大小
- 灰階轉換

## 使用方式

```bash
java -jar ASCIIart.jar <圖片路徑> [字符集] [寬度]
```

### 參數說明

- `圖片路徑`：要轉換的圖片檔案路徑（必填）
- `字符集`：用於轉換的字符集（選填，預設為 " .▪◆●■█"）
- `寬度`：輸出寬度（選填，預設為 80）

### 範例

```bash
# 使用預設設定
java -jar ASCIIart.jar image.jpg

# 自定義字符集和寬度
java -jar ASCIIart.jar image.jpg "@%#*+=-:. " 100
```

## 開發環境

- Java 8 或更高版本
- Maven 3.6 或更高版本

## 建置方式

```bash
mvn clean package
```

## 授權

MIT License
