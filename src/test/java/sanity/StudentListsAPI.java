package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;
import java.util.Arrays;
import java.util.List;

@Listeners(utilities.Listeners.class)
public class StudentListsAPI extends CommonOps {

    // java -jar students.jar --server.port=9000

    // http://localhost:9000/student/list

    @Test(description = "Test 01: get student email from student list")
    @Description("This test verify Student email")
    public void test01_verify_Student() {
        Verifications.verifyText(ApiFlows.getStudentProperty("email[99]"), "non.ante.bibendum@risusDonecegestas.edu");
    }

    @Test(description = "Test 02: Add student and verify the email")
    @Description("This test add student to student list and verify it")
    public void test02_AddStudentAndVerify() {
        List<String> courses = Arrays.asList("Java", "Python", "Web");
        ApiFlows.postStudent("nir", "hofenberg", "nir104@gmail.com", "QA manual", courses);
        Verifications.verifyText(ApiFlows.getStudentProperty("email[100]"), "nir104@gmail.com");
    }


    @Test(description = "Test 03: update student and verify the email")
    @Description("This test update student in student list and verify it")
    public void test03_updateStudentAndVerify() {
        List<String> courses = Arrays.asList("Java", "Python", "Web");
        String id = ApiFlows.getStudentProperty("id[100]");
        ApiFlows.updateStudent("nir", "hofenberg", "nir108@gmail.com", "QA manual", courses, id);
        Verifications.verifyText(ApiFlows.getStudentProperty("email[100]"), "nir108@gmail.com");
    }

    @Test(description = "Test 04: delete student and verify status code 204")
    @Description("This test delete student in student list and verify it")
    public void test04_deleteStudentAndVerify() {
        String id = ApiFlows.getStudentProperty("id[100]");
        ApiFlows.deleteStudent(id);
        Verifications.verifyStatusCode(204);
    }

}
