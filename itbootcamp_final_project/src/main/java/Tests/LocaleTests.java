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

}
