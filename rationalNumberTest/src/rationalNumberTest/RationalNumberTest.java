package rationalNumberTest;

import rationalnumber.RationalNumbers;

public class RationalNumberTest
{
    public static void main(String[] args)
    {
        RationalNumbers rationalNumbers=new RationalNumbers(1,2);
        RationalNumbers rationalNumbers2=new RationalNumbers(1,3);
        RationalNumbers sum=rationalNumbers.add(rationalNumbers2);
        System.out.println(sum);

    }
}
