/**
 * Project name: Slots
 * Programmer: Seham Ahmed
 * Date: 10/20/2020
 * Description: a program that simulates a slot machine using file info
 * */
package slots;

import java.text.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Slots {

    public static void main(String[] args) throws IOException throws {
        //calls upon the menu method
        menu();
    }

    /**
     * method name: menu 
     * description: this method displays the user menu
     **/
    public static void menu() throws IOException {
        //initializing variables ans scanners
        Scanner scanS = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);

        String line, name, cUser;
        int ans, choice;
        int i = 1;
        int l = 0;
        String[] user = new String[10];
        String[] info = new String[20];
        int[] token = new int[10];

        File myFile = new File("D:\\netbeansfiles\\SlotScores.txt");
        Scanner readFile = new Scanner(myFile);

        //runs until the file has no more lines to be read
        while (readFile.hasNextLine()) {
            line = readFile.nextLine();
            info = line.split(", ");
            // makes user&token i in the array equal to the data read from file
            user[i - 1] = info[0];
            token[i - 1] = Integer.parseInt(info[1]);
            i++;
        }

        //menu asking if player is new or returning
        System.out.println("Welcome! Are you a:\n1) New Player\n2) Returning "
                + "Player");
        ans = scanN.nextInt();
        if (ans == 1) {
            System.out.println("Hi! What is your name?");
            name = scanS.nextLine();

            //checks for open spots in the array and places new user there
            for (int j = 0; j < user.length; j++) {
                if (user[j] == null) {
                    user[j] = name;
                    token[j] = 0;
                    break;
                }
                l++;
            }
            //calls upon the game method
            token[l] = game(name, 0);
            //calls upon the update method
            update(user, token);
        }

        if (ans == 2) {
            System.out.println("Welcome back! Please choose your user 1-10:");
            //checks if the spot is taken or not and displays proper menu
            for (int j = 0; j < user.length; j++) {
                if (user[j] != null && !user[j].equalsIgnoreCase("null")) {
                    System.out.println(j + 1 + ") " + user[j]);
                } else if (user[j] == null
                        || user[j].equalsIgnoreCase("null")) {
                    user[j] = "Empty";
                    System.out.println(j + 1 + ") Empty");
                }
            }

            //asking for the user they would like to return as
            choice = scanN.nextInt();
            if (choice > 10 || choice < 1) {
                System.out.println("This isn't a valid option!");
                menu();
            }

            switch (choice) {
                case 1:
                    //call upon the game method
                    token[0] = game(user[0], token[0]);
                    //call upon the update method
                    update(user, token);
                    break;
                case 2:
                    //calls upon the game method
                    token[1] = game(user[1], token[1]);
                    //calls upon the update method
                    update(user, token);
                    break;
                case 3:
                    token[2] = game(user[2], token[2]);
                    update(user, token);
                    break;
                case 4:
                    token[3] = game(user[3], token[3]);
                    update(user, token);
                    break;
                case 5:
                    token[4] = game(user[4], token[4]);
                    update(user, token);
                    break;
                case 6:
                    //continues to game method if there is a player in the spot
                    //if not then it turns user back to menu again
                    cUser = user[5];
                    if (cUser == null || cUser.equalsIgnoreCase("empty")) {
                        System.out.println("This spot has not been used yet!");
                        menu();
                        break;
                    } else {
                        token[5] = game(user[5], token[5]);
                        update(user, token);
                        break;
                    }
                case 7:
                    //continues to game method if there is a player in the spot
                    //if not then it turns user back to menu again
                    cUser = user[6];
                    if (cUser == null || cUser.equalsIgnoreCase("empty")) {
                        System.out.println("This spot has not been used yet!");
                        menu();
                        break;
                    } else {
                        token[6] = game(user[6], token[6]);
                        update(user, token);
                        break;
                    }
                case 8:
                    //continues to game method if there is a player in the spot
                    //if not then it turns user back to menu again
                    cUser = user[7];
                    if (cUser == null || cUser.equalsIgnoreCase("empty")) {
                        System.out.println("This spot has not been used yet!");
                        menu();
                        break;
                    } else {
                        token[7] = game(user[7], token[7]);
                        update(user, token);
                        break;
                    }
                case 9:
                    cUser = user[8];
                    if (cUser == null || cUser.equalsIgnoreCase("empty")) {
                        System.out.println("This spot has not been used yet!");
                        menu();
                        break;
                    } else {
                        token[8] = game(user[8], token[8]);
                        update(user, token);
                        break;
                    }
                case 10:
                    cUser = user[9];
                    if (cUser == null || cUser.equalsIgnoreCase("empty")) {
                        System.out.println("This spot has not been used yet!");
                        menu();
                        break;
                    } else {
                        token[9] = game(user[9], token[9]);
                        update(user, token);
                        break;
                    }
            }
        }
    }

    /**
     * method name: game 
     * description: this method introducing and runs the game
     * @param name - the name of the user
     * @param - tokens - the tokens of the user
     * @return tokens - the new token amnt for user
     **/
    public static int game(String name, int tokens) {
        //initializing variables ans scanners
        Scanner scanS = new Scanner(System.in);
        Random r = new Random();

        String[] slot = {"Cherries", "Oranges", "Plums", "Bells", "Melons",
            "Bars"};
        int count = 0;
        int won2, won3, mtotwon, spent;
        String ans;
        ans = "x";
        mtotwon = 0;
        spent = 0;

        System.out.println("Welcome to the S L O T  M A C H I N E "
                + name + "!");
        //asking if user wants to continue
        System.out.println("It cost 10 tokens to spin, however you may"
                + " still spin if you have 0 tokens.\nYou have " + tokens
                + " tokens. The first spin is free! Type 'QUIT' to exit!");

        //do while loop that runs until you type quit
        while(!ans.equalsIgnoreCase("quit")) {
            //will output 3 random words from the array
            int randSlot = r.nextInt(slot.length);
            int randSlot2 = r.nextInt(slot.length);
            int randSlot3 = r.nextInt(slot.length);

            //asking for user input
            ans = scanS.nextLine();
            if (count > 1) {
                tokens -= 10; //subtracting 10 tokens bc it costs 10 to play
                if (tokens < 0) //checks if tokens go in the negatives
                {
                    tokens = 0;
                } else {
                    //counts num tokens spent (not included if 0 spent)
                    spent += 10;
                }
            } else if (count == 1) {
                tokens -= 0;
            }
            spent += 0;

            //displaying the 3 random words chosen
            System.out.println(slot[randSlot] + " + " + slot[randSlot2] + " + "
                    + slot[randSlot3]);

            //if no words match...
            if (randSlot != randSlot2 && randSlot != randSlot3
                    && randSlot2 != randSlot3) {

                //lets user know how much they won
                System.out.println("\nYou have won 0 tokens."
                        + " Better luck next time!");
                System.out.println("Would you like to play again? You have "
                        + "" + tokens + " tokens. Type 'QUIT' "
                        + "to exit!");
                count++;

                //if two words match...
            } else if ((randSlot == randSlot2 && randSlot2 != randSlot3
                    || randSlot == randSlot3 && randSlot != randSlot2
                    || randSlot3 == randSlot2 && randSlot != randSlot3)) {
                won2 = 20;
                mtotwon += won2;
                tokens += won2;

                //lets user know how much they won
                System.out.println("\nYou have won " + won2
                        + " tokens. Congrats!");
                System.out.println("Would you like to play again? You have "
                        + tokens + " tokens. Type 'QUIT' to exit!");
                count++;

                //if all the words match...
            } else if (randSlot == randSlot2 && randSlot == randSlot3) {
                won3 = 100;
                mtotwon += won3;
                tokens += won3;

                //lets user know how much they won
                System.out.println("\nCongrats! You have won " + won3
                        + " tokens!");
                System.out.println("Would you like to play again? You have "
                        + tokens + " tokens. Type 'QUIT' to exit!");
                count++;
            }
        } 
        //lets user know # of plays, # coins won and # coins spent
        System.out.println("\nCongratulations! You have played " + count
                + " times and have won " + mtotwon + " tokens!\nBut..."
                + " You spent " + spent + " tokens for a total earning "
                + "of " + (mtotwon - spent) + " tokens!");

        //returning the user tokens back to main
        return tokens;
    }

    /**
     * method name: intro 
     * description: this method updates the data in the text file
     * @param user[] - an array with all the updated user info
     * @param token[] - an array with all the updated token info
     **/
    public static void update(String[] user, int[] token) throws IOException {
        //initializing objects
        //will replace the data in the file instead of writing underneath
        FileWriter fWriter = new FileWriter("D:\\netbeansfiles\\"
                + "SlotScores.txt", false);
        PrintWriter outputFile = new PrintWriter(fWriter);

        //for loop to rewrite all updated user info
        for (int i = 0; i < user.length; i++) {
            outputFile.println(user[i] + ", " + token[i]);
        }
        //close the file editor
        outputFile.close();
    }
}
