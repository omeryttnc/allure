package pages;

public class AllElements {
    private xb homePage;

    public xb getHomePage() {
        if (homePage == null) {
            homePage = new xb();
        }
        return homePage;
    }


}
