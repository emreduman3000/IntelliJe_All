package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;

public class Facebook_Dropdown {

    WebDriver driver;

    @Before
    public  void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void birthday()
    {
        WebElement month=driver.findElement(By.xpath("//select[@title='Month" +
                "']"));
        Select optionMonth= new Select(month);
        optionMonth.selectByIndex(4);//april

        WebElement day=driver.findElement(By.id("day"));
        Select optionDay= new Select(day);
        optionDay.selectByValue("30");//april 30

        WebElement year=driver.findElement(By.name("birthday_year"));
        Select optionYear= new Select(year);
        optionYear.selectByVisibleText("2020");//april
    }

    @After
    public void close()
    {
        //driver.close();
    }
}
