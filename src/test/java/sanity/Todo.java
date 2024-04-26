package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

public class Todo extends CommonOps {

    @Test(description = "Test01 - add and verify task")
    @Description("This test add a task to todo list and verify it was added")
    public void test01_addAndVerifyNewTask() {
        // Add a new task to the todo list
        ElectronFlows.addNewTask("Learn Java");
        // Get the number of tasks and verify that it is 1
        int Actual = ElectronFlows.getNumberofTasks();
        Verifications.verifyNumber(Actual, 1);
    }

    @Test(description = "Test02 - delete task")
    @Description("This test add a task to todo list and verify it was deleted from todo list")
    public void test02_deleteTask() {
        // Add a new task to the todo list
        ElectronFlows.addNewTask("Bake Cake");

        // Delete the task and verify that the number of tasks is now 0
        ElectronFlows.deleteTask();
        int Actual = ElectronFlows.getNumberofTasks();
        Verifications.verifyNumber(Actual, 0);
    }

    @Test(description = "Test03 - add tasks")
    @Description("This test add tasks to todo list and verify it was added")
    public void test03_addAndVerifyTasks() {
        // Add multiple tasks to the todo list
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn to bake pizza");
        ElectronFlows.addNewTask("make tea");

        // Get the number of tasks and verify that it is 3
        int Actual = ElectronFlows.getNumberofTasks();
        Verifications.verifyNumber(Actual, 3);
    }
}
