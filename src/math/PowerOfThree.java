package math;

public class PowerOfThree {
        public boolean isPowerOfThree(int n) {
            if (n == 1) return true;   // missing edge case
            if (n < 3) return false;

            int i = 1;

            while (true) {
                int num = (int) Math.pow(3, i);
                if (num == n) return true;
                if (num > n) return false;
                i++;
            }
        }

    // Optimal ----------------
    //Since 3^19 = 1162261467 is the largest power of 3 that fits in a 32-bit signed int,
    //n is a power of 3 iff it divides this number.
    public boolean isPowerOfThree2(int n) {
        int maxPowerOfThree = 1162261467; // 3^19
        return n > 0 && maxPowerOfThree % n == 0;
    }
}
