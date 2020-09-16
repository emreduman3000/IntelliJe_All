package com.techproed;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JUnit_Annotationn {
//RİGHT CLİCK ON PROJECT , CLICK MAVEN , RELOAD
    //ALL TESTS RUNS

    @Before
    public void TestBefore()
    {
        System.out.println("TestBefore");
    }
    @Before
    public void TestBefore2()
    {
        System.out.println("TestBefore2");
    }

    @Test
    public void Test1()
    {
        System.out.println("Print TEST11");
    }

    @Ignore//Test2 methodu ve onunla calısıcak before - after methodları ıgnored olucak
    @Test
    public void Test2()
    {
        System.out.println("Print TEST2");
    }


    @Test
    public void Test3()//herhangi bir test before ve after methodlarını calıstırır
    {
        System.out.println("Print TEST3");
    }

    @After
    public void TestAfter()
    {
        System.out.println("TestAfter");
    }
}
