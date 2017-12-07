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


    int rows = 5;
    int cols = 5;

    private void partTwo(String input) {

        int[][] matrix = new int[rows][cols];

        int numberOfSquares = rows / 2;
        int selectedRow = rows / 2;
        int selectedCol = cols / 2;

        int value = 0;

        matrix[selectedRow][selectedCol] = ++value;

        for (int i = 0; i < numberOfSquares; i++) {

            selectedCol++;

            int forN = 2 * i + 2;

            for (int j = 0; j < forN; j++) {
                matrix[selectedRow][selectedCol] = ++value;
                selectedRow--;

//                printMatrix(matrix);
            }

            selectedCol--;
            selectedRow++;

            for (int j = 0; j < forN; j++) {
                matrix[selectedRow][selectedCol] = ++value;
                selectedCol--;

//                printMatrix(matrix);
            }

            selectedCol++;
            selectedRow++;

            for (int j = 0; j < forN; j++) {
                matrix[selectedRow][selectedCol] = ++value;
                selectedRow++;

//                printMatrix(matrix);
            }

            selectedCol++;
            selectedRow--;

            for (int j = 0; j < forN; j++) {
                matrix[selectedRow][selectedCol] = ++value;
                selectedCol++;

//                printMatrix(matrix);
            }

            selectedCol--;

        }

        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(String.format(" %05d", matrix[r][c]));
            }
            System.out.println("");
        }
        System.out.println("*************");
    }
}
