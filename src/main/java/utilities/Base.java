package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.Eribank.LoginPage;
import pageObjects.saucedemo.*;
import pageObjects.Eribank.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;



public class Base {

    // General

    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    // Web

    protected static WebDriver driver;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected  static DesiredCapabilities dc = new DesiredCapabilities();


    // Page Objects - Web

    protected static pageObjects.saucedemo.LoginPage saucedemoLogin;
    protected static BurgerMenu saucedemoBurgerMenu;
    protected static Products saucedemoProducts;
    protected static CheckoutPage saucedemoCheckout;
    protected static YourCartPage saucedemoCartPage;
    protected static OverviewPage saucedemoOverviewtPage;
    protected static footerSocial saucedemoFooter;

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;


    // Page Objects - Mobile
    protected static LoginPage eribankLogin;
    protected static MainPage eribankMainPage;
    protected static PaymentPage eribankPaymentPage;

    // Page Objects Electron
    protected static pageObjects.todo.MainPage todoMainPage;

    // Page Objects Electron

    protected static pageObjects.Calculator.MainPage calcMainPage;


}
