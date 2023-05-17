package session6;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForJsonResponse {

    @Test
    public void UserListResponseBody() {
        //Get Request specification Reference
        RequestSpecification requestSpecification = RestAssured.given();
        //Specify base URI
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users?page=2");
        //create get request
        Response response = requestSpecification.get();

        //read response body

        ResponseBody responseBody = response.getBody();

        String responseString = responseBody.asString();
        System.out.println("Body " + responseString);
        //Check for presence of George in response body

        Assert.assertTrue(responseString.contains("George"), "check for");

        //Get json path view of response body

        JsonPath jsonPathView = responseBody.jsonPath();
        //x.data[0].email

        String firstEmail = jsonPathView.get("data[0].email");

        Assert.assertEquals(firstEmail, "george.bluth@reqres.in");


    }
}
