package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MessagePopUpPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForPopUpMessageToBeVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-snack__content")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-btn--flat")));
        return this.driver.findElement(By.tagName("li"));
    }


}
