import java.util.ArrayList;
import java.util.List;

/**
 * Created by giuseppeliguori on 09/12/2017.
 */
public class Fifteen {

        long inputA = 289;
//    long inputA = 65;
    long factorA = 16807;

        long inputB = 629;
//    long inputB = 8921;
    long factorB = 48271;

    long divider = 2147483647;

    public Fifteen() {
//        partOne();
        partTwo();
    }

    private void partTwo() {

        List<String> resultsA = new ArrayList<>();
        List<String> resultsB = new ArrayList<>();

        int judgeCounter = 0;
        int accettable = 5000000;
        while (resultsA.size() < accettable || resultsB.size() < accettable) {
            long resultA = (inputA * factorA) % divider;
            long resultB = (inputB * factorB) % divider;

            if (resultA % 4 == 0 && resultsA.size() < accettable) {
                String binaryA = formatBinaryString(Integer.toBinaryString((int) resultA), 16);
                System.out.println("Fifteen.partOne: A: " + resultA);
                String subA = binaryA.substring(binaryA.length() - 16, binaryA.length());
                resultsA.add(subA);
            }

            if (resultB % 8 == 0 && resultsB.size() < accettable) {
                String binaryB = formatBinaryString(Integer.toBinaryString((int) resultB), 16);
                System.out.println("Fifteen.partOne: B: " + resultB);
                String subB = binaryB.substring(binaryB.length() - 16, binaryB.length());
                resultsB.add(subB);
            }
            inputA = resultA;
            inputB = resultB;
//            System.out.println("Fifteen.partOne: " + i);

        }

        int lenA = resultsA.size();
        int lenB = resultsB.size();

        for (int i = 0; i < resultsB.size(); i++) {
            if (resultsA.get(i).equals(resultsB.get(i))) {
                System.out.println("Fifteen.partTwo " + i);
                judgeCounter++;
            }
        }

        System.out.println("Fifteen.partTwo: " + lenA + " " + lenB);

        System.out.println("Fifteen.partOne " + judgeCounter);
    }

    public void partOne() {
        int judgeCounter = 0;
        for (int i = 0; i < 40000000; i++) {
            long resultA = (inputA * factorA) % divider;
            long resultB = (inputB * factorB) % divider;

            String binaryA = formatBinaryString(Integer.toBinaryString((int) resultA), 16);
            String binaryB = formatBinaryString(Integer.toBinaryString((int) resultB), 16);

//            System.out.println("Fifteen.partOne: " + resultA);
//            System.out.println("Fifteen.partOne: " + resultB);
//            System.out.println("Fifteen.partOne");
//            System.out.println("Fifteen.partOne: " + binaryA);
//            System.out.println("Fifteen.partOne: " + binaryB);


            String subA = binaryA.substring(binaryA.length() - 16, binaryA.length());
            String subB = binaryB.substring(binaryB.length() - 16, binaryB.length());

            if (subA.equals(subB)) {
                judgeCounter++;
            }
//            System.out.println("Fifteen.partOne: " + judgeCounter);

            inputA = resultA;
            inputB = resultB;

            System.out.println("Fifteen.partOne: " + i);

        }
        System.out.println("Fifteen.partOne " + judgeCounter);
    }

    private String formatBinaryString(String binaryString, int lenght) {
        int binaryStringLength = binaryString.length();
        if (binaryStringLength < lenght) {
            for (int j = 0; j < lenght - binaryStringLength; j++) {
                binaryString = "0" + binaryString;
//                System.out.println("Fifteen.partOne: " + binaryString);
            }
        }
        return binaryString;
    }
}
