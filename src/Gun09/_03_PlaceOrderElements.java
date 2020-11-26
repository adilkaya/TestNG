package Gun09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

public class _03_PlaceOrderElements {

    public _03_PlaceOrderElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[name='search']")
    public WebElement searcInput;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    public WebElement searcButton;

    @FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
    public WebElement itemNameList1;

    @FindBy(css = "a[title='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(linkText = "Checkout")
    public WebElement checkOut;

    @FindBy(id = "button-payment-address")
    public WebElement continu1;

    @FindBy(id = "button-shipping-address")
    public WebElement continu2;

    @FindBy(id = "collapse-shipping-address")
    public WebElement continu3;

    @FindBy(id = "button-shipping-method")
    public WebElement continu4;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(id = "button-payment-method")
    public WebElement continu5;

    @FindBy(id = "button-confirm")
    public WebElement confirmButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    public WebElement mesaj;

















}
