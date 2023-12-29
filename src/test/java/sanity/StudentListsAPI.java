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
        // Verify that the student email matches the expected value
        Verifications.verifyText(ApiFlows.getStudentProperty("email[99]"), "non.ante.bibendum@risusDonecegestas.edu");
    }

    @Test(description = "Test 02: Add student and verify the email")
    @Description("This test add student to student list and verify it")
    public void test02_AddStudentAndVerify() {
        // Define courses for the new student
        List<String> courses = Arrays.asList("Java", "Python", "Web");
        // Post a new student to the API
        ApiFlows.postStudent("nir", "hofenberg", "nir104@gmail.com", "QA manual", courses);
        // Verify that the added student's email matches the expected value
        Verifications.verifyText(ApiFlows.getStudentProperty("email[100]"), "nir104@gmail.com");
    }


    @Test(description = "Test 03: update student and verify the email")
    @Description("This test update student in student list and verify it")
    public void test03_updateStudentAndVerify() {
        // Define courses for the updated student
        List<String> courses = Arrays.asList("Java", "Python", "Web");
        // Define courses for the updated student
        String id = ApiFlows.getStudentProperty("id[100]");
        // Update the student information via API
        ApiFlows.updateStudent("nir", "hofenberg", "nir108@gmail.com", "QA manual", courses, id);
        // Verify that the updated student's email matches the expected value
        Verifications.verifyText(ApiFlows.getStudentProperty("email[100]"), "nir108@gmail.com");
    }

    @Test(description = "Test 04: delete student and verify status code 204")
    @Description("This test delete student in student list and verify it")
    public void test04_deleteStudentAndVerify() {
        // Get the ID of the student to be deleted
        String id = ApiFlows.getStudentProperty("id[100]");

        // Delete the student via API and verify the status code
        ApiFlows.deleteStudent(id);
        Verifications.verifyStatusCode(204);
    }

}
