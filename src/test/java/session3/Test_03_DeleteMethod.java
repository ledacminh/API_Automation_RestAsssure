package session3;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test_03_DeleteMethod {
    @Test
    public void test_01() {

        RestAssured.baseURI = "https://reqres.in/api/users/3";
        RestAssured.given()
                .when().delete()
                .then().statusCode(204)
                .log().all();

    }
}
