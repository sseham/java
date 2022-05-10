/**
 * Class name: Fish
 * Description: An object that simulates a fish 
 */
package fishtank;
import java.util.Scanner;
public class Fish {
    //Scanners
    Scanner scanS = new Scanner(System.in);
    Scanner scanN = new Scanner(System.in);
 
    //fields
    private String name;
    private boolean alive;
    private int size;
    
    //no args constructor
    Fish() {
        name = null;
        alive = false;
        size = 0;
    }
    
    //args contructor
    Fish(String n, int s, boolean a) {
        name = n;
        size = s;
        alive = a;
    }
    
    //accessors and mutators
    public void setName(String n) {
        name = n;
    }

    public void setAlive(boolean a) {
        alive = a;
    }

    public void setSize(int s) {
        size = s;
    }

    public String getName() {
        return name;
    }

    public boolean getAlive() {
        return alive;
    }

    public int getSize() {
        return size;
    }

    //returns the states of the object
    public String toString() {
        String alive1 = "x";
        if (!alive) 
            alive1 = "dead :(";
        else if (alive == true) 
            alive1 = "alive :)";
        
        return name + " is size " + size + " and is "
                + "" + alive1;
    }

    /**
     * Method: fight
     * Description: this method simulates a fight between the two fishes
     * @param enemy - the second fish object that is fighting with the first one
     */
    public void fight(Fish enemy) {
        if (size > enemy.size) {
            enemy.alive = false;
            size += 1;
        } else if (size < enemy.size) {
            alive = false;
            enemy.size += 1;
        } if (size == 11)
            size = 10;
        else if (enemy.size == 11)
            enemy.size = 10;
    }
}
