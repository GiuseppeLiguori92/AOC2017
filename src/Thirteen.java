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
                        for (int i = 0; i < (index - currentIndex); i++) {
                            firewall.add(currentIndex++, new FirewallLine(new Character[0], -1, true));
                        }
                    }

                    firewall.add(currentIndex++, new FirewallLine(new Character[depth], -1, true));
                }
        );

        resetFirewall();

        for (int picosecond = 0; picosecond < 8; picosecond++) {
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
                }
            }
            printFirewall();
            resetFirewall();
        }
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
