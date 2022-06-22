package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{

    @Test(priority = 1)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {

        navPage.getHomeLink();
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain '/login'.");
    }

    @Test(priority = 2)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {

        navPage.getMyProfileLink();
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain '/login'.");
    }

    @Test(priority = 3)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {

        driver.get(baseUrl + "/admin/cities");
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain '/login'.");
    }

    @Test(priority = 4)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {

        driver.get(baseUrl + "/admin/users");
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain '/login'.");
    }

}
