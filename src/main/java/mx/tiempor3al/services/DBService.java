package mx.tiempor3al.services;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.sqlclient.Pool;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DBService {

    @Inject
    Pool client;

    public Uni<String> version() {
        return client.query("SELECT version()").execute()
                .onItem().transform(set -> set.iterator().next().getString(0));
    }

}
