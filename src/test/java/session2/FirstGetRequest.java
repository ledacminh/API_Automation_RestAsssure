package session2;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FirstGetRequest {
//https://reqres.in/api/users/2

    @Test
    public void testcase_01() {
        Response response = get("https://reqres.in/api/users/2");
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

}
