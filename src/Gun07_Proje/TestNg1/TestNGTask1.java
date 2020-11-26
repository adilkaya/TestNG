package Gun07_Proje.TestNg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestNGTask1 extends  BaseDriverProject{
    /* TASK 1
               - Bu siteye gidiniz.  "http://demowebshop.tricentis.com/"
               - Sağ üstteki "Log in" yazısına tıklayınız.
               - "email" ve "password" girip "log in"e tıklayınız.

               - Sayfanın en altındaki "Follow Us" başlığındaki "Facebook" buttonuna tıklayınız.
                   Sonrasında açılan pencerenin URL'indeki "facebook" kelimesini doğrulayınız.
               - Ana sayfaya geri dönün.

               - "Information" başlığı altındaki "Contact Us" buttonuna tıklayınız.
               - "Enquiry" yazan yerin altındaki text kutusuna mesajınızı yazıp "submit" butonuna tıklayınız.
               - Sonrasında çıkan yazıyı doğrulayınız. */

    @Test
    public void faceBookTest() throws InterruptedException {

        String homePageID = driver.getWindowHandle();
//     - Sayfanın en altındaki "Follow Us" başlığındaki "Facebook" buttonuna tıklayınız.
        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));  // linktext ile anabiliriz...
        facebook.click();

        Set<String> windowsIDs = driver.getWindowHandles();

        for (String id : windowsIDs ) {
            if(homePageID.equals(id)) continue;
           driver.switchTo().window(id);  // BURAYA FIREFOX YAKALAYAMIYOR wait ayarla...
            wait.until(ExpectedConditions.urlContains("facebook"));
            System.out.println("Window title : " +driver.getTitle() + "  |  "+ driver.getCurrentUrl());
        }
        // Sonrasında açılan pencerenin URL'indeki "facebook" kelimesini doğrulayınız.
        textValidation(driver.getCurrentUrl(), "facebook");

        driver.close();
        //  - Ana sayfaya geri dönün.
        driver.switchTo().window(homePageID);
    }

    @Test
    public void successfullyMessageTest (){
        // - "Information" başlığı altındaki "Contact Us" buttonuna tıklayınız.
        WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact us']"));
        contactUs.click();
//        - "Enquiry" yazan yerin altındaki text kutusuna mesajınızı yazıp "submit" butonuna tıklayınız.
        WebElement enquiry = driver.findElement(By.id("Enquiry"));
        enquiry.sendKeys("Burdan bir garip gecti diye yazarsiniz...");

        WebElement submitButoon = driver.findElement(By.name("send-email"));
        submitButoon.click();
//        - Sonrasında çıkan yazıyı dpğrulayınız.
        String actualSuccessMessage = driver.findElement(By.cssSelector("div.result")).getText();
        System.out.println(actualSuccessMessage);
        textValidation(actualSuccessMessage, "successfully");
    }

    public void textValidation(String actualText, String keyText){
        Assert.assertTrue(actualText.contains(keyText));
    }

}
