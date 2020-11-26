package Proje_TestNG;

import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * NOTE : 	NOT: Bu web sitesi için bir hesabınız yoksa,bir tane oluşturun
 * testNG Projesi :
 * •	Verilen taskları  iki farklı classta oluşturmalı ve taskları tamamladıktan sonra bu görevleri paralel olarak run etmelisiniz.
 * •	Username ve password ‘ u  xml dosyasında  bir parametre olarak kullanın.
 *
 * Task 1)
 * Step 1) Siteye gidin    http://demowebshop.tricentis.com/
 * Step 2) username ve password girin.
 * Step 3) Sol alttaki contact us butonuna tıklayın.
 * Step 4)Gerekli alanları doldurun.
 * Step 5) Submit butonuna tıklayın.
 * Step 6) Submite bastıktan sonra gelen mesajın gözüküp gözükmedigini kontrol edin.
 */
public class Task1 extends ParameterDriver_TEstNg {


    public Task1(WebDriver driver) {
        super();
    }

    @Test
    @Parameters
    public void addToWishList(){


        WebElement facebook = driver.findElement(By.linkText("Contact us]"));
        facebook.click();

        WebElement Enquiry = driver.findElement(By.xpath("//textarea[@id='Enquiry']"));
        Enquiry.sendKeys("Haydi biraz mola verelim..");

        WebElement submitButton = driver.findElement(By.xpath("//input[@class='button-1 contact-us-button']   "));
        submitButton.click();

        String confirmMessage = driver.findElement(By.cssSelector("div[class='result']")).getText();

        Assert.assertTrue(confirmMessage.contains("successfully"));


}
}


//