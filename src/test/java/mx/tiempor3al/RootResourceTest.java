package mx.tiempor3al;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import mx.tiempor3al.services.DBService;
import org.junit.jupiter.api.Test;

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

}