package Gun10;

import Gun09._03_PlaceOrderElements;
import Utils.ParameterDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _03_WishListPOM extends ParameterDriver {

    @Test
    @Parameters("itemName")
    public void addToWishList(String itemName){

        Gun09._03_PlaceOrderElements pacePlaceOrderElements=new _03_PlaceOrderElements(driver);
        _02_WishListElements wishListElements=new _02_WishListElements(driver);

        pacePlaceOrderElements.searcInput.sendKeys(itemName);
        pacePlaceOrderElements.searcButton.click();

        int RundNumber= Tools.RandomNumberGenerator(wishListElements.pruductList.size());  // random bir numara oluşturduk

        String wishItemName=wishListElements.pruductList.get(RundNumber).getText(); // bu oluşan numaradaki ürünün adını aldık.
        wishListElements.searchResultWishList.get(RundNumber).click(); // çıkan bu listedekki WishListlerin aynı random numarakini tıklattım.
        wishListElements.wishListLink.click();
        Tools.ListContainsString(wishListElements.tableNames, wishItemName);
    }

    @Test
    public void Test1()
    {
        System.out.println("merhaba dünya");
        Assert.fail();
    }

}
