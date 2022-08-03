//package utilities;
//
//import Tests.Mobile.BaseClass;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.touch.WaitOptions;
//import io.appium.java_client.touch.offset.PointOption;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//
//import java.time.Duration;
//
//public class Utilities extends BaseClass {
//    //calisiyor
//    public static boolean isExist(MobileElement element) {
//        boolean b;
//        try {
//            b = element.isDisplayed() || !element.isDisplayed();
//        } catch (Exception var3) {
//            b = false;
//        }
//
//        return b;
//    }
//
//    //calistiramadim
//    public static void moveAroundToFindElement(MobileElement mobileElement) {
//        Dimension dimension = androidDriver.manage().window().getSize();
//        double x = 0.5;
//        double y = 0.2;
//
//        int start_x = (int) (dimension.height * 0.1);
//        int start_y = (int) (dimension.width * 0.1);
//
//        int end_x = (int) (dimension.height * x);
//        int end_y = (int) (dimension.width * y);
//
//        while (isExist(mobileElement)) {
//            touchAction.press(PointOption.point(start_x, start_y)).
//                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
//                    moveTo(PointOption.point(end_x, end_y)).release().perform();
//            x = x + 0.1;
//            // y = y + 0.1;
//            System.out.println(x);
//        }
//    }
//
//    //calisiyor
//    public static void wait(int secs) {
//        try {
//            Thread.sleep(1000 * secs);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //catch ile sarilmasi lazim bazen geciyor bazen gecmiyor
//    public static void scrollDown() {
//        Dimension dimension = androidDriver.manage().window().getSize();
//        int scrollStart = (int) (dimension.getHeight() * 0.5);
//        int scrollEnd = (int) (dimension.getHeight() * 0.2);
//
//        new TouchAction(androidDriver)
//                .press(PointOption.point(0, scrollStart))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
//                .moveTo(PointOption.point(0, scrollEnd))
//                .release().perform();
//    }
//
//
//    //calisiyor     //ben calistiramadim Erkan
//    public static void scrollNClick(WebElement el) {
//        int retry = 0;
//
//        while (retry <= 5) {
//            try {
//                el.click();
//                System.out.println(retry);
//                break;
//            } catch (org.openqa.selenium.NoSuchElementException e) {
//                scrollDown();
//                retry++;
//            }
//        }
//    }
//
//    //denemedim
//    public static void scrollIntoView(String Text) {
//        ((AndroidDriver<MobileElement>) androidDriver).findElementByAndroidUIAutomator(
//        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))").click();
//
//    }
//
//
//
//   }
