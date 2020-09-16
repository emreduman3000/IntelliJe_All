package Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class Day01_DriverKomutlari {
    @Test
    public void test1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driverı tam ekran yaptık.
        driver.manage().window().maximize();
        // webelementlerin yüklenmesini 10 saniyeye kadar bekleyebilirsin.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com");
        // herhangi bir websayfasına gider.
        driver.navigate().to("http://amazon.com");
        // bir önceki sayfaya geri döner.
        driver.navigate().back();
        // ileri gider.
        driver.navigate().forward();
        // sayfayı yeniler.
        driver.navigate().refresh();
        // driver'ı kapatmak için kullanılır
        driver.quit();
        // açık olan sekmeyi kapatmak için kullanılır.
        driver.close();
    }
}

/*review day01 notes

Selenium Review 1. Ders
08/31/2020 - Pazartesi
pom.xml -> her maven projesinde yer alan, projemizi yönettiğimiz bir dosyadır.
JUnit ile test işlemi yapabilmek için 3 tane kütüphaneye ihtiyacımız var.
1. webdrivermanager : driver kullanabilmek için ihtiyacımız var.
2. selenium-java    : selenium kütüphanesini kullanabilmek için.
3. JUnit            : test işlemi yapabilmek için.
WebDriverManager.chromedriver().setup(); -> ChromeDriver'ı kullanılabilir hale getirdik.
WebDriver driver = new ChromeDriver(); -> Driver nesnesi oluşturduk.
driver.manage().window().maximize() -> Driver'ı tam ekran yaptık.
driver.manage().timeouts().implicitlyWait -> Bekleme komutu verdik.
driver.get() -> Bununla istediğimiz sayfaya gidebiliriz.
driver.navigate().to("http://amazon.com"); -> herhangi bir websayfasına gider.
driver.navigate().back(); -> bir önceki sayfaya geri döner.
driver.navigate().forward(); -> ileri gider.
driver.navigate().refresh(); -> sayfayı yeniler.
driver.quit(); -> driver'ı kapatmak için kullanılır
driver.close(); -> açık olan sekmeyi kapatmak için kullanılır.
<a href="/international-sales-offers/" class="nav-a  " tabindex="47">Today's Deals</a>
tagname   : a
attribute : href, class, tabindex
value     : /international-sales-offers/, nav-a  , 47
text      : Today's Deals
locator : konum bulucu.
id, name, tagName, className, linkText, partialLinkText, xpath, cssSelector
NoSuchElementException : Aradığınız özelliklerde bir webelement bulamadığınız zaman bu hatayı alırsınız.
sendKeys() -> Bir webelemente yazı gönderebiliyoruz.
getText()  -> Bir webelementin içerdiği yazıyı almak için kullanılır.
click()    -> WebElement'e tıklayabiliyoruz.
submit()   -> Yazılan yazıyı gönderme(bir nevi enter) görevi görür.
	*****  aramaKutusu.sendKeys("Merhabalar");
		   aramaKutusu.submit();
Keys.ENTER -> Enter butonuna tıklamak için.
	*****  aramaKutusu.sendKeys("Merhabalar" + Keys.ENTER);
xpath : //tagName[@attribute='value']
xpath : (//tagName[@class="a-link-normal a-text-normal"])[1]
		***** index 1'den başlıyor.
		By.xpath("//tagName[@class='merhaba']")
Yarının Konuları : xpath, cssSelector, @BeforeClass, @AfterClass, @Before, @After, @Ignore
 */
