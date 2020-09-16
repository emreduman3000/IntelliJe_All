package com.techproed.tests;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void sagTiklama()
    {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        //Actions actions = new Actions(driver);//gerek yok testbaseden alıyorum
        // <span class="context-menu-one btn btn-neutral">right click me</span>
        // linkText : HAYIR (çünkü link değil - "a" tagName'i yok)
        // className: HAYIR (çünkü class değerinin içerisinde BOŞLUK var)
        // tagName, xpath, cssSelector
        // By.xpath("//*[.='right click me']") -> içerdiği yazı "right click me" olan webelement
        WebElement rightClickMe = driver.findElement(By.xpath("//*[.='right click me']"));
        action.contextClick(rightClickMe).perform();
    }

    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        //Actions action = new Actions(driver);
        //<button ondblclick="myFunction()">Double-Click Me To See Alert</button>
        WebElement doubleClick = driver.findElement(By.tagName("button"));
        action.doubleClick(doubleClick).perform();
    }

    @Test
    public void hoverOver(){ // mouse'u bir webelementin üzerine götürme
        driver.get("http://amazon.com");
        //Actions actions = new Actions(driver);
        // <a href="" class="nav-a nav-a-2" data-nav-ref="nav_ya_signin"
        // data-nav-role="signin" data-ux-jq-mouseenter="true"
        // id="nav-link-accountList" tabindex="0">
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(accountList).perform();


    }

    @Test
    public void keyActions() throws InterruptedException {
        driver.get("http://amazon.com");


//        action.sendKeys(Keys.END).perform();//sayfanın sonuna gider
//        Thread.sleep(3000);
//        action.sendKeys(Keys.UP).perform();//sayfanın basına gider
//        Thread.sleep(3000);


        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);

        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.ARROW_UP).perform();
        action.sendKeys(Keys.HOME).perform();



    }

    @Test
    public void keyUpKeyDown(){
        // MERHABA nasılsınız
        // shift'e basılı tutarak merhaba               -> MERHABA
        // shift'ten elimizi kaldıracağız nasılsınız    -> nasılsınız
        driver.get("http://google.com");
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        // aramaKutusu.sendKeys("merhaba nasılsınız");
        actions.moveToElement(aramaKutusu)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba ")
                .keyUp(Keys.SHIFT)
                .sendKeys("nasılsınız")
                .perform();
    }
    @Test
    public void ikiTusaAyniAndaTiklama(){
        driver.get("http://google.com");
        Actions actions = new Actions(driver);
        // ALT + F4 : sayfayı kapatması gerekiyor
        actions.keyDown(Keys.ALT)
                .keyDown(Keys.F4)
                .perform();
    }



}
/*
---------------------------ACTIONS CLASS------------------------------
***** Actions class kullanırken, işlemi bitirmek için her defasında 		  "PERFORM()" yazmak zorundayız.
contextClick : Sağ tıklama yapmak için kullanılır.
doubleClick  : İki kere (çift tıklama) yapabiliyoruz.
moveToElement: Mouse'u hedef webelement'in üzerine götürebiliyoruz.
keyDown      : Herhangi bir tuşa tıklamak için kullanılır.
keyUp        : Herhangi bir tuştan elimizi kaldırmak için kullanılır.
-------------------------SAYFADA AŞAĞI GİTME--------------------------
sendKeys(Keys.END)   : Sayfanın en aşağısına gidiyoruz.
sendKeys(Keys.PAGE_DOWN) : Belirli bir oranda sayfanın aşağısına gider.
sendKeys(Keys.ARROW_DOWN): Düşük bir oranda sayfanın aşağısına gider.
-------------------------SAYFADA YUKARI GİTME--------------------------
sendKeys(Keys.PAGE_UP) : Belirli bir oranda sayfanın yukarısına gider.
sendKeys(Keys.ARROW_UP): Düşük bir oranda sayfanın yukarısına gider.
 */
