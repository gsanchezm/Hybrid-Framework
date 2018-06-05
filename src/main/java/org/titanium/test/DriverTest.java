package org.titanium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.titanium.utils.BaseClass;
import org.titanium.utils.DataProviderClass;
import org.titanium.utils.HandledException;

public class DriverTest  extends BaseClass{
    @Test(dataProvider="LoginCredentials", dataProviderClass=DataProviderClass.class, priority=0, description="Test Case using valid credentials")
    public void validCredentials(String strUserName, String strPassword) throws Exception {
        try{
            Assert.assertTrue(loginQA.Login(strUserName, strPassword));
            Assert.assertTrue(logout.LogoOutApplication());
        }catch (InterruptedException ie){
            new HandledException(driver, "Error_Logi_", "Interrupted Error", ie);
        }

    }

    @Test(dataProvider="LoginCredentials", dataProviderClass=DataProviderClass.class, priority=1, description="Test Case using invalid credentials")
    public void invalidCredentials(String strUserName, String strPassword, String strExpectedResult) throws InterruptedException, HandledException {
        Assert.assertTrue(loginQA.Login(strUserName, strPassword));
        Assert.assertEquals(loginPage.getErrorLoginLabel(), strExpectedResult);
    }
}
