package com.example.demo_resttemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

// Annotation Spring pour définir une classe de configuration
@Configuration
public class RestTemplateBuilderConfig {

    // L'URL est stockée dans application.properties
    @Value("${base.url.jsonPlaceHolder}")
    private String rootUrl;

    // Bean = niveau le plus élevé d'annotation Spring
    // Signifie qu'on configure un élément
    @Bean
    RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
        RestTemplateBuilder builder = configurer.configure(new RestTemplateBuilder());

        // Ajout des configurations :

        // Elément Spring pour construire des URLs
        DefaultUriBuilderFactory uriBuilderFactory =
                new DefaultUriBuilderFactory(rootUrl);

        RestTemplateBuilder configuredBuilder = builder.uriTemplateHandler(uriBuilderFactory);

        return configuredBuilder;
    }
}
