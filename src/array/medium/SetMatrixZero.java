package array.medium;
/*73. Set Matrix Zeroes
Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place. */



public class SetMatrixZero {

//------Optimal -----------
// TC = O(m*n)  SC = O(1)
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean row0 = false, col0 = false;

        // Step 1: Determine if the first row and column need to be zeroed
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0 = true;
        }
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) row0 = true;
        }

        // Step 2: Use the first row and column to mark other rows and columns
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the first cell of the row
                    matrix[0][j] = 0; // Mark the first cell of the column
                }
            }
        }

        // Step 3: Zero out cells based on the markers
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Handle the first row and column separately
        if (row0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    // Better approach
    public void setZeroes2(int[][] matrix) {
        // Get the number of rows and columns in the matrix
        int row = matrix.length;
        int col = matrix[0].length;

        // Arrays to keep track of which rows and columns should be set to zero
        boolean[] r = new boolean[row];
        boolean[] c = new boolean[col];

        // Step 1: Identify the rows and columns that should be set to zero
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If an element is zero, mark its row and column in the respective arrays
                if (matrix[i][j] == 0) {
                    r[i] = true;  // Mark row `i` for zeroing
                    c[j] = true;  // Mark column `j` for zeroing
                }
            }
        }

        // Step 2: Update the rows to set all elements to zero where marked
        for (int i = 0; i < row; i++) {
            if (r[i]) {  // If row `i` is marked
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;  // Set all elements in row `i` to zero
                }
            }
        }

        // Step 3: Update the columns to set all elements to zero where marked
        for (int j = 0; j < col; j++) {
            if (c[j]) {  // If column `j` is marked
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;  // Set all elements in column `j` to zero
                }
            }
        }
    }


// Brute force approach
/*
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Create a copy of the matrix
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        // Traverse the original matrix and mark rows/columns in the temp matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // Set the entire row and column to 0 in temp matrix
                    for (int k = 0; k < col; k++) temp[i][k] = 0; // Mark row
                    for (int k = 0; k < row; k++) temp[k][j] = 0; // Mark column
                }
            }
        }

        // Copy the temp matrix back to the original matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
 */


}
