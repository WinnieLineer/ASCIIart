package ASCIIart;

import java.awt.image.BufferedImage;

/**
 * 將圖片轉換為 ASCII 藝術的類別
 */
public class ASCIIConverter {
    private final String charSet;
    
    /**
     * 建構函數
     * @param charSet 用於轉換的字符集
     */
    public ASCIIConverter(String charSet) {
        this.charSet = charSet;
    }
    
    /**
     * 將圖片轉換為 ASCII 藝術
     * @param image 要轉換的圖片
     * @return ASCII 藝術字串
     */
    public String convertToASCII(BufferedImage image) {
        StringBuilder sb = new StringBuilder();
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int gray = (rgb >> 16) & 0xFF;
                int index = gray * charSet.length() / 256;
                char c = charSet.charAt(index);
                sb.append(c);
            }
            sb.append('\n');
        }

        return sb.toString();
    }
} 