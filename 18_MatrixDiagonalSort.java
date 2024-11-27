/* 
Question: 
A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column 
and going in the bottom-right direction until reaching the matrix's end. 
Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

Example 1:
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

Example 2:
Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
*/

/* 
Understanding the Problem Statement:
1. Each diagonal of the matrix must be sorted independently.
2. A diagonal is defined as cells with the same difference of indices (row - column).
3. Return the modified matrix with sorted diagonals.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type: int[][] (a 2D matrix of integers)
2. Expected Output: int[][] (the transformed matrix)
3. Output return type: int[][]
4. Time complexity expectations: Efficient diagonal sorting algorithm expected, ideally O(m * n * log(min(m, n))).
5. Constraints: 
   - Matrix dimensions (m x n) where 1 <= m, n <= 100.
   - Values in the matrix are between 1 and 100.

*/

/* 
Thinking Solution for the Problem Statement:
1. Type of Problem: Matrix manipulation with diagonal sorting.
2. Intuition: Diagonals can be accessed and sorted independently because their indices share the same difference (row - column).
3. Conversational solution: 
   - Group elements of the same diagonal (by row - column difference).
   - Sort the elements of each diagonal.
   - Write back the sorted elements into their respective positions.

*/

/* 
Conversional Solution into Subtasks:
1. Group all elements of each diagonal using a data structure like a HashMap where the key is (row - column).
2. Sort each diagonal.
3. Place the sorted elements back into the matrix.
*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a HashMap to group elements of each diagonal using (row - column) as the key.
2. Extract, sort, and store elements in their respective groups.
3. Rewrite the sorted elements back to their respective positions.
4. Return the modified matrix.
*/

import java.util.*;

public class MatrixDiagonalSort {
    // Main method to test the code
    public static void main(String[] args) {
        int[][] mat1 = {
            {3, 3, 1, 1},
            {2, 2, 1, 2},
            {1, 1, 1, 2}
        };

        int[][] mat2 = {
            {11, 25, 66, 1, 69, 7},
            {23, 55, 17, 45, 15, 52},
            {75, 31, 36, 44, 58, 8},
            {22, 27, 33, 25, 68, 4},
            {84, 28, 14, 11, 5, 50}
        };

        System.out.println("Result for matrix 1:");
        printMatrix(diagonalSort(mat1));

        System.out.println("Result for matrix 2:");
        printMatrix(diagonalSort(mat2));
    }

    /* Subtask 1: Group elements of each diagonal using a HashMap */
    public static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // HashMap to store diagonal elements
        Map<Integer, PriorityQueue<Integer>> diagonals = new HashMap<>();

        // Iterate through the matrix to group diagonals
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j; // Calculate diagonal identifier
                diagonals.putIfAbsent(key, new PriorityQueue<>()); // Min-Heap
                diagonals.get(key).offer(mat[i][j]); // Add element to respective heap
            }
        }

        /* Subtask 2: Write sorted elements back into the matrix */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j; // Calculate diagonal identifier
                mat[i][j] = diagonals.get(key).poll(); // Retrieve smallest element
            }
        }

        return mat;
    }

    // Utility function to print the matrix
    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}

/* 
Time and Space Complexity Explanation:
1. Time Complexity:
   - Grouping elements: O(m * n), where m is the number of rows and n is the number of columns.
   - Sorting each diagonal: Each diagonal has at most min(m, n) elements. Sorting takes O(k log k), 
     where k is the size of the diagonal. Total sorting complexity is O(m * n * log(min(m, n))).
   - Writing back elements: O(m * n).

   Overall: O(m * n * log(min(m, n))).

2. Space Complexity:
   - Space for the HashMap to store diagonals: O(m * n).
   - Total space: O(m * n).

*/

/* 
Code Walkthrough:
1. For mat1:
   - Group diagonals: 
     Key 0 -> [3, 2, 1]
     Key -1 -> [3, 1]
     Key -2 -> [1]
     Key 1 -> [2, 1]
   - Sort diagonals:
     Key 0 -> [1, 2, 3]
     Key -1 -> [1, 3]
     Key -2 -> [1]
     Key 1 -> [1, 2]
   - Rewrite:
     Result: [[1, 1, 1, 1], [1, 2, 2, 2], [1, 2, 3, 3]].

2. Similar steps apply for mat2 with respective keys and values.
*/
