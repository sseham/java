package selectsort;

import java.util.Scanner;

public class SelectSort {

    public static Scanner scanN = new Scanner(System.in);

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
//        search(nums);

//        int[] num = {7, 2, 8, 1, 9, 13, 15, 10, 4, 6, 12, 3, 14, 5, 0, 11};
//
//        for (int i = 0; i < num.length - 1; i++) {
//            int minValue = num[i];
//            int minIndex = i;
//            for (int j = i + 1; j < num.length; j++) {
//                if (num[j] < minValue) {
//                    minValue = num[j];
//                    minIndex = j;
//                }
//            }
//            num[minIndex] = num[i];
//            num[i] = minValue;
//        }
//        for (int i = 0; i < num.length; i++) {
//            System.out.print(num[i] + " ");
//        }
//
//        String[] letter = {"g", "a", "o", "j", "e", "z", "y", "d", "r", "p",
//            "l", "s", "q", "h", "m", "t", "b", "x", "u", "c", "v", "f", "i", 
//            "n", "k",};
//
//        for (int i = 0; i < letter.length - 1; i++) {
//            String minLet = letter[i];
//            int minIndex = i;
//            for (int j = i + 1; j < letter.length; j++) {
//                if (letter[j].compareToIgnoreCase(minLet) < 0) {
//                    minLet = letter[j];
//                    minIndex = j;
//                }
//            }
//            letter[minIndex] = letter[i];
//            letter[i] = minLet;
//        }
//        System.out.println();
//        for (int i = 0; i < letter.length; i++) {
//            System.out.print(letter[i] + " ");
//        }
//        String[] name = {"bowman", "walker", "christian", "edwards", "cummings",
//            "scott", "halpern", "rhineheart", "haley", "brooks"};
//        String[] sex = {"m", "f", "m", "m", "m", "f", "m", "f", "f",
//            "m"};
//        String[] car = {"saturns", "old", "chev", "chev", "ford", "chev",
//            "ford", "cad", "honda", "ford"};
//        int[] year = {1999, 2000, 2001, 2003, 2004, 2002, 2006, 2005, 2002,
//            2004};
//
//        for (int i = 0; i < name.length - 1; i++) {
//            String minName = name[i];
//            int minIndex = i;
//            String minCar = car[i]; 
//            String minSex = sex[i];
//            int minYear = year[i];
//            for (int j = i + 1; j < name.length; j++) {
//                if (name[j].compareToIgnoreCase(minName) < 0) {
//                    minName = name[j];
//                    minIndex = j;
//                    minSex = sex[j];
//                    minCar = car[j];
//                    minYear = year[j];
//                }
//            }
//            name[minIndex] = name[i];
//            name[i] = minName;
//            sex[minIndex] = sex[i];
//            sex[i] = minSex;
//            car[minIndex] = car[i];
//            car[i] = minCar;
//            year[minIndex] = year[i];
//            year[i] = minYear;
//        }
//        System.out.println();
//        for (int i = 0; i < name.length; i++) {
//            System.out.println("\t\t\t"  + name[i] + "\t\t\t" + sex[i] + 
//                    "\t\t\t" + car[i] + "\t\t\t" + year[i]);
//        }
//    }
//
//    public static boolean search(int[] num) {
//        int first = 0;
//        int last = num.length - 1;
//        int middle, key;
//        int count = 0;
//        boolean found = false;
//
//        System.out.println("what number would you like to look for 1-30");
//        key = scanN.nextInt();
//        do {
//            count++;
//            middle = (first + last) / 2;
//            if (num[middle] == key) {
//                found = true;
//                count++;
//            } else if (num[middle] > key) {
//                last = middle - 1;
//                count++;
//            } else if (num[middle] < key) {
//                first = middle + 1;
//                count++;
//            }
//        } while (!found && last < first);
//        System.out.println("your number: " + key + ", was found in " + count
//                + " step(s)!");
//        
//        return found;
//    }
//initializing variables,, student answers and the answer key
        // binary search
//            do {
//            middle = (first + last) / 2;
//            if (sort[middle] > key) 
//                last = middle - 1;
//            if (sort[middle] < key) 
//                first = middle + 1;
//            if (sort[middle] == key) 
//                found = true;
//            
//        } while(!found && last>first);
//            if (found=true)
//        System.out.println("student " + stud[middle]
//                + " has gotten the mark of " + key);
//            else 
//                System.out.println("This number is not here!");
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
     *
     * @param key - the correct answer key of the test
     * @param answers - a 2d array of all the student answers
     * @return mark - the numbers of correct answers each student got
     *
     */
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
                if (key[col] != answers[row][col]) {
                    calc[row][col] = 0;
                }
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
     *
     * @param mark - the students mark count
     * @return sort - array that contains the sorted students marks.
     *
     */
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
     *
     * @param sort - array that contains the sorted answers from least to
     * greatest.
     *
     */
    public static void searchMark(int[] sort) {
        //initializing scanners and variables
        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);

        int first = 0;
        int last = sort.length - 1;
        int middle, key;
        int[] stud = {3, 4, 6, 2, 5, 1, 7, 8};
        boolean found = false;
        String choice;

        //do while loop that runs the binary search to find desired answer
        do {
            System.out.println("Would you like to look for a mark?"
                    + " (yes or no)");
            choice = scanS.nextLine();

            if (choice.equalsIgnoreCase("no")) {
                break;
            }
            if (choice.equalsIgnoreCase("yes")) {

                System.out.println("What mark would you like to look for (1-10)");
                key = scanN.nextInt();
                // binary search
                while (!found && first < last) {
                    middle = (first + last) / 2;
                    if (sort[middle] == key) 
                        found = true;
                     else if (sort[middle] > key) 
                        last = middle - 1;
                else if (sort[middle] < key)
                    first = middle + 1;
                }
                if (found=true)
        System.out.println("student " + stud[middle]
                + " has gotten the mark of " + key);
            else 
                System.out.println("This number is not here!");
            if (choice.equalsIgnoreCase("no")) 
                break;
        }
       
//            do {
//            middle = (first + last) / 2;
//            if (sort[middle] > key) 
//                last = middle - 1;
//            if (sort[middle] < key) 
//                first = middle + 1;
//            if (sort[middle] == key) 
//                found = true;
//            
//        } while(!found && last>first);
//            if (found=true)
//        System.out.println("student " + stud[middle]
//                + " has gotten the mark of " + key);
//            else 
//                System.out.println("This number is not here!");
//            if (choice.equalsIgnoreCase("no")) 
//                break;
//        }
//        } while (!choice.equalsIgnoreCase("yes") || 
//                !choice.equalsIgnoreCase("no"));


}
            }
