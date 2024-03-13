package com.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.dto.UserRegistration;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.*;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class KeycloakUserService {

    @Value("testRealm")
    private String realm;
    private Keycloak keycloak;
    private KeycloakUserService keycloakUserService;

    public KeycloakUserService(Keycloak keycloak, KeycloakUserService keycloakUserService) {
        this.keycloak = keycloak;
        this.keycloakUserService = keycloakUserService;
    }

    public UserRegistration createUser(UserRegistration userRegistration) {
        //TODO
        return null;
    }

    private UsersResource getUsersResource() {
        RealmResource realm1 = keycloak.realm(realm);
        return realm1.users();
    }

    public UserRepresentation getUserById(String userId) {
        //TODO
        return getUsersResource().get(userId).toRepresentation();
    }

    public void deleteUserById(String userId) {
        //TODO
        getUsersResource().delete(userId);
    }

    public void emailVerification(String userId) {
        //TODO
        UsersResource usersResource = getUsersResource();
        usersResource.get(userId).sendVerifyEmail();
    }

    public UserResource getUserResource(String userId) {
        UsersResource usersResource = getUsersResource();
        return usersResource.get(userId);
    }

    public void updatePassword(String userId) {
        //TODO
        UserResource userResource = getUserResource(userId);
        List<String> actions = new ArrayList<>();
        actions.add("UPDATE_PASSWORD");
        userResource.executeActionsEmail(actions);

    }
}

