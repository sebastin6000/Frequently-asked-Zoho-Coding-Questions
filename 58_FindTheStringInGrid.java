/* 
Question:
Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. 
Word is said to be found in a direction if all characters match in this direction (not in zig-zag form). 
The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

Note: The returning list should be lexicographically smallest. 
If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once. 

Example 1:

Input: 
grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: 
{{0,0}}
Explanation: 
From (0,0) we can find "abc" in horizontally right direction.

Example 2:

Input: 
grid = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}
word = "abe"
Output: 
{{0,0},{0,2},{1,0}}
Explanation: 
From (0,0) we can find "abe" in right-down diagonal. 
From (0,2) we can find "abe" in left-down diagonal. 
From (1,0) we can find "abe" in horizontally right direction.

Your Task:
You don't need to read or print anything, 
Your task is to complete the function searchWord() 
which takes grid and word as input parameters and returns a list containing the positions from where the word originates in any direction. 
If there is no such position then returns an empty list.

Expected Time Complexity: O(n*m*k) where k is constant
Expected Space Complexity: O(1)

Constraints:
1 <= n <= m <= 50
1 <= |word| <= 15
*/

/* 
Understanding the Problem Statement:
- You are given a 2D grid of characters.
- You are also given a word.
- The task is to find all occurrences of the word in the grid, checking in all 8 possible directions.
- The valid directions include:
    - Horizontally right
    - Horizontally left
    - Vertically up
    - Vertically down
    - 4 diagonal directions (top-left, top-right, bottom-left, bottom-right)
- We need to return a list of coordinates from where the word starts in the grid, considering the directions mentioned.
- The coordinates must be lexicographically smallest, meaning that if two positions are found with the same word but in different directions, 
  only the first (lexicographically smaller) one should be kept.
- If no occurrence is found, return an empty list.

What is being asked:
- Implement the function `searchWord(grid, word)` 
  which returns a list of coordinates (row, column) where the word is found in the grid in any of the 8 directions.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input consists of a 2D array (grid) of size `n x m`, where each element is a character.
   - The input also includes a string `word` whose occurrences need to be found in the grid.
   
2. Expected Output:
   - The function should return a list of coordinates where the word starts in the grid, considering all 8 directions.

3. Output return type:
   - The return type should be a list of coordinate pairs, each representing the starting point of the word.

4. Time complexity expectations:
   - The time complexity should be O(n * m * k), where `k` is a constant that represents the length of the word (which is ≤ 15). 
     We will check each potential starting position and each direction.
   
5. Constraints:
   - The grid can have a maximum size of 50x50, and the length of the word is at most 15 characters.
   - The problem allows for up to 50 * 50 possible starting positions, and for each, we need to check 8 possible directions.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a grid search problem where we need to check every possible direction from each cell for the given word.
   - We can use a helper function that checks if the word matches from a given starting point in a particular direction.
   
2. Destructuring:
   - Start from each cell in the grid and check in all 8 possible directions.
   - For each direction, check if the word can be found by iterating through the grid from the current position.
   - If the word is found, add the starting coordinates to the result list.
   
3. Conversational solution into smaller subtask:
   - Subtask 1: Loop over all the grid cells (n x m).
   - Subtask 2: For each cell, check all 8 directions.
   - Subtask 3: For each direction, check if the word can be formed by looking at subsequent grid positions.
   - Subtask 4: If the word is found, store the starting coordinates.
   - Subtask 5: Sort the coordinates lexicographically and return them.

*/

/* 
Conversional Solution into Subtasks:
1. Loop over all grid cells.
2. For each grid cell, check if the word can be formed in any of the 8 directions:
   - Use helper functions to check all 8 directions.
3. For each direction, check the word formation by matching characters in the grid.
4. If the word is found, store the position.
5. Sort the positions lexicographically and return.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a helper function `isWordFound()` to check if the word can be found in a particular direction.
2. Loop over each grid cell and for each cell, check all 8 directions.
3. Store valid positions where the word is found.
4. Return the sorted positions as the result.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class SearchWordInGrid {

    // Directions array for the 8 possible directions
    static int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1}; // row direction
    static int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1}; // column direction

    // Helper function to check if word can be found starting from (r, c) in direction (dir)
    private static boolean isWordFound(char[][] grid, String word, int r, int c, int dir) {
        int n = grid.length;
        int m = grid[0].length;
        int len = word.length();

        // Check if the word can fit in this direction
        for (int i = 0; i < len; i++) {
            int newRow = r + i * dRow[dir];
            int newCol = c + i * dCol[dir];

            // Check if the new position is out of bounds or doesn't match the character
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || grid[newRow][newCol] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Function to find all occurrences of the word in the grid
    public static List<int[]> searchWord(char[][] grid, String word) {
        List<int[]> result = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;

        // Loop over each cell in the grid
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                // Check if the word can be formed from grid[r][c] in any of the 8 directions
                for (int dir = 0; dir < 8; dir++) {
                    if (isWordFound(grid, word, r, c, dir)) {
                        result.add(new int[]{r, c});
                        break; // Once found, no need to check other directions for the same starting point
                    }
                }
            }
        }

        // Sort the results lexicographically
        result.sort((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        return result;
    }

    // Main function to test the code
    public static void main(String[] args) {
        // Test case 1
        char[][] grid1 = {
            {'a', 'b', 'c'},
            {'d', 'r', 'f'},
            {'g', 'h', 'i'}
        };
        String word1 = "abc";
        List<int[]> result1 = searchWord(grid1, word1);
        for (int[] pos : result1) {
            System.out.println(Arrays.toString(pos)); // Expected output: [0, 0]
        }

        // Test case 2
        char[][] grid2 = {
            {'a', 'b', 'a', 'b'},
            {'a', 'b', 'e', 'b'},
            {'e', 'b', 'e', 'b'}
        };
        String word2 = "abe";
        List<int[]> result2 = searchWord(grid2, word2);
        for (int[] pos : result2) {
            System.out.println(Arrays.toString(pos)); // Expected output: [0, 0], [0, 2], [1, 0]
        }
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:
- We iterate over all grid cells, which is O(n * m).
- For each cell, we check 8 possible directions, and for each direction, we check a word of length `k` (max 15).
- Thus, the time complexity is O(n * m * k), where `k` is the length of the word, which is constant (<=15).

Space Complexity:
- The space complexity is O(1) as we only use a constant amount of extra space for checking directions, 
  and the space used for storing results does not depend on the grid size.

*/

/* 
For Loop Walkthrough:
- The outer `for` loop iterates through each cell in the grid (n * m).
- For each cell, the inner `for` loop checks the 8 directions for matching the word.
- If the word is found in any direction, the starting position is added to the result list.
- The result list is sorted lexicographically before returning.

Complete Code Walkthrough:
- We start by looping through every cell in the grid.
- For each cell, we check the 8 possible directions for the word.
- If the word matches in a direction, the starting position is added to the result list.
- After checking all cells, we sort the result list lexicographically.
- Finally, the result is returned.
*/
