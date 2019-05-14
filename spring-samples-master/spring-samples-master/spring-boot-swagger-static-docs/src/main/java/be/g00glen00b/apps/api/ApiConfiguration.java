package be.g00glen00b.apps.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class ApiConfiguration {
//    @Bean
//    public Docket docket(ApiInfo apiInfo) {
//        return new Docket(DocumentationType.SWAGGER_2)
//            .groupName("user-api")
//            .useDefaultResponseMessages(false)
//            .apiInfo(apiInfo)
//            .select().paths(regex("/api/.*"))
//            .build();
//    }
	
//    @Bean
//    public ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//            .title("User API")
//            .description("API for fetching user related information")
//            .version("1.0.0")
//            .build();
//    }
//
//    @Bean
//    public UiConfiguration uiConfiguration() {
//        return UiConfigurationBuilder.builder()
//            .deepLinking(true)
//            .validatorUrl(null)
//            .build();
//    }
	@Bean
    public Docket publicApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("new-doctors-api")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("be.g00glen00b.apps.user"))
                .paths()
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Doctors API Service")
                .description("Doctors management for consulting and updating doctor's profiles.")
                //.contact(new Contact("Mario", "", "marioflorescondori@gmail.com"))
                
                .contact(new Contact("Wario", "github.com/draconetics", "marioflorescondori@gmail.com"))
                .version("1.0.0")
                .license("MIT License")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .build();
    }
    
	  @Bean
	  public UiConfiguration uiConfiguration() {
	      return UiConfigurationBuilder.builder()
	          .deepLinking(true)
	          .validatorUrl(null)
	          .build();
	  }
}
