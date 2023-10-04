package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YourCartPage {

    @FindBy(id = "checkout")
    public WebElement btn_Checkout;

    @FindBy(id = "continue-shopping")
    public WebElement btn_continue_shopping;

    @FindBy(css = "button[class='btn btn_secondary btn_small cart_button']")
    public WebElement btn_remove;

    @FindBy(className = "cart_item_label")
    public List<WebElement> products_rows;





}
