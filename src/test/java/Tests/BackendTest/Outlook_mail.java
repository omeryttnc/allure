package Tests.BackendTest;

import Tests.BrowserTestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import utilities.ReusableMethods;

public class Outlook_mail extends BrowserTestBase {
    @Test
    public void getAllMail() {
        Driver.getDriver().get("https://outlook.live.com/owa/");
        LocalStorage localStorage = ((WebStorage) Driver.getDriver()).getLocalStorage();


        ReusableMethods.wait(5);
        Driver.getDriver().findElement(By.xpath("/html/body/header/div/aside/div/nav/ul/li[2]/a")).click();
        ReusableMethods.wait(5);
        String userName ="omeryttnc@hotmail.com";
        Driver.getDriver().findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(userName);
        ReusableMethods.wait(5);
        String pass = "Antep.0603";
        Driver.getDriver().findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys(pass);
        ReusableMethods.wait(5);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();


        ReusableMethods.wait(5);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();

        ReusableMethods.wait(5);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"AQAAAAAAAQwBAAAFPCFgyQAAAAA=\"]/div/div/div[1]/div/div[1]/div[2]/span")).click();
    }

    @Test
    public void getLocal() {
        Driver.getDriver().get("https://outlook.live.com/owa/");
        LocalStorage localStorage = ((WebStorage) Driver.getDriver()).getLocalStorage();

        localStorage.setItem("UsersNormalizedTheme","base");
        localStorage.setItem("sessionTracking_00067FFEE45611A4","{\"authenticatedState\":1,\"upn\":\"omeryttnc@hotmail.com\",\"idp\":\"msa\",\"lastActiveTime\":1658485444774}");
        localStorage.setItem("LogicalRing","WW");
        localStorage.setItem("OwaClientId","6B809DF3142246C3841691886304A92D");
        localStorage.setItem("bootstrapMailListItemViewSwapSetting","true");
        localStorage.setItem("sdmp","{\"TimeZoneStr\":\"Turkey Standard Time\",\"InboxReadingPanePosition\":3,\"IsFocusedInboxOn\":true,\"BootWithConversationView\":false,\"SortResults\":[{\"Path\":{\"__type\":\"PropertyUri:#Exchange\",\"FieldURI\":\"item:ReceivedOrRenewTime\"},\"Order\":\"Descending\"},{\"Path\":{\"__type\":\"PropertyUri:#Exchange\",\"FieldURI\":\"item:DateTimeReceived\"},\"Order\":\"Descending\"}]}");
        localStorage.setItem("sessionTracking_SignedInAccountList","[{\"sessionTrackingKey\":\"sessionTracking_00067FFEE45611A4\",\"lastActiveTime\":1658485444774}]");
        localStorage.setItem("sdfp","{\"TimeZoneStr\":\"Turkey Standard Time\"}");
        localStorage.setItem("bootstrapMailListItemViewMode","3col");
        localStorage.setItem("WebPushUserSettings","[{\"userPreferenceIdentifier\":\"00067ffe-e456-11a4-0000-000000000000_\",\"lastSessionDate\":\"Fri Jul 22 2022\",\"uniqueDaysSessionCount\":1,\"enabled\":null,\"mailEnabled\":null,\"reminderEnabled\":null,\"vipMailEnabled\":null,\"lastCheckboxUnchecked\":null,\"promptCount\":0,\"lastPromptDate\":null}]");
        localStorage.setItem("OwaLocale","en");
        localStorage.setItem("bootstrapMailListItemWindowWidth","163");
        localStorage.setItem("MailOwaPreloadStrings","[\"https://res.cdn.office.net/owamail/20220715009.09/scripts/../resources/locale/en/owa.SharedBoot.json\",\"https://res.cdn.office.net/owamail/20220715009.09/scripts/../resources/locale/en/owa.MailBoot.json\",\"https://res.cdn.office.net/owamail/20220715009.09/scripts/../resources/locale/en/owa.MailListItemThreeColumnView.json\",\"https://res.cdn.office.net/owamail/20220715009.09/scripts/../resources/locale/en/owa.MailListItemSingleLineView.json\",\"https://res.cdn.office.net/owamail/20220715009.09/scripts/../resources/locale/en/owa.MailRibbon.json\"]");
        localStorage.setItem("O365Shell_ThemeInfo_Consumer","{\"Id\":\"base\",\"Primary\":\"#0078d4\",\"NavBar\":\"#0078d4\",\"DefaultBackground\":\"#0078d4\",\"BackgroundImageUrl\":null,\"DefaultText\":\"#FFFFFF\",\"AppName\":\"#FFFFFF\",\"FullBleedImages\":null,\"userPersonalizationAllowed\":true}");
        localStorage.setItem("BootDiagnostics","{\"puid\":\"00067FFEE45611A4\",\"tid\":\"84df9e7f-e9f6-40af-b435-aaaaaaaaaaaa\",\"mbx\":\"00067ffe-e456-11a4-0000-000000000000\",\"prem\":\"0\",\"isCon\":true,\"upn\":\"omeryttnc@hotmail.com\"}");

        ReusableMethods.refreshPage();
        Driver.getDriver().get("https://outlook.live.com/mail/0/");
        ReusableMethods.wait(20);

    }
}
