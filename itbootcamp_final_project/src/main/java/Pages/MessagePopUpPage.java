package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPopUpMessageToBeVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public void waitForPopUpMessageSuccessfullyToBeVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getMessageTextElement() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-snack__content")));
        return this.driver.findElement(By.tagName("li"));
    }

    public WebElement getMessageSuccessfullyTextElement() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
        return this.driver.findElement(By.className("success"));
    }

    public WebElement getCloseButtonFromPopUpMesssage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-snack__content")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-btn--flat")));
        return this.driver.findElement(By.className("v-btn--flat"));
    }

    public void waitForDialogueToBeVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-card")));
    }

    public WebElement getTitleFromVerifyYourAccountDialog() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-card__title")));
        return this.driver.findElement(By.className("v-card__title"));
    }

    public WebElement getCloseButton() {
        return this.driver.findElement(By.className("btnClose"));
    }

}
