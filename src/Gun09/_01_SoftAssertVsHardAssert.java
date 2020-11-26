package Gun09;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {


    @Test
    public void hardAssert()
    {
        String s1="Merhaba";
        System.out.println("Hard assert oncesi.");
        Assert.assertEquals("Merhaba123",s1);
        System.out.println("Kod Bitti.");
    }

    @Test
    public void softAssert()
    {
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert softAssertion= new SoftAssert();

        softAssertion.assertEquals("www.facebook.com/homepage",strHomePage);
        System.out.println("assert1");

        softAssertion.assertEquals("www.facebook.com/profile",strCartPage);
        System.out.println("assert2");

        softAssertion.assertEquals("www.facebook.com/settings",strEditAccount);
        System.out.println("assert3");

        softAssertion.assertAll();
        System.out.println("kod bitisi");
    }
    }











