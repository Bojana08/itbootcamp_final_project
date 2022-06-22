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

    public WebElement getSaveButton() {
        return this.driver.findElement(By.className("btnSave"));
    }

    public WebElement getSearchInput() {
        return this.driver.findElement(By.id("search"));
    }

    public void waitForRowsToAppear(int rowNum) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNum + 1));
    }

    public WebElement getEditButton(int rowIndex) {
        return this.driver.findElements(By.id("edit")).get(rowIndex - 1);
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return driver
                .findElement(By.xpath(
                        "//tbody/tr["+rowIndex +"]/td["+ columnIndex +"]"));
    }
}
