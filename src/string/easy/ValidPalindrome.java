package string.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(str).reverse().toString();

        return str.equals(reversed);
    }

    public static void main(String[] args) {
        ValidPalindrome vd = new ValidPalindrome();
        String str = "A man, a plan, a canal: Panama";

        System.out.println(vd.isPalindrome(str));
    }

}
