package java_selenium01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.namespace.QName;
import java.sql.Driver;
import java.util.List;


public class Java_Selenium01 {
    //Selenium web tabanlı uygulamaları browser üzerinden test etmemizi saglar.
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");//ı set the BROWSER I USE , ı ADDRESS the link WHERE chromedriver.exe is
        WebDriver driver = new ChromeDriver();//I CREATED AN OBJECT FROM WebDriver CLASS
        //WebDriver driver2 = new ChromeDriver();//I CREATED AN OBJECT FROM WebDriver CLASS if ı dont use this object a blank webpage will be opened
        ///WebDriverManager.chromedriver().setup();
        /*
            driver.get("https://www.google.com");//It will open
            driver.get("https://www.amazon.com");//Then, web page will open amazon
            Thread.sleep(5000);// wait 5000 milisecond-5second throws InterruptedException ekledim
            driver.close();//close the browser - close current page
            //driver.quit();//close the browser - close all pages
        */
        driver.get("https://www.udemy.com");//udemy opens
        driver.navigate().to("https://www.amazon.com");//go to amazon
        driver.navigate().back();//back to udemy
        driver.navigate().forward();//forward to amazon
        driver.navigate().refresh();//refresh the last opened webpage
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.close();//close the last opened webpage- amazon/ udemy remains
        driver.quit();//close all subsequent pages (close amazon and udemy as well)
    }
}

class verifyTitleTEST {
    public static void main(String[] args) {

    //region Description

        System.setProperty("webdriver.chrome.driver","C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        String actualTitle=driver.getTitle();
        String expectedTitle="Google";

        if(actualTitle.equals(expectedTitle))
            System.out.println("pass");
        else
            System.out.println("fail"+"\n"+
                    "Actual Title:"+actualTitle+"\n"+
                    "Expected Title:"+expectedTitle);

        expectedTitle="google";
        System.out.println(actualTitle.equals(expectedTitle) ? "Pass" : "fail"+"\n"+
                "Actual Title:"+actualTitle+"\n"+
                "Expected Title:"+expectedTitle);

        driver.close();//ı closed the page
//endregion
    }
}

class verifyURLTitle {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println(driver.getCurrentUrl());//https://www.google.com/ - this url is printed on console

        String actualURL = "https://www.google.com/";
        String expectedURL = "https://www.google.com";

        System.out.println(actualURL.equals(expectedURL) ? "Pass" : "Fail" + "\n" +
                "Actual Title:" + actualURL + "\n" +
                "Expected Title:" + expectedURL);
        /*
            Fail
            Actual Title:https://www.google.com/
            Expected Title:https://www.google.com
         */

        driver.close();
    }
}

class reviewDAY02 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");


        String actualYOUTUBEtitle=driver.getTitle();//Youtube
        String expectedYOUTUBEtitle="youtube";
        boolean x=actualYOUTUBEtitle.equals(expectedYOUTUBEtitle);//false

        System.out.println( x ? "It is equal" : "It is not equal"+"\n"+
                "Actual Youtube Title:"+actualYOUTUBEtitle+"\n"+
                "Expected Youtube Title:"+expectedYOUTUBEtitle);
        /*result
            It is not equal
            Actual Youtube Title:YouTube
            Expected Youtube Title:youtube
         */


        String actualYOUTUBEurl = driver.getCurrentUrl();//https://www.youtube.com/
        String expectedYOUTUBEurl="youtube";
        boolean x2=actualYOUTUBEurl.contains(expectedYOUTUBEurl);//true

        System.out.println( x2 ? "It contains " : "It doesn't contain" + "\n" +
                "Actual Youtube URL:" + actualYOUTUBEurl +"\n"+
                "Expected Youtube URL:"+expectedYOUTUBEurl);
        /*result
            It contains
         */


        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();//back to Youtube
        driver.navigate().refresh();//refresh Youtube
        driver.navigate().forward();//forward to Amazon
        driver.manage().window().maximize();//maximize Amazon web page


        String actualAMAZONtitle=driver.getTitle();//Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
        String expectedAMAZONtitle="Amazon";
        boolean x3=actualAMAZONtitle.contains(expectedAMAZONtitle);//true
        System.out.println( x3 ? "It contains" : "It doesn't contains,"+ "\n" +
                "Actual Amazon Title:"+actualAMAZONtitle + "\n" +
                "Expected Amazon Title:"+expectedAMAZONtitle);
        /*result
            It contains
         */

        String actualAMAZONurl=driver.getCurrentUrl();
        String expectedAMAZONurl="https://www.amazon.com";
        boolean x4=actualAMAZONurl.equals(expectedAMAZONurl);

        System.out.println( x4 ? "It is equal" : "It is not equal,"+ "\n" +
                "Actual Amazon URL:" + actualAMAZONurl+ "\n" +
                "Expected Amazon URL:"+ expectedAMAZONurl);
        /*result
            It is not equal,
            Actual Amazon URL:https://www.amazon.com/
            Expected Amazon URL:https://www.amazon.com
         */

        //driver.close();//close onlt last opened web page
        driver.quit();//It closes all subsequent opened web pages
    }
}

class day03 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");


         /*
            driver.findElement(By.name("session[email]"));
            driver.findElement(By.className("form-group row"));
            driver.findElement(By.linkText(""));//email textbox için linkText yok
            driver.findElement(By.partialLinkText(""));//email textbox için partialLinkText yok
            driver.findElement(By.tagName(""));//bu mantıklı değil bu tagname ile bir sürü element  vardır
            driver.findElement(By.xpath(""));//birden fazla syntax ı vardır
            driver.findElement(By.cssSelector(""));//
        */


        WebElement emailTextBox = driver.findElement(By.id("session_email"));//An element is located only once , like in this line
        emailTextBox.sendKeys("testtechproed@gmail.com");//sendKeys() method send the text which is inside of double quote into textbox on webPage

        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();//click() method is used to click indicated button automatically.
        driver.manage().window().maximize();
        //websitesinde right cilick+inspect+mouse tıkla sonra textbox ya da bir elemente tıkla - onla alakalı kodlar cıkıcak
        //name'e ya da id'ye yada class'a double click + ctrl+c  sonra ctrl+f yap araa butonuna cıktı ctrl+v yap
        //name tek bir elemente mi ait görebiliriz

        //user ıd'nin testtechproed@gmail.com verify edin
        WebElement userID=driver.findElement(By.className("navbar-text"));
        System.out.println("USER ID WEBELEMENT: "+userID);//hashcode'u -reference'ı verir - [[ChromeDriver: chrome on WINDOWS (7cdd4801843dce1fa04088b90bd97102)] -> class name: navbar-text]
        System.out.println("USER ID TEXT: "+userID.getText());//ELEMET'İN GÖRÜNEN METNINI VERIR - testtechproed@gmail.com

        String actualUserID=userID.getText();
        String expectedUserID="testtechproed@gmail.com";
        boolean x=actualUserID.equals(expectedUserID);

        System.out.println( x ? "It is equal\n" : "It is not equal,"+ "\n" +
                "ActualUserID:" + actualUserID+ "\n" +
                "ExpectedUserID:"+ expectedUserID +"\n");


        //Addresses and Sign Out textlerinin displayed edildiğini verify et

        //<a class="nav-item nav-link" data-test="addresses" href="/addresses">Addresses</a>
        WebElement addressLinkTest=driver.findElement(By.linkText("Addresses"));
        System.out.println("reference of addressLink:"+addressLinkTest);
        System.out.println("text of addressLink:"+addressLinkTest.getText()+"\n");

        String actualAddressLink=addressLinkTest.getText();
        String expectedAddressLink="Addresses";
        boolean x2=actualAddressLink.equals(expectedAddressLink);

        System.out.println( x2 ? "It is equal\n" : "It is not equal,"+ "\n" +
                "ActualAddressLink:" + actualAddressLink+ "\n" +
                "ExpectedAddressLink:"+ expectedAddressLink);


        //<a class="nav-item nav-link" data-test="sign-out" rel="nofollow" data-method="delete" href="/sign_out">Sign out</a>
        //“Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement signOutLink = driver.findElement(By.linkText("Sign out"));
        String actualSignOutLinkText = signOutLink.getText();
        String expectedSignOutLinkText = "Sign Out";

        if(actualSignOutLinkText.equals(expectedSignOutLinkText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL SIGN OUT TEXT : "+actualSignOutLinkText);
            System.out.println("EXTECTED SIGN OUT TEXT : "+expectedSignOutLinkText);
        }



       // driver.quit();//It closes all subsequent opened web pages

        //By.partialLinkText();
        //ADDRESSES link
        WebElement addressPartialLink = driver.findElement(By.partialLinkText("Address"));
        String actualAddressPartialLinkText = addressPartialLink.getText();
        System.out.println("ADDRESSES PARTIAL LINK TEXT :"+ actualAddressPartialLinkText);
        //Sign out link
        WebElement signOutPartialLink = driver.findElement(By.partialLinkText("ign ou"));
        String actualSignOutPartialLink = signOutPartialLink.getText();
        System.out.println("SIGN OUT PARTIAL LINK TEXT :"+actualSignOutPartialLink);



        //Sayfadaki toplam link sayisini bulun ve bu linkleri konsolda yazdirin.
        //findElement(); metodu yalnizca tek bir elementi locate icin kullanilir. String return eder.
        //findElements(); metodu birden fazla element return eder. List<WebElement>
        List<WebElement> listOfWebElement = driver.findElements(By.tagName("a"));
        System.out.println("Bu web sayfasinda "+listOfWebElement.size()+" tane link vardir.");
        //linkleri tek tek yazdırın
        //3 tane link elementi var.  1. elementin indexini 0 alırız

        System.out.println("1. WEB ELEMENT:" + listOfWebElement.get(0));
        //1. elementin konsolda yazdırılması. 1. element için index 0 alınır

        System.out.println("1.link text:"+listOfWebElement.get(0).getText());
        System.out.println("2.link text:"+listOfWebElement.get(1).getText());
        System.out.println("3.link text:"+listOfWebElement.get(2).getText());

        for (WebElement i: listOfWebElement) {
            System.out.println(i.getText());
        }




    }
}

class day04_GoogleSearchTest {
    public static void main(String[] args)
    {
        //a.google web sayfasına gidin. https://www.google.com/
        System.setProperty("webdriver.chrome.driver","C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com/");

        //b. Search(ara) “city bike”
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("city bike");
        googleSearchBox.submit();

        //c. Google'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement allResults = driver.findElement(By.id("result-stats"));
        System.out.println(allResults.getText());

        //d. “Shopping” e tıklayın.

        driver.findElement(By.linkText("Görseller")).click();

        //e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.className("WGvvNb")).click();
    }
}

class day04_Locators_xpath {
    public static void main(String[] args)
    {
        //Kullanici http://a.testaddressbook.com/sign_in adresine gitsin.
        System.setProperty("webdriver.chrome.driver","C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");

        //email text box'i absolute xpath kullanarak locate edin
        WebElement emailTextBox = driver.findElement(By.xpath("html/body/div/div/div/div/form/div[1]/input"));
        emailTextBox.sendKeys("testtechproed@gmail.com");  //Kullanici adini giriniz =>> Username : testtechproed@gmail.com

        //password text boxi relative xpath kullanarak locate edin
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordTextBox.sendKeys("Test1234!");  //passwordu giriniz =>> Password : Test1234!

        //Locate signin button
        WebElement signinButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signinButton.click();  //sign in düğmesini tıklayın
        driver.manage().window().maximize();
        //Ardından, beklenen(expected) user id  testtechproed@gmail.com dogrulayin(verify)
        //user id locate

        //*[.='text name']
        WebElement userID = driver.findElement(By.xpath("//*[.='testtechproed@gmail.com']"));
        String actualUserID = userID.getText();
        String expectedUserId = "testtechproed@gmail.com";
        if(actualUserID.equals(expectedUserId)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL USER ID : "+actualUserID);
            System.out.println("EXPECTED USER ID : "+expectedUserId);
        }
        //Addresses ve Sign Out metinlerinin görüntülendiğini(isDisplayed) doğrulayin.

        //tagName[.='text name']
        WebElement addressLink = driver.findElement(By.xpath("//a[.='Addresses']"));
        System.out.println("ADDRESSES LINK TEXT :"+ addressLink.getText());


        //Sayfadaki toplam link sayısını bulun ve konsolda yazdirin
        List<WebElement> listOfLinkElements= driver.findElements(By.tagName("a"));
        System.out.println(listOfLinkElements.size());

        System.out.println("**********LINKS ON THE WEBPAGE*************");
        for (WebElement i:listOfLinkElements) {
            System.out.println(i.getText());
        }

        //Sayfadan çıkış yapın(Sign Out)

        WebElement sigOutLink=driver.findElement(By.xpath("//a[.='Sign out']"));
        System.out.println("SIGN OUT LINK TEST:"+sigOutLink.getText());
        sigOutLink.click();
        driver.close();






         /*
            8 tane locater vardir.
            By.id
            -By.name
            By.class.name
            By.tagName
            By.linkName
            By.partialLinkName
            By.xpath
            By.css
            2 CESIT XPATH VARDIR
            1-) Absolute xpath -  WebElement emailTextBox = driver.findElement(By.xpath("html/body/div/div/div/div/form/div[1]/input"));
            2-) Relative xpath - //tagName[@attribute=’value’]; -  WebElement signinButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
                             //tagname[.="value"]; - . herhangi bir attribute
                             //*[.="value"]; - * herhangi bir tag
                             //*[(text()='testtechproed@gmail.com')]; - text name "testtechproed@gmail.com " olan ı bul
          */


    }
}

class day05_cssSelector {
    public static void main(String[] args)
    {
        //Kullanici http://a.testaddressbook.com/sign_in adresine gitsin.
        System.setProperty("webdriver.chrome.driver","C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");

        //email text box'i cssSelector kullanarak locate edin
        WebElement emailTextBox = driver.findElement(By.cssSelector("input[type='email']"));
        emailTextBox.sendKeys("testtechproed@gmail.com");  //Kullanici adini giriniz =>> Username : testtechproed@gmail.com

        //password text boxi cssSelector kullanarak locate edin
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#session_password"));
        passwordTextBox = driver.findElement(By.cssSelector("input[name='session[password]']"));
        passwordTextBox.sendKeys("Test1234!");  //passwordu giriniz =>> Password : Test1234!

        WebElement signInButton = driver.findElement(By.cssSelector("input#u_0_b"));
        System.out.println(signInButton.getText());
        /*
            "tag#idName"
            "tag.className"
            "tag[attribute='value']"
         */

    }



}

class day05_checkbox {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1=driver.findElement(By.cssSelector("input[type='checkbox']"));
        checkBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        checkBox1=driver.findElement(By.xpath("//*[@type='checkbox']"));//buna [1] yazmaadım olur çünkü ilk bu var

        if(!checkBox1.isSelected())
            checkBox1.click();
        else
            System.out.println("CheckBox 1 is already checked!!!");

        WebElement checkBox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if(!checkBox2.isSelected())
            checkBox2.click();
        else
            System.out.println("CheckBox 2 is already checked!!!");

    }
}

class day06_facebook
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/emreduman/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com/");



//sıgn up
        WebElement  Text=driver.findElement(By.xpath("//div[@class='_5iyx']"));
        System.out.println(Text.getText());

        WebElement signUpText=driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']"));
        System.out.println(signUpText.getText());

        WebElement nameTextBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        nameTextBox.sendKeys("firstname");

        WebElement surnameTextBox=driver.findElement(By.id("u_0_o"));
        surnameTextBox.sendKeys("lastname");

        WebElement phoneORemail=driver.findElement(By.id("u_0_r"));
        phoneORemail.sendKeys("test@gmail.com");

        WebElement phoneORemailRepeat=driver.findElement(By.id("u_0_u"));
        phoneORemailRepeat.sendKeys("test@gmail.com");

        WebElement passwordd=driver.findElement(By.id("password_step_input"));
        passwordd.sendKeys("password1234");

        WebElement day=driver.findElement(By.id("day"));
        day.sendKeys("29");
        WebElement month=driver.findElement(By.id("month"));
        month.sendKeys("march");
        WebElement year=driver.findElement(By.id("year"));
        year.sendKeys("1997");


        WebElement femaleRadioButton = driver.findElement(By.cssSelector("#u_0_6"));
        femaleRadioButton.click();

        WebElement maleRadioButton = driver.findElement(By.cssSelector("#u_0_7"));
        maleRadioButton.click();

        WebElement privateRadioButton = driver.findElement(By.cssSelector("#u_0_8"));
        privateRadioButton.click();

        if (!maleRadioButton.isSelected()) {   //true
            maleRadioButton.click();
        } else {
            System.out.println("Male seçeneği zaten seçili");
        }


        WebElement singUpButton=driver.findElement(By.id("u_0_12"));
        singUpButton.click();

        //sign ın
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("test@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@name='pass']"));
        password.sendKeys("password1234");

        WebElement submitButton=driver.findElement(By.id("u_0_4"));
        submitButton.click();





    }
}