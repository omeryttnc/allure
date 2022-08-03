package utilities;

import driver.DriverFactoryImplementation;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

/**
 *
 * @author steve
 *
 * to use, add the following to your JUnit5 tests:
 *
 * @RegisterExtension
 * ScreenshotWatcher5 watcher = new ScreenshotWatcher5(driver, "target/surefire-reports");
 *
 */
public class ScreenshotWatcher5 implements TestWatcher {

    WebDriver driver;
    String path;

    public ScreenshotWatcher5(WebDriver driver, String path) {
        this.driver = driver;
        this.path = path;
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
        // do something
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
        // do something
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        // do something
        captureScreenshot(DriverFactoryImplementation.getInstance().getDriver(), context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        // do something
    }

    public void captureScreenshot(WebDriver driver, String fileName) {
        try {
           // new File(path).mkdirs();

            try ( FileOutputStream out = new FileOutputStream(path + File.separator + fileName + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }

}

