package com.techproed.tests;

import org.testng.annotations.Test;

public class DependsOnTest {

    @Test ()
    public void login(){  // sisteme giriş testiniz
        System.out.println("login");
    }
    @Test (priority = 1, dependsOnMethods = "login")
    public void test02(){ // sisteme giriş yaptıktan sonraki işlemler
        System.out.println("test02");
    }

    @Test(priority = 2 , dependsOnMethods = "login")//yukarda calıstıysa birdaha calısmaz
    public void test03(){
        System.out.println("test03");
    }
}
