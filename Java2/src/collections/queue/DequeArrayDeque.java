package collections.queue;



import java.util.*;

public class DequeArrayDeque {
    public static void main(String[] args)
    {

        //sıralanmıyor

        //Java Deque Interface is a linear collection that supports element insertion and removal at both ends.
        // Deque is an acronym for "double ended queue".

        //public interface Deque<E> extends Queue<E>

        //The ArrayDeque class provides the facility of using deque and resizable-array.
        // It inherits AbstractCollection class and implements the Deque interface.

        //Unlike Queue, we can add or remove elements from both sides.
        //Null elements are not allowed in the ArrayDeque.
        //ArrayDeque is not thread safe, in the absence of external synchronization.
        //ArrayDeque has no capacity restrictions.
        //ArrayDeque is faster than LinkedList and Stack.

        //public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable


        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Ravi");
        deque.add("Vijay");
        deque.add("Ajay");
        //Traversing elements-bir uctan öbür uca gezmek
        for (String str : deque) {
            System.out.println(str);
            //Ravi
            //Vijay
            //Ajay
        }
        System.out.println(deque);//[Ravi, Vijay, Ajay]


        Deque<String> deque2 = new ArrayDeque<String>();
        deque2.offer("arvind");
        deque2.offer("vimal");
        deque2.add("mukul");//en sona ekler
        deque2.offerFirst("jai");//ilk sıraya yazar
        System.out.println("After offerFirst Traversal...");
        System.out.println(deque2);
        //After offerFirst Traversal...
        //[jai, arvind, vimal, mukul]

        //deque.poll(); -//bastaki elemanı siler ve return eder
        //deque.pollFirst();//it is same as poll()
        deque2.pollLast();//deletes last elemenst
        System.out.println("After pollLast() Traversal...");
        System.out.println(deque2);
        //After pollLast() Traversal...
        //[jai, arvind, vimal]


        Deque<Book> set = new ArrayDeque<Book>();
        //Creating Books
        Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(103, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b3 = new Book(102, "Operating System", "Galvin", "Wiley", 6);
        //Adding Books to Deque
        set.add(b1);
        set.add(b2);
        set.add(b3);
        //Traversing ArrayDeque
        for (Book b : set) {
            System.out.println(b);
            //Book{id=101, name='Let us C', author='Yashwant Kanetkar', publisher='BPB', quantity=8}
            //Book{id=103, name='Data Communications & Networking', author='Forouzan', publisher='Mc Graw Hill', quantity=4}
            //Book{id=102, name='Operating System', author='Galvin', publisher='Wiley', quantity=6}
        }
        System.out.println(set);//[obj1,obj2,obj3] yanyana yazdırır


        Iterator iterator01 = set.iterator();
        while (iterator01.hasNext()) {
            System.out.println(iterator01.next());
            //Book{id=101, name='Let us C', author='Yashwant Kanetkar', publisher='BPB', quantity=8}
            //Book{id=103, name='Data Communications & Networking', author='Forouzan', publisher='Mc Graw Hill', quantity=4}
            //Book{id=102, name='Operating System', author='Galvin', publisher='Wiley', quantity=6}
        }

    }
}



class Book implements Comparable<Book>{
    int id;
    String name, author, publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        if(this.id>o.id){
            return 1;
        }
        else if(this.id<o.id)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}

class IdComparator implements Comparator
{
    public int compare(Object o1,Object o2)
    {
        Book s1=(Book)o1;
        Book s2=(Book)o2;

        if(s1.id==s2.id)
        return 0;
        else if(s1.id>s2.id)
        return 1;
        else
        return -1;
    }
}