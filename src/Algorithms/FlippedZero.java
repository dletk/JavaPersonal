package Algorithms;

import java.util.Arrays;

/**
 * Created by DucLe on 1/8/17.
 */
public class FlippedZero {
    public static void main(String[] args) {
        System.out.println(checkZero(new int[]{1,0,0,1,1}, 1));
        System.out.println(checkZero(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}, 2));
        System.out.println(checkZero(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}, 1));
        System.out.println(checkZero(new int[]{0,0,0,0,0,0,1,0,0,1}, 20));
    }

    public static String checkZero(int[] anArray, int m) {
        int[] potential_pos = new int[m];
        int[] final_result = new int[m];
        int current_numZero = 0;
        int maximum = 0;
        for (int i = 0; i < anArray.length; i++) {
            for (int j = i; j < anArray.length; j++) {
                // Check to eliminate the sub array that shorter than current maximum length
                if (j - i + 1 > maximum) {
                    // Loop through the sub array
                    for (int pos = i; pos <= j; pos++) {
                        // If the current element in the sub arary is 0 and the total number of zero is < m, then add it
                        if (anArray[pos] == 0) {
                            // Add the position of the zero to the array of position (potential)
                            if (current_numZero < m) {
                                potential_pos[current_numZero] = pos;
                            }
                            // Increment the number of zero encountered by 1.
                            current_numZero++;
                        }
                    }
                    // After looping through the sub array, if the number of zero is m, then that sub array is the new max
                    if (current_numZero <= m) {
                        // Assign the length to be the new max
                        maximum = j - i + 1;
                        // Save the value of position
                        final_result = potential_pos;
                        // Reset the current number of 0s for the next case
                        current_numZero = 0;
                    } else if (current_numZero > m) {
                        // Reset the current number of 0s for the next case
                        current_numZero = 0;
                        break;
                    }
                }
            }
        }
        return Arrays.toString(final_result);
    }
}
