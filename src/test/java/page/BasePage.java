package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected final int EXPLICIT_WAIT_SECONDS = 10;
    protected final int IMPLICIT_WAIT_SECONDS = 1;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitUntilElementIsVisible(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_SECONDS)).until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilElementLocatedByIsVisible(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_SECONDS)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void closeCookiePopupIfPresent() {
        try {
            WebElement okButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']")));
            okButton.click();
        } catch (Exception ignored) {
            // Если кнопки нет — ничего не делаем
        }
    }


}
