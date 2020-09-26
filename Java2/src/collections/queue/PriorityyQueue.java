package collections.queue;

import java.util.*;

public class PriorityyQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        System.out.println(priorityQueue);//[1, 2, 3] Sıraladı

        PriorityQueue<String> priorityQueue02=new PriorityQueue<>();
        priorityQueue02.offer("A");
        priorityQueue02.offer("C");
        priorityQueue02.offer("B");
        System.out.println(priorityQueue02);//[A, C, B] Sıralamadı
        while (!priorityQueue02.isEmpty())
        {
            System.out.println(priorityQueue02.poll());
            //A
            //B
            //C
            //sıraladı
        }
        //Collections.sort(priorityQueue02);//olmaz sort(List) olmali




        PriorityQueue<Student> s=new PriorityQueue<>(new Comparator<Student>() {//sorting.comparator.Comparator Interface
            @Override
            public int compare(Student o1,Student o2) {
                if(o1.studentID<o2.studentID){
                    return 1;
                }
                else if(o1.studentID>o2.studentID){
                    return -1;
                }
                else
                    return 0;
            }
        });
        s.offer(new Student(1,90));
        s.offer(new Student(2,91));
        s.offer(new Student(3,92));
        s.offer(new Student(4,93));
        s.offer(new Student(5,94));
        System.out.println(s);
        //[Student{studentID=5, examMark=94}, Student{studentID=4, examMark=93}, Student{studentID=2, examMark=91}, Student{studentID=1, examMark=90}, Student{studentID=3, examMark=92}]
        //id ye göre sıraladı ama yanlıs oldu
        while (!s.isEmpty()){
            System.out.println(s.poll());
            //Student{studentID=5, examMark=94}
            //Student{studentID=4, examMark=93}
            //Student{studentID=3, examMark=92}
            //Student{studentID=2, examMark=91}
            //Student{studentID=1, examMark=90}
        }





        PriorityQueue<Student> priorityQueue01=new PriorityQueue<>();
        priorityQueue01.offer(new Student(1,90));
        priorityQueue01.offer(new Student(2,91));
        priorityQueue01.offer(new Student(3,92));
        priorityQueue01.offer(new Student(4,93));
        priorityQueue01.offer(new Student(5,94));
        System.out.println(priorityQueue01);//error because I have to put them order according one of the parameter
       //[Student{studentID=5, examMark=94}, Student{studentID=4, examMark=93}, Student{studentID=2, examMark=91}, Student{studentID=1, examMark=90}, Student{studentID=3, examMark=92}]
       //aynı sekilde for foreach ile de sonuc yanlıs ılabilir
        //Kullansak bile garantisi yok
        //oyuzden while dögüsü kullancz
        while (!priorityQueue01.isEmpty()){
            System.out.println(priorityQueue01.poll());//bastaki elemanı siler ve return eder
        }
        //Student{studentID=5, examMark=94}
        //Student{studentID=4, examMark=93}
        //Student{studentID=3, examMark=92}
        //Student{studentID=2, examMark=91}
        //Student{studentID=1, examMark=90}





        //PriorityQueue Sınıfı
        //Elemanları belli bir sıraya göre saklayan somut sınıftır.Wrapper ve string
        //sınıflar için herhangi bir şey yapmaya gerek yoktur ama kendi sınıflarımızı
        //kullanırken bu sınıfların sorting.comparator.comparable.Comparable interfacesini gerçekleştirmesi gerekir ki
        //java sıralamayı nasıl yapacağını bilebilsin.
        //Eğer string ve wrapperlar için normal sıralama istemiyorsanız bu sınıftan
        //nesne üretirken sorting.comparator interfacesini gerçekleştirerek isteğinizi
        //belirtebilirsiniz.

    }
}

class Student implements Comparable<Student>
{
    public int studentID;
    public int examMark;

    public Student(int studentID,int ExamMark) {
        this.studentID = studentID;
        this.examMark=ExamMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", examMark=" + examMark +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.examMark<o.examMark) {
            return 1;
        }
        else if(this.examMark>o.examMark) {
            return -1;
        }
        else
            return 0;

    }
}
