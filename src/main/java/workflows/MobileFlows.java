package workflows;


import extensions.MobileActions;
import io.qameta.allure.Step;

import pageObjects.saucedemo.LoginPage;
import utilities.CommonOps;


public class MobileFlows extends CommonOps {

    @Step("business flow - Login")
    public static void Login(String userName,String password) {

        MobileActions.updateText(eribankLogin.getUsernameTextField(), userName);
        MobileActions.updateText(eribankLogin.getPasswordTextField(), password);
        MobileActions.tap(eribankLogin.getLoginButton());

    }

    @Step("business flow - Login")
    public static void Pay(String phone,String name, String amount, String country) {

        MobileActions.updateText(eribankPaymentPage.getPhoneTextField(), phone);
        MobileActions.updateText(eribankPaymentPage.getNameTextField(), name);
        MobileActions.updateText(eribankPaymentPage.getAmountTextField(), amount);
        MobileActions.updateText(eribankPaymentPage.getCountryTextField(), country);
        MobileActions.tap(eribankPaymentPage.getSendPaymentButton());
        MobileActions.tap(eribankPaymentPage.getYesButton());

    }


}


