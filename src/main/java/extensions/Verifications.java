package extensions;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify element is displayed")
    public static void verifyElementIsDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertTrue(element.isDisplayed());
    }

    @Step("Verify text in element")
    public static void verifyTextInElement(WebElement element, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expectedText);
    }

    @Step("Verify number Of elements")
    public static void numberOfElements(List<WebElement> elements, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size() - 1)));
        assertEquals(elements.size(), expected);
    }

    @Step("Verify visibility  Of elements (soft Assertion")
    public static void visibilityOfElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            softAssert.assertTrue(element.isDisplayed(), element.getText() + "is not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify element Visually")
    public static void visualElement(String expectedImageName) {
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File: " + findFailed);
            fail("Error Comparing Image File: " + findFailed);
        }

    }

    @Step("Verify there are no elements")
    public static void verifyNoElements(List<WebElement> elements) {
        assertTrue((elements.size() == 0));
    }


    @Step("Verify text in mobile element")
    public static void verifyTextInElement(MobileElement mobileElement, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
        assertEquals(mobileElement.getText(), expectedText);
    }

    @Step("Verify text equals to text")
    public static void verifyText(String actual, String expetcted) {
        assertEquals(actual, expetcted);
    }

    @Step("Verify number equals to number")
    public static void verifyNumber(int actual, int expetcted) {
        assertEquals(actual, expetcted);
    }

    @Step("Verify request response status code equals to text")
    public static void verifyStatusCode(int exptected) {
        assertEquals(response.getStatusCode(),exptected);
    }

}




