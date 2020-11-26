package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Tools {

    public static void compareToList(List<WebElement> menuActualList, List<String> menuExpectedList)
    {
        int i=0;
        for(WebElement el: menuActualList)
        {
            Assert.assertEquals(el.getText(),menuExpectedList.get(i++) );

//            if (el.getText()!=menuExpectedList.get(i++))
//                System.out.println("Menu bulunamadı.");
        }
    }
    public static void successMessageValidation(WebDriver driver)
    {
        //İşlemin doğruğu çıkan mesajdan kontorl edildi.
        WebElement SuccessMessage = driver.findElement(By.cssSelector("div[class='alert alert-success']"));
        Assert.assertTrue(SuccessMessage.getText().contains("uccess"));
    }


    public static void selectByIndex(WebElement dropDownName){

        Select _select=new Select(dropDownName);

        _select.selectByIndex(RandomNumberGenerator(_select.getOptions().size()));
    }

    public static int RandomNumberGenerator(int max)
    {
        Random rnd= new Random();
        int RandomNumber= rnd.nextInt(max-1)+1;

        /*
          int randomNumber = rnd.nexInt(10); -> 0-1-2....9

          int randomNumber = rnd.nexInt(10-1)+1; ->

                0 ve 10-1 =9
                0-1-2-3...8
                1-2-3-4....9
         */

        return RandomNumber;
    }
    // List in içinde aranan kelime var mı ? yok ise(bulundu=false) hata oluştur
    public static void ListContainsString(List<WebElement> menuActualList, String expectedString)
    {
        boolean bulundu=false;
        for(WebElement el: menuActualList)
        {
            if (el.getText().contains(expectedString)) {
                bulundu = true;
                break;
            }
        }

        Assert.assertTrue( bulundu, "aranan eleman bulunamadı");
    }
}