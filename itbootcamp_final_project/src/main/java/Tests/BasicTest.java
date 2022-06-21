package Tests;

import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasicTest {

    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected CitiesPage citiesPage;
    protected SignupPage signupPage;
    protected MessagePopUpPage messagePopUpPage;
    protected WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
        navPage = new NavPage(driver);
        citiesPage = new CitiesPage();
        signupPage = new SignupPage();
        messagePopUpPage = new MessagePopUpPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        this.driver.get(baseUrl);
    }

    @AfterClass
    public void afterClass() {
        this.driver.quit();
    }

}
