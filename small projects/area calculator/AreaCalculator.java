/**
 * Project name: Area Calculator
 * Programmer: Seham Ahmed
 * Date: 6/1/2020
 * Description: a program that calculates the area for a chosen shape.
 **/
package areacalculator;
import java.text.DecimalFormat;
import java.util.Scanner;
public class AreaCalculator {

    public static void main(String[] args) {
        Scanner scanN = new Scanner(System.in);
        DecimalFormat twoDigit = new DecimalFormat("0.00");
        double baseT, heightT, lengthS, lengthR, widthR, radiusC, area;
        int choice;
        //initializing variables and scanners
        
        menu();
        choice = scanN.nextInt();
        //asking for user choice
        
        switch (choice) {
            case 1: 
                System.out.println("You have chosen a TRIANGLE.\nPlease insert"
                        + " the base and height (base first, enter, then the "
                        + "height).");
                baseT = scanN.nextDouble();
                heightT = scanN.nextDouble();
                area = triangle(baseT,heightT);
                System.out.println("The area of your shape is " + 
                        twoDigit.format(area));
                break;
            case 2:
                System.out.println("You have chosen a SQUARE.\nPlease insert"
                        + " the length");
                lengthS = scanN.nextDouble();
                area = sqaure(lengthS);
                System.out.println("The area of your shape is " + 
                        twoDigit.format(area));
                break;
            case 3:
                System.out.println("You have chosen a RECTANGLE.\nPlease insert"
                        + " the length and the width (length first and then"
                        + " the width).");
                lengthR = scanN.nextDouble();
                widthR = scanN.nextDouble();
                area = rectangle(lengthR, widthR);
                System.out.println("The area of your shape is " + 
                        twoDigit.format(area));
                break;
            case 4:
                System.out.println("You have chosen a CIRCLE.\nPlease insert"
                        + " the radius.");
                radiusC = scanN.nextDouble();
                area = circle(radiusC);
                System.out.println("The area of your shape is " + 
                        twoDigit.format(area));
                break;
            case 5:
                System.out.println("Goodbye!...");
                break;    
        }//asking for measurements depending on their choice
        
    }
    /*
    * Method name: menu
    * This method displays a starting message and menu for the user to choose
    * from.
    */
    public static void menu() {
        System.out.println("Welcome to the A R E A  C A L C U L A T O R!\n"
                + "What shape would you like to find the area for?");
        System.out.println("1. Triangle\n2. Square\n3. Rectangle\n4. Circle\n"
                + "5. Quit");
    } //end of menu
    
    /*
    * Method name: triangle
    * This method calculates the area for a triangle
    * @param base - the base of the triangle
    * @param height - the height of the triangle
    * @return areaT - calculated area of the triangle
    */
    public static double triangle(double base, double height) {
        double areaT = (base*height)/2;
        return areaT;
    } //end of circle
    
    /*
    * Method name: square
    * This method calculates the area for a square
    * @param length - the length of the sqaure
    * @return areaS - calculated area of the square
    */
    public static double sqaure(double length) {
        double areaS = length*length;
        return areaS;
    } //end of square
    
    /*
    * Method name: rectangle
    * This method calculates the area for a rectangle
    * @param length - the length of the rectangle
    * @param width - the width of the rectangle
    * @return areaR - calculated area of the rectangle
    */
    public static double rectangle(double length, double width) {
        double areaR = length*width;
        return areaR;
    } //end of rectangle
    
    /*
    * Method name: circle
    * This method calculates the area for a circle
    * @param radius - the radius of the circle
    * @return areaC - calculated area of the circle
    */
    public static double circle(double radius) {
        double areaC = Math.PI*radius*radius;
        return areaC;
    } //end of circle
}
