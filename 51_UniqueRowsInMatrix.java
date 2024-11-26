/* 
Question:
Given a binary matrix, your task is to find all unique rows of the given matrix in the order of their appearance in the matrix.

Example 1:

Input:
row = 3, col = 4 
M[][] = {{1 1 0 1},{1 0 0 1},{1 1 0 1}}
Output: $1 1 0 1 $1 0 0 1 $
Explanation: Above, the matrix of size 3x4 looks like:
1 1 0 1
1 0 0 1
1 1 0 1
The two unique rows are R1: {1 1 0 1} and R2: {1 0 0 1}. As R1 first appeared at row-0 and R2 appeared at row-1, in the resulting list, 
R1 is kept before R2.

Example 2:

Input:
row = 2, col = 4 
M[][] = {{0 0 0 1}, {0 0 0 1}}
Output: $0 0 0 1 $
Explanation: Above, the matrix of size 2x4 looks like:
0 0 0 1
0 0 0 1
Only unique row is $0 0 0 1 $

Your task is to implement the function `uniqueRow()`. The function takes three arguments:
- The matrix M (a 2D array),
- The number of rows (`row`), 
- The number of columns (`col`).

The function should return a list of unique rows from the matrix. You do not need to worry about printing; 
the driver code will take care of printing the output.

Expected Time Complexity: O(row * col)
Expected Auxiliary Space: O(row * col)

Constraints:
1 <= row, col <= 40
0 <= M[i][j] <= 1
*/

/* 
Understanding the Problem Statement:
- We are given a binary matrix `M` with `row` number of rows and `col` number of columns.
- Our goal is to return all unique rows from the matrix in the order of their appearance.
- Rows that are identical should be considered duplicates and only appear once in the final result.
- The output should be the list of unique rows where each row is represented as a string of 0s and 1s, with the elements separated by spaces.

What is being asked:
- We need to extract all unique rows of the binary matrix.
- The rows should be returned in the order they first appear.
- Duplicates should be eliminated.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - M[][]: A 2D array (binary matrix) where the elements are either 0 or 1.
   - row: An integer representing the number of rows in the matrix.
   - col: An integer representing the number of columns in the matrix.

2. Expected Output:
   - A list of strings, where each string represents a unique row in the matrix, with elements separated by a space.
   
3. Output return type:
   - A List of Strings.

4. Time complexity expectations:
   - We are expected to solve this in O(row * col) time complexity, 
     which suggests that we need to traverse the matrix once to find unique rows and eliminate duplicates.

5. Constraints:
   - `1 <= row, col <= 40` means the matrix size is at most 40x40. This allows us to perform a solution that operates within O(row * col) complexity.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a problem of extracting unique rows from a matrix.
   - We can use a `HashSet` to keep track of rows we've already seen to eliminate duplicates.
   
2. Destructuring:
   - We need to traverse the matrix row by row.
   - For each row, convert it into a string (or a tuple) to check if it has appeared before.
   - If it has not appeared, add it to our result list and mark it as seen by adding it to a `HashSet`.
   - The `HashSet` will automatically handle the uniqueness of the rows.

3. Conversational solution into smaller subtask:
   - Subtask 1: Convert each row into a format (like a string) that can be easily compared and stored in a set.
   - Subtask 2: Traverse each row, check if it has already been seen using the set, and add it to the result if it is unique.
   - Subtask 3: Return the list of unique rows.

*/

/* 
Conversional Solution into Subtasks:
1. Convert each row of the matrix into a string.
2. Traverse the matrix, and use a `HashSet` to keep track of unique rows.
3. Add rows to the result list if they are not already in the set.
4. Return the list of unique rows.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Convert each row into a string (to make comparisons easy).
2. Use a `HashSet` to keep track of rows we've already seen.
3. If the row has not been seen, add it to the result list and mark it as seen in the `HashSet`.
4. Return the list of unique rows as the result.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class UniqueRowsInMatrix {

    // Function to find and return the unique rows of the matrix
    public static List<String> uniqueRow(int[][] M, int row, int col) {
        Set<String> uniqueRows = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        // Traverse each row of the matrix
        for (int i = 0; i < row; i++) {
            // Create a string representation of the row
            StringBuilder rowString = new StringBuilder();
            for (int j = 0; j < col; j++) {
                rowString.append(M[i][j]).append(" ");
            }
            
            // If this row is not already seen, add it to the result list
            String rowStr = rowString.toString().trim(); // Remove trailing space
            if (!uniqueRows.contains(rowStr)) {
                uniqueRows.add(rowStr);
                result.add(rowStr);
            }
        }
        
        return result;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[][] matrix1 = {
            {1, 1, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 0, 1}
        };
        List<String> uniqueRows1 = uniqueRow(matrix1, 3, 4);
        System.out.println(String.join(" $", uniqueRows1) + " $");  // Expected output: "1 1 0 1 $1 0 0 1 $"

        // Test case 2
        int[][] matrix2 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1}
        };
        List<String> uniqueRows2 = uniqueRow(matrix2, 2, 4);
        System.out.println(String.join(" $", uniqueRows2) + " $");  // Expected output: "0 0 0 1 $"
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - The algorithm processes each row once, and for each row, it processes each column once to create a string. 
    Therefore, the time complexity is O(row * col), where `row` is the number of rows and `col` is the number of columns.
  
- Space Complexity:
  - We use a `HashSet` to store unique rows and a `List` to store the result. The space complexity is O(row), 
    where `row` is the number of rows, since we store at most `row` unique rows in the set and list.

*/

/* 
We use two `for` loops in the code:
1. The outer loop traverses each row of the matrix (from 0 to `row-1`).
2. The inner loop processes each element in the row to create a string representation of the row.

For input:
matrix1 = {{1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}}

1. i = 0: 
   - rowString = "1 1 0 1"
   - The row is not in the set, so add it to the result and the set.

2. i = 1:
   - rowString = "1 0 0 1"
   - The row is not in the set, so add it to the result and the set.

3. i = 2:
   - rowString = "1 1 0 1"
   - The row is already in the set, so it is skipped.

Result: ["1 1 0 1", "1 0 0 1"]

Output: "1 1 0 1 $1 0 0 1 $"
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For the first test case with matrix:
{{1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}}

- We start by traversing the first row. "1 1 0 1" is not in the set, so we add it to the result.
- We move to the second row. "1 0 0 1" is not in the set, so we add it to the result.
- The third row is "1 1 0 1", which is already in the set, so we skip it.

Final result: ["1 1 0 1", "1 0 0 1"]
Output: "1 1 0 1 $1 0 0 1 $"
*/ 
