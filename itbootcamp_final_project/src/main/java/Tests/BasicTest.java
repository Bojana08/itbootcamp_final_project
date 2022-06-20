package Tests;

import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasicTest {

    private WebDriver driver;
    private String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    private LoginPage loginPage;
    private NavPage navPage;
    private CitiesPage citiesPage;
    private SignupPage signupPage;
    private MessagePopUpPage messagePopUpPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage();
        navPage = new NavPage();
        citiesPage = new CitiesPage();
        signupPage = new SignupPage();
        messagePopUpPage = new MessagePopUpPage();
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
