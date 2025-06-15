package com.org.CommercialService.Configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Commercial building renting and sales",
                description = "APIs documentation for Commercial Building Service",
                version = "V1",
                contact = @Contact(
                        name = "Keshaw Krishna",
                        email = "keshawkrishna2007@gmail.com"
                )
        )
)
public class OpenAPIConfigurations {

}
