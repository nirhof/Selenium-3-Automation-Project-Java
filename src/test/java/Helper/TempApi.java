package Helper;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TempApi {

    RequestSpecification httpRequest;
    Response response;
    String url = "https://dummy.restapiexample.com";

    String employeeId;
    String employeeName;
    String employeeSalary;
    String employeeAge;
    String employeeImage;

    @Test
    public void testApi_getEmployeeData() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();

        employeeId = "2";

        response = httpRequest.get("/api/v1/employee/"+employeeId);
        response.prettyPrint();

    }
//
//    @Test
//    public void testApi_postEmployeeData() {
//
//
//
//        RestAssured.baseURI = url;
//        httpRequest = RestAssured.given();
//
//
//        String employeeName = "roger stone";
//        String employeeSalary =" 10000";
//        String employeeAge = "63";
//
//
//        JSONObject params=new JSONObject();
//        params.put("name",employeeName);
//        params.put("salary",employeeSalary);
//        params.put("age",employeeAge);
//
//        httpRequest.header("Content-Type","application/json");
//
//        httpRequest.body(params.toJSONString());
//        response =httpRequest.post("/create");
//
//        response.prettyPrint();


//    }


}
