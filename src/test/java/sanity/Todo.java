package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class Todo extends CommonOps {

    @Test(description = "Test01 - add and verify task")
    @Description("This test add a task to todo list and verify it was added")
    public void test01_addAndVerifyNewTask() {
        ElectronFlows.addNewTask("Learn Java");
        int Actual = ElectronFlows.getNumberofTasks();
        Verifications.verifyNumber(Actual, 1);
    }

    @Test(description = "Test02 - delete task")
    @Description("This test add a task to todo list and verify it was deleted from todo list")
    public void test02_deleteTask() {
        ElectronFlows.addNewTask("Bake Cake");
        ElectronFlows.deleteTask();
        int Actual = ElectronFlows.getNumberofTasks();
        Verifications.verifyNumber(Actual, 0);
    }

    @Test(description = "Test03 - add tasks")
    @Description("This test add tasks to todo list and verify it was added")
    public void test03_addAndVerifyTasks() {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn to bake pizza");
        ElectronFlows.addNewTask("make tea");
        int Actual = ElectronFlows.getNumberofTasks();
        Verifications.verifyNumber(Actual, 3);
    }
}
