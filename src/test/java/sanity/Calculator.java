package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class Calculator extends CommonOps {

    @Test(description = "Test01 - Verify addition")
    @Description("This test verify number 1 + number 3")
    public void test01_verifyAddTwoNumbers() {
        // Perform addition operation
        DesktopFlows.addition(calcMainPage.getDigit_1(), calcMainPage.getDigit_3());
        // Get the actual result from the calculator
        WebElement Actual = calcMainPage.getResultField();
        // Verify that the actual result matches the expected result
        Verifications.verifyTextInElement(Actual,"התצוגה היא 4");
    }

    @Test(description = "Test02 - Verify Multiply")
    @Description("This test verify number 1 X number 3")
    public void test02_verifyMultiplyTwoNumbers() {
        // Perform multiplication operation
        DesktopFlows.multiply(calcMainPage.getDigit_1(), calcMainPage.getDigit_3());
        // Get the actual result from the calculator
        WebElement Actual = calcMainPage.getResultField();
        // Verify that the actual result matches the expected result
        Verifications.verifyTextInElement(Actual,"התצוגה היא 3");
    }

    @Test(description = "Test03 - Verify division by 0")
    @Description("This test verify division by 0")
    public void test03_verifyDivisionByZero() {
        // Perform division by 0 operation
        DesktopFlows.division(calcMainPage.getDigit_6(), calcMainPage.getDigit_0());
        // Get the actual result from the calculator
        WebElement Actual = calcMainPage.getResultField();
        // Verify that the actual result matches the expected result for division by 0
        Verifications.verifyTextInElement(Actual,"התצוגה היא לא ניתן לחלק באפס");
    }
}

