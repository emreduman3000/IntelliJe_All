package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BestBUY {
    /*
     Bir class oluşturun: Tekrar_BeforeAfter_BestBuy
    Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun      https://www.bestbuy.com/
    titleTest => Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
    logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    Her testten sonra tarayıcıyı kapatin
     */

    WebDriver driver;

    @Before
    public void driver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");

        //Yavas web siteleri icin implicitly wait kullanilabilir.sayfa acılır ve bekler 10 saniye sonra kodlar calısır
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest()
    {
        String actualTitle=driver.getTitle();
        String expectedTitle="Best";
        if(actualTitle.contains(expectedTitle))
            System.out.println("PASS -The title contains 'Best'");
        else
            System.out.println("FAIL -The title does not contain 'Best'");
    }

    @Test
    public  void logoTest()
    {
        WebElement bestBuyLogo=driver.findElement(By.xpath("//img" +
                "[@alt='Best Buy Logo']"));
        if(bestBuyLogo.isDisplayed())
            System.out.println("PASS - displayed");
        else
            System.out.println("FAIL");
    }
    @Test
    public void mexicoLinkTest()
    {
        WebElement mexicoLink=driver.findElement(By.partialLinkText("Mexico"));
        if(mexicoLink.isDisplayed())
            System.out.println("PASS - displayed");
        else
            System.out.println("FAIL");
    }

    @After
    public void tearDown()
    {
        driver.close();
    }
}
