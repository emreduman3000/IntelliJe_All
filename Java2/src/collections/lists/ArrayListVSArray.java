package collections.lists;

import java.util.ArrayList;

public class ArrayListVSArray {
    public static void main(String[] args) {

        ArrayList<String> arrayList=new ArrayList<>(9000000);//size:0
        String[] array=new String[9000000];


        long startTime=System.currentTimeMillis();
        for (int i=0;i<array.length;i++)
        {
            arrayList.add("deneme");
        }
        long endTime=System.currentTimeMillis();
        System.out.println("ArrayListDuration:"+(endTime-startTime));


        startTime=System.currentTimeMillis();
        for (int i=0;i<array.length;i++)
        {
            array[i]="deneme";
        }
        endTime=System.currentTimeMillis();
        System.out.println("ArrayDuration:"+(endTime-startTime));

        //ArrayListDuration:129
        //ArrayDuration:102
        //Consequently, ArrayList is slower than Array

        startTime=System.currentTimeMillis();
        array[0]="deneme2";
        endTime=System.currentTimeMillis();
        System.out.println("Array's element changing duration:"+(endTime-startTime));

        startTime=System.currentTimeMillis();
        arrayList.add(0,"deneme2");
        endTime=System.currentTimeMillis();
        System.out.println("ArrayList's element adding duration:"+(endTime-startTime));

        //Array's element changing duration:0
        //ArrayList's element adding duration:656
        //Because every elements of arrayList step forward
        //for array,just first element changed


    }


}


