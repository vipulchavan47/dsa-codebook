package patterns.star;

public class Pyramid {
    /*

            *
           * *
          * * *
         * * * *

        spaces = n - i
        stars = i
     */

    public void printPyramid(){
        int n = 4;

        for (int i = 1; i <= n; i++) {

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /*
        Inverted Pyramid

        * * * *
         * * *
          * *
           *

     */

    public void printPyramid2(){
        int n = 4;

        for (int i = n; i >= 1; i--) {

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // Hollow pyramid
    public void  printHollowPyramid(){
        int n = 4;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) System.out.print(" ");

            for (int j = 1; j <= 2 * i - 1; j++) {

                if (j == 1 || j == 2 * i - 1 || i == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
