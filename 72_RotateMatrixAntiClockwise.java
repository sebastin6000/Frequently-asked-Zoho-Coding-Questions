/* 
    Question:

    Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space.
    
    Examples:

    Input: 
    mat[][] = [[1, 2, 3], 
               [4, 5, 6], 
               [7, 8, 9]]
    Output: 
    Rotated Matrix:
    [3, 6, 9]
    [2, 5, 8]
    [1, 4, 7]

    Input: 
    mat[][] = [[1, 2], 
               [3, 4]]
    Output: 
    Rotated Matrix:
    [2, 4]
    [1, 3]

    Constraints:
    1 ≤ n ≤ 102
    1 ≤ mat[i][j] ≤ 103
*/

/*
    Understanding the Problem Statement:

    The problem asks us to rotate a given n x n matrix by 90 degrees in an anti-clockwise direction. 
    This means that each element in the matrix will move to a new position following a specific rotation rule.

    Key points:
    1. We need to rotate the matrix in-place, i.e., we cannot use extra space for storing the rotated matrix.
    2. The rotation should be done by 90 degrees anti-clockwise.
*/

/*
    Extracting Information from the Problem Statement:

    1. Input data type: A 2D array (square matrix) of size n x n.
    2. Expected Output: The same matrix rotated 90 degrees anti-clockwise.
    3. Output return type: The function will modify the input matrix in place and not return a new matrix.
    4. Time Complexity Expectations: Ideally, the solution should be O(n^2), since we are working with a matrix of size n x n.
    5. Constraints:
        - 1 ≤ n ≤ 102 (matrix size up to 102x102)
        - 1 ≤ mat[i][j] ≤ 103 (matrix elements between 1 and 103)
*/

/*
    Thinking Solution for the Problem Statement:

    To rotate the matrix by 90 degrees in an anti-clockwise direction, we can perform the following steps:
    1. Transpose the matrix: Convert rows into columns.
    2. Reverse each row: After transposing, reverse the order of elements in each row to get the final rotated matrix.
    
    This solution works in-place and doesn't require any extra space apart from temporary variables for swapping elements.
*/

/*
    Conversional Solution into Subtasks:

    1. Transpose the matrix: Swap elements mat[i][j] with mat[j][i] for all i < j.
    2. Reverse each row: After transposing, reverse each row of the matrix.
*/

/*
    Subtasks of Conversional Solution into Code:

    S.no 1: Transpose the matrix by swapping mat[i][j] with mat[j][i] for all i < j.
    S.no 2: Reverse each row of the matrix after transposition.
*/

/*
    Java Code according to conversational subtasks:

*/

import java.util.*;

public class RotateMatrixAntiClockwise {

    public static void rotateMatrix(int[][] mat) {
        int n = mat.length;
        
        // Subtask 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap mat[i][j] with mat[j][i]
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Subtask 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                // Swap mat[i][start] with mat[i][end]
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
    }

    // Main function for testing
    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] mat2 = {
            {1, 2},
            {3, 4}
        };

        System.out.println("Original Matrix 1:");
        printMatrix(mat1);
        rotateMatrix(mat1);
        System.out.println("Rotated Matrix 1:");
        printMatrix(mat1);

        System.out.println("Original Matrix 2:");
        printMatrix(mat2);
        rotateMatrix(mat2);
        System.out.println("Rotated Matrix 2:");
        printMatrix(mat2);
    }

    // Helper function to print matrix
    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
    Time and Space Complexity Explanation:

    Time Complexity:
    - Transposing the matrix requires O(n^2) time because we are visiting each element once.
    - Reversing each row requires O(n^2) time as well, because we reverse n elements for each of the n rows.
    - Therefore, the overall time complexity is O(n^2), which is optimal for this problem.

    Space Complexity:
    - The solution works in-place, so we do not require any additional space apart from temporary variables for swapping elements.
    - Therefore, the space complexity is O(1).
*/

/*
    Loop Walkthroughs:

    1. Transpose Loop (Subtask 1):
        - The outer loop (i) runs from 0 to n-1, and for each i, the inner loop (j) runs from i+1 to n-1.
        - In each iteration, we swap mat[i][j] with mat[j][i].
        - Example for mat1:
            - i=0, j=1 -> swap mat[0][1] with mat[1][0] -> mat = [[1, 4, 3], [2, 5, 6], [7, 8, 9]]
            - i=0, j=2 -> swap mat[0][2] with mat[2][0] -> mat = [[1, 4, 7], [2, 5, 6], [3, 8, 9]]
            - i=1, j=2 -> swap mat[1][2] with mat[2][1] -> mat = [[1, 4, 7], [2, 5, 6], [3, 8, 9]]

    2. Reverse Row Loop (Subtask 2):
        - The loop runs from 0 to n-1 (for each row).
        - For each row, the inner while loop swaps the elements from start and end and then increments start and decrements end.
        - Example for mat1 after transposition:
            - i=0 -> reverse row [1, 4, 7] -> [7, 4, 1]
            - i=1 -> reverse row [2, 5, 6] -> [6, 5, 2]
            - i=2 -> reverse row [3, 8, 9] -> [9, 8, 3]
            - Final rotated matrix: [[7, 4, 1], [6, 5, 2], [9, 8, 3]]

*/

/*
    Complete Code Walkthrough with Applying the Given Input:

    For mat1:
    1. We start with matrix mat1:
       [[1, 2, 3], 
        [4, 5, 6], 
        [7, 8, 9]]

    2. After the transpose step:
       [[1, 4, 7], 
        [2, 5, 8], 
        [3, 6, 9]]

    3. After reversing each row:
       Final rotated matrix:
       [[7, 4, 1], 
        [6, 5, 2], 
        [9, 8, 3]]

    Similarly, for mat2:
    1. Start with matrix mat2:
       [[1, 2], 
        [3, 4]]

    2. After transposition:
       [[1, 3], 
        [2, 4]]

    3. After reversing each row:
       Final rotated matrix:
       [[3, 1], 
        [4, 2]]
*/


