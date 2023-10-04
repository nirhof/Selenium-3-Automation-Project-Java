package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

  @FindBy(id = "user-name")
    public WebElement txt_userName;

    @FindBy(id = "password")
    public WebElement txt_userPassword;

    @FindBy(id = "login-button")
    public WebElement btn_login;

  @FindBy(css = "div[class='error-message-container error']")
  public WebElement txt_error_messege;

}
