package com.bdia.Utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ServerManager {
    private static AppiumDriverLocalService service;

    public static AppiumDriverLocalService getServer() throws IOException {
        GlobalParamsManager params = new GlobalParamsManager();
        Properties props = new PropertiesManager().getProps();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withLogFile(new File(
                "ServerLogs" + File.separator + params.getDeviceName() + File.separator + "server.log"))
                        .usingDriverExecutable(new File(props.getProperty("nodePath")))
                        .withAppiumJS(new File(props.getProperty("mainJSPath")))
                        .usingAnyFreePort()
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE))
                .withBasePath("/wd/hub/");


    }

    public static void setService(AppiumDriverLocalService server) {
        ServerManager.service = server;
    }
    public static AppiumDriverLocalService getService(){
        return service;
    }

    public void startServer() {
        try {

            service = getServer();
            if (!service.isRunning()) {
                service.start();
            }
        System.out.println("PRINT service state : " + service.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }

        service.clearOutPutStreams(); // Disable Appium logs from Console
    }

    public void stopServer() {
        if (service.isRunning()) {
            service.stop();
        }
    }

}
