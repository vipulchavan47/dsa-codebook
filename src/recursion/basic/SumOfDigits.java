package recursion.basic;

public class SumOfDigits {
    public static void main(String[] args) {
        int ans = sumOfdigits(1234);
        System.out.println(ans);
    }

    public static int sumOfdigits(int num){
        if(num == 0){
            return 0;
        }
        return (num % 10)+ sumOfdigits(num /10);
    }
}
