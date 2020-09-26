package collections.maps;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMap2 {
    public static void main(String[] args) {

        //Java HashMap contains values based on the key.
        //Java HashMap contains only unique keys.
        //Java HashMap may have one null key and multiple null values.
        //Java HashMap is non synchronized.
        //Java HashMap maintains no order.
        //The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.

        ///public class HashMap<K,V> extends AbstractMap<K,V>
        // implements Map<K,V>, Cloneable, Serializable
        String name="Emre";
        String name2="Emre2";
        String name3="Emre";
        System.out.println(name.hashCode());//2163963
        System.out.println(name2.hashCode());//67082903
        System.out.println(name3.hashCode());//2163963
        System.out.println(name.equals(name3));//true
        //name ve name ün hashcodeları aynı ve equals true dur
        //cünkü String Classında bunlar override edilmistir

        //Employee Class
        //hahCode() reference number'ı return etmez içindeki degerlerin integer halinin döner
        Employee e1=new Employee("emre",1);
        Employee e2=new Employee("emre",1);
        System.out.println(e1.hashCode());//96636487 objectin hashcodu
        System.out.println(e1.name.hashCode());//3117275 object icindeki kelımenın hashcodu
        System.out.println(e2.hashCode());//96636487 override etmeseydeim farklı bir hashcode dönerdi
        System.out.println(e1.equals(e2));//true  override etmeseydim false verirdi

        char c=1;         System.out.println(c);//
        char c2=50;       System.out.println(c2);//2
        char c3=100;      System.out.println(c3);//d




        HashMap<Integer,String> hashMap01=new HashMap<>(1,0.75f);
        //default capacity is 16 (array'den olusur) ve eger ben 12 tane eleman koyarsam capacity 32 olacak
        //elemanlar 16 bosluktan birine yerlescek random

        hashMap01.put(1,"EMRE");// |KEY|VALUE(NODE)|HASHCODE|NEXT ELEMENT'S KEY| - |1|EMRE|1234|2|
        hashMap01.put(2,"EMRE");//|1|EMRE|1234|2| --> |2|EMRE|1234|null|
        hashMap01.put(3,"DUMAN");//|3|DUMAN|5678|null|
        hashMap01.put(3,"DUMAN2");//|3|DUMAN2|5678|null|// 3 E GİTTİ VE DUMAN2 YAPTI
        hashMap01.put(null,"null1");//|null|null1|1456|null|
        hashMap01.put(null,"null2");//|null|null2|1498|null|
        hashMap01.put(4,null);//|4|null|0|null|
        System.out.println(hashMap01);//{null=null2, 1=EMRE, 2=EMRE, 3=DUMAN2}
        //null keywordu olan node(value en basa yazılır)
        System.out.println(hashMap01.size());//4
        //eger 17 element varsa capacity 2 katına cıkar 32 olur 64 128 diye devam edr

        //aynı hashcode'lu baska bir deger olabilir
        System.out.println(hashMap01.get(2));
        //gitti hashcode a göre gitti baktı
        // sonra keyword e baktı uymuyor diğer aynı hashcode gitti ve sonra onun key worduna baktı
        //uyuyorsa node(value)'ı getirdi

        System.out.println("Iterating Hashmap...");
        for(Map.Entry<Integer,String> m : hashMap01.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
            //Iterating Hashmap...
            //null null2
            //1 EMRE
            //2 EMRE
            //3 DUMAN2
            //4 null
        }




        HashMap<String,Integer>hashMap02=new HashMap<>();
        hashMap02.put("Istanbul",34);
        hashMap02.put("Izmir",35);
        hashMap02.put("Antalya",07);
        hashMap02.put("Bursa",16);
        hashMap02.put("Bursa",166);//Updating
        hashMap02.put(null,200);///but there should be only one null key.
        System.out.println(hashMap02);
        //{Antalya=7, null=200, Bursa=166, Izmir=35, Istanbul=34}


        System.out.println("Iterating Hashmap...");
        for(Map.Entry m : hashMap02.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
            //Iterating Hashmap...
            //Antalya 7
            //null 200
            //Bursa 166
            //Izmir 35
            //Istanbul 34
        }


    }



}

class Employee
{
    String name;
    int id;
    public Employee(String name,int id)
    {
        this.name=name;
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}