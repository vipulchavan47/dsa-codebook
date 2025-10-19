package string.easy;

public class MinimumNumberOfChairs {
    public int minimumChairs(String s) {
        int result = 0;
        int temp = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'E') {
                temp++;  // 'E' means a person enters, so one more chair is occupied
            }
            else {
                temp--;  // 'L' means a person leaves, so one chair becomes free
            }

            // Update the maximum number of occupied chairs seen so far
            result = Math.max(result, temp);
        }

        return result;
    }
}
