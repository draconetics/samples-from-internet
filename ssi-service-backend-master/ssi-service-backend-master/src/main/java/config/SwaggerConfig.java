package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Santiago Mamani
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket publicApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ssi-service-api")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.dh.ssiservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("ssi service API")
                .description("Users management")
                .contact(new Contact("mario", "", "marioflorescondori@gmail.com"))
                .version("0.0.1")
                .license("Apache 1.0")
                .licenseUrl("https://docs.spring.io/spring-data/jpa/docs/current/reference/html/")
                .build();
    }
}
