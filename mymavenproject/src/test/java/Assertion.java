import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertion {

    /*
    //@Before annotation'i tekrarlanan kosullar icin kullanilir
    //@Before driver'i kurmak,browser'i acmak, URL'e gitmek icin kullanilir
    //@Before ve @After kullanarak tekrari engellemis oluruz
    //@Before her @Test methodundan once calisir
    //Eger internetiniz,web sitesi veya browser yavassa testiniz basarisiz olabilir.
    // bunu onlemek icin @Before icine wait ekleyebilirsiniz.
     */


    WebDriver driver;
    @Before
    public void before() {System.out.println("JUnit testing thanks to Maven");}

    @Before
    public void driver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //Yavas web siteleri icin implicitly wait kullanilabilir.sayfa acılır ve bekler 10 saniye sonra kodlar calısır
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void close()
    {
        driver.close();
    }


    @Test
    public void titleTest()
    {
        //driver.close(); buraya yazarsam asagıdaki kodlar calısmaz error alırız
        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        Assert.assertEquals(expectedTitle,actualTitle);//maven sayesinde assertion kullanıyoruz
        //maven kullanmazsak jar file ları yüklememiz gerek
        /*
        if the test fails, on console,
        org.junit.ComparisonFailure:
        Expected :Googl
        Actual   :Google
         */



    }

    @Test
    public void imageTest()
    {
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        */


        WebElement googleImage=driver.findElement(By.id("hplogo"));
       // Assert.assertTrue(googleImage.isDisplayed());//true is pass olur
        Assert.assertFalse(!googleImage.isDisplayed());//false ise pass olur
    }

    @Test
    public void gmailLinkTest()
    {
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        */

        //<a class="gb_g" data-pid="23" href="https://mail.google.com/mail/?tab=wm&amp;ogbl" target="_top">Gmail</a>
        WebElement gmailLink=driver.findElement(By.linkText("Gmail"));
        Assert.assertTrue(gmailLink.isDisplayed());

    }
}
