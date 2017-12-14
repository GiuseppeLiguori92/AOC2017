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

    String input = "0: 5\n" +
            "1: 2\n" +
            "2: 3\n" +
            "4: 4\n" +
            "6: 6\n" +
            "8: 4\n" +
            "10: 8\n" +
            "12: 6\n" +
            "14: 6\n" +
            "16: 14\n" +
            "18: 6\n" +
            "20: 8\n" +
            "22: 8\n" +
            "24: 10\n" +
            "26: 8\n" +
            "28: 8\n" +
            "30: 10\n" +
            "32: 8\n" +
            "34: 12\n" +
            "36: 9\n" +
            "38: 20\n" +
            "40: 12\n" +
            "42: 12\n" +
            "44: 12\n" +
            "46: 12\n" +
            "48: 12\n" +
            "50: 12\n" +
            "52: 12\n" +
            "54: 12\n" +
            "56: 14\n" +
            "58: 14\n" +
            "60: 14\n" +
            "62: 20\n" +
            "64: 14\n" +
            "66: 14\n" +
            "70: 14\n" +
            "72: 14\n" +
            "74: 14\n" +
            "76: 14\n" +
            "78: 14\n" +
            "80: 12\n" +
            "90: 30\n" +
            "92: 17\n" +
            "94: 18";

    public Thirteen() {
//        partOne(input);
        partOne(input);
//        partTwo(inputeTest1);
    }

    int currentIndex = 0;

    List<FirewallLine> firewall = new ArrayList<>();

    public class FirewallLine {
        Character[] line;
        int index;
        boolean verse;

        public FirewallLine(Character[] line, int index, boolean verse) {
            this.line = line;
            this.index = index;
            this.verse = verse;
        }
    }

    public void partOne(String input) {
        (Arrays.asList(input.split("\\n"))).forEach(
                line -> {
                    line = line.replace(" ", "");
                    int index = Integer.parseInt(line.split(":")[0]);
                    int depth = Integer.parseInt(line.split(":")[1]);
                    if (index != currentIndex) {
                        int remain = index-currentIndex;
                        for (int i = 0; i < remain; i++) {
                            firewall.add(new FirewallLine(new Character[0], -1, true));
                        }
                    }

                    firewall.add(new FirewallLine(new Character[depth], -1, true));
                    currentIndex = index+1;
                }
        );

        resetFirewall();

        int severity = 0;
        for (int picosecond = 0; picosecond < firewall.size(); picosecond++) {
            for (int i = 0; i < firewall.size(); i++) {
                FirewallLine firewallLine = firewall.get(i);

                if (firewallLine.line.length > 0) {
                    int index = firewallLine.index;

                    if (firewallLine.verse) {
                        index += 1;
                        if (index == firewallLine.line.length - 1) {
                            firewallLine.verse = !firewallLine.verse;
                        }
                    } else {
                        index -= 1;
                        if (index == 0) {
                            firewallLine.verse = !firewallLine.verse;
                        }
                    }
                    firewallLine.index = index;
                    firewallLine.line[index] = 'S';

                    if (i == picosecond) {
                        if (firewallLine.index == 0) {
                            severity += (i * firewallLine.line.length);
                        }
                    }
                }
            }
            printFirewall();
            resetFirewall();
        }

        System.out.println("Thirteen.partOne: " + severity);
    }

    private void printFirewall() {
        for (int i = 0; i < firewall.size(); i++) {
            FirewallLine firewalLine = firewall.get(i);
            System.out.print(i + " ");
            for (int j = 0; j < firewalLine.line.length; j++) {
                System.out.print("[" + firewalLine.line[j] + "]");
            }
            System.out.println(" ");
        }

        System.out.println(" ");
    }

    private void resetFirewall() {
        for (int i = 0; i < firewall.size(); i++) {
            FirewallLine firewalLine = firewall.get(i);
            for (int j = 0; j < firewalLine.line.length; j++) {
                firewalLine.line[j] = ' ';
            }
        }
    }

    public void partTwo(String input) {

    }
}
