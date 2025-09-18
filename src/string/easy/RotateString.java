package string.easy;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            if (sb.toString().equals(goal)) {
                return true;
            }

            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
        }

        return false;
    }

    // More optimal way:
    public static boolean rotateString2(String s, String goal) {
        // s + s create a new string object and contains method check for the sequence of the substring
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    // Main
    public static void main(String[] args) {
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println(rotateString2(s1, goal1)); // true

        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println(rotateString2(s2, goal2)); // false
    }
}
