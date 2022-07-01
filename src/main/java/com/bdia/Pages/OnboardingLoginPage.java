package com.bdia.Pages;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

public class OnboardingLoginPage extends BasePage {

    @iOSXCUITFindBy(accessibility = "login_onboarding")
    @CacheLookup
    private WebElement lottieOnboadLoginImg;
    @iOSXCUITFindBy(xpath = "(XCUIElementTypeStaticText)[1]")
    @CacheLookup
    private WebElement onboadLoginTitletxt;
    @iOSXCUITFindBy(xpath = "(XCUIElementTypeStaticText)[2]")
    @CacheLookup
    private WebElement onboadLoginDescTxt;
    @iOSXCUITFindBy(accessibility = "LoginButtonId")
    @CacheLookup
    private WebElement onboardingLoginBtn;
    @iOSXCUITFindBy(accessibility = "SkipButtonId")
    @CacheLookup
    private WebElement onboardingSkipBtn;

    public OnboardingPickStorePage tapSkip() {
        try {
            tap(onboardingSkipBtn);
        } catch (StaleElementReferenceException e) {
            refreshScreen(onboardingSkipBtn);
            tap(onboardingSkipBtn);
        }

        return new OnboardingPickStorePage();
    }
}


