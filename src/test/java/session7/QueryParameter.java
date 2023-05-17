package session7;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class QueryParameter {

    @Test
    public void filterData() {
        //Get request specification for the given request
        RequestSpecification requestSpecification = RestAssured.given();
        //specify url
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users");
        requestSpecification.queryParam("page", 2).queryParam("id", 10);

        Response response = requestSpecification.get();
        String responsebodyString = response.getBody().asString();
        System.out.println("Response Body " + responsebodyString);

        JsonPath jsonPath =  response.jsonPath();
        String email = jsonPath.getString("data.email");

        System.out.println("Email " + email);

    }

}
