package com.bdia.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public void initializeDriver() throws IOException {

        AppiumDriver driver = null;

        CapabilitiesManager capabilities = new CapabilitiesManager();
        GlobalParamsManager params = new GlobalParamsManager();
        switch (params.getPlatformName()) {
            case "Android":
                driver = new AndroidDriver(ServerManager.getServer().getUrl(), capabilities.getCaps());
                break;
            case "iOS":
                System.out.println("APPOIUM URL IS : " + ServerManager.getService().getUrl());
                driver = new IOSDriver(ServerManager.getService().getUrl(), capabilities.getCaps());
                break;
            default:
                throw new RuntimeException("Driver is not set ");
        }
        this.driver.set(driver);
    }

    public AppiumDriver getDriver() {

        return this.driver.get();
    }
}
