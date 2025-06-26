package recursion.subsetsandsubsequences;

import java.util.ArrayList;

public class subsequnce {
    public static void main(String[] args) {
        String up = "abc";
        String p = "";
//        findSubsequnce(p, up);

        System.out.println(findSubsequnce2(p, up, new ArrayList<String>()));
        System.out.println(findSubsequence3(p, up));


    }

    private static void findSubsequnce(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        // char at index 0   ---> (" " / "abc") so here a is that character and for every recursive call the first character
        char ch = up.charAt(0);

        // so either pick that character
        findSubsequnce(p + ch, up.substring(1));

        // or do not pick that character
        findSubsequnce(p, up.substring(1));
    }

    private static ArrayList<String> findSubsequnce2(String p, String up, ArrayList<String> list) {
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }

        // char at index 0   ---> (" " / "abc") so here a is that character and for every recursive call the first character
        char ch = up.charAt(0);

        // so either pick that character
        findSubsequnce2(p + ch, up.substring(1), list);

        // or do not pick that character
        findSubsequnce2(p, up.substring(1), list);

        return list;
    }

    private static ArrayList<String> findSubsequence3(String p, String up) {
        ArrayList<String> list = new ArrayList<>();

        if (up.isEmpty()) {
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        // recursive call when we include the character
        ArrayList<String> left = findSubsequence3(p + ch, up.substring(1));

        // recursive call when we exclude the character
        ArrayList<String> right = findSubsequence3(p, up.substring(1));

        // combine both lists
        list.addAll(left);
        list.addAll(right);

        return list;
    }

}
