package matrix;

public class Matrix {

    public static void main(String[] args) {

        String[][] animal = {
            {"cats", "milo", "meno", "nelson", "luna", "alexa", "austin", "kae"},
            {"dogs", "kira", "shiva", "rex", "daniel", "carlos", "ricky",
                "terry"},
            {"fish", "toby", "alex", "flop", "jae", "kiki", "beta", "simon"}};
        
        for (int row = 0; row < animal.length; row++) {
            System.out.println();
            for (int j = 0; j < animal[row].length; j++) {
                System.out.print(animal[row][j] + "\t");
            }
        }
        String[][] umm = new String[8][9];

        for (int row = 0; row < umm.length; row++) {
            for (int col = 0; col < umm[row].length; col++) {
                umm[row][col] = "[" + row + "]" + "[" + col + "]";
            }
        }
        for (int row = 0; row < umm.length; row++) {
            for (int col = 0; col < umm[row].length; col++) {
                System.out.print(umm[row][col] + "\t");
            }
            System.out.println();
        }

        int[][] num = new int[11][11];

        for (int row = 1; row < num.length; row++) {
            num[row][0] = row;
            num[0][row] = row;
        }
        for (int row = 1; row < num.length; row++) {
            for (int col = 1; col < num[row].length; col++) {
                num[row][col] = row * col;
            }
        }
        for (int row = 0; row < num.length; row++) {
            for (int col = 0; col < num[row].length; col++) {
                System.out.print("[" + num[row][col] + "]\t");
            }
            System.out.println();
        }
    }

}
