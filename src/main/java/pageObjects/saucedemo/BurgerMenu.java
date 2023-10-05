package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu {

    @FindBy(id = "inventory_sidebar_link")
    private WebElement btn_All_Items;

    @FindBy(id = "about_sidebar_link")
    private WebElement btn_About;

    @FindBy(id = "logout_sidebar_link")
    private WebElement btn_Logout;

    @FindBy(id = "reset_sidebar_link")
    private WebElement btn_ResetApp;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement btn_X;

    // get elements

    public WebElement getAllItemsButton() {
        return btn_All_Items;
    }

    public WebElement getAboutButton() {
        return btn_About;
    }

    public WebElement getLogoutButton() {
        return btn_Logout;
    }

    public WebElement getResetAppButton() {
        return btn_ResetApp;
    }

    public WebElement getXButton() {
        return btn_X;
    }

}
