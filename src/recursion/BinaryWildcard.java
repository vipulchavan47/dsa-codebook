package recursion;
/*
Given string with 0,1,?, replace ? with 0/1.
 */
public class BinaryWildcard {
        public static void generate(String str, int index, char[] arr) {
            if (index == arr.length) {
                System.out.println(new String(arr));
                return;
            }

            if (arr[index] == '?') {
                arr[index] = '0';
                generate(str, index + 1, arr);

                arr[index] = '1';
                generate(str, index + 1, arr);

                arr[index] = '?'; // backtrack
            } else {
                generate(str, index + 1, arr);
            }
        }

        public static void main(String[] args) {
            String str = "1?0?";
            generate(str, 0, str.toCharArray());
        }
}
