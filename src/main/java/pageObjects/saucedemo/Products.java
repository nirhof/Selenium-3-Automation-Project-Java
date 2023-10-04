package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Products {

    @FindBy(className = "inventory_item")
    public List <WebElement> inventory_Products;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement btn_Burger;

    @FindBy(className = "product_sort_container")
    public WebElement btn_sort_products;

    @FindBy(className = "inventory_item_price")
    public WebElement products_price;

    @FindBy(id = "shopping_cart_container")
    public WebElement btn_Cart;

    @FindBy(css = "button[class='btn btn_primary btn_small btn_inventory']")
    public List <WebElement> btn_add_to_cart;



}
