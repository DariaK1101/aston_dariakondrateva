package postmanecho;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequestTest {


    @Test
    @DisplayName("PUT Request")
    void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";


        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(requestBody)
                .log().all()
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("form", anEmptyMap())
                .body("json", nullValue());
    }
}