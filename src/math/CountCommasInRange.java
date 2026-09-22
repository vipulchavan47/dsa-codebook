package math;

/*
You are given an integer n.

Return the total number of commas used when writing all
integers from [1, n] (inclusive) in standard number formatting.

In standard formatting:
A comma is inserted after every three digits from the right.
Numbers with fewer than 4 digits contain no commas.
 */
public class CountCommasInRange {
        public int countCommas(int n) {
            // Numbers below 1000 don't contain a comma.
            // From 1000 to 100000 , every number has exactly one comma
            // because of the constraint n <= 100000.
            // Count of numbers from 1000 to n = n - 1000 + 1 = n - 999.
            return Math.max(0, n - 999);
        }
}
