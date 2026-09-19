package com.webcodein.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;

@OpenIdAuthenticationMechanismDefinition(
    providerURI = "${oidc.provider.url}",
    clientId = "${oidc.client.id}",
    clientSecret = "${oidc.client.secret}"
)
@ApplicationScoped
public class SecuritySetup {
    // Standardized OIDC configuration, values resolved from MicroProfile Config
}
