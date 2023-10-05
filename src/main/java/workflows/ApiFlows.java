package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
import java.util.List;

public class ApiFlows extends CommonOps {

    @Step("business flow - Get employee property")
    public static String getEmployeeDetails(String jpath) {
        response = ApiActions.get("/api/v1/employees");
        return ApiActions.extractFromJSON(response, jpath);
    }


    @Step("business flow - Get Student property")
    public static String getStudentProperty(String jpath) {
        response = ApiActions.get("/student/list");
        return ApiActions.extractFromJSON(response, jpath);
    }


    @Step("business flow - Create new student")
    public static void postStudent(String firstName, String lastName, String email, String programme, List<String> courses) {

        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        params.put("courses", courses);
        ApiActions.post(params, "/student");
    }

    @Step("business flow - Update Existing student")
    public static void updateStudent(String firstName, String lastName, String email, String programme, List<String> courses, String id) {

        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        params.put("courses", courses);
        ApiActions.put(params, "/student/" + id);
    }

    @Step("business flow - Update Existing student")
    public static void deleteStudent(String id) {
        ApiActions.delete("/student/" + id);
    }


}
