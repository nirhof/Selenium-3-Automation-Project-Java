package pageObjects.Eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;


public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id = "makePaymentButton")
    private AndroidElement btn_Make_Payment;

    @AndroidFindBy(id = "mortageRequestButton")
    private AndroidElement btn_Mortgage_Request;

    @AndroidFindBy(id = "expenseReportButton")
    private AndroidElement btn_Expense_Report;

    @AndroidFindBy(id = "logoutButton")
    private AndroidElement btn_Logout;

    @AndroidFindBy(xpath = "//*[starts-with(@text, 'Your balance is:')]")
    private AndroidElement txt_YourBalance;


// get elements

    public AndroidElement getMakePaymentButton() {
        return btn_Make_Payment;
    }

    public AndroidElement getMortgageRequestButton() {
        return btn_Mortgage_Request;
    }

    public AndroidElement getExpenseReportButton() {
        return btn_Expense_Report;
    }

    public AndroidElement getLogoutButton() {
        return btn_Logout;
    }

    public AndroidElement getYourBalanceText() {
        return txt_YourBalance;
    }

}
