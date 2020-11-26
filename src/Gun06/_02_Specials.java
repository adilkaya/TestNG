package Gun06;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _02_Specials extends MetodDriver {

    @Test
    public void specials()
    {
        WebElement contactLink=driver.findElement(By.linkText("Specials"));
        contactLink.click();

        List<WebElement> oldAmount = driver.findElements(By.xpath("//span[@class='price-old']"));
        List<WebElement> items=driver.findElements(By.cssSelector("div.product-thumb"));

        Assert.assertTrue(oldAmount.size() == items.size());
    }

}