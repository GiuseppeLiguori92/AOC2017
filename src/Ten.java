/**
 * Created by giuseppeliguori on 09/12/2017.
 */
public class Ten {
    int input[] = new int[]{212, 254, 178, 237, 2, 0, 1, 54, 167, 92, 117, 125, 255, 61, 159, 164};
    int inputTest[] = new int[]{3, 4, 1, 5};

    int[] input2 = new int[]{50, 49, 50, 44, 50, 53, 52, 44, 49, 55, 56, 44, 50, 51, 55, 44, 50, 44, 48, 44, 49, 44, 53, 52, 44, 49, 54, 55, 44, 57, 50, 44, 49, 49, 55, 44, 49, 50, 53, 44, 50, 53, 53, 44, 54, 49, 44, 49, 53, 57, 44, 49, 54, 52, 17, 31, 73, 47, 23};

    public Ten() {
        partOne(input);
        partTwo(input2);
    }

    public void partOne(int[] input) {
        int[] array = new int[256];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        printArray(array);

        int skip = 0;
        int selectedIndex = 0;

        for (int i = 0; i < input.length; i++) {
            int value = input[i];

            int[] tempArray = new int[value];

            int added = 0;
            int counter = 0;
            while (added < value) {
                if (selectedIndex + added < array.length) {
                    tempArray[added] = array[selectedIndex + added];
                } else {
                    tempArray[added] = array[counter++];
                }
                added++;
            }

            printArray(tempArray);

            for (int j = 0; j < tempArray.length / 2; j++) {
                int temp = tempArray[j];
                tempArray[j] = tempArray[tempArray.length - j - 1];
                tempArray[tempArray.length - j - 1] = temp;
            }

            printArray(tempArray);

            added = 0;
            counter = 0;
            while (added < value) {
                if (selectedIndex + added < array.length) {
                    array[selectedIndex + added] = tempArray[added];
                } else {
                    array[counter++] = tempArray[added];
                }
                added++;
            }

            printArray(array);

            selectedIndex = selectedIndex + value + skip;
            if (selectedIndex % array.length != 0) {
                selectedIndex = selectedIndex % array.length;
            }


            skip++;


            printArray(array);
        }

        System.out.println("Ten.partOne: " + (array[0] * array[1]));
    }

    public void partTwo(int[] input) {
        int[] array = new int[256];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        printArray(array);

        int skip = 0;
        int selectedIndex = 0;

        for (int round = 0; round < 64; round++) {
            for (int i = 0; i < input.length; i++) {
                int value = input[i];

                int[] tempArray = new int[value];

                int added = 0;
                int counter = 0;
                while (added < value) {
                    if (selectedIndex + added < array.length) {
                        tempArray[added] = array[selectedIndex + added];
                    } else {
                        tempArray[added] = array[counter++];
                    }
                    added++;
                }

                printArray(tempArray);

                for (int j = 0; j < tempArray.length / 2; j++) {
                    int temp = tempArray[j];
                    tempArray[j] = tempArray[tempArray.length - j - 1];
                    tempArray[tempArray.length - j - 1] = temp;
                }

                printArray(tempArray);

                added = 0;
                counter = 0;
                while (added < value) {
                    if (selectedIndex + added < array.length) {
                        array[selectedIndex + added] = tempArray[added];
                    } else {
                        array[counter++] = tempArray[added];
                    }
                    added++;
                }

                printArray(array);

                selectedIndex = selectedIndex + value + skip;
                if (selectedIndex % array.length != 0) {
                    selectedIndex = selectedIndex % array.length;
                }

                skip++;

                printArray(array);
            }
        }

        int[] dash = new int[16];
        int xor = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
            counter++;
            if (counter % 16 == 0 && i != 0) {
                dash[i/16] = xor;
                xor = 0;
                counter=0;
            }
        }

        printArray2(dash);

//        dash[0] = 64;
//        dash[1] = 7;
//        dash[2] = 255;
        String hex = "";
        for (int i = 0; i < dash.length; i++) {
            hex += String.format("%02X", dash[i] & 0xFF);
        }
        System.out.println("Ten.partTwo: " + hex);

    }

    private void printArray(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            System.out.print("[" + String.format("%03d", array[i]) + "]");
//        }
//        System.out.println("Ten.printArray");
    }

    private void printArray2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + String.format("%03d", array[i]) + "]");
        }
        System.out.println(" ");
    }
}
