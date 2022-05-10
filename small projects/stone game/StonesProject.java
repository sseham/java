package stonesproject;

import java.util.Scanner;

public class StonesProject {

    public static void main(String[] args) {

        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        String n1, n2, ans;
        int stones = 15;
        boolean cont = false;
        int pic; //initializing scanners and variables

        System.out.println("Welcom to Stones!\nIn this game there are 15 stones"
                + " in a pile which 2 players will each take turns to "
                + "choose either 1, 2 or 3 stones.\nThe player that selects the"
                + " last stone loses!");
        //informing users about the rules of the game

        System.out.println("Enter your name Player 1: ");
        n1 = scanS.nextLine();
        System.out.println("Enter your name Player 2: ");
        n2 = scanS.nextLine();
        //asking for user input

        System.out.println("Player 1:" + n1 + "\nPlayer 2:" + n2 + "\n...Is "
                + "this correct?");
        ans = scanS.nextLine();

        //if else statement that makes sure the players names are 
        if (ans.equalsIgnoreCase("no")) {
            System.out.println("Oops... Okay!\n Enter your name Player 1: ");
            n1 = scanS.nextLine();
            System.out.println("Enter your name Player 2: ");
            n2 = scanS.nextLine();
        } else {
            System.out.println("Alright! Let's get started!");
        }
        do {
            System.out.println("There's " + stones + " stones in this pile! "
                    + "Player 1, how many stones will you choose? "
                    + "( 1, 2 or 3 stones can be chosen)");
            pic = scanN.nextInt();

            if (pic > 3 && pic < 0) {
                cont = GameCont(stones, pic);
            } else {
                System.out.println("What are you thinking!? You can only choose 1,"
                        + " 2 or 3 stones! Choose properly or else the game WILL"
                        + " end...");
                pic = scanN.nextInt();
                if (pic > 3 || pic < 0) {
                    System.out.println("Dude...");
                } else 
                    cont = GameCont(stones, pic);
                
            }
                //make it repeat for player 2 unless its false then make it say a winner or loser

                System.out.println("There's " + stones + " stones in this pile!"
                        + "Player 2, how many stones will you choose?"
                        + "( 1, 2, or 3 stones can be chosen) ");
                pic = scanN.nextInt();

                if (pic < 3 && pic > 0) {

                } else {
                    System.out.println("What are you thinking!? You can only choose 1,"
                            + " 2 or 3 stones! Choose properly or else the game WILL"
                            + " end...");
                    pic = scanN.nextInt();
                }
                if (pic < 3 || pic > 0) {
                    cont = GameCont(stones, pic);
                } else {
                    System.out.println("I told you the game would end...");
                }
            }
        } while (cont = false);

    }

    public static boolean GameCont(int stones, int pic) {
        int stn = stones - pic;
        boolean cont;
        if (stn > 0) {
            cont = true;
        } else {
            cont = false;
        }

        return cont;
    }
}
