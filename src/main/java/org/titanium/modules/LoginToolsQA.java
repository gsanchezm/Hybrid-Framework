package org.titanium.modules;

import org.openqa.selenium.WebDriver;
import org.titanium.pages.LoginPage;
import org.titanium.utils.BaseClass;
import org.titanium.utils.HandledException;

public class LoginToolsQA extends BaseClass {
    LoginPage loginPage;

    public LoginToolsQA(WebDriver driver){
        this.driver = driver;
    }

    public boolean Login(String strUserName, String strPassword) throws InterruptedException{
        try{
            loginPage = new LoginPage(driver);
            loginPage.clickMyAccount();
            loginPage.clearUserNameField();
            loginPage.setUserName(strUserName);
            loginPage.clearPasswordField();
            loginPage.setPassword(strPassword);
            loginPage.clickLogin();
            Thread.sleep(5000);
        }catch(Exception e){
            new HandledException(e.getMessage());
            return false;
        }
        info("Login credentials was typed!");
        return true;
    }
}
