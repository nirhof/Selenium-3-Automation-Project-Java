package pageObjects.Eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;


public class LoginPage {

    private AppiumDriver mobileDriver;

    public LoginPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id = "usernameTextField")
    private AndroidElement txt_username;

    @AndroidFindBy(id = "passwordTextField")
    private AndroidElement txt_password;

    @AndroidFindBy(id = "loginButton")
    private AndroidElement btn_login;

    // get elements
    public AndroidElement getUsernameTextField() {
        return txt_username;
    }

    public AndroidElement getPasswordTextField() {
        return txt_password;
    }

    public AndroidElement getLoginButton() {
        return btn_login;
    }

}
