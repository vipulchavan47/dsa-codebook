package recursion.basic;

public class CountZeros {
    public static void main(String[] args) {
        int n = 102030;
        int count = 0;
        int ans = countZeros(n,count);
        System.out.println("Count = " + ans);
    }

    public static int countZeros(int n, int count){
        if(n == 0){
            return count;
        }

        int rem = n % 10;
        if(rem == 0){
            return countZeros((n/10),count+1);
        }
        return countZeros((n/10),count);


    }
}


// if n itself is zero then we have to improve this code
/*
public class CountZeros {
    public static void main(String[] args) {
        int n = 102030;
        int ans = countZeros(n);
        System.out.println("Count = " + ans);
    }

    public static int countZeros(int n) {
        if (n == 0) return 1;  // Special case for 0 itself

        return helper(n, 0);
    }

    private static int helper(int n, int count) {
        if (n == 0) {
            return count;
        }

        int rem = n % 10;
        if (rem == 0) {
            return helper(n / 10, count + 1);
        } else {
            return helper(n / 10, count);
        }
    }
}

 */