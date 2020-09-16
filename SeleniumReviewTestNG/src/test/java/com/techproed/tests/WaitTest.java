package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest extends TestBase
{
    @Test
    public void implicitlyWaitTest(){
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // implicitly wait : Sayfadaki findElement işlemi gerçekleşirken,
        //                   belirlediğimiz maksimum süreye kadar bekliyor.
        //                   Öncesinde bulursa, bekleme işlemini bırakıp devam ediyor.
        //                   Örnek : Eğer 2. saniyede aranılan webelementi bulursa,
        //                           8 saniye daha BEKLEMİYOR. Direk alt satıra geçiyor.
        driver.get("http://google.com");
        //WebElement hamzaYilmazLink = driver.findElement(By.id("hamza_yilmaz"));
        WebElement aramaKutusu = driver.findElement(By.name("q"));
    }
    @Test
    public void explicitWaitTest(){
        // WebDriverWait class'ından nesne üretmek zorundayız !
        // implicitlyWait'ten en önemli farkı, burada herhangi bir webelement için
        // özel bir bekleme işlemi gerçekleştiriyoruz.
        // Explicit Wait içinde en önemli fark, burada bir koşul belirtiyoruz.
        // Örnek : Aradığımız WebElement tıklayabiliyor olsun.
        // Örnek : Aradığımız webelement'in yazısı "deneme" olsun.
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        //<button autocomplete="off" type="button" onclick="swapCheckbox()">Remove</button>
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();
        // <p id="message">It's gone!</p>
        // Eğer explicit wait kullanmak istiyorsak, WebDriverWait'ten nesne üretmek zorundayız.
        WebDriverWait wait = new WebDriverWait(driver  ,  30);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());
    }
}

/*
Selenium Review 6. Ders
System.getProperty("user.dir") : Bulunduğunuz klasörün dosya yolunu alırsınız.
System.getProperty("user.home"): Bulunduğunuz kullanıcının ana klasörünün dosya yolunu alabiliyorsunuz.
Files.exists(Paths.get("dosyaAdresi")) -> Yazılan adreste, o dosyanın var olup olmadığını kontrol ediyor. (TRUE ya da FALSE)
Websitesine bilgisayarınızdan bir dosya upload etmek isterseniz, "Choose File" ya da "Gözat" şeklindeki webelementi locate edip, ona sendKeys ile dosya yolunu göndermeniz gerekir.
ÖRNEK : chooseFile.sendKeys("C:\\Users\\isimsiz\\upload\\logo.png");
Dosya İndirme : Websitesinden dosyayı indirdikten sonra, bir müddet bekleyip(dosyanın yüklenmesi zaman alabilir) bilgisayarımızda o dosyanın var olup olmadığını doğrulayabiliriz.
Implicitly Wait : Bu komut driver'a verilir ve BÜTÜN WEBELEMENTLERİ kapsar. Aradığımız özellikte bir webelementin maksimum bulunma süresini belirleriz. Ve o webelement belirlediğimiz süre boyunca aranır. Eğer o süre içerisinde bulunamazsa, FAİL olur. Fakat, eğer bulunursa, kalan süre beklenmez ve direk test devam eder.
	Örnek : driver.manage().timeOuts().implicitlyWait(40, TimeUnit.SECONDS);
	eğer 5. saniyede bir webelement bulunursa, kalan 35 saniye beklenmez.
	eğer 40 saniye boyunca bulunamazsa, 41. saniyede HATA verir.
Explicit Wait : Bu bekleme türü ile herhangi bir webelement beklenen koşul sağlanıncaya dek bekleniyor. Eğer koşul, maksimum süre içerisinde gerçekleşmezse, webelement arama işlemi FAİL oluyor. Eğer aranılan özelliklerde ve beklenen şartları sağlayan bir webelement bulunursa, kalan süre beklenmeden, test işlemine devam ediliyor.
Explicit Wait kullanmak için, WebDriverWait class'ından nesne üretmek zorundayız. Ürettiğimiz bu nesneyi kullanarak, bekleme işlemi gerçekleştirebiliriz.
	Örnek : WebDriverWait wait = new WebDriverWait(driver  ,  120);
        	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
    Eğer 120 saniye boyunca, bu webelement bulunamazsa, 121. saniyede hata alırız. Fakat 5. saniyede bu webelement bulunursa, kalan 115 saniye es geçilir ve beklemek zorunda kalmayız.
 */