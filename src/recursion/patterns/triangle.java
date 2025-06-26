package recursion.patterns;

public class triangle {
    public static void main(String[] args) {
        triangle(5,0);
    }

    public static void triangle(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            // to print the entire row line we will increase the col count by one
            System.out.print("*");
            triangle(row,col+1);
        }
        else {
            // once the col in printed we'll move to the next row
            System.out.println();
            triangle(row-1,0);
        }
    }

    public static void triangle2(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            triangle(row,col+1);
            System.out.print("*");
        }
        else {
            triangle(row-1,0);
            System.out.println();
        }
    }
}


/*

*****
****
***
**
*




 */