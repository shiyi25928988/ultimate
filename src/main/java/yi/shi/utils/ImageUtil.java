package yi.shi.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
    public static void compressImage(InputStream inputStream, String outputFilePath) throws IOException {
        File outputFile = new File(outputFilePath);
        Thumbnails.of(inputStream)
                .width(800)
                .keepAspectRatio(true)
                .toFile(outputFile);
    }
}
