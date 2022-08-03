package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverAppium {

    public static AndroidDriver<WebElement> driver;
//    public static AppiumDriver<WebElement> iOSdriver;
//    private static DesiredCapabilities desiredCapabilities;


    public static AndroidDriver getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Tugraoppo");
        desiredCapabilities.setCapability("appPackage", "com.android.chrome");
        desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");



        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, desiredCapabilities);
        return driver;
    }


    public static void quitAppiumDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

//    public static AppiumDriver<WebElement> getIOSdriver() throws MalformedURLException {
//        desiredCapabilities = new DesiredCapabilities();
//
//        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigurationReader.getProperty("automationNameIOS"));
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigurationReader.getProperty("platformNameIOS"));
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigurationReader.getProperty("platformVersionIOS"));
//        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationReader.getProperty("deviceNameIOS"));
//        desiredCapabilities.setCapability("appPackage", "com.android.chrome");
//        desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
//        //desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
//
//
//        URL url = new URL("http://127.0.0.1:4723/wd/hub");
//        iOSdriver = new AppiumDriver<>(url, desiredCapabilities);
//        return iOSdriver;
//    }
//
//
//    public static void quitIOSDriver() {
//        if (iOSdriver != null) {
//            iOSdriver.quit();
//            iOSdriver = null;
//        }
//    }
}
