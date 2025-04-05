package ASCIIart;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 處理圖片相關操作的類別
 */
public class ImageProcessor {
    
    /**
     * 將圖片轉換為灰階
     * @param image 原始圖片
     * @return 灰階圖片
     */
    public static BufferedImage toGrayScale(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                int gray = (r + g + b) / 3;
                int newRgb = (gray << 16) | (gray << 8) | gray;
                grayImage.setRGB(x, y, newRgb);
            }
        }

        return grayImage;
    }

    /**
     * 調整圖片大小
     * @param image 原始圖片
     * @param width 目標寬度
     * @return 調整後的圖片
     */
    public static BufferedImage resizeImage(BufferedImage image, int width) {
        int height = (int) (image.getHeight() * ((double) width / image.getWidth()));
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }
} 