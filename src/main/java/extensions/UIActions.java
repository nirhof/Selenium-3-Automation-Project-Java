package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;


public class UIActions extends CommonOps {

    @Step("Click on Element")
    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    @Step("Insert key")
    public static void PressKey(WebElement element, Keys keyvalue) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keyvalue);
    }

    @Step("Update Text Element Human Speed")
    public static void updateTextHumanSpeed(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        for (char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            element.sendKeys(ch + "");
        }
    }

    @Step("Select drop down Element")
    public static void selectDropDown(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    @Step("mouse Hover Element")
    public static void mouseHover(WebElement element1, WebElement element2) {
        actions.moveToElement(element1).moveToElement(element2).click().build().perform();

    }

    @Step("mouse Hover Element")
    public static void mouseHover(WebElement element1) {
        actions.moveToElement(element1).click().build().perform();


    }

}
