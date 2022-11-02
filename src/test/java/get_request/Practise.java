package get_request;


import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class Practise extends JsonplaceholderBaseUrl {

    @Test
    public void get09() {
        spec.pathParams("first","todos","second",2);

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println("expectedData"+ expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualData= response.as(HashMap.class);
        System.out.println("actualData"+ actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));





    }
}
