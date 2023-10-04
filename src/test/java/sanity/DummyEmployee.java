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
    @Description("This test verify employee name")
    public void test01_verify_EmployeeName(){
        Verifications.verifyText(ApiFlows.getEmployeeDetails("data[0].employee_name"),"Tiger Nixon");
    }

}
