package com.example.controller;

import com.example.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final RoleService roleService;


    @PutMapping("/assign-role/user/{userId}")
    public ResponseEntity<?> assignRole(@PathVariable String userId){
        roleService.assignRole(userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/manager")
    public String manager(Authentication authentication) {
        return "Эту страницу видят только пользователи с правами MANAGER\n"
                + " Привет менеджер "
                + authentication.getName()
                + "\n ваши данные"
                + authentication.getCredentials().toString() + " " + authentication.getDetails().toString();
    }

    @GetMapping("/authenticated")
    public String authenticated(Authentication authentication) {
        return "Привет аутентифицированный пользователь" + authentication.getName();
    }
}
