package com.example.repository;

import com.example.dto.UserRegistration;
import org.springframework.stereotype.Repository;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;


@Repository
public interface KeyCloakRepository {
    UserRegistration createUser(UserRegistration userRegistration);
    UserRepresentation getUserById(String userId);
    void deleteUserById(String userId);
    void emailVerification(String userId);
    UserResource getUserResource(String userId);
    void updatePassword(String userId);

}
