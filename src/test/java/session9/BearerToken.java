package session9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BearerToken {


    @Test
    public void BearTokenDemo() {
        //create request specification

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://gorest.co.in");
        requestSpecification.basePath("/public/v2/users");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "CodeStudio1");
        jsonObject.put("gender", "Female");
        jsonObject.put("email", "ledacminh0305@gmail.com");
        jsonObject.put("status", "Active");

        String token = "Bearer f4c964a05e6235a6e822b215f3adc2de8633eb7bc294112a9e9301e7e8f93dc2";
        requestSpecification.headers("Authorization", token).contentType(ContentType.JSON).body(jsonObject.toJSONString());
        Response response = requestSpecification.post();

        System.out.println("Response Body " + response.asString());
        System.out.println("Status Code " + response.statusCode());

    }

}
