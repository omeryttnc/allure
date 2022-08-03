package Tests.Juni5_works;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("development")
public class ClassATest {
    @Test
    @Tag("userManagement")
    void testCaseA(TestInfo testInfo) {
        System.out.println("test case a is called");
    }

    @Test
    @Tag("development")
    @Tag("production")
    void testCaseB(TestInfo testInfo) {
        System.out.println("test case b is called");
        System.out.println(testInfo.getTags());
    }
}
