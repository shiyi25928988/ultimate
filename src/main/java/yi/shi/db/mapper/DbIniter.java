package yi.shi.db.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;

@Slf4j
public class DbIniter {


    public  static void init(DataSource dataSource) {

        ClassLoader classLoader = DbIniter.class.getClassLoader();
        try(Connection connection = dataSource.getConnection()){
            Enumeration<URL> resources = classLoader.getResources("sql");
            while (resources.hasMoreElements()) {
                URL resourceUrl = resources.nextElement();
                if (resourceUrl.getProtocol().equals("file")||resourceUrl.getProtocol().equals("jar")) { // 文件系统场景
                    Files.list(Paths.get(resourceUrl.toURI()))
                            .filter(path -> path.toString().endsWith(".sql"))
                            .forEach(path -> {
                                log.info("执行SQL文件：{}", path);
                                try (InputStream is = Files.newInputStream(path)) {
                                    // 处理每个 SQL 文件流
                                    connection.createStatement().execute(IOUtils.toString(is, "UTF-8"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            });
//                } else if (resourceUrl.getProtocol().equals("jar")) { // JAR 包场景
//                    // 需要特殊处理 JAR 文件路径
//                    System.out.println("JAR包场景");
                }
        }
        }catch (Exception e){}


//        try (Connection connection = dataSource.getConnection()) {
//            Reader reader = new InputStreamReader(DbIniter.class.getResourceAsStream("/sql/userAccount.sql"));
//            connection.createStatement().execute(IOUtils.toString(reader));
//            reader = new InputStreamReader(DbIniter.class.getResourceAsStream("/sql/markdownFiles.sql"));
//            connection.createStatement().execute(IOUtils.toString(reader));
//        } catch (IOException | RuntimeException | SQLException e) {
//            throw new RuntimeException("Failed to execute SQL script", e);
//        }

    }
}
