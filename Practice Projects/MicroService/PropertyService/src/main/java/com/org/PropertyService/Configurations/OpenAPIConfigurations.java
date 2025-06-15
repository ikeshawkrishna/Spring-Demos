package com.org.PropertyService.Configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Property Service EndPoints",
                description = "APIs documentation for Property Service",
                version = "V1",
                contact = @Contact(
                        name = "Keshaw Krishna",
                        email = "keshawkrishna2007@gmail.com"
                )
        )
)
public class OpenAPIConfigurations {

}
