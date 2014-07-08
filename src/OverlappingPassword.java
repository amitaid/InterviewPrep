import java.util.Arrays;

/**
 * Solution to the overlapping password string problem
 * ---------------------------------------------------
 * Return the shortest possible string which contains as a substring all numbers
 * of length n from 0 to 10^n - 1. For n=4, the strings "0000" to "9999".
 */

public class OverlappingPassword {

    // Take an array and a start and end index, and return that slice as an integer.
    public static int arrRangeToInt(int[] arr, int start, int end) {
        int mult = 1;
        int res = 0;
        for (int i = end - 1; i >= start; i--) {
            res += mult * arr[i];
            mult *= 10;
        }
        return res;
    }

    public static String getPasswords(int length) {

        int size = General.exponent(10, length);
        boolean[] exists = new boolean[size]; // There are 10^len possible numbers
        int[] order =
            new int[size + length - 1]; // The length of the result is size + length - 1, with maximum overlap.
        exists[0] = true;
        int index = length; // Set the first entered number to be "0"*len
        int chr = 0;

        while (index < order.length) {
            if (chr > 9) { // We ran out of options. Go back one char and increment it.
                exists[arrRangeToInt(order, index - length, index)] = false;
                index--;
                chr = order[index] + 1;
            } else if (exists[10 * arrRangeToInt(order, index - length + 1, index) +
                              chr]) { // Already added this number. Move on.
                chr++;
            } else { // Legal number that hasn't been entered yet. Add it and reset chr.
                order[index] = chr;
                chr = 0;
                index++;
                exists[arrRangeToInt(order, index - length, index)] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(order).forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        int len = 5;
        System.out.println(getPasswords(len));

    }

}
