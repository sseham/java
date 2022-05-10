/**
 * Project name: RPGCulm
 * Programmer: Seham Ahmed
 * Date: 11/12/20
 * Description: runs like an interactive rpg game
 */
package rpgculm;

import java.text.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class RpgCulm {
//creating global scanners
    public static Scanner scanN = new Scanner(System.in);
    public static Scanner scanS = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //initializing arrays and arraylists
        String[] info = new String[4];
        ArrayList<Player> players = new ArrayList<>();

        //directory
        File myFile = new File("D:\\netbeansfiles\\culm.txt");
        Scanner readFile = new Scanner(myFile);

        while (readFile.hasNextLine()) {
            String line = readFile.nextLine();
            info = line.split(", ");
            //creates new player based on file input
            players.add(new Player(info[0], Integer.parseInt(info[1]),
                    Integer.parseInt(info[2]), Integer.parseInt(info[3])));
        }
        //calling upon the menu method
        menu(players);
    }

    public static void menu(ArrayList<Player> players) throws IOException {
        //initializing variables
        int choice, user;

        //displaying the menu output
        System.out.println("Welcome! Are you a...\n1. New player\n2. Returning"
                + " player\n3. Quit");
        choice = scanN.nextInt();

        //switch for user choice
        switch (choice) {
            case 1:
                //calls upon the getData method
                players = getData(players);
                //calls upon the update method after its finished
                update(players);
                break;
            case 2:
                //gets user input for retuning player
                System.out.println("Please choose your user!");
                if (players.isEmpty()) {
                    System.out.println("There are no users! Going back to the "
                            + "main menu...");
                    //sends user back to the menu method
                    menu(players);
                }   for (int i = 0; i < players.size(); i++) {
                    //for loop that displays the different users
                    System.out.println(i + ") " + players.get(i).getName()
                            + " (World " + players.get(i).getWorld() + ")");
                }   user = scanN.nextInt();
                if (user > players.size()) {
                    System.out.println("This is not an option! Going back to"
                            + " the menu!");
                    //sends player back to the menu
                    menu(players);
                } else {
                    //try catch for interruptedexception
                    try {
                        //sends a new variable down and sets all fields after
                        Player user1 = players.get(user);
                        user1 = gameMenu(players.get(user));
                        players.get(user).setName(user1.getName());
                        players.get(user).setCoins(user1.getCoins());
                        players.get(user).setWorld(user1.getWorld());
                        players.get(user).setWorld(user1.getWeapon());
                        update(players);
                    } catch (InterruptedException e) {
                    }
                }   break;
            case 3:
                //ends program
                System.out.println("Goodbye!");
                break;
            default:
                //ends program if invalid option
                System.out.println("This is not an option... Goodbye!");
                break;
        }
    }

    /**
     * method: getData
     * description: gets user data and makes a new player
     * @param players - arraylist of players
     * @return players - arraylist with new user added
     */
    public static ArrayList getData(ArrayList<Player> players) {
        //initializing variables
        String name;
        int weapon, coins, world;
        boolean alive;
        weapon = 0;
        world = 0;
        coins = 0;
        alive = true;
        
        try {
            //asking for the user info
            System.out.println("Hello new player! What is your name?");
            name = scanS.nextLine();
            
            //adding new user with the fields
            players.add(new Player(name, coins, weapon, world));
            int i = players.size() - 1;
            //calling upon the gameMenu method
            gameMenu(players.get(i));
        } catch (InterruptedException e) {
        }
        //returning players arraylist
        return players;
    }

    /**
     * Method name: gameMenu
     * description: displays the game menu for the user
     * @param user - Player object that the user chose
     * @return user - the updated player object
     * @throws InterruptedException 
     */
    public static Player gameMenu(Player user) throws InterruptedException {
        //initializing variables
        int choice, world;

        //telling the user about the game
        System.out.println("Welcome to JP Hunters!\nThis is an interactive role"
                + "-playing game (RPG) that allows you to travel to different\n"
                + "worlds and fight monsters called JP's! Defeat the JP's, gain"
                + " coins, buy weapons \nand advance to the next stages..!");
        Thread.sleep(4000);
        
        //try catch for interruptedexception
        try {
            if (user.getWorld() > 0) {
                //tells user if they have a saved game already
                //lets them choose a new world if they want to
                System.out.println(user.getName() + ", you have a previous game "
                        + "saved in world " + user.getWorld() + ". Would you"
                                + " like" + " to:\n1. Continue this world\n2."
                                + " Choose a new " + "world");
                choice = scanN.nextInt();

                if (choice > 2 || choice < 0) {
                    System.out.println("This is not an option! Choose "
                            + "again...");
                    choice = scanN.nextInt();
                }
                //switch for user choice if they want new world or not
                switch (choice) {
                    case 1:
                        //switch that sends down user to their saved world
                        switch (user.getWorld()) {
                            case 1:
                                user.setWorld(1);
                                //sets world and calls upon worldOne method
                                user = worldOne(user);
                                break;
                            case 2:
                                user.setWorld(2);
                                //sets world and calls upon worldTwo method
                                user = worldTwo(user);
                                break;
                            case 3:
                                user.setWorld(3);
                                //sets world and calls upon worldThree method
                                user = worldThree(user);
                                break;
                        }   break;
                    case 2:
                        Thread.sleep(1000);
                        //asks user what new world they want to choose
                        System.out.println("What world would you like to "
                                + "choose?\n1. Ocean\n2. Swamp\n3. Desert");
                        world = scanN.nextInt();
                        switch (world) {
                            case 1:
                                user.setWorld(1);
                                //sets world and calls upon worldOne method
                                user = worldOne(user);
                                break;
                            case 2:
                                user.setWorld(2);
                                //sets world and calls upon worldTwo method
                                user = worldTwo(user);
                                break;
                            case 3:
                                user.setWorld(3);
                                //sets world and calls upon worldThree method
                                user = worldThree(user);
                                break;
                            default:
                                System.out.println("This isn't an option! "
                                        + "Going back...");
                                //sends user back to the menu
                                gameMenu(user);
                                break;
                        }   break;
                    default:
                        System.out.println("This is not an option! Going back"
                                + "...");
                        //sends user back to the menu
                        gameMenu(user);
                        break;
                }
            }
            if (user.getWorld() == 0) {
                Thread.sleep(1000);
                //displays world list if user does not have a saved world
                System.out.println("What world would you like to choose?"
                        + "\n1. Ocean\n2. Swamp\n3. Desert");

                world = scanN.nextInt();
                switch (world) {
                    case 1:
                        user.setWorld(1);
                        //sets world and calls upon worldOne method
                        user = worldOne(user);
                        break;
                    case 2:
                        user.setWorld(2);
                        //sets world and calls upon worldTwo method
                        user = worldTwo(user);
                        break;
                    case 3:
                        user.setWorld(3);
                        //sets world and calls upon worldThree method
                        user = worldThree(user);
                        break;
                    default:
                        System.out.println("This isn't an option! Going back"
                                + "...");
                        //sends user back to gamamenu
                        gameMenu(user);
                        break;
                }
            }
        } catch (InterruptedException e) {
        }

        //return Player user
        return user;
    }

    /**
     * method: shop
     * description: runs like a shop for the user weapons
     * @param user - Player object for the user
     * @return user - Player object with updated weapon
     */
    public static Player shop(Player user) {
        //initializing variables
        int choice, weapon;
        int coins = user.getCoins();
        String[] w = {"Wooden Bat", "Crowbar", "Axe", "Magic Wand",
            "Ultimate Sword"};

        //displaying a menu
        System.out.println("Welcome to the shop! Would you like to buy a "
                + "weapon?\n1. Yes!\n2. Exit!");
        choice = scanN.nextInt();
        switch (choice) {
            case 1:
                //displays the catalog for the user to choose from
                System.out.println("You can choose from 5 weapons"
                        + "to purchase with your coins!\nHere is our catalog:"
                        + "\n1. " + w[0] + " (100 coins)\n2. " + w[1] + " "
                        + "(250 coins)\n3. " + w[2] + " (500 coins)\n4. " 
                        + w[3] + " (800 coins)\n5. " + w[4] + " (1050 coins)");
                System.out.println("What would you like to buy?");
                weapon = scanN.nextInt();
                
                //switch for the weapon choice
                switch (weapon) {
                    case 1:
                        //checks if user has enough coins
                        if (coins < 100) {
                            System.out.println("You do not have enough coins!"
                                    + " Going back...");
                            //sends user back if they do not have enough coins
                            shop(user);
                        } else {
                            //subtract price and set coins and weapons
                            coins -= 100;
                            user.setWeapon(1);
                            user.setCoins(coins);
                            System.out.println("You have successfully bought"
                                    + " the " + w[0] + "!");
                        }
                        break;
                    case 2:
                        //checks if user has enough coins
                        if (coins < 250) {
                            System.out.println("You do not have enough coins!"
                                    + " Going back...");
                            shop(user);
                        } else {
                            //subtract price and set coins and weapons
                            coins -= 250;
                            user.setWeapon(2);
                            user.setCoins(coins);
                            System.out.println("You have successfully bought"
                                    + " the " + w[1] + "!");
                        }
                        break;
                    case 3:
                        //checks if user has enough coins
                        if (coins < 500) {
                            System.out.println("You do not have enough coins!"
                                    + " Going back...");
                            shop(user);
                        } else {
                            //subtract price and set coins and weapons
                            coins -= 500;
                            user.setWeapon(3);
                            user.setCoins(coins);
                            System.out.println("You have successfully bought"
                                    + " the " + w[2] + "!");
                        }
                        break;
                    case 4:
                        //checks if user has enough coins
                        if (coins < 800) {
                            System.out.println("You do not have enough coins!"
                                    + " Going back...");
                            shop(user);
                        } else {
                            //subtract price and set coins and weapons
                            coins -= 800;
                            user.setWeapon(4);
                            user.setCoins(coins);
                            System.out.println("You have successfully bought "
                                    + "the " + w[3] + "!");
                        }
                        break;
                    case 5:
                        if (coins < 1050) {
                            System.out.println("You do not have enough coins!"
                                    + " Going back...");
                            shop(user);
                        } else {
                            coins -= 1050;
                            user.setWeapon(5);
                            user.setCoins(coins);
                            System.out.println("You have successfully bought"
                                    + " the " + w[4] + "!");
                        }
                        break;
                    default:
                        //sends user back if options is invalid
                        System.out.println("This is not an option! Going"
                                + " back...");
                        shop(user);
                        break;
                }
                break;
            case 2:
                //return user if user does not want to buy anything
                System.out.println("Cya!");
                return user;
            default:
                //sends user back if option is invalid
                System.out.println("This is not an option! Going"
                        + " back...");
                shop(user);
                break;
        }
        return user;
    }

    /**
     * method: minigame
     * @param user - Player object
     * @return user - player object with updated fields
     */
    public static Player minigame(Player user) {
        //setting scanners and variables
        Random r = new Random();
        int rand = r.nextInt(20) + 1;
        int[] hunt = {45, 76, 87, rand, 90};
        int first = 0;
        int last = hunt.length - 1;
        int middle, key;
        boolean found = false;

        //telling the user about the minigame and asking for their guess
        System.out.println("Welcome to the stage three minigame!\nIn this "
                + "minigame you will have to choose a number between 1-20. "
                + "If you guess the\n number correctly then I will give you"
                + "1000 coins! If you don't... I'll let you go with nothing."
                + "\nReady? Pick a number between 1-20!");
        key = scanN.nextInt();

        //leaves if the user did not listen to the instructions
        if (key < 0 || key > 20) {
            System.out.println("I told you to choose from 1-20! You do not get"
                    + " anything because you did not follow the rules!");
            return user;
        } else {
            //do while loop that runs a binary search to find users guess
            do {
                middle = (first + last) / 2;
                if (hunt[middle] == key) {
                    found = true;
                } else if (hunt[middle] > key) {
                    last = middle - 1;
                } else if (hunt[middle] < key) {
                    first = middle + 1;
                }
            } while (!found && last < first);

            if (found == true) {
                //if user guesses right, they get coins
                System.out.println("Congrats! That number was correct! "
                        + "Here's your 1000 coins I promised!");
                //sets coins
                int coins = user.getCoins();
                coins += 1000;
                user.setCoins(coins);
            } else {
                //if user gets it wrong they do not get anything
                System.out.println("Sorry... That number was incorrect!"
                        + " You do not get anything!");
            }
        }
        
        //return user
        return user;
    }

    /**
     * method: worldOne
     * description: starts world one of the game
     * @param user - Player object
     * @return user - player object with updated fields
     * @throws InterruptedException 
     */
    public static Player worldOne(Player user) throws InterruptedException {
        //initializing variables
        Random r = new Random();
        int ans, damageE, shop;
        int heal = 0;
        int coins = user.getCoins();
        int damage = 0;
        int healthP = 750;
        boolean flee;
        int[] health = {500, 600, 800, 1000};
        String[] jp = {"Siren", "Kraken", "Nessie", "Sea Ricky"};

        //telling user about the world
        System.out.println("Welcome to World one... The Ocean. In this "
                + "deep, dark world, you will have to make\nyour way to the"
                + " deepest part of the oceans and fight the monsters!\nMake"
                + " sure to have your goggles and weapon ready!");
        Thread.sleep(5000);
        //introducing the first stage
        System.out.println("\t\t\t***************\n\t\t\t*  STAGE ONE  *"
                + "\n\t\t\t***************");
        Thread.sleep(2000);
        System.out.println("Oh no! A Siren appeared. Make sure not to "
                + "listen to her voice or else she will trick you! Fight"
                + " the Siren!");
        Thread.sleep(2000);
        
        //loop that runs the attacks and heals etc
        do {
            //setting the random damage of the JP
            damageE = r.nextInt(100);
            //switch that alters damage depending on weapon of user
            switch (user.getWeapon()) {
                case 0:
                    damage = r.nextInt(100);
                    break;
                case 1:
                    damage = r.nextInt(120) + 20;
                    break;
                case 2:
                    damage = r.nextInt(140) + 40;
                    break;
                case 3:
                    damage = r.nextInt(160) + 60;
                    break;
                case 4:
                    damage = r.nextInt(180) + 80;
                    break;
                case 5:
                    damage = r.nextInt(200) + 100;
                    break;
            }
            //asks user what they will do
            System.out.println("What will you do?\n1. Attack!\n2. Heal!\nYou"
                    + " cannot flee the first stage!");
            ans = scanN.nextInt();

            //checks if user response is appropriate
            if (ans < 0 || ans > 2) {
                System.out.println("This isn't an option! Hurry choose again!");
                Thread.sleep(2000);
                System.out.println("What will you do?\n1. Attack!\n2. Heal!\n"
                        + "You cannot flee the first stage!");
                //allows user to choose one more time
                ans = scanN.nextInt();
            }

            //switch for user answer
            switch (ans) {
                case 1:
                    /* if user chooses to attack, the user health and JP health
                    is adjusted depending on the damage each party does
                    */
                    health[0] -= damage;
                    healthP -= damageE;
                    Thread.sleep(500);
                    //output that shows the damages and healths
                    System.out.println("The " + jp[0] + " attacked"
                            + " you with " + damageE + " damage!"
                            + " You now  have " + healthP + " health. You have"
                            + " done " + damage + " damage! The " + jp[0]
                            + " is now at " + health[0] + " health! ");
                    break;
                case 2:
                    /* if user chooses to heal, they will heal a random amount 
                    however the jp will still attack and the user health is 
                    adjusted depending on the damage
                    */
                    heal = r.nextInt(50);
                    healthP += heal;
                    healthP -= damageE;
                    Thread.sleep(500);
                    //shows user the output
                    System.out.println("You have healed " + heal + "! "
                            + "However... the " + jp[0] + " attacked "
                            + "you with " + damageE + " damage! "
                            + "You now have " + healthP + " health");
                    break;
                default:
                    /* if user gives an invalid response, the jp will attack
                     the user without letting the user do anything
                    */
                    healthP -= damageE;
                    Thread.sleep(500);
                    //shows user the output
                    System.out.println("Uh oh... You answered wrong and made "
                            + "the " + jp[0] + " angry... The " + jp[0]
                            + " attacked you with " + damageE + " damage! "
                            + "You now have " + healthP + " health");
                    break;
            }
            //loops runs until one of the parties has ran out of health
        } while (health[0] > 0 && healthP > 0);
        
        //if the user health goes to 0...
        if (healthP <= 0) {
            System.out.println("You couldn't defeat the " + jp[0] + "..."
                    + " Better luck next time!");
            return user;
        } else if (health[0] <= 0) {
            //if the user wins, they gain 100 coins, coins are set
            coins += 100;
            user.setCoins(coins);
            System.out.println("Congrats! You beat the " + jp[0] + "! "
                    + "Easy wasn't it? Let's get out of here! On to stage "
                    + "two!");
            //health resets
            healthP = 750;
            Thread.sleep(5000);
            
            //introduces the next stage
            System.out.println("\t\t\t***************\n\t\t\t*  STAGE TWO  *"
                    + "\n\t\t\t***************");
            Thread.sleep(2000);
            System.out.println("Oh no! A Kraken appeared! Don' get tangled"
                    + "up in his tentacles! Fight the Kraken!");
            Thread.sleep(2000);
            do {
                //setting random damage amount the JP will do
                damageE = r.nextInt(150) + 20;
                //setting a random boolean for flee
                flee = r.nextBoolean();
                
                //switch for the weapon and adjusts the damage based off of it
                switch (user.getWeapon()) {
                    case 0:
                        damage = r.nextInt(100);
                        break;
                    case 1:
                        damage = r.nextInt(120) + 20;
                        break;
                    case 2:
                        damage = r.nextInt(140) + 40;
                        break;
                    case 3:
                        damage = r.nextInt(160) + 60;
                        break;
                    case 4:
                        damage = r.nextInt(180) + 80;
                        break;
                    case 5:
                        damage = r.nextInt(200) + 100;
                        break;
                }
                
                //asks user what they will do
                System.out.println("What will you do?\n1. Attack!\n2. Heal!"
                        + "\n3. Flee!");
                ans = scanN.nextInt();

                //checks for a valid response
                if (ans < 0 || ans > 3) {
                    System.out.println("This isn't an option! Hurry choose "
                            + "again!");
                    Thread.sleep(2000);
                    System.out.println("What will you do?\n1. Attack!\n2. "
                            + "Heal!\n3. Flee!");
                    ans = scanN.nextInt();
                }

                switch (ans) {
                    case 1:
                        /* if user chooses to attack, the user health and JP 
                        health is adjusted depending on the damage each party 
                        does */
                        health[1] -= damage;
                        healthP -= damageE;
                        Thread.sleep(500);
                        //lets user see the output
                        System.out.println("The " + jp[1] + " attacked"
                                + " you with " + damageE + " damage!"
                                + " You now  have " + healthP + " health."
                                + " You have done " + damage + " damage! The"
                                + " " + jp[1] + " is now at " + health[1]
                                + " health! ");
                        break;
                    case 2:
                        /* if user chooses to heal, they will heal a random 
                        amount however the jp will still attack and the user 
                        health is adjusted depending on the damage
                        */
                        heal = r.nextInt(50);
                        healthP += heal;
                        healthP -= damageE;
                        Thread.sleep(500);
                        //lets user see the output
                        System.out.println("You have healed " + heal + "! "
                                + "However... the " + jp[1] + " attacked "
                                + "you with " + damageE + " damage! "
                                + "You now have " + healthP + " health");
                        break;
                    case 3:
                        /* if user chooses to flee, the random boolean value
                        will be taken into account, if it is true then they
                        will be allowed to flee but if its false they cannot
                        flee and the jp will attack them
                        */
                        if (!flee) {
                            healthP-=damageE;
                            //shows user output
                            System.out.println("You cannot flee! You tried to"
                                    + " run but the " + jp[1] + " brought "
                                    + "you back! The " + jp[1] + " attacked"
                                    + " you with " + damageE + " damage! " 
                                    + "You now have " + healthP + " health");
                        }
                        break;
                    default:
                        /* if user gives an invalid response, the jp will 
                        attack the user without letting the user do anything
                        */
                        healthP -= damageE;
                        Thread.sleep(500);
                        //shows user output
                        System.out.println("Uh oh... You answered wrong "
                                + "and made " + "the " + jp[1] + " angry..."
                                + " The " + jp[1] + " attacked you with " 
                                + damageE + " damage! " + "You now have " 
                                + healthP + " health");
                        break;
                }
                //loops runs until flee is true, health on either pary is 0
            } while (health[1] > 0 && healthP > 0 && !flee);
            
            if (healthP <= 0) {
                //if user died
                System.out.println("You couldn't defeat the " + jp[1] + "... "
                        + "Looks like you got tangled up in his tentacles "
                        + "after all!");
                return user;
            } else if (health[1] <= 0 || flee == true) {
                //if user flees or if the enemy dies, gains coins
                coins += 250;
                user.setCoins(coins);
                System.out.println("Congrats! You beat the " + jp[1] + "! "
                        + "Hurry! On to the next stage!");
                //health is reset
                healthP = 750;
                Thread.sleep(5000);
                
                //asks user if they want to go to the shop
                System.out.println("Would you like to go to the shop?\n1. Yes"
                        + "\n2. No");
                shop = scanN.nextInt();
                
                if(shop==1)
                    shop(user);
                else if (shop > 2 || shop < 0)
                    System.out.println("This is invalid! We will continue");
                
                //sends user to the minigame for stage 3
                minigame(user);
                Thread.sleep(5000);
                
                //introduces the next stage
                System.out.println("\t\t\t***************\n\t\t\t*  STAGE "
                        + "FOUR  *\n\t\t\t***************");
                Thread.sleep(2000);
                System.out.println("Oh no! A " + jp[2] + " appeared! Try not to"
                        + " strain your neck while looking at him! Fight the "
                        + jp[2] + "!");
                Thread.sleep(2000);
                
                do {
                    //sets random damage and flee value
                    damageE = r.nextInt(200)+50;
                    flee = r.nextBoolean();
                    
                    //switch for the weapon damage
                    switch (user.getWeapon()) {
                        case 0:
                            damage = r.nextInt(100);
                            break;
                        case 1:
                            damage = r.nextInt(120) + 20;
                            break;
                        case 2:
                            damage = r.nextInt(140) + 40;
                            break;
                        case 3:
                            damage = r.nextInt(160) + 60;
                            break;
                        case 4:
                            damage = r.nextInt(180) + 80;
                            break;
                        case 5:
                            damage = r.nextInt(200) + 100;
                            break;
                    }
                    
                    //asks user what they would like to do
                    System.out.println("What will you do?\n1. Attack!\n2. "
                            + "Heal!\n3. Flee!");
                    ans = scanN.nextInt();

                    //checks if the options is valid
                    if (ans < 0 || ans > 3) {
                        System.out.println("This isn't an option! Hurry choose"
                                + " again!");
                        Thread.sleep(2000);
                        //asks the user again
                        System.out.println("What will you do?\n1. Attack!\n2."
                                + " Heal!\n3. Flee!");
                        ans = scanN.nextInt();
                    }

                    //switch for user answer
                    switch (ans) {
                        case 1:
                            /* if user chooses to attack, the user health
                            and JP health is adjusted depending on the
                            damage each party does */
                            health[2] -= damage;
                            healthP -= damageE;
                            Thread.sleep(500);
                            System.out.println("The " + jp[2] + " attacked"
                                    + " you with " + damageE + " damage!"
                                    + " You now  have " + healthP + " health."
                                    + " You have done " + damage + " damage!"
                                    + " The " + jp[2] + " is now at " 
                                    + health[2] + " health! ");
                            break;
                        case 2:
                            /* if user chooses to heal, they will heal a 
                            random amount however the jp will still attack
                            and the user health is adjusted depending on 
                            the damage
                            */
                            heal = r.nextInt(50);
                            healthP += heal;
                            healthP -= damageE;
                            Thread.sleep(500);
                            //output
                            System.out.println("You have healed " + heal + "! "
                                    + "However... the " + jp[2] + " attacked "
                                    + "you with " + damageE + " damage! "
                                    + "You now have " + healthP + " health");
                            break;
                        case 3:
                            /* if user chooses to flee, the random boolean 
                            value will be taken into account, if it is true 
                            then they will be allowed to flee but if its false
                            they cannot flee and the jp will attack them
                            */
                            if (!flee) {
                                healthP-=damageE;
                                //output
                                System.out.println("You cannot flee! You "
                                        + "tried to run but the " + jp[2] 
                                        + " brought you back! The " + jp[2] 
                                        + " attacked you with " + damageE 
                                        + " damage! " + "You now have " 
                                        + healthP + " health");
                            }
                            break;
                        default:
                            //if user answer is invalid
                            healthP -= damageE;
                            Thread.sleep(500);
                            //output
                            System.out.println("Uh oh... You answered wrong "
                                    + "and made " + "the " + jp[2] + " "
                                    + "angry... The " + jp[2] + " attacked "
                                    + "you with " + damageE + " damage! "
                                    + "You now have " + healthP + " health");
                            break;
                    }
                    //runs while flee is false, each party has positive health
                } while (health[2] > 0 && healthP > 0 && !flee);
                
                //if user dies
                if (healthP <= 0) {
                    System.out.println("You couldn't defeat the " + jp[2] + 
                            "... He was just too tall...!");
                    return user;
                } else if (health[2] <= 0 || flee == true) {
                    //if enemy dies, user gains coins
                    coins += 500;
                    user.setCoins(coins);
                    System.out.println("Congrats! You beat the " + jp[2] + "! "
                            + "Moving on!");
                    //reset health
                    healthP = 750;
                    Thread.sleep(5000);
                    
                    //asks user if they want to go to the shop
                System.out.println("Would you like to go to the shop?\n1. Yes"
                        + "\n2. No");
                shop = scanN.nextInt();
                
                if(shop==1)
                    shop(user);
                else if (shop > 2 || shop < 0)
                    System.out.println("This is invalid! We will continue");
                    
                    //intro to stage
                    System.out.println("\t\t\t***************\n\t\t\t*  "
                            + "FINAL STAGE  *\n\t\t\t***************");
                    Thread.sleep(2000);
                    System.out.println("GET READY!!! " + jp[3] + " IS COMING"
                            + "!! Quickly fight this big JP before he "
                            + "destroys the Oceans! Fight the " + jp[3] + "!");
                    Thread.sleep(2000);
                    
                    do {
                        //random damange and flee value
                        damageE = r.nextInt(500) + 100;
                        switch (user.getWeapon()) {
                            case 0:
                                damage = r.nextInt(100);
                                break;
                            case 1:
                                damage = r.nextInt(120) + 20;
                                break;
                            case 2:
                                damage = r.nextInt(140) + 40;
                                break;
                            case 3:
                                damage = r.nextInt(160) + 60;
                                break;
                            case 4:
                                damage = r.nextInt(180) + 80;
                                heal = r.nextInt(300)+50;
                                break;
                            case 5:
                                damage = r.nextInt(200) + 100;
                                break;
                        }
                        
                        //asks user what they will do
                        System.out.println("What will you do?\n1. Attack!\n"
                                + "2. Heal!");
                        ans = scanN.nextInt();

                        //checks if ans is valid
                        if (ans < 0 || ans > 3) {
                            System.out.println("This isn't an option! Hurry "
                                    + "choose again!");
                            Thread.sleep(2000);
                            System.out.println("What will you do?\n1. Attack!"
                                    + "\n2. Heal!");
                            ans = scanN.nextInt();
                        }

                        switch (ans) {
                            case 1:
                                /* if user chooses to attack, the user health 
                                and JP health is adjusted depending on the 
                                damage each party does */
                                health[3] -= damage;
                                healthP -= damageE;
                                Thread.sleep(500);
                                //output
                                System.out.println("The " + jp[3] + " attacked"
                                        + " you with " + damageE + " damage!"
                                        + " You now  have " + healthP + 
                                        " health. You have done " + damage + 
                                        " damage! The " + jp[3] + " is now at "
                                        + health[3] + " health! ");
                                break;
                            case 2:
                                /* if user chooses to heal, they will heal a 
                                random amount however the jp will still attack
                                and the user health is adjusted depending on
                                the damage
                                */
                                healthP += heal;
                                healthP -= damageE;
                                Thread.sleep(500);
                                //output
                                System.out.println("You have healed " + heal
                                        + "! However... the " + jp[3] + 
                                        " attacked you with " + damageE + 
                                        " damage! " + "You now have " + 
                                        healthP + " health");
                                break;
                            default:
                                //if user answer is invalid
                                healthP -= damageE;
                                Thread.sleep(500);
                                //output
                                System.out.println("Uh oh... You answered "
                                        + "wrong and made " + "the " + jp[3]
                                        + " angry... The " + jp[3] + " attacked"
                                        + " you with " + damageE + " damage! "
                                        + "You now have " + healthP +
                                        " health");
                                break;
                        }
                        //runs while both users have health
                    } while (health[3] > 0 && healthP > 0);
                    
                    //if user dies
                    if (healthP <= 0) {
                        System.out.println("You couldn't defeat the " + jp[3]
                                + "... I guess he was just too strong!");
                        return user;
                    } else if (health[3] <= 0) {
                        //if enemy dies, user gains coins
                        coins += 1000;
                        user.setCoins(coins);
                        System.out.println("Congrats! You beat the " + jp[3]
                                + " and saved the Oceans! The marine animals"
                                + " will forever be appreciative of you! "
                                + "Their hero!");
                    }
                }
            }
        }

        //return user
        return user;
    }

    /**
     * method: worldTwo
     * description: runs world two of the game
     * @param user - player object
     * @return user - updated player object
     * @throws InterruptedException 
     * note: i did not add commenting because it runs exactly the same as
     * world one
     */
    public static Player worldTwo(Player user) throws InterruptedException {
        Random r = new Random();
        int ans, damageE, shop;
        int heal = 0;
        int coins = user.getCoins();
        int damage = 0;
        int healthP = 750;
        boolean flee;

        int[] health = {500, 600, 800, 1000};
        String[] jp = {"Sasquatch", "Giant Toad", "Gill-Man", 
            "Swamp Demon Carlos"};

        System.out.println("Welcome to World two..! The Swamp. In this "
                + "cold, muddy world, you will have to make\nyour way to the"
                + " muckiest part of the swamp and fight the monsters!\nMake"
                + " sure not to get stuck in the mud!");
        Thread.sleep(5000);
        
        System.out.println("\t\t\t***************\n\t\t\t*  STAGE ONE  *"
                + "\n\t\t\t***************");
        Thread.sleep(2000);
        System.out.println("Oh no! A " + jp[0] + " appeared. Make sure not to"
                + " get crushed by him!");
        Thread.sleep(2000);
        
        do {
            damageE = r.nextInt(100);
            
            switch (user.getWeapon()) {
                case 0:
                    damage = r.nextInt(100);
                    break;
                case 1:
                    damage = r.nextInt(120) + 20;
                    break;
                case 2:
                    damage = r.nextInt(140) + 40;
                    break;
                case 3:
                    damage = r.nextInt(160) + 60;
                    break;
                case 4:
                    damage = r.nextInt(180) + 80;
                    break;
                case 5:
                    damage = r.nextInt(200) + 100;
                    break;
            }
            
            System.out.println("What will you do?\n1. Attack!\n2. Heal!\nYou"
                    + " cannot flee the first stage!");
            ans = scanN.nextInt();

            if (ans < 0 || ans > 2) {
                System.out.println("This isn't an option! Hurry choose again!");
                Thread.sleep(2000);
                System.out.println("What will you do?\n1. Attack!\n2. Heal!\n"
                        + "You cannot flee the first stage!");
                ans = scanN.nextInt();
            }

            switch (ans) {
                case 1:
                    health[0] -= damage;
                    healthP -= damageE;
                    Thread.sleep(500);
                    System.out.println("The " + jp[0] + " attacked"
                            + " you with " + damageE + " damage!"
                            + " You now  have " + healthP + " health. You have"
                            + " done " + damage + " damage! The " + jp[0]
                            + " is now at " + health[0] + " health! ");
                    break;
                case 2:
                    heal = r.nextInt(50);
                    healthP += heal;
                    healthP -= damageE;
                    Thread.sleep(500);
                    System.out.println("You have healed " + heal + "! "
                            + "However... the " + jp[0] + " attacked "
                            + "you with " + damageE + " damage! "
                            + "You now have " + healthP + " health");
                    break;
                default:
                    healthP -= damageE;
                    Thread.sleep(500);
                    System.out.println("Uh oh... You answered wrong and made "
                            + "the " + jp[0] + " angry... The " + jp[0]
                            + " attacked you with " + damageE + " damage! "
                            + "You now have " + healthP + " health");
                    break;
            }
        } while (health[0] > 0 && healthP > 0);
        
        if (healthP <= 0) {
            System.out.println("You couldn't defeat the " + jp[0] + "..."
                    + " Better luck next time!");
            return user;
            } else if (health[0] <= 0) {
            coins += 100;
            user.setCoins(coins);
            System.out.println("Congrats! You beat the " + jp[0] + "! "
                    + "Easy wasn't it? Let's get out of here! On to stage "
                    + "two!");
            healthP = 750;
            Thread.sleep(5000);
            
            System.out.println("\t\t\t***************\n\t\t\t*  STAGE TWO  *"
                    + "\n\t\t\t***************");
            Thread.sleep(2000);
            System.out.println("Oh no! A " + jp[1] + " appeared! Make sure not"
                    + " to get eaten by this hungry toad!");
            Thread.sleep(2000);
            
            do {
                damageE = r.nextInt(150) + 20;
                flee = r.nextBoolean();
                
                switch (user.getWeapon()) {
                    case 0:
                        damage = r.nextInt(100);
                        break;
                    case 1:
                        damage = r.nextInt(120) + 20;
                        break;
                    case 2:
                        damage = r.nextInt(140) + 40;
                        break;
                    case 3:
                        damage = r.nextInt(160) + 60;
                        break;
                    case 4:
                        damage = r.nextInt(180) + 80;
                        break;
                    case 5:
                        damage = r.nextInt(200) + 100;
                        break;
                }
                
                System.out.println("What will you do?\n1. Attack!\n2. Heal!"
                        + "\n3. Flee!");
                ans = scanN.nextInt();

                if (ans < 0 || ans > 3) {
                    System.out.println("This isn't an option! Hurry choose "
                            + "again!");
                    Thread.sleep(2000);
                    System.out.println("What will you do?\n1. Attack!\n2. "
                            + "Heal!\n3. Flee!");
                    ans = scanN.nextInt();
                }

                switch (ans) {
                    case 1:
                        health[1] -= damage;
                        healthP -= damageE;
                        Thread.sleep(500);
                        System.out.println("The " + jp[1] + " attacked"
                                + " you with " + damageE + " damage!"
                                + " You now  have " + healthP + " health."
                                + " You have done " + damage + " damage! The"
                                + " " + jp[1] + " is now at " + health[1]
                                + " health! ");
                        break;
                    case 2:
                        heal = r.nextInt(50);
                        healthP += heal;
                        healthP -= damageE;
                        Thread.sleep(500);
                        System.out.println("You have healed " + heal + "! "
                                + "However... the " + jp[1] + " attacked "
                                + "you with " + damageE + " damage! "
                                + "You now have " + healthP + " health");
                        break;
                    case 3:
                        if (!flee) {
                            healthP-=damageE;
                            System.out.println("You cannot flee! You tried to"
                                    + " run but the " + jp[1] + " brought "
                                    + "you back! The " + jp[1] + " attacked"
                                    + " you with " + damageE + " damage! " 
                                    + "You now have " + healthP + " health");
                        }
                        break;
                    default:
                        healthP -= damageE;
                        Thread.sleep(500);
                        System.out.println("Uh oh... You answered wrong "
                                + "and made " + "the " + jp[1] + " angry..."
                                + " The " + jp[1] + " attacked you with " 
                                + damageE + " damage! " + "You now have " 
                                + healthP + " health");
                        break;
                }
            } while (health[1] > 0 && healthP > 0 && !flee);
            
            if (healthP <= 0) {
                System.out.println("You couldn't defeat the " + jp[1] + "... "
                        + "Looks like he made a nice meal out of you...!");
                return user;
            } else if (health[1] <= 0 || flee == true) {
                coins += 250;
                user.setCoins(coins);
                System.out.println("Congrats! You beat the " + jp[1] + "! "
                        + "Hurry! On to the next stage!");
                healthP = 750;
                Thread.sleep(5000);
                
                //asks user if they want to go to the shop
                System.out.println("Would you like to go to the shop?\n1. Yes"
                        + "\n2. No");
                shop = scanN.nextInt();
                
                if(shop==1)
                    shop(user);
                else if (shop > 2 || shop < 0)
                    System.out.println("This is invalid! We will continue");
                
                
                //calls upon minigame method
                minigame(user);
                
                Thread.sleep(5000);
                System.out.println("\t\t\t***************\n\t\t\t*  STAGE "
                        + "FOUR  *\n\t\t\t***************");
                Thread.sleep(2000);
                System.out.println("Oh no! " + jp[2] + " appeared! Try not to"
                        + " get captured by him! Fight the " + jp[2] + "!");
                Thread.sleep(2000);
                
                do {
                    damageE = r.nextInt(200)+50;
                    flee = r.nextBoolean();
                    
                    switch (user.getWeapon()) {
                        case 0:
                            damage = r.nextInt(100);
                            break;
                        case 1:
                            damage = r.nextInt(120) + 20;
                            break;
                        case 2:
                            damage = r.nextInt(140) + 40;
                            break;
                        case 3:
                            damage = r.nextInt(160) + 60;
                            break;
                        case 4:
                            damage = r.nextInt(180) + 80;
                            break;
                        case 5:
                            damage = r.nextInt(200) + 100;
                            break;
                    }
                    System.out.println("What will you do?\n1. Attack!\n2. "
                            + "Heal!\n3. Flee!");
                    ans = scanN.nextInt();

                    if (ans < 0 || ans > 3) {
                        System.out.println("This isn't an option! Hurry choose"
                                + " again!");
                        Thread.sleep(2000);
                        System.out.println("What will you do?\n1. Attack!\n2."
                                + " Heal!\n3. Flee!");
                        ans = scanN.nextInt();
                    }

                    switch (ans) {
                        case 1:
                            health[2] -= damage;
                            healthP -= damageE;
                            Thread.sleep(500);
                            System.out.println("The " + jp[2] + " attacked"
                                    + " you with " + damageE + " damage!"
                                    + " You now  have " + healthP + " health."
                                    + " You have done " + damage + " damage!"
                                    + " The " + jp[2] + " is now at " 
                                    + health[2] + " health! ");
                            break;
                        case 2:
                            heal = r.nextInt(50);
                            healthP += heal;
                            healthP -= damageE;
                            Thread.sleep(500);
                            System.out.println("You have healed " + heal + "! "
                                    + "However... the " + jp[2] + " attacked "
                                    + "you with " + damageE + " damage! "
                                    + "You now have " + healthP + " health");
                            break;
                        case 3:
                            if (!flee) {
                                healthP-=damageE;
                                System.out.println("You cannot flee! You "
                                        + "tried to run but the " + jp[2] 
                                        + " brought you back! The " + jp[2] 
                                        + " attacked you with " + damageE 
                                        + " damage! " + "You now have " 
                                        + healthP + " health");
                            }
                            break;
                        default:
                            healthP -= damageE;
                            Thread.sleep(500);
                            System.out.println("Uh oh... You answered wrong "
                                    + "and made " + "the " + jp[2] + " "
                                    + "angry... The " + jp[2] + " attacked "
                                    + "you with " + damageE + " damage! "
                                    + "You now have " + healthP + " health");
                            break;
                    }
                } while (health[2] > 0 && healthP > 0 && !flee);
                
                if (healthP <= 0) {
                    System.out.println("You couldn't defeat the " + jp[2] + 
                            "... He was just too strong...!");
                    return user;
                    } else if (health[2] <= 0 || flee == true) {
                    coins += 500;
                    user.setCoins(coins);
                    System.out.println("Congrats! You beat the " + jp[2] + "! "
                            + "Moving on!");
                    healthP = 750;
                    Thread.sleep(5000);
                    
                    System.out.println("\t\t\t***************\n\t\t\t*  "
                            + "FINAL STAGE  *\n\t\t\t***************");
                    Thread.sleep(2000);
                    System.out.println("GET READY!!! " + jp[3] + " IS COMING"
                            + "!! Quickly fight this muddy JP before he "
                            + "destroys the rest of the Swamp! Fight the " 
                            + jp[3] + "!");
                    Thread.sleep(2000);
                    
                    do {
                        damageE = r.nextInt(500) + 100;
                        switch (user.getWeapon()) {
                            case 0:
                                damage = r.nextInt(100);
                                break;
                            case 1:
                                damage = r.nextInt(120) + 20;
                                break;
                            case 2:
                                damage = r.nextInt(140) + 40;
                                break;
                            case 3:
                                damage = r.nextInt(160) + 60;
                                break;
                            case 4:
                                damage = r.nextInt(180) + 80;
                                heal = r.nextInt(300)+50;
                                break;
                            case 5:
                                damage = r.nextInt(200) + 100;
                                break;
                        }
                        System.out.println("What will you do?\n1. Attack!\n"
                                + "2. Heal!");
                        ans = scanN.nextInt();

                        if (ans < 0 || ans > 3) {
                            System.out.println("This isn't an option! Hurry "
                                    + "choose again!");
                            Thread.sleep(2000);
                            System.out.println("What will you do?\n1. Attack!"
                                    + "\n2. Heal!");
                            ans = scanN.nextInt();
                        }

                        switch (ans) {
                            case 1:
                                health[3] -= damage;
                                healthP -= damageE;
                                Thread.sleep(500);
                                System.out.println("The " + jp[3] + " attacked"
                                        + " you with " + damageE + " damage!"
                                        + " You now  have " + healthP + 
                                        " health. You have done " + damage + 
                                        " damage! The " + jp[3] + " is now at "
                                        + health[3] + " health! ");
                                break;
                            case 2:
                                healthP += heal;
                                healthP -= damageE;
                                Thread.sleep(500);
                                System.out.println("You have healed " + heal
                                        + "! However... the " + jp[3] + 
                                        " attacked you with " + damageE + 
                                        " damage! " + "You now have " + 
                                        healthP + " health");
                                break;
                            default:
                                healthP -= damageE;
                                Thread.sleep(500);
                                System.out.println("Uh oh... You answered "
                                        + "wrong and made " + "the " + jp[3]
                                        + " angry... The " + jp[3] + " attacked"
                                        + " you with " + damageE + " damage! "
                                        + "You now have " + healthP +
                                        " health");
                                break;
                        }
                    } while (health[3] > 0 && healthP > 0);
                    
                    if (healthP <= 0) {
                        System.out.println("You couldn't defeat the " + jp[3]
                                + "... I guess he was just too strong!");
                        return user;
                    } else if (health[3] <= 0) {
                        coins += 1000;
                        user.setCoins(coins);
                        System.out.println("Congrats! You beat the " + jp[3]
                                + " and saved the Swamps! I'm sure all the "
                                + "reptiles and animals are relieved!");
                    }
                }
            }
        }

        return user;
    }

    /**
     * method: worldThree
     * description: runs world three of the game
     * @param user - player object
     * @return user - updated player object
     * @throws InterruptedException 
     * note: i did not add commenting because it runs the same as world one
     */
    public static Player worldThree(Player user) throws InterruptedException {
        Random r = new Random();
        int ans, damageE, shop;
        int heal = 0;
        int coins = user.getCoins();
        int damage = 0;
        int healthP = 750;
        boolean flee;

        int[] health = {500, 600, 800, 1000};
        String[] jp = {"Sphinx", "Cactus Monster", "Ghazi Mummies", 
            "Fares Pharaoh"};

        System.out.println("Welcome to World three..! The Desert. In this "
                + "hot, sandy world, you will have to make\nyour way to the"
                + " sandiest parts of the desert and fight the monsters!\nMake"
                + " sure not to get any sand in your eyes! It sure is windy..."
                + "");
        Thread.sleep(5000);
        
        System.out.println("\t\t\t***************\n\t\t\t*  STAGE ONE  *"
                + "\n\t\t\t***************");
        Thread.sleep(2000);
        System.out.println("Oh no! A " + jp[0] + " appeared. Make sure not to"
                + " get clawed by him!");
        Thread.sleep(2000);
        
        do {
            damageE = r.nextInt(100);
            switch (user.getWeapon()) {
                case 0:
                    damage = r.nextInt(100);
                    break;
                case 1:
                    damage = r.nextInt(120) + 20;
                    break;
                case 2:
                    damage = r.nextInt(140) + 40;
                    break;
                case 3:
                    damage = r.nextInt(160) + 60;
                    break;
                case 4:
                    damage = r.nextInt(180) + 80;
                    break;
                case 5:
                    damage = r.nextInt(200) + 100;
                    break;
            }
            System.out.println("What will you do?\n1. Attack!\n2. Heal!\nYou"
                    + " cannot flee the first stage!");
            ans = scanN.nextInt();

            if (ans < 0 || ans > 2) {
                System.out.println("This isn't an option! Hurry choose again!");
                Thread.sleep(2000);
                System.out.println("What will you do?\n1. Attack!\n2. Heal!\n"
                        + "You cannot flee the first stage!");
                ans = scanN.nextInt();
            }

            switch (ans) {
                case 1:
                    health[0] -= damage;
                    healthP -= damageE;
                    Thread.sleep(500);
                    System.out.println("The " + jp[0] + " attacked"
                            + " you with " + damageE + " damage!"
                            + " You now  have " + healthP + " health. You have"
                            + " done " + damage + " damage! The " + jp[0]
                            + " is now at " + health[0] + " health! ");
                    break;
                case 2:
                    heal = r.nextInt(50);
                    healthP += heal;
                    healthP -= damageE;
                    Thread.sleep(500);
                    System.out.println("You have healed " + heal + "! "
                            + "However... the " + jp[0] + " attacked "
                            + "you with " + damageE + " damage! "
                            + "You now have " + healthP + " health");
                    break;
                default:
                    healthP -= damageE;
                    Thread.sleep(500);
                    System.out.println("Uh oh... You answered wrong and made "
                            + "the " + jp[0] + " angry... The " + jp[0]
                            + " attacked you with " + damageE + " damage! "
                            + "You now have " + healthP + " health");
                    break;
            }
        } while (health[0] > 0 && healthP > 0);
        
        if (healthP <= 0) {
            System.out.println("You couldn't defeat the " + jp[0] + "..."
                    + " Better luck next time!");
            return user;
            } else if (health[0] <= 0) {
            coins += 100;
            user.setCoins(coins);
            System.out.println("Congrats! You beat the " + jp[0] + "! "
                    + "Easy wasn't it? Let's get out of here! On to stage "
                    + "two!");
            healthP = 750;
            Thread.sleep(5000);
            
            System.out.println("\t\t\t***************\n\t\t\t*  STAGE TWO  *"
                    + "\n\t\t\t***************");
            Thread.sleep(2000);
            System.out.println("Oh no! A " + jp[1] + " appeared! Make sure not"
                    + " to get poked by its thorns!");
            Thread.sleep(2000);
            
            do {
                damageE = r.nextInt(150) + 20;
                flee = r.nextBoolean();
                
                switch (user.getWeapon()) {
                    case 0:
                        damage = r.nextInt(100);
                        break;
                    case 1:
                        damage = r.nextInt(120) + 20;
                        break;
                    case 2:
                        damage = r.nextInt(140) + 40;
                        break;
                    case 3:
                        damage = r.nextInt(160) + 60;
                        break;
                    case 4:
                        damage = r.nextInt(180) + 80;
                        break;
                    case 5:
                        damage = r.nextInt(200) + 100;
                        break;
                }
                System.out.println("What will you do?\n1. Attack!\n2. Heal!"
                        + "\n3. Flee!");
                ans = scanN.nextInt();

                if (ans < 0 || ans > 3) {
                    System.out.println("This isn't an option! Hurry choose "
                            + "again!");
                    Thread.sleep(2000);
                    System.out.println("What will you do?\n1. Attack!\n2. "
                            + "Heal!\n3. Flee!");
                    ans = scanN.nextInt();
                }

                switch (ans) {
                    case 1:
                        health[1] -= damage;
                        healthP -= damageE;
                        Thread.sleep(500);
                        System.out.println("The " + jp[1] + " attacked"
                                + " you with " + damageE + " damage!"
                                + " You now  have " + healthP + " health."
                                + " You have done " + damage + " damage! The"
                                + " " + jp[1] + " is now at " + health[1]
                                + " health! ");
                        break;
                    case 2:
                        heal = r.nextInt(50);
                        healthP += heal;
                        healthP -= damageE;
                        Thread.sleep(500);
                        System.out.println("You have healed " + heal + "! "
                                + "However... the " + jp[1] + " attacked "
                                + "you with " + damageE + " damage! "
                                + "You now have " + healthP + " health");
                        break;
                    case 3:
                        if (!flee) {
                            healthP-=damageE;
                            System.out.println("You cannot flee! You tried to"
                                    + " run but the " + jp[1] + " brought "
                                    + "you back! The " + jp[1] + " attacked"
                                    + " you with " + damageE + " damage! " 
                                    + "You now have " + healthP + " health");
                        }
                        break;
                    default:
                        healthP -= damageE;
                        Thread.sleep(500);
                        System.out.println("Uh oh... You answered wrong "
                                + "and made " + "the " + jp[1] + " angry..."
                                + " The " + jp[1] + " attacked you with " 
                                + damageE + " damage! " + "You now have " 
                                + healthP + " health");
                        break;
                }
            } while (health[1] > 0 && healthP > 0 && !flee);
            
            if (healthP <= 0) {
                System.out.println("You couldn't defeat the " + jp[1] + "... "
                        + "Looks like he popped you like a balloon with his"
                        + " thorns...!");
                return user;
            } else if (health[1] <= 0 || flee == true) {
                coins += 250;
                user.setCoins(coins);
                System.out.println("Congrats! You beat the " + jp[1] + "! "
                        + "Hurry! On to the next stage!");
                healthP = 750;
                Thread.sleep(5000);
                
                //asks user if they want to go to the shop
                System.out.println("Would you like to go to the shop?\n1. Yes"
                        + "\n2. No");
                shop = scanN.nextInt();
                
                if(shop==1)
                    shop(user);
                else if (shop > 2 || shop < 0)
                    System.out.println("This is invalid! We will continue");
                
                //calls upon minigame
                minigame(user);
                Thread.sleep(5000);
                
                System.out.println("\t\t\t***************\n\t\t\t*  STAGE "
                        + "FOUR  *\n\t\t\t***************");
                Thread.sleep(2000);
                System.out.println("Oh no! " + jp[2] + " appeared! Try not to"
                        + " get wrapped up! Fight the " + jp[2] + "!");
                Thread.sleep(2000);
                
                do {
                    damageE = r.nextInt(200)+50;
                    flee = r.nextBoolean();
                    
                    switch (user.getWeapon()) {
                        case 0:
                            damage = r.nextInt(100);
                            break;
                        case 1:
                            damage = r.nextInt(120) + 20;
                            break;
                        case 2:
                            damage = r.nextInt(140) + 40;
                            break;
                        case 3:
                            damage = r.nextInt(160) + 60;
                            break;
                        case 4:
                            damage = r.nextInt(180) + 80;
                            break;
                        case 5:
                            damage = r.nextInt(200) + 100;
                            break;
                    }
                    System.out.println("What will you do?\n1. Attack!\n2. "
                            + "Heal!\n3. Flee!");
                    ans = scanN.nextInt();

                    if (ans < 0 || ans > 3) {
                        System.out.println("This isn't an option! Hurry choose"
                                + " again!");
                        Thread.sleep(2000);
                        System.out.println("What will you do?\n1. Attack!\n2."
                                + " Heal!\n3. Flee!");
                        ans = scanN.nextInt();
                    }

                    switch (ans) {
                        case 1:
                            health[2] -= damage;
                            healthP -= damageE;
                            Thread.sleep(500);
                            System.out.println("The " + jp[2] + " attacked"
                                    + " you with " + damageE + " damage!"
                                    + " You now  have " + healthP + " health."
                                    + " You have done " + damage + " damage!"
                                    + " The " + jp[2] + " is now at " 
                                    + health[2] + " health! ");
                            break;
                        case 2:
                            heal = r.nextInt(50);
                            healthP += heal;
                            healthP -= damageE;
                            Thread.sleep(500);
                            System.out.println("You have healed " + heal + "! "
                                    + "However... the " + jp[2] + " attacked "
                                    + "you with " + damageE + " damage! "
                                    + "You now have " + healthP + " health");
                            break;
                        case 3:
                            if (!flee) {
                                healthP-=damageE;
                                System.out.println("You cannot flee! You "
                                        + "tried to run but the " + jp[2] 
                                        + " brought you back! The " + jp[2] 
                                        + " attacked you with " + damageE 
                                        + " damage! " + "You now have " 
                                        + healthP + " health");
                            }
                            break;
                        default:
                            healthP -= damageE;
                            Thread.sleep(500);
                            System.out.println("Uh oh... You answered wrong "
                                    + "and made " + "the " + jp[2] + " "
                                    + "angry... The " + jp[2] + " attacked "
                                    + "you with " + damageE + " damage! "
                                    + "You now have " + healthP + " health");
                            break;
                    }
                } while (health[2] > 0 && healthP > 0 && !flee);
                
                if (healthP <= 0) {
                    System.out.println("You couldn't defeat the " + jp[2] + 
                            "... You got tangled up in his bandages...!");
                    return user;
                    } else if (health[2] <= 0 || flee == true) {
                    coins += 500;
                    user.setCoins(coins);
                    System.out.println("Congrats! You beat the " + jp[2] + "! "
                            + "Moving on!");
                    healthP = 750;
                    Thread.sleep(5000);
                    
                    //asks user if they want to go to the shop
                System.out.println("Would you like to go to the shop?\n1. Yes"
                        + "\n2. No");
                shop = scanN.nextInt();
                
                if(shop==1)
                    shop(user);
                else if (shop > 2 || shop < 0)
                    System.out.println("This is invalid! We will continue");
                    
                    System.out.println("\t\t\t***************\n\t\t\t*  "
                            + "FINAL STAGE  *\n\t\t\t***************");
                    Thread.sleep(2000);
                    System.out.println("GET READY!!! " + jp[3] + " IS COMING"
                            + "!! Quickly fight this powerful ruler before he "
                            + "destroys the rest of the Desert! Fight the " 
                            + jp[3] + "!");
                    Thread.sleep(2000);
                    
                    do {
                        damageE = r.nextInt(500) + 100;
                        
                        switch (user.getWeapon()) {
                            case 0:
                                damage = r.nextInt(100);
                                break;
                            case 1:
                                damage = r.nextInt(120) + 20;
                                break;
                            case 2:
                                damage = r.nextInt(140) + 40;
                                break;
                            case 3:
                                damage = r.nextInt(160) + 60;
                                break;
                            case 4:
                                damage = r.nextInt(180) + 80;
                                heal = r.nextInt(300)+50;
                                break;
                            case 5:
                                damage = r.nextInt(200) + 100;
                                break;
                        }
                        System.out.println("What will you do?\n1. Attack!\n"
                                + "2. Heal!");
                        ans = scanN.nextInt();

                        if (ans < 0 || ans > 3) {
                            System.out.println("This isn't an option! Hurry "
                                    + "choose again!");
                            Thread.sleep(2000);
                            System.out.println("What will you do?\n1. Attack!"
                                    + "\n2. Heal!");
                            ans = scanN.nextInt();
                        }

                        switch (ans) {
                            case 1:
                                health[3] -= damage;
                                healthP -= damageE;
                                Thread.sleep(500);
                                System.out.println("The " + jp[3] + " attacked"
                                        + " you with " + damageE + " damage!"
                                        + " You now  have " + healthP + 
                                        " health. You have done " + damage + 
                                        " damage! The " + jp[3] + " is now at "
                                        + health[3] + " health! ");
                                break;
                            case 2:
                                healthP += heal;
                                healthP -= damageE;
                                Thread.sleep(500);
                                System.out.println("You have healed " + heal
                                        + "! However... the " + jp[3] + 
                                        " attacked you with " + damageE + 
                                        " damage! " + "You now have " + 
                                        healthP + " health");
                                break;
                            default:
                                healthP -= damageE;
                                Thread.sleep(500);
                                System.out.println("Uh oh... You answered "
                                        + "wrong and made " + "the " + jp[3]
                                        + " angry... The " + jp[3] + " attacked"
                                        + " you with " + damageE + " damage! "
                                        + "You now have " + healthP +
                                        " health");
                                break;
                        }
                    } while (health[3] > 0 && healthP > 0);
                    
                    if (healthP <= 0) {
                        System.out.println("You couldn't defeat the " + jp[3]
                                + "... I guess he was just too strong!");
                        return user;
                    } else if (health[3] <= 0) {
                        coins += 1000;
                        user.setCoins(coins);
                        System.out.println("Congrats! You beat the " + jp[3]
                                + " and saved the Desert! I'm glad we had you"
                                        + " to protect this sacred land!");
                    }
                }
            }
        }
    
        //return user
        return user;
    }

    /**
     * method: update
     * description: updates the data in the file
     * @param players - the player arraylist with all updated fields
     * @throws IOException 
     */
    public static void update(ArrayList<Player> players) throws IOException {
        //initializing objects
        //will replace the data in the file instead of writing underneath
        FileWriter fWriter = new FileWriter("D:\\netbeansfiles\\"
                + "culm.txt", false);
        PrintWriter outputFile = new PrintWriter(fWriter);

        //runs a select sort for the users so that they are in order in the file
        for (int i = 0; i < players.size() - 1; i++) {
            String minName = players.get(i).getName();
            int minIndex = i;
            int minCoins = players.get(i).getCoins();;
            int minWeapon = players.get(i).getWeapon();
            int minWorld = players.get(i).getWorld();
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(j).getName().compareToIgnoreCase(minName) < 0){
                    minName = players.get(j).getName();
                    minIndex = j;
                    minCoins = players.get(j).getCoins();
                    minWeapon = players.get(j).getWeapon();
                    minWorld = players.get(j).getWorld();
                }
            }
            players.get(minIndex).setName(minName);
            players.get(i).setName(minName);
            players.get(minIndex).setCoins(minCoins);
            players.get(i).setCoins(minCoins);
            players.get(minIndex).setWorld(minWorld);
            players.get(i).setWorld(minWorld);
            players.get(minIndex).setWeapon(minWeapon);
            players.get(i).setWeapon(minWeapon);
        }
        
        //for loop to rewrite all updated user info
        for (int i = 0; i < players.size(); i++) {
            outputFile.println(players.get(i).getName() + ", "
                    + players.get(i).getCoins() + ", "
                    + players.get(i).getWeapon() + ", "
                    + players.get(i).getWorld());
        }
        //close the file editor
        outputFile.close();
        try {
        credits();
        } catch(InterruptedException e) {
            
        }
    }
    
    /**
     * method name: credits
     * description: displays a small end credit scene
     * @throws InterruptedException 
     */
    public static void credits() throws InterruptedException {
        //displays the credits
        Thread.sleep(1500);
        System.out.println("\t\t\t**End Credits**");
        Thread.sleep(1000);
        System.out.println("Game Creator: Seham Ahmed");
        Thread.sleep(1000);
        System.out.println("Monster names by: Mahnoor (Friend)");
        Thread.sleep(1000);
        System.out.println("Game Tester: Liza (Sister)");
        Thread.sleep(1000);
        System.out.println("Inspired by: Joseph (Friend)");
        Thread.sleep(1000);
        System.out.println("Thank you for playing!");
    }
}
