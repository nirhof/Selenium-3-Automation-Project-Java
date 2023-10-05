package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add new task to the list")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoMainPage.getCreateTaskTextField(), taskName);
        UIActions.PressKey(todoMainPage.getCreateTaskTextField(), Keys.RETURN);

    }

    @Step("Count and return number of tasks")
    public static int getNumberofTasks() {
        return todoMainPage.getTaskList().size();
    }

    @Step("Empty lists from tasks")
    public static void emptyList() {
        for (int i = 0; i < getNumberofTasks(); i++) {
            UIActions.mouseHover(todoMainPage.getXButton());
        }
    }

    @Step("delete a task")
    public static void deleteTask() {
        UIActions.click(todoMainPage.getXButton());
    }

}
