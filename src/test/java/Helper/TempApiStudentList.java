package Helper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Arrays;


public class TempApiStudentList {
    private final String BASE_URL = "http://localhost:9000";
    private RequestSpecification httpRequest;
    private Response response;
    private JsonPath jp;

    @BeforeClass
    public void startSession() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    @Test
    public void test01GET() {
        response = httpRequest.get("/student/list");
        jp = response.jsonPath();
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void test02POST(){
        JSONObject params=new JSONObject();
        params.put("firstName","Nir");
        params.put("lastName","Hofenberg");
        params.put("email","nir104@gmail.com");
        params.put("programme","QA manual");
        params.put("courses", Arrays.asList("Java","Python","Web"));
        httpRequest.body(params.toJSONString());
        response=httpRequest.post("/student");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),201);
    }
    @Test
    public void test03PUT(){
        JSONObject params=new JSONObject();
        params.put("firstName","Nir");
        params.put("lastName","Hofenberg");
        params.put("email","nir104@gmail.com");
        params.put("programme","QA Automation");
        params.put("courses", Arrays.asList("Java","C#","Web"));
        httpRequest.body(params.toJSONString());
        response=httpRequest.put("/student/101");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void test04DELETE(){
        response=httpRequest.delete("/student/101");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),204);
    }

}
