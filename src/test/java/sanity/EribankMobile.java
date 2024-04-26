package sanity;

import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;


public class EribankMobile extends CommonOps {

    @Test(description = "Test01 - Verify payment process in Eribank App")
    @Description("This test verifies the payment process in the Eribank App. After a successful payment, the user's balance is expected to decrease.")
    public void test01_Payment() {
        // Tap on the "Make Payment" button in the Eribank App
        MobileActions.tap(eribankMainPage.getMakePaymentButton());
        // Perform the payment process with the provided details: phone number, recipient name, amount, and country
        MobileFlows.Pay("0546900249", "nir hofenberg", "20", "Iceland");
        // Verify that the displayed balance text after the payment matches the expected balance
        Verifications.verifyTextInElement(eribankMainPage.getYourBalanceText(), "Your balance is: 80.00$");

    }
}
