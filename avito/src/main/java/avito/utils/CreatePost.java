package avito.utils;

import avito.dto.ItemCreateRequest;
import io.restassured.RestAssured;

import static avito.constants.CreateConstants.*;

public class CreatePost {

    public static String createAndGetItemId() {

        var request = new ItemCreateRequest(
                SELLER_ID,
                NAME,
                PRiCE,
                STATISTICS
        );

        String  status = RestAssured.given()
                .body(request)
                .when()
                .post("/item")
                .body()
                .jsonPath()
                .getString("status");

        return status.substring(status.lastIndexOf(" ") + 1); // извлекаем UUID

    }
}
