package Tests.UITests.interviewQuestions_1;

import Tests.junitCalismalari.Users.Omer;
import enums.LINKS;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class BJSSTest {
    ChromeDriver chromeDriver;

    @BeforeEach
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        Allure.addAttachment("name for attachment",
                new ByteArrayInputStream(((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES)));


        chromeDriver.quit();
    }

    // @Omer
    @Epic("BJSS")
    @Feature("FEATURE")
    @Story("US_01")
    @Step("Step for US_1")
    @Link("https://www.bjss.com/careers")
    @Test
    void test1() {
        chromeDriver.get(LINKS.BJSS_CAREERS.getGetLink());
        System.out.println(chromeDriver.getCurrentUrl());
    }

    // @Omer
    @Test
    @Epic("BJSS")
    @Feature("FEATURE")
    @Story("US_02")
    @Severity(value = SeverityLevel.TRIVIAL)
    @Description(value = "I am checking user credentials are blo bla ble")
    @Owner(value = "OMER")
    public void test2() {

        chromeDriver.get(LINKS.BJSS_CAREERS.getGetLink());
        System.out.println(chromeDriver.getCurrentUrl());
    }

    @Test
     @Omer
    @Epic("BJSS")
    @Feature("FEATURE")
    @Story("US_03")
    @Severity(value = SeverityLevel.BLOCKER)
    @Description(value = "testing something")
    @Owner(value = "OMER")
    public void test3() {
        chromeDriver.get(LINKS.BJSS_CAREERS.getGetLink());
        Assertions.assertTrue(chromeDriver.getCurrentUrl().contains("bjsls"),
                "there is a problem with url expected to include \nbjss but it came as \n" +
                        chromeDriver.getCurrentUrl());

//screenshot();
    }

    @Omer
    @Test
    void test4() {
        Assertions.assertTrue(2==2);
    }


    @Omer
    @Test
    void test5() {
        Assertions.assertTrue(3==3);
    }


    //    @Attachment(value = "Screenshot",type = "image/png")
//    public byte[] screenshot(){
//        return (((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES));
//    }



}
