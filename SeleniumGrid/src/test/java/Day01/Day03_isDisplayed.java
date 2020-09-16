package Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

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
    public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        //*[.="Dynamic Controls"]
        //h4
        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean visible = baslik.isDisplayed(); // true false
        System.out.println("Is it visible? : " + visible);
    }

    @Test
    public void isSelected(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement secimElementi = driver.findElement(By.xpath("//input[@type='checkbox']"));
        // eğer bir webelement seçili ise, TRUE değilse FALSE
        boolean seciliMi = secimElementi.isSelected();
        System.out.println("Seçili mi 1: " + seciliMi);
        secimElementi.click();
        boolean seciliMi2 = secimElementi.isSelected();
        System.out.println("Seçili mi 2: " + seciliMi2);
        if(secimElementi.isSelected()){// true false
            // eğer seçili ise burayı
        }else{
            // değilse burayı kullanırsınız.
        }
    }

    @Test
    public void isEnabled(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputKutusu = driver.findElement(By.xpath("//input[@type='text']"));
        boolean aktifMi = inputKutusu.isEnabled(); // true false
        System.out.println("Aktif Mi 1: " + aktifMi);
        WebElement enableButonu = driver.findElement(By.xpath("//*[.='Enable']"));
        enableButonu.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        boolean aktifMi2 = inputKutusu.isEnabled(); // true false
        System.out.println("Aktif Mi 2: " + aktifMi2);
    }


    // 1. DropDown'da Books kategorisini seçelim.
    // 2. Arama kutusuna JAVA yazalım.
    // 3. Toplam sonuç sayısını ekrana yazdıralım.
    // 4. İlk sıradaki ürüne tıklayalım.
    // 5. Back to results linki varsa, testimiz TRUE yoksa FALSE
    //      pass        fail
    @Test
    public void amazonDropdownTest(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("JAVA" + Keys.ENTER);
        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrun.click();
        WebElement backToResultLinki = driver.findElement(By.partialLinkText("Back to results"));
        boolean varMi = backToResultLinki.isDisplayed();
        Assert.assertTrue(varMi); // TRUE gelirse, TESTİM başarılı
    }

}

/*
Selenium Review 3. Ders
dropdown : açılır menü.
<select id="menu" type="drop">
	<option value="value1">Bilgisayarlar</option>
	<option value="value2">Telefonlar</option>
	<option value="value3">Tabletler</option>
</select>
hangi locatorlar ile bulabilirsiniz :
	id, xpath, cssSelector, tagName
örnek: By.id("menu")
***** 3 FARKLI SEÇİM YAPMA YÖNTEMİ
selectByVisibleText
selectByIndex
selectByValue
getOptions() : tüm seçenekler
getFirstSelectedOption() : seçili webelementi
-----------------------------------------------------------------
isDisplayed : bir webelement görünüyorsa TRUE, görünmüyorsa FALSE
isSelected  : bir webelement seçili ise  TRUE, değilse      FALSE
isEnabled   : bir webelement aktif ise   TRUE, değilse      FALSE
---------------------------ASSERTIONS----------------------------
Maven ile test yaptığınız projelerde, if-else ile doğrulama yaparak sadece kendinizi ve o projeyi izleyenleri bilgilendirirsiniz.
Fakat test çalıştırma ortalamınızı(mesela intellij) junit, testng, cucumber gibi kütüphanelerden gelen Assert işlemini uygulamanız gerekir. Aksi durumda, yani Assert işlemi yapmazsanız tüm testleriniz başarılı görünür.
				HARD ASSERT              		SOFT ASSERT
			Assert.assertTrue         SoftAssert nesnesi oluşturulur.
			Assert.assertFalse
			Assert.assertEquals
Assert.assertTrue : içerisinde yazdığınız koşul TRUE ise testiniz başarılı
Assert.assertFalse: içerisinde yazdığınız koşul FALSE ise testiniz başrılı.
Assert.assertEquals: yazdığınız iki değer birbirine eşitse testiniz bşrılı.
***** Eğer testiniz BAŞARIZSA Assert işleminden sonra testinizin kalan kısmı çalışmaz.
 */



