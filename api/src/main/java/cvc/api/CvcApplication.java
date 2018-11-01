package cvc.api;

import cvc.api.configs.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class CvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(CvcApplication.class);
    }
}
