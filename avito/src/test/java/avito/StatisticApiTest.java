package avito;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static avito.utils.CreatePost.createAndGetItemId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("GET /statistic/{id} — статистика объявления")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StatisticApiTest extends BaseApiTest{

    @BeforeAll
    static void init() {
        withJsonContentType();
    }

    @Test
    @DisplayName("TC-POS-001: Успешное получение статистики — ожидается JSON-объект, но приходит массив → BUG")
    void getStatisticShouldReturnObjectButReturnsArray() {
        String id = createAndGetItemId();

        Response response = given()
                .pathParam("id", id)
                .when()
                .get("/statistic/{id}");

        String responseBody = response.getBody().asString();
        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200);


        if (responseBody.trim().startsWith("[")) {
            // Это массив — баг!
            int arraySize = jsonPath.getList("$").size();
            fail("BUG: Сервер возвращает массив вместо объекта!\n" +
                    "Ожидалось: { \"contacts\": N, \"likes\": N, \"viewCount\": N }\n" +
                    "Получено: " + responseBody + "\n" +
                    "Размер массива: " + arraySize +
                    (arraySize == 1 ? "\n→ Внутри массива один элемент — возможно, ошибка проектирования API." : ""));
        }

        // Если дойдём сюда — это объект. Проверяем поля.
        response
                .then()
                .body("contacts", isA(Number.class))
                .body("likes", isA(Number.class))
                .body("viewCount", isA(Number.class))
                .body("contacts", greaterThanOrEqualTo(0))
                .body("likes", greaterThanOrEqualTo(0))
                .body("viewCount", greaterThanOrEqualTo(0));
    }


    @Test
    @DisplayName("TC-NEG-001: Несуществующий UUID — должен быть 404, но возвращается 400")
    void nonexistentUuidShouldBe404ButIs400() {
        String uuid = "00000000-0000-0000-0000-000000000000";
        given().pathParam("id", uuid)
                .when().get("/statistic/{id}")
                .then()
                .statusCode(404)
                .body("result.message", containsString("statistic 00000000-0000-0000-0000-000000000000 not found"));
    }
}