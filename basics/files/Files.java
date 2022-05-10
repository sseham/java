/*

 */
package files;
import java.io.*;
import java.util.Scanner;
public class Files {
    public static Scanner scanS = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        
        int sum = 0;
       
        System.out.print("Enter the name of a file: ");
        String fileName = scanS.nextLine(); 
        
        File myFile = new File("D:\\netbeansfiles\\" + fileName);
        Scanner readFile = new Scanner(myFile);

        String line;

        while (readFile.hasNextLine()) {
            line = readFile.nextLine();
            String[] token = line.split(", ");
            System.out.println(token[0] + " has won $" + token[1] + "!");
            sum += Integer.parseInt(token[1]);
            String user = token[0];
    }
    System.out.println("The total winnings are $" + sum + "!");
    
}
}
