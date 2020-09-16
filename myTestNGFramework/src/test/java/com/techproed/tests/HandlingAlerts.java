package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HandlingAlerts {

    //driver.switchTo().alert().dismiss();//alert'e cancel'a bas

    //Bir class olusturun: HandlingAlerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //


    WebDriver driver;


    @BeforeClass
    public void driver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }


    @Test
    public  void acceptAlert(){
        WebElement firstButton=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        firstButton.click();

        System.out.println(driver.switchTo().alert().getText());//alert mesajı
        driver.switchTo().alert().accept();//alertteki ok tusunu clicklemek icin

        WebElement result=driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public  void dismissAlert(){
        WebElement secondButton=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        secondButton.click();

        System.out.println(driver.switchTo().alert().getText());//alert mesajı
        driver.switchTo().alert().accept();//alertteki ok tusunu clicklemek icin

        WebElement result=driver.findElement(By.id("result"));
        String actualMessage=result.getText();
        String expectedMesage="You clicked: Ok";

        Assert.assertEquals(actualMessage,expectedMesage);
        Assert.assertFalse(!result.isDisplayed());

    }
    @Test
    public  void sendKeysAlert(){
        WebElement thirdButton=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        thirdButton.click();

        System.out.println(driver.switchTo().alert().getText());//alert mesajı
        String name = "EMRE";
        driver.switchTo().alert().sendKeys(name);//input girdim
        driver.switchTo().alert().accept();//alertteki ok tusunu clicklemek icin

        WebElement result=driver.findElement(By.id("result"));
        String resultName=result.getText();
        System.out.println(resultName);//You entered: EMRE

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals("You entered: "+name,resultName);

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(resultName.contains(name));
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown()
    {
        //driver.close();
    }
}
