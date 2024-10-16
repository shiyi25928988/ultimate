package yi.shi;

import lombok.extern.slf4j.Slf4j;
import yi.shi.plinth.annotation.PropertiesFile;
import yi.shi.plinth.boot.ServiceBooter;

import java.io.IOException;

/**
 * Hello world!
 *
 */
@PropertiesFile(files = { "application.properties" })
@Slf4j
public class App 
{
    public static void main( String[] args ) {
        try {
            ServiceBooter.startFrom(App.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
