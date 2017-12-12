import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by giuseppeliguori on 09/12/2017.
 */
public class Ten {
    int input[] = new int[] {212,254,178,237,2,0,1,54,167,92,117,125,255,61,159,164};
    int inputTest[] = new int[] {3,4,1,5};

    public Ten() {
        partOne(input);
        partTwo();
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
                    tempArray[added] = array[selectedIndex+added];
                } else {
                    tempArray[added] = array[counter++];
                }
                added++;
            }

            printArray(tempArray);

            for(int j = 0; j < tempArray.length / 2; j++) {
                int temp = tempArray[j];
                tempArray[j] = tempArray[tempArray.length - j - 1];
                tempArray[tempArray.length - j - 1] = temp;
            }

            printArray(tempArray);

            added = 0;
            counter = 0;
            while (added < value) {
                if (selectedIndex + added < array.length) {
                    array[selectedIndex+added] = tempArray[added];
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

        System.out.println("Ten.partOne: " +  (array[0]*array[1]));
    }

    public void partTwo() {

    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("["+String.format("%03d", array[i])+"]");
        }
        System.out.println("Ten.printArray");
    }
}
