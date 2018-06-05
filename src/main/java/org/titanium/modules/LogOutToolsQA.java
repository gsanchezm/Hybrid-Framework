package org.titanium.modules;

import org.openqa.selenium.WebDriver;
import org.titanium.pages.YourAccountPage;
import org.titanium.utils.BaseClass;
import org.titanium.utils.HandledException;

public class LogOutToolsQA extends BaseClass {
    YourAccountPage yourAcc;

    public LogOutToolsQA(WebDriver driver){
        this.driver = driver;
    }

    public boolean LogoOutApplication(){
        try{
            yourAcc = new YourAccountPage(driver);
            yourAcc.getUserNameText();
            yourAcc.clickLogoutButton();
        }catch(Exception e){
            new HandledException(e.getMessage());
            return false;
        }
        info("Logging out successfully!");
        return true;
    }
}
