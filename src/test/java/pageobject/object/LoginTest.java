package pageobject.object;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {
    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials("nickysmith2023@yahoo.com", "lSOnFe");
        softAssert.assertTrue(loginPage.successMessageIsDisplayed(), "Success message is not displayed");
        softAssert.assertEquals(loginPage.getSuccessMessageText(), "You are now logged in as Nicky Smith.");
        softAssert.assertAll();
    }

    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials("nickysmith2023@yahoo.com", "12341234");
        softAssert.assertTrue(loginPage.errorMessageIsDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(loginPage.getErrorMessageText(), "Wrong password or the account is disabled, or does not exist");
        softAssert.assertAll();
    }

    @Test
    public void loginWithWrongEmailAndCorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials("nickysmith@yahoo.com", "12341234");
        softAssert.assertTrue(loginPage.errorMessageIsDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(loginPage.getErrorMessageText(), "Wrong password or the account is disabled, or does not exist");
        softAssert.assertAll();
    }

    @Test
    public void loginWithCorrectEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials("nickysmith@yahoo.com", "");
        softAssert.assertTrue(loginPage.errorMessageIsDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(loginPage.getErrorMessageText(), "You must provide both email address and password.");
        softAssert.assertAll();

    }

    @Test(enabled = false)
    public void loginWithEmptyRequiredEmailAndCorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials("nickysmith@yahoo.com", "");

        Alert alert = driver.switchTo().alert(); // NoAlertPresentException: no such alert. Ask how to handle such tooltip.
        String alertText = alert.getText();
        alert.accept();
        softAssert.assertEquals(alertText, "Please fill out this field.");
        softAssert.assertAll();
    }
}
