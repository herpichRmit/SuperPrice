package superprice.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import superprice.catalog.model.dao.SessionProvider;

@SpringBootApplication
public class Application {
    public static void main (String [] args) {
        SessionProvider.init ();
        SpringApplication.run (
                Application.class,
                args
        );
    }

}
