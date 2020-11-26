package Gun08;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_Giris {
    /****************************************/

    @Test(dataProvider = "UserDataProvider") // senin dataproviderın getData isimli metoddur
    public void LoginTest(String username)
    {
        System.out.println(username);
    }

    /**
     * Data provider must return Object[][]/Object[] or Iterator<Object[]>/Iterator<Object>
     */
    @DataProvider(name = "UserDataProvider")
    public Iterator<Object> getData()
    {
        List<Object> data=new ArrayList<>();

        data.add("Ahmet");
        data.add("Ayse");
        data.add("Ali");
        data.add("Fatma");

        return data.iterator();
    }



    @Test(dataProvider = "getData2") // senin dataproviderın getData isimli metoddur
    public void LoginTest2(String username, String password)
    {
        System.out.println(username+" "+password);
    }

    /**
     * Data provider must return Object[][]/Object[] or Iterator<Object[]>/Iterator<Object>
     */
    @DataProvider
    public Iterator<Object []> getData2()
    {
        List<Object[]> data=new ArrayList<>();

        data.add(new Object[]{"Ahmet", "xyz"});
        data.add(new Object[]{"Ali", "abc"});
        data.add(new Object[]{"Ayse", "asd"});
        data.add(new Object[]{"Fatma", "tpk"});

        return data.iterator();
    }
}
