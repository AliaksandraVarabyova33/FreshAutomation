package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-qa ='signup-name']")
    private WebElement signUpNameField;

    @FindBy(xpath = "//input[@data-qa ='signup-email']")
    private WebElement signUpEmailField;

    @FindBy(xpath = "//button[@data-qa ='signup-button']")
    private WebElement signUpButton;

    @FindBy(xpath = "//input[@data-qa ='login-password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//input[@data-qa ='login-email']")
    private WebElement loginEmailField;

    @FindBy(xpath = "//button[@data-qa ='login-button']")
    private WebElement loginButton;

    public SignUpPage enterSignUpCredentials(String name, String email) {
        waitUntilElementIsVisible(signUpNameField).sendKeys(name);
        signUpEmailField.sendKeys(email);
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public HomePage enterLoginCredentials(String password, String email) {
        waitUntilElementIsVisible(loginEmailField).sendKeys(email);
        loginPassword.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}
