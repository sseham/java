/**
 * Class name: Player
 * Programmer: Seham Ahmed
 * Date: 11/12/20
 * Description: an object that is used to keep fields of a player
 */
package rpgculm;

public class Player {

    private String name;
    private int coins;
    private int weapon;
    private int world;

    Player(String n, int t, int w, int wo) {
        name = n;
        coins = t;
        weapon = w;
        world = wo;
    }
    
    //setters and getters
    public void setName(String n) {
        name = n;
    }

    public void setCoins(int t) {
        coins = t;
    }

    public void setWeapon(int w) {
        weapon = w;
    }
    
    public void setWorld(int wo){
        world = wo;
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getWorld(){
        return world;
    }
    
    //tostring method (not used)
    public String toString(){
        String sWeapon = "x";
     
        switch(weapon){
            case 0:
                sWeapon = "no weapon";
            case 1:
                sWeapon = "a";
            case 2:
                sWeapon = "b";
            case 3:
                sWeapon = "c";
            case 4:
                sWeapon = "d";
            case 5:
                sWeapon = "e";
        }
            
        return name + " has " + coins + " coins, are using " + sWeapon + 
                ".";
    }
}
