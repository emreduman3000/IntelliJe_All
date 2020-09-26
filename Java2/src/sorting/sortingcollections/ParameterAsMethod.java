package sorting.sortingcollections;

public class ParameterAsMethod {

    public static void main(String[] args) {

        System.out.println(new ParameterAsMethod().method(new A().methodA(),new B().methodB()));
        //1
        //2
        //3
    }

    public int method(int a,  int b)
    {
        return a+b;
    }
}

class A
{
    int a=1;
    public A() {
        System.out.println(a);
    }

    int methodA() {
        return a;
    }
}

class B
{
    int b=2;
    public B() {
        System.out.println(b);
    }

    int methodB() {
        return b;
    }
}