package collections.lists;

import java.util.*;

public class ArrayLists {

    //public class ArrayList<E> extends AbstractList<E>
    //        implements List<E>, RandomAccess, Cloneable, java.io.Serializable

    public static void main(String[] args) {


        ArrayList<Integer> numbers=new ArrayList<>();//Default Capacity:10
        numbers.add(1);

        ArrayList<String> names=new ArrayList<>(20);//Amount of capacity
        names.add("Emre");

        ArrayList<String> nameSpare=new ArrayList<>(names);//names ArrayList'i buraya kopyalandı
        System.out.println(nameSpare);//[Emre]

        System.out.println(names.equals(nameSpare));//true - equals() methodu overrided ediliyor
        System.out.println(names==nameSpare);//false - reference numbers are different because these arrays are different

        //ensureCapacity()
        names.ensureCapacity(100);//100 - It increased the the capacity of the list to 100.

        //trimToSize()
        names.trimToSize();//1 - It decrease to capacity to the number of elements in the list

        //size()
        System.out.println(names.size());//1 - check the number of elements in the list

        //setSize() methodu yok Vektorde var ama

        //isEmpty()
        System.out.println(names.isEmpty());//false - if it has no element,ıt return true, otherwise false

        //clear()
        names.clear();//deletes all elements in the list
        System.out.println(names+" "+names.size());//[] 0

        //contains()
        System.out.println(nameSpare.contains("Emre"));//true - If the list contains this String returns true

        List<Integer> numbers02=new ArrayList<>();
        numbers02.add(1);
        numbers02.add(2);
        numbers02.add(3);
        numbers02.add(4);
        System.out.println(numbers02);//[1, 2, 3, 4]

        List<Integer> subListOfNumbers=numbers02.subList(0,2);
        System.out.println(subListOfNumbers);//[1, 2]
        subListOfNumbers.add(8);subListOfNumbers.add(9);
        System.out.println(subListOfNumbers);//[1, 2, 8, 9]
        System.out.println(numbers02);//[1, 2, 8, 9, 3, 4]

        numbers02.set(2,7);
        System.out.println(numbers02);//[1, 2, 7, 9, 3, 4]
        System.out.println(subListOfNumbers);//[1, 2, 7, 9]



        //hashCode()
        ArrayList<String>nameArrayList=new ArrayList<>();
        nameArrayList.add("emre");
        List<String>name02=new ArrayList<>();
        name02.add("emre");
        System.out.println(nameArrayList.hashCode()==name02.hashCode());//true

        //add() - add(index,dataType);
        ArrayList fruitList = new ArrayList();
        fruitList.add("mango");
        fruitList.add("pineapple");
        fruitList.add("coconut");
        fruitList.add(1);
        fruitList.add('a');
        fruitList.add(false);
        fruitList.add(1.0);
        System.out.println(fruitList);//[mango, pineapple, coconut, 1, a, false, 1.0]
        fruitList.add(1,"APPLE");//ADDED IN 1.INDEX
        System.out.println(fruitList);//[mango, APPLE, pineapple, coconut, 1, a, false, 1.0]

        //set();
        fruitList.set(0, "mangoooo");
        System.out.println(fruitList);//[mangoooo, APPLE, pineapple, coconut, 1, a, false, 1.0]

        //remove() - remove(index);
        fruitList.remove("pineapple");
        fruitList.remove(2);
        System.out.println(fruitList);//[mangoooo, APPLE, 1, a, false, 1.0]



        ArrayList<Integer> integers =new ArrayList<>(1);//1 olsada artırabilirim
        integers.add(0);//0
        integers.add(1);//1
        integers.add(2,10);//the code below make 10 be third position
        integers.add(2,20);//put 20 into second position
        //integers.add(5,20);//compile error

        //1.element: 0
        //2.element: 1
        //3.element: 20
        //4.element: 10

        /*
        //sonsuza kadar data girebilirsin.
        Scanner scan= new Scanner(System.in);
        for(int i=0;i<integers.size();i++)
        {
            int a=scan.nextInt();
            integers.add(a);
            if(i==3){ break;}
        }
        for(int i=0;i<integers.size();i++)//size();
        {
            System.out.printf("%d.element: %s %n",i+1,integers.get(i));//get();
        }

        for (Integer i : integers)
            System.out.println("Number = " + i);

        //Collections.sort(List);
        Collections.sort(integers);
        System.out.println(integers);//[0, 1, 1, 2, 3, 4, 10, 20]
        */

        //list1.addAll(List);
        fruitList.clear();
        fruitList.add("apple");//[apple]
        fruitList.addAll(integers);
        System.out.println("fruitList:"+fruitList);//fruitList:[apple, 0, 1, 1, 1, 1, 1, 10, 20]
        fruitList.addAll(fruitList);
        System.out.println("fruitList:"+fruitList);//fruitList:[apple, 0, 1, 1, 1, 1, 1, 10, 20, apple, 0, 1, 1, 1, 1, 1, 10, 20]


        //addAll(index(fromPoint),List);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);list3.add(7);
        System.out.println(list3);//[6, 7]

        List<Integer> list4 = new ArrayList<>();
        list4.add(1);list4.add(2);list4.add(3);
        System.out.println(list4);//[1, 2, 3]

        list4.addAll(1, list3); //index 1 den itibaren ekler
        System.out.println(list4);//[1, 6, 7, 2, 3]


        ArrayList<String> groups =new ArrayList<String>();//suan degersiz bir list
        groups.add("metallica");//0
        groups.add("manga");//1
        groups.add("PUBG");//2
        //groups.add(0)="emre"; error
        groups.set(0,"0");

        //indexOf(); - get();
        System.out.printf("%d. index:%s %n ",groups.indexOf("0"),groups.get(0));//0. index:0
        System.out.println("1. index: "+ groups.get(1));// 1. index: manga
        System.out.println("2. index: "+ groups.get(2));//2. index: PUBG
        System.out.println("arraylist size:"+groups.size());//arraylist size:3

        //remove(Object) - remove(String)
        boolean w1=groups.remove("metallica");//false
        boolean w2=groups.remove(groups.get(0));//true
        String w3=groups.remove(0);//manga
        System.out.println("w1:"+w1 +"\nw2:"+w2 + "\nw3:"+w3);



        //equals();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        System.out.println(list1.equals(list2));//true
        list1.add("A");
        list1.add("B");
        System.out.println(list1.equals(list2));//false
        list2=list1;
        System.out.println(list1==list2);//true
        System.out.println(list2);//[A, B]
        list1.add("C");
        System.out.println(list2);//[A, B ,C ]


        //list2.toArray() methodu list'i array'e cevirmek icin kullanilir.
        String[] SArray =list2.toArray( new String[4] );// new String[0] desem de olur
        System.out.println(SArray);           //[Ljava.lang.String;@675d3402
        System.out.println(SArray.toString());//[Ljava.lang.String;@675d3402
        System.out.println(Arrays.toString(SArray));//[[A, B, C, null]

        //2. Yontem: Olusturdugunuz array'in data type'ini Object olarak secin
        //Object class, Java'da butun class'larin parent'idir.Yani Object class ortak atadir.
        //Object class, Java'da parent'i olmayan tek class'dir.
        //String, Object class'in child'i oldugundan data type olarak bazi durumlarda
        //String yerine Object kullaniriz.
        Object arr1[] = list2.toArray();
        System.out.println("arr1:"+Arrays.toString(arr1));//arr1:[A, B, C]

        //Arrays.asList() methodu array'leri list'e cevirmek icin kullanilir.
        //Arrays.asList() methodu parametre olarak array'in ismini kabul eder.
        //Create an ArrayList from an array - Arrays.asList();
        String[] stringArray = { "a", "b", "c", "d", "e" };
        System.out.println(Arrays.asList(stringArray));//[a, b, c, d, e]
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArray));
        System.out.println(arrayList);// [a, b, c, d, e]

        // Arrays.asList(Array).contains("a");
        boolean b = Arrays.asList(stringArray).contains("a");
        System.out.println(b);//// true

        //Collections.addAll(List,Array);
        List <Object> list01=new ArrayList<>();
        Collections.addAll(list01,stringArray);//Array elemanlarını List'e atar
        System.out.println("list01:"+list01);




    }

}
