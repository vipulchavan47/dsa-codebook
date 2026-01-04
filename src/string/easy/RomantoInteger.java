package string.easy;


public class RomantoInteger {
    public static int romanToInt(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int currVal = getValue(s.charAt(i));

            // i+1 < n to check whether next char exits or not else give null pointer exception
            if (i + 1 < n && currVal < getValue(s.charAt(i + 1))) {
                result -= currVal;
            } else {
                result += currVal;
            }
        }

        return result;


    }

    public static int getValue(char ch) {
        int ans = 0;
        switch (ch) {
            case 'I':
                ans = 1;
                break;
            case 'V':
                ans = 5;
                break;
            case 'X':
                ans = 10;
                break;
            case 'L':
                ans = 50;
                break;
            case 'C':
                ans = 100;
                break;
            case 'D':
                ans = 500;
                break;
            case 'M':
                ans = 1000;
                break;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("CVI"));
    }
}
