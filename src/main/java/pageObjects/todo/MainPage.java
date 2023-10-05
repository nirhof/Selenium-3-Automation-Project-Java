package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(css = "input[placeholder='Create a task']")
    private WebElement txt_CreateTask;

    @FindBy(className = "destroy_19w1q")
    private WebElement btn_X;

    @FindBy(css = "div[class='task_BEG6D task_2vpFW']")
    private List<WebElement> list_tasks;

    // get elements
    public WebElement getCreateTaskTextField() {
        return txt_CreateTask;
    }

    public WebElement getXButton() {
        return btn_X;
    }

    public List<WebElement> getTaskList() {
        return list_tasks;
    }
}
