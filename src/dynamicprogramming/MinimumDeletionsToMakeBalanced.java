package dynamicprogramming;

public class MinimumDeletionsToMakeBalanced {
        public int minimumDeletions(String s) {
            int bCount = 0;     // number of 'b' seen so far
            int deletions = 0;  // minimum deletions needed till now

            for (char ch : s.toCharArray()) {

                if (ch == 'b') {
                    bCount++;   // count b's on left
                } else { // ch == 'a'
                    // Option 1: delete this 'a'  → deletions + 1
                    // Option 2: delete all previous 'b's → bCount
                    deletions = Math.min(deletions + 1, bCount);
                }
            }

            return deletions;
        }

        /*
        When we see:
            • 'b' → it's fine, just count it.
            • 'a' → it's problematic if previous 'b' exists.
        We either:
            delete this 'a'
            or delete all previous 'b'
        At every step we keep the minimum cost.
         */

}
