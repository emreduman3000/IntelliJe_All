package collections.maps;

import java.util.HashMap;
import java.util.Iterator;

public class HashMap3 {
    public static void main(String[] args) {

        HashMap map=new HashMap();
        map.put("emre",1);
        map.put("fb",2);
        map.put(null,1234);
        map.put("Ea",3);
        map.put("Ea",5);
        System.out.println(map.get("Ea"));

        Iterator iterator=map.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //HashMap has no inherent ordering.
        // If you're looking for insertion order, use a LinkedHashMap.
        // If you're looking for natural order (A-Z, 0-9), use a TreeMap.
        // Use TreeMap for Ascending order
    }
}
