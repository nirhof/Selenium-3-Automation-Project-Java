package sanity;

import extensions.MobileActions;
import extensions.Verifications;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;


@Listeners(utilities.Listeners.class)
public class EribankMobile extends CommonOps {

    @Test(description = "Test01 - Verify payment process in Eribank App")
    @Description("This test verify payment process in Eribank App. After successful payment the user Balance will go down")
    public void test01_Payment() {

        MobileActions.tap(eribankMainPage.getMakePaymentButton());
        MobileFlows.Pay("0546900249", "nir hofenberg", "20", "Iceland");
        Verifications.verifyTextInElement(eribankMainPage.getYourBalanceText(), "Your balance is: 80.00$");

    }
}
