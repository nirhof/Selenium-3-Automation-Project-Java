package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage {

   @FindBy(css = "div[Class='summary_info_label summary_total_label']")
    public WebElement field_total;

    @FindBy(id = "cancel")
    public WebElement btn_cancel;

    @FindBy(id = "finish")
    public WebElement btn_finish;





}
