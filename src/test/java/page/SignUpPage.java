package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='password']")
    private WebElement signUpPasswordField;

    @FindBy(id = "days")
    private WebElement signUpBirthDayDropdown;

    @FindBy(id = "months")
    private WebElement signUpBirthMonthDropdown;

    @FindBy(id = "years")
    private WebElement signUpBirthYearDropdown;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement signUpFirstNameField;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement signUpLastNameField;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement signUpAddressField;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement signUpCountryDropdown;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement signUpCityField;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement signUpStateField;

    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement signUpZipCodeField;

    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement signUpPhoneNumberField;

    @FindBy(xpath = "//button[text()='Create Account']")
    private WebElement createAccountButton;

    public SignUpPage fillInAccountDetails(String title, String password, String day, String month, String year) {
        getRadioButtonByLabel(title).click();
        signUpPasswordField.sendKeys(password);
        Select select;
        select = new Select(signUpBirthDayDropdown);
        select.selectByValue(day);
        select = new Select(signUpBirthMonthDropdown);
        select.selectByValue(day);
        select = new Select(signUpBirthYearDropdown);
        select.selectByValue(year);
        return this;
    }

    public SignUpPage fillInAddressDetails(String firstName, String lastName, String addresss, String country, String state, String city, String zipCode, String phoneNumber) {
        signUpFirstNameField.sendKeys(firstName);
        signUpLastNameField.sendKeys(lastName);
        signUpAddressField.sendKeys(addresss);
        Select select = new Select(signUpCountryDropdown);
        select.selectByValue(country);
        signUpCityField.sendKeys(city);
        signUpStateField.sendKeys(state);
        signUpZipCodeField.sendKeys(zipCode);
        signUpPhoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    public ConfirmSignUpPage confirmSignUpInformation() {
        createAccountButton.click();
        return new ConfirmSignUpPage(driver);
    }

    private WebElement getRadioButtonByLabel(String labelText) {
        String xpath = String.format("//label[contains(., '%s')]/div", labelText);
        return waitUntilElementLocatedByIsVisible(By.xpath(xpath));
    }

}
