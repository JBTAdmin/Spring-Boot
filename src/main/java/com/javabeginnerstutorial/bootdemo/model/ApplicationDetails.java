package com.javabeginnerstutorial.bootdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component  // Either use @Component or @EnableConfigurationProperties annotation to make @ConfigurationProperties work
@ConfigurationProperties("app")
public class ApplicationDetails {

    String name;
    Author author = new Author();
    String springVersion;
    String javaVersion;

    @Data
    public static class Author{
        String name;
        String website;
        String email;
    }
}