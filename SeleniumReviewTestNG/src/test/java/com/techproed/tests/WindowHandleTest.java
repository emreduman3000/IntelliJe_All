package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {

    /*
        Selenium Review 5. Ders
        Window Handle : Her bir sekmenin kendine ait benzersiz bir kodu vardır, biz bu koda window handle diyoruz.
        Örnek :
            Google  -> CDwindow9DD98SAD8ASD8ASDUSAD8S89AD9ASD
            Youtube -> CDwindowd6a8hg8g87fg8gf87f8hgf77f8hf7s
        ***** Sekmeler arasında geçiş yaparken INDEX KULLANILAMAZ !!!!!
        getWindowHandle() => Bulunduğunuz sayfanın, window handle'ını STRING olarak return eder.
        getWindowHandles() => Açık olan tüm pencerelerin window handle'ları Set<String> şeklinde return edilir.
        driver.switchTo().window(gitmek istediğimiz sayfanın window handle'ı);
     */

    @Test
    public void test()
    {

        /*
            1. Adım : the-internet.herokuapp.com/windows bu sayfaya gittiğimizde,
                      sayfanın WindowHandle'ını alalım.
            2. Adım : Click Here linkine tıklayalım.
            3. Adım : Gittiğimiz sayfadan, the-internet.herokuapp.com/windows sayfasına
                      window handle'ını kullanarak geçiş yapalım.
        */


        driver.get("https://the-internet.herokuapp.com/windows");
        String anaSayfaWindowHandle = driver.getWindowHandle();
        System.out.println("anaSayfaWindowHandle: "+anaSayfaWindowHandle);

        //<a href="/windows/new" ,="" target="_blank">Click Here</a>
        // tagName , xpath, cssSelector , linkText, partialLinkText

        /*WebElement clickHereLinki = driver.findElement(By.partialLinkText("Click Here"));
        clickHereLinki.click();*/

        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //driver hala homepage'de islem yapar
        System.out.println(driver.getTitle());//homaPage's title
        System.out.println(driver.findElement(By.tagName("h3")).getText());//Opening a new window


        System.out.println("anaSayfaWindowHandle: "+anaSayfaWindowHandle);

        //UI 2.PAGE, BURADA 2.PAGE'in driver'ını alabiliriz ya da hompe IU'ındayken de alırız
        String ikinciSayfaWindowHandle="";

        // Açık olan tüm pencerelerin window handle'larını almak
        Set<String> tumWindowHandlelar = driver.getWindowHandles();
        for (String handle : tumWindowHandlelar)
        {
            if(!handle.equals(anaSayfaWindowHandle)){
                ikinciSayfaWindowHandle = handle;
            }
            System.out.println(handle);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // windowhandle kullanarak istediğimiz pencereye şu şekilde geçiş yapabiliyoruz
        driver.switchTo().window(anaSayfaWindowHandle);
        System.out.println("anaSayfaWindowHandle: "+anaSayfaWindowHandle);

        //driver.navigate().back();// bu aynı sekmede geri gitmek için kullanılır
        //hem driver'ı değiştirmek
        // hem de sayfadan sayfaya girmek için kullanılır
        //burada zaten driver'ımız hımepage'in
        //oyuzden sadece geri gönmek için kullandık



        driver.switchTo().window(ikinciSayfaWindowHandle);

        System.out.println(driver.getTitle());//homaPage's title
        System.out.println(driver.findElement(By.tagName("h3")).getText());//Opening a new window

        ///////////////// Set<String> i Array'e çevirme /////////////////
        Object[] windowHandleDegerleri = tumWindowHandlelar.toArray();
        System.out.println(windowHandleDegerleri[0].toString());
        System.out.println(windowHandleDegerleri[1].toString());
    }

}
