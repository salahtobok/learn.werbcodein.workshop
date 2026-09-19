package com.webcodein.security;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.Claim;

@RequestScoped
public class UserProfileService {

    @Inject
    @Claim("preferred_username")
    private String username;

    @Inject
    @Claim("email_verified")
    private Boolean isEmailVerified;

    public String getUsername() {
        return username;
    }

    public Boolean getIsEmailVerified() {
        return isEmailVerified;
    }
}
