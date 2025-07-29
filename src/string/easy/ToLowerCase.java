package string.easy;


// ASCII Value of A = 65 and Z = 90
// a = 97 and z = 122
public class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                // if added 32 it will go to the lower case English letters
                // for A = 65 + 32 = 97 which is => a
                ch = (char) (ch + 32);
                sb.append(ch);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
