package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Value("${server.port}")
    private Integer serverPort;

    @Bean
    public OpenAPI openAPI() {
        Server server = new Server();
        server.setUrl(String.format("http://localhost:%d", serverPort));

        return new OpenAPI()
                .servers(Collections.singletonList(server))
                .components(new Components())
                .info(new Info()
                        .title("Controller Advice with MapStruct Example")
                        .version("1.0")
                        .contact(new Contact().name("Farzan").email("farzan.6118@gmail.com")));
    }
}