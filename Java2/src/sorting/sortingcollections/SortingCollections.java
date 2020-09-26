package sorting.sortingcollections;

import java.util.*;

public class SortingCollections {

    public static void main(String[] args) {

        //String class and Wrapper classes implement the Comparable interface.
        // So if you store the objects of string or wrapper classes,
        // it will be Comparable.

        ArrayList<String> al=new ArrayList<String>();
        al.add("Viru");
        al.add("Saurav");
        al.add("Mukesh");
        al.add("Tahir");

        System.out.println("*********Example to sort string objects**********");
        sortAndPrint(al);

        System.out.println("*********Example to sort string objects in reverse order**********");
        sortReverseAndPrint(al,Collections.reverseOrder());


        System.out.println("*********Example to sort Wrapper class objects**********");
        ArrayList al2=new ArrayList();
        al2.add(Integer.valueOf("201"));//String is converted in Integer
        al2.add(Integer.valueOf(101));//Integer is converted in String
        al2.add(230);//internally will be converted into objects as Integer.valueOf(230)

        sortAndPrint(al2);



        System.out.println("*********Example to sort user-defined class objects**********");
        class Student implements Comparable<Student> //Local Class
        {
            public String name;
            public Student(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Student{" + "name='" + name + '\'' + '}';
            }

            public int compareTo(Student person) {
                return name.compareTo(person.name);
            }
        }

        ArrayList<Student> al3=new ArrayList<Student>();
        al3.add(new Student("Viru"));
        al3.add(new Student("Saurav"));
        al3.add(new Student("Mukesh"));
        al3.add(new Student("Tahir"));

        sortAndPrint(al3);
        //Student{name='Mukesh'}
        //Student{name='Saurav'}
        //Student{name='Tahir'}
        //Student{name='Viru'}


    }

    public static void sortAndPrint(List list)
    {
        Collections.sort(list);

        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    public static void sortReverseAndPrint(List list, Comparator c)
    {
        Collections.sort(list,c);

        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

