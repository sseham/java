/**
 * Project name: Culminating
 * Programmer: Seham Ahmed
 * Date: 6/19/2020
 * Description: a program that runs like the jeopardy game
 **/
package culminating;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Culminating {

    public static void main(String[] args) {        
        intro();
        //calls upon the intro method
        player();
        //calls upon the player method
        game();
        //calls upon the game method
        
    }
    public static void intro() {
        System.out.println("Welcome to Jeopardy, a game show hosted by yours"
                + " truly,\nin which contestants are presented with general"
                + " knowledge clues in the form of answers,\nand must phrase"
                + " their responses in the form of questions.\n\n*This game is"
                + " automatically set to single player mode*\n\nLet's begin,"
                + " shall we?");
        System.out.println("\nYou will be given a board with 5 categories to "
                + "choose from! \nEach category will have 5 cards with money "
                + "values on them ranging from $200 to $1000.");
                System.out.println("\nSelect a category, select a card and"
            	+ " answer the question! If you get the answer correct, "
                        + "that money will be added to your prize winnings!");
       }//end of intro method
        public static String player() {
            Scanner scanS = new Scanner(System.in);
            String name, country;
            
            System.out.println("\nBefore we begin, we are going to need to know"
                    + " who is playing with us today. Please enter your first"
                    + " name and your last name");
            name = scanS.nextLine();
            System.out.println("I will also be needing your country! "
                    + "What country do you live in?");
            country = scanS.nextLine();
            System.out.println("Great! Let's get started!");
            return name;
        }//end of player
        
        /*Method name: game
         * this method runs the jeopardy game
         */
        public static void game() {
            Scanner scanN= new Scanner(System.in);
            Scanner scanS= new Scanner(System.in);
            DecimalFormat twoDigit = new DecimalFormat("$0.00");
            double money=0;
            int category;
            String cont;
            
            System.out.println("\t\t\t\t\t*********************************"
                    + "\n\t\t\t\t\t*  WELCOME TO J E O P A R D Y!  *\n\t\t\t\t\t"
                    + "*********************************");
            System.out.format("\t\t\t\t%-6s %-2s %-6s %-2s %-6s %-2s %-6s %-2s"
                    + " %-6s", "ONE", "|", "TWO", "|", "THREE", "|", "FOUR",
                    "|", "FIVE");
            System.out.println("\n\t\t\t\t___________________________________"
                    + "___________");
      System.out.format("\t\t\t\t%-6s %-2s %-6s %-2s %-6s %-2s %-6s %-2s"
                    + " %-6s", "$200", "|", "$200", "|", "$200", "|", "$200",
                    "|", "$200");
       System.out.format("\n\t\t\t\t%-6s %-2s %-6s %-2s %-6s %-2s %-6s %-2s"
                    + " %-6s", "$400", "|", "$400", "|", "$400", "|", "$400",
                    "|", "$400");
        System.out.format("\n\t\t\t\t%-6s %-2s %-6s %-2s %-6s %-2s %-6s %-2s"
                    + " %-6s", "$600", "|", "$600", "|", "$600", "|", "$600",
                    "|", "$600");
         System.out.format("\n\t\t\t\t%-6s %-2s %-6s %-2s %-6s %-2s %-6s %-2s"
                    + " %-6s", "$800", "|", "$800", "|", "$800", "|", "$800",
                    "|", "$800");
          System.out.format("\n\t\t\t\t%-6s %-2s %-6s %-2s %-6s %-2s %-6s %-2s"
                    + " %-6s", "$1000", "|", "$1000", "|", "$1000", "|",
                    "$1000", "|", "$1000");
           System.out.println("\n\t\t\t\t___________________________________"
                    + "___________");
           
           do {
               
           System.out.println("\nHere is your board. Which category do you "
                   + "choose? (1-5) Type 6 to head to your winnings and quit!");
           category = scanN.nextInt();
           
           switch (category) {
               case 1:
                   //calls upon the cat1 method
                   double money1 = cat1();
                   money +=money1;
                   break;
               case 2:
                   //calls upon the cat2 method
                  double money2 = cat2();
                  money+=money2;
                  break;
               case 3:
                   //calls upon the cat3 method
                   double money3 = cat3();
                   money+=money3;
                   break;
               case 4:
                   //calls upon the cat4 method
                   double money4 = cat4();
                   money+=money4;
                   break;
               case 5:
                   //calls upon the cat5 method
                   double money5 = cat5();
                   money+=money5;
                   break;
               case 6:
                   System.out.println("Congrats! You have won a total of " +
                          twoDigit.format(money) + "! Thank you for playing!");
                   break;
           }
           
             System.out.println("Would you like to continue? "
                     + "Type quit to exit!");
                     cont = scanS.nextLine();
           } while (!cont.equalsIgnoreCase("quit")); {
            
            
        }
}       /* method name: cat1
        this method displays the questions in the first category
        @return money1 - the amount of money the user has made in the first
        catergory */
        public static double cat1() {
            Scanner scanN= new Scanner(System.in);
            Scanner scanS= new Scanner(System.in);
            double money1 = 0;
            int moneyAm;
            String ans1, ans2, ans3, ans4, ans5;
            System.out.println("\t\t\t\t\t********\n\t\t\t\t\t* MATH *\n"
                           + "\t\t\t\t\t********\n\t\t\t\t\t  $200\n\t\t\t\t\t"
                           + "  $400\n\t\t\t\t\t  $600\n\t\t\t\t\t  $800"
                           + "\n\t\t\t\t\t  $1000");
                   System.out.println("Choose your money amount (200-1000)");
                   moneyAm = scanN.nextInt();
             
                   if (moneyAm == 200) {
                       System.out.println("You have chosen, $200. "
                               + "Here's your question:\n Which number is the"
                               + " only number that has the same amount of "
                               + "letters as its meaning?\n(type your answer as "
                               + "words, not numbers)");
                       ans1 = scanS.nextLine();
                       if (ans1.equalsIgnoreCase("four")) {
                       System.out.println("You are correct! You gained "
                                   + "$200!");
                       money1 =+ 200;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 400) {
                       System.out.println("You have chosen, $400. "
                               + "Here's your question:\nWhat is the only number"
                               + " to have its letters in alphabetical order?\n"
                               + "(type your answer as words, not numbers)");
                       ans2 = scanS.nextLine();
                       if (ans2.equalsIgnoreCase("fourty")) {
                       System.out.println("You are correct! You gained "
                                   + "$400!");
                       money1 =+ 400;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 600) {
                       System.out.println("You have chosen, $600. "
                               + "Here's your question:\nThe numbers on "
                               + "opposite sides of a dice add up to what"
                               + " number?\n(type your answer as words, not "
                               + "numbers)");
                       ans3 = scanS.nextLine();
                       if (ans3.equalsIgnoreCase("seven")) {
                       System.out.println("You are correct! You gained "
                                   + "$600!");
                       money1 =+ 600;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 800) {
                       System.out.println("You have chosen, $800. "
                               + "Here's your question:\nWhat number would come "
                               + "first if all the numbers are arranged "
                               + "alphabetically?\n(type your answer as words, "
                               + "not numbers)");
                       ans4 = scanS.nextLine();
                       if (ans4.equalsIgnoreCase("eight")) {
                       System.out.println("You are correct! You gained "
                                   + "$800!");
                       money1 =+ 800;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 1000) {
                       System.out.println("You have chosen, $1000. "
                               + "Here's your question:\nWhat is the only"
                               + " number that is twice the sum of its digits"
                               + "\n(type your answer as words,"
                               + " not numbers)");
                       ans5 = scanS.nextLine();
                       if (ans5.equalsIgnoreCase("eighteen")) {
                       System.out.println("You are correct! You gained "
                                   + "$1000!");
                       money1 =+ 1000;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   return money1;
        }
        /* method name: cat2
        this method displays the questions in the second category
        @return money2 - the amount of money the user has made in the second 
        catergory */
        public static double cat2() {
            Scanner scanN= new Scanner(System.in);
            Scanner scanS= new Scanner(System.in);
            double money2 = 0;
            int moneyAm, ans2;
            String ans1, ans3, ans4, ans5;
            
             System.out.println("\t\t\t\t\t***********\n\t\t\t\t\t* "
                           + "HISTORY *\n\t\t\t\t\t***********\n\t\t\t\t\t  "
                           + "$200\n\t\t\t\t\t  $400\n\t\t\t\t\t  $600\n\t\t\t"
                           + "\t\t  $800\n\t\t\t\t\t  $1000");
                   System.out.println("Choose your money amount (200-1000)");
                   moneyAm = scanN.nextInt();
                   
                   if (moneyAm == 200) {
                       System.out.println("You have chosen, $200. "
                               + "Here's your question:\nWhat was the first "
                               + "city to reach a population of one million?");
                       ans1 = scanS.nextLine();
                       if (ans1.equalsIgnoreCase("rome")) {
                       System.out.println("You are correct! You gained "
                                   + "$200!");
                       money2 =+ 200;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 400) {
                       System.out.println("You have chosen, $400. "
                               + "Here's your question:\nHow long did the "
                               + "Hundred Years' War last? (in years)");
                       ans2 = scanN.nextInt();
                       if (ans2 == 116) {
                       System.out.println("You are correct! You gained "
                                   + "$400!");
                       money2 =+ 400;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 600) {
                       System.out.println("You have chosen, $600. "
                               + "Here's your question:\nWho was the first U.S. "
                               + "President to be impeached?");
                       ans3 = scanS.nextLine();
                       if (ans3.equalsIgnoreCase("andrew johnson")) {
                       System.out.println("You are correct! You gained "
                                   + "$600!");
                       money2 =+ 600;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 800) {
                       System.out.println("You have chosen, $800. "
                               + "Here's your question:\nWhich Canadian "
                               + "province was first to grant women the "
                               + "right to vote?");
                       ans4 = scanS.nextLine();
                       if (ans4.equalsIgnoreCase("manitoba")) {
                       System.out.println("You are correct! You gained "
                                   + "$800!");
                       money2 =+ 800;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 1000) {
                       System.out.println("You have chosen, $1000. "
                               + "Here's your question:\nWhich animal’s fur "
                               + "drove the Canadian fur-trade economy?");
                       ans5 = scanS.nextLine();
                       if (ans5.equalsIgnoreCase("beaver")) {
                       System.out.println("You are correct! You gained "
                                   + "$1000!");
                       money2 =+ 1000;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   return money2;
        }
        /* method name: cat3
        this method displays the questions in the third category
        @return money3 - the amount of money the user has made in the third 
        catergory */
        public static double cat3() {
            Scanner scanN= new Scanner(System.in);
            Scanner scanS= new Scanner(System.in);
            double money3 = 0;
            int moneyAm;
            String ans1, ans2, ans3, ans4, ans5;
            
             System.out.println("\t\t\t\t\t************\n\t\t\t\t\t* "
                           + "COMP SCI *\n\t\t\t\t\t************\n\t\t\t\t\t  "
                           + "$200\n\t\t\t\t\t  $400\n\t\t\t\t\t  $600\n\t\t\t"
                           + "\t\t  $800\n\t\t\t\t\t  $1000");
                   System.out.println("Choose your money amount (200-1000)");
                   moneyAm = scanN.nextInt();
                   
                   if (moneyAm == 200) {
                       System.out.println("You have chosen, $200. "
                               + "Here's your question:\n What is the smallest"
                               + "unit in a computers memory?");
                       ans1 = scanS.nextLine();
                       if (ans1.equalsIgnoreCase("bit")) {
                       System.out.println("You are correct! You gained "
                                   + "$200!");
                       money3 =+ 200;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 400) {
                       System.out.println("You have chosen, $400. "
                               + "Here's your question:\nAbout how many bytes"
                               + " are in a terabyte? (answer in words,"
                               + " not numbers)");
                       ans2 = scanS.nextLine();
                       if (ans2.equalsIgnoreCase("one trillion")) {
                       System.out.println("You are correct! You gained "
                                   + "$400!");
                       money3 =+ 400;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 600) {
                       System.out.println("You have chosen, $600. "
                               + "Here's your question:\nWhat is the term for"
                               + " a paper printout of the program code or data"
                               + " displayed on the screen?");
                       ans3 = scanS.nextLine();
                       if (ans3.equalsIgnoreCase("hard copy")) {
                       System.out.println("You are correct! You gained "
                                   + "$600!");
                       money3 =+ 600;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 800) {
                       System.out.println("You have chosen, $800. "
                               + "Here's your question:\nWhat is it called when "
                               + "one uses a capital letter on the first letter"
                               + " of all words but the first to seperate them?"
                               + " (example: 'jeopardyGame'");
                       ans4 = scanS.nextLine();
                       if (ans4.equalsIgnoreCase("camel case")) {
                       System.out.println("You are correct! You gained "
                                   + "$800!");
                       money3 =+ 800;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 1000) {
                       System.out.println("You have chosen, $1000. "
                               + "Here's your question:\nWhat does OOP stand "
                               + "for?");
                       ans5 = scanS.nextLine();
                       if (ans5.equalsIgnoreCase("object oriented programming"))
                       {
                       System.out.println("You are correct! You gained "
                                   + "$1000!");
                       money3 =+ 1000;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   return money3;
        }
        /* method name: cat4
        this method displays the questions in the fourth category
        @return money4 - the amount of money the user has made in the fourth 
        catergory */
        public static double cat4() {
            Scanner scanN= new Scanner(System.in);
            Scanner scanS= new Scanner(System.in);
            double money4 = 0;
            int moneyAm;
            String ans1, ans2, ans3, ans4, ans5;
            
             System.out.println("\t\t\t\t\t***********\n\t\t\t\t\t* "
                           + "ENGLISH *\n\t\t\t\t\t***********\n\t\t\t\t\t  "
                           + "$200\n\t\t\t\t\t  $400\n\t\t\t\t\t  $600\n\t\t\t"
                           + "\t\t  $800\n\t\t\t\t\t  $1000");
                   System.out.println("Choose your money amount (200-1000)");
                   moneyAm = scanN.nextInt();
                   
                   if (moneyAm == 200) {
                       System.out.println("You have chosen, $200. "
                               + "Here's your question:\nWhat is the longest"
                               + " english word that can be spelt without"
                               + " repeating any letters?");
                       ans1 = scanS.nextLine();
                       if (ans1.equalsIgnoreCase("uncopyrightable")) {
                       System.out.println("You are correct! You gained "
                                   + "$200!");
                       money4 =+ 200;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 400) {
                       System.out.println("You have chosen, $400. "
                               + "Here's your question:\nWhat is the most"
                               + "commonly used letter in the english alphabet?"
                               + "");
                       ans2 = scanS.nextLine();
                       if (ans2.equalsIgnoreCase("e")) {
                       System.out.println("You are correct! You gained "
                                   + "$400!");
                       money4 =+ 400;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 600) {
                       System.out.println("You have chosen, $600. "
                               + "Here's your question:\nWhat is the longest"
                               + " word of the alphabet with all letters in"
                               + " alphabetical order?");
                       ans3 = scanS.nextLine();
                       if (ans3.equalsIgnoreCase("almost")) {
                       System.out.println("You are correct! You gained "
                                   + "$600!");
                       money4 =+ 600;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 800) {
                       System.out.println("You have chosen, $800. "
                               + "Here's your question:\nWhat is the term for a"
                               + " sentence that uses every letter of a given"
                               + " alphabet at least once?");
                       ans4 = scanS.nextLine();
                       if (ans4.equalsIgnoreCase("pangram")) {
                       System.out.println("You are correct! You gained "
                                   + "$800!");
                       money4 =+ 800;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 1000) {
                       System.out.println("You have chosen, $1000. "
                               + "Here's your question:\nWhat is the longest "
                               + "word in the english language?");
                       ans5 = scanS.nextLine();
                       if (ans5.equalsIgnoreCase
                       ("pneumonoultramicroscopicsilicovolcanoconiosis")) {
                       System.out.println("You are correct! You gained "
                                   + "$1000!");
                       money4 =+ 1000;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   return money4;
        }
        /* method name: cat5
        this method displays the questions in the fifth category
        @return money5 - the amount of money the user has made in the fifth 
        catergory */
        public static double cat5() {
            Scanner scanN= new Scanner(System.in);
            Scanner scanS= new Scanner(System.in);
            double money5 = 0;
            int moneyAm;
            String ans1, ans2, ans3, ans4, ans5;
            
             System.out.println("\t\t\t\t\t*********************\n\t\t\t\t\t* "
                           + "GENERAL KNOWLEDGE *\n\t\t\t\t\t******************"
                     + "***\n\t\t\t\t\t  $200\n\t\t\t\t\t  $400\n\t\t\t\t\t  "
                     + "$600\n\t\t\t\t\t  $800\n\t\t\t\t\t  $1000");
                   System.out.println("Choose your money amount (200-1000)");
                   moneyAm = scanN.nextInt();
                   
                   if (moneyAm == 200) {
                       System.out.println("You have chosen, $200. "
                               + "Here's your question:\nThe tallest building "
                               + "in the world is located in which city?");
                       ans1 = scanS.nextLine();
                       if (ans1.equalsIgnoreCase("dubai")) {
                       System.out.println("You are correct! You gained "
                                   + "$200!");
                       money5 =+ 200;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 400) {
                       System.out.println("You have chosen, $400. "
                               + "Here's your question:\nWhat currency is used "
                               + "in Mexico?");
                       ans2 = scanS.nextLine();
                       if (ans2.equalsIgnoreCase("pesos")) {
                       System.out.println("You are correct! You gained "
                                   + "$400!");
                       money5 =+ 400;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 600) {
                       System.out.println("You have chosen, $600. "
                               + "Here's your question:\nHow many hearts does "
                               + "an octopus have?\n(type your answer as words,"
                               + " not numbers)");
                       ans3 = scanS.nextLine();
                       if (ans3.equalsIgnoreCase("three")) {
                       System.out.println("You are correct! You gained "
                                   + "$600!");
                       money5 =+ 600;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 800) {
                       System.out.println("You have chosen, $800. "
                               + "Here's your question:\nSaying the name of what"
                               + " dried fruit used to be used to encourage"
                               + " people to smile before a photo in the 1800s,"
                               + " before the phrase “cheese?”");
                       ans4 = scanS.nextLine();
                       if (ans4.equalsIgnoreCase("prune")) {
                       System.out.println("You are correct! You gained "
                                   + "$800!");
                       money5 =+ 800;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   if (moneyAm == 1000) {
                       System.out.println("You have chosen, $1000. "
                               + "Here's your question:\nWhich southern Italian"
                               + " city is usually credited as the birthplace"
                               + " of the pizza?");
                       ans5 = scanS.nextLine();
                       if (ans5.equalsIgnoreCase("naples")) {
                       System.out.println("You are correct! You gained "
                                   + "$1000!");
                       money5 =+ 1000;
                       }else 
                           System.out.println("That is incorrect... Sorry!");
                   }
                   return money5;
        }
    
}
      
