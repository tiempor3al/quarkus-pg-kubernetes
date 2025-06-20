package mx.tiempor3al.resources;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mx.tiempor3al.services.DBService;

@Path("/")
public class RootResource {


    @Inject
    DBService dbService;



    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> version() {
       return dbService.version();
    }
}
