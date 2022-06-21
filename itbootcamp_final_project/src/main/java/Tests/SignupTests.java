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

    @Test(priority = 3)
    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignUpButton().click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/signup"),
                "[ERROR] - Page URL does not contain '/signup'.");
        signupPage.getNameInput().sendKeys(name);
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswordInput().sendKeys(password);
        signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.waitForPopUpMessageToBeVisible().getText(),
                "E-mail already exists",
                "[ERROR] - There is no 'E-mail already exists' in pop up error.");

    }

}
