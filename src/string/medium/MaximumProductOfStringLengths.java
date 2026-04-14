package string.medium;

public class MaximumProductOfStringLengths {
    //     ---------- Brute Force -------
    public int maxProduct(String[] words) {

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String s1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String s2 = words[j];

                if (!hasCommon(s1, s2)) {
                    result = Math.max(result, s1.length() * s2.length());
                }
            }
        }

        return result;
    }

    boolean hasCommon(String a, String b) {
        for (char c : a.toCharArray()) {
            // for every char in string a if it has any match with b if it has a match return
            if (b.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
