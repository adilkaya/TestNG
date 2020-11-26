package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void EqualOrnek()
    {
        String s1="mehmet";
        String s2="ahmet";

        Assert.assertEquals(s1,s2);
    }

    @Test
    void TrueOrnek()
    {
        int sayi1=5;
        int sayi2=7;

        Assert.assertTrue(sayi1==sayi2);
    }

    String s;

    @Test
    void nullOrnek()
    {
        //String s=null;

        Assert.assertNull(s);
    }
}
