package com.andresyfr.connect.drive.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Connect Drive API")
                        .description("API para el manejo de recursos de google drive")
                        .version("1.0")
                        .termsOfService("http://andresyfr/terms")
                        .contact(new io.swagger.v3.oas.models.info.Contact().name("Andresyfr").email("https://github.com/andresyfr/"))
                        .license(new io.swagger.v3.oas.models.info.License().name("AGPL 3.0").url("https://github.com/andresyfr/connect_drive_back?tab=AGPL-3.0-1-ov-file#readme")));
    }
}