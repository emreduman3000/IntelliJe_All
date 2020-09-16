package com.techproed;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;
public class DataBaseTesting {
    //Database url
    String url = "jdbc:mysql://107.182.225.121:3306/LibraryMgmt";
    //kullanici adi
    String username = "techpro";
    //sifre
    String password = "tchpr2020";
    //Connection, Statement, ResultSet objelerini olusturalim
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Before
    public void setUp() throws SQLException {
        //getConnnection methodu ile databayse baglaniyoruz
        connection = DriverManager.getConnection(url,username,password);
        //createStaement methoduyla stament objesi olusturuyoruz. Bu objeyi kullanarak resutset objesi olusturacagiz
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    @Test
    public void Test1() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM Book;");
        //ilk satiyi atliyoruz
        resultSet.next();
        String deger1=resultSet.getString("BookName");
        System.out.println("DEGER1 : "+deger1);
        //TC_02_BookName deki tum degerleri yazdir
        int rowSayisi=1;//su an ilk satirda oldugumuzdan, 1 den basladik
        while (resultSet.next()){
            Object deger2=resultSet.getObject("BookName");
            System.out.println(deger2);
            rowSayisi++;
        }
        //TC_03_toplam 14 satirin olup olmadigini test et
        Assert.assertEquals(14,rowSayisi);
        //TC_04  5. degerin JAVA olup olmadigini test et

        //5 satira git
        resultSet.absolute(5);
        //o satirdaki degeri al
        String deger5=resultSet.getString("BookName");
        //karsilastir. Assertion yap
        Assert.assertEquals("JAVA",deger5);//FAILED. BUG BULDUK.

    }



    @Test
    public void Test2() throws SQLException
    {
        resultSet = statement.executeQuery("SELECT * FROM Book;");
        //TC_05_son degerin UIPath olup olmadigini test et
        resultSet.last();//dinamic code ile son satira gittik
        String degerSon=resultSet.getString("BookName");
        Assert.assertEquals("UIPath",degerSon);
        //TC_06_ilk satirdaki degerin SQL olup olmadigi test et
        resultSet.first();
        String actualResult=resultSet.getString("BookName");
        String expectedResult="SQL";
        Assert.assertEquals(expectedResult,actualResult);
        System.out.println(actualResult);

    }

    @Test
    public void test3() throws SQLException
    {
        //MetaData: datayla ilgili bilgiler
        DatabaseMetaData databaseMetaData=connection.getMetaData();
        System.out.println(
            "getUserName:"+ databaseMetaData.getUserName()+
                "\ngetConnection: "+databaseMetaData.getConnection()+
                   "\ngetDatabaseProductName:"+databaseMetaData.getDatabaseProductName()+
                      "\ngetDatabaseProductVersion:"+databaseMetaData.getDatabaseProductVersion()
        );
        /*
            getUserName:techpro@CPEf81d0fad81a3-CMf81d0fad81a0.cpe.net.cable.rogers.com
            getConnection: com.mysql.cj.jdbc.ConnectionImpl@184f6be2
            getDatabaseProductName:MySQL
            getDatabaseProductVersion:5.5.5-10.4.14-MariaDB-1:10.4.14+maria~xenial
         */



    }


}