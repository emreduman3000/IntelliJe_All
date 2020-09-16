package com.techproed.tests;


import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void BeforeSuite()
    {
        System.out.println("***************BEFORE SUITE**************");
    }

    @BeforeTest
    public void BeforeTest() { System.out.println("***************BEFORE TEST**************"); }

    @BeforeClass
    public void BeforeClass() { System.out.println("***************BEFORE CLASS**************"); }

    @BeforeMethod
    public void BeforeMethod() { System.out.println("***************BEFORE METHOD**************"); }


    //testNG'de methodlar alfabetik sıraya göre yazdırılır.
   //JUnit'te ise sırayla yazılır
    @Test
    public void b(){ System.out.println("test1"); }
    @Test
    public void a(){ System.out.println("test2"); }//ilk bunu göstercek
    @Ignore @Test//Ignore sadwce Test annotatıonlarda calısır
    public void c(){ System.out.println("test3"); }



    @AfterMethod
    public void AfterMethod(){ System.out.println("***************AFTER METHOD**************"); }

    @AfterClass
    public void AfterClass(){System.out.println("***************AFTER CLASS**************"); }

    @AfterTest
    public void AfterTest(){ System.out.println("***************AFTER TEST**************"); }

    @AfterSuite
    public void AfterSuite(){ System.out.println("***************AFTER SUITE**************"); }
}
