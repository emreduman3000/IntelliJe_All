package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()
    //downloadTest () metodunun icinde aşağıdaki testi yapın:
    //https://the-internet.herokuapp.com/download adresine gidin.
    //image1.jpg dosyasını indir
    //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.

    @Test
    public void isExist()
    {
        String mevcutKlasor =  System.getProperty("user.dir");
        System.out.println("MEVCUT KLASOR => "+ mevcutKlasor);
        //MEVCUT KLASOR => C:\Users\emreduman\IdeaProjects\myTestNGFramework


        String userKlasor = System.getProperty("user.home");
        System.out.println("USER KLASOR => "+userKlasor);
        //USER KLASOR => C:\Users\emreduman

        String filePath=userKlasor+"/Pictures/PAPATYA.jpg";
        //C:\Users\emreduman\Pictures\PAPATYA.jpg

        boolean isFileExist= Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);//if this file exist, true will be written on console
    }

    @Test
    public void downloadTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidin.
        driver.get("https://the-internet.herokuapp.com/download");
        //image1.jpg dosyasını indir
        WebElement image1 = driver.findElement(By.linkText("image1.jpg"));
        image1.click();
        Thread.sleep(5000);//biraz beklmesi gerek yoksa fail olur
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
        //Kullanici klasoru
        String userKlasor = System.getProperty("user.home");
        // indirilen dosyanin konumunu(path) buluyoruz.
        String filePath = userKlasor + "/Downloads/image1.jpg";
        //String filePath = "C:/Users/PC/Downloads/image1.jpg";  bu da kullanilabilir.

        //dosya var mi yok mu kontrol ediyoruz.
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);  // dosya yuklendi ise PASS, Degilse FAIL
    }


}
