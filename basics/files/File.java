/*

 */
package file;

import java.io.*;
import java.util.Scanner;

public class File {

    public File(String file) {
    }

    public static Scanner scanS = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.print("Enter the name of a file: ");
        String fileName = scanS.nextLine(); 
        
        File myFile = new File("D:\\netbeansfiles\\" + fileName);
        Scanner readFile = new Scanner(myFile);

        String line;

        while (readFile.hasNextLine()) {
            line = readFile.nextLine();
            System.out.println(line);

    }
}

