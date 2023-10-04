package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class MobileActions extends CommonOps {

    @Step("Tap on element")
    public static void tap(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        TouchAction action = new TouchAction(mobileDriver);
        action.tap(new TapOptions()
                        .withElement(ElementOption.element(element)))
                .perform();
    }

    @Step("zoom Element")
    public static void zoom(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                        .withElement(element).withCoordinates(x, y - 10))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y - 100));

        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(element).withCoordinates(x, y + 10))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y + 100));
        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();

    }

    @Step("pinch Element")
    public static void pinch(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                        .withElement(element).withCoordinates(x, y - 100))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y - 10));

        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(element).withCoordinates(x, y + 100))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y + 10));
        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();

    }

    @Step("Update Text Element")
    public static void updateText(MobileElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    @Step("Select drop down Element")
    public static void selectDropDown(MobileElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

}


