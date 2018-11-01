package cvc.api.configs;

import cvc.security.SecurityConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"cvc.logic"})
@EntityScan(basePackages = {"cvc.domain"})
@ComponentScan(basePackages = {"cvc"})
@Import(SecurityConfig.class)
public class AppConfig {
}
