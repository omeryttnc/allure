package Tests.AllureReport;

import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Test3 {
    @Epic("Weekly Order")
    @Feature("Weekly")
    @Story("Can user able to receive email after purchasing weekly order")
    @Owner(value = "OMER")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5,6,7,8})
    void name(int nu) {
        System.out.println(nu);
    }
}
