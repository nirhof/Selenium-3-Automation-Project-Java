package workflows;

import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;

public class Webflows extends CommonOps {


    @Step("business flow - log in")
    public static void login(String userName, String password) {
        saucedemoLogin.txt_userName.clear();
        saucedemoLogin.txt_userPassword.clear();
        UIActions.updateText(saucedemoLogin.txt_userName, userName);
        UIActions.updateText(saucedemoLogin.txt_userPassword, password);
        UIActions.click(saucedemoLogin.btn_login);
    }

    @Step("business flow - log out")
    public static void logout() {

        UIActions.click(saucedemoProducts.btn_Burger);
        UIActions.click(saucedemoBurgerMenu.btn_Logout);
    }

    @Step("business flow - proceed checkout with your information")
    public static void Checkout(String firstName, String lastName, String zipcode) {
        UIActions.click(saucedemoProducts.btn_Cart);
        UIActions.click(saucedemoCartPage.btn_Checkout);
        UIActions.updateText(saucedemoCheckout.txt_FirstName, firstName);
        UIActions.updateText(saucedemoCheckout.txt_LastName, lastName);
        UIActions.updateText(saucedemoCheckout.txt_ZipCode, zipcode);
        UIActions.click(saucedemoCheckout.btn_Continue);
    }

    @Step("business flow - sort products by price high to Low")
    public static void SortProductsHightoLow() {

        UIActions.selectDropDown(saucedemoProducts.btn_sort_products, "Price (high to low)");

    }

    @Step("business flow - sort products by price low to High")
    public static void SortProductsLowtoHigh() {
        UIActions.selectDropDown(saucedemoProducts.btn_sort_products, "Price (low to high)");
    }

    @Step("business flow - add product to cart")
    public static void AddToCart(WebElement element) {
        UIActions.click(element);
    }


    @Step("business flow - Reset app state")
    public static void ResetSite() {

        driver.get("https://www.saucedemo.com/inventory.html");
        UIActions.click(saucedemoProducts.btn_Burger);
        UIActions.click(saucedemoBurgerMenu.btn_ResetApp);
    }

    @Step("business flow - Remove all Items from cart")
    public static void RemoveAllItem(List<WebElement> elements) {
        for (WebElement element: elements) {
            UIActions.click(saucedemoCartPage.btn_remove);
        }
    }

    @Step("business flow - add product to cart")
    public static void AddItemToCart(List <WebElement> elements, int element_index ) {
        WebElement elem = elements.get(element_index);
        UIActions.click(elem);
    }

    @Step("business flow - proceed checkout with customer details from DB")
    public static void CheckoutWithCustomerFromDB() {
        String query = "SELECT firstName, lastName, zipcode FROM Customers WHERE id = '2'";
        List <String> customer = DBActions.getCustomers(query);

        UIActions.click(saucedemoProducts.btn_Cart);
        UIActions.click(saucedemoCartPage.btn_Checkout);
        UIActions.updateText(saucedemoCheckout.txt_FirstName, customer.get(0));
        UIActions.updateText(saucedemoCheckout.txt_LastName, customer.get(1));
        UIActions.updateText(saucedemoCheckout.txt_ZipCode, customer.get(2));
        UIActions.click(saucedemoCheckout.btn_Continue);
    }

}



