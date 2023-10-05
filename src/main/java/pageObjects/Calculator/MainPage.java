package pageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(name = "אפס")
    private WebElement digit_0;
    @FindBy(name = "אחת")
    private WebElement digit_1;

    @FindBy(name = "שתיים")
    private WebElement digit_2;

    @FindBy(name = "שלוש")
    private WebElement digit_3;

    @FindBy(name = "ארבע")
    private WebElement digit_4;

    @FindBy(name = "חמש")
    private WebElement digit_5;

    @FindBy(name = "שש")
    private WebElement digit_6;

    @FindBy(name = "שבע")
    private WebElement digit_7;

    @FindBy(name = "שמונה")
    private WebElement digit_8;

    @FindBy(name = "תשע")
    private WebElement digit_9;

    @FindBy(name = "ועוד")
    private WebElement btn_plus;

    @FindBy(name = "פחות")
    private WebElement btn_minus;

    @FindBy(name = "הכפל ב")
    private WebElement btn_multiply;

    @FindBy(name = "חלק ב")
    private WebElement btn_divide;

    @FindBy(name = "שווה")
    private WebElement btn_equals;

    @FindBy(name = "נקה")
    private WebElement btn_clear;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    private WebElement field_result;

    // get methods
    public WebElement getDigit_0(){
        return digit_0;
    }

    public WebElement getDigit_1(){
        return digit_1;
    }

    public WebElement getDigit_2(){
        return digit_2;
    }

    public WebElement getDigit_3(){
        return digit_3;
    }

    public WebElement getDigit_4(){
        return digit_4;
    }

    public WebElement getDigit_5(){
        return digit_5;
    }

    public WebElement getDigit_6(){
        return digit_6;
    }

    public WebElement getDigit_7(){
        return digit_7;
    }

    public WebElement getDigit_8(){
        return digit_8;
    }

    public WebElement getDigit_9(){
        return digit_9;
    }

    public WebElement getPlusButton(){
        return btn_plus;
    }

    public WebElement getMinusButton(){
        return btn_minus;
    }

    public WebElement getMultiplyButton(){
        return btn_multiply;
    }

    public WebElement getDivideButton(){
        return btn_divide;
    }

    public WebElement getEqualsButton(){
        return btn_equals;
    }

    public WebElement getClearButton(){
        return btn_clear;
    }

    public WebElement getResultField(){
        return field_result;
    }


}
