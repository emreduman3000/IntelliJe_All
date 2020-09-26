package collections.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class Queuee {
    public static void main(String[] args) {

        //public interface Deque<E> extends Queue<E>
        //Queue Interface ne ait methodlar vardır

        //public class LinkedList<E>
        //    extends AbstractSequentialList<E>
        //    implements List<E>, Deque<E>, Cloneable, java.io.Serializable


        Queue<Integer> queue01=new LinkedList<Integer>();
        // Ilk giren ilk çıkar mantığı ile çalışır.
        queue01.offer(1);
        queue01.offer(2);
        queue01.offer(3);
        queue01.offer(4);
        queue01.add(5);
        System.out.println(queue01);//[1, 2, 3, 4, 5]

        System.out.println(queue01.peek());//1 bastaki elemanı return eder
        System.out.println(queue01.poll());//1 bastaki elemanı siler ve return eder
        System.out.println(queue01.poll());//2 bastaki elemanı siler ve return eder
        System.out.println(queue01.remove());//3 bastaki elemanı siler ve return eder
        System.out.println(queue01.poll());//4 bastaki elemanı siler ve return eder
        System.out.println(queue01.poll());//5 bastaki elemanı siler ve return eder
        System.out.println(queue01.poll());//null bastaki elemanı siler ve return eder
        //System.out.println(queue01.remove());//errorolmayan elemanı cıkarmaya calısıyoruz

    }
}

//Queue Interface
//Collection interfacesinden türetilmiştir.
// Ilk giren ilk çıkar mantığı ile çalışır.
// Priority queue ise biraz farklıdır. Burada elemanlar önceliğe göre sıralanır, en küçük değeri olan kuyruğun başına geçer.
//Kuyruğun başı ve sonu vardır. Elemanlar sona eklenir, baş taraftan çıkartılır.
//Kuyruğun ortasına bir eleman eklenmez.
//Burada null değerlere izin verilmez. Aynı elemanlar eklenebilir. Liste gibi
//random access erişim yoktur.
//poll metotu ile elemanı kuyruktan çıkarırız, eleman yoksa null değer döner.
//remove metotu da kullanılabilir, yalnız eleman yoksa hata alırız.
//peek ile en baştaki elemanı görebiliriz eğer eleman yoksa null değer döner.
//element metotu da kullanılabilir, yalnız eleman yoksa hata alırız.
//offer ile kuyruğun sonuna eleman eklenir eğer başarılı olunmazsa null değer
//döner, add ile de ekleyebilirz yalnız başarısız durumda hata alırız.
