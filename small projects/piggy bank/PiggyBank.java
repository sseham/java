/**
 * Project name: Piggy Bank
 * Programmer: Seham Ahmed
 * Date: 3/6/2020
 * Description: Creating a software that will assist children in totaling the
 * amount of coins in their piggy banks
 **/
package piggybank;

import java.text.*;
import java.util.Scanner;

public class PiggyBank {

    public static void main(String[] args) {
    //initiallizing variables
        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        DecimalFormat twoDigit = new DecimalFormat("$0.00");
        
        String firstName, lastName;
        int toonies, loonies, quarters, dimes, nickels, pennies, weeks;
        double toonieAmnt, loonieAmnt, quarterAmnt, dimeAmnt, nickelAmnt,
                pennyAmnt, total, avPYear, avPWeek;
        
        //title
        System.out.println("P I G G Y  B A N K!");
        
        //asking user for coin input and processing amount of money
        System.out.println("Before we begin, please insert your first and last"
                + " name. (first name, hit enter and then last name.)");
        firstName = scanS.nextLine();
        lastName = scanS.nextLine();
        
        System.out.println("Please insert the amount of TOONIES and"
                + " LOONIES you have. (Toonies first and then loonies).");
        toonies = scanN.nextInt();
        loonies = scanN.nextInt();
        toonieAmnt = toonies*2.00;
        loonieAmnt = loonies*1.00;
        
        System.out.println("Next, please insert the amount of QUARTERS and"
                + " DIMES you have. (Quarters first and then dimes).");
        quarters = scanN.nextInt();
        dimes = scanN.nextInt();
        quarterAmnt = quarters*0.25;
        dimeAmnt = dimes*0.1;
        
        System.out.println("Finally, insert the amount of NICKELS and PENNIES"
                + "you have. (Nickels first and then pennies).");
          nickels = scanN.nextInt();
          pennies = scanN.nextInt();
          nickelAmnt = nickels*0.05;
          pennyAmnt = pennies*0.01;
        
          System.out.println("How many weeks have you been saving these"
                  + " coins?");
          weeks = scanN.nextInt();
          
          //output table of user data
          System.out.format("%-16s %-2s %-16s %-2s %-16s %-2s", "Name of coin",
                   "|", "Amount of coins", "|", "Money of coins", "|");
          System.out.println("\n-------------------------------------------"
                  + "--------------------");
          System.out.format("%-16s %-2s %-16s %-2s %-16s %-2s", "Toonies", "|"
                  , toonies, "|", twoDigit.format(toonieAmnt), "|");
          System.out.format("\n%-16s %-2s %-16s %-2s %-16s %-2s", "Loonies"
                   , "|", loonies, "|", twoDigit.format(loonieAmnt), "|");
          System.out.format("\n%-16s %-2s %-16s %-2s %-16s %-2s", "Quarters"
                    , "|", quarters, "|", twoDigit.format(quarterAmnt), "|");
          System.out.format("\n%-16s %-2s %-16s %-2s %-16s %-2s", "Dimes",
                   "|", dimes, "|", twoDigit.format(dimeAmnt), "|");
          System.out.format("\n%-16s %-2s %-16s %-2s %-16s %-2s", "Nickels"
                     , "|", nickels, "|", twoDigit.format(nickelAmnt), "|");
          System.out.format("\n%-16s %-2s %-16s %-2s %-16s %-2s", "Pennies",
                    "|", pennies, "|", twoDigit.format(pennyAmnt), "|");
          
          //process of users total amount of money
          total = toonieAmnt+loonieAmnt+quarterAmnt+dimeAmnt+nickelAmnt
                  +pennyAmnt;
          System.out.println(total);
          //process of average amount saved per week and year
          avPWeek = total/weeks;
          avPYear = avPWeek*52;
      
          //outputting users results
          System.out.println(firstName.charAt(0) + ", " + lastName + " at this"
                  + " rate you can save " + twoDigit.format(avPYear)
                  + " in one year.");
    }
    
}
