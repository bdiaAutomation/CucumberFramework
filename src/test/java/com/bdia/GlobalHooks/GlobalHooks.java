package com.bdia.GlobalHooks;

import com.bdia.Utils.DriverFactory;
import com.bdia.Utils.GlobalParamsManager;
import com.bdia.Utils.ServerManager;
import com.bdia.Utils.TestUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class GlobalHooks {


    @BeforeAll()
    public static void beforeAll() {
        new ServerManager().startServer();
        new TestUtils().log().info("BEFORE ALL FEATURE FILES BEEN EXCECUTED");
    }


    @AfterAll
    public static void afterAll() {
        new TestUtils().log().info("AFTER ALL FEATURE FILES EXCECUTED");
        new ServerManager().stopServer();
    }

    @Before()
    public void beforePL() {
        GlobalParamsManager params = new GlobalParamsManager();
        params.initializeGlobalParameters();
        try {
            new DriverFactory().initializeDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After()
    public void after(Scenario scenario) {

        if(scenario.isFailed()){
            String ScreenShoLocation = "target" + File.separator + "screenshots" + File.separator + scenario.getName();
            byte[] screenshot = ((TakesScreenshot)new DriverFactory().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", ScreenShoLocation );
        }

        if(new DriverFactory().getDriver() != null){
            new DriverFactory().getDriver().quit();
        }
    }

}
