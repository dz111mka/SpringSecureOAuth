package com.example.controller;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/manager")
    public String manager(Authentication authentication) {
        return "Эту страницу видят только пользователи с правами MANAGER\n"
                + " Привет менеджер "
                + authentication.getName()
                + "\n ваши данные"
                + authentication.getCredentials().toString() + " " + authentication.getDetails().toString();
    }

    @GetMapping("/authenticated")
    public String authenticated(Neo4jProperties.Authentication authentication) {
        return "Привет аутентифицированный пользователь" + authentication.getUsername() + " " + authentication.getPassword();
    }
}
