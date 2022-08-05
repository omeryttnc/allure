package Tests.UITests.interviewQuestions_1;

import Tests.BrowserTestBase;
import Tests.junitCalismalari.Jenkins.SmokeTest;
import Tests.junitCalismalari.Users.Omer;
import enums.USER.USERINFO;
import enums.USER.USER_ALL;
import org.junit.jupiter.api.DisplayName;

public class Fruugo extends BrowserTestBase {
    @SmokeTest
    @Omer
    @DisplayName("check title format")
    public void checkTitleFormat() {
        USER_ALL user_all = new USER_ALL(USERINFO.BUYER);
        System.out.println("user_all.getUser_manager().getEmail() = " + user_all.getUser_manager().getEmail());
    }
}
