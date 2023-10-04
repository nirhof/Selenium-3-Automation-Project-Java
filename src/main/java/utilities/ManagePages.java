package utilities;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Eribank.PaymentPage;
import pageObjects.saucedemo.*;
import pageObjects.Eribank.MainPage;
import pageObjects.Eribank.LoginPage;


public class ManagePages extends Base {

    // Web Pages
    public static void initSauceDemo(){
        saucedemoLogin = PageFactory.initElements(driver, pageObjects.saucedemo.LoginPage.class);
        saucedemoBurgerMenu = PageFactory.initElements(driver, BurgerMenu.class);
        saucedemoProducts = PageFactory.initElements(driver, Products.class);
        saucedemoCheckout = PageFactory.initElements(driver, CheckoutPage.class);
        saucedemoCartPage = PageFactory.initElements(driver, YourCartPage.class);
        saucedemoOverviewtPage = PageFactory.initElements(driver, OverviewPage.class);
        saucedemoFooter = PageFactory.initElements(driver, footerSocial.class);
    }

    // Mobile Pages
    public static void initEribank(){

        eribankLogin = new LoginPage(mobileDriver);
        eribankMainPage = new MainPage(mobileDriver);
        eribankPaymentPage = new PaymentPage(mobileDriver);
    }

    public static void initTodo(){
        todoMainPage = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator(){
        calcMainPage = PageFactory.initElements(driver, pageObjects.Calculator.MainPage.class);
    }


}
