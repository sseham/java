
/*
 draft not completed
 */

package randomm;

import java.util.Scanner;
import java.util.Random;

public class Randomm {

    public static Scanner scanN = new Scanner(System.in);
    public static Scanner scanS = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        String[] name = new String[6];
        
        System.out.println("welcome to the crush calculator :> "
                + "\ntype in 5 names to calculate for...");
        for (int i = 0; i < 5; i++) {
            System.out.println("name " + i + ":");
            name[i]=scanS.nextLine();
        

        String[] crush = {"ricky", "carlos", "shawn", "stefan", "kakashi", 
            "george", "aiden", "issa", "camel", 
            "manu rios", "polo boy", "kelly" };
        String[] crush2 = new String[6];

        System.out.println("alright, finding your crush <3");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);

        System.out.println("found!!!\nuser\t\tcrush<3\n--------"
                + "---------------------");

//      system.out.println("alright, calculating");
        for (int i = 0; i < name.length; i++) {
            int crush1 = (int) (12 * Math.random());
            crush2[i] = crush[crush1];

            if (name[i].equalsIgnoreCase("sam")) {
                System.out.println(name[i] + "\t\t" + "shawn <3");
            } else if (name[i].equalsIgnoreCase("joseph"))
                System.out.println(name[i] + "\t\t" + "sam <3");
            else 
                System.out.println(name[i] + "\t\t" + crush2[i] + "<3");
        }
    }
}
