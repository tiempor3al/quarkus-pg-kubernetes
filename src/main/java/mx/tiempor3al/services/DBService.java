package mx.tiempor3al.services;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.sqlclient.Pool;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mx.tiempor3al.models.Pokemon;

@ApplicationScoped
public class DBService {

    @Inject
    Pool client;

    public Uni<String> version() {
        return client.query("SELECT version()").execute()
                .onItem().transform(set -> set.iterator().next().getString(0));
    }

    public Multi<Pokemon> getAllPokemons() {
        String query = "SELECT p.id, p.name, p.type_id, pt.name as type_name, p.height, p.weight, " +
                "p.hp, p.attack, p.defense, p.special_attack, p.special_defense, p.speed, p.description " +
                "FROM pokemon p " +
                "JOIN pokemon_types pt ON p.type_id = pt.id " +
                "ORDER BY p.id";

        return client.query(query).execute()
                .onItem().transformToMulti(rows -> Multi.createFrom().iterable(rows))
                .onItem().transform(Pokemon::fromRecord);
    }

    public Multi<Pokemon> getPokemonsByTrainer(Long trainerId) {
        String query = "SELECT p.id, p.name, p.type_id, pt.name as type_name, p.height, p.weight, " +
                "p.hp, p.attack, p.defense, p.special_attack, p.special_defense, p.speed, p.description " +
                "FROM pokemon p " +
                "JOIN pokemon_types pt ON p.type_id = pt.id " +
                "JOIN trainer_pokemon tp ON p.id = tp.pokemon_id " +
                "WHERE tp.trainer_id = $1 " +
                "ORDER BY p.id";

        return client.preparedQuery(query).execute(Tuple.of(trainerId))
                .onItem().transformToMulti(rows -> Multi.createFrom().iterable(rows))
                .onItem().transform(Pokemon::fromRecord);
    }
}
