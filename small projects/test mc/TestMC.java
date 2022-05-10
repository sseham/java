/**
 * Project name: TestMC
 * Programmer: Seham Ahmed
 * Date: 10/07/2020
 * Description: a program that calculates student marks for a multiple choice
 * test
 **/
package testmc;
import java.util.Scanner;
public class TestMC {

    public static void main(String[] args) {
//initializing variables,, student answers and the answer key
        char[][] answers = {{'A', 'B', 'A', 'C', 'C', 'D', 'E',
            'E', 'A', 'D'}, {'D', 'B', 'A', 'B', 'C', 'A', 'E',
            'E', 'A', 'D'}, {'E', 'D', 'D', 'A', 'C', 'B', 'E',
            'B', 'A', 'C'}, {'C', 'B', 'A', 'E', 'D', 'C', 'E',
            'E', 'A', 'A'}, {'A', 'B', 'D', 'C', 'C', 'D', 'B',
            'A', 'A', 'C'}, {'B', 'B', 'E', 'C', 'C', 'D', 'E',
            'E', 'B', 'B'}, {'B', 'B', 'A', 'C', 'C', 'D', 'E',
            'E', 'A', 'D'}, {'D', 'B', 'D', 'C', 'C', 'D', 'A',
            'E', 'A', 'D'}};
        char[] key = {'D', 'B', 'D', 'C', 'C', 'D', 'A',
            'E', 'A', 'D'};

        //calling upon calcMark and sending down the answers as params
        int[] mark = calcMark(answers, key);
        //calling upon sortMark
        int[] sort = sortMark(mark);
        searchMark(sort);
    }

    /**
     * method name: calcMark description: this method calculates how many
     * answers students got correct.
     * @param key - the correct answer key of the test
     * @param answers - a 2d array of all the student answers
     * @return mark - the numbers of correct answers each student got
     **/
    public static int[] calcMark(char[][] answers, char[] key) {
        //setting intiger variables to count the total correct answer counts
        int[][] calc = new int[8][10];
        int[] mark = new int[8];

        //forloop to count how many answers are correct
        for (int row = 0; row < answers.length; row++) {
            mark[row] = 0;
            for (int col = 0; col < answers[row].length; col++) {
                if (key[col] == answers[row][col]) {
                    calc[row][col] = 1;
                    mark[row]++;
                }
                if (key[col] != answers[row][col])
                    calc[row][col] = 0;
            }
        }
        //loop to tell user the output
        for (int row = 0; row < answers.length; row++) {
            System.out.println("Student " + (row + 1) + " has gotten "
                    + mark[row] + " answers correct!");
        }
        System.out.println();
        //returning marks to main to be sorted
        return mark;
    }

    /**
     * method name: sortMark description: this method sorts the student answers
     * from least correct answers to most correct answers.
     * @param mark - the students mark count
     * @return sort - array that contains the sorted students marks.
     **/
    public static int[] sortMark(int[] mark) {
        //initializing and setting variables
        int[] stud = {1, 2, 3, 4, 5, 6, 7, 8};
        int[][] sort = new int[2][8];
        int minStud = 0;
        int minMark = 0;

        //forloop that organizes the answer count by least to greatest
        for (int i = 0; i < stud.length - 1; i++) {
            minMark = mark[i];
            int minIndex = i;
            minStud = stud[i];
            for (int j = i + 1; j < stud.length; j++) {
                if (mark[j] < minMark) {
                    minMark = mark[j];
                    minIndex = j;
                    minStud = stud[j];
                }
            }
            mark[minIndex] = mark[i];
            mark[i] = minMark;
            stud[minIndex] = stud[i];
            stud[i] = minStud;
        }
        //loop to give the sorted output
        for (int i = 0; i < stud.length; i++) {
            System.out.println("Student " + stud[i] + " has gotten " + mark[i]
                    + " answers correct!");
        }
        System.out.println();
        //returning the SORTED mark to be searched through later on
        return mark;
    }

    /**
     * method name: searchMark description: this method asks the user if they
     * would like to look for a specific mark count among the students
     * @param sort - array that contains the sorted answers from least to
     * greatest.
     **/
    public static void searchMark(int[] sort) {
        //initializing scanners and variables
        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);

        int first = 0;
        int last = sort.length;
        int middle, key;
        int[] stud = {3, 4, 6, 2, 5, 1, 7, 8};
        boolean found = false;
        String choice;
            
        //do while loop that runs the binary search to find desired answer
        do {
            //asking for user input
            System.out.println("Would you like to look for a mark?"
                    + " (yes or no)");
            choice = scanS.nextLine();

            if (choice.equalsIgnoreCase("no"))
                break;
            if (choice.equalsIgnoreCase("yes")) {
                //asking for mark to be found
                System.out.println("What mark would you like to look for "
                        + "(1-10)");
                key = scanN.nextInt();
                
                // binary search
                do {
                    middle = (first + last) / 2;
                    if (sort[middle] > key) 
                        last = middle - 1;
                    else if (sort[middle] < key) 
                        first = middle + 1;
                    else if (sort[middle] == key) 
                        found = true;
                } while (!found && last > first);
                
                if (found = true) {
                //forloop that checks if multiple students got the same mark
                    for (int i = 0; i < sort.length; i++) {
                        if (sort[middle] == sort[i])
                            System.out.println("student " + stud[i]
                            + " has gotten the mark of " + sort[middle]);
                    } break;
                } else {
                    /*i have no idea why this code doesnt run, it just rounds
                    the mark you asked for to the nearest mark in the array
                    */
                    System.out.println("This number is not here!");
                     break;
                }
            }
        } while (!choice.equalsIgnoreCase("yes"));
    }
}

    
