package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//classi cucumber ile calistir.
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        //plugin rapor almak icin kullanulır
        //    plugin = "html:target/cucumber",   //(html seklinde) raporları almamızı saglar targetin altında cucumber raporu olusturur
        features = "src/test/resources/features",  //feature file ile
        glue = "stepdefinitions",               //stepdefinitions ı birbiine sttach ediyorum
        tags = "@testcase1",                         //sadece nokiayı calıstırmak isersem tags bölümünde sadece nokiayı yazarım
        dryRun = false                                        //false default'tur, bazı senoryaolar sadece tanımlıdır ama steplerde olusturulmamıstır,bos yere browserı acmasın workareada arasın diye dryRun=true dedik*/
                                                  //stepleri yazılmıs senario ise ignored edilir// missin stepleri verir of defined tag

)

public class Runner {
}




//parameter_fhclogin.faeture olusturduk ve onun 2 step'i fhctrip_login.faeture'den farklı(parameter'lı)
//tags="fhcloginparameter" yazınca ve dryRun=true diyince parameter_fhclogin.faeture fileın stepleri tanımlanmamıs olanları console bize verir
//bizde onu copy yapıp FhcTripLoginStepDefinitions lara paste ettik

//diyelimki .feature file'ımız dogru runnner classımız ve steplerimiz dogru
//dryRun acıksa web browser calısmaz testler ignored edilir
//dryRun zaten missing stepleri bulmak için kullanılır,missing varsa undefined der,missing yoksa ignored der




/*
CUCUMBER INTRO
====TDD Nedir?
Once test caseleri yazalir, daha sonra bu test caseleri icin  kodlar yazilir.
====BDD Nedir?
Bu tip frameworkte ilk once behaviours(davranislar) yazilir, daha sonra kodlar yazilmaya baslanir.
===Cucumber PROJECT SET UP===(Cucumber-JUnit)
Create Project: File -> New -> Project-> Select maven -> click next
PROJE ADI :mycucumberframework->finish->click on Enable Auto Reload->
Eklenecek Dependencies =>Selenium-java, webdrivermanager,cucumber java, cucumber junit
Java'nin kesin versiyonunu kullanmak icin maven compiler ekleyebilirsiniz.
<properties>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
test=>java package'te saga tiklayin ve asagidaki package lari olusturun:
# utilities
# pages
# runners
# stepdefinitions
Create utilities classes : Driver, ConfigurationReader
projede saga tiklayin =>> configuration.properties dosyasi olusturun
test package'te saga tiklayin ve bir directory olusturun: resources
resources'da saga tiklayin ve yeni bir directory olusturun: features (java olmayan kisimlar buradadir.)
features'da saga tiklayin -> new -> file -> firstfeaturefile.feature
Intellij de calismak icin cucumber plugin ekleyin
MAC=>IntelliJ Idea->Preference->Plugins->Marketplace->Type Cucumber for Java->Install -> Restart
WINDOWS=>File->Settings->Plugins->Marketplace->Type Cucumber for Java->Install -> Restart
=====Cucumber'in Iki Onemli Bileseni======
1.features         :non technical stuff. ghenkin language.
2.step definitions :technical stuff. Java kodlari burada
====>>>>Cucumber'da kod nasil gelistirilir???
Step 1: Create feature file ve  Scenario'lari yaz
            Feature: log in functionality
             Scenario: positive scenario
                Given user is on the log in page
                And user types in 1234
                Then verify that user logged in.
Step 2: step definitions'lari olusturmak icin Runner classi calistir.
            @RunWith(Cucumber.class)
            @CucumberOptions(
              features ="src/test/resources/features",
              glue = "stepdefinitions"
            )
            public class Runner {
            }
Step 3: Copy and paste  step definitions(stepdefinitions classina)
            @Given("user searches for iphone")
            public void user_searches_for_iphone() {

            }
Step 4: Java kodlarini step definitionslarin icine yaz.
            @Given("user searches for iphone")
                public void user_searches_for_iphone() {
               WebElement searchBox=Driver.getDriver().findElement(By.name("q"));
               searchBox.sendKeys("iphone");
               searchBox.submit();
            }
====Cucumber Html Report====
Runner classina cucumber html plugin ekle ve rapor almak icin Runner classini calistir.
                    plugin="html:target/cucumber"
====dryRun=====
1. Runner class'ta dryRun olmadan   ===>Features yurutulecek
2. Runner class'ta dryRun=false ile ===>Features yurutulecek(dryRun olmadigi haliyle ayni)
3. Runner class'ta dryRun=true ile  ===>Tarayıcıyı açmadan arka planda çalışır. Amaç, gerçek kodu
                                        çalıştırmadan eksik adım tanımları olup olmadığını bulmaktır.
 */