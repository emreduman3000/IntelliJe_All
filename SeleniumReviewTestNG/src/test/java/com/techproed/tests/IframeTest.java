package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    // https://the-internet.herokuapp.com/iframe
    // 1. Adım : Sayfadaki iframe'i bulacağız.
    // 2. Adım : O iframe'in içerisindeki "p" tag name'ine sahip webelementi bulacağız.
    // 3. Adım : İçerisine "Selamlar IFRAME" yazdıracağız.
    // 4. Adım : Iframe'den çıkış yapıp, sayfamıza döneceğiz (defaultContent)
    // 5. Adım : "Elemental Selenium" linkini bulup, tıklayacağız.
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
      /*
         <iframe id="mce_0_ifr" src="javascript:&quot;&quot;" allowtransparency="true"
         title="Rich Text Area. Press ALT-F9 for menu. Press ALT-F10 for toolbar. Press ALT-0 for help" style="width: 100%; height: 100px; display: block;"
         frameborder="0"></iframe>
      */
        // 1. index ile
        // driver.switchTo().frame(0);
        // 2. id attribute değeri ile
        // driver.switchTo().frame("mce_0_ifr");
        // 3. webelement ile
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement yaziBolumu = driver.findElement(By.tagName("p"));
        yaziBolumu.clear();
        yaziBolumu.sendKeys("Selamlar IFRAME");
        driver.switchTo().defaultContent();
        //<a target="_blank" href="http://elementalselenium.com/">Elemental Selenium</a>
        // tagName, linkText, partialLinkText, xpath, cssSelector
        WebElement link = driver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();
    }



}

/*

    Selenium Review 4. Ders
Unit Testing      -> JUnit
Automation Tester -> TestNG, Cucumber
JUnit için ihtiyaç duyduğumuz kütüphaneler
webdrivermanager, selenium-java, junit
TestNG için ihtiyaç duyduğumuz kütüphaneler
webdrivermanager, selenium-java, testng
-------------------------------------------
* TestNG'de birden fazla test oluşturursanız, alfabetik olarak sıralama yapılır ve o sıralamaya uygun şekilde çalıştırılır.
- public void amazonTest()      1
- public void googleTest()      4
- public void facebookTest()    3
- public void appleTest()       2
priority : testlerimize öncelik vermek için kullanırız.
		   örnek kullanım : @Test (priority = 10)
dependsOnMethods : testleri birbirine bağlamak istediğimizde kullanırız.
		   örnek kullanım : @Test (dependsOnMethods = "login")
@Test -> loginTesti()					1
@Test -> kullaniciBilgileriTesti()		2 (dependsOnMethods ="loginTesti")
@Test -> krediKartiBilgileriTesti()		3 (dependsOnMethods ="loginTesti")
@Test -> sifreTesti()					4 (dependsOnMethods ="loginTesti")
@Test -> adresBilgileriTesti()			5 (dependsOnMethods ="loginTesti")
----------------------JS ALERT--------------------------
* Web sayfalarında genelde 2 tip uyarı bulunur.
	1. Java Script Alert (JSAlert) -> Uyarı
		* JavaScript ile hazırlanırsa, kullanıcı bu uyarıyı kapatmadan
		sayfada herhangi bir işlem yapamıyor.
		* Sağ tıklayıp -> öğeyi incele(inspect) YAPILAMAZ
	2. HTML ile hazırlanmış Alert  -> Uyarı
		* HTML ile hazırlanırsa, kullanıcı bu uyarıyı KAPATMASA bile
		sayfada işlem yapabiliyor.
		* Sağ tıklayıp -> öğeyi incele(inspect) YAPILABİLİR
***** JSAlert ile ilgili SADECE 4 tane methodumuz var.
driver.switchTo().alert().getText() -> Alert'in içerisindeki mesajı alır.
driver.switchTo().alert().sendKeys()-> Alert'in içerisinde yazı gönderir.
driver.switchTo().alert().accept()  -> TAMAM butonuna tıklar.(kabul et)
driver.switchTo().alert().dismiss() -> VAZGEÇ butonuna tıklar.(reddet)
<button onclick="jsPrompt()">Click for JS Prompt</button>
Kaç farklı locator ile bulabiliriz :
	id 				  HAYIR
	name  			  HAYIR
	className         HAYIR
	tagName           EVET   - tüm webelementler tagName ile bulunur.
	linkText          HAYIR
	partialLinkText   HAYIR
	xpath			  EVET	 //button[@onclick='jsPrompt()']
	cssSelector		  EVET
--------------------------IFrame----------------------------
* Bir websayfasının içerisinde, farklı bir websayfasının eklenmesi durumunda iframe kullanılır.
* Eklenmiş olan sayfaya geçiş yapmak zorundayız. Yani iframe'e geçiş yapmak zorundayız.
SENARYO - JournalsGlobal.com'un içerisindeki, iframe ile eklenmiş olan wikipedia.org sayfasındaki <div id="logo" /> webelementini locate edelim.
	journalsglobal.com
		<a href="/register.php">Register</a>
		wikipedia.org
			<div id="logo" />
->driver.findElement(By.id("logo"))   BU HATALI KULLANIM OLUR, ÇÜNKÜ IFRAME'E GEÇİŞ YAPMAK ZORUNDAYIZ !
1. ADIM
	iframe'e geçiş yapmamız gerekir.
2. ADIM
	driver.findElement(By.id("logo"))
3. ADIM
	driver.switchTo().defaultContent()
4. ADIM
	driver.findElement(By.linkText("Register"))
***** Iframe'in içerisindeki herhangi bir webelemente ulaşmak için,Iframe'e geçiş yapmak ZORUNDASINIZ.
***** Iframe'in içerisinde, işlem yaptıktan sonra tekrar Iframe'den çıkış yapmak ZORUNDASINIZ.
***** Iframe'e geçiş yapmak için 3 TANE yöntemimiz var.
	1. index ile            -> driver.switchTo().frame(0)
	2. id ya da name ile    -> driver.switchTo().frame("mce_0_ifr")
	3. webelement ile       -> driver.switchTo().frame(webelement)
***** Iframe'den çıkış yapmak için 2 TANE yöntemimiz var.
	1. driver.switchTo().defaultContent()
	2. driver.switchTo().parentFrame()     * İÇ İÇE IFRAME VARSA
	journalsglobal
		iframe (wikipedia.org)
			iframe (facebook.com)
				iframe (google.com)
-------------------------ÖNEMLİ BİR NOT------------------------------
iframe ve jsalert için unutmamamız gereken bir durum var : switchTo() methodunu kullanıyoruz.
 */