/**
 * Project name: Juice Shop
 * Programmer: Seham Ahmed
 * Date: 10/30/20
 * Description: A program that simulates an online juice shop
 */
package juiceshop;
import java.util.ArrayList;
import java.util.Scanner;
public class JuiceShop {
    
    public static void main(String[] args) {
        //creating the arraylist
        ArrayList<Order> orders = new ArrayList<>();
        //intro
        System.out.println("Welcome to the Juice Shop! What would you like to"
                + " do?");
        //calls upon the menu method
        menu(orders);
    }

    /**
     * method name: menu 
     * description: displays the menu for the user
     * @param orders<> - an arraylist with the orders(objects) of customers
     */
    public static void menu(ArrayList<Order> orders) {
        //initializing scanners and variables
        Scanner scanN = new Scanner(System.in);
        int choice;

        //displays the menu and asks for user input
        System.out.println("1. View Orders\n2. Add Order\n3. Remove Order\n4. "
                + "Calculate Total Profit\n5. Exit");
        choice = scanN.nextInt();

        switch (choice) {
            case 1:
                //calls upon the orders method, sending orders as param
                view(orders);
                break;
            case 2:
                //calls upon getData method, sending orders as param
                orders = getData(orders);
                menu(orders);
                break;
            case 3:
                //calls upon remove method
                orders = remove(orders);
                menu(orders);
                break;
            case 4:
                //calls upon the profit method
                profit(orders);
                break;
            case 5:
                //leaves the program
                System.out.println("Goodbye!");
                break;
        }
    }

    /**
     * method name: view 
     * description: allows user to view the orders
     * @param orders<> - an arraylist with the orders(objects) of customers
     */
    public static void view(ArrayList<Order> orders) {
        //initializing scanners and variables
        Scanner scanS = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);
        int choice;
        String choice2;

        //checks if the arraylist is empty or not
        if (orders.isEmpty()) {
            System.out.println("There are no current orders! Going back to the"
                    + " menu!\n");
            //returns to menu if arraylist is empty
            menu(orders);
        } else if (orders.size() > 0) {
            do {
                //displays the list of customers
                System.out.println("Which order would you like to view? (Use"
                        + " numbers)");
                for (int i = 0; i < orders.size(); i++)
                    System.out.println(i + ". " + orders.get(i).getName());
                //takes user input and gives them the order they want to see
                choice = scanN.nextInt();
                System.out.println(orders.get(choice).toString());

                //asks user if they would like to go back
                System.out.println("Would you like to return to the main menu?"
                        + " (yes or no)");
                choice2 = scanS.nextLine();

            } while (choice2.equalsIgnoreCase("no"));
            //takes them back to the menu method
            menu(orders);
        }
    }

    /**
     * method name: getData 
     * description: gets user input for a new order
     * @param orders<> - an arraylist with the orders(objects) of customers
     * @return orders<> - an updated arraylist with the customer orders
     */
    public static ArrayList getData(ArrayList<Order> orders) {
        //initializing scanners and variables
        Scanner scanS = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);
        String n, j, choice;
        int l;

        //a do while loop that will run until the user doesnt want to add more--
        //--objects to the arraylist
        do {
            System.out.println("What is the name of the customer?");
            n = scanS.nextLine();
            System.out.println("What type of juice would they like to order?"
                    + "(apple, pickle or orange)");
            j = scanS.nextLine().toLowerCase();
            System.out.println("Finally, how many litres would they like? (use"
                    + " numbers)");
            l = scanN.nextInt();
            //creates new object with the fields asked for
            orders.add(new Order(n, j, l));
            //asks user if they would like to return to the menu
            System.out.println("Would you like to return to the main menu?"
                    + " (yes or no)");
            choice = scanS.nextLine();
        } while (choice.equalsIgnoreCase("no"));
        //returning updated arraylist
        return orders;
    }

    /**
     * method name: remove 
     * description: allows user to remove an order
     * @param orders<> - an arraylist with the orders(objects) of customers
     * @return orders<> - an updated arraylist with the customer orders
     */
    public static ArrayList remove(ArrayList<Order> orders) {
        //initializing scanners and variables
        Scanner scanS = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);
        int choice;
        String choice2;
        //checks if array is empty or not
        if (orders.isEmpty()) {
            System.out.println("There are no current orders! Going back to the"
                    + " menu!\n");
            menu(orders);
        } else if (orders.size() > 0) {
            do {
                //displays the customers
                System.out.println("Which order would you like to delete? (Use"
                        + " numbers)");
                for (int i = 0; i < orders.size(); i++) {
                    System.out.println(i + ". " + orders.get(i).getName());
                }
                //deletes the customer that the user inputted
                choice = scanN.nextInt();
                orders.remove(choice);
                //asks user if they would like to return to the menu
                System.out.println("Removed!\nWould you like to return to the "
                        + "main menu? (yes or no)");
                choice2 = scanS.nextLine();
            } while (choice2.equalsIgnoreCase("no"));
        }
        //returning updated orders
        return orders;
    }

    /**
     * method name: profit 
     * description: allows user to find out the total
     * profit made based on the orders already in the system
     * @param orders<> - an arraylist with the orders(objects) of customers
     */
    public static void profit(ArrayList<Order> orders) {
        //initializing scanners and variables
        Scanner scanS = new Scanner(System.in);
        String choice;
        int profit = 0;
        //checks if the arraylist is empty or not
        if (orders.isEmpty()) {
            System.out.println("There are no current orders! Going back to the"
                    + " menu!\n");
            //returns to menu if its empty
            menu(orders);
        } else if (orders.size() > 0) {
            do {
                //goes through each object and calculates profit, adds them up
                for (int i = 0; i < orders.size(); i++) {
                    profit += orders.get(i).calcPrice();
                }
                //displays the total profit that was calculated
                System.out.println("The total profit of all the orders is "
                        + "$" + profit);
                //asks user if they would like to return to the menu
                System.out.println("Would you like to return to the "
                        + "main menu? (yes or no)");
                choice = scanS.nextLine();
            } while (choice.equalsIgnoreCase("no"));
            //returns back to the menu
            menu(orders);
        }
    }
}
