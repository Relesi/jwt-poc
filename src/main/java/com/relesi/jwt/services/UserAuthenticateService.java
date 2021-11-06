package com.relesi.jwt.services;

import com.relesi.jwt.security.UserSpringSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserAuthenticateService {

    public static UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}