package math;

/*
Given an integer array nums, 
return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer 
that evenly divides both numbers. 

(leetcode-1979)
Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.
*/
public class FindGCD {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for(int i=0; i<nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }

        return findGCD(min , max);
    }

    // normal method with Time Complexity O(min(num1,num2)) and Space Complexity O(1)
    public int findGCD(int num1 , int num2){
        int min = Math.min(num1,num2);
        int gcd = 1;
        
        for(int i=1; i<=min; i++){
            if(num1 % i == 0 && num2 % i == 0){
                gcd = i;
            }
        }

        return gcd;
    }

    // findGCDEuclidean method to calculate the greatest common divisor of two numbers using the Euclidean algorithm
    // time complexity: O(log(min(num1,num2))) and space complexity: O(1)
    // Euclidean formula: GCD(a, b) = GCD(a-b, b) or GCD(a, b) = GCD(b, a % b)
    public int findGCDEuclidean(int a , int b){
        // Use the Euclidean algorithm to find the GCD of two numbers
        while(a > 0 && b > 0){
            if(a > b){
                a = a % b;
            }else{
                b = b % a;
            }
        }

        // Return the non-zero number as the GCD
        if(a == 0){
            return b;
        }else{
            return a;
        }
    }
}
