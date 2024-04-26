package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.Webflows;

public class SauceDemoWebTestLogin extends CommonOps {

    @Test(description = "Test09 - Verify login Errors messages", dataProvider = "data-provider", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verify error messages in the login process")
    public void test9_verifyLogInErrors(String user, String password, String expected) {
        // Navigate to the Saucedemo website
        driver.get("https://www.saucedemo.com/");
        // Perform login with provided user and password
        Webflows.login(user, password);
        // Verify the displayed error message matches the expected error message
        Verifications.verifyTextInElement(saucedemoLogin.getErrorMessageText(), expected);

    }

}
