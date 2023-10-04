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
        DesktopFlows.addition(calcMainPage.btn_1, calcMainPage.btn_3);
        WebElement Actual = calcMainPage.field_result;
        Verifications.verifyTextInElement(Actual,"התצוגה היא 4");
    }

    @Test(description = "Test02 - Verify Multiply")
    @Description("This test verify number 1 X number 3")
    public void test02_verifyMultiplyTwoNumbers() {
        DesktopFlows.multiply(calcMainPage.btn_1, calcMainPage.btn_3);
        WebElement Actual = calcMainPage.field_result;
        Verifications.verifyTextInElement(Actual,"התצוגה היא 3");
    }

    @Test(description = "Test03 - Verify division by 0")
    @Description("This test verify division by 0")
    public void test03_verifyDivisionByZero() {
        DesktopFlows.division(calcMainPage.btn_6, calcMainPage.btn_0);
        WebElement Actual = calcMainPage.field_result;
        Verifications.verifyTextInElement(Actual,"התצוגה היא לא ניתן לחלק באפס");
    }
}

