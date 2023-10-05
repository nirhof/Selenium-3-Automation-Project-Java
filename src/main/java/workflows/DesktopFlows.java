package workflows;


import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {


    @Step("calculate addition: number 1 + number 2")
    public static void addition(WebElement elem1, WebElement elem2) {
        UIActions.click(calcMainPage.getClearButton());
        UIActions.click(elem1);
        UIActions.click(calcMainPage.getPlusButton());
        UIActions.click(elem2);
        UIActions.click(calcMainPage.getEqualsButton());
    }

    @Step("calculate substraction: number 1 - number 2")
    public static void substraction(WebElement elem1, WebElement elem2) {
        UIActions.click(calcMainPage.getClearButton());
        UIActions.click(elem1);
        UIActions.click(calcMainPage.getMinusButton());
        UIActions.click(elem2);
        UIActions.click(calcMainPage.getEqualsButton());
                   }

    @Step("calculate multiply: number 1 * number 2")
    public static void multiply(WebElement elem1, WebElement elem2) {
        UIActions.click(calcMainPage.getClearButton());
        UIActions.click(elem1);
        UIActions.click(calcMainPage.getMultiplyButton());
        UIActions.click(elem2);
        UIActions.click(calcMainPage.getEqualsButton());
    }

    @Step("calculate division: number 1 / number 2")
    public static void division(WebElement elem1, WebElement elem2) {
        UIActions.click(calcMainPage.getClearButton());
        UIActions.click(elem1);
        UIActions.click(calcMainPage.getDivideButton());
        UIActions.click(elem2);
        UIActions.click(calcMainPage.getEqualsButton());
    }

}
