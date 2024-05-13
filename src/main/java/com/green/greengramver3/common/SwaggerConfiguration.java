package com.green.greengramver3.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "그린그램"
                , description = "Greengram with react"
                , version = "v3"
        )
)
public class SwaggerConfiguration {

}
