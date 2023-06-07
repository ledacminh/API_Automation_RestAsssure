package session15;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JSONMap {


    @Test
    public void test01(){
        Map<String, String> authen  = new HashMap<String, String>();
        authen.put("userName", "admin");
        authen.put("password", "password");
    }

    @Test
    public void test02(){
        Map<String, Object> userData  = new HashMap<String, Object>();
        userData.put("firstName", "Le");
        userData.put("lastName", "Minh");

        ArrayList<String> hobbies = new ArrayList<String>();
        hobbies.add("Music");
        hobbies.add("Films");
        userData.put("Hobbies", hobbies);

        Map<String, Object> techskills  = new HashMap<String, Object>();
        techskills.put("techskill1", "Java");
        techskills.put("techskill2", "Ruby");
        userData.put("TechSkills", techskills);
    }
}
