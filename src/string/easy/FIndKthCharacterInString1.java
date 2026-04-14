package string.easy;

/*
Input: k = 5
Output: "b"

Explanation:
Initially, word = "a". We need to do the operation three times:
    Generated string is "b", word becomes "ab".
    Generated string is "bc", word becomes "abbc".
    Generated string is "bccd", word becomes "abbcbccd".

 */
public class FIndKthCharacterInString1 {
    // ------ Brute Force Solution --------
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while(word.length() < k){
            StringBuilder str = new StringBuilder();

            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(ch == 'z'){
                    str.append('a');
                }
                else{
                    char nextChar = (char) (ch+1);
                    str.append(nextChar);
                }
            }

            word.append(str);
        }

        return word.charAt(k-1);
    }
    // ---- Optimal Solution ---------
}
