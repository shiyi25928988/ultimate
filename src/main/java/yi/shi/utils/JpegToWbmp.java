package yi.shi.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JpegToWbmp {

    public static void convertAndSave(InputStream jpegFileInputStream, String wbmpFilePath) throws IOException {

        JpegToWbmp converter = new JpegToWbmp();
        try {
            // 读取 JPEG 图像
            BufferedImage jpegImage = ImageIO.read(jpegFileInputStream);

            // 将 JPEG 图像转换为 WBMP 图像
            BufferedImage wbmpImage = convertToWbmp(jpegImage);

            // 写入 WBMP 图像
            converter.writeWbmp(wbmpImage, wbmpFilePath);

            System.out.println("JPEG to WBMP conversion successful.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error converting JPEG to WBMP: " + e.getMessage());
        }
    }

    private static BufferedImage convertToWbmp(BufferedImage sourceImage) {
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();

        // 创建一个新的单色图像
        BufferedImage wbmpImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

        // 将源图像的内容复制到新的单色图像中
        wbmpImage.getGraphics().drawImage(sourceImage, 0, 0, null);

        return wbmpImage;
    }
    private void writeWbmp(BufferedImage image, String filePath) throws IOException {
        // 使用自定义的 WBMP 编码器写入图像
        WbmpEncoder encoder = new WbmpEncoder();
        encoder.write(image, new File(filePath));
    }


    class WbmpEncoder {
        public void write(BufferedImage image, File file) throws IOException {
            int width = image.getWidth();
            int height = image.getHeight();

            // 创建输出流
            try (java.io.DataOutputStream out = new java.io.DataOutputStream(new java.io.FileOutputStream(file))) {
                // 写入 WBMP 文件头
                out.writeByte(0x00); // WBMP 文件标识符
                out.writeShort(0x0000); // 版本号
                out.writeShort(width); // 宽度
                out.writeShort(height); // 高度
                out.writeByte(0x00); // 颜色模式（0 表示单色）

                // 写入图像数据
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        int pixel = image.getRGB(x, y);
                        int gray = (pixel >> 16) & 0xFF; // 取红色通道作为灰度值
                        out.writeByte(gray > 127 ? 1 : 0); // 1 表示白色，0 表示黑色
                    }
                }
            }
        }

        private void writeBit(int bit, java.io.DataOutputStream out) throws IOException {
            int byteValue = 0;
            int bitCount = 0;

            while (bitCount < 8) {
                byteValue <<= 1;
                byteValue |= (bit & 0x01);
                bit >>= 1;
                bitCount++;
            }

            out.writeByte(byteValue);
        }
    }
}
