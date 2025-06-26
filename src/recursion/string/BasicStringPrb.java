package recursion.string;

public class BasicStringPrb {
    public static void main(String[] args) {
        String str = "baccabd";
//        StringBuilder sb = new StringBuilder("");
//        char ch = 'a';
//        StringBuilder ans = removeChar(str,sb,0,ch);
//        System.out.println(ans);


// new
//        String an2 = skip(str);
//        System.out.println("Answer = " + an2);

// skip apple
//        System.out.println("Skip apple = " + skipApple("adsapplefg"));

        System.out.println("Skip app not apple = " + skipAppNotApple("dgappceappler"));
    }

    private static StringBuilder removeChar(String str, StringBuilder sb, int index, char ch) {
        if (str.length() == index) {
            return sb;
        }

        if (str.charAt(index) != ch) {
            sb.append(str.charAt(index));
            return removeChar(str, sb, index + 1, ch);
        } else {
            return removeChar(str, sb, index + 1, ch);
        }
    }

    public static String skip(String up) {
        // up means unprocessed string
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        }
    }

    // SKip apple
    public static String skipApple(String up) {
        if (up.isEmpty()) {
            return "";
        }

        if (up.startsWith("apple")) {
            return skipApple(up.substring(5));
        } else {
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }

    public static String skipAppNotApple(String up) {
        if (up.isEmpty()) {
            return "";
        }

        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }
}
