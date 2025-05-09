package com.project.Student.Configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Swagger for Student Microservice",
                description = "This is the API documentation represents the Student Microservice",
                version = "V1",
                contact = @Contact(
                        name = "Keshaw",
                        url = "www.google.com",
                        email = "ikeshawkrishna@gmail.com"
                ),
                termsOfService = "This is terms of service"
        ),
        servers = {
                @Server(
                        description = "DEV",
                        url = "http://localhost:8080/"
                ),
                @Server(
                        description = "PROD Environment",
                        url = "http://localhost:8080/PROD"
                )
        },
        security = {
        }
)
@SecuritySchemes(
        {
                @SecurityScheme(
                        type = SecuritySchemeType.HTTP,
                        name = "basicAuth",
                        description = "For basic authentication",
                        scheme = "basic",
                        in = SecuritySchemeIn.HEADER
                )
        }
)
public class OpenApiConfigurations {

    @Bean
    public GroupedOpenApi customGroupOpenAPI1() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .packagesToScan("com.project.Student.Controller")
                .build();
    }

}
