package Gun03;

import Utils.MetodDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_EditAccount extends MetodDriver {
    /*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
     */


    @Test
    void EditAccount()
    {
        AccountEdit("ismet", "Yılmaz");
        AccountEdit("asd123", "asd");
    }


    void AccountEdit(String name, String surName)
    {
        WebElement editAccount = driver.findElement(By.linkText("Edit Account"));
        editAccount.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys(name);

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys(surName);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Tools.successMessageValidation(driver);
    }

}
