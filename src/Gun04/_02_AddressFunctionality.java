package Gun04;

import Utils.MetodDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends MetodDriver {

     /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.

     */


    @Test
    void AddAdress() throws InterruptedException {

        // Address Book -> linkText
        // New Address
//        input-firstname
//        input-lastname
//        input-company
//        input-address-1
//        input-address-2
//        input-city
//        input-postcode
//        input-country  select
//        input-zone
//
//input[value='Continue']


        WebElement AddressBookButton= driver.findElement(By.linkText("Address Book"));
        AddressBookButton.click();

        WebElement NewAddressButton= driver.findElement(By.linkText("New Address"));
        NewAddressButton.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.sendKeys("Adil");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("ky");

        WebElement company = driver.findElement(By.id("input-company"));
        company.sendKeys("technoStudy");

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("Usa");

        WebElement address2 = driver.findElement(By.id("input-address-2"));
        address2.sendKeys("Turkey");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Newyork");

        WebElement postcode = driver.findElement(By.id("input-postcode"));
        postcode.sendKeys("100060");

        WebElement selectCountry = driver.findElement(By.id("input-country"));

        Tools.selectByIndex(selectCountry);

        WebDriverWait bekle=new WebDriverWait(driver,10);

        By stateOptions = By.xpath("//select[@id='input-zone']/option");
        bekle.until(ExpectedConditions.numberOfElementsToBeMoreThan(stateOptions,1));


        Thread.sleep(1000);

        WebElement selectRegion = driver.findElement(By.id("input-zone"));
        Tools.selectByIndex(selectRegion);

        WebElement continuebtn= driver.findElement(By.xpath("//input[@value='Continue']"));
        continuebtn.click();

        Tools.successMessageValidation(driver);

    }
    @Test (dependsOnMethods  ={"AddAdress"})
    void EditAdress(){

        WebElement AddressBookButton= driver.findElement(By.linkText("Address Book"));
        AddressBookButton.click();

        // butun edit butunlari alinda
        List<WebElement> editBtn=driver.findElements(By.xpath("//a[text()='Edit']"));
        editBtn.get(editBtn.size()-1).click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.clear();
        firstname.sendKeys("akif");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("ersoy");

        WebElement continuebtn= driver.findElement(By.xpath("//input[@value='Continue']"));
        continuebtn.click();

        Tools.successMessageValidation(driver);

    }


    @Test (dependsOnMethods  ={"EditAdress"})
    void DeleteAdress(){

        WebElement AddressBookButton= driver.findElement(By.linkText("Address Book"));
        AddressBookButton.click();

        // butun delete butunlari alinda
        List<WebElement> deleteBtn=driver.findElements(By.xpath("//a[text()='Delete']"));
        deleteBtn.get(deleteBtn.size()-1).click();

        Tools.successMessageValidation(driver);
    }
}