package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile extends TestBase {

    @Test
    public void chooseFile()
    {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        //action.moveToElement(chooseFile).click().perform();

        String imagePath="C:\\Users\\emreduman\\Pictures\\PAPATYA.jpg";
        chooseFile.sendKeys(imagePath);

        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText() ,"File Uploaded!");
    }
}
