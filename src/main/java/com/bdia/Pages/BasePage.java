package com.bdia.Pages;

import com.bdia.Utils.Constants;
import com.bdia.Utils.DriverFactory;
import com.bdia.Utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {

    private AppiumDriver driver;
    private WebDriverWait wait;
    TestUtils utils = new TestUtils();

    public BasePage() {
        this.driver = new DriverFactory().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(Constants.WAIT));
    }

    public void tap(WebElement e){
        wait.until(ExpectedConditions.elementToBeClickable(e)).click();
    }

    public void refreshScreen(WebElement e) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(e)));
    }
}
