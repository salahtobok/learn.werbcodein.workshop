package com.webcodein.hexagonal;

import com.webcodein.hexagonal.infrastructure.adapter.in.rest.OrderResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(OrderResource.class);
    }
}
