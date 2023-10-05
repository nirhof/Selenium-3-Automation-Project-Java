package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    @FindBy(id = "first-name")
    private WebElement txt_FirstName;

    @FindBy(id = "last-name")
    private WebElement txt_LastName;

    @FindBy(id = "postal-code")
    private WebElement txt_ZipCode;

    @FindBy(id = "continue")
    private WebElement btn_Continue;

    @FindBy(id = "cancel")
    private WebElement btn_Cancel;

    // get elements
    public WebElement getFirstNameTextField() {
        return txt_FirstName;
    }

    public WebElement getLastNameTextField() {
        return txt_LastName;
    }

    public WebElement getZipCodeTextField() {
        return txt_ZipCode;
    }

    public WebElement getContinueButton() {
        return btn_Continue;
    }

    public WebElement getCancelButton() {
        return btn_Cancel;
    }






}
