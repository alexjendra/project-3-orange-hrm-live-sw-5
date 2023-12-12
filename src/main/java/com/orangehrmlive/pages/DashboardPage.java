package com.orangehrmlive.pages;

import com.orangehrmlive.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement userProfileLogo;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutLink;

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public void clickOnUserProfileLogo () {
        clickOnElement(userProfileLogo);
    }

    public void mouseHoverAndClickOnLogOut() {
        mouseHoverToElementAndClick(logoutLink);
    }
}
