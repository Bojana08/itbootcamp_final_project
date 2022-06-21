package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{

    @Test(priority = 1)
    public void visitsTheSignupPage() {

        navPage.getSignUpButton().click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/signup"),
                "[ERROR] - Page URL does not contain '/signup'.");
    }

    @Test(priority = 2)
    public void checksInputTypes() {

        navPage.getSignUpButton().click();
        Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] - Input email is not type email.");
        Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] - Input password is not type password.");
        Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] - Input Confirm password is not type password.");
    }

}
