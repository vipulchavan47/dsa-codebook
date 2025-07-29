package string.easy;

public class FindTheFirstOccurence {
    public static int strStr(String haystack, String needle) {
        // Loop through haystack from index 0 to the point where a full needle could still fit
        // We stop at haystack.length() - needle.length() because beyond that, no full match is possible
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            // First check if the current character matches the first character of needle
            if (haystack.charAt(i) == needle.charAt(0)) {

                // If first character matches, check the whole substring of haystack
                // starting at i and of length equal to needle.length()
                // If it matches needle, return the starting index i
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
            }
        }

        // If no match found, return -1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "but"));
    }

}
