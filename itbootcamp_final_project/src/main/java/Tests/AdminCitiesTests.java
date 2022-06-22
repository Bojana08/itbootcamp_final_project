package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCities() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        wait.until(ExpectedConditions.urlContains("/admin/cities"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] - Page URL does not contain '/admin/cities'.");
    }

    @Test(priority = 2)
    public void checksInputTypesForCreateOrEditNewCity() {

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditOrCreateDialogToBeVisible();
        Assert.assertEquals(citiesPage.getNameInput().getAttribute("type"),
                "text",
                "[ERROR] - Input name is not type text.");
    }

    @Test(priority = 3)
    public void createNewCity() {
        String city = "Bojana R's city";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditOrCreateDialogToBeVisible();
        citiesPage.getNameInput().sendKeys(city);
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUpMessageSavedSuccessfullyToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.getMessageSavedSuccessfullyTextElement().getText().contains("Saved successfully"),
                "[ERROR] - Pop Up Message does not contain 'Saved successfully'");
    }

    @Test(priority = 4)
    public void editCity() {
        String oldCityName = "Bojana R's city";
        String newCityName = "Bojana R's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys(oldCityName);
        citiesPage.waitForRowsToAppear(1);
        citiesPage.getEditButton(1).click();
        Actions actions = new Actions(driver);
        actions
                .click(citiesPage.getNameInput())
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(newCityName)
                .perform();
        wait.until(ExpectedConditions.elementToBeClickable(citiesPage.getSaveButton()));
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUpMessageSavedSuccessfullyToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.getMessageSavedSuccessfullyTextElement().getText().contains("Saved successfully"),
                "[ERROR] - Pop Up Message does not contain 'Saved successfully'");
    }

    @Test(priority = 5)
    public void searchCity() {
        String cityName = "Bojana R's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(citiesPage.getSearchInput()));
        citiesPage.getSearchInput().sendKeys(cityName);

        citiesPage.waitForRowsToAppear(1);
        Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(),
                cityName,
                "[ERROR] - City that you searched for does not exist.");
    }

    

}
