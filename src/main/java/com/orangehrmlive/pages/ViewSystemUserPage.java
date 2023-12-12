package com.orangehrmlive.pages;

import com.orangehrmlive.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ViewSystemUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement userNameFieldInSystemUsers;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(text(),'-- Select --')])[1]")
    WebElement userRoleDropDownInSystemUsers;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    WebElement adminOptionInUserRoleDropDownInSystemUsers;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'ESS')]")
    WebElement ESSOptionInUserRoleDropDownInSystemUsers;


    @CacheLookup
    @FindBy(xpath = "(//i)[13]")
    WebElement statusDropDownInSystemUsers;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    WebElement disableStatusOptionInSystemUsers;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Enable']")
    WebElement enableStatusOptionInSystemUsers;


    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameFieldInSystemUsers;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButtonInSystemUsers;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButtonInSystemUsers;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "(//div[@data-v-6c07a142])[1]")
    WebElement userNameInRecord;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement checkBoxAgainstFirstUserName;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Delete Selected']")
    WebElement deleteButtonAgainstFirstUSerName;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement yesDeleteOption;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement oneRecordFoundMessage;

    public void sendDataToEmployeeNameFieldInSystemUsers(String eName) {
        sendTextToElement(employeeNameFieldInSystemUsers, eName);
    }

    public String getSystemUsersText() {
        return getTextFromElement(systemUsersText);
    }

    public void sendDataToUserNameFieldInSystemUsers(String uname) {
        sendTextToElement(userNameFieldInSystemUsers, uname);
    }

    public void clickOnUserRoleDropDownInSystemUsers() {
        clickOnElement(userRoleDropDownInSystemUsers);
    }

    public void mouseHoverAndClickOnAdminOptionInUserRoleDropDownInSystemUsers() {
        mouseHoverToElementAndClick(adminOptionInUserRoleDropDownInSystemUsers);
    }

    public void mouseHoverAndClickOnESSOptionInUserRoleDropDownInSystemUsers() {
        mouseHoverToElementAndClick(ESSOptionInUserRoleDropDownInSystemUsers);
    }

    public void clickOnStatusDropDownInSystemUsers() {
        clickOnElement(statusDropDownInSystemUsers);
    }

    public void mouseHoverAndCLickOndDisableStatusOptionInSystemUsers() {
        mouseHoverToElementAndClick(disableStatusOptionInSystemUsers);
    }

    public void mouseHoverAndCLickOndEnableStatusOptionInSystemUsers() {
        mouseHoverToElementAndClick(enableStatusOptionInSystemUsers);
    }

    public void clickOnSearchButtonInSystemUsers() {
        clickOnElement(searchButtonInSystemUsers);
    }

    public void clickOnResetButtonInSystemUsers() {
        clickOnElement(resetButtonInSystemUsers);
    }

    public String getDataFromUserNameInRecord() {
        return getTextFromElement(userNameInRecord);
    }

    public void clickOnCheckBoxAgainstFirstUserName() {
        clickOnElement(checkBoxAgainstFirstUserName);
    }

    public void clickOnDeleteSelectedOption() {
        clickOnElement(deleteButtonAgainstFirstUSerName);
    }

    public void clickOnYesDeleteOption() {
        clickOnElement(yesDeleteOption);
    }

    public void clickOnAddButton() {
        clickOnElement(addButton);
    }

    public String getOneRecordFoundMessage () {
        return getTextFromElement(oneRecordFoundMessage);
    }

    public void searchUserDetails(String uName, String userRole, String eName, String status){
        sendDataToUserNameFieldInSystemUsers(uName);
        clickOnUserRoleDropDownInSystemUsers();

        if(userRole == "Admin"){
            mouseHoverAndClickOnAdminOptionInUserRoleDropDownInSystemUsers();
        } else {
            mouseHoverAndClickOnESSOptionInUserRoleDropDownInSystemUsers();
        }

        sendDataToEmployeeNameFieldInSystemUsers(eName);

        clickOnStatusDropDownInSystemUsers();
        if(status == "Enabled"){
            mouseHoverAndCLickOndEnableStatusOptionInSystemUsers();
        } else {
            mouseHoverAndCLickOndDisableStatusOptionInSystemUsers();
        }

        clickOnSearchButtonInSystemUsers();

        String expectedOneRecordFoundMessage = "(1) Record Found";
        String actualOneRecordFoundMessage = getOneRecordFoundMessage();
        Assert.assertEquals(actualOneRecordFoundMessage, expectedOneRecordFoundMessage);

        String actualUserNameInRecord = getDataFromUserNameInRecord();
        Assert.assertEquals(uName, actualUserNameInRecord);

        clickOnResetButtonInSystemUsers();
    }
}
