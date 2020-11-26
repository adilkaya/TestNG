package Gun01;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
   Senaryo ;
     1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
     2- asd@gmail.com  ve 123qweasd   bilgileri ile login olan test metodunu yazınız.
     3- Login olup olmadığınızı assert ile kontrol ediniz.
     4- bir utils paketi açınız ve buraya beforeClass ve afterClass metdolarını yazarak
        genel kullanım için MetodWebDriver isimli test klasını tanımlayınız.
 */
public class _05_Ornek extends MetodDriver {

    @Test
    void loginKontrol()
    {
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("asd@gmail.com");

        WebElement pass=driver.findElement(By.id("input-password"));
        pass.sendKeys("123qweasd");

        WebElement btnLogin =driver.findElement(By.cssSelector("input.btn.btn-primary"));
        btnLogin.click();
    }

}
