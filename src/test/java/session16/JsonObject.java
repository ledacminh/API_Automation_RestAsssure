package session16;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JsonObject {

    @Test(enabled = false)
    public void test01(){
        JSONObject ob1 = new JSONObject();
        ob1.put("abc","abc");

        JSONObject ob2 = new JSONObject();
        ob2.put("bcd", "bcd");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(ob2);
        jsonArray.add(ob1);

    }
}
