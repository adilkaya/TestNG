package Gun06;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_ContactUs extends MetodDriver {

    @Test
    //@Parameters("enquiry")
    public void contactUs(){

        WebElement contact_us= driver.findElement(By.linkText("Contact Us"));
        contact_us.click();

        WebElement enquiryInput= driver.findElement(By.id("input-enquiry"));
        enquiryInput.sendKeys("Hello marketing we are comming");

        WebElement submit= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        submit.click();

        WebElement successMessage=driver.findElement(By.cssSelector("#content>p"));

        Assert.assertTrue(successMessage.getText().toLowerCase().contains("successfully"));




    }


}
