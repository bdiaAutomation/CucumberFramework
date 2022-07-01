package com.bdia.Utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {


    public DesiredCapabilities getCaps() throws IOException {
        Properties props = new PropertiesManager().getProps();
        GlobalParamsManager params = new GlobalParamsManager();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
        caps.setCapability(MobileCapabilityType.UDID, params.getUdid());
        caps.setCapability("useNewWDA", props.getProperty("useNewWDA"));
        switch (params.getPlatformName()) {
            case "Android":
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                caps.setCapability("systemPort", params.getSystemPort());
                caps.setCapability("chromeDriverPort", params.getChromedriverPort());
                String androidAPPLocation = "src" + File.separator + "test" + File.separator + "resources" + File.separator + props.getProperty("androidApp")
                        + File.separator + "smi.apk";

                caps.setCapability(MobileCapabilityType.APP, androidAPPLocation);
                break;
            case "iOS":
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.get("iOSAutomationName"));
                caps.setCapability("newCommandTimeout", props.getProperty("newCommandTimeout"));
                caps.setCapability("webviewConnectTimeout", props.getProperty("webviewConnectTimeout"));
                caps.setCapability("newCommandTimeout", props.getProperty("newCommandTimeout"));
                caps.setCapability("includeSafariInWebviews", props.getProperty("includeSafariInWebviews"));
                caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                caps.setCapability(MobileCapabilityType.APP, getClass().getClassLoader().getResource(props.getProperty("iOSApp")).getFile());
                break;
            default:
                throw new IllegalStateException("Capabilities not set ABORT !!!!!");
        }
        return caps;
    }
}
