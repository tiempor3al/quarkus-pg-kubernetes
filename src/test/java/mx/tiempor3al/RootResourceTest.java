package mx.tiempor3al;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import mx.tiempor3al.models.Pokemon;
import mx.tiempor3al.services.DBService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
class RootResourceTest {

    @InjectMock
    DBService dbService;

    @Test
    void testRootEndpoint() {
        when(dbService.version()).thenReturn(Uni.createFrom().item("1.0.0"));

        given()
          .when().get("/")
          .then()
             .statusCode(200)
            .body(is("1.0.0"));
    }

    @Test
    void testPokemonsEndpoint() {
        // Create a sample Pokemon record
        Pokemon pokemon = new Pokemon(
            1L,
            "Pikachu",
            4L,
            "Electric",
            new BigDecimal("0.4"),
            new BigDecimal("6.0"),
            35,
            55,
            40,
            50,
            50,
            90,
            "An Electric-type Pokemon that stores electricity in its cheeks"
        );

        // Mock the DBService to return a stream with our sample Pokemon
        when(dbService.getAllPokemons()).thenReturn(Multi.createFrom().item(pokemon));

        // Test the endpoint
        given()
            .when().get("/pokemons")
            .then()
                .statusCode(200)
                .body("[0].id", is(1))
                .body("[0].name", is("Pikachu"))
                .body("[0].typeId", is(4))
                .body("[0].typeName", is("Electric"))
                .body("[0].height", is(0.4f))
                .body("[0].weight", is(6.0f))
                .body("[0].hp", is(35))
                .body("[0].attack", is(55))
                .body("[0].defense", is(40))
                .body("[0].specialAttack", is(50))
                .body("[0].specialDefense", is(50))
                .body("[0].speed", is(90))
                .body("[0].description", is("An Electric-type Pokemon that stores electricity in its cheeks"));
    }
}
