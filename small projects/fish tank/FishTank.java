/**
 * Project name: FishTank
 * Programmer: Seham Ahmed
 * Date: 10/27/20
 * Description: A program that simulates a fish tank
 */
package fishtank;
import java.util.Scanner;
import java.util.Random;
public class FishTank {

    public static void main(String[] args) {
        //initializing variables and objects
        Random r = new Random();
        Fish[] fishes = new Fish[5];
        int r1 = r.nextInt(fishes.length);
        int r2 = r.nextInt(fishes.length);
        
        //loop that makes sure that the two numbers are not the same
        while(r1==r2)
            r2 = r.nextInt(fishes.length);

        System.out.println("Welcome to your fish tank!");
        //for loop to get user data for all the fish in the tank
        for (int i = 0; i < fishes.length; i++) {
            //calls upon the getData method
            fishes[i] = getData();
        }
        //displays users fish tank (states of all fish objects)
        System.out.println("Your fish tank:");
        for (int i = 0; i < fishes.length; i++) {
            System.out.println(fishes[i]);
        }
        //simulates a fight between two random fishes
        System.out.println("\nOh no! " + fishes[r1].getName() + " and " + 
                fishes[r2].getName() + " are fighting!");
        //calls upon the fight method in the class
        fishes[r1].fight(fishes[r2]);
        //tells the user who won the fight (who is alive or not)
        if (fishes[r1].getAlive()==true)
            System.out.println(fishes[r1].getName() + 
                    " has won! Rest in peace " + fishes[r2].getName() + "...");
        else if (!fishes[r1].getAlive())
            System.out.println(fishes[r2].getName() + 
                    " has won! Rest in peace " + fishes[r1].getName() + "...");
        
        //displays updated fish tank
        System.out.println("\nYour fish tank:");
        for (int i = 0; i < fishes.length; i++) {
            System.out.println(fishes[i]);
        }
    }

    /**
     * method name: getData
     * description: gets user input for each fish in the tank
     * @return Fish - a new Fish object that uses the fields user has inputted
     */
    public static Fish getData() {
        //initializing scanners and variables
        Scanner scanS = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);
        String name;
        int size;
        boolean alive;

        //asking for user input on the fish
        System.out.println("What is the name of your fish?");
        name = scanS.nextLine();
        //try catch to make sure user inputs a number
        try {
        System.out.println("What is the size of " + name + " (1-10)");
        size = scanN.nextInt();
        } catch (java.util.InputMismatchException e) {
                System.out.println("This isnt a number! Try again...");
                System.out.println(e);
                String soak = scanN.nextLine();
                size = scanN.nextInt();
        }
        alive = true;
        //checks to see if the size is either too big or too small
        if (size > 10 || size < 1) {
            System.out.println("Your fish cannot be a size bigger than 10 or "
                    + "less than 1!");
            System.out.println("What is the size of your fish? (1-10)");
            size = scanN.nextInt();
        }
        //returns the new fish object back to the array in main
        return new Fish(name, size, alive);
    }
}
