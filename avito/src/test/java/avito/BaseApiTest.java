package avito;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;


public abstract class BaseApiTest {
    protected static final String BASE_URL = "https://qa-internship.avito.com/api/1";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    protected static void withJsonContentType() {
        RestAssured.requestSpecification = RestAssured.given()
                .contentType(ContentType.JSON);
    }
}
