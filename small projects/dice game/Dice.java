/**
 * Project name: Dice
 * Programmer: Seham Ahmed
 * Date: 9/24/2020
 * Description: a program that allows the user to play different
 * dice games.
 **/
package dice;

import java.util.Scanner;
import java.util.Random;

public class Dice {

    //initiallizing global variables used throughout the program
    public static Scanner scanN = new Scanner(System.in);
    public static Scanner scanS = new Scanner(System.in);
    public static int coins = 10;
    public static int counter = 0;

    public static void main(String[] args) {
        //calls upon the intro method
        String name = intro();
        //calls upon the game method
        game(name);
    }

    /**
     * method name: intro 
     * description: this method introduces the game and asks
     * for user info
     * @return name - the name of the user *
     **/
    public static String intro() {
        //initializing variables
        String name;

        System.out.println("Welcome to the Dice game!\nIn this game there will"
                + " be 3 options of minigames that you can play!");
        System.out.println("To start, what is your name? (first name only)");
        //asking for user input (name)
        name = scanS.nextLine();

        //returning the users name
        return name;
    }

    /**
     * method name: game 
     * description: this method displays the game menu and redirects user to 
     * selected game
     * @param name - the name of the user *
     **/
    public static void game(String name) {

        //try/catch used for interruptedexception (thread.sleep)
        try {
            System.out.println("\nYou currently have " + coins + " coins!\n"
                    + "What game would you like to play " + name + "?");
            System.out.println("\n1. Pig\n2. Gamble\n3. Cho-Han"
                    + "\n4. Exit\n(choose either 1,2,3 or 4.)");
            //taking user input for what game they want to play
            int choice = scanN.nextInt();

            //switch that displays all the games
            switch (choice) {
                case 1:
                    //calls upon the pig method if 1 is chosen
                    pig(name);
                    break;
                case 2:
                    //calls upon the gamble method if 2 is chosen
                    gamble(name);
                    break;
                case 3:
                    //calls upon the choHan method
                    choHan(name);
                    break;
                case 4:
                    //calls upon the exit method if 4 is chosen
                    exit(name);
                    break;
            }
        } catch (InterruptedException e) 
        //try/catch used for interruptedexception (thread.sleep)
        {
        }
    }

    /**
     * method name: pig 
     * description: this method displays the pig game
     * @param name - the name of the user *
     **/
    public static void pig(String name) {
        //initializing variables
        int rolln, rolln2;
        int roll1 = 0;
        int roll2 = 0;
        String roll, choice;
        counter++;

        // telling the user about the game
        System.out.println("\nWelcome to the game 'Pig'. In this game, you"
                + " and an opponenent (AI)\nwill take turns rolling a dice. "
                + "The sum of the roles will get added up\nand you may roll "
                + "as many times as you want to.\nThe goal is to score a "
                + "higher sum than your opponent. However,\nif you roll a 1,"
                + " your score goes down to 0 and your opponent wins."
                + "\nWinner gains 10 coins and loser loses 10 coins, "
                + "if its a tie then both players recieve 10 coins");

        // do while loop that repeats as long as a user rolls 1
        do {
            //random number from 1-6 that acts as a dice
            rolln = (int) (6 * Math.random() + 1);
            roll1 += rolln;

            System.out.println("\nYour turn! Press enter or type in anything"
                    + " to roll the dice!");
            roll = scanS.nextLine();
            //rolls the dice once something is typed

            //if a user rolls a one, prompts the if statement
            if (rolln == 1) {
                System.out.println("Uh oh... You have rolled a 1!!! "
                        + "That means your sum goes down to zero and the"
                        + " AI wins!\nYou have lost 10 coins :("
                        + " better luck next time!");
                //removes the amount of coins lost from the total amount
                coins -= 10;
                //checks if coins are 0 so it doesnt go into the negatives
                if (coins < 0) {
                    coins = 0;
                }
                //sends user back to the game menu after they lost
                game(name);
                break;
            }
            //random number from 1-6 that acts as a dice
            rolln2 = (int) (6 * Math.random() + 1);
            roll2 += rolln2;

            //is AI rolls a one, prompts the if statement 
            if (rolln2 == 1) {
                System.out.println("Uh oh... The AI has rolled a 1!!! "
                        + "That means their sum goes down to zero and you win!"
                        + "\nYou have gained 10 coins! Congrats!");
                //adds winning amount to total coin amount
                coins += 10;
                //sends user back to menu after the game is done
                game(name);
                break;
            }
            //tells user what the user and AI have rolled and their sums
            System.out.println(rolln + " was rolled! You now have a sum of "
                    + roll1);
            System.out.println("The AI has rolled a " + rolln2
                    + "! They now have a sum of " + roll2);
            System.out.println("\nWould you like to keep going? (yes or no)");
            choice = scanS.nextLine();
            //runs until player doesnt want to roll anymore
        } while (choice.equalsIgnoreCase("yes"));

        if (roll1==roll2) {
            System.out.println("It was a tie! Both players have won 10 coins.");
            coins+=10;
            //sends user to menu
            game(name);
        } else if (roll2>roll1) {
            //if user quits and AI has higher sum
            System.out.println("The AI had a higher sum than you! You have lost"
                    + " 10 coins!");
            coins -= 10;
            //checks so user doesnt go into negatives
            if (coins < 0) {
                coins = 0;
            }
            //sends user to menu
            game(name);
        } else if (roll1>roll2) {
            //if user quits and has a higher sum
            System.out.println("Your sum was higher than the AI! You have "
                    + "won 10 coins!");
            coins += 10;
            game(name);
        }
    }

    /**
     * method name: gamble 
     * description: this method displays the gamble game
     * @param name - the name of the user
     **/
    public static void gamble(String name)
            // interruptedexception for thread.sleep
            throws InterruptedException {
        //initializing variables
        int choice, betAm, rollSum, win;
        int rolln = (int) (6 * Math.random() + 1);
        int rolln2 = (int) (6 * Math.random() + 1);
        counter++;

        //tells the user the rules of the game
        System.out.println("Welcome to 'Gamble'!\nIn this game you will"
                + " bet an amount of coins over the sum of two dice! You "
                + "have three options\n\n1. Bet that the sum will be larger"
                + " than 6 (win 2x the bet)\n2. Bet that the sum will be "
                + "even (win 2x the bet)\n3. Bet on the sum being a"
                + " specific number of your choice (win 7x the bet)\nYou "
                + "cannot play if you have no coins! You also cannot bet "
                + "coins that you do not have!\n\nWhat would you like to do?"
                + "(choose 1,2,3 or 4 to go back to the menu!");
        //asks user for their choice
        choice = scanN.nextInt();

        //switch that runs based off of the users choice 
        switch (choice) {
            case 1:
                //if user choses option 1, this will run
                System.out.println("Okay " + name + ", You have chosen to "
                        + "bet that the sum will be\nlarger than 6! "
                        + "How much would you like to bet?");
                //asks for user bet amount
                betAm = scanN.nextInt();
                //checks if user has enough coins to bet
                if (betAm > coins) {
                    System.out.println("You dont have enough coins to bet"
                            + " this amount! Try again!");
                    //sends user back to the menu if funds are not sufficient
                    gamble(name);
                    break;
                }
                //takes out betting amount from total coins
                coins -= betAm;
                rollSum = rolln + rolln2;

                //tells users what numbers were rolled and the sum
                System.out.println("Alright, you have decided to bet "
                        + betAm + " coins! Lets get started!");
                System.out.println("The two numbers rolled were... ");
                Thread.sleep(1000);
                System.out.print(rolln);
                Thread.sleep(1000);
                System.out.print(" and " + rolln2);
                Thread.sleep(1000);
                System.out.println(" The sum is " + rollSum + "!");

                //checks if the sum is greater than 6
                if (rollSum > 6) {
                    //doubling the amount betted as they won
                    win = betAm * 2;
                    System.out.println("\nCongrats " + name + "! The sum was "
                            + "greater than 6! You have won " + win
                            + " coins!");
                    //adding winning coins to total
                    coins += win;
                    //sending user back to manu after game is done
                    game(name);
                    break;
                } else {
                    //if the sum is not greater than 6...
                    System.out.println("\nUh oh... The sum was not greater than"
                            + " 6! You did not win anything this time!");
                    //sends user back to the menu
                    game(name);
                    break;
                }
            case 2:
                //runs when the user choses the 2nd option
                System.out.println("Okay " + name + ", You have chosen to "
                        + "bet that the sum will be even!\n"
                        + "How much would you like to bet?");
                //ask for bet amount
                betAm = scanN.nextInt();
                //checks if funds are sufficient
                if (betAm > coins) {
                    System.out.println("You dont have enough coins to bet"
                            + " this amount! Try again!");
                    gamble(name);
                    break;
                }
                coins -= betAm;
                rollSum = rolln + rolln2;

                //tells user the rolls and sum
                System.out.println("Alright, you have decided to bet "
                        + betAm + " coins! Lets get started!");
                System.out.println("The two numbers rolled were... ");
                Thread.sleep(1000);
                System.out.print(rolln);
                Thread.sleep(1000);
                System.out.print(" and " + rolln2);
                Thread.sleep(1000);
                System.out.println(" The sum is " + rollSum + "!");

                // checks if number is even or not
                if (rollSum % 2 == 0) {
                    win = betAm * 2;
                    System.out.println("\nCongrats " + name + "! The sum was"
                            + " even! You have won " + win
                            + " coins!");
                    coins += win;
                    game(name);
                    break;
                } else {
                    System.out.println("\nUh oh... The sum was not even. "
                            + "You did not win anything this time!");
                    game(name);
                    break;
                }
            case 3:
                //runs if user chose option 3
                //initializing variables
                int guess;

                System.out.println("Okay " + name + ", You have chosen to "
                        + "bet that the sum will be a number of your choice!\n"
                        + "How much will you like to bet?");
                //asking for user input
                betAm = scanN.nextInt();
                //checking for sufficient funds
                if (betAm > coins) {
                    System.out.println("You dont have enough coins to bet"
                            + " this amount! Try again!");
                    gamble(name);
                    break;
                }
                coins -= betAm;
                rollSum = rolln + rolln2;

                System.out.println("\nWhat number do you think the sum will be?"
                        + "(please type an integer value)");
                //asking user for their sum guess
                guess = scanN.nextInt();

                //letting user know the rolls and sum
                System.out.println("Alright, you have decided to bet "
                        + betAm + " coins and have guessed that the sum will "
                        + "be " + guess + " Lets get started!");
                System.out.println("The two numbers rolled were... ");
                Thread.sleep(1000);
                System.out.print(rolln);
                Thread.sleep(1000);
                System.out.print(" and " + rolln2);
                Thread.sleep(1000);
                System.out.println(" The sum is " + rollSum + "!");

                //checks if the users guess was correct or not
                if (rollSum == guess) {
                    win = betAm * 7;
                    System.out.println("\nCongrats " + name + "! The sum you"
                            + " guessed was correct! You should try buying a"
                            + " lottery ticket...\nYou have won " + win
                            + " coins!");
                    coins += win;
                    game(name);
                    break;
                } else {
                    System.out.println("\nUh oh... The sum you guessed was not "
                            + "correct... You did not win anything this time!");
                    game(name);
                    break;
                }
            case 4:
                //runs if user chose 4
                //exits out of the game and sends user to the menu
                game(name);
                break;
        }
    }

    /**
     * method name: choHan 
     * description: this method displays the cho han game
     * @param name - the name of the user 
     **/
    public static void choHan(String name)
            throws InterruptedException {

        //intializing variables
        Random r = new Random();
        String choice;
        int betU;
        int sum = 0;
        int[] roll1 = new int[6];
        int[] roll2 = new int[6];
        int betAI = (int) (25 * Math.random() + 1);
        boolean random = r.nextBoolean();
        String choiceAI;
        counter++;

        //sets string answers to boolean values
        if (random == true) {
            choiceAI = "even";
        } else {
            choiceAI = "odd";
        }

        //tells the game rules
        System.out.println("Welcome to the game Cho-Han! This is a simple but"
                + " popular dice game played in\nJapan that is similar to the"
                + " game 'Gamble'. In this game you will\nbe going against"
                + " an AI. Both of you will roll 6 dice but will not share the"
                + " numbers.\nYou and the AI will BOTH bet if the sum will be "
                + "even or odd.\n(Although you are betting, you will not lose "
                + "any coins but have the chance to gain coins! :))");
        System.out.println("How much would you like to bet?");
        //asks for user bet
        betU = scanN.nextInt();
        //checks if funds are sufficient
        if (betU > coins) {
            System.out.println("You dont have enough coins to bet"
                    + " this amount! Try again!");
            gamble(name);
        }
        System.out.println("You have decided to bet " + betU + " coins "
                + "and the AI has decided to bet " + betAI + " coins! "
                + "Lets get started!");

        System.out.println("\nRolling the dice!");
        //for loop to pick random values for dice rolls
        for (int i = 0; i < roll1.length; i++) {
            roll1[i] = (int) (6 * Math.random() + 1);
            roll2[i] = (int) (6 * Math.random() + 1);
        }
        System.out.println("Would you like to bet that the sum is even or "
                + "odd?");
        //asks for user choice
        choice = scanS.nextLine();
        System.out.println("Alright! You have chosen " + choice
                + " and the AI has chosen " + choiceAI + ".");
        System.out.print("Here are the rolls and the total sum!"
                + "\n\t\tUSER ROLLS\t\tAI ROLLS\n");
        //for loop to display the random dice rolls
        for (int i = 0; i < roll1.length; i++) {
            System.out.println("\t\t" + roll1[i] + "\t\t" + roll2[i]);
            sum += roll1[i] + roll2[i];
        }
        System.out.println("The sum of these rolls is " + sum + "!\n");
        if (sum % 2 == 0 && choice.equalsIgnoreCase("even")
                && random == false) {
            //if sum is even and user guess is correct
            System.out.println("You have guessed correct! You win " + betAI
                    + " coins!");
            coins += betAI;
            game(name);
        } else if (sum % 2 == 0 && random == true
                && choice.equalsIgnoreCase("odd")) {
            //if sum is even and the user guess is wrong
            System.out.println("The AI has guessed correct! You lose!");
            game(name);
        } else if (sum % 2 == 0 && random == true
                && choice.equalsIgnoreCase("even")) {
            //if sum is even and its a tie
            System.out.println("It was a tie! You both can keep your "
                    + "money");
            game(name);
        } else if (sum % 2 > 0 && random == false
                && choice.equalsIgnoreCase("even")) {
            //if sum is odd and user is wrong
            System.out.println("The AI has guessed correct! You lose!");
            game(name);
        } else if (sum % 2 > 0 && random == false
                && choice.equalsIgnoreCase("odd")) {
            //if sum is odd and its a tie
            System.out.println("It was a tie! You both can keep your "
                    + "money!");
            game(name);
        } else if (sum % 2 > 0 && random == true
                && choice.equalsIgnoreCase("odd")) {
            //if sum is odd and user is right
            System.out.println("You have guessed correct! You win " + betAI
                    + " coins!");
            coins += betAI;
            game(name);
        }
    }

    /**
     * method name: exit 
     * description: this method displays the exit statement of the game and 
     * user winnings
     * @param name - the name of the user
     **/
    public static void exit(String name) {
        System.out.println("Congrats " + name + "! You have played " + counter 
                + " minigame(s) and have finished the game with " + coins +
                " coins!");
    }
}
