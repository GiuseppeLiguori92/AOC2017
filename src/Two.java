import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by giuseppeliguori on 01/12/2017.
 */
public class Two {

    String input = "86\t440\t233\t83\t393\t420\t228\t491\t159\t13\t110\t135\t97\t238\t92\t396\n" +
            "3646\t3952\t3430\t145\t1574\t2722\t3565\t125\t3303\t843\t152\t1095\t3805\t134\t3873\t3024\n" +
            "2150\t257\t237\t2155\t1115\t150\t502\t255\t1531\t894\t2309\t1982\t2418\t206\t307\t2370\n" +
            "1224\t343\t1039\t126\t1221\t937\t136\t1185\t1194\t1312\t1217\t929\t124\t1394\t1337\t168\n" +
            "1695\t2288\t224\t2667\t2483\t3528\t809\t263\t2364\t514\t3457\t3180\t2916\t239\t212\t3017\n" +
            "827\t3521\t127\t92\t2328\t3315\t1179\t3240\t695\t3144\t3139\t533\t132\t82\t108\t854\n" +
            "1522\t2136\t1252\t1049\t207\t2821\t2484\t413\t2166\t1779\t162\t2154\t158\t2811\t164\t2632\n" +
            "95\t579\t1586\t1700\t79\t1745\t1105\t89\t1896\t798\t1511\t1308\t1674\t701\t60\t2066\n" +
            "1210\t325\t98\t56\t1486\t1668\t64\t1601\t1934\t1384\t69\t1725\t992\t619\t84\t167\n" +
            "4620\t2358\t2195\t4312\t168\t1606\t4050\t102\t2502\t138\t135\t4175\t1477\t2277\t2226\t1286\n" +
            "5912\t6261\t3393\t431\t6285\t3636\t4836\t180\t6158\t6270\t209\t3662\t5545\t204\t6131\t230\n" +
            "170\t2056\t2123\t2220\t2275\t139\t461\t810\t1429\t124\t1470\t2085\t141\t1533\t1831\t518\n" +
            "193\t281\t2976\t3009\t626\t152\t1750\t1185\t3332\t715\t1861\t186\t1768\t3396\t201\t3225\n" +
            "492\t1179\t154\t1497\t819\t2809\t2200\t2324\t157\t2688\t1518\t168\t2767\t2369\t2583\t173\n" +
            "286\t2076\t243\t939\t399\t451\t231\t2187\t2295\t453\t1206\t2468\t2183\t230\t714\t681\n" +
            "3111\t2857\t2312\t3230\t149\t3082\t408\t1148\t2428\t134\t147\t620\t128\t157\t492\t2879";

    public Two() {
        partOneBest(input);
        partOne(input);
        partTwo(input);
    }

    int sum = 0;
    private void partOneBest(String input) {
        Arrays.asList(input.split("\\n")).forEach(line -> {
            List<Integer> integers = new ArrayList<>();
            Arrays.asList(line.split("\\t")).forEach(number -> integers.add(Integer.valueOf(number)));
            sum += (Collections.max(integers) - Collections.min(integers));
        });
        System.out.println("Two.partOne: [" + sum + "]");
    }

    private void partOne(String input) {
        String[] lines = input.split("\\n");
        int sum = 0;
        for (int i = 0; i < lines.length; i++) {
            String[] numbersString = lines[i].split("\\t");

            int[] numbers = new int[numbersString.length];

            int max = -1;
            int min = Integer.MAX_VALUE;
            int diff;

            for (int j = 0; j < numbersString.length; j++) {
                numbers[j] = Integer.valueOf(numbersString[j]);

                if (max == -1 || numbers[j] > max) {
                    max = numbers[j];
                }

                if (numbers[j] < min) {
                    min = numbers[j];
                }
            }

            diff = max - min;
//            System.out.println("Two.partOne: [" + max + "][" + min + "] [" + diff + "]");
            sum += diff;
        }
        System.out.println("Two.partOne: [" + sum + "]");
    }

    private void partTwo(String input) {
        String[] lines = input.split("\\n");
        int sum = 0;
        for (int i = 0; i < lines.length; i++) {
            String[] numbersString = lines[i].split("\\t");
            int[] numbers = new int[numbersString.length];

            for (int j = 0; j < numbersString.length; j++) {
                numbers[j] = Integer.valueOf(numbersString[j]);
            }

            for (int j = 0; j < numbers.length; j++) {
                for (int k = 0; k < numbers.length; k++) {
                    if (numbers[k] > numbers[j] || j == k) {
                        continue;
                    }

                    if (numbers[j] % numbers[k] == 0) {
                        double div = (double) numbers[j] / (double) numbers[k];
                        sum += div;
//                        System.out.println("Two.partTwo: " + String.format("[%d] %f result[%d]", i, div, sum));
                    }
                }
            }
        }
        System.out.println("Two.partTwo: " + String.format("[%d]", sum));
    }
}
