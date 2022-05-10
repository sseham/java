/**
 * Project name: Slot Machine 1
 * Programmer: Seham Ahmed
 * Date: 5/11/2020
 * Description: Creating a slot machine
 **/
package slotmachine1;

import java.text.*;
import java.util.Scanner;
import java.util.Random;

public class SlotMachine1 {

    public static void main(String[] args) {
    //setting scanners 
    Scanner scanN = new Scanner(System.in);
    Scanner scanS = new Scanner(System.in);
    DecimalFormat twoDigit = new DecimalFormat("$0.00");
    Random r = new Random();
    
//initializing variables
    String[] slot = {"Cherries", "Oranges", "Plums", "Bells", "Melons", 
        "Bars"};
    int count = 0;
    double moneyin, lost, won2, won3, mtotin, mtotwon;
    String ans;
    ans = "x";
    mtotin=0;
    mtotwon=0;
    
    System.out.println("Welcome to the S L O T  M A C H I N E !");
    
    do { 
        //will output 3 random words from the array
        int randSlot = r.nextInt(slot.length);
        int randSlot2 = r.nextInt(slot.length);
        int randSlot3 = r.nextInt(slot.length);
       
     //asking for user input
        System.out.println("How much money would you like to enter in the Slot"
                + " Machine?");
        moneyin = scanN.nextDouble();
                
        System.out.println("You have entered " + twoDigit.format(moneyin)+ 
                " into the machine!\n\nS p i n n i n g . . .\n\nYou have "
                        + "spun...");
        mtotin += moneyin;
        System.out.println(slot[randSlot] + " + " + slot[randSlot2] + " + " +
                slot[randSlot3]);
        
        if (randSlot!=randSlot2 && randSlot!=randSlot3 && randSlot2!=randSlot3){
            lost = 0;
            System.out.println("You have won " + twoDigit.format(lost) + "."
                    + " Better luck next time!");
            System.out.println("Would you like to play again? Type 'QUIT' to"
                    + " exit!");
            ans = scanS.nextLine();
            count++;
        }
        else if ((randSlot==randSlot2 && randSlot2!=randSlot3 || 
                    randSlot==randSlot3 && randSlot!=randSlot2 || 
                    randSlot3==randSlot2 && randSlot!=randSlot3) ) {
            won2 = moneyin*2;
            mtotwon += won2;
            System.out.println("You have won " + twoDigit.format(won2) + 
                        " Congrats!");
            System.out.println("Would you like to play again? Type 'QUIT' to "
                    + "exit!");
            ans = scanS.nextLine();
            count++;
        }
        else if (randSlot==randSlot2 && randSlot == randSlot3){
            won3 = moneyin*3;
            mtotwon += won3;
            System.out.println("Congrats! You have won" +
                    twoDigit.format(won3));
            System.out.println("Would you like to play again? Type 'QUIT' to "
                    + "exit!");
            ans = scanS.nextLine();
            count++;
        }
    } while (!ans.equalsIgnoreCase("QUIT"));
           System.out.println("Congratulations! You have entered a total of " +
                   twoDigit.format(mtotin) + " into the slow machine. You have"
                   + " played " + count + " times and have won a total "
                   + "of " + twoDigit.format(mtotwon));
        
               
        }
    }
  
    
