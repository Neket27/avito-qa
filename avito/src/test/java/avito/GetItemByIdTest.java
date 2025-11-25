package avito;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.stream.Stream;

import static avito.utils.CreatePost.createAndGetItemId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@DisplayName("GET /item/{id} — получение объявления")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GetItemByIdTest extends BaseApiTest {

    @BeforeAll
    static void init() {
        withJsonContentType();
    }


    @Test
    @DisplayName("TC-POS-001: Успешное получение существующего объявления")
    void getExistingItem() {
        String id = createAndGetItemId();

        Response response = given()
                .when().get("/item/" + id);

        response.then()
                .statusCode(200)
                .body("id", is(id))
                .body("name", not(emptyString()))
                .body("price", isA(Number.class))
                .body("statistics.likes", isA(Number.class));
    }

    @Test
    @DisplayName("TC-NEG-002 / TC-NEG-003: Некорректный UUID (SQL-inj, число)")
    void invalidIdShouldReturn400() {
        String _id = createAndGetItemId();
        Stream.of(_id+"; DROP TABLE users--", "1", "0", "-1", "not-a-uuid")
                .forEach(id -> {
                    given().pathParam("id", id)
                            .when().get("/item/{id}")
                            .then()
                            .statusCode(400)
                            .body("status", is("400"))
                            .body("result.message", notNullValue());
                });
    }

    @Test
    @DisplayName("TC-NEG-003: Несуществующий, но валидный UUID - ожидаем 404 not found")
    void nonexistentButValidUuid() {
        String invalidUuid = "00000000-0000-0000-0000-000000000000";
        given().pathParam("id", invalidUuid)
                .when().get("/item/{id}")
                .then()
                .statusCode(404)
                .body("result.message", is("item 00000000-0000-0000-0000-000000000000 not found"));
    }
}
