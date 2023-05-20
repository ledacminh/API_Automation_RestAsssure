package session12;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Deserialization {

    @Test
    public void createUser() {
        //create Request Specification

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users");
        //create request body
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "morpheus");
        jsonObject.put("job", "leader");

        //perform post request

        Response response = requestSpecification.contentType(ContentType.JSON).body(jsonObject.toJSONString()).post();
        ResponseBody responseBody = response.getBody();
        //Deserialization json response to class object

        JSONPostRequestResponse jsonPostRequestResponse = responseBody.as(JSONPostRequestResponse.class);

        System.out.println("Name " + jsonPostRequestResponse.name);
    }

    @Test
    public void createUser2()
    {
        //https://reqres.in/api/users
        //create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //specify URL
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users");

        //create request body
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Prachi");
        jsonData.put("job", "QA");


        //perform post request
        Response response = requestSpec.
                contentType(ContentType.JSON).
                body(jsonData.toJSONString()).
                post();

        ResponseBody responseBody = response.getBody();

        //Deserialize responseBody i.e json resoponse body to class object

        //Class<T> is a generic form of any class of type T which is also referred to as template class.

        JSONPostRequestResponse responseClass = responseBody.as(JSONPostRequestResponse.class);

        Assert.assertEquals(responseClass.name, "Prachi","check for name.");
        Assert.assertEquals(responseClass.job, "QA","check for QA.");


    }
}
