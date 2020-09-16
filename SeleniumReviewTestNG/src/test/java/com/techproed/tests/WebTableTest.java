package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {

    @BeforeTest
    public void login()
    {
        driver.get("http://fhctrip-qa.com/admin/HotelroomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }

    @Test
    public void basliklar(){
        // sayfadaki başlıklar : //thead//th
        List<WebElement> basliklar = driver.findElements(By.xpath("//thead//th"));
        for(WebElement w : basliklar){
            System.out.println(w.getText());
        }
    }

    @Test
    public void tumSatirlar(){
        // sayfadaki tüm satırlar : //tbody/tr
        List<WebElement> satirlar = driver.findElements(By.xpath("//tbody/tr"));
        for(WebElement w : satirlar){
            System.out.println(w.getText());
        }
    }

    @Test
    public void sutunYazdirma(){
        // 5. sütun : //tbody/tr/td[5]
        List<WebElement> besinciSutun = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for(WebElement w : besinciSutun){
            System.out.println(w.getText());
        }
    }

    @Test
    public void hucreYazdirma(){
        //tbody/tr[2]/td[3] : 2. satır 3. sütun gibi istediğimiz hücreyi yazdırma.
        WebElement hucre = driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
        System.out.println(hucre.getText());
    }

    @AfterMethod
    public void afterMethod()
    {

    }
}


/*
Selenium Review 7. Ders
WebTable : <table tagname'i ile oluşturulan webelementlere webtable diyoruz. İçerisinde oluşturulan tablonun, başlıkları ve satırları olmak üzere 2 ana bölümden oluşuyor.
1. Bölüm : THEAD (table head)
	Tablonun başlıklarının yer aldığı bölüm bulunur.
2. Bölüm : TBODY (table body)
	Tablonun içerisindeki satırlar (veriler) yer alıyor.
tr  : 	tablonun içerisindeki satırları eklediğimiz webelement.
th  :   tablonun içerisindeki başlıkları eklediğimiz webelement.
td  :   bir satırın içerisindeki verileri(data) eklediğimiz webelement.
-----------------------------xpath komutları---------------------------
//table           : tabloyu bulmak için kullanırız.
//table/thead     : tablonun üst kısmını (thead) bulmak için kullanırız.
//table/tbody     : tablonun gövde kısmı (tbody) bulmak için kullanırız.
//tbody/tr        : tablonun içerisindeki tüm satırları bulmak için..
//tbody/tr[3]     : tablonun 3. satırını almak için kullanılır.
//tbody/tr/td[5]  : tablonun tüm satrlarnın 5. sütunundaki dğrlri almk için
***** "//" (çift slash) ile "/" (tek slash) farkı nedir ?
"//" (çift) : Child ya da daha alt nesil manasına gelir.
"/"  (tek)  : Child manasına gelir.
//table/tr  : TABLE webelementinin ÇOCUĞU(child)'ı olan TR webelementi
//table//tr : TABLE webelementinin ÇOCUĞU(child)'ı YA DA TORUNU(daha alt nesil) olan TR webelementi


Define an HTML Table
The <table> tag defines an HTML table.
Each table row is defined with a <tr> tag. Each table header is defined with a <th> tag. Each table data/cell is defined with a <td> tag.

By default, the text in <th> elements are bold and centered.

By default, the text in <td> elements are regular and left-aligned.

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Code</th>
			<th>Location</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>123</td>
			<td>Almanya</td>
		</tr>
		<tr>
			<td>2</td>
			<td>124</td>
			<td>Belçika</td>
		</tr>
		<tr>
			<td>3</td>
			<td>125</td>
			<td>Norveç</td>
		</tr>
	</tbody>
</table>
 */