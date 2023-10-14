package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.Webflows;
import java.util.ArrayList;
import java.util.List;

@Listeners(utilities.Listeners.class)
public class SauceDemoWeb extends CommonOps {


    @Test(description = "Test01 - Verify number of products")
    @Description("This test verify the number of products in the products page")
    public void test01_verifyNumberOfProducts() {
        Verifications.numberOfElements(saucedemoProducts.getInventoryProducts(), 6);
    }

    @Test(description = "Test02 - Verify highest price")
    @Description("This test verify the price of the most expensive item")
    public void test02_verifyPriceOfMostExpensiveItem() {
        Webflows.SortProductsHightoLow();
        Verifications.verifyTextInElement(saucedemoProducts.getProductsPrice(), "$49.99");
    }

    @Test(description = "Test03 - Verify product Total price")
    @Description("This test verify the total price of a product in the Overview page")
    public void test03_verifyTotalPrice() {
        Webflows.SortProductsLowtoHigh();
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 0);
        Webflows.Checkout("Nir", "Hofenberg", "215454");
        Verifications.verifyTextInElement(saucedemoOverviewtPage.getFieldTotal(), "Total: $8.63");

    }

    @Test(description = "Test04 - Verify products added to cart")
    @Description("This test verify number of products added to cart")
    public void test04_verifyAddedProductsNumber() {
        Webflows.SortProductsLowtoHigh();
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 0);
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 1);
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 2);
        UIActions.click(saucedemoProducts.getCartButton());
        Verifications.numberOfElements(saucedemoCartPage.getProductRows(), 3);
    }

    @Test(description = "Test05 - Verify buttons are visible")
    @Description("This test verify if Social buttons are visible (using soft assertion)")
    public void test05_verifySocialButtonAreVisible() {

        List<WebElement> elements_list = new ArrayList<>();
        elements_list.add(saucedemoFooter.getFacebookLink());
        elements_list.add(saucedemoFooter.getTwitterLink());
        elements_list.add(saucedemoFooter.getLinkedInLink());
        Verifications.visibilityOfElements((elements_list));

    }

    @Test(description = "Test06 - Verify removal of all products")
    @Description("This test verify if removal of all the products added to the cart")
    public void test06_verifyRemovalAllProducts() {
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
        Verifications.visualElement("SauceDemoCart");
    }

    @Test(description = "Test09 - Verify product Total price. checkout with customer from DB")
    @Description("This test verify the total price of a product in the Overview page")
    public void test09_verifyTotalPriceDB() {
        Webflows.SortProductsLowtoHigh();
        Webflows.AddItemToCart(saucedemoProducts.getAddToCartButtons(), 2);
        Webflows.CheckoutWithCustomerFromDB();
        Verifications.verifyTextInElement(saucedemoOverviewtPage.getFieldTotal(), "Total: $17.27");

    }

    @AfterMethod
    public void afterMethod() {
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        Webflows.ResetSite();
        goLoginPage();
        Webflows.login(getData("userName"), getData("password"));
    }


}
