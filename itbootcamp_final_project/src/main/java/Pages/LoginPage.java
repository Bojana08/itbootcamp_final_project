package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailInput() {
        return this.driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInput() {
        return this.driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.className("v-btn--contained"));
    }

}
