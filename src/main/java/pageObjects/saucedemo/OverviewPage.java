package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage {

   @FindBy(css = "div[Class='summary_info_label summary_total_label']")
    private WebElement field_total;

    @FindBy(id = "cancel")
    private WebElement btn_cancel;

    @FindBy(id = "finish")
    private WebElement btn_finish;

    // get elements

 public WebElement getFieldTotal() {
  return field_total;
 }

 public WebElement getCancelButton() {
  return btn_cancel;
 }

 public WebElement getFinishButton() {
  return btn_finish;
 }





}
