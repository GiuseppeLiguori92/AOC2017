/**
 * Created by giuseppeliguori on 01/12/2017.
 */
public class Three {

    public Three() {
        partOne();
        partTwo();
    }

    private void partOne() {
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


    int rows = 11;
    int cols = 11;

    private void partTwo() {

        int[][] matrix = new int[rows][cols];

        int numberOfSquares = rows / 2;
        int selectedRow = rows / 2;
        int selectedCol = cols / 2;

        matrix[selectedRow][selectedCol] = 1;

        for (int i = 0; i < numberOfSquares - 1; i++) {

            selectedCol++;

            int forN = 2 * i + 2;

            for (int j = 0; j < forN; j++) {
                matrix[selectedRow][selectedCol] = getValueInMatrix3x3(matrix, selectedRow, selectedCol);
                selectedRow--;
            }

            selectedCol--;
            selectedRow++;

            for (int j = 0; j < forN; j++) {
                matrix[selectedRow][selectedCol] = getValueInMatrix3x3(matrix, selectedRow, selectedCol);
                selectedCol--;
            }

            selectedCol++;
            selectedRow++;

            for (int j = 0; j < forN; j++) {
                matrix[selectedRow][selectedCol] = getValueInMatrix3x3(matrix, selectedRow, selectedCol);
                selectedRow++;
            }

            selectedCol++;
            selectedRow--;

            for (int j = 0; j < forN; j++) {
                matrix[selectedRow][selectedCol] = getValueInMatrix3x3(matrix, selectedRow, selectedCol);
                selectedCol++;
            }

            selectedCol--;

        }

        printMatrix(matrix);
    }

    private int getValueInMatrix3x3(int[][] matrix, int row, int col) {
        row = row-1;
        col = col-1;
        int sum = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                try {
                    sum += matrix[row+r][col+c];
                } catch (IndexOutOfBoundsException e) {}
            }
        }

        return sum;
    }


    private void printMatrix(int[][] matrix) {
        int val = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(String.format(" %07d", matrix[r][c]));
                if (matrix[r][c] > 368078) {
                    val = matrix[r][c];
                    System.out.println("");
                    System.out.println("*************");
                    System.out.println("*************");
                    System.out.println("****"+ val + "***");
                    System.out.println("*************");
                    System.out.println("*************");
                    System.exit(1);
                }
            }
            System.out.println("");
        }
        System.out.println("*************");
    }
}
