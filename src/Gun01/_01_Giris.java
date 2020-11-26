package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {
    // Eğer test metodlarına sıralama verilmezse alfabetik sırasına göre çalışır.

    @Test(priority = 1)                         // @Test -> annotation
    void vebSitesiAc() {
        System.out.println("Driver tanımlandı, ve web sitesi açıldı...");
    }

    @Test(priority = 2)  // priority : öncelik sırası
    void loginTest()
    {
        System.out.println("Login test işlemleri yapıldı");
    }

    @Test(priority = 3)
    void dirverKapat()
    {
        System.out.println("Driver kapatıldı ve çıkıldı.");
    }
}
