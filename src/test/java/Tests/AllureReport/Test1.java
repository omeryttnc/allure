package Tests.AllureReport;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("EP001")
@Story("US003")
public class Test1 {
    @Epic("Weekly Order")
    @Feature("One Time")
    @Story("Can user able to buy one time order")
    @Owner(value = "OMER")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("TC_01")


    @Test
    public void testCase1() {
        System.out.println("testcase 1");
        Assertions.assertEquals(2, 2);

    }
}
