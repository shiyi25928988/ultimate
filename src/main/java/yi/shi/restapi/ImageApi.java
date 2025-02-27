package yi.shi.restapi;

import yi.shi.data.result.ImageUrlResult;
import yi.shi.plinth.annotation.Properties;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.JSON;
import yi.shi.plinth.servlet.ServletHelper;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@HttpService
public class ImageApi {

    @Properties("server.resources.folder")
    private String UPLOAD_DIRECTORY;

    @GET
    @HttpPath(value = "/api/getImages")
    public JSON<Object> getImages(){
        List<ImageUrlResult> list = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(UPLOAD_DIRECTORY))) {
            // 获取所有文件的文件名并打印
            paths.filter(Files::isRegularFile)
                    .map(path -> path.getFileName().toString())
                    .forEach(file-> list.add(new ImageUrlResult("/static/" + file)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JSON<>(list);
    }

    @GET
    @HttpPath(value = "/api/deleteImages")
    @AUTH(authUrl = "/page/login", andRole = "admin")
    public void deleteImages() throws IOException {
        Path dirPath = Paths.get(UPLOAD_DIRECTORY);

        try {
            // 使用Files.walkFileTree方法遍历目录树并删除文件
            Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // 删除文件
                    Files.delete(file);
                    System.out.println("Deleted file: " + file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    // 删除空目录
                    //Files.delete(dir);
                    System.out.println("directory: " + dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServletHelper.getResponse().sendRedirect("/");
    }



}
