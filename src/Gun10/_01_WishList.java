package Gun10;
/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız.
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.

   2.Test;
   1- WishList i boşaltınız.
 */

import Gun06._03_SearchFunctionality;
import Gun06._04_SearchFunctionality;
import Utils.ParameterDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends ParameterDriver {

    @Test
    @Parameters("itemName")
    public void addToWishList(String itemName){

        // 1.Yöntem
        WebElement searchInput=driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.sendKeys(itemName);

        WebElement searchButton=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

//        //2.Yöntem   : Ödev : Çalıştıtılacak bu yöntem :
//        Gun06._04_SearchFunctionality searchTest=new _04_SearchFunctionality();
//        searchTest.SearchFunction(itemName);

        // Arama sonucu ekrana çıkan ürünlerin listesini aldık
        List<WebElement> pruductList=driver.findElements(By.cssSelector("div[class='caption']>h4"));
        int RundNumber= Tools.RandomNumberGenerator(pruductList.size());  // random bir numara oluşturduk
        String wishItemName=pruductList.get(RundNumber).getText(); // bu oluşan numaradaki ürünün adını aldık.

        List<WebElement> searchResultWishList=driver.findElements(By.cssSelector("button[data-original-title='Add to Wish List']"));
        searchResultWishList.get(RundNumber).click(); // çıkan bu listedekki WishListlerin aynı random numarakini tıklattım.
        // böylece wish liste attım.

        // WishList e tıklattım.
        WebElement wishListLink=driver.findElement(By.id("wishlist-total"));
        wishListLink.click();

        // Çıkan WishListi aldım.
        List<WebElement> tableNames=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//td[2]"));

        // bu listedeki ürünlerin isimleri ile daha önce eklediğim ürünün ismi var mı diye karşılaştırdım
        Tools.ListContainsString(tableNames, wishItemName);
    }





}






















