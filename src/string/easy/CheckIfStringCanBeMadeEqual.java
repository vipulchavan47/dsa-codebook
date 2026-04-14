package string.easy;

/*
You are given two strings s1 and s2, both of length 4, consisting of lowercase English letters.
You can apply the following operation on any of the two strings any number of times:
    Choose any two indices i and j such that j - i = 2,
    then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.


-- Approach --
Constraint of this problem:
String length is exactly 4
Only allowed swaps:
(0, 2)
(1, 3)

So effectively:
Even indices {0, 2} form one group
Odd indices {1, 3} form another group
And within each group, you can rearrange freely.
 */
public class CheckIfStringCanBeMadeEqual {
        public boolean canBeEqual(String s1, String s2) {

            // check even indices
            if (!(
                    (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                            (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0))
            )) return false;

            // check odd indices
            if (!(
                    (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                            (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1))
            )) return false;

            return true;
        }
}
