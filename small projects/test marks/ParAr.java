/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parar;
import java.util.Scanner;
public class ParAr {
    public static Scanner scanN = new Scanner(System.in);
    public static Scanner scanS = new Scanner(System.in);
    
    public static void main(String[] args) {
        
//        String[] name  = new String[6];
//        int[] test1 = new int[6];
//        int[] test2 = new int[6];
//        int[] testS = new int[6];
//        int[] ave = new int[6];
//        
//        for (int i = 0; i < name.length; i++) {
//            System.out.println("type in the student name, "
//                    + "test one mark, test two mark");
//            name[i] = scanS.nextLine();
//            test1[i] = scanN.nextInt();
//            test2[i] = scanN.nextInt();
//            System.out.println("\t\t" + name[i] + "\t\t" + test1[i] + "\t\t"
//                    + test2[i]);
//        }
//        System.out.println("\n\t\tname\t\ttest 1 mark\t\ttest 2 
//                + "mark\t\taverage\n\t\t-----------------------------------
//                + "------------------------------------");
//        
//        for (int i = 0; i < name.length; i++) {
//            testS[i] = test1[i]+test2[i];
//            ave[i] = testS[i]/2;
//            System.out.println("\t\t" + name[i] + "\t\t" + test1[i] + "\t\t"
//                    + test2[i] + "\t\t" + testS[i] + "\t\t" + ave[i]);
//            
//        }

        int[] num = {2,89,73,14,32,63,10,2,39};
        String choice;
        boolean found;
        
        do {
            found = false;
        
            System.out.println("What number are you looking for?");
            int numm = scanN.nextInt();
            
            for (int i = 0; i < num.length; i++) {
                if (numm==num[i]) {
                    System.out.println("The number is in index " + i);
                    found = true;
            } 
        }
            if (!found)
                System.out.println("That number is not here!");
            System.out.println("Would you like to look for another"
                        + " number? (yes or no)");
            choice = scanS.nextLine();
        }
        while (choice.equalsIgnoreCase("yes"));
    }
}
