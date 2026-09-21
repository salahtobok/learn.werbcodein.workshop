package com.webcodein.security.zerotrust.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service("securityService")
public class SecurityService {

    public boolean isOwner(Authentication authentication, String accountId) {
        if (authentication == null || !(authentication.getPrincipal() instanceof Jwt jwt)) {
            return false;
        }
        
        // In a real application, you would map the JWT subject to an account owner in the database.
        // For this demonstration, we assume the JWT subject IS the account ID.
        String subject = jwt.getSubject();
        return accountId.equals(subject);
    }
}
