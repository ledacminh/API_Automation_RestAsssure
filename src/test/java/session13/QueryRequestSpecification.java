package session13;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class QueryRequestSpecification {


    @Test
    public void createUser(){
        //create request
        //create json data
        JSONObject jsonObject  = new JSONObject();
        jsonObject.put("name", "ledacminh");
        jsonObject.put("job", "Automation Tester");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users");
        requestSpecification.contentType(ContentType.JSON).body(jsonObject.toJSONString());

        //query details from request specification
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);

        //get base URI
        String retrieveBaseURI  = queryableRequestSpecification.getBaseUri();
        String retrieveBasePath = queryableRequestSpecification.getBasePath();
        System.out.println("Base URI " + retrieveBaseURI);
        System.out.println("Base Path " + retrieveBasePath);
        System.out.println("Body " + queryableRequestSpecification.getBody());

        //Get request headers

        Headers headers =  queryableRequestSpecification.getHeaders();
        System.out.println("Header " + headers.toString());





    }
}
