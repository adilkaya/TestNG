package Gun08;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_Giris {


        /**
         * Aşağıdaki ikli ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
         * data sayısı kadar test çalıştırılı, dataların olduğu yere DataProvider annottion ı konur.
         * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
         */

        @Test (dataProvider = "getData") // senin dataproviderın getData isimli metoddur
        public void UsernameTest(String username)
        {
            System.out.println(username);
        }


        /**
         * Data provider must return Object[][]/Object[] or Iterator<Object[]>/Iterator<Object>
         */
        @DataProvider // bu metoda dataprovider görevi verildi.
        public Object[] getData() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
        {
            Object[] data={
                    "ahmet",
                    "ayşe",
                    "mehmet",
                    "fatma"
            };

            return data;
        }


    }

