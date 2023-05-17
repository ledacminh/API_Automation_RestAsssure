package session4;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForValidResponse {


    @Test
    public void GetSingleUser(){
        baseURI="https://reqres.in/api/users/2";
        // Get Request Specification of the request

        RequestSpecification requestSpecification = given();

        //Call get method
        Response response =  requestSpecification.get();

        int statusCode =  response.getStatusCode();

        //validate actual status code with expected

        Assert.assertEquals(statusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println("Status line " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","incorrect status line return");
    }

    @Test
    public void GetSingleUserUsingValidationResponse(){
        baseURI="https://reqres.in/api/users/2";
        // Get Request Specification of the request
        RequestSpecification requestSpecification = given();
        //Call get method
        Response response =  requestSpecification.get();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void GettingUser_BEDStyle(){
        given()

        .when()
                .get("https://reqres.in/api/users/2")

        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }
}
