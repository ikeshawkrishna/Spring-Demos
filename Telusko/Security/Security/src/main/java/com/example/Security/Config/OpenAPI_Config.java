package com.example.Security.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Security Project Swagger UI",
                contact = @Contact(
                        name = "Keshaw",
                        email = "keshawkrishna2007@gmail.com",
                        url = "www.google.com"
                ),
                description = "This is for Spring Secuity Controllers endpoints",
                version = "V1",
                termsOfService = "This is Terms of Service"
        ),
        servers = {
                @Server(
                        description = "DEV Environment",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD Environment",
                        url = "http://localhost:8080/PROD"
                )
        },

        security = {
                @SecurityRequirement(name = "basicAuth")
        }

)

@SecuritySchemes(
        {
                @SecurityScheme(
                        name = "basicAuth",
                        description = "For basic authentication",
                        scheme = "basic",
                        type = SecuritySchemeType.HTTP,
                        in = SecuritySchemeIn.HEADER
                ),
                @SecurityScheme(
                        name = "jwtAuthentication",
                        description = "For JST authentication",
                        scheme = "bearer",
                        type = SecuritySchemeType.HTTP,
                        in = SecuritySchemeIn.HEADER,
                        bearerFormat = "JWT"
                )
        }
)
public class OpenAPI_Config {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .packagesToScan("com.example.Security.Controller")
                .build();
    }

}
