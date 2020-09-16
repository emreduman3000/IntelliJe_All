package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClassExample extends TestBase
{
    //Create  class: ActionsClassExample
    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
    //Dikdörtgen kutu icinde sağa tıklayın.
    //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
    //Alert’te OK ye basin

    @Test
    public void contextClickMethod()
    {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Actions action=new Actions(driver); // TestBase class'ına koy
        WebElement rectangle=driver.findElement(By.id("hot-spot"));
        action.contextClick(rectangle).perform();//right click:contextClick

        String alertMessage=driver.switchTo().alert().getText();//alert mesajı
        System.out.println("Alert Message:"+alertMessage);
        String expectedAlertMessage="You selected a context menu";
        Assert.assertEquals(alertMessage,expectedAlertMessage);

        driver.switchTo().alert().accept();//click OK on alert!

    }


    //Create  test method : hoverOver() ve aşağıdaki senaryoyu test edin:
    //https://www.amazon.com/  web sitesine gidin.
    //“Your Account” linkine tıklayın.
    //Sayfa basliginin(page title) “Your Account) icerdigini(contains) dogrulayin.
    @Test
    public void hoverOver(){
        //https://www.amazon.com/  web sitesine gidin.
        driver.get("https://www.amazon.com/");

        //“Your Account” linkine tıklayın.
        WebElement helloSignIn = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        action.moveToElement(helloSignIn).perform();

        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();

        //Sayfa basliginin(page title) “Your Account" icerdigini(contains) dogrulayin.

        String title=driver.getTitle();
        Assert.assertEquals(title,"Your Account");
    }

    //testCase
    //https://www.google.com/ adresine gidin.
    //Google text box’a IPHONE (capital) yazdirin
    //( input(giris) => iphone , output => IPHONE)
    //Text box’ta cift tiklayin(double click).
    @Test
    public void keysUpDown()
    {
        driver.get("https://www.google.com/");
        WebElement googleSearchBar=driver.findElement(By.name("q"));

        //there are 3 different way
        googleSearchBar.sendKeys("iphone".toUpperCase());
        googleSearchBar.clear();

        googleSearchBar.sendKeys(Keys.SHIFT+"iphone");
        googleSearchBar.clear();

        action.moveToElement(googleSearchBar).click().
                keyDown(Keys.SHIFT).sendKeys("iphone").perform();
        googleSearchBar.clear();

        action.keyDown(googleSearchBar, Keys.SHIFT).sendKeys("iphone").
                keyUp(googleSearchBar, Keys.SHIFT).perform();//keyUp elini tustan cek

        //Text box’ta cift tiklayin(double click).
        action.doubleClick(googleSearchBar).perform();

    }

    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.ARROW_DOWN).perform();//cokcok az iner
        Thread.sleep(3000);
        action.sendKeys(Keys.ARROW_UP).perform();//cokcok az cıkar
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
    }

}

