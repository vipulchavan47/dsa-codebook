package recursion.basic;

public class ProductOfDigits {
    public static void main(String[] args) {
        int ans = ProductOfdigits(1234);
        System.out.println(ans);
    }

    public static int ProductOfdigits(int num){
        // in product if we returned 0 the asn will be 0 .
        // so only one digit remains we return it
        if(num%10 == num){
            return num;
        }
        return (num % 10) * ProductOfdigits(num /10);
    }
}
