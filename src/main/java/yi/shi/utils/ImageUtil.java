package yi.shi.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class ImageUtil {
    private static Set<String> imageTypes = new HashSet<>();
    static {
        imageTypes.add("image/jpg");
        imageTypes.add("image/jpeg");
        imageTypes.add("image/png");
        imageTypes.add("image/gif");
        imageTypes.add("image/bmp");
        imageTypes.add("image/tiff");
        imageTypes.add("image/webp");
    }

    public static void compressImage(InputStream inputStream, String outputFilePath) throws IOException {
        File outputFile = new File(outputFilePath);
        Thumbnails.of(inputStream)
                .width(800)
                .keepAspectRatio(true)
                .toFile(outputFile);
    }

    public static boolean isImage(String contentType) {
        return imageTypes.contains(contentType);
    }
}
