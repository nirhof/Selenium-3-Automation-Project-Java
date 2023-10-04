package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    @FindBy(id = "first-name")
    public WebElement txt_FirstName;

    @FindBy(id = "last-name")
    public WebElement txt_LastName;

    @FindBy(id = "postal-code")
    public WebElement txt_ZipCode;

    @FindBy(id = "continue")
    public WebElement btn_Continue;

    @FindBy(id = "cancel")
    public WebElement btn_Cancel;





}
