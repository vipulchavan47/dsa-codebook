package math;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int temp = n;
        int digits = 0;

        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        temp = n;
        int sum = 0;

        while(temp != 0){
            int digi = temp % 10;
            sum += Math.pow(digi,digits);
            temp /= 10;
        }

        if (sum == n)
            System.out.println("Armstrong number");
        else
            System.out.println("Not an Armstrong number");
    }
}
