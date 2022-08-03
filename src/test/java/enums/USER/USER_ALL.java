package enums.USER;

import Tests.BrowserTestBase;

public class USER_ALL extends BrowserTestBase {
    // ana class imiz
    private USER_MANAGER user_manager;


    public USER_ALL(USERINFO userinfo) {
        this.user_manager = new USER_MANAGER(userinfo);

    }


    public USER_MANAGER getUser_manager() {
        return user_manager;
    }


}




