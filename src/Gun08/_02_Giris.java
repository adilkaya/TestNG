package Gun08;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_Giris {
    /****************************************/

    @Test(dataProvider = "UserDataProvider") // senin dataproviderın getData isimli metoddur
    public void LoginTest(String username, String password)
    {
        System.out.println(username+ " " +password);
    }


    /**
     * Data provider must return Object[][]/Object[] or Iterator<Object[]>/Iterator<Object>
     */
    @DataProvider(name = "UserDataProvider")
    public Object[][] getData3()
    {
        Object[][] data={
                {"ahmet","abc"},
                {"ayşe","xyz"},
                {"mehmet","bcd"}
        };

        return data;
    }
}
