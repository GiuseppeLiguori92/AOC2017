import java.nio.charset.StandardCharsets;

/**
 * Created by giuseppeliguori on 09/12/2017.
 */
public class Fourteen {
    String input = "uugsqrei";

    public Fourteen() {
        partOne(input);
    }

    public void partOne(String input) {
        char[][] matrix = new char[128][128];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                matrix[r][c] = ' ';
            }
        }

        int used = 0;
        Ten ten = new Ten();
        for (int i = 0; i < 128; i++) {
            String inputEdited = String.format("%s-%d", input, i);
            byte[] bytes = inputEdited.getBytes(StandardCharsets.US_ASCII);
            byte[] bytesPlus = new byte[bytes.length + 5];
            int j = 0;
            for (j = 0; j < bytes.length; j++) {
                bytesPlus[j] = bytes[j];
            }
            bytesPlus[j++] = 17;
            bytesPlus[j++] = 31;
            bytesPlus[j++] = 73;
            bytesPlus[j++] = 47;
            bytesPlus[j++] = 23;


            String hex = ten.partTwo(bytesPlus);
//            System.out.println("Fourteen.partOne: " + inputEdited + " " + hex);
            int counter = 0;
            String output = "";

            for (int jjj = 0; jjj < hex.length(); jjj++) {
                int decimal = Integer.parseInt("" + hex.charAt(jjj), 16);
                String binary = Integer.toBinaryString(decimal);
                int len = binary.length();
                // WTF????
                if (len == 0) {
                    binary = "0000";
                } else if (len == 1) {
                    binary = "000" + binary;
                } else if (len == 2) {
                    binary = "00" + binary;
                } else if (len == 3) {
                    binary = "0" + binary;
                }
//                System.out.println("Fourteen.partOne: " + hex.charAt(jjj) + " = " + decimal);
//                System.out.println("Fourteen.partOne: " + decimal + " = " + binary);

                for (int k = 0; k < binary.length(); k++) {
                    if (binary.charAt(k) == '1') {
                        used++;
                    }
                    output += binary.charAt(k) == '0' ? '.' : '#';
                    counter++;
                }

            }
//            System.out.println("" + output);
            for (int k = 0; k < output.length(); k++) {
                matrix[i][k] = output.charAt(k);
            }
            output = "";
        }

        this.matrix = matrix;
        printMatrix();
        System.out.println("Fourteen.partOne: " + used);

        partTwo();
    }

    char[][] matrix;

    public void printMatrix() {
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("************************************************");
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print("" + matrix[r][c]);
            }
            System.out.println(" ");
        }
    }

    public void partTwo() {
        int counter = 0;
        char character = 49;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] == '#') {
                    char characterNumber = character;
                    matrix[r][c] = characterNumber;

                    createGroup(r, c, characterNumber);
                    character++;
                    counter++;
                    printMatrix();
                }
            }
        }
        printMatrix();
        System.out.println("Fourteen.partTwo: " + counter);
    }

    private void createGroup(int startR, int startC, char characterNumber) {
        //matrix[2][3] = '#';

        int c = startC + 1;
        while (true) {
            if (startR > matrix.length - 1 || startR < 0 ||
                    c > matrix.length - 1 || c < 0) {
                break;
            }
            if (matrix[startR][c] == '#') {
                matrix[startR][c] = characterNumber;
                createGroup(startR, c, characterNumber);
                c++;
            } else {
                break;
            }
        }

        c = startC - 1;
        while (true) {
            if (startR > matrix.length - 1 || startR < 0 ||
                    c > matrix.length - 1 || c < 0) {
                break;
            }
            if (matrix[startR][c] == '#') {
                matrix[startR][c] = characterNumber;
                createGroup(startR, c, characterNumber);
                c--;
            } else {
                break;
            }
        }

        c = startC;
        int r = startR - 1;
        while (true) {
            if (r > matrix.length - 1 || r < 0 ||
                    c > matrix.length - 1 || c < 0) {
                break;
            }
            if (matrix[r][c] == '#') {
                if (matrix[startR][c] == characterNumber) {
                    matrix[r][c] = characterNumber;
                    createGroup(r, c, characterNumber);
                } else if (c - 1 >= 0 && matrix[r][c - 1] == characterNumber){
                    matrix[r][c] = characterNumber;
                    createGroup(r, c, characterNumber);
                }
            }
            c--;

            if (c == 0) {
                c = startC;
                if (matrix[r][c] == characterNumber) {
                    while (true) {
                        c++;
                        if (c == matrix.length) {
                            break;
                        }

                        if (matrix[r][c] == '#') {
                            matrix[r][c] = characterNumber;
                            createGroup(r, c, characterNumber);
                        } else {
                            break;
                        }
                    }
                }
                break;
            }

        }

        c = startC;
        r = startR + 1;
        while (true) {
            if (r > matrix.length - 1 || r < 0 ||
                    c > matrix.length - 1 || c < 0) {
                break;
            }
            if (matrix[r][c] == '#') {
                if (matrix[startR][c] == characterNumber) {
                    matrix[r][c] = characterNumber;
                    createGroup(r, c, characterNumber);
                } else if (c - 1 >= 0 && matrix[r][c - 1] == characterNumber) {
                    matrix[r][c] = characterNumber;
                    createGroup(r, c, characterNumber);
                }
            }
            c++;

            if (c == matrix.length) {
                c = startC;
                if (matrix[r][c] == characterNumber) {
                    while (true) {
                        c--;
                        if (c < 0) {
                            break;
                        }

                        if (matrix[r][c] == '#') {
                            matrix[r][c] = characterNumber;
                            createGroup(r, c, characterNumber);
                        } else {
                            break;
                        }
                    }
                }
                break;
            }
        }

//        printMatrix(matrix);
    }
}
