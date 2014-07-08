import java.util.Arrays;

/**
 * @author amitay
 */

public class OverlappingPassword {

    public static int arrRangeToInt(int[] arr, int start, int end) {
        int mult = 1;
        int res = 0;
        for (int i = end - 1; i >= start; i--) {
            res += mult * arr[i];
            mult *= 10;
        }
        return res;
    }

    public static int arrEndToInt(int[] arr, int length) {
        return arrRangeToInt(arr, arr.length - length, arr.length);
    }

    public static String getPasswords(int length) {

        int size = General.exponent(10, length);
        boolean[] exists = new boolean[size];
        int[] order = new int[size + length - 1];

        int index = length;
        int chr = 0;
        exists[0] = true;
        while (index < order.length) {
            if (chr > 9) {
                exists[arrRangeToInt(order, index - length, index)] = false;
                index--;
                chr = order[index] + 1;
            } else if (exists[10 * arrRangeToInt(order, index - length + 1, index) + chr]) {
                chr++;
            } else {
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
        int len = 4;
        System.out.println(getPasswords(len));

    }

}
