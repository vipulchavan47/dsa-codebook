package string.easy;

public class LengthOfLastWord {
    // Optimal 
    public int lengthOfLastWord2(String s) {
        String str = s.trim();
        int n = str.length() - 1;
        int count = 0;

        for (int i = n; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;

    }

    // TC = O(N) ans SC = O(N)
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int len = s.length();

        String[] words = str.split(" ");

        String lastWord = words[words.length - 1];
        int ans = lastWord.length();
        return ans;

    }


}
