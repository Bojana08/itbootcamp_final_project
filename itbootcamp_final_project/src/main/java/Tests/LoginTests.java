package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 1)
    public void visitsTheLoginPage() {

        navPage.getButtonEN().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain '/login'.");
    }

    @Test(priority = 2)
    public void checksInputTypes() {

        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] - Input email is not type email.");
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] - Input password is not type password.");
    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.waitForPopUpMessageToBeVisible().getText(),
                "User does not exists",
                "[ERROR] - There is no 'User does not exists' in pop up error.");
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain '/login'.");
    }

    @Test(priority = 4)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.waitForPopUpMessageToBeVisible().getText(),
                "Wrong password",
                "[ERROR] - There is no 'Wrong password' in pop up error.");
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain '/login'.");
    }

    @Test(priority = 5)
    public void login() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        wait.until(ExpectedConditions.urlContains("/home"));
    }

    @Test(priority = 6)
    public void logout() {
         wait.until(ExpectedConditions.visibilityOf(navPage.getLogoutButton()));
         navPage.getLogoutButton().click();
    }


}
