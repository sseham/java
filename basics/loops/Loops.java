package loops;
import java.util.Scanner;
public class Loops {
    
    public static void main(String[] args) {
        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        int num;
        
        System.out.println("please insert a number...");
        num = scanN.nextInt();
        
        while(num<100){
            System.out.println(num);
            num=num*10;
        }
   
        int num,num2,num3;
        String choice;
        
        do{
            System.out.println("please enter two numbers (number one, enter,"
                + " number two)");
            num = scanN.nextInt();
            num2 = scanN.nextInt();
            num3=num+num2;
            System.out.println("the sum of your two numbers is " + num3 + "\n"
                    + "would you like to continue?(yes or no)");
            choice = scanS.nextLine();
        }
            while(choice.equalsIgnoreCase("yes"));
                System.out.println("leaving program...");

        for (int i = 0; i <= 1000; i+=10) 
            System.out.println(i);

        for (int i = 0; i < 8; i++) {
           System.out.print("*");
             for (int j = i; j < 7; j++) {
               System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < 7; i++) {
            System.out.print("#");
                    for (int j = i ; j > 0 ;j--){
                        System.out.print(" ");
                    }
                    System.out.print("#\n");
        }
    }   
}
