package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.Webflows;
import java.util.ArrayList;
import java.util.List;


public class SauceDemoWeb extends CommonOps {


    @Test(description = "Test01 - Verify number of products")
    @Description("This test verify the number of products in the products page")
    public void test01_verifyNumberOfProducts() {
        // Verify the number of products on the products page
        Verifications.numberOfElements(saucedemoProducts.getInventoryProducts(), 6);
    }

    @Test(description = "Test02 - Verify highest price")
    @Description("This test verify the price of the most expensive item")
    public void test02_verifyPriceOfMostExpensiveItem() {
        // Sort products from high to low to find the most expensive item
        Webflows.SortProductsHightoLow();
        // Verify that the price of the most expensive item is $49.99
        Verifications.verifyTextInElement(saucedemoProducts.getProductsPrice(), "$49.99");
    }

    @Test(description = "Test03 - Verify product Total price")
    @Description("This test verify the total price of a product in the Overview page")
    public void test03_verifyTotalPrice() {
        // Sort products from low to high
        Webflows.SortProductsLowtoHigh();
        // Add a product to the cart, proceed to checkout, and verify the total price
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 0);
        Webflows.Checkout("Nir", "Hofenberg", "215454");
        Verifications.verifyTextInElement(saucedemoOverviewtPage.getFieldTotal(), "Total: $8.63");

    }

    @Test(description = "Test04 - Verify products added to cart")
    @Description("This test verifies the number of products added to the cart")
    public void test04_verifyAddedProductsNumber() {
        // Sort products from low to high
        Webflows.SortProductsLowtoHigh();
        // Add multiple products to the cart and verify the count
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 0);
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 1);
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 2);
        UIActions.click(saucedemoProducts.getCartButton());
        Verifications.numberOfElements(saucedemoCartPage.getProductRows(), 3);
    }

    @Test(description = "Test05 - Verify buttons are visible")
    @Description("This test verify if Social buttons are visible (using soft assertion)")
    public void test05_verifySocialButtonAreVisible() {
        // Create a list of social buttons and check their visibility
        List<WebElement> elements_list = new ArrayList<>();
        elements_list.add(saucedemoFooter.getFacebookLink());
        elements_list.add(saucedemoFooter.getTwitterLink());
        elements_list.add(saucedemoFooter.getLinkedInLink());
        Verifications.visibilityOfElements((elements_list));

    }

    @Test(description = "Test06 - Verify removal of all products")
    @Description("This test verify if removal of all the products added to the cart")
    public void test06_verifyRemovalAllProducts() {
        // Sort products from low to high, add products to the cart, go to the cart, remove all items, and verify the cart is empty
        Webflows.SortProductsLowtoHigh();
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 1);
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 2);
        UIActions.click(saucedemoProducts.getCartButton());
        Webflows.RemoveAllItem(saucedemoCartPage.getProductRows());
        Verifications.verifyNoElements(saucedemoCartPage.getProductRows());
    }

    @Test(description = "Test07 - Verify number of products added to cart")
    @Description("This test verify Total number of products added to the cart")
    public void test07_verifyAddedProductsNumber() {
        // Sort products from low to high, add multiple products to the cart, and verify the count
        Webflows.SortProductsLowtoHigh();
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 0);
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 1);
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 2);
        UIActions.click(saucedemoProducts.getCartButton());
        Verifications.numberOfElements(saucedemoCartPage.getProductRows(), 3);
    }

    @Test(description = "Test08 - Verify image of the cart icon")
    @Description("This test verify the cart image icon using sikuli tool")
    public void test8_verifyCartIcon() {
        // Verify the presence of the cart icon using Sikuli tool
        Verifications.visualElement("SauceDemoCart");
    }

    @Test(description = "Test09 - Verify product Total price. checkout with customer from DB")
    @Description("This test verify the total price of a product in the Overview page")
    public void test09_verifyTotalPriceDB() {
        // Sort products from low to high, add a product to the cart, proceed to checkout with customer details from the database, and verify the total price
        Webflows.SortProductsLowtoHigh();
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 2);
        Webflows.CheckoutWithCustomerFromDB();
        Verifications.verifyTextInElement(saucedemoOverviewtPage.getFieldTotal(), "Total: $17.27");

    }

    @Test(description = "Test10 - Verify buttons text")
    @Description("This test verify the the social buttons Names")
    public void test10_verifySocialButtonNames() {
        // Create a list of social buttons, define expected names, and verify the text of the buttons
        List<WebElement> elements_list = new ArrayList<>();
        elements_list.add(saucedemoFooter.getFacebookLink());
        elements_list.add(saucedemoFooter.getTwitterLink());
        elements_list.add(saucedemoFooter.getLinkedInLink());

        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("Facebook");
        expectedNames.add("Twitter");
        expectedNames.add("LinkedIn");

        Verifications.VerifyTextInElements(elements_list,expectedNames);

    }

    @AfterMethod
    public void afterMethod() {
        // Get the current URL and print it to the console
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        // Reset the site, navigate to the login page, and perform login with credentials from data
        Webflows.ResetSite();
        goLoginPage();
        Webflows.login(getData("userName"), getData("password"));
    }

}
