package driver;


import config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.ConfigurationReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/*
{
  "platformName": "Android",
  "platformVersion": "10.0",
  "automationName": "UiAutomator2"
}
 */

public class Driver {

    public static AndroidDriver appiumDriver;

    public static AppiumDriver getAppiumDriver()  {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigurationReader.getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigurationReader.getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigurationReader.getProperty("platformVersion"));
            //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationReader.getProperty("deviceName"));
            desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigurationReader.getProperty("appPath"));
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            desiredCapabilities.setCapability("autoAcceptAlert",true);

            if (ConfigurationReader.getProperty("platformName").equals("android")) {
                //if you do not provide app path so you should provide "appPackage" and "appActivity"
                desiredCapabilities.setCapability("appPackage","");
//                desiredCapabilities.setCapability("app", "/src/test/resources/testdata/app-release.aab");
                desiredCapabilities.setCapability("app", "/Users/savsa/IdeaProjects/urbanicfarm-framework/src/test/resources/testdata/1.0.3.apk");
                desiredCapabilities.setCapability("appActivity","");

                appiumDriver = new AndroidDriver(appiumServerURL,desiredCapabilities);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (ConfigurationReader.getProperty("platformName").equals("ios")) {
                //if you do not provide app path so you should use "bundleId"
                desiredCapabilities.setCapability("bundleId",ConfigReader.getProperty("iosBundleId"));
                appiumDriver = new AndroidDriver(appiumServerURL,desiredCapabilities);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigurationReader.getProperty("platformName"));
            }
        }
        return appiumDriver;
    }


    public static void quitAppiumDriver(){
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}