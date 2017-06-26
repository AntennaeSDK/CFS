package org.github.antennae.cfs.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by nsankaran on 6/23/17.
 */
@Component
@ApplicationPath("/api/v1")
public class RestConfig extends ResourceConfig {

    public RestConfig() {
        register(RestController.class);
    }

}