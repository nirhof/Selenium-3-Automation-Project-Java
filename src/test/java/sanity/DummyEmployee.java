package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class DummyEmployee extends CommonOps {

    @Test (description = "Test 01: get employee name from DummyEmployee")
    @Description("This test verifies the retrieval of employee name from DummyEmployee data")
    public void test01_verify_EmployeeName(){
        // Get the employee name using the API and the provided employee index (data[0])
        String actualEmployeeName = ApiFlows.getEmployeeDetails("data[0].employee_name");

        // Verify that the retrieved employee name matches the expected name "Tiger Nixon"
        Verifications.verifyText(actualEmployeeName, "Tiger Nixon");    }

}
