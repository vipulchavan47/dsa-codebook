package recursion.string;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
//        permutations("","abc");
//
//        ArrayList<String> ans = permutationsList("", "abc");
//        System.out.println(ans);

        System.out.println(permutationsCount("", "abc",0));
    }

    private static ArrayList<String> permutationsList(String p, String up) {
        // Base case: if 'up' is empty, it means the permutation is complete
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>(); // create a new list
            list.add(p);                                // add the complete permutation
            return list;                                // return the list
        }

        // To store all permutations from this recursion level
        ArrayList<String> ans = new ArrayList<>();

        // Take the first character from 'up' to insert into 'p'
        char ch = up.charAt(0);

        // We will insert 'ch' into all possible positions in 'p'
        for (int i = 0; i <= p.length(); i++) {
            // Split 'p' into two parts: before and after position 'i'
            String f = p.substring(0, i);        // characters before position i
            String s = p.substring(i);           // characters from position i onwards

            // collect returned permutations and add to ans
            // at each level add the lists generated
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }

        // Return the collected list of permutations at this level
        return ans;
    }

    public static  void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i=0;i<= p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());

            permutations(f+ch+s, up.substring(1));
        }
    }

    public static int permutationsCount(String p, String up, int count) {
        if (up.isEmpty()) {
            return count + 1; // increment count when a permutation is found
        }

        char ch = up.charAt(0);
        int c = count; // start with passed count

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            c = permutationsCount(f + ch + s, up.substring(1), c); // pass updated count each time
        }

        return c;
    }

}
