package utilities;


import Tests.BrowserTestBase;
import com.github.javafaker.Faker;
import driver.DriverFactoryImplementation;
import enums.EVENTS.ENDPOINTS;
import enums.USER.USERINFO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllElements;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static io.restassured.RestAssured.given;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.next;


public abstract class ReusableMethods extends BrowserTestBase {

    public static String email;
    static Faker faker = new Faker();
    static Response response;
    public static Map<String, Object> reqBody = new HashMap<>();

    public static void visitUrl() {
        DriverFactoryImplementation.getInstance().getDriver().get(ConfigurationReader.getProperty("UFUrl"));
        //page render oldugu icin wait koyduk
        ReusableMethods.waitForPageToLoad(2);
        ReusableMethods.wait(2);
        //DriverFactoryImplementation.getInstance().getDriver().findElement(By.cssSelector(" a.Navbar_textLink__f6_Al.ml-4.mr-4")).click();
        ReusableMethods.waitForPageToLoad(2);
        ReusableMethods.wait(2);

    }

    public static void visitRegisterPage() {
        DriverFactoryImplementation.getInstance().getDriver().get(ConfigurationReader.getProperty("registerUFUrl"));
        ReusableMethods.waitForPageToLoad(4);

    }

    public static void visitCanliRegisterPage() {
        DriverFactoryImplementation.getInstance().getDriver().get(ConfigurationReader.getProperty("URl_canli"));
        ReusableMethods.waitForPageToLoad(5);
    }

    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(DriverFactoryImplementation.getInstance().getDriver()).doubleClick(element).build().perform();
    }

    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver();
        jse.executeScript(command, element);
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver();
        jse.executeScript(command);
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForInVisibilityofWebElement(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeToWaitInSec);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickablilityAndClick(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        element.click();
    }


    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    //hyrai projesi icin olsuturulmus bir method
    public static void cleanTextInBox(WebElement element) {
        String inputText = element.getAttribute("value");
        if (inputText != null) {
            for (int i = 0; i < inputText.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        }
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(DriverFactoryImplementation.getInstance().getDriver());
        actions.moveToElement(element).perform();
    }
//    public static void closeDriver(){
//        // Eğer driver nesnesi NULL değilse, yani hafızada varsa
//        if (driver != null){
//            driver.quit();  // driver'ı kapat
//            driver = null;  // driver'ı hafızadan temizle.
//        }
//    }

    /**
     * this method open new tab and url
     *
     * @param url
     */
    public static void openNewTab(String url) {
        String newTab = "window.open('" + url + "','_blank');";
        ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript(newTab);
    }

    /**
     * take screenshot
     */

    public static void takeScreenshot(TestInfo testInfo) {

        //after verification take screenshot
//       I use this code to take a screenshot when needed
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) DriverFactoryImplementation.getInstance().getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + testInfo.getDisplayName() + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(WebElement element) {
        boolean b;
        try {
            b = element.isDisplayed() || !element.isDisplayed();
        } catch (Exception var3) {
            b = false;
        }

        return b;
    }

    public static boolean isElementVisible(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException var2) {
            return false;
        }
    }



    public static void selectByIndex(WebElement webElement, int index) {
        Select city = new Select(webElement);
        city.selectByIndex(index);
    }

//    public static Supplier<String> satici_mail = () -> "https://mailsac.com/inbox/satici_mail@mailsac.com";
//    public static Supplier<String> alici_mail = () -> "https://mailsac.com/inbox/alici_test_mart@mailsac.com";
//    public static Supplier<String> seller_mail = () -> "https://mailsac.com/inbox/seller@mailsac.com";
//    public static Supplier<String> buyer_mail = () -> "https://mailsac.com/inbox/buyer.test@mailsac.com";


    public static class datalar {
        public static Map<String, List<String>> hub_product_map = new HashMap<>();
        public static List<String> hubs = new ArrayList<>();


        public static Map<String, List<String>> createMap_hub_products() {
            String[] product_VEGETABLES_AND_FRUITS_HUB = {"TOMATO_ALICANTE", "TOMATO_CELEBRITIES", "TOMATO_CHERRY", "TOMATO_AZOYCHKA", "TOMATO_ROMAN"};
            String[] product_DAIRY_HUB = {"MILK", "CHEESE", "BUTTER", "YOGURT", "HONEY"};
            String[] product_GARDENING_SERVICES_HUB = {"SOD_INSTALLATION", "LANDSCAPING",};
            String[] product_GARDENING_TOOLS_HUB = {"GARDENING_TOOLS_BROADCAST_SPRAYER", "GARDENING_TOOLS_BROADFORK",};
            String[] product_SEED_HUB = {"SEED_TOMATO_CELEBRITIES", "SEED_CUCUMBER_ENGLISH",};
            String[] product_SEEDLING_AND_SAPLING_HUB = {"SAPLING_TOMATO_GOLD_CHERRY", "SAPLING_SUNFLOWER",};
            String[] product_COMPOST_HUB = {"COMPOST_COMPOST", "COMPOST_FARMYARD_MANURE", "COMPOST_GREEN_MANURE",};
            String[] product_WORM_HUB = {"WORM_RED", "WORM_TIGER",};
            String[] product_FERTILIZER_HUB = {"FERTILIZER_POTASSIUM", "FERTILIZER_INORGANIC",};
            String[] product_HERBS_AND_FLOWERS_HUB = {"HERBS_AND_FLOWERS_BASIL_RED_RUBIN", "HERBS_AND_FLOWERS_CILANTRO",};
            String[] product_TREES_HUB = {"ARIZONA_CYPRESS", "VIRGINIA_PINE"};

            List<String> list_VEGETABLES_AND_FRUITS_HUB = Arrays.asList(product_VEGETABLES_AND_FRUITS_HUB);
            List<String> list_DAIRY_HUB = Arrays.asList(product_DAIRY_HUB);
            List<String> list_GARDENING_SERVICES_HUB = Arrays.asList(product_GARDENING_SERVICES_HUB);
            List<String> list_GARDENING_TOOLS_HUB = Arrays.asList(product_GARDENING_TOOLS_HUB);
            List<String> list_SEED_HUB = Arrays.asList(product_SEED_HUB);
            List<String> list_SEEDLING_AND_SAPLING_HUB = Arrays.asList(product_SEEDLING_AND_SAPLING_HUB);
            List<String> list_COMPOST_HUB = Arrays.asList(product_COMPOST_HUB);
            List<String> list_WORM_HUB = Arrays.asList(product_WORM_HUB);
            List<String> list_FERTILIZER_HUB = Arrays.asList(product_FERTILIZER_HUB);
            List<String> list_HERBS_AND_FLOWERS_HUB = Arrays.asList(product_HERBS_AND_FLOWERS_HUB);
            List<String> list_TREES_HUB = Arrays.asList(product_TREES_HUB);


            hubs.add("VEGETABLES_AND_FRUITS_HUB");
            hubs.add("DAIRY_HUB");
            hubs.add("GARDENING_SERVICES_HUB");
            hubs.add("GARDENING_TOOLS_HUB");
            hubs.add("SEED_HUB");
            hubs.add("SEEDLING_AND_SAPLING_HUB");
            hubs.add("COMPOST_HUB");
            hubs.add("WORM_HUB");
            hubs.add("FERTILIZER_HUB");
            hubs.add("HERBS_AND_FLOWERS_HUB");
            hubs.add("TREES_HUB");
            hub_product_map.put("VEGETABLES_AND_FRUITS_HUB", list_VEGETABLES_AND_FRUITS_HUB);
            hub_product_map.put("DAIRY_HUB", list_DAIRY_HUB);
            hub_product_map.put("GARDENING_SERVICES_HUB", list_GARDENING_SERVICES_HUB);
            hub_product_map.put("GARDENING_TOOLS_HUB", list_GARDENING_TOOLS_HUB);
            hub_product_map.put("SEED_HUB", list_SEED_HUB);
            hub_product_map.put("SEEDLING_AND_SAPLING_HUB", list_SEEDLING_AND_SAPLING_HUB);
            hub_product_map.put("COMPOST_HUB", list_COMPOST_HUB);
            hub_product_map.put("WORM_HUB", list_WORM_HUB);
            hub_product_map.put("FERTILIZER_HUB", list_FERTILIZER_HUB);
            hub_product_map.put("HERBS_AND_FLOWERS_HUB", list_HERBS_AND_FLOWERS_HUB);
            hub_product_map.put("TREES_HUB", list_TREES_HUB);

            for (int i = 0; i < hubs.size(); i++) {

                String hub = hubs.get(i);

                for (int j = 0; j < 2; j++) {

                    String product = hub_product_map.get(hub).get(j);
                    //     System.out.println(hub + " ; " + product);
                }
            }
            return hub_product_map;
        }

    }

    public static String Random_isTrade() {
        Random random = new Random();
        String[] str = {"true", "false"};
        int number = random.nextInt(2);  //0 1
        return str[number];
    }

    public static String Random_isOrganic() {
        Random random = new Random();
        String[] str = {"true", "false"};
        int number = random.nextInt(2);  //0 1
        return str[number];
    }

    public static void refreshPage() {
        DriverFactoryImplementation.getInstance().getDriver().navigate().refresh();

    }

    public static void setAttribute(WebElement element, String value, boolean clearFirst) {
        if (clearFirst) element.clear();
        element.sendKeys(value);
    }

    static AllElements elements = new AllElements();



    //Abdullah tarafindan eklendi.(Nispeten dinamic method).
    //userName dogru girilmeli




    public static class supplier {
        static Date date = new Date(); // This object contains the current date value
        static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        public static Supplier<String> CurrentDateAndTime = () -> formatter.format(date);
    }



    public static String backgroundColorRGB(String argument, String propertyValue, List<WebElement> list, String index) {
        return ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("return window.getComputedStyle(arguments[" + index + "], ':" + argument + "').getPropertyValue('" + propertyValue + "');", list.get(Integer.parseInt(index))).toString();
    }

    //date_compare de kullanilan method icin yazildi
    private static boolean test3(String firstDate, String secondDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM/dd");
        boolean b = false;
        try {
            b = sdf.parse(firstDate).before(sdf.parse(secondDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean date_compare(String date) {
        // su anki saati alip istenilen formata ceviriyor
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM/dd");
        String formattedDate = myDateObj.format(myFormatObj);

        int bosluk = date.indexOf(" ") + 1;  // ilk boslugu kaldiriyor
        String tarih = date.substring(bosluk); // gunu cikarmis olduk
        int bosluk2 = tarih.indexOf(" "); // ay ile gunu ayirdik
        String ay = tarih.substring(0, bosluk2); // ayi ve altta gunu aldik
        String gun = tarih.substring(bosluk2 + 1).substring(0, tarih.substring(bosluk2 + 1).length() - 2);
        String d = (ay + "/" + gun);
        return (test3(formattedDate, d)); // suanki gunden girilen tarih onde ise true veriyor
    }

    public static void switchWindow(String mainWindow) {

        /**
         *         String mainWindow = DriverFactoryImplementation.getInstance().getDriver().getWindowHandle();
         *         seklinde mainWindow eklenmeli
         */
        Set<String> allWindows = DriverFactoryImplementation.getInstance().getDriver().getWindowHandles();

        for (String paypalWindow : allWindows) {
            if (!paypalWindow.equals(mainWindow)) {
                DriverFactoryImplementation.getInstance().getDriver().switchTo().window(paypalWindow);
            }
        }
    }

    /**
     * String kapatilacakWindow = DriverFactoryImplementation.getInstance().getDriver().getWindowHandle();
     * seklinde kapatilacakWindow eklenmeli
     * <p>
     * ilk once o sayfayi kapatip daha sonra anasayfaya geciyor
     *
     * @param kapatilacakWindow
     */
    public static void closeWindow(String kapatilacakWindow) {
        DriverFactoryImplementation.getInstance().getDriver().switchTo().window(kapatilacakWindow).close();
        ReusableMethods.switchWindow(kapatilacakWindow);

    }

    public static String printUrl() {
        return DriverFactoryImplementation.getInstance().getDriver().getCurrentUrl();
    }

    public static void checkUrl(WebElement tiklanacakElement, String expected, WebElement assertEdilecekElement) {
        ReusableMethods.waitForClickablility(tiklanacakElement, 100);
        ReusableMethods.wait(2);
        try {

            tiklanacakElement.click();
            ReusableMethods.waitForPageToLoad(100);
            ReusableMethods.wait(2);
            Assertions.assertTrue(ReusableMethods.printUrl().contains(expected));
            Assertions.assertTrue(assertEdilecekElement.isDisplayed());

        } catch (Exception e) {
            tiklanacakElement.click();
            ReusableMethods.waitForPageToLoad(10);
            ReusableMethods.wait(5);
            Assertions.assertTrue(ReusableMethods.printUrl().contains(expected));
            Assertions.assertTrue(assertEdilecekElement.isDisplayed());

        }

    }



    /**
     * pazar gunun tarihini veriyor
     *
     * @return eger pazartesi sali carsamba ise bu haftanin pazar tarihini verir
     * eger diger gunler ise onumuzdeki pazari veriyor
     * @author omer
     * @since 13.12.2021
     */
    public static String getNextSunday() {
        DateFormat outputFormat = new SimpleDateFormat("EEEE, MMMM dd");
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        LocalDate today = LocalDate.now();
        int weekday = today.getDayOfWeek().getValue();
        if (weekday == 1 || weekday == 2 || weekday == 3) {
            LocalDate nextSunday = today.with(next(SUNDAY));
            String inputText = nextSunday.toString();
            Date date = null;
            try {
                date = inputFormat.parse(inputText);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return outputFormat.format(date);
        } else {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.add(Calendar.DATE, 7);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String inputText2 = df.format(calendar.getTime());
            Date date = null;
            try {
                date = inputFormat.parse(inputText2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return outputFormat.format(date);

        }
    }

    /**
     * onetime weekly order lari update edebilmek icin bir sonraki pazarin tarihini burdan cekiyoruz
     *
     * @return database formatinda nex sunday
     */
    public static String getNextSunday_database() {
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        LocalDate today = LocalDate.now();
        int weekday = today.getDayOfWeek().getValue();
        if (weekday == 1 || weekday == 2 || weekday == 3) {
            LocalDate nextSunday = today.with(next(SUNDAY));
            String inputText = nextSunday.toString();
            Date date = null;
            try {
                date = inputFormat.parse(inputText);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return outputFormat.format(date);
        } else {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.add(Calendar.DATE, 7);
            //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String inputText2 = inputFormat.format(calendar.getTime());
            Date date = null;
            try {
                date = inputFormat.parse(inputText2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return outputFormat.format(date);

        }
    }

    //=====StaleElementReferenceException=====//
    public static void clickStaleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), 20);
        boolean cevir = true;
        while (cevir) {
            try {
                ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                cevir = false;
            } catch (StaleElementReferenceException e) {
                cevir = true;
            }
        }
    }

    public static void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});", element);
    }

    //=====StaleElementReferenceExceptionVisibility=====//
    public static void waitForStaleElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), 20);
        boolean cevir = true;
        while (cevir) {
            try {
                ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                wait.until(ExpectedConditions.visibilityOf(element));
                // element.click();
                cevir = false;
            } catch (StaleElementReferenceException e) {
                cevir = true;
            }
        }
    }

    //=====StaleElementReferenceException=====//
    public static void sendKeysToStaleElement(WebElement element, String str) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), 20);
        Actions actions = new Actions(DriverFactoryImplementation.getInstance().getDriver());
        boolean cevir = true;
        while (cevir) {
            try {
                ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                ReusableMethods.wait(1);
                element.clear();
                actions.sendKeys(element, str).perform();

                cevir = false;
            } catch (StaleElementReferenceException e) {
                cevir = true;
            }
        }
    }

    public static void visitUrlPage() {
        DriverFactoryImplementation.getInstance().getDriver().get(ConfigurationReader.getProperty("UFUrl"));
        //page render oldugu icin wait koyduk
        ReusableMethods.waitForPageToLoad(20);
        //beforeMethod_Logout();
        // ReusableMethods.wait(10);


    }


    public static void visitUrlCanliPage() {
        DriverFactoryImplementation.getInstance().getDriver().get(ConfigurationReader.getProperty("URl_canli"));
        //page render oldugu icin wait koyduk
        ReusableMethods.waitForPageToLoad(20);
        //beforeMethod_Logout();
        ReusableMethods.wait(10);

        // }
    }

    /**
     * local storage daki verileri silip logout olmamizi sagliyor
     * AfterMethod olarak kullanilabilir
     *
     * @author Omer
     * @since 30.12.20212
     */
    public static void localClear() {
        LocalStorage local = ((WebStorage) DriverFactoryImplementation.getInstance().getDriver()).getLocalStorage();
        local.clear();
        DriverFactoryImplementation.getInstance().getDriver().navigate().refresh();
        ReusableMethods.waitForPageToLoad(10);

    }






    private static int largest(int... numbers) {
        int currentLargest = numbers[0];
        for (int number : numbers) {
            if (number > currentLargest) {
                currentLargest = number;
            }
        }
        return currentLargest;
    }

    /**
     * gun/ay/yil seklinde tarihi veriyor
     *
     * @return bugunun tarihi
     * @author omer
     * @since 01.01.2022
     */
    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

    //Scroll down
    public static void scrollToBottomOfPage() {
//        JavascriptExecutor jse = (JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver();
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        DriverFactoryImplementation.getInstance().getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    //ScrollDown by pixel
    public static void scrollDownByPixel(int times, String pixcel) {
        for (int i = 0; i < times; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //scrolling up
            JavascriptExecutor jse = (JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver();
            jse.executeScript("window.scrollBy(0," + pixcel + ")");
        }
    }


    // format method cagrildiginda dinamic yazilabilir. ornegin: "dd/MM/yyyy" veya "MM-dd-yyyy"
    public static String getMeTomorrow(String format) {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +1);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }
    /**
     * Bugunden kac gun sonrasi isteniyorsa plus day kismina int olarak yaziliyor.
     *formati da kendimiz giriyoruz
     * @return bugun+plusday
     * @author Abdullah
     * @since 06.06.2022
     */
    public static String getMeADayFromFuture(String format, int plusDay) {
        //Kac gun sonrasinin tarihini almak istiyorsak plusDayé onu yaziyoruz.

        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +plusDay);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * weekly update test i icin database tarih formatinda bir gun sonrasini veriyor
     *
     * @return yarinin tarihi
     * @author omer
     * @since 21.04.2022
     */
    public static String getMeTomorrow_databaseUpdateWeeklyOrder() {
        String format = "YYYY-MM-dd";
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +1);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * Abdullah
     * @return bugunu haftanin gunu olarak donuyor.pazartesiyi ilk gun kabul ediyor.
     */
    public static int getTheDayofTheWeek(){
        Calendar calendar= Calendar.getInstance();
        return  calendar.get(Calendar.DAY_OF_WEEK)-1;}


    public static String getMe10days_databaseUpdateWeeklyOrder() {
        String format = "YYYY-MM-dd";
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +10);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * weekly update test i icin database tarih formatinda 4 gun sonrasini veriyor
     *
     * @return 4 gun sonraki tarih
     * @author omer
     * @since 21.04.2022
     */
    public static String getMe4days_databaseUpdateWeeklyOrder() {
        String format = "YYYY-MM-dd";
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +4);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * @param day
     * @return
     */
    public static String getDateForPromoCode(int day) {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +day);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     *
     * @return Database'deki formata gore local date ve saati
     */
    public static String getCurrentDateAndTime() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE,0);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }




    /**
     * credential girmeden, dogrudan istenilen sayfaya goturur.
     * Kullanici adi ve url'in devamini yazmak yeterli.
     *
     * @author Abdullah
     * @since 31/12/2021
     * gerektiginde kullanicinin tokenini kullanilabilmesi icin token donduruyor.
     */
    public static String fastLogin(String userName, String restOfUrl) {
        //System.out.println("userName = " + userName);
        return FastLogin.fastLogin(userName, restOfUrl);
    }

    /**
     * pop up in gorunur oldugunu gostermek icin
     *
     * @return popup gorunur ise true gorunmezse false donduruyor
     */
    public static boolean isVisible_popUp() {
        boolean b;
        WebElement popUp = DriverFactoryImplementation.getInstance().getDriver().findElement(By.xpath("//div[contains(@class,'text-center')]/ .. /a"));

        try {

            WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), 0);
            wait.until(ExpectedConditions.elementToBeClickable(popUp));
            b = true;
        } catch (TimeoutException e) {
            b = false;
        }
        return b;
    }










    public static String date() {
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM dd");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public static String convertTime_to_am_pm(String dateInString){
        //Displaying given time in 12 hour format with AM/PM
        //date = "22.30";
        //old format
       // SimpleDateFormat sdf_old = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        SimpleDateFormat sdf_old = new SimpleDateFormat("hh:mm:ss");
        Date date3 = null;
        SimpleDateFormat sdf_new = null;
        try{
            date3 = sdf_old.parse(dateInString);
            //new format
            sdf_new = new SimpleDateFormat("HH:mm aa");
            //formatting the given time to new format with AM/PM
           // System.out.println("Given time in AM/PM: "+sdf_new.format(date3));
        }catch(ParseException e){
            e.printStackTrace();
        }
        return sdf_new.format(date3);
    }


    public static long getDateDifference(String FirstDate, String SecondDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        Date firstDate = null;
        try {
            firstDate = sdf.parse(FirstDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date secondDate = null;
        try {
            secondDate = sdf.parse(SecondDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long difference = time.convert(diff, TimeUnit.MILLISECONDS);
        //System.out.println("The difference in days is : "+difference);
        return difference;
    }

    /**
     * urunlerin bazilari parantezli olarak geldigi icin parantezi kaldirmak icin ara yontem eklendi
     * @param //icinde parantez olan urun adi
     * @return eger parantez varsa cikarttigim urun adi
     */
    public static String remove_parantez(String input) {


        if (input.contains("(")) {
            input = input.replace("(", "");
        }

        if (input.contains(")")) {
            input = input.replace(")", "");
        }
        return input;
    }
    public static boolean randomFalse() {
        Random randomNo = new Random();
        int no = randomNo.nextInt(2);
        return no % 2 != 0;
    }

    // TODO: 15/06/2022 APIENDPOINT UZERINDEN HEPSINI KAPSAYACAK BIR YOL BULAMADIGIM ICIN ENDPOINTS ENUM OLUSTURDUM. OMER BEYE SORULACAK
    public static void responseMethodwithBody(USERINFO userinfo, ENDPOINTS apiendpoint) {

        ///System.out.println("reqBody = " + reqBody);
        response = given().headers(
                        "Authorization",
                        "Bearer " + userinfo.getToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                body(reqBody).
                when().
                post(apiendpoint.getEndPoint());
        response.prettyPrint();
    }
    // TODO: 15/06/2022 APIENDPOINT UZERINDEN HEPSINI KAPSAYACAK BIR YOL BULAMADIGIM ICIN ENDPOINTS ENUM OLUSTURDUM. OMER BEYE SORULACAK
    public static void responseMethod(ENDPOINTS apiendpoint, USERINFO userinfo) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + userinfo.getToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                post(apiendpoint.getEndPoint());
        response.prettyPrint();
    }

    public static ExpectedCondition<Boolean> stalenessOf(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver ignored) {
                try {
                    // Calling any method forces a staleness check
                    element.isEnabled();
                    return false;
                } catch (StaleElementReferenceException expected) {
                    return true;
                }
            }

            @Override
            public String toString() {
                return String.format("element (%s) to become stale", element);
            }
        };
    }

    public static boolean retryingFindGetText(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                DriverFactoryImplementation.getInstance().getDriver().findElement(by).getText();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

}



