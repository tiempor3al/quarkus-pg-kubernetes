package org.acme;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.sqlclient.Pool;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @Inject
    Pool client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String root() {
        Log.info("Hello from Quarkus REST!");
        return "Hello from Quarkus REST!";
    }

    @GET
    @Path("/version")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> version() {
        Log.info("Querying PostgreSQL version");
        return client.query("SELECT version()").execute()
                .onItem().transform(set -> set.iterator().next().getString(0));
    }
}
