import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String imagePath = "/Users/user/Desktop/images.jpg"; // 圖片路徑
        String charSet = " .▪◆●■█"; // 包含不同密度字符的字符集
        int width = 80; // 輸出寬度

        BufferedImage img = ImageIO.read(new File(imagePath));
        img = toGrayScale(img); // 轉換為灰階圖片
        img = resizeImage(img, width); // 縮放圖片

        String asciiArt = convertToASCII(img, charSet);
        System.out.println(asciiArt);
    }

    // 灰階轉換
    private static BufferedImage toGrayScale(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                int gray = (r + g + b) / 3; // 計算灰階值
                int newRgb = (gray << 16) | (gray << 8) | gray; // 重新組合 RGB 值
                grayImage.setRGB(x, y, newRgb);
            }
        }

        return grayImage;
    }

    // 圖片縮放
    private static BufferedImage resizeImage(BufferedImage image, int width) {
        int height = (int) (image.getHeight() * ((double) width / image.getWidth())); // 等比例縮放高度
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // 使用平滑縮放演算法
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    // 轉換為 ASCII 字元
    private static String convertToASCII(BufferedImage image, String charSet) {
        StringBuilder sb = new StringBuilder();
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int gray = (rgb >> 16) & 0xFF; // 取得灰階值
                int index = gray * charSet.length() / 256; // 計算字元集索引
                char c = charSet.charAt(index); // 取得對應的 ASCII 字元
                sb.append(c);
            }
            sb.append('\n'); // 換行
        }

        return sb.toString();
    }
}