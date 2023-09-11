package superprice.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import superprice.catalog.controller.ColesSync;

@SpringBootApplication
public class Application {

    public static void main (String [] args) {
        SpringApplication.run (Application.class, args);
        ColesSync.main(args);
    }

}
