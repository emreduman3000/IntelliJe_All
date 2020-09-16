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

public class BeforeAfterMethods
{
    // Bir class oluşturun: BeforeAfterMethods
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
    // imageTest => Google logosunun görüntülenip görüntülenmediğini doğrulayın
    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini doğrulayın
    // Her testten sonra tarayıcıyı kapatin

    WebDriver driver;

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
        if(driver.getTitle().equals("Google"))
            System.out.println("PASS -The title is right!");
        else
            System.out.println("FAIL -The title is wrong!");


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
        if(googleImage.isDisplayed())
            System.out.println("PASS - displayed");
        else
            System.out.println("FAIL");
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
        if(gmailLink.isDisplayed())
            System.out.println("PASS - displayed");
        else
            System.out.println("FAIL");

    }
}
