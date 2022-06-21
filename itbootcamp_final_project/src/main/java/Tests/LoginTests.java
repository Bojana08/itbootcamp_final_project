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
        Assert.assertEquals(this.driver.findElement(By.id("email")).getAttribute("type"),
                "email",
                "[ERROR] - Input email is not type email.");
        Assert.assertEquals(this.driver.findElement(By.id("password")).getAttribute("type"),
                "password",
                "[ERROR] - Input password is not type password.");
    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserDoesNotExist() throws InterruptedException {
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-snack__content")));
        Assert.assertEquals(this.driver.findElement(By.tagName("li")).getText(),
                "User does not exists",
                "[ERROR] - There is no 'User does not exists' in pop up error.");
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain '/login'.");
    }
}
