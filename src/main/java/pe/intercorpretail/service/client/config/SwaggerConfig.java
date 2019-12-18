package pe.intercorpretail.service.client.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	public static final Contact CONTACT = new Contact("Giancarlo Yarleque", "https://github.com/Giancarlo2709", "giancarlo2709@gmail.com");
	public static final ApiInfo API_INFO = new ApiInfo("Microservicio Cliente", "Descripcion del microservicio cliente", "1.0",
			"Terms of Service", CONTACT, "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
	
	@Bean
	public Docket apiDocument() {
		return new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(LocalDate.class, String.class)
				.select()
				.apis(RequestHandlerSelectors.basePackage("pe.intercorpretail.service.client"))
				.paths(regex("/.*"))
				.build()
				.apiInfo(API_INFO);
	}
	
	
}
