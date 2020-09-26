package collections.maps;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap02 {
    public static void main(String[] args) {

        TreeMap<Student2,String> treeMap01=new TreeMap<>();
        Student2 t1=new Student2(1,"kule");
        Student2 t2=new Student2(3,"kule2");
        Student2 t3=new Student2(4,"kule3");
        Student2 t4=new Student2(2,"kule4");
        treeMap01.put(t1,"piyade");
        treeMap01.put(t2,"jandarma");
        treeMap01.put(t3,"hava karacı");
        treeMap01.put(t4,"istihbarat");
        System.out.println(treeMap01);
        //{Student{studentID=1, studentName='kule'}=piyade, Student{studentID=2, studentName='kule4'}=istihbarat, Student{studentID=3, studentName='kule2'}=jandarma, Student{studentID=4, studentName='kule3'}=hava karacı}

        //Comparable INterface i compareTo() methodu calıstı
        for(Map.Entry i: treeMap01.entrySet()){
            System.out.println(i);
        }



        TreeMap<Student2,String> treeMap02=new TreeMap<>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });

        Student2 t11=new Student2(1,"kule");
        Student2 t22=new Student2(3,"kule4");
        Student2 t33=new Student2(4,"kule2");
        Student2 t44=new Student2(2,"kule3");
        treeMap02.put(t11,"piyade");
        treeMap02.put(t22,"jandarma");
        treeMap02.put(t33,"hava karacı");
        treeMap02.put(t44,"istihbarat");
        System.out.println(treeMap02);
        //{Student{studentID=1, studentName='kule'}=piyade, Student{studentID=3, studentName='kule2'}=jandarma, Student{studentID=4, studentName='kule3'}=hava karacı, Student{studentID=2, studentName='kule4'}=istihbarat}

        //Comparator Interface i compare() methodu calısır

        System.out.println(treeMap02.lowerEntry(t44));//1 altını verir
        //Student{studentID=4, studentName='kule2'}=hava karacı

        System.out.println(treeMap02.higherEntry(t33));
        //Student{studentID=2, studentName='kule3'}=istihbarat

        System.out.println(treeMap02.lowerKey(t44));
        //Student{studentID=4, studentName='kule2'}

        System.out.println(treeMap02.higherKey(t33));
        //Student{studentID=2, studentName='kule3'}

        System.out.println(treeMap02.values());
        //[piyade, hava karacı, istihbarat, jandarma]


    }
}




class Student2 implements Comparable<Student2>{
    private int studentID;
    private String studentName;

    public Student2(Integer studentID,String studentName){
        this.studentID=studentID;
        this.studentName=studentName;
    }
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                '}';
    }


    @Override
    public int compareTo(Student2 o) {
        if(this.studentID>o.studentID)
            return 1;
        else if(this.studentID<o.studentID)
            return -1;
        else
            return 0;
    }
}

//Collections.sort(List,new IDComparator())
//Collections.sort(List,new NameComparator())
//yapamayız
//cunku bu treeMap List değil
class IDComparator implements Comparator {

    public int compare(Object o1,Object o2){
        Student s1=(Student)o1;
        Student s2=(Student)o2;

        if(s1.getStudentID()==s2.getStudentID())
            return 0;
        else if(s1.getStudentID()>s2.getStudentID())
            return 1;
        else
            return -1;
    }
}

class NameComparator implements Comparator {

    public int compare(Object o1,Object o2){
        Student s1=(Student)o1;
        Student s2=(Student)o2;
        return s1.getStudentName().compareTo(s2.getStudentName());
    }
}
