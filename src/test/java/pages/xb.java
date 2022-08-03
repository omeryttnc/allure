package pages;

import driver.DriverFactoryImplementation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class xb {
    public xb() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }

    @FindBy(css = ".button.site-header__button")
    public WebElement get_in_touch;

    @FindBy(css = "[name='Full-Name']")
    public WebElement full_name;

    @FindBy(css = "[data-name='Email']")
    public WebElement email;

    @FindBy(css = "#Contact-Number")
    public WebElement contact_number;

    @FindBy(css = "Company-Name-2")
    public WebElement company_name;

    @FindBy(css = "#Message")
    public WebElement how_can_we_help;

    @FindBy(css = ".contact-form__checkbox")
    public WebElement tick_to_confirm;

    @FindBy(css = ".w-button")
    public WebElement submit;


}
