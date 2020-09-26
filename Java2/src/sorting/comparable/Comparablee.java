package sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Comparablee {
    //Java Comparable interface is used to order the objects of the user-defined class.
    // This interface is found in java.lang package and contains only one method named compareTo(Object).
    // It provides a single sorting sequence only, i.e., you can sort the elements on the basis of single data member only.
    // For example, it may be rollno, name, age or anything else.


    //public int compareTo(Object obj): It is used to compare the current object with the specified object. It returns
    //positive integer, if the current object is greater than the specified object.
    //negative integer, if the current object is less than the specified object.
    //zero, if the current object is equal to the specified object.
    public static void main(String[] args) {
        System.out.println("******* Comparable interface that sorts the list elements on the basis of age *******");
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student(101,"Vijay",23));
        al.add(new Student(106,"Ajay",27));
        al.add(new Student(105,"Jai",21));
        sortAndPrint(al);

        System.out.println("******* Comparable interface that sorts the list elements on the basis of age in reverse order *******");


    }

    public static void sortAndPrint(List list)
    {
        Collections.sort(list);

        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}


class Student implements Comparable<Student>
{
    int rollno;
    String name;
    int age;

    Student(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int compareTo(Student st){
        if(age==st.age)
            return 0;
        else if(age>st.age)
            return 1;
        else
            return -1;
    }
}
