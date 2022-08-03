package Tests.AllureReport;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("EP001")
@Story("US003")
public class Test1 {
    @Test
    public void testCase01() {
    }

    @Test
    public void testCase1() {
        System.out.println("testcase 1");

    }
}
