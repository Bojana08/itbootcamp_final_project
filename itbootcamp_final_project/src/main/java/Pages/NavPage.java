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

    public WebElement getLanguageButton() {
        return this.driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getButtonEN() {
        return this.driver.findElement(By.className("btnEN"));
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

    public WebElement getButtonES() {
        return this.driver.findElement(By.className("btnES"));
    }

    public WebElement getButtonFR() {
        return this.driver.findElement(By.className("btnFR"));
    }

    public WebElement getButtonCN() {
        return this.driver.findElement(By.className("btnCN"));
    }

    public WebElement getHeader() {
        return this.driver.findElement(By.tagName("h1"));
    }

}
