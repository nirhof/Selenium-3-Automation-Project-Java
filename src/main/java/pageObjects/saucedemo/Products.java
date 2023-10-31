package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Products {

    @FindBy(className = "inventory_item")
    private List <WebElement> inventory_Products;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement btn_Burger;

    @FindBy(className = "product_sort_container")
    private WebElement btn_sort_products;

    @FindBy(className = "inventory_item_price")
    private WebElement products_price;

    @FindBy(id = "shopping_cart_container")
    private WebElement btn_Cart;

//    @FindBy(css = "button[class='btn btn_primary btn_small btn_inventory']")
//    private List <WebElement> btn_add_to_cart;

    @FindBy(css = "button[class]")
    private List <WebElement> btn_add_to_cart;


    // get elements

    public List<WebElement> getInventoryProducts() {
        return inventory_Products;
    }

    public WebElement getBurgerButton() {
        return btn_Burger;
    }

    public WebElement getSortProductsButton() {
        return btn_sort_products;
    }

    public WebElement getProductsPrice() {
        return products_price;
    }

    public WebElement getCartButton() {
        return btn_Cart;
    }

    public List<WebElement> getAddToCartButtons() {
        return btn_add_to_cart;
    }



}
