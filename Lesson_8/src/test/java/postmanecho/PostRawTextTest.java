package postmanecho;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRawTextTest {

    @Test
    @DisplayName("POST Raw Text")
    void testPostRawText() {
        String rawText = "This is expected to be sent back as part of response body.";
        given()
                .baseUri ("https://postman-echo.com")
                .contentType("text/plain")
                .body(rawText)
                .log().all()
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(rawText));
    }
}