package com.relesi.jwt.services.impl;

import com.relesi.jwt.security.UserSpringSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserServiceImpl {
    public static UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        } catch (Exception e) {
            return null;
        }
    }
}
