package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class footerSocial {

    @FindBy(linkText = "Twitter")
    public WebElement social_twitter;

    @FindBy(linkText = "Facebook")
    public WebElement social_facebook;

    @FindBy(linkText = "LinkedIn")
    public WebElement social_linkedin;






}
