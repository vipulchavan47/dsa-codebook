import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // Generate a specific row of Pascal's Triangle
    public List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add((int) ans); // First element is always 1

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }

        return ansRow;
    }

    // Generate Pascal's Triangle up to numRows
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            list.add(generateRow(i));
        }

        return list;
    }

    // Main method to test the class
    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();

        int numRows = 5;
        List<List<Integer>> result = triangle.generate(numRows);

        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
