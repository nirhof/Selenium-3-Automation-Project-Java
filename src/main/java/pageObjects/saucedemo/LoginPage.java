package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

  @FindBy(id = "user-name")
    private WebElement txt_userName;

    @FindBy(id = "password")
    private WebElement txt_userPassword;

    @FindBy(id = "login-button")
    private WebElement btn_login;

  @FindBy(css = "div[class='error-message-container error']")
  private WebElement txt_error_messege;

  // get elements
  public WebElement getUserNameTextField() {
    return txt_userName;
  }

  public WebElement getUserPasswordTextField() {
    return txt_userPassword;
  }

  public WebElement getLoginButton() {
    return btn_login;
  }

  public WebElement getErrorMessageText() {
    return txt_error_messege;
  }

}
