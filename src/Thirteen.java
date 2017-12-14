import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by giuseppeliguori on 09/12/2017.
 */
public class Thirteen {
    String inputTest = "0: 3\n" +
            "1: 2\n" +
            "4: 4\n" +
            "6: 4";
    String input = "";

    public Thirteen() {
//        partOne(input);
        partOne(inputTest);
//        partTwo(inputeTest1);
    }

    int currentIndex = 0;
    List<Character[]> firewall = new ArrayList<>();

    public void partOne(String input) {
        (Arrays.asList(input.split("\\n"))).forEach(
                line -> {
                    line = line.replace(" ", "");
                    int index = Integer.parseInt(line.split(":")[0]);
                    int depth = Integer.parseInt(line.split(":")[1]);
                    if (index != currentIndex) {
                        for (int i = 0; i < (index - currentIndex); i++) {
                            firewall.add(currentIndex++, new Character[0]);
                        }
                    }

                    firewall.add(currentIndex++, new Character[depth]);
                }
        );

        resetFirewall();

        for (int picosecond = 0; picosecond < 8; picosecond++) {
            for (int i = 0; i < firewall.size(); i++) {
                Character[] firewalLine = firewall.get(i);
                if (firewalLine.length > 0) {
                    int val = (picosecond / firewalLine.length );
                    boolean direction = val % 2 == 0;
                    int value = (picosecond % firewalLine.length);
                    int index = direction ?
                            value : (firewalLine.length-value-1-1);
                    firewalLine[index] = 'S';
                    System.out.println(" " + direction + " " + val + " " + value + " " + index);
                }
            }
            printFirewall();
            resetFirewall();
        }
    }

    private void printFirewall() {
        for (int i = 0; i < firewall.size(); i++) {
            Character[] firewalLine = firewall.get(i);
            System.out.print(i + " ");
            for (int j = 0; j < firewalLine.length; j++) {
                System.out.print("[" + firewalLine[j] + "]");
            }
            System.out.println(" ");
        }

        System.out.println(" ");
    }

    private void resetFirewall() {
        for (int i = 0; i < firewall.size(); i++) {
            Character[] firewalLine = firewall.get(i);
            for (int j = 0; j < firewalLine.length; j++) {
                firewalLine[j] = ' ';
            }
        }
    }

    public void partTwo(String input) {

    }
}
