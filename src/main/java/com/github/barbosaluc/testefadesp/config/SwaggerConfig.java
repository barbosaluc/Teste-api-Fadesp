package com.github.barbosaluc.testefadesp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de teste da Fadesp")
                .description("Api de pagamento referente ao teste da Fadesp")
                .version("1.0.0")
            );
    }       
}

