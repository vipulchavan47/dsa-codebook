package array.medium;
// Problem Statement:
// Rotate the matrix by 90 degrees.

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap the elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                // swap(matrix[i][j],matrix[j][i])
            }
        }

        // Reverse each row (like an array)
        for (int i = 0; i < n; i++) {
            reverseMat(matrix[i]);
        }

    }

    public void reverseMat(int[] mat) {
        int start = 0;
        int end = mat.length - 1;

        while (start < end) {
            int temp = mat[start];
            mat[start] = mat[end];
            mat[end] = temp;
            // swap(mat[start],mat[end])

            start++;
            end--;
        }
    }


    // Print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rm.rotate(matrix);

        System.out.println("Matrix after 90-degree rotation:");
        printMatrix(matrix);
    }
}


