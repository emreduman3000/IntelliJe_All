package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Priority_DependsOnMethod {

    @Test
    public void zlogin()//default 0.5 'tur'
    {
        System.out.println("zLogin");
    }


    //@Ignore koyarsam homepage calsmaz cünkü login calısmıyor-no tests were found
    @Test(priority = -1)
    public void login()
    {
        System.out.println("Login");
    }
    @Test( dependsOnMethods ="login" , priority = 0)//defaulttan bile ilk yazılır
    public void homepage()//buraya basarsam login() method da calısıcak, cünkü o calısmazsa homepage() calısmaz
    {
        System.out.println("Homepage");
    }



    @Test(priority = 2)
    public void search()
    {
        System.out.println("Search");
    }
    @Test(priority = 1)
    public void result()
    {
        System.out.println("Result");
    }

    @Test(priority = 1)//if the priority is same as another method, compiler looks the alphabetic order
    public void resultt()
    {
        System.out.println("Resultt");
    }




    @Test(dependsOnMethods = "b", priority = 1)
    public void a() {System.out.println("a");}//normalde priority'ler aynı oldugu icin a calısır
    @Test(priority = 1)
    public void b() {System.out.println("b");}//b calısmadan a calısmaz oyuzden ilk b sonra a calıscak

    //zincirleme dependsOnMethods OLMAZ!!!

   // @Test(priority = 1)
    //    public void c() {System.out.println("c");}
    //
    //    @Test(dependsOnMethods = "c", priority = 1)
    //    public void d() {System.out.println("d");}
    //
    //    @Test(dependsOnMethods = "d", priority = 1)
    //    public void e() {System.out.println("e");}


}
