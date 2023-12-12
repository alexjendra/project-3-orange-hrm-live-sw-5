package com.orangehrmlive.pages;

import com.orangehrmlive.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanelText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    WebElement userNameFieldBlankErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement passwordFieldBlankErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentialErrorMessage;



    public void sendDataToUserNameField(String userName) {
        sendTextToElement(userNameField,userName);
    }

    public void sendDataToPasswordField(String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String verifyTheLoginPanelText() {
        return getTextFromElement(loginPanelText);
    }

    public String getUserNameFieldBlankErrorMessage() {
        return getTextFromElement(userNameFieldBlankErrorMessage);
    }

    public String getPasswordFieldBlankErrorMessage() {
        return getTextFromElement(passwordFieldBlankErrorMessage);
    }

    public String getInvalidCredentialErrorMessage() {
        return getTextFromElement(invalidCredentialErrorMessage);
    }

    public void loginToTheApplication(String email, String password) {
        sendDataToUserNameField(email);
        sendDataToPasswordField(password);
        clickOnLoginButton();
    }

}
