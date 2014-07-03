import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * General String questions
 */

public class Strings {

    // Finds the first character that is not repeated in the String
    public static String firstNonRepeating(String str) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        str.chars().forEach(c -> m.merge(c, 1, (x, y) -> x + y));
        for (Integer c : m.keySet()) {
            if (m.get(c) == 1) {
                return c.toString();
            }
        }
        return "";
    }

    // Iterative String reversal
    public static String reverseIter(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Recursive String reversal
    public static String reverseRec(String str) {
        return str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
    }

    // Checks if the two given Strings are anagrams
    public static boolean anagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Integer, Integer> m = new HashMap<>();
        s1.chars().forEach(c -> m.compute(c, (k, v) -> (v == null) ? 1 : v + 1));
        s2.chars().forEach(c -> m.compute(c, (k, v) -> (v == null) ? -1 : v - 1));
        return s2.chars().allMatch(c -> m.get(c) == 0);
    }

    // Checks if the given String is a palindrome
    public static boolean palindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        int i = 0;
        while (i < str.length() / 2) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    // Checks if the String has no repeating characters
    public static boolean distinct(String str) {
        return str.chars().distinct().count() == str.length();
    }

    // Checks if the String is an Integer or a Double value
    public static boolean intOrDouble(String str) {
        return str.matches("(0|[1-9][0-9]*)(.[0-9]+)?");
    }

    // Prints all permutations of the given String
    public static void permutations(String str) {
        permHelper(str, "");
    }

    // Helper recursive function for the permutations
    private static void permHelper(String str, String perm) {
        if (str.length() == 0) {
            System.out.println(perm);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permHelper(str.substring(0, i) + str.substring(i + 1, str.length()), perm + str.charAt(i));
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(intOrDouble("0.2"));
    }
}
