package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1)
    public void setLocaleToES() {

        navPage.getLanguageButton().click();
        navPage.getButtonES().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Página de aterrizaje"),
                "[ERROR] - Page Header does not contain 'Página de aterrizaje'.");
    }

    @Test(priority = 2)
    public void setLocaleToEN() {

        navPage.getLanguageButton().click();
        navPage.getButtonEN().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Landing"),
                "[ERROR] - Page Header does not contain 'Landing'.");
    }

    @Test(priority = 3)
    public void setLocaleToCN() {

        navPage.getLanguageButton().click();
        navPage.getButtonCN().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("首页"),
                "[ERROR] - Page Header does not contain '首页'.");
    }

    @Test(priority = 4)
    public void setLocaleToFR() {

        navPage.getLanguageButton().click();
        navPage.getButtonFR().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Page d'atterrissage"),
                "[ERROR] - Page Header does not contain 'Page d'atterrissage'.");
    }

}
