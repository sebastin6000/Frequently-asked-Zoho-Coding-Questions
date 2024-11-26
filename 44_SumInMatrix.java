/* 
Question:
You are given a 0-indexed 2D integer array `nums`. Initially, your score is 0. Perform the following operations until the matrix becomes empty:

From each row in the matrix, select the largest number and remove it. In the case of a tie, it does not matter which number is chosen.
Identify the highest number amongst all those removed in step 1. Add that number to your score.
Return the final score.

Example 1:
Input: nums = [[7,2,1],[6,4,2],[6,5,3],[3,2,1]]
Output: 15
Explanation: 
In the first operation, we remove 7, 6, 6, and 3. We then add 7 to our score. 
Next, we remove 2, 4, 5, and 2. We add 5 to our score.
Lastly, we remove 1, 2, 3, and 1. We add 3 to our score. Thus, our final score is 7 + 5 + 3 = 15.

Example 2:
Input: nums = [[1]]
Output: 1
Explanation: We remove 1 and add it to the answer. We return 1.

*/

/* 
Understanding the Problem Statement:
- We are given a matrix `nums`, where each element in a row represents a number.
- In each operation, we select the largest number from each row and remove it.
- After selecting the largest number from each row, we add the highest of those numbers to the score.
- This process continues until the matrix becomes empty.

What is being asked:
- We need to calculate and return the final score after performing the operations as described.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A 2D integer array `nums`, where `nums.length` represents the number of rows and `nums[i].length` represents the number of elements in the ith row.
2. Expected Output:
   - A single integer representing the final score after performing the operations on the matrix.
3. Output return type:
   - Integer value.
4. Time complexity expectations:
   - We need to handle large inputs efficiently, ideally in O(m * n), where `m` is the number of rows and `n` is the number of elements in each row.
5. Constraints:
   - 1 <= nums.length <= 300
   - 1 <= nums[i].length <= 500
   - 0 <= nums[i][j] <= 103.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - In each operation, we remove the largest number from each row.
   - After that, we determine the maximum of those largest numbers and add it to our score.
   - We can remove the maximum number from each row by sorting each row and selecting the largest element.
   - To track the overall maximum of the selected numbers from each row, we can keep a running `max` variable.

2. Destructuring:
   - The main task is to extract the maximum number from each row in the matrix, find the maximum of those values, and add it to the score.
   - We can remove the maximum number from each row by sorting the rows and selecting the largest element.

3. Conversional solution into smaller subtask:
   - Subtask 1: Initialize a variable `score` to 0 to keep track of the score.
   - Subtask 2: For each row, find the largest number and store it.
   - Subtask 3: After finding the largest numbers in all rows, identify the highest among them and add it to the score.
   - Subtask 4: Repeat the process until the matrix becomes empty.
   - Subtask 5: Return the final score.

*/

/* 
Conversional Solution into Subtasks:
1. Initialize a variable `score` to 0.
2. Iterate through each row, find and remove the largest number from the row.
3. Track the maximum number among the removed elements.
4. Update the score with the largest of these numbers.
5. Repeat until the matrix becomes empty and return the final score.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Initialize `score` to 0.
2. For each row, find the largest number.
3. Track the maximum number among all removed numbers.
4. Update the score with the largest of these numbers.
5. Repeat until the matrix becomes empty and return the final score.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class FinalScore {

    // Function to calculate the final score
    public static int maxScore(int[][] nums) {
        int score = 0;
        
        // Subtask 1: Continue until all rows are removed
        while (nums.length > 0) {
            int maxOfThisRound = Integer.MIN_VALUE;
            
            // Subtask 2: Find the largest number from each row
            for (int i = 0; i < nums.length; i++) {
                int maxInRow = Arrays.stream(nums[i]).max().getAsInt();
                maxOfThisRound = Math.max(maxOfThisRound, maxInRow);
                
                // Remove the largest number from the current row
                nums[i] = removeLargest(nums[i]);
            }
            
            // Subtask 3: Add the largest number among the removed ones to score
            score += maxOfThisRound;
            
            // Subtask 4: Remove any empty rows from the matrix
            nums = Arrays.stream(nums).filter(row -> row.length > 0).toArray(int[][]::new);
        }

        // Subtask 5: Return the final score
        return score;
    }

    // Helper function to remove the largest number from a row
    private static int[] removeLargest(int[] row) {
        int max = Arrays.stream(row).max().getAsInt();
        return Arrays.stream(row).filter(num -> num != max).toArray();
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[][] input1 = {{7,2,1},{6,4,2},{6,5,3},{3,2,1}};
        System.out.println(maxScore(input1));  // Expected output: 15

        // Test case 2
        int[][] input2 = {{1}};
        System.out.println(maxScore(input2));  // Expected output: 1
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - In each round, we process each row, find the maximum element in the row, and remove it. 
  - Finding the maximum element in a row takes O(n), where n is the length of the row. Since we do this for each row, 
    the total complexity for each round is O(m * n), where m is the number of rows and n is the number of columns.
  - The number of rounds is at most m, as after each round, we remove at least one element from each row.
  - Overall, the time complexity is O(m * n), where m is the number of rows and n is the average number of elements in each row.

- Space Complexity:
  - The space complexity is O(m * n) because we are using an additional 2D array to store the matrix after removing the largest elements.
  - We also use additional space for storing intermediate results, but this does not exceed O(m * n).

*/

/* 
“for” loop or “while” loop walkthrough with every iteration with given input.
*/

/* 
In the `maxScore` method, we use the following loops:
1. The outer `while` loop continues until all rows are empty.
2. Inside it, a `for` loop iterates over each row to find the largest number in the row, and another operation removes that number.
3. We also filter out empty rows after processing each round.
*/

 /* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input: 
nums = [[7, 2, 1], [6, 4, 2], [6, 5, 3], [3, 2, 1]]

1. Round 1:
   - Largest from row 1: 7
   - Largest from row 2: 6
   - Largest from row 3: 6
   - Largest from row 4: 3
   - We add 7 to the score, so score = 7.
   - The matrix after removing the largest numbers: 
     [[2, 1], [4, 2], [5, 3], [2, 1]]

2. Round 2:
   - Largest from row 1: 2
   - Largest from row 2: 4
   - Largest from row 3: 5
   - Largest from row 4: 2
   - We add 5 to the score, so score = 7 + 5 = 12.
   - The matrix after removing the largest numbers: 
     [[1], [2], [3], [1]]

3. Round 3:
   - Largest from row 1: 1
   - Largest from row 2: 2
   - Largest from row 3: 3
   - Largest from row 4: 1
   - We add 3 to the score, so score = 12 + 3 = 15.

Final score = 15
*/ 
