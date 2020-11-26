package Gun06;

import Utils.MetodDriver;
import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _04_SearchFunctionality extends ParameterDriver {

    /*
        Senaryo ;
        1- Siteyi açınız.
        2- mac kelimeini göndererek aratınız.
        3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      */
    @Test
    @Parameters("arananKelime")
    public void SearchFunction(String searchText)
    {
        WebElement searchInput=driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.sendKeys(searchText);

        WebElement searchButton=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> itemNameList = driver.findElements(By.cssSelector("h4>a"));

        for(WebElement itemName : itemNameList)
        {
            System.out.println(itemName.getText());
            Assert.assertTrue(itemName.getText().toLowerCase().contains(searchText));
        }
    }
}
