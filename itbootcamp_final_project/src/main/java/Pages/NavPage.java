package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class NavPage {

    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonEN() {
        this.driver.findElement(By.className("btnLocaleActivation")).click();
        return this.driver.findElement(By.id("list-item-73"));
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.linkText("LOGIN"));
    }

    public WebElement getLogoutButton() {
        return this.driver.findElement(By.className("btnLogout"));
    }

    public WebElement getSignUpButton() {
        return this.driver.findElement(By.linkText("SIGN UP"));
    }

    public WebElement getAdminButton() {
        return this.driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesButton() {
        return this.driver.findElement(By.linkText("Cities"));
    }

    public void getHomeLink() {
        this.driver.get(driver.getCurrentUrl()+"home");
    }

    public void getMyProfileLink() {
        this.driver.get(driver.getCurrentUrl()+"profile");
    }

}
