package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonplaceholderBaseUrl {



    @Test
    public void get01(){

        // 1. Set The Url

        spec.pathParam("first","todos");

        // 2. Set The expected Data ( Put Patch ve Post)

        // 3. Send The request And get The Response
        Response response=given().spec(spec).when().accept(ContentType.JSON).get("/{first}");
        // response.prettyPrint();

        // 4. Do Assertion

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id",hasSize(200),
                        "title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2,7,9));

    }


}