package session3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_02_PostMethod {

    @Test
    public void test_01() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "morpheus");
        jsonObject.put("job", "leader");

        RestAssured.baseURI = "https://reqres.in/api/users";
        RestAssured.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when().post()
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void test_02() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "morpheus");
        jsonObject.put("job", "zion resident");

        RestAssured.baseURI = "https://reqres.in/api/users/2";
        RestAssured.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when().patch()
                .then()
                .statusCode(200)
                .log().all();
    }

}
