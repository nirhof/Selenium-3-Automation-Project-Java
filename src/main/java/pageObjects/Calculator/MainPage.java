package pageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(name = "אפס")
    public WebElement btn_0;
    @FindBy(name = "אחת")
    public WebElement btn_1;

    @FindBy(name = "שתיים")
    public WebElement btn_2;

    @FindBy(name = "שלוש")
    public WebElement btn_3;

    @FindBy(name = "ארבע")
    public WebElement btn_4;

    @FindBy(name = "חמש")
    public WebElement btn_5;

    @FindBy(name = "שש")
    public WebElement btn_6;

    @FindBy(name = "שבע")
    public WebElement btn_7;

    @FindBy(name = "שמונה")
    public WebElement btn_8;

    @FindBy(name = "תשע")
    public WebElement btn_9;

    @FindBy(name = "ועוד")
    public WebElement btn_plus;

    @FindBy(name = "פחות")
    public WebElement btn_minus;

    @FindBy(name = "הכפל ב")
    public WebElement btn_multiply;

    @FindBy(name = "חלק ב")
    public WebElement btn_divide;

    @FindBy(name = "שווה")
    public WebElement btn_equals;

    @FindBy(name = "נקה")
    public WebElement btn_clear;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;
}
