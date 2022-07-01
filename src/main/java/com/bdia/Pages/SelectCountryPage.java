package com.bdia.Pages;

import com.bdia.Utils.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

public class SelectCountryPage extends BasePage {


    @iOSXCUITFindBy(accessibility = "suggestedChangeCountry")
    @CacheLookup
    private WebElement suggestedChangeCountryBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Select your country\" AND type == \"XCUIElementTypeNavigationBar\"")
    @CacheLookup
    private WebElement selectCountryPageTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Luxembourg']/preceding-sibling::XCUIElementTypeStaticText[@name='Français']")
    @CacheLookup
    private WebElement selectedCountry;

    @iOSXCUITFindBy(accessibility = "suggestedContinue")
    @CacheLookup
    private WebElement suggestedContinueBtn;

    public void validateCountry() {
        utils.log().info("Click on suggest country Btn");
        tap(suggestedContinueBtn);

    }
}
