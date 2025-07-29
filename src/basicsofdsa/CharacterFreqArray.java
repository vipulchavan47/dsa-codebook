package basicsofdsa;

public class CharacterFreqArray {
    public static void main(String[] args) {
        String str = "ricklessandmorty";
        int[] freq = new int[26]; // for 'a' to 'z'

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Make sure the character is lowercase letter
            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                System.out.println((char) (i + 'a') + ": " + freq[i]);
            }
        }
    }

}
