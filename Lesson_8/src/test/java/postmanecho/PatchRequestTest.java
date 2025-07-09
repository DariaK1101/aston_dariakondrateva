package postmanecho;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PatchRequestTest {
    @Test
    @DisplayName("PATCH Request")
    void testPatchRequest() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(body)
                .log().all()
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(body))
                .body("form", anEmptyMap())
                .body("json", nullValue());
    }
}