package get_request;


import base_url.JsonplaceholderBaseUrl;
import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static org.testng.Assert.*;

public class Practise extends RestfulBaseUrl {

    @Test
    public void get01(){

       /*
        Given
            https://restful-booker.herokuapp.com/booking/2325
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
         {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-10-27",
        "checkout": "2022-11-07"
    },
    "additionalneeds": "None"
}
     */

        spec.pathParams("first","booking","second",2325);
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //response.prettyPrint();


        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Bradley"),
                        "lastname",equalTo("Pearson"),
                        "totalprice",equalTo(132),
                        "depositpaid",equalTo(false),
                        "bookingdates.checkin",equalTo("2022-10-27"),
                        "bookingdates.checkout",equalTo("2022-11-07"),
                        "additionalneeds",equalTo("None"));






    }






}

