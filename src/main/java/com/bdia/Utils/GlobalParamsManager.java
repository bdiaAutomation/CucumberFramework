package com.bdia.Utils;

public class GlobalParamsManager {
    private static ThreadLocal<String> platformName = new ThreadLocal<>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static ThreadLocal<String> udid = new ThreadLocal<>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<>();
    private static ThreadLocal<String> chromedriverPort = new ThreadLocal<>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<>();

    public  String getPlatformName() {
        return platformName.get();
    }

    public  void setPlatformName(String platformName2) {
        platformName.set(platformName2);
    }

    public  String getDeviceName() {
        return deviceName.get();
    }

    public  void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public  String getUdid() {
        return udid.get();
    }

    public  void setUdid(String udid2) {
        udid.set(udid2);
    }


    public  String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public  void setWebkitDebugProxyPort(String webkitDebugProxyPort2) {
        webkitDebugProxyPort.set(webkitDebugProxyPort2);
    }

    public  String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public  void setWdaLocalPort(String wdaLocalPort2) {
        wdaLocalPort.set(wdaLocalPort2);
    }

    public  String getChromedriverPort() {
        return chromedriverPort.get();
    }

    public  void setChromedriverPort(String chromedriverPort2) {
        chromedriverPort.set(chromedriverPort2);
    }

    public   String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }

    public void initializeGlobalParameters(){
        setPlatformName(System.getProperty("platformName", "Android"));
        setDeviceName(System.getProperty("deviceName", "Pixel 2"));
        setUdid(System.getProperty("udid", "Android"));

        switch (getPlatformName()){
            case "Android":
                setChromedriverPort(System.getProperty("chromeDriverPort", "10000"));
                setSystemPort(System.getProperty("systemPort","9000"));
                break;
            case "iOS":
                setWdaLocalPort(System.getProperty("wdaLocalPort", "8000"));
                setWebkitDebugProxyPort(System.getProperty("webkiDebugProxyPort", "10001"));
                break;
            default:
                throw new IllegalStateException("Invalid Platform ABORT !!!");
        }
    }
}
