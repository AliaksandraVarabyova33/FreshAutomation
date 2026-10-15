package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmSignUpPage extends BasePage {
    public ConfirmSignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@data-qa ='account-created']")
    private WebElement successfulSignUpMessage;

    public String extractAccountCreatedMessage() {
        return waitUntilElementIsVisible(successfulSignUpMessage).getText();
    }
}
