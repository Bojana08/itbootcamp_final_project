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

}
