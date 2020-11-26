package Gun03;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
  3- Newsletter  üyelik işlemini, üye ise , üyelikten çıkma, değilse ekleme şeklinde yapınız
 */

import Utils.MetodDriver;
import Utils.Tools;
import jdk.jfr.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Subscribe extends MetodDriver {

    /*
    Bu bölgede değişken tanımlayabilirsiniz.
    Ama kendi başına kod çalıştıramazsınız.
     */


    @Test (enabled=false)
    void subscribeFunctionYes()
    {
        //Üyelik linkine tıklandı
        WebElement SubscribeButton = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
        SubscribeButton.click();

        // Evet seçildi, seçili olsa da farketmez
        WebElement yesRadioButton = driver.findElement(By.xpath("//input[@value='1']"));
        yesRadioButton.click();

        //Continue (Tamam) butonuna basıldı.
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

    @Test (priority = 1)
    void subscribeFunctionNo()
    {
        //Üyelik linkine tıklandı
        WebElement SubscribeButton = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
        SubscribeButton.click();

        // Evet seçildi, seçili olsa da farketmez
        WebElement noRadioButton = driver.findElement(By.xpath("//input[@value='0']"));
        noRadioButton.click();

        //Continue (Tamam) butonuna basıldı.
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

    @Test (priority = 2)
    void subscribeFunctionForBoth() throws InterruptedException {
        //Üyelik linkine tıklandı
        WebElement SubscribeButton = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
        SubscribeButton.click();

        // seçili olanın teersini al
        WebElement noRadioButton = driver.findElement(By.xpath("//input[@value='0']"));
        WebElement yesRadioButton = driver.findElement(By.xpath("//input[@value='1']"));

        Thread.sleep(3000);
        if (noRadioButton.isSelected())
            yesRadioButton.click();
        else
            noRadioButton.click();

        //Continue (Tamam) butonuna basıldı.
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

}
