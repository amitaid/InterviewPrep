import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * General programming question solutions
 */

public class General {

    // Iterative Fibonacci sequence
    public static int fib_iter(int n) {
        int prev, cur = 0, next = 1;
        for (int i = 0; i < n; i++) {
            prev = cur;
            cur = next;
            next = prev + cur;
        }
        return cur;
    }

    // Recursive Fibonacci sequence
    public static int fib_rec(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            return fib_rec(n - 1) + fib_rec(n - 2);
        }
    }

    // Dynamic Fibonacci sequence
    public static int fib_memo(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int[] mem = IntStream.generate(() -> -1).limit(n + 1).toArray();
        mem[0] = 0;
        mem[1] = mem[2] = 1;
        return fib_memo(n, mem);
    }

    // Dynamic Fibonacci helper
    public static int fib_memo(int n, int[] mem) {
        if (mem[n] == -1) {
            mem[n] = fib_memo(n - 1, mem) + fib_memo(n - 2, mem);
        }
        return mem[n];
    }

    // Translates an integer into it's binary form, as a String
    public static String int2binary(int n) {
        String res = "";
        while (n > 0) {
            res = (n % 2 == 1 ? "1" : "0") + res;
            n /= 2;
        }
        return res;
    }

    // Returns the most frequent element in the given array
    public static int mostFrequent(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : arr) {
            m.merge(n, 1, (x, y) -> x + y);
        }
        return m.keySet().stream().max((k1, k2) -> m.get(k1) - m.get(k2)).get();
    }

    // Finds the only element in the given array that occurs only once.
    public static int occursOnce(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : arr) {
            m.merge(n, 1, (x, y) -> x + y);
        }
        return m.keySet().stream().filter(x -> m.get(x) == 1).findFirst().get();
    }

    // Exponent function. Only accepts integer powers. log(n) time.
    public static double exponent(double base, int power) {
        double res = 1.0;
        if (power < 0) {
            base = 1 / base;
            power *= -1;
        }
        while (power > 0) {
            if (power % 2 == 1) {
                res *= base;
                power--;
            } else {
                base *= base;
                power /= 2;
            }
        }
        return res;
    }

    // Exponent function, accepting ints as well
    public static int exponent(int base, int power) {
        return (int) exponent(1.0 * base, power);
    }

    // Silly IntStream way. O(n) time.
    public static int power(int base, int power) {
        return IntStream.
            generate(() -> base).
            limit(power).
            reduce(1, (x, y) -> x * y);
    }

    // Newton method sqrt
    public static double sqrt(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Negative values not supported.");
        }
        if (num == 0) {
            return num;
        }

        double cur = num / 2;
        while (Math.abs(cur * cur - num) > 0.000001) {
            cur = cur - (cur * cur - num) / (2 * cur);       // f(x) = x^2 - num, f'(x) = 2x, g(x) = x_0 - f(x)/f'(x)
        }

        return cur;
    }

    // rand5 / rand7 question. Given a rand5 function (uniform 0-5), create rand7
    public static int rand5() {
        return new Random().nextInt(6);
    }

    public static int rand7() {
        return (rand5() < 3 ? 4 : 0) +
                (rand5() < 3 ? 2 : 0) +
                (rand5() < 3 ? 1 : 0);
    }

    // Parse the given string into an integer in the given base
    public static int parseInt(String str, int base) {
        int mult = 1;
        int res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int chr = str.charAt(i) - '0';
            if (chr >= base) {
                throw new IllegalArgumentException("Illegal number in this base.");
            }
            res += mult * chr;
            mult *= base;
        }
        return res;
    }

    // When not provided with a base, use base 10
    public static int parseInt(String str) {
        return parseInt(str, 10);
    }

    // Prints all pairs in the given array whose sums are 10
    public static void array10Pairs(int[] arr) {
        Set<Integer> s = new HashSet<>();
        int min, max;
        Arrays.stream(arr).forEach(s::add);
        for (Integer i : s) {
            if (s.contains(10 - i)) {
                min = Math.min(i, 10 - i);
                max = 10 - min;
                System.out.println(min + ", " + max);
            }
        }
    }

    // Prints all elements that appear in both arrays
    public static void common(int[] arr1, int[] arr2) {
        Set<Integer> s = new HashSet<>();
        Arrays.stream(arr1).forEach(s::add);
        Arrays.stream(arr2).
                distinct().
                filter(s::contains).
                forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println(sqrt(9));

        //common(new int[]{1, 2, 3, 4, 6, 9}, new int[]{1, 3, 5, 7, 9, 9});
        //
        //Map<Integer, Integer> m7 = new HashMap<>();
        //IntStream.
        //        generate(General::rand7).
        //        limit(100000).
        //        forEach(n -> m7.merge(n, 1, (x, y) -> x + y));
        //System.out.println(m7);
        //
        //Map<Integer, Integer> m5 = new HashMap<>();
        //IntStream.
        //        generate(General::rand5).
        //        limit(100000).
        //        forEach(n -> m5.merge(n, 1, (x, y) -> x + y));
        //System.out.println(m5);

    }
}
