package collections.lists;

import java.util.*;

public class Vector
{

    //public class Vector<E>
    //    extends AbstractList<E>
    //    implements List<E>, RandomAccess, Cloneable, java.io.Serializable

    public static void main(String[] args) {
        //List<String> vector01=new java.util.Vector<>(3);
        //yukardaki initializngde Vektor classındaki Lİsteen overried edilmiş methodara erişilebilirdi
        //Vektor classındaki methodlara erisilemezdi

        java.util.Vector<String> vector01=new java.util.Vector<>(3);
        vector01.add("A");
        vector01.add("A");
        vector01.add("A");
        vector01.add("A");//I exceed the capacity of the vector01,and automatically capacity doubles.
        System.out.println(vector01.size());//4
        System.out.println(vector01.capacity());//6 ArrayList'in Default Capacity si de 10'du.
        vector01.setSize(10);
        System.out.println(vector01);//[A, A, A, A, null, null, null, null, null, null]


        System.out.println(vector01.firstElement());//A
        System.out.println(vector01.lastElement());//null
        System.out.println(vector01.get(vector01.size()-1));//null

        Iterator<String> iterator01=vector01.iterator();
        while (iterator01.hasNext()){
            System.out.print(iterator01.next()+"\n");
        }
        System.out.println();

        ListIterator<String>listIterator01=vector01.listIterator();
        while (listIterator01.hasNext()){
            System.out.print(listIterator01.next()+"\n");
        }
        System.out.println();

        //Vektor Classına hastır, 3 tane methodu var
        Enumeration<String> enumeration01=vector01.elements();
        while (enumeration01.hasMoreElements()){
            System.out.print(enumeration01.nextElement()+"\n");
        }


        //olmaz stackta olur
        //java.util.Vector vector02=new java.util.Vector();
        //        vector02.push();
        //        vector02.pop();

    }
}

//Tanım
//Arraylist sınıfı gibi dinamik olarak artan bir dizi gibidir. Arraylistten en
//temel farkı vector sınıfı synchronized metotlara sahiptir yani vector üzerinde
//sadece tek bir thread işlem yapar, diğer threadler burdaki işlemin bitmesini
//beklemek zorundadır.


//Multi thread bir ortamda vector kullanımı daha mantıklıdır. Tabi bu da
//beraberinde performans sorunları getirebilir. Çünkü bir thread işlem yaparken
//vector üzerine kilit koyar ve diğer threadler bu işlemin yapılmasını beklemek
//zorunda kalır. Eğer multi thread bir uygulama yapmıyorsak arraylisti tercih
//etmek daha mantıklı olacaktır.


//Vector<Integer> vector = new Vector<Integer>(3); vectorumüzü 3 elemanlı olarak
//oluşturduk.


//vector.capacity() ile vektörümüzün o anki boyutunu görebiliriz. Bu kapasite
//aşıldığı anda vector kapasitesini 2 katına çıkarır.

//vector.setSize(20) diyerek vektörün boyutunu arttırabiliriz, bu durumda vektör
//boş olan elemanlara null değerleri atar.


//Vektördeki elemanları gezmek için
// Enumeration<Integer> en = vector.elements();
// while (en.hasMoreElements())
// {
// System.out.println(en.nextElement());
// }

//vector.firstElement() ve vector.lastElement() ile ilk ve son elemanlara
//ulaşabilirsiniz.

//○ Collections.synchronizedList(arraylist)
//• Thread safe özelliğini arraylistlere de kazandırabiliriz.
//• Vektörlerdeki thread safe özelliği çok fazla zaman alır.
//Eski bir sınıftır, eksi özellikleri çoktur o yüzden arraylist kullanalım
