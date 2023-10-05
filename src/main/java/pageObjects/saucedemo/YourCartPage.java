package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YourCartPage {

    @FindBy(id = "checkout")
    private WebElement btn_Checkout;

    @FindBy(id = "continue-shopping")
    private WebElement btn_continue_shopping;

    @FindBy(css = "button[class='btn btn_secondary btn_small cart_button']")
    private WebElement btn_remove;

    @FindBy(className = "cart_item_label")
    private List<WebElement> products_rows;

// get elements

    public WebElement getCheckoutButton() {
        return btn_Checkout;
    }

    public WebElement getContinueShoppingButton() {
        return btn_continue_shopping;
    }

    public WebElement getRemoveButton() {
        return btn_remove;
    }

    public List<WebElement> getProductRows() {
        return products_rows;
    }




}
