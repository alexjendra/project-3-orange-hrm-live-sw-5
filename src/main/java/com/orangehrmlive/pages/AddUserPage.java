package com.orangehrmlive.pages;

import com.orangehrmlive.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement addUserText;

    @CacheLookup
    @FindBy(xpath = "(//div[@class = 'oxd-select-wrapper'])[1]")
    WebElement userRoleDropDownInAddUser;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    WebElement adminOptionInUserRoleDropDownInAddUser;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'ESS')]")
    WebElement ESSOptionInUserRoleDropDownInAddUser;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameFieldInAddUser;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'oxd-form-row']//input[@class = 'oxd-input oxd-input--active']")
    WebElement userNameFieldInAddUser;


    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'-- Select --')]")
    WebElement statusDropDownInAddUser;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    WebElement disabledStatusOptionInAddUser;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Enabled']")
    WebElement enabledStatusOptionInAddUser;


    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement passwordFieldInAddUser;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPasswordFieldInAddUser;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButtonInAddUser;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButtonInAddUser;


    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successfullySavedMessageInAddUser;


    public String verifyAddUserText () {
        return getTextFromElement(addUserText);
    }

    public void mouseHoverAndClickOnUserRoleDropDownInAddUser() {
        mouseHoverToElementAndClick(userRoleDropDownInAddUser);
    }

    public void mouseHoverAndCLickOnAdminOptionInUserRoleDropDownInAddUser() {
        clickOnElement(adminOptionInUserRoleDropDownInAddUser);
    }

    public void mouseHoverAndCLickOnESSOptionInUserRoleDropDownInAddUser() {
        clickOnElement(ESSOptionInUserRoleDropDownInAddUser);
    }

    public void sendDataToEmployeeNameFieldInAddUser(String eName) {
        sendTextToElement(employeeNameFieldInAddUser, eName);
    }

    public void clickOnStatusDropDownMenuInAddUser() {
        clickOnElement(statusDropDownInAddUser);
    }

    public void mouseHoverAndClickOnDisabledOptionInAddUser() {
        mouseHoverToElementAndClick(disabledStatusOptionInAddUser);
    }

    public void mouseHoverAndClickOnEnabledOptionInAddUser() {
        mouseHoverToElementAndClick(enabledStatusOptionInAddUser);
    }

    public void sendDataToUserNameFieldInAddUser(String uName) {
        sendTextToElement(userNameFieldInAddUser, uName);
    }

    public void sendDataToPasswordFieldInAddUser(String password) {
        sendTextToElement(passwordFieldInAddUser, password);
    }

    public void sendDataToConfirmPasswordFieldInAddUser(String cPassword) {
        sendTextToElement(confirmPasswordFieldInAddUser, cPassword);
    }

    public void clickOnSaveButtonInAddUser() {
        clickOnElement(saveButtonInAddUser);
    }

    public void clickOnCancelButtonInAddUser() {
        clickOnElement(cancelButtonInAddUser);
    }

    public String getSuccessfullySavedMessageInAddUser() {
        return getTextFromElement(successfullySavedMessageInAddUser);
    }
}
