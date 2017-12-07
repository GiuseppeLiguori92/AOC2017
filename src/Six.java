import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by giuseppeliguori on 01/12/2017.
 */
public class Six {

    String input = "0\t5\t10\t0\t11\t14\t13\t4\t11\t8\t8\t7\t1\t4\t12\t11";
    String inputTest = "0\t2\t7\t0";

    public Six() {
//        partOne(input);
        partTwo(input);
    }

    private void partOne(String input) {
        List<Integer> values = new ArrayList<>();
        (Arrays.asList(input.split("\\t"))).forEach(
                value -> {
                    values.add(Integer.valueOf(value));
                }
        );

        Integer[] numbers = values.toArray(new Integer[values.size()]);

        boolean loopFound = false;

        int counter = 0;
        List<String> results = new ArrayList<>();
        while (!loopFound) {
            int maxIndex = numbers.length;
            int max = 0;
            for (int i = numbers.length - 1; i > -1; i--) {
                if (numbers[i] >= max) {
                    maxIndex = i;
                    max = numbers[i];
                }
            }

            int maxValue = max;
            System.out.println("Six.partOne: " + maxIndex + " " + maxValue);

            int nextIndex = maxIndex + 1;
            int distributedBlock = 0;


            numbers[maxIndex] = 0;

            while (distributedBlock < maxValue) {

                if (nextIndex > numbers.length - 1) {
                    nextIndex = 0;
                }

                numbers[nextIndex] = numbers[nextIndex] + 1;

                nextIndex++;

                distributedBlock++;
            }

            String currentResult = "";
            for (int i = 0; i < numbers.length; i++) {
                currentResult += String.valueOf(numbers[i]);
            }

            counter++;
            for (String result : results) {
                if (result.equals(currentResult)) {
                    System.out.println("Six.partOne FOUND: " + counter);
                    loopFound = true;
                }
            }

            results.add(currentResult.toString());

        }
    }

    private void partTwo(String input) {
        List<Integer> values = new ArrayList<>();
        (Arrays.asList(input.split("\\t"))).forEach(
                value -> {
                    values.add(Integer.valueOf(value));
                }
        );

        Integer[] numbers = values.toArray(new Integer[values.size()]);

        String originalLoop = "";

        boolean loopFound = false;

        int counter = 0;
        while (!loopFound) {
            int maxIndex = numbers.length;
            int max = 0;
            for (int i = numbers.length - 1; i > -1; i--) {
                if (numbers[i] >= max) {
                    maxIndex = i;
                    max = numbers[i];
                }
            }

            int maxValue = max;

            int nextIndex = maxIndex + 1;
            int distributedBlock = 0;


            numbers[maxIndex] = 0;

            while (distributedBlock < maxValue) {

                if (nextIndex > numbers.length - 1) {
                    nextIndex = 0;
                }

                numbers[nextIndex] = numbers[nextIndex] + 1;

                nextIndex++;

                distributedBlock++;
            }

            String currentResult = "";
            for (int i = 0; i < numbers.length; i++) {
                currentResult += String.valueOf(numbers[i]);
            }

            if (counter == 0) {
                originalLoop = currentResult.toLowerCase();
                counter++;
                continue;
            }

            System.out.println("["+ counter +"] " + originalLoop + " == " + currentResult);

            if (originalLoop.equals(currentResult)) {
                System.out.println("Six.partTwo FOUND: " + counter);
                loopFound = true;
            }

            counter++;

            printArray(numbers);
        }
    }

    private void printArray(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
        System.out.println(" ");
    }

}
