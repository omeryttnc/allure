package Tests;

import com.github.javafaker.Faker;
import config.ConfigReader;
import config.TestResultLoggerExtension;
import driver.DriverFactory;
import driver.DriverFactoryImplementation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.launcher.TestExecutionListener;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestExecutionListeners;
import pages.AllElements;
import utilities.ScreenshotWatcher5;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//@SpringBootTest
@TestExecutionListeners
@ExtendWith(TestResultLoggerExtension.class)
//@ExtendWith({YourExtension.class})
public class BrowserTestBase implements TestExecutionListener {
    // @RegisterExtension
    protected final Actions actions = new Actions(DriverFactoryImplementation.getInstance().getDriver());
    protected static final Logger LOG = LoggerFactory.getLogger(BrowserTestBase.class);
    protected final DriverFactory Driver = new DriverFactoryImplementation();
    protected Faker faker = new Faker();
    private static final String FILE_DIRECTORY = "test-output\\Screenshots";
    private static final String FILE_EXTENSION = ".png";
    protected AllElements elements = new AllElements();
    protected Random random = new Random();
//     @BeforeTestExecution
//    static void deleteScreeenshot(){
//     new DeleteFile().deleteFile(FILE_DIRECTORY, FILE_EXTENSION);
//     }
   /* @BeforeEach
    public void safari(){
        System.out.println("ConfigReader.getProperty(\"browser\") = " + ConfigReader.getProperty("browser"));
        if(ConfigReader.getProperty("browser").equals("safari")){
            System.out.println("Before I am Safari driver");

            DriverFactoryImplementation.getInstance().getDriver().quit();
            DriverFactoryImplementation.getInstance().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            DriverFactoryImplementation.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        System.out.println("First I am Safari driver");

    }*/
    @BeforeEach
    public void setup() {
        LOG.info("before method initialized.. thread ID => " + Thread.currentThread().getId());

        DriverFactoryImplementation.getInstance().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        DriverFactoryImplementation.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach

    public void tearDown(TestInfo testInfo) {
        //System.out.println(new TestPlan());


        //if(testExecutionResult.getStatus() ==TestExecutionResult.Status.FAILED){

        ScreenshotWatcher5 watcher = new ScreenshotWatcher5(DriverFactoryImplementation.getInstance().getDriver(), new File(System.getProperty("user.dir")) + "\\target");
        watcher.captureScreenshot(DriverFactoryImplementation.getInstance().getDriver(), testInfo.getTestClass().toString().substring(15) + testInfo.getDisplayName());

        // }

//TestIdentifier testIdentifier, TestExecutionResult testExecutionResult,
        if (ConfigReader.getProperty("browser").equals("safari")) {
            System.out.println("After I am Safari driver");
           DriverFactoryImplementation.getInstance().getDriver().close();
        } else {
            LOG.info("tear down method worked.. thread ID =>  " + Thread.currentThread().getId());
            Driver.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            Driver.removeDriver();
        }
    }

}
