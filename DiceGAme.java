import java.util.Random;
import java.util.Scanner;

public class DiceGAme {
    public void output(char[][] arr)
    {
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public static void main(String[] args)
    {
        char[][] arr=new char[10][10];
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                arr[i][j]='0';
            }
        }
        DiceGAme obj=new DiceGAme();
        obj.output(arr);

        String dice;
        Scanner s=new Scanner(System.in);
        System.out.println("Click the space bar to roll the dice");
        dice=s.nextLine();
        int randomNo=0;

        if(dice.charAt(0)==' ')
        {
            int count=0, num=0;
            boolean flag=false;
            Random random = new Random();

            randomNo = random.nextInt(6)+1;
            System.out.println("Dice number: "+randomNo);
            arr[0][randomNo-1]='x';
            obj.output(arr);
            count+=randomNo;
            while(count!=81)
            {
                System.out.println("Click the space bar to roll the dice");
                dice=s.nextLine();

               if(dice.charAt(0)==' ')
               {
                   randomNo = random.nextInt(6)+1;
                   System.out.println("Dice number: "+randomNo);
                   count+=randomNo;
                   flag=false;
                   for(int i=0;i<10;i++)
                   {
                       for(int j=0;j<10;j++)
                       {
                           if(arr[i][j]=='x')
                           {
                               if(i==9&&j+randomNo>9)
                               {
                                   System.out.println("Try again");
                                   flag=true;
                                   break;
                               }

                               if(j+randomNo<=9)
                               {
                                   arr[i][j]='0';
                                   arr[i][j+randomNo]='x';
                                   obj.output(arr);
                                   flag=true;
                                   break;
                               }
                               else if(j+randomNo>9)
                               {
                                   num=(j+randomNo)-9;
                                   arr[i][j]='0';
                                   j=num-1;
                                   arr[i+1][j]='x';
                                   obj.output(arr);
                                   flag=true;
                                   break;
                               }

                           }

                       }
                       if(flag==true)
                           break;
                   }
               }

            }
        }
    }
}
