package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu {

    @FindBy(id = "inventory_sidebar_link")
    public WebElement btn_All_Items;

    @FindBy(id = "about_sidebar_link")
    public WebElement btn_About;

    @FindBy(id = "logout_sidebar_link")
    public WebElement btn_Logout;

    @FindBy(id = "reset_sidebar_link")
    public WebElement btn_ResetApp;

    @FindBy(id = "react-burger-cross-btn")
    public WebElement btn_X;

}
