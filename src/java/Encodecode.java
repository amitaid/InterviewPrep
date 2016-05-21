import java.util.Arrays;

public class Encodecode {

    public static String encode(String[] words) {
        if (words == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {    // Skip nulls
                continue;
            }
            sb.append(words[i].length());
            if (i < words.length - 1) {
                sb.append(",");
            }
        }
        sb.append("#");
        for (String word : words) {
            sb.append(word);
        }

        return sb.toString();
    }

    public static String[] decode(String code) {
        if (code == null) {
            return null;
        }

        if (code.equals("#")) {
            return new String[0];
        }

        int split = code.indexOf("#");
        String[] lengths = code.substring(0, split).split(",");
        code = code.substring(split + 1);

        String[] result = new String[lengths.length];
        int index = 0;

        try {
            for (int i = 0; i < lengths.length; i++) {
                int len = Integer.parseInt(lengths[i]);
                result[i] = code.substring(index, index + len);
                index += len;
            }
        } catch (NumberFormatException e) {
            // Handle illegal encoding
        }

        return result;
    }

    public static void main(String[] args) {

        String[] input = {"a", "bb", "ccc", "dddd"};
        String coded = encode(input);
        String[] decoded = decode(coded);

        System.out.println(coded);
        System.out.println(Arrays.toString(decoded));

    }

}