package workflows;


import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {


    @Step("calculate addition: number 1 + number 2")
    public static void addition(WebElement elem1, WebElement elem2) {
        UIActions.click(calcMainPage.btn_clear);
        UIActions.click(elem1);
        UIActions.click(calcMainPage.btn_plus);
        UIActions.click(elem2);
        UIActions.click(calcMainPage.btn_equals);
    }

    @Step("calculate substraction: number 1 - number 2")
    public static void substraction(WebElement elem1, WebElement elem2) {
        UIActions.click(calcMainPage.btn_clear);
        UIActions.click(elem1);
        UIActions.click(calcMainPage.btn_minus);
        UIActions.click(elem2);
        UIActions.click(calcMainPage.btn_equals);
                   }

    @Step("calculate multiply: number 1 * number 2")
    public static void multiply(WebElement elem1, WebElement elem2) {
        UIActions.click(calcMainPage.btn_clear);
        UIActions.click(elem1);
        UIActions.click(calcMainPage.btn_multiply);
        UIActions.click(elem2);
        UIActions.click(calcMainPage.btn_equals);
    }

    @Step("calculate division: number 1 / number 2")
    public static void division(WebElement elem1, WebElement elem2) {
        UIActions.click(calcMainPage.btn_clear);
        UIActions.click(elem1);
        UIActions.click(calcMainPage.btn_divide);
        UIActions.click(elem2);
        UIActions.click(calcMainPage.btn_equals);
    }

}
