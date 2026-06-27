package hashmap.easy;

public class GreatestUppercaseEnglishLetter {
        public String greatestLetter(String s) {
            boolean[] lower = new boolean[26];
            boolean[] upper = new boolean[26];

            for(char ch: s.toCharArray()){
                if(Character.isLowerCase(ch)){
                    lower[ch - 'a'] = true;
                }
                else{
                    upper[ch - 'A'] = true;
                }
            }

            String str = "";

            // traverse from the end so first letter we get will be the answer
            for(int i=25; i>= 0; i--){
                if(lower[i] && upper[i]){
                    // get the ASCII value of Uppercase letter  and convert it to char
                    char ch = (char) (65 + i);
                    str = Character.toString(ch);
                    break;
                }
            }

            return str;
        }
}
