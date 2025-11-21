package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationDeletePage extends BasePage {
    public ConfirmationDeletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@data-qa ='account-deleted']")
    private WebElement deleteMessage;

    public String extractAccountDeletedMessage() {
        return waitUntilElementIsVisible(deleteMessage).getText();
    }
}
