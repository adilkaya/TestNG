package Proje_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseDriverProject_TEstNG {
    public  WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        driver.get("http://demowebshop.tricentis.com/");

        driver.manage().deleteAllCookies();

        logIn();
    }

    public void logIn(){
            WebElement login= driver.findElement(By.cssSelector("a.ico-login"));
            login.click();

            WebElement email = driver.findElement(By.id("Email"));
            email.sendKeys("adl.22@gmail.com");

            WebElement password = driver.findElement(By.id("Password"));
            password.sendKeys("12345678");

            WebElement loginButton = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
            loginButton.click();
    }




    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
