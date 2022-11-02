package get_request;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Practise extends base_urls.RestfulBaseUrl {
/*
     /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */

    @Test
    public void get04() {

        spec.pathParam("first","booking").
                queryParams("firstname","Almedin","lastname","Alicadic");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",hasItem("Almedin"),"lastname",hasItem("Alicadic"));


    }
}