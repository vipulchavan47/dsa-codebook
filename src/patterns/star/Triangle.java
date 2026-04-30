package patterns.star;

/*

 *
 * *
 * * *
 * * * *

 */
public class Triangle {
    public void printPattern(){
        int n = 4;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    /*

     * * * *
     * * *
     * *
     *

     */

    public void printTriangle2(){
        int n = 4;

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
