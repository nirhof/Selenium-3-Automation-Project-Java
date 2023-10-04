package workflows;


import extensions.MobileActions;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import pageObjects.saucedemo.LoginPage;
import utilities.CommonOps;


public class MobileFlows extends CommonOps {

    @Step("business flow - Login")
    public static void Login(String userName,String password) {

        MobileActions.updateText(eribankLogin.txt_username, userName);
        MobileActions.updateText(eribankLogin.txt_password, password);
        MobileActions.tap(eribankLogin.btn_login);

    }

    @Step("business flow - Login")
    public static void Pay(String phone,String name, String amount, String country) {

        MobileActions.updateText(eribankPaymentPage.txt_phone, phone);
        MobileActions.updateText(eribankPaymentPage.txt_name, name);
        MobileActions.updateText(eribankPaymentPage.txt_amount, amount);
        MobileActions.updateText(eribankPaymentPage.txt_countrey, country);
        MobileActions.tap(eribankPaymentPage.btn_SendPayment);
        MobileActions.tap(eribankPaymentPage.btn_Yes);

    }


}


