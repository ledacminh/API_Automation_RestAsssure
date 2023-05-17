package session3;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_01_GetMethod {

    @Test
    public void test_01(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.asString());
        System.out.println("Response Body " +  response.getBody().asString());
        System.out.println("Response Code " +  response.getStatusCode());
        System.out.println("Response Time " +  response.getTime());
        System.out.println("Response Header " +  response.getHeader("Content-Type"));
        //Validate status code
        //expected status code equal 200
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_02(){
        //given. when, then
        baseURI="https://reqres.in/api/users";

        given()
            .queryParam("page", "2")
            .when()
            .get()
            .then()
            .statusCode(200);

    }
}
