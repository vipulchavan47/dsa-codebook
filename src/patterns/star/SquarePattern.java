package patterns.star;

/*
Tips:
    1. Draw pattern → count rows & columns
    2.Break into:
        spaces
        stars
    3.Convert into formula:
        spaces → n - i
        stars → i or 2*i-1
    4.For hollow → use boundary condition
 */

/*
 * * * *
 * * * *
 * * * *
 * * * *
 */
public class SquarePattern {
    public void printPattern(){
        int n = 4;

        for (int i = 0; i < n; i++) {          // rows
            for (int j = 0; j < n; j++) {      // columns
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
    Hollow Square
     * * * *
     *     *
     *     *
     * * * *

     */

    public void print(){
        int n = 4;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
