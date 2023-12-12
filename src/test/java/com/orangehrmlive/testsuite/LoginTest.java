package com.orangehrmlive.testsuite;

import com.orangehrmlive.customelistner.CustomListeners;
import com.orangehrmlive.pages.DashboardPage;
import com.orangehrmlive.pages.HomePage;
import com.orangehrmlive.pages.LoginPage;
import com.orangehrmlive.resources.testdata.TestData;
import com.orangehrmlive.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Objects;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.sendDataToUserNameField("Admin");
        loginPage.sendDataToPasswordField("admin123");
        loginPage.clickOnLoginButton();

        String expectedMessage = "Dashboard";
        String actualMessage = dashboardPage.getWelcomeText().substring(0, expectedMessage.length());
        Assert.assertEquals(actualMessage, expectedMessage, "DashboardPage is not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage(){
        loginPage.loginToTheApplication("Admin", "admin123");
        Assert.assertTrue(homePage.verifyOrangeHRMLogo());
    }

    @Test(groups = {"regression"})
    public void VerifyUserShouldLogOutSuccessFully(){
        loginPage.loginToTheApplication("Admin", "admin123");
        dashboardPage.clickOnUserProfileLogo();
        dashboardPage.mouseHoverAndClickOnLogOut();
        String expectedLoginPanelText = "Login";
        String actualLoginPanelText = loginPage.verifyTheLoginPanelText();
        Assert.assertEquals(actualLoginPanelText, expectedLoginPanelText);
    }

    @Test(dataProvider = "credentials", dataProviderClass = TestData.class, groups = {"regression"})
    public void verifyErrorMessageWithInvalidCredentials(String uName, String password, String eMessage){
        loginPage.loginToTheApplication(uName, password);

        if(Objects.equals(uName, "")){
            String actualMessage = loginPage.getUserNameFieldBlankErrorMessage();
            Assert.assertEquals(actualMessage, eMessage);
        } else if (Objects.equals(password, "")){
            String actualMessage = loginPage.getPasswordFieldBlankErrorMessage();
            Assert.assertEquals(actualMessage, eMessage);
        }else{
            String actualMessage = loginPage.getInvalidCredentialErrorMessage();
            Assert.assertEquals(actualMessage, eMessage);
        }
    }
}
