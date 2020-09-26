package collections.maps;

import java.util.*;

public class LinkedHashMapp {
    public static void main(String[] args) {

        ///public class LinkedHashMap<K,V>
        //    extends HashMap<K,V>
        //    implements Map<K,V>

        // sıralanmıyor

        //Hashmap de elemanların sırası önemli değildir,
        // linkedhashmap de elemanlar eklendikleri sırada tutulur
        // ve son olarak treemap de ise elemanlar sıralı olarak saklanır.

        LinkedHashMap<String,Integer> linkedHashMap01=new LinkedHashMap<>();
        linkedHashMap01.put("emre",1);
        linkedHashMap01.put("duman",2);
        linkedHashMap01.put("commando",3);
        linkedHashMap01.put("emre",4);

        // linkedhashmap de elemanlar eklendikleri sırada tutulur
        System.out.println(linkedHashMap01);//{emre=4, duman=2, commando=3}

        for(String i: linkedHashMap01.keySet()){
            System.out.println(i);
            //emre
            //duman
            //commando
        }
        for(int i: linkedHashMap01.values()){
            System.out.println(i);
            //4
            //2
            //3
        }

        //Map Interface Entry InnerInterface
        for(Map.Entry i: linkedHashMap01.entrySet()){
            System.out.println(i);
            //emre=4
            //duman=2
            //commando=3
        }
        //Map Interface Entry InnerInterface
        for(Map.Entry <String,Integer>i: linkedHashMap01.entrySet()){
            System.out.println(i);
            //emre=4
            //duman=2
            //commando=3
        }

        for(Object i: linkedHashMap01.entrySet()){
            System.out.println(i);
            //emre=4
            //duman=2
            //commando=3
        }

        Iterator iterator01=linkedHashMap01.entrySet().iterator();
        while(iterator01.hasNext()){
            System.out.println(iterator01.next());
            //emre=4
            //duman=2
            //commando=3
        }

        Iterator iterator02=linkedHashMap01.keySet().iterator();
        while(iterator02.hasNext()){
            System.out.println(iterator02.next());
            //emre
            //duman
            //commando
        }
        Iterator iterator03=linkedHashMap01.values().iterator();
        while(iterator03.hasNext()){
            System.out.println(iterator03.next());
            //4
            //2
            //3
        }

    }
}
