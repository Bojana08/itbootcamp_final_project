package Tests;

import Pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
        navPage = new NavPage(driver);
        citiesPage = new CitiesPage(driver);
        signupPage = new SignupPage(driver);
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

    @AfterMethod
    public void createScreenShotForFailedTest(ITestResult result) throws IOException {
        String timestamp = new SimpleDateFormat(
                "hh_mm_ss_dd_MM_yyyy").format(new Date());
        if (result.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(
                    "src/main/java/Screenshots/TestFailure_" + timestamp + ".png"));
        }
    }

}
