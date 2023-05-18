package session10;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APIKeyAuthorization {

    @Test
    public void GetWeatherDataCity() {
        //create request specification
        //https://api.openweathermap.org/data/2.5/weather?id=524901&lang=fr&appid={API key}
        //api key   749e6c771e7b6d6375510379c898d4bb
        String apikey = "749e6c771e7b6d6375510379c898d4bb";
        String city = "delhi";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("q", city).queryParam("appid", "749e6c771e7b6d6375510379c898d4bb");
        requestSpecification.baseUri("https://api.openweathermap.org");
        requestSpecification.basePath("/data/2.5/weather");

        Response response = requestSpecification.get();

        System.out.println("Response status " + response.statusCode());
        System.out.println("Response body " + response.body().asString());

    }

}
