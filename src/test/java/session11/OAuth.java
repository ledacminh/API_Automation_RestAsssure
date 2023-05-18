package session11;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class OAuth {

    //https://api-m.sandbox.paypal.com/v1/oauth2/token
    @Test
    public void AuthorizationDemoAuth() {

        String clientId = "Af6ZaIMAoqOuIxoWdFXu0-DagBIO-16R84vyhxBkAIGynL8IIuTrue3qP3wAOmAZ52qSV3I240SsXkoP";
        String clientSecret = "EBWh5kucLCxYHILbnQiAHeG6fpz4cFZ1YH4mNXjlGo92BdZkSTr0iLZW_nrSIvKYylpaQ26oVtaJAQd6";


        RequestSpecification requestSpecification = RestAssured.given();

        //specify URL
        requestSpecification.baseUri("https://api-m.sandbox.paypal.com");
        requestSpecification.basePath("/v1/oauth2/token");

        //Basic authorization
        Response response = requestSpecification.auth().preemptive().basic(clientId, clientSecret).param("grant_type", "client_credentials").post();
        System.out.println("Response " + response.prettyPrint());

    }

    @Test
    public void ListInvoice() {
        RestAssured.given().auth().oauth2("accesstoken").queryParam("page", 3).get("url");

    }

}
