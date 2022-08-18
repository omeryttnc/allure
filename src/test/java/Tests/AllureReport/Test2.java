package Tests.AllureReport;

import io.qameta.allure.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Epic("Weekly Order")
public class Test2 {


    //
    @Nested
    @Feature("One Time")
    class OneTime {
        @Story("one time positive")
        @Owner(value = "OMER")
        @Test
        void positive1() {
        }

        //            }
        @Story("one time negative")
        @Nested
        class negative {
            @Owner(value = "OMER")
            @Severity(SeverityLevel.BLOCKER)
            @Test
            void negative2() {
            }
            @Owner(value = "OMER")
            @Severity(SeverityLevel.BLOCKER)
            @Test
            void negative3() {
            }
        }
    }

//        @Nested
//        class WeeklyO {

    @Feature("Weekly")
    @Story("Weekly positive")
    @Owner(value = "OMER")
    @Test
    void positive() {
    }

    @Feature("Weekly")
    @Story("Weekly negative")
    @Owner(value = "OMER")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void negative() {
    }
}
//    }
