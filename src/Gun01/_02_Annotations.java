package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {
/*
      @BeforeClass      -> Her Classdan önce çalışacaklar buraya yazılıyor.
         @BeforeMethod  -> Her metod çalışmadan önce yapılacakları buraya yazıyoruz
                  @Test  -> testimiz
                  @Test
         @AfterMethod   -> Her metod çalıştıktan sonra yapılacakları buraya yazıyoruz.
      @AfterClass       -> Her class dan sonra yapıalcaklar buraya yazılıyor.
 */
    @BeforeClass
    void beforeClass()
    {
        System.out.println("Classdan önce çalışacak : before class");
    }

    @AfterClass
    void aftereClass()
    {
        System.out.println("Classdan sonra çalışacak : aftere class");
    }


    @BeforeMethod
    void beforeMetod()
    {
        System.out.println("Her metoddan önce çalışacak : Before Metod");
    }

    @AfterMethod
    void afterMetod()
    {
        System.out.println("Her metoddan sonra çalışacak : After Metod");
    }

    @Test
    void tes1()
    {
        System.out.println("Burası Test 1");
    }

    @Test
    void tes2()
    {
        System.out.println("Burası Test 2");
    }
}
