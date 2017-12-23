import java.util.ArrayList;
import java.util.List;

/**
 * Created by giuseppeliguori on 09/12/2017.
 */
public class Seventeen {
    String input = "";

    public Seventeen() {
        partOne(input);
    }

    public void partOne(String input) {
        List<Integer> buffer = new ArrayList<>();
        int n = 0;
        buffer.add(n);
        int currentPosition = 0;
        buffer.add(++n);
        currentPosition = 1;

        printList(buffer, currentPosition);

        for (int i = 0; i < 5; i++) {
            currentPosition = buffer.size() - currentPosition + 3;
            currentPosition = currentPosition % buffer.size();
            System.out.println("Seventeen.partOne: " + currentPosition);

            buffer.add(currentPosition, ++n);

            printList(buffer, currentPosition);
        }


    }

    private void printList(List<Integer> buffer, int currentPosition) {
        for (int i = 0; i < buffer.size(); i++) {
            System.out.print("" + (currentPosition == i ? "(" : "") + buffer.get(i) + (currentPosition == i ? ")" : ""));
        }
        System.out.println("------------------------");
    }

    public void partTwo(String input) {

    }
}
