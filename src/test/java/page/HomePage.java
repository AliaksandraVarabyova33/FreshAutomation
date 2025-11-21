package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String HOME_PAGE_LINK = "https://automationexercise.com/";

    @FindBy(xpath = "//a[text() =' Signup / Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    private WebElement deleteAccountButton;

    public HomePage openPage() {
        driver.get(HOME_PAGE_LINK);
        closeCookiePopupIfPresent();
        return this;
    }

    public LoginPage moveToLoginPage() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public ConfirmationDeletePage deleteAccount() {
        waitUntilElementIsVisible(deleteAccountButton).click();
        return new ConfirmationDeletePage(driver);
    }
}
