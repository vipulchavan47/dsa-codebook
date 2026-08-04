package string.easy;

public class NumberOfSegmentsInString {
    public int countSegments(String s) {
        int count = 0;

        // count the words not spaces
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' ' &&
                (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }

        return count;
    }
}
