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
    public AndroidElement btn_Make_Payment;

    @AndroidFindBy(id = "mortageRequestButton")
    public AndroidElement btn_Mortgage_Request;

    @AndroidFindBy(id = "expenseReportButton")
    public AndroidElement btn_Expense_Report;

    @AndroidFindBy(id = "logoutButton")
    public AndroidElement btn_Logout;

    @AndroidFindBy(xpath = "//*[starts-with(@text, 'Your balance is:')]")
    public AndroidElement txt_YourBalance;



}
