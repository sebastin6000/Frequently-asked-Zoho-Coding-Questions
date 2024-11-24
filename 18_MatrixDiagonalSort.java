/* 
Question: 
https://leetcode.com/problems/sort-the-matrix-diagonally/description/
*/

 /* 
 1.Understanding the Problem Statement: 
   The task is to sort the diagonals of a matrix, 
   starting from any element in the top row or left column, 
   and moving in the bottom-right direction. After sorting, 
   we return the matrix with the diagonals sorted in ascending order.

For example, consider the matrix:
[[3, 3, 1, 1],
 [2, 2, 1, 2],
 [1, 1, 1, 2]]
 
 The diagonals here are:
 - Diagonal starting at mat[0][0] → [3, 2, 1]
 - Diagonal starting at mat[0][1] → [3, 1]
 - Diagonal starting at mat[0][2] → [1]
 - Diagonal starting at mat[1][0] → [2, 1]
 - Diagonal starting at mat[1][1] → [2, 2]
 - Diagonal starting at mat[2][0] → [1]
 
 Sorting each diagonal:
 - [3, 2, 1] → [1, 2, 3]
 - [3, 1] → [1, 3]
 - [1] → [1]
 - [2, 1] → [1, 2]
 - [2, 2] → [2, 2]
 - [1] → [1]
 
 The final matrix will be:
 [[1, 1, 1, 1],
  [1, 2, 2, 2],
  [1, 2, 3, 3]]
*/

 /* Constraints explanation:
The matrix's dimensions are given by m and n, where:
- m is the number of rows
- n is the number of columns
- 1 <= m, n <= 100
- The elements in the matrix range from 1 to 100

Given these constraints, the matrix could be at most 100x100, which is manageable within modern computational limits.

The goal is to efficiently sort each diagonal in a matrix of this size without running into performance issues. */
 
 /* Relatable analogy or real-world scenario:
Imagine you're organizing a collection of books arranged on a shelf. Some books are aligned diagonally, 
starting from the top-left corner of the shelf. You need to rearrange these books diagonally in ascending order so that each diagonal sequence of books (starting from different positions along the shelf's top or left edge) is ordered from smallest to largest. You can think of the matrix as a shelf, and each diagonal as a line of books in a particular diagonal direction.

To solve this, you need to:
1. Identify each diagonal.
2. Sort the books (matrix elements) on each diagonal.
3. Place them back in their respective diagonal positions in the matrix.

This way, after sorting, the matrix looks "tidier" with all the diagonals in order! */

 /* Relatable analogy Java code step by step:
Step 1: Loop over all diagonals. These diagonals start from either the first row or the first column of the matrix.
Step 2: For each diagonal, collect all elements along that diagonal.
Step 3: Sort the collected diagonal elements.
Step 4: Place the sorted elements back into their diagonal positions in the matrix.
Step 5: Repeat this for all diagonals, and return the final sorted matrix. */

 /* Time and Space Complexity Explanation:
Time Complexity:
- To process each diagonal, we collect elements (which takes O(k) time where k is the length of the diagonal) and then sort them (which takes O(k log k) time).
- The total number of diagonals is approximately m + n - 1.
- Hence, the time complexity for sorting all diagonals is O(mn log n), where m and n are the matrix dimensions.

Space Complexity:
- The extra space complexity is O(m + n), as we need extra space to temporarily hold the diagonals when sorting them.
*/

 /* FOR loop walkthrough with every iteration with given input:
1. We loop through the first row and first column to get all diagonals.
2. For each diagonal, we collect the elements, sort them, and put them back into their respective positions.
For example, starting from the first row:
- For mat[0][0], the diagonal is [3, 2, 1]. After sorting: [1, 2, 3].
- For mat[0][1], the diagonal is [3, 1]. After sorting: [1, 3].
And so on.
*/

 /* Complete code walkthrough with applying the given input in code and explanation:
1. Define a method to handle the main task.
2. Loop through the top row and the left column to process each diagonal.
3. For each diagonal, collect the elements, sort them, and place them back into their original positions.
4. After processing all diagonals, return the sorted matrix.

Here is the code in Java: */

import java.util.*; // Importing the necessary utilities (ArrayList, Arrays)

public class MatrixDiagonalSort {
    // Function to sort the diagonals of the matrix
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;  // Get the number of rows
        int n = mat[0].length;  // Get the number of columns

        // HashMap to store diagonals with starting points as keys
        Map<Integer, List<Integer>> diagonals = new HashMap<>();

        // Step 1: Collect all diagonals
        // Loop through the first row
        for (int i = 0; i < n; i++) {
            int row = 0, col = i;
            List<Integer> diagonal = new ArrayList<>();
            while (row < m && col < n) {
                diagonal.add(mat[row][col]);
                row++;
                col++;
            }
            diagonals.put(i, diagonal);  // Store the diagonal in the map
        }

        // Loop through the first column (excluding the first element)
        for (int i = 1; i < m; i++) {
            int row = i, col = 0;
            List<Integer> diagonal = new ArrayList<>();
            while (row < m && col < n) {
                diagonal.add(mat[row][col]);
                row++;
                col++;
            }
            diagonals.put(n + i - 1, diagonal);  // Store the diagonal in the map
        }

        // Step 2: Sort each diagonal
        for (List<Integer> diagonal : diagonals.values()) {
            Collections.sort(diagonal);  // Sort the diagonal
        }

        // Step 3: Place sorted elements back into the matrix
        for (int i = 0; i < n; i++) {
            int row = 0, col = i;
            List<Integer> diagonal = diagonals.get(i);
            int index = 0;
            while (row < m && col < n) {
                mat[row][col] = diagonal.get(index);
                row++;
                col++;
                index++;
            }
        }

        // Loop through the first column (excluding the first element)
        for (int i = 1; i < m; i++) {
            int row = i, col = 0;
            List<Integer> diagonal = diagonals.get(n + i - 1);
            int index = 0;
            while (row < m && col < n) {
                mat[row][col] = diagonal.get(index);
                row++;
                col++;
                index++;
            }
        }

        // Return the matrix with sorted diagonals
        return mat;
    }

    public static void main(String[] args) {
        MatrixDiagonalSort solution = new MatrixDiagonalSort();

        // Test case 1
        int[][] mat1 = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int[][] result1 = solution.diagonalSort(mat1);
        System.out.println(Arrays.deepToString(result1));

        // Test case 2
        int[][] mat2 = {
            {11, 25, 66, 1, 69, 7},
            {23, 55, 17, 45, 15, 52},
            {75, 31, 36, 44, 58, 8},
            {22, 27, 33, 25, 68, 4},
            {84, 28, 14, 11, 5, 50}
        };
        int[][] result2 = solution.diagonalSort(mat2);
        System.out.println(Arrays.deepToString(result2));
    }
}

/*
Explanation of the code:
1. The `diagonalSort` method starts by collecting all diagonals in a `Map` where the key is the diagonal's starting index and the value is the list of elements in that diagonal.
2. Each diagonal is sorted using `Collections.sort()`.
3. After sorting, we place the sorted elements back into their respective positions in the matrix.
4. The main method tests the code with two example matrices and prints the results.

Time complexity: O(mn log n), where m is the number of rows, n is the number of columns, and we sort each diagonal.
Space complexity: O(m + n), as we use extra space for storing the diagonals.
*/

 /* Conclusion:
The code takes an input matrix, identifies its diagonals, sorts each diagonal, and places the sorted elements back into their original positions. This approach efficiently handles sorting while maintaining the structure of the matrix, producing the desired result.
*/
