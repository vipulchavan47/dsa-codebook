package string.medium;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {
    // My solution
    public String reverseWords(String s) {
        String str = s.trim().replaceAll("\\s+", " ");
        String words[] = str.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(words[i]);
            } else {
                sb.append(words[i]);
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    // Optimal
    public String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


}
