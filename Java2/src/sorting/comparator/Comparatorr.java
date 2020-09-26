package sorting.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Comparatorr
{
    //ava Comparator interface is used to order the objects of a user-defined class.
    //This interface is found in java.util package and contains 2 methods compare(Object obj1,Object obj2) and equals(Object element).
    //It provides multiple sorting sequences, i.e., you can sort the elements on the basis of any data member, for example, rollno, name, age or anything else.

    //Collections class provides static methods for sorting the elements of a collection.
    // If collection elements are of Set or Map, we can use TreeSet or TreeMap.
    // However, we cannot sort the elements of List.
    // Collections class provides methods for sorting the elements of List type elements also.
    public static void main(String[] args)
    {

        //public void sort(List list, Comparator c): is used to sort the elements of List by the given Comparator.
        ArrayList al=new ArrayList();
        al.add(new Student(101,"Vijay",23));
        al.add(new Student(106,"Ajay",27));
        al.add(new Student(105,"Jai",21));

        System.out.println("Sorting by Name");

        Collections.sort(al,new NameComparator());//name e göre sıralıcak
        Iterator itr=al.iterator();
        while(itr.hasNext()){
            Student st=(Student)itr.next();
            System.out.println(st.rollno+" "+st.name+" "+st.age);
            ///Sorting by Name
            //106 Ajay 27
            //105 Jai 21
            //101 Vijay 23
        }


        System.out.println("Sorting by age");

        Collections.sort(al,new AgeComparator());
        Iterator itr2=al.iterator();
        while(itr2.hasNext()){
            Student st=(Student)itr2.next();
            System.out.println(st.rollno+" "+st.name+" "+st.age);
            //Sorting by age
            //105 Jai 21
            //101 Vijay 23
            //106 Ajay 27
        }

    }
}


class Student{
    int rollno;
    String name;
    int age;
    Student(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }
}

class AgeComparator implements Comparator {
    public int compare(Object o1,Object o2){
        Student s1=(Student)o1;
        Student s2=(Student)o2;

        if(s1.age==s2.age)
            return 0;
        else if(s1.age>s2.age)
            return 1;
        else
            return -1;
    }
}


class NameComparator implements Comparator{
    public int compare(Object o1,Object o2){
        Student s1=(Student)o1;
        Student s2=(Student)o2;

        return s1.name.compareTo(s2.name);
    }
}