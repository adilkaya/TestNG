package Proje_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class ParameterDriver_TEstNg {

    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser) {

        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://demowebshop.tricentis.com/");

        //Login
        WebElement login= driver.findElement(By.cssSelector("a.ico-login"));
        login.click();

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("adl.22@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("12345678");

        WebElement loginButton = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        loginButton.click();


        if (!browser.equalsIgnoreCase("firefox")){
        //Güvenlik işlemlerini aşmak için
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[id='details-button']")));


            WebElement sitedonusBtn = driver.findElement(By.cssSelector("button[id='details-button']"));
            sitedonusBtn.click();

            WebElement btnSiteIlerleLinki = driver.findElement(By.id("proceed-link"));
            btnSiteIlerleLinki.click();
        }


    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
