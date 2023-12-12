package com.orangehrmlive.testsuite;

import com.orangehrmlive.customelistner.CustomListeners;
import com.orangehrmlive.pages.*;
import com.orangehrmlive.resources.testdata.TestData;
import com.orangehrmlive.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    ViewSystemUserPage viewSystemUserPage;
    AddUserPage addUserPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
        viewSystemUserPage = new ViewSystemUserPage();
        addUserPage = new AddUserPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {
        loginPage.loginToTheApplication("Admin", "admin123");
        homePage.clickOnAdminLink();

        String expectedSystemUsersMessage = "System Users";
        String actualSystemUsersMessage = viewSystemUserPage.getSystemUsersText();
        Assert.assertEquals(actualSystemUsersMessage, expectedSystemUsersMessage);

        viewSystemUserPage.clickOnAddButton();

        String expectedAddUsersMessage = "Add User";
        String actualAddUserMessage = addUserPage.verifyAddUserText();
        Assert.assertEquals(actualAddUserMessage, expectedAddUsersMessage);

        addUserPage.mouseHoverAndClickOnUserRoleDropDownInAddUser();
        addUserPage.mouseHoverAndCLickOnAdminOptionInUserRoleDropDownInAddUser();

        addUserPage.sendDataToEmployeeNameFieldInAddUser(" x x Zenaida Schultz");
        addUserPage.sendDataToUserNameFieldInAddUser("Prime78");
        addUserPage.clickOnStatusDropDownMenuInAddUser();
        addUserPage.mouseHoverAndClickOnDisabledOptionInAddUser();
        addUserPage.sendDataToPasswordFieldInAddUser("prime123");
        addUserPage.sendDataToConfirmPasswordFieldInAddUser("prime123");
        addUserPage.clickOnSaveButtonInAddUser();

        String expectedSuccessfullySavedMessage = "Successfully Saved";
        String actualSuccessfullySavedMessage = addUserPage.getSuccessfullySavedMessageInAddUser();
        Assert.assertEquals(actualSuccessfullySavedMessage, expectedSuccessfullySavedMessage);
    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        loginPage.loginToTheApplication("Admin", "admin123");
        homePage.clickOnAdminLink();

        String expectedSystemUsersMessage = "System Users";
        String actualSystemUsersMessage = viewSystemUserPage.getSystemUsersText();
        Assert.assertEquals(actualSystemUsersMessage, expectedSystemUsersMessage);

        viewSystemUserPage.sendDataToUserNameFieldInSystemUsers("Prime78");
        viewSystemUserPage.clickOnUserRoleDropDownInSystemUsers();
        viewSystemUserPage.mouseHoverAndClickOnAdminOptionInUserRoleDropDownInSystemUsers();
        viewSystemUserPage.clickOnStatusDropDownInSystemUsers();
        viewSystemUserPage.mouseHoverAndCLickOndDisableStatusOptionInSystemUsers();
        viewSystemUserPage.clickOnSearchButtonInSystemUsers();

        String expectedUserName = "Prime78";
        String actualUserName = viewSystemUserPage.getDataFromUserNameInRecord();
        Assert.assertEquals(actualUserName, expectedUserName);
    }

    @Test(dataProvider = "userDetails", dataProviderClass = TestData.class, groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(String uName, String userRole, String eName, String status){
        loginPage.loginToTheApplication("Admin", "admin123");
        homePage.clickOnAdminLink();

        String expectedSystemUsersMessage = "System Users";
        String actualSystemUsersMessage = viewSystemUserPage.getSystemUsersText();
        Assert.assertEquals(actualSystemUsersMessage, expectedSystemUsersMessage);

        viewSystemUserPage.searchUserDetails(uName, userRole, eName, status);
    }

}
