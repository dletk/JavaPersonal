package Algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by DucLe on 5/16/17.
 */
public class BigSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for (int i = 0; i < n; i++) {
            unsorted[i] = in.next();
        }

        // Solutions
        class BigSortingComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        }

        Arrays.sort(unsorted, new BigSortingComparator());

        for (String num: unsorted) {
            System.out.println(num);
        }
    }
}
