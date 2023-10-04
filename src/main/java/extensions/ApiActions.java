package extensions;

import io.qameta.allure.Step;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps {

    @Step("Get Data from server")
    public static Response get(String ParamValues) {
        response = httpRequest.get(ParamValues);
        response.prettyPrint();
        return response;
    }

    @Step("Extract value from JSON")
    public static String extractFromJSON(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }


    @Step("Post data to server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update data to server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }

    @Step("delete data to server")
    public static void delete(String resource) {
        response = httpRequest.delete(resource);
        response.prettyPrint();
    }

}
