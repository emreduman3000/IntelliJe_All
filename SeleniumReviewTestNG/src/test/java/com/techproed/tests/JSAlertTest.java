package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void alert()
    {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();


        String messageOfAlert=driver.switchTo().alert().getText();
        System.out.println(messageOfAlert);

        driver.switchTo().alert().sendKeys("3000");//input girdim
        driver.switchTo().alert().accept();//alertteki ok tusunu clicklemek icin
        driver.switchTo().alert().dismiss();
    }
}
