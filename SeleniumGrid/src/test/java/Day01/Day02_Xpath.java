package Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1()
    {
        driver.get("http://a.testaddressbook.com/");
        //<a id="sign-in" class="nav-item nav-link" data-test="sign-in"
        // href="/sign_in">Sign in</a>
        // id               EVET, className        HAYIR, tagName          EVET, name             HAYIR, xpath            EVET, cssSelector      EVET, linkText         EVET, partialLinkText  EVET
        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        //  ipucu : findElements kullanabilirsiniz.
        //  ipucu : tagName'i a olan webelementler linktir.
        //  ipucu : bir sayfadaki tüm webelementleri bulmak istiyorsanız, findElements
        //          kullanabilirsiniz.
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {

        }

        List<WebElement> tumLinkler = driver.findElements(By.tagName("a"));
        //By.xpath("//a")
        for(WebElement w : tumLinkler){
            System.out.println(w.getText());
        }



        WebElement userName = driver.findElement(By.cssSelector("#session_email"));
        userName.sendKeys("testtechproed@gmail.com");
        WebElement Password = driver.findElement(By.cssSelector("#session_password"));
        Password.sendKeys("Test1234!");
        WebElement SignIn = driver.findElement(By.cssSelector(".btn.btn-primary"));
        SignIn.click();


        List<WebElement> allWebElements = driver.findElements(By.xpath("//*"));
        //html head body içindeki yazıları da bulur

        //for(WebElement i : allWebElements2){
        //            System.out.println(i.getText());
        //        }

        List<WebElement> allTextsInBody = driver.findElements(By.tagName("body"));
        allTextsInBody.
                stream().
                distinct().
                forEach(t-> System.out.println(t.getText()));

    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}

/*
Selenium Review 2. Ders
09/01/2020 - Salı
id, tagName, name, className, linkText, partialLinkText, xpath, cssSelector
Xpath
absoulete xpath(bu kullanılmaz) ve relative xpath
örnk webelement : <input class="deneme" id="deger" />
1. //input[@class='deneme'];
   //input[@id='deger']
   //input
2. //*[@class='deneme'] : tagName'i farketmeksizin,(attribute : class, value : deneme) tüm webelementleri bul demek.
<a href="http://google.com">Google Linki</a>
3. //*[.='Google Linki']
<div>Merhaba ben webelement</div>
//*[.='Merhaba ben webelement']
//div[.='Merhaba ben webelement']
4. //*[(text() = 'Google Linki')]
5. //*[contains(text(),'Linki')]
   //div[contains(text(),'Linki')]
1. <div class="deneme" id="deger" placeholder="merhaba" />
2. <div class="tabindex" id="deger" placeholder="selamlar" />
or  : ya da
and : ve
6. //div[@class='deneme' or @id='deger']
   //div[@class='deneme' and @id='deger']
örnek : class="deneme" attributene sahip webelementleri bulun ?
//div[@class='deneme'] -> 1
örnek : id="deger" attributene sahip webelementleri bulun ?
//div[@id='deger'] -> 1 ve 2
örnek : id="deger" ya da class="deneme" attributlerine göre arama yapınz
//div[@id='deger' or @class='deneme'] -> 1 ve 2
örnek : id="deger" ve class="deneme" attirbutelerine sahip webelementi blnz
//div[@id='deger' and @class='deneme']  ->
7. //div[@id='deger'] -> 1 ve 2
   (//div[@id='deger'])[2] -> 2. sıradaki webelemente götürür.
   (//div[@id='deger'])[1] -> 1. sıradaki webelemente götürür.
***** ÖZELLİKLE BİLİNMESİ GEREKENLER.
1. //tagName[@attribute='value']
2. //*[@attribute='value']
3. //*[.='Yazıya göre arama']
4. (//tagName[@attribute='value'])[2]
CSS SELECTOR
***** XPATH ile CSSSELECTOR FARKI
En Önemli Fark : İNDEX KULLANARAK BULDUĞUMUZ WEBELEMENTLER ARASINDA GEZİNEMİYORUZ !
<input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]" id="session_email">
Bu webelement kaç farklı şekilde bulunabilir ? :
By.id        		-> Bulunabilir.. -  By.id("session_email")
By.name      		-> Bulunabilir.. -  By.name("session[email]")
By.className		-> Bulunabilir.. -  By.className("form-control")
By.tagName   		-> Bulunabilir.. -  By.tagName("input")
By.linkText  		-> BulunaMAZ.... -  <a tagname'i yok.
By.partialLinkText  -> BulunaMAZ.... -  <a tagname'i yok.
By.xpath            -> Bulunabilir.. -  By.xpath("//input[@type='email']")
By.cssSelector      -> Bulunabilir.. -  By.cssSelector("#session_email")
tagName   : input
attribute : type, class, placeholder, data-test, name, id
tagName[attribute='value']
***** cssSelector'u biz daha çok CLASS ve ID attributelerine göre arama yapmak için kullanıyor.
// CLASS  ->  .form-control
// ID     ->  #session_email
<div class="merhaba selamlar" />
##### YANLIŞ KULLANIM : By.className("merhaba selamlar")
##### DOĞRU KULLANIM  : By.cssSelector(".merhaba.selamlar")
------------------  JUNIT ANNOTATIONS  -----------------------
@Test         : Test methodu olduğunu belirtmek için..
@BeforeClass  : Sadece 1 KERE
			    Her class'tan önce sadece 1 kere.
			    Test işlemine başlamadan önce yapmak istediklerimizi bu methodun içerisinde yapabiliriz.
			    örnek : driver nesnesi oluşturabiliriz.
@AfterClass   : Sadece 1 KERE
				Her class'tan sonra sadece 1 kere.
				Test işlemi bittikten sonra yapmak istediklerimizi bu methodun içerisinde yapabiliriz.
				örnek : driver.quit(), rapor alma
@Before       : Test sayısınca çalışır.
				Her testten önce çalışır.
				Örneğin : 10 tane testiniz varsa, bu methotta 10 kere çalışır.
@After        : Test sayısınca çalışır.
				Her testten sonra çalışır.
				Örneğin : 10 tane testiniz varsa, bu methotta 10 kere çalışır.
@Ignore       : Kullanıldığı testin görmezden gelinmesini sağlar.
				Testi atlamak için kullanılır.
JUnit 4.13 ile birlikte BeforeClass ve AfterClass methodları STATIC olmak zorunda.
yarının konuları: dropdown isDisplayed isSelected isEnabled
 */
