package Tests.UITests.BJSS;

import Tests.BrowserTestBase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Codility extends BrowserTestBase {
    @Test
    void name() {
        Assert.assertTrue(elements.getHomePage().company_name.isDisplayed());
        elements.getHomePage().company_name.click();
    }
}
