package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(css = "input[placeholder='Create a task']")
    public WebElement txt_CreateTask;

    @FindBy(className = "destroy_19w1q")
    public WebElement btn_X;

    @FindBy(css = "div[class='task_BEG6D task_2vpFW']")
    public List<WebElement> list_tasks;

}
