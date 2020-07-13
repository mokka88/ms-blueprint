package org.mokka88.msblueprint.auth.controller;

import org.mokka88.msblueprint.auth.api.LoginApiDelegate;
import org.mokka88.msblueprint.auth.api.model.UserLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoginDelegateImpl implements LoginApiDelegate {
    @Override
    public ResponseEntity<Void> login(UserLogin body) {
        System.out.println("Called login");
        return ResponseEntity.ok().build();
    }
}
