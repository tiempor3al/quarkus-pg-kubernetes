package mx.tiempor3al.resources;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mx.tiempor3al.models.Pokemon;
import mx.tiempor3al.services.DBService;

@Path("/")
public class RootResource {

    @Inject
    DBService dbService;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> version() {
        Log.info("GET version");
        return dbService.version();
    }

    @GET
    @Path("/pokemons")
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Pokemon> getAllPokemons() {
        Log.info("GET all pokemons");
        return dbService.getAllPokemons();
    }

    @GET
    @Path("/trainers/{trainerId}/pokemons")
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Pokemon> getPokemonsByTrainer(@PathParam("trainerId") Long trainerId) {
        Log.info("GET pokemons for trainer: " + trainerId);
        return dbService.getPokemonsByTrainer(trainerId);
    }
}
