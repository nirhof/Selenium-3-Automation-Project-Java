package extensions;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
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

    @Step("Verify text in element")
    public static void verifyTextInElementWithAtrribute(WebElement element, String expectedText) {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.textToBePresentInElement(element, expectedText)));

        System.out.println("actual text is " + element.getText());
        System.out.println("expected text is " + expectedText);
        assertEquals(element.getText(), expectedText);
    }

    @Step("Verify element is disabled")
    public static void verifyElementIsDisabled(WebElement element) {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.attributeToBe(element,"disabled","true")));
        assertEquals(element.getAttribute("disabled"), "true");
    }

    @Step("Verify text contained in element")
    public static void verifyTextContainedInElement(WebElement element, String expectedText) {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.textToBePresentInElement(element, expectedText)));

        System.out.println("actual text is " + element.getText());
        System.out.println("expected text is " + expectedText);
        assertTrue(element.getText().contains(expectedText));
    }

    @Step("Verify elements are empty")
    public static void verifyElementsAreEmpty(List<WebElement> elements) {
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
            String elementText = "";

            // Check if the element has a "value" attribute
            if (element.getAttribute("value") != null) {
                elementText = element.getAttribute("value");
            }
            // If "value" attribute is null, try to get text using getText()
            else {
                elementText = element.getText();
            }

            System.out.println("Element text is: " + elementText);
            softAssert.assertEquals(elementText, "", "Element is not empty.");
        }

        softAssert.assertAll("Some elements are not empty");
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
        assertEquals(response.getStatusCode(), exptected);
    }


    @Step("Verify text to text")
    public static void verifyStringToString(String actualText, String expectedText) {
        System.out.println("actual text is " + actualText);
        System.out.println("expected text is " + expectedText);
        assertEquals(actualText, expectedText);
    }

    @Step("Verify list of element equals to list of string text")
    public static void VerifyTextInElements(List<WebElement> elements, List<String> expectedStrings) {

        // Check if the sizes of the lists are different
        if (elements.size() != expectedStrings.size()) {
            softAssert.fail("Lists have different sizes");
        }

        // Iterate through the elements and compare their text
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            String actualText = element.getText();

            if (actualText.isEmpty()) {
                actualText = element.getAttribute("value");
            }

            String expectedText = expectedStrings.get(i);
            System.out.println("expected text is : " + expectedText);
            System.out.println("element text is : " + actualText);

            // Compare the actual text with the expected text
            softAssert.assertEquals(actualText, expectedText, "Text mismatch at index " + i);
            System.out.println("element text is : " + actualText);
        }

        // Perform assertAll and return the result
        softAssert.assertAll();
    }
}





