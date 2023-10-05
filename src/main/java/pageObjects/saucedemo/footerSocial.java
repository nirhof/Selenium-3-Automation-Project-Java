package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class footerSocial {

    @FindBy(linkText = "Twitter")
    private WebElement social_twitter;

    @FindBy(linkText = "Facebook")
    private WebElement social_facebook;

    @FindBy(linkText = "LinkedIn")
    private WebElement social_linkedin;

    // get elements

    public WebElement getTwitterLink() {
        return social_twitter;
    }

    public WebElement getFacebookLink() {
        return social_facebook;
    }

    public WebElement getLinkedInLink() {
        return social_linkedin;
    }




}
