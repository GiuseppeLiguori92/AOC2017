/**
 * Created by giuseppeliguori on 01/12/2017.
 */
public class Three {

    String input = "";

    public Three() {
//        partOne(input);
        partTwo(input);
    }

    private void partOne(String input) {

        int n = 366025;
        int value = 303;
        int v = 303 * 2 - 1;
        boolean firstshot = true;
        boolean change = true;
        for (int i = 366026; i < 368449; i++) {
            System.out.println("Three.partOne: " + String.format("%d : %d", i, v));

            if (v > value && firstshot) {
                v = v - 1;
            } else if (firstshot) {
                firstshot = false;
                System.out.println("**************************************************");
                System.out.println("**************************************************");
                System.out.println("**************************************************");
            }


            if (firstshot == false) {
                if (v <= 606 && change) {
                    v = v + 1;
                    if (v == 606) {
                        change = !change;
                        System.out.println("**************************************************");
                        System.out.println("**************************************************");
                        System.out.println("**************************************************");
                    }
                } else if (!change) {
                    v = v - 1;
                    if (v == 303) {
                        change = !change;
                        System.out.println("**************************************************");
                        System.out.println("**************************************************");
                        System.out.println("**************************************************");
                    }
                }
            }
        }
    }


    int rows = 7;
    int cols = 7;

    private void partTwo(String input) {

        int[][] matrix = new int[rows][cols];


        int startR = rows / 2;
        int startC = cols / 2;


        matrix[startR][startC] = 1;

        matrix[startR][startC + 1] = 2;

        matrix[startR - 1][startC + 1] = 3;

        matrix[startR - 1][startC] = 4;

        matrix[startR - 1][startC - 1] = 5;

        matrix[startR][startC - 1] = 6;
//
        matrix[startR+1][startC - 1] = 7;

        matrix[startR + 1][startC] = 8;
//
        matrix[startR + 1][startC + 1] = 9;
//
//        matrix[startR + 1][startC + 1] = 10;
//
        // 8    - 16   - 24 -
        // 2ˆ3    2ˆ4   2ˆ5
        for (int index = 1; index < 4; index++) {
            matrix[startR + index][startC + index] = 8 * index + matrix[startR + index - 1][startC + index - 1];
            for (int i = 0; i < 2; i++) {
                matrix[startR + index][startC + index - i] = (int) (1 + Math.pow(2, 3*index)) - i;
            }
        }


        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(String.format(" %02d", matrix[r][c]));
            }
            System.out.println("");
        }
    }
}
