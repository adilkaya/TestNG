package Gun08;

import Utils.MetodDriver;
import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _04_Task1 extends MetodDriver {
    /**
     * Daha önceki derslerde yaptğımı Search fonksiyonunu
     * Mac ve Laptop için Dataprovider ile yapınız.
     * Fonksiyonu aynen kopyalabilirsiniz.
     */

    @Test (dataProvider = "getData")
    public void searchFunctionality(String searchItem){

        WebElement searchInput = driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.clear();
        searchInput.sendKeys(searchItem);

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> itemNamesList = driver.findElements(By.tagName("h4"));

        for(WebElement eachElement:itemNamesList){

            System.out.println(eachElement.getText());

            Assert.assertTrue(eachElement.getText().toLowerCase().contains(searchItem.toLowerCase()));
        }
    }

    @DataProvider
    public Object[] getData()
    {
        Object[] data={
                "Mac",
                "Samsung"
        };

        return data;
    }


}