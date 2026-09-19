package com.webcodein.security;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/admin")
@ApplicationScoped
public class AdminResource {

    @GET
    @RolesAllowed("ADMIN")
    public String getAdminData() {
        return "Top Secret Enterprise Data";
    }
}
