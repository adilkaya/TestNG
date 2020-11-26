package Mentoring.Tahir.CrossBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyTitle {

    WebDriver driver;



    @Test
    @Parameters("browser")
    public void verifyPageTitle(String browserName){

        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/chromedriver.exe");

            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/geckodriver.exe");
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();

        driver.get("http://www.learn-automation.com");

                System.out.println(driver.getTitle());

    }
}