package yi.shi.db.mapper;

import org.apache.commons.io.IOUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class DbIniter {


    public  static void init(DataSource dataSource) {

        try (Connection connection = dataSource.getConnection()) {
            Reader reader = new InputStreamReader(DbIniter.class.getResourceAsStream("/sql/userAccount.sql"));
            connection.createStatement().execute(IOUtils.toString(reader));
            reader = new InputStreamReader(DbIniter.class.getResourceAsStream("/sql/markdownFiles.sql"));
            connection.createStatement().execute(IOUtils.toString(reader));
        } catch (IOException | RuntimeException | SQLException e) {
            throw new RuntimeException("Failed to execute SQL script", e);
        }

    }
}
