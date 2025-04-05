package ASCIIart;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ASCII 藝術生成器的主程式
 */
public class Main {
    private static final String DEFAULT_CHAR_SET = " .▪◆●■█";
    private static final int DEFAULT_WIDTH = 80;

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.err.println("請提供圖片路徑作為參數");
                System.exit(1);
            }

            String imagePath = args[0];
            String charSet = args.length > 1 ? args[1] : DEFAULT_CHAR_SET;
            int width = args.length > 2 ? Integer.parseInt(args[2]) : DEFAULT_WIDTH;

            processImage(imagePath, charSet, width);
        } catch (IOException e) {
            System.err.println("處理圖片時發生錯誤: " + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("寬度參數必須是數字");
            System.exit(1);
        }
    }

    /**
     * 處理圖片並生成 ASCII 藝術
     * @param imagePath 圖片路徑
     * @param charSet 字符集
     * @param width 輸出寬度
     * @throws IOException 當讀取圖片失敗時拋出
     */
    private static void processImage(String imagePath, String charSet, int width) throws IOException {
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            throw new IOException("找不到圖片檔案: " + imagePath);
        }

        BufferedImage img = ImageIO.read(imageFile);
        if (img == null) {
            throw new IOException("無法讀取圖片: " + imagePath);
        }

        // 處理圖片
        img = ImageProcessor.toGrayScale(img);
        img = ImageProcessor.resizeImage(img, width);

        // 轉換為 ASCII
        ASCIIConverter converter = new ASCIIConverter(charSet);
        String asciiArt = converter.convertToASCII(img);
        System.out.println(asciiArt);
    }
}