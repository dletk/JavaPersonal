package Algorithms;

import java.util.Arrays;

/**
 * Created by DucLe on 1/8/17.
 */
public class FlippedZero_OPT {
    public static void main(String args[]) {
        int[] something = new int[10000];
        long start = System.currentTimeMillis();
        System.out.println(checkZero(new int[]{1, 0, 0, 1, 1}, 1));
        checkZero(something, 2);
        System.out.println(checkZero(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}, 2));
        System.out.println(checkZero(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}, 1));
        System.out.println(checkZero(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, 20));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static String checkZero(int[] anArray, int m) {
        int[] left_sub = new int[anArray.length];
        int[] right_sub = new int[anArray.length];
        int num_zero = 0;
        int num_ones = 0;
        for (int index = 0; index < anArray.length; index++) {
            if (anArray[index] == 1) {
                num_ones++;
            } else {
                left_sub[index] = num_ones;
                num_ones = 0;
                num_zero++;
            }
        }
        int[] pos_zeros = new int[num_zero];
        num_ones = 0;
        num_zero--;
        for (int index = anArray.length - 1; index >= 0; index--) {
            if (anArray[index] == 1) {
                num_ones++;
            } else {
                right_sub[index] = num_ones;
                num_ones = 0;
                pos_zeros[num_zero] = index;
                num_zero--;
            }
        }
        int max_length = 0;
        int from = 0;
        int to = 0;
        if (m >= pos_zeros.length) {
            return Arrays.toString(pos_zeros);
        } else {
            for (int i = 0; i <= pos_zeros.length - m; i++) {
                int length_sub = left_sub[pos_zeros[i]] + right_sub[pos_zeros[i + m - 1]] + (pos_zeros[i] - pos_zeros[i + m - 1]) + 1;
                if (max_length < length_sub) {
                    max_length = length_sub;
                    from = i;
                    to = i + m - 1;
                }
            }
        }
//        System.out.println(Arrays.toString(left_sub));
//        System.out.println(Arrays.toString(right_sub));
//        System.out.println(Arrays.toString(pos_zeros));
        return Arrays.toString(Arrays.copyOfRange(pos_zeros, from, to + 1));
    }
}
