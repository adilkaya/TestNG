package Gun10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _02_WishListElements {

    public _02_WishListElements(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    // FindBy ın bulduğu elemanları (FindAll) hepsini al
    @FindAll(
            {
                    @FindBy(css = "div[class='caption']>h4")
//                    ,@FindBy(css = "div[class='caption']>h4")
                    // Eğer gerekir ise birden fazla locator ile bulunan tüm
                    // tüm elemanları tek bir listte bu şekilde
                    // birleştirilebilir.
            }
    )
    public List<WebElement> pruductList;


    @FindAll(
            {
                    @FindBy(css = "button[data-original-title='Add to Wish List']")
            }
    )
    public List<WebElement> searchResultWishList;

    @FindBy(id="wishlist-total")
    public WebElement wishListLink;

    @FindAll(
            {
                    @FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//td[2]")
            }
    )
    public List<WebElement> tableNames;
}
