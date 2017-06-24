package og.github.antennae.cfs.rest;

import og.github.antennae.cfs.service.VersionService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Component
@Path("/api/version")
public class RestController {

    @Inject
    VersionService versionService;

    @GET
    public String message() {
        return "{ 'version' : " + versionService.version() + " }";
    }
}
