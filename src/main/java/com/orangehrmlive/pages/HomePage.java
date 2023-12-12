package com.orangehrmlive.pages;

import com.orangehrmlive.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement orangeHRMLogo;

    @CacheLookup
    @FindBy(xpath = "//li[1]//a[1]//span[1]")
    WebElement adminLink;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    WebElement PIMLink;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Leave']")
    WebElement leaveLink;

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public Boolean verifyOrangeHRMLogo() {
        return driver.findElement((By) orangeHRMLogo).isDisplayed();
    }

    public void clickOnAdminLink() {
        clickOnElement(adminLink);
    }

    public void clickOnPIMLink() {
        clickOnElement(PIMLink);
    }

    public void clickOnLeaveLink() {
        clickOnElement(leaveLink);
    }

}
