package com.example.weatherking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseBean {
    private String version;
    private String title;

    @Bean
    public Docket apiV1() throws UnknownHostException {
        version = "V1";
        title = "날씨왕서버 " + version;

        //public ApiInfo(
        // String title
        // , String description
        // , String version
        // , String termsOfServiceUrl
        // , Contact contact
        // , String license
        // , String licenseUrl
        // , Collection<VendorExtension> vendorExtensions) {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors/*.any()*/.basePackage("com.example.weatherking"))
//                .paths(PathSelectors.ant("/v2/api/**"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title(title)
                        .description("Weatherking API Docs")
                        .version(version)
                        .termsOfServiceUrl(InetAddress.getLocalHost().getHostAddress())
                        .contact(new Contact("baegseungchan", "https://github.com/mokdonjr/", "mokdonjr@naver.com"))
//                        .license("MIT License")
//                        .licenseUrl()
                        .extensions(new ArrayList<>())
                        .build());
    }
}
