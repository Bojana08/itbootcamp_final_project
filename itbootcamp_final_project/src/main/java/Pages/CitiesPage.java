package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {

    private WebDriver driver;
    protected WebDriverWait wait;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return this.driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getNameInput() {
        return this.driver.findElement(By.id("name"));
    }

    public void waitForEditOrCreateDialogToBeVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-card")));
    }


}
