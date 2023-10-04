package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.Webflows;

@Listeners(utilities.Listeners.class)
public class SauceDemoWebTestLogin extends CommonOps {

    @Test(description = "Test09 - Verify login Errors messages", dataProvider = "data-provider", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verify error messages in the login process")
    public void test9_verifyLogInErrors(String user, String password, String expected) {
        driver.get("https://www.saucedemo.com/");
        Webflows.login(user, password);
        Verifications.verifyTextInElement(saucedemoLogin.txt_error_messege, expected);

    }
}
