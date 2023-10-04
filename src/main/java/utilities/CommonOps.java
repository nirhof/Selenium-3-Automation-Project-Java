package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import workflows.ElectronFlows;
import workflows.MobileFlows;
import workflows.Webflows;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.lang.reflect.Method;

public class CommonOps extends Base {

    // Method Name: getData
    // Method Description: This Method get the data from xml file
    // Method Parameters: String of the node name of the xml whose content is to be retrieved
    // Method Return: String of the content of the specified XML node
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml"); // Load XML file and set up DocumentBuilder
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    // Method Name : initBrowser
    // Method Description: Initializes a web browser based on the provided browser type.
    // Method Parameters : String of browserType - The type of browser to be initialized (e.g., "chrome", "firefox").
    // Throws : RuntimeException - If an invalid browser type is provided.
    public void initBrowser(String browserType) {
        // Check which browser type is provided
        if (browserType.equalsIgnoreCase("chrome")) // Initialize Chrome WebDriver
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox")) // Initialize Firefox WebDriver
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("edge")) // Initialize Edge WebDriver
            driver = initEdgeDriver();
        else if (browserType.equalsIgnoreCase("ie")) // Initialize Internet Explorer WebDriver
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid browser type"); // Throw an exception for invalid browser types

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initSauceDemo();   // Initialize components for managing pages
        actions = new Actions(driver);  // Initialize Actions class for performing advanced user interactions
        // Log in using provided username and password
        Webflows.login(getData("userName"), getData("password"));
    }


    // Method Name: initChromeDriver
    // Method Description : Initializes and returns a Chrome WebDriver.
    // Method Return: An instance of Chrome WebDriver.
    public static WebDriver initChromeDriver() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\JavaCourse\\Projects\\FinalProject\\FinalProject (2)\\FinalProject\\FinalProject\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    // Method Name: initFirefoxDriver
    // Method Description : Initializes and returns a Firefox WebDriver.
    // Method Return: An instance of Firefox WebDriver.
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    // Method Name: initIEDriver
    // Method Description: Initializes and returns an Internet Explorer WebDriver.
    // Method Return: An instance of Internet Explorer WebDriver.
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    // Method Name: initEdgeDriver
    // Method Description : Initializes and returns an Edge WebDriver.
    // Method Return: An instance of Edge WebDriver.
    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    // Method Name: initMobile
    // Method Description: Initializes the mobile testing environment and sets up the driver.
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try { // Connect to the Appium server
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {    // Handle connection exception
            throw new RuntimeException("Can not connect to appium server, see details: " + e);
        }
        ManagePages.initEribank();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        actions = new Actions(mobileDriver);
        mobileDriver.resetApp();
        MobileFlows.Login(getData("EribankUserName"), getData("EribankPassword"));
    }

    // Method Name: initApi
    // Method Description: Initializes the API testing environment and sets up the HTTP request.
    public static void initAPI() {
        // Set the base URI for the API
        RestAssured.baseURI = getData("url_base_API");
        httpRequest = RestAssured.given(); // Initialize the HTTP request

    }

    // Method Name : initElectronAppTesting
    // Method Description : Initializes the Electron application testing environment and sets up the ChromeDriver.
    public static void initElectron() {

        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        actions = new Actions(driver);
    }

    // Method Name : initDesktop
    // Method Description : Initializes the desktop application testing environment and sets up the WindowsDriver.
    public static void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (MalformedURLException e) {
            System.out.println("Can not connect to Appium server, see details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initCalculator();
    }


    // Method Name : startSession
    // Method Description : Starts a session based on the provided PlatformName from xml file.
    // Method Parameters : String PlatformName - The name of the platform ("web", "mobile", "api", "electron", "desktop").
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));
    }

    // Method Name : closeSession
    // Method Description: Closes the session.
    @AfterClass
    public void closeSession() {
        if (!platform.equalsIgnoreCase("api")) {
            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
            ManageDB.closeConnection();
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    // Method Name : beforeMethod
    // Method Description: Executes before each test MonteScreenRecorder.startRecord (if platform is not api)
    // Method Parameters : Method - The test being executed.
    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api"))
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    // Method Name : afterMethod
    // Method Description: Executes after each test If the platform is Electron,
    // it performs a specific action to empty a list.
    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("electron"))
            ElectronFlows.emptyList();
        ;
    }

    // Method Name : goLoginPage
    // Method Description: Navigates the webdriver to the login page by opening the specified URL.
    public void goLoginPage() {
        driver.get(getData("url"));
    }

}



