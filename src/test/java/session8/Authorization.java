package session8;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Authorization {

    @Test
    public void basicAuthorization() {
        //Basic authorization
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("http://postman-echo.com");
        requestSpecification.basePath("/basic-auth");

        //perform get request
        Response response = requestSpecification.auth().preemptive().basic("postman", "password").get();
        System.out.println("Response status " + response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void DigestAuth() {
        //Basic authorization
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("http://httpbin.org");
        requestSpecification.basePath("/digest-auth/undefined/prachi/prachi");

        //perform get request
        Response response = requestSpecification.auth().digest("prachi", "parchi").get();
        System.out.println("Response status " + response.statusCode());
        System.out.println(response.asString());
    }
}
