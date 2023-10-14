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
        saucedemoLogin.getUserNameTextField().clear();
        saucedemoLogin.getUserPasswordTextField().clear();
        UIActions.updateText(saucedemoLogin.getUserNameTextField(), userName);
        UIActions.updateText(saucedemoLogin.getUserPasswordTextField(), password);
        UIActions.click(saucedemoLogin.getLoginButton());
    }

    @Step("business flow - log out")
    public static void logout() {

        UIActions.click(saucedemoProducts.getBurgerButton());
        UIActions.click(saucedemoBurgerMenu.getLogoutButton());
    }

    @Step("business flow - proceed checkout with your information")
    public static void Checkout(String firstName, String lastName, String zipcode) {
        UIActions.click(saucedemoProducts.getCartButton());
        UIActions.click(saucedemoCartPage.getCheckoutButton());
        UIActions.updateText(saucedemoCheckout.getFirstNameTextField(), firstName);
        UIActions.updateText(saucedemoCheckout.getLastNameTextField(), lastName);
        UIActions.updateText(saucedemoCheckout.getZipCodeTextField(), zipcode);
        UIActions.click(saucedemoCheckout.getContinueButton());
    }

    @Step("business flow - sort products by price high to Low")
    public static void SortProductsHightoLow() {

        UIActions.selectDropDown(saucedemoProducts.getSortProductsButton(), "Price (high to low)");

    }

    @Step("business flow - sort products by price low to High")
    public static void SortProductsLowtoHigh() {
        UIActions.selectDropDown(saucedemoProducts.getSortProductsButton(), "Price (low to high)");
    }

    @Step("business flow - add product to cart")
    public static void AddToCart(WebElement element) {
        UIActions.click(element);
    }


    @Step("business flow - Reset app state")
    public static void ResetSite() {

        driver.get("https://www.saucedemo.com/inventory.html");
        UIActions.click(saucedemoProducts.getBurgerButton());
        UIActions.click(saucedemoBurgerMenu.getResetAppButton());
    }

    @Step("business flow - Remove all Items from cart")
    public static void RemoveAllItem(List<WebElement> elements) {
        for (WebElement element : elements) {
            UIActions.click(saucedemoCartPage.getRemoveButton());
        }
    }

    @Step("business flow - add product to cart")
    public static void AddItemToCart(List<WebElement> elements, int element_index) {
        WebElement elem = elements.get(element_index);
        UIActions.click(elem);
    }

    @Step("business flow - proceed checkout with customer details from DB")
    public static void CheckoutWithCustomerFromDB() {
        String query = "SELECT firstName, lastName, zipcode FROM Customers WHERE id = '2'";
        List<String> customer = DBActions.getCustomers(query);

        UIActions.click(saucedemoProducts.getCartButton());
        UIActions.click(saucedemoCartPage.getCheckoutButton());
        UIActions.updateText(saucedemoCheckout.getFirstNameTextField(), customer.get(0));
        UIActions.updateText(saucedemoCheckout.getLastNameTextField(), customer.get(1));
        UIActions.updateText(saucedemoCheckout.getZipCodeTextField(), customer.get(2));
        UIActions.click(saucedemoCheckout.getContinueButton());
    }

}



