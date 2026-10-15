package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class SignUpAndDeleteTest extends BaseTest {

    @Test(description = "Test Case 1 - part 1: Sign Up Account")
    public void signUpIsSuccessful() {
        String expectedSuccessfulSignUpMessage = new HomePage(driver)
                .openPage()
                .moveToLoginPage()
                .enterSignUpCredentials("testUser", "javaTest@gmail.com")
                .fillInAccountDetails("Mrs.", "12345", "1", "January", "2016")
                .fillInAddressDetails("firstName", "lastName", "address", "Canada", "state", "city", "1234", "3456789")
                .confirmSignUpInformation()
                .extractAccountCreatedMessage();
        Assert.assertEquals(expectedSuccessfulSignUpMessage, "ACCOUNT CREATED!", "Account is not created");
    }

    @Test(description = "Test Case 1 - part 2: Delete Account", dependsOnMethods = "signUpIsSuccessful()")
    public void deleteIsSuccessful() {
        String expectedSuccessfulDeleteMessage = new HomePage(driver)
                .openPage()
                .moveToLoginPage()
                .enterLoginCredentials("12345", "javaTest@gmail.com")
                .deleteAccount()
                .extractAccountDeletedMessage();
        Assert.assertEquals(expectedSuccessfulDeleteMessage, "ACCOUNT DELETED!", "Account is not deleted");
    }
}
