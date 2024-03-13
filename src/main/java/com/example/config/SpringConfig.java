package com.example.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.example")
public class SpringConfig {

    @Value("admin-cli")
    private String adminClientId;

    @Value("Datt43VSxsteDgNjNO5VEwtacEBP59XI}")
    private String adminClientSecret;

    @Value("http://localhost:8080/")
    private String authServerUrl;

    @Value("testRealm")
    private String realm;

    @Bean
    public Keycloak keycloak(){

        return KeycloakBuilder.builder()
                .serverUrl(authServerUrl)
                .realm(realm)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(adminClientId)
                .clientSecret(adminClientSecret)
                .build();
    }

}
