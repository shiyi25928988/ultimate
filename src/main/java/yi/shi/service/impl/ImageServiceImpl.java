package yi.shi.service.impl;

import yi.shi.service.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ImageServiceImpl implements ImageService {

    private String UPLOAD_DIRECTORY = System.getProperty("server.resources.folder");
    @Override
    public List<String> getImageList() {
        List<String> list = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(UPLOAD_DIRECTORY))) {
            paths.filter(Files::isRegularFile)
                    .map(path -> path.getFileName().toString())
                    .forEach(file-> list.add("/static/" + file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
