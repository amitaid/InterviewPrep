import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author amitay
 */

public class Strings {

  public static String firstNonRepeating(String str) {
    TreeMap<Character, Integer> m = new TreeMap<>();
    str.chars().forEach(c -> m.compute((char)c, (k,v) -> (v == null) ? 1 : v+1));
    for (Character c : m.keySet()) {
      if (m.get(c) == 1) {
        return c.toString();
      }
    }
    return "No such char found.";
  }

  public static String reverseIter(String str) {
    StringBuilder sb = new StringBuilder(str.length());
    for (int i = str.length()-1; i >= 0; i--) {
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  public static String reverseRec(String str) {
    return str.charAt(str.length()-1) + str.substring(0, str.length() - 1);
  }

  public static boolean anagrams(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    Map<Integer, Integer> m = new HashMap<>();
    s1.chars().forEach(c -> m.compute(c, (k,v) -> (v == null) ? 1 : v+1));
    s2.chars().forEach(c -> m.compute(c, (k,v) -> (v == null) ? -1 : v-1));
    return s2.chars().allMatch(c -> m.get(c) == 0);
  }

  public static boolean palindrome(String str) {
    if (str.length() <= 1) {
      return true;
    }
    int i = 0;
    while (i < str.length()/2) {
      if (str.charAt(i) != str.charAt(str.length()-1-i)) {
        return false;
      }
      i++;
    }
    return true;
  }

  public static boolean distinct(String str) {
    return str.chars().distinct().count() == str.length();
  }

  public static boolean intOrDouble(String str) {
    return str.matches("[1-9][0-9]*(.[0-9]+)?");
  }

  public static void permutations(String str) {
    permHelper(str, "");
  }

  private static void permHelper(String str, String perm) {
    if (str.length() == 0) {
      System.out.println(perm);
    } else {
      for (int i = 0; i < str.length(); i++) {
        permHelper(str.substring(0, i) + str.substring(i+1, str.length()), perm+str.charAt(i));
      }
    }
  }



  public static void main(String[] args) {
    permutations("abcde");
  }
}
