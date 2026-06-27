package recursion.string;

public class WildcardMatching {
        public boolean isMatch(String s, String p) {

            int i = s.length();
            int j = p.length();

            return find(i - 1, j - 1, s, p);
        }

        boolean find(int i, int j, String text, String pattern) {

            // both exhausted
            if(i < 0 && j < 0){
                return true;
            }

            // pattern exhausted but string remains
            if(j < 0 && i >= 0){
                return false;
            }

            // if string exhausted then the remaining chars must be * since they can be 0 (match with nothing)
            if(i < 0 && j >= 0){
                for(int k = 0; k <= j; k++){
                    if(pattern.charAt(k) != '*'){
                        return false;
                    }
                }
                return true;
            }

            // direct match or ?
            if(text.charAt(i) == pattern.charAt(j)
                    || pattern.charAt(j) == '?'){
                // shrink the window by reducing the pointers
                return find(i - 1, j - 1, text, pattern);
            }

            // *
            if(pattern.charAt(j) == '*'){
                // recursively search for * matching (0 to n)
                return find(i, j - 1, text, pattern)
                        ||
                        find(i - 1, j, text, pattern);
            }

            return false;
        }
}
