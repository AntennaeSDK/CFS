package og.github.antennae.cfs.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by nsankaran on 6/23/17.
 */
@Component
public class RestConfig extends ResourceConfig {

    public RestConfig() {
        register(RestController.class);
        //register(ReverseEndpoint.class);
    }

}