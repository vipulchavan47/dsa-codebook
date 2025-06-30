package recursion.RecursionEasy;

public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        return findPower(n);
    }

    public static boolean findPower(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 3 != 0) {
            return false;
        }
        return findPower(n / 3);
    }

    public static void main(String[] args) {
        System.out.println(findPower(27));
        System.out.println(findPower(15));
        System.out.println(findPower(-27));
        
    }
}
