package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

}
