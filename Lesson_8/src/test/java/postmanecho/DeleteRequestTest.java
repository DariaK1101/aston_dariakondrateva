package postmanecho;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTest {

    @Test
    @DisplayName("DELETE Request")
    void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";


        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(requestBody)
                .log().all()
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("form", anEmptyMap())
                .body("json", nullValue());
    }
}