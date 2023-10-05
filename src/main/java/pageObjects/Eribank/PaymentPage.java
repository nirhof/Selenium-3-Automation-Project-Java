package pageObjects.Eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;


public class PaymentPage {

    private AppiumDriver mobileDriver;

    public PaymentPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id = "phoneTextField")
    private AndroidElement txt_phone;

    @AndroidFindBy(id = "nameTextField")
    private AndroidElement txt_name;

    @AndroidFindBy(id = "amountTextField")
    private AndroidElement txt_amount;

    @AndroidFindBy(id = "countryTextField")
    private AndroidElement txt_countrey;

    @AndroidFindBy(id = "countryButton")
    private AndroidElement btn_selectCountry;

    @AndroidFindBy(id = "sendPaymentButton")
    private AndroidElement btn_SendPayment;

    @AndroidFindBy(id = "cancelButton")
    private AndroidElement btn_cancel;

    @AndroidFindBy(id = "button1")
    private AndroidElement btn_Yes;

// get elements

    public AndroidElement getPhoneTextField() {
        return txt_phone;
    }

    public AndroidElement getNameTextField() {
        return txt_name;
    }

    public AndroidElement getAmountTextField() {
        return txt_amount;
    }

    public AndroidElement getCountryTextField() {
        return txt_countrey;
    }

    public AndroidElement getSelectCountryButton() {
        return btn_selectCountry;
    }

    public AndroidElement getSendPaymentButton() {
        return btn_SendPayment;
    }

    public AndroidElement getCancelButton() {
        return btn_cancel;
    }

    public AndroidElement getYesButton() {
        return btn_Yes;
    }



}
