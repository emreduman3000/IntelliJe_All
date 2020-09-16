package com.techproed.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityTest {

    //priority annotation koymazsam alfabetic sıraya göre testler calısır
    //priorityler aynıysa alfabetik sıraya  göre calısır

    @BeforeMethod//her testten önce calısır
    public void setUp()
    {
        System.out.println("setUp");
    }

    @Test(priority = 0)
    public void amazonTest()
    {
        System.out.println("AmazonTest!");
    }

    @Test(priority = 0)
    public void googleTest()
    {
        System.out.println("googleTest!");
    }
    @Test(priority = 2)
    public void facebookTest()
    {
        System.out.println("facebookTest!");
    }

    @Test(priority = 3)
    public void appleTest()
    {
        System.out.println("appleTest!");
    }

}
