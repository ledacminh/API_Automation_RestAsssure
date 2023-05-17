package session5;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForValidHeader {


    @Test
    public void GettingSingleUser(){
        //Get request specification
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users/2");
        Response response =  requestSpecification.get();
        //Validate response header
        String contentType =   response.getHeader("Content-Type");
        System.out.println("Content-type " + contentType);

        String connection =   response.getHeader("Connection");
        System.out.println("Connection " + connection);

        Headers headers = response.getHeaders();
        for (Header heahder: headers) {
            System.out.println("Key " + heahder.getName() + " Value " + heahder.getValue());
        }

        //Validate header content-type, expected value  Content-Type Value application/json; charset=utf-8

        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
    }
}
