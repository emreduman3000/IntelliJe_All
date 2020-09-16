package rationalnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class RationalNumbers implements Comparable<RationalNumbers>
{
    private int share,denominator;//pay payda
    List<RationalNumbers> rationalNumbers=new ArrayList<>();
    Scanner scan;
    int firstRNumber,secondRNumber;


    public RationalNumbers()
    {

    }
    public RationalNumbers(int share, int denominator)
    {
        int ebob=ebobBul(share,denominator);// burada her 2sini de positive yaptım
        this.share=(share/ebob);//sadelestirme
        this.denominator=denominator/ebob;//sadelestirme
    }


    @Override
    public String toString()
    {
        if(this.denominator==0)
            return this.share+"/"+this.denominator+" TANIMSIZDIR!";

        if(share/denominator==0)
        {
            if((share>0 && denominator>0) ||  (share<0 && denominator<0)  )
                return String.valueOf(Math.abs(this.share) + "/" +Math.abs(this.denominator) );
            if((share>0 && denominator<0) ||  (share<0 && denominator>0)  )
                return String.valueOf(this.share + "/" +this.denominator  );
            if(this.share == 0 && this.denominator != 0 )
                return "Result:0";

        }

        if(share/denominator>0)
        {
            if(Math.abs(this.share)> Math.abs(this.denominator) && Math.abs(this.denominator) == 1 )
                return String.valueOf(Math.abs(this.share));

            if(Math.abs(this.share)> Math.abs(this.denominator) && Math.abs(this.denominator) != 1 )
                return String.valueOf(Math.abs(this.share) +"/"+Math.abs(this.denominator));

            if(Math.abs(this.share)== Math.abs(this.denominator) )
                return "Result: 1";



        }

        if(share/denominator<0)
        {

            if(Math.abs(this.share)==Math.abs(this.denominator))
                return "Result:1";
            if(this.denominator==1)
                return String.valueOf(this.share);
            if(this.denominator==-1)
                return String.valueOf(-1*this.share);

            return this.share + "/" + this.denominator ;

        }



        return "";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.share;
        hash = 71 * hash + this.denominator;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {//equals() methodunu kullanan,cagıran nense=this(p1 diyelim), parametre olarak gelen nesneye(p2 diyelim) esitse true yaz
            return true;
        }
        if (obj == null) {//parametre olan nesne null ise false deger
            return false;
        }

        if(!(obj instanceof RationalNumbers))//obj Person2 sınıfın nesnesi ise false deger
            return false;

        RationalNumbers nesne=(RationalNumbers)obj;//DOWNCASTING
        return (denominator==nesne.denominator && share==nesne.share);//equals method in this line is overrided in String Class
    }

    private int ebobBul(int share,int denominator)
    {
        int shareAbsoluteValue=Math.abs(share);//ın case of share is negative
        int denominatorAbsoluteValue=Math.abs(denominator);//ın case of share is negative
        int ebob=1;

        for(int i=1; i<=shareAbsoluteValue && i<=denominatorAbsoluteValue ; i++)
        {
            if(shareAbsoluteValue % i == 0 && denominatorAbsoluteValue % i == 0)//2 sayıyı da tam bölen sayı ebobtur
            {
                ebob=i;
            }
        }

        return ebob;
    }

    public void enterNumbers()
    {
        System.out.print("Please Enter Share and Denominator one by one:\nShare:");
        share=scan.nextInt();System.out.print("Denominator:");
        denominator=scan.nextInt();

        RationalNumbers fraction=new RationalNumbers(share,denominator);
        rationalNumbers.add(fraction);
        System.out.println(fraction);

    }

    public void showRationalNumbers()
    {
        System.out.println(rationalNumbers);
    }

    public void sortedList(List<RationalNumbers> list)
    {
        List<RationalNumbers> sortedList=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            sortedList.add(i, list.get(i));
        }
        Collections.sort(sortedList);
        Collections.sort(sortedList,Collections.reverseOrder());//tamtersi sıralama yaparr
        System.out.println(sortedList);
        System.out.println("size:"+sortedList.size());
    }

    public RationalNumbers add(RationalNumbers number)
    {
        int newShare=(this.share*number.denominator)+(this.denominator*number.share);
        int newDeminator=this.denominator*number.denominator;

        RationalNumbers result=new RationalNumbers(newShare,newDeminator);
        rationalNumbers.add(result);
        return result;
    }
    public RationalNumbers substract(RationalNumbers cikarilacakSayi)
    {
        int newShare=(this.share*cikarilacakSayi.denominator)-(this.denominator*cikarilacakSayi.share);
        int newDeminator=this.denominator*cikarilacakSayi.denominator;

        RationalNumbers result=new RationalNumbers(newShare,newDeminator);
        return result;
    }
    public RationalNumbers multiply(RationalNumbers number)
    {
        int newShare=this.share*number.share;
        int newDeminator=this.denominator*number.denominator;

        RationalNumbers result=new RationalNumbers(newShare,newDeminator);
        return result;
    }
    public RationalNumbers divide(RationalNumbers number)
    {
        int newShare=this.share*number.denominator;
        int newDeminator=this.denominator*number.share;

        RationalNumbers result=new RationalNumbers(newShare,newDeminator);
        return result;
    }

    public void transaction(int i)
    {
        boolean goOn=true;
        while(goOn)
        {
            if(rationalNumbers.size()>=2)
            {
                System.out.println("Total element number of the list is "+rationalNumbers.size()+" .\nWhich elements of list do you want to add?\nSelect first element:");
                int number=scan.nextInt();System.out.println("\nSelect second element:");
                int number2=scan.nextInt();

                if(number>rationalNumbers.size() || number2>rationalNumbers.size())
                {
                    System.out.println("You entered wrong  numbers combination!!!\nIf you want to continue  for the transaction(Press 1)\nto quit(Press 0)");
                    goOn=(scan.nextInt()==1 ? true : false);
                }
                else
                {
                    firstRNumber=number-1;
                    secondRNumber=number2-1;
                    switch(i)
                    {
                        case 1:RationalNumbers addition= rationalNumbers.get(firstRNumber).add(rationalNumbers.get(secondRNumber));
                            System.out.println("Result:"+addition);break;
                        case 2:RationalNumbers substraction= rationalNumbers.get(firstRNumber).substract(rationalNumbers.get(secondRNumber));
                            System.out.println("Result:"+substraction);break;
                        case 3:RationalNumbers multiplication= rationalNumbers.get(firstRNumber).multiply(rationalNumbers.get(secondRNumber));
                            System.out.println("Result:"+multiplication);break;
                        case 4:RationalNumbers division= rationalNumbers.get(firstRNumber).divide(rationalNumbers.get(secondRNumber));
                            System.out.println("Result:"+division);break;
                    }

                    System.out.println("If you want to continue  for another transaction(Press 1)\nto quit(Press 0)");
                    goOn=(scan.nextInt()==1 ? true : false);
                }
            }

            else
            {
                System.out.println("Any list does not exist!!!");
                goOn=false;
            }
        }
    }

    @Override
    public int compareTo(RationalNumbers o) {
        if(this.substract(o).share>0)//1/2 - 2/2 >0 ise kucugu al
            return 1;
        else if(this.substract(o).share<0)
            return -1;//buyugu al
        else
            return 0; //esitse bir aynı bırak

    }


    public void main()
    {
        scan=new Scanner(System.in);
        boolean goON=true;

        while(true)
        {
            System.out.println("-------------------------------------------------\n"
                    + "1. If you want to add a rational number into the list(Press 1)\n"
                    + "2. If you want to display the rational number list(Press 2)\n"
                    + "3. If you want to do transaction with rational numbers from list (Press 3)\n"
                    + "4. If you want to add rational numbers to practice (Press 4)\n"
                    + "5. If you want to display sortedList (Press 5)\n"
                    + "6. If you want to check if 2 numbers are equals to each other (Press 6)\n"
                    + "7. If you want to exit the system (Press 0)");


            switch(scan.nextInt())
            {
                case 0:
                    System.exit(0);break;//to exit

                case 1:
                    goON=true;
                    while(goON)
                    {
                        enterNumbers();
                        System.out.println("Do you wanna go on to enter numbers?(if yes, type true; if no ,type false");
                        goON=scan.nextBoolean();
                    }
                    break;

                case 2:
                    showRationalNumbers(); break;

                case 3:
                    System.out.println("1.For Addition - Press 1\n"
                            + "2.For Substraction - Press 2\n"
                            + "3.For Multiplication - Press 3\n"
                            + "4.For Addition - Press 4");
                    int option=scan.nextInt();

                    if(option>0 && option<5 )
                        transaction(option);
                    else
                        System.out.println("Wrong Transaction!!!");

                    break;

                case 4:
                    RationalNumbers obje=new RationalNumbers(2,4);
                    RationalNumbers obje2=new RationalNumbers(3,4);
                    System.out.println(obje.add(obje2));
                    break;

                case 5:
                    sortedList(rationalNumbers);break;

                case 6:
                    if(rationalNumbers.size()>=2)
                    {
                        System.out.print("Please enter the sequence numbers of both rational numbers\nFirst one:");
                        int first=scan.nextInt()-1;System.out.print("\nSecond one:");
                        int second=scan.nextInt()-1;
                        System.out.println(rationalNumbers.get(first).equals(rationalNumbers.get(second)));
                    }
                    else
                        System.out.println("There is no enough number at the list, Back to main menu, add new numbers to compare them!");

                    break;
                default:
                    System.out.println("Wrong Option!!!");break;
            }
        }
    }
}

