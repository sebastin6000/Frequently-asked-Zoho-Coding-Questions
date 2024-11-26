/* 
Question:
Given an N X N matrix (M) filled with 1, 0, 2, 3:
- A value of cell 1 means Source.
- A value of cell 2 means Destination.
- A value of cell 3 means Blank cell.
- A value of cell 0 means Blank Wall.

You need to find the minimum number of moves needed to move from the source (1) to the destination (2) while traversing through blank cells (3) only. 
You can move up, down, right, and left. 

Each move in the matrix counts as ‘1’.

Examples:

Input:
M[3][3] = {{ 0 , 3 , 2 },
            { 3 , 3 , 0 },
            { 1 , 3 , 0 }};
Output: 4

Input:
M[4][4] = {{ 3 , 3 , 1 , 0 },
            { 3 , 0 , 3 , 3 },
            { 2 , 3 , 0 , 3 },
            { 0 , 3 , 3 , 3 }};
Output: 4

Your Task:
Implement the function that finds the minimum number of moves from the source to the destination.
*/

/* 
Understanding the Problem Statement:
1. We are given a grid that represents a map. Some cells are walkable (denoted by 3), some are walls (denoted by 0),
   and there are single source (denoted by 1) and destination (denoted by 2).
2. Our objective is to find the shortest path from the source to the destination, 
   moving through blank cells only, and we are allowed to move in four directions: up, down, left, and right.
3. We need to use the BFS (Breadth First Search) algorithm as it is suited for finding the shortest path in an unweighted grid.

What is being asked:
- We are to return the minimum number of moves required to go from the source (1) 
  to the destination (2) while traversing only blank cells (3). If no path exists, 
  the output should indicate failure (we can return -1 or any other indication for this case).

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A 2D matrix `M` of size N x N filled with integers {0, 1, 2, 3}.
2. Expected Output:
   - The minimum number of moves required to reach the destination from the source or -1 if there is no valid path.
3. Output return type:
   - An integer indicating the minimum number of moves.
4. Time complexity expectations:
   - The time complexity should be O(N^2), where N is the size of the matrix, since BFS will explore all cells in the worst case.
5. Constraints:
   - The grid size can go up to 10^6 elements (since N x N can be large).

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a typical pathfinding problem in a grid where we need to find the shortest path from the source to the destination using BFS.
   
2. Destructuring:
   - First, we need to find the source and destination in the grid.
   - Then, we need to use BFS to explore all valid cells starting from the source, keeping track of the number of moves.
   - We will stop when we reach the destination and return the number of moves.
   
3. Conversational solution into smaller subtask:
   - Step 1: Find the position of the source and the destination.
   - Step 2: Implement BFS starting from the source and explore all possible paths.
   - Step 3: During BFS, mark visited cells to avoid reprocessing.
   - Step 4: If the destination is reached, return the number of moves, otherwise return -1 if the destination is unreachable.

*/

/* 
Conversional Solution into Subtasks:
1. Find the position of the source (1) and the destination (2) in the matrix.
2. Implement BFS (Breadth-First Search) to explore the matrix starting from the source.
3. Keep track of the number of moves by incrementing it at each level of BFS.
4. Stop if we reach the destination and return the number of moves, otherwise return -1 if no path exists.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Parse the matrix and find the source and destination.
2. Implement BFS to find the shortest path.
3. Return the number of moves or -1 if no path exists.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.LinkedList;
import java.util.Queue;

public class MinMovesInMatrix {
    
    // Function to find the minimum number of moves from source to destination
    public static int minMoves(int[][] matrix) {
        int N = matrix.length;
        
        // Directions for moving in the matrix (right, down, left, up)
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};
        
        // Find the source and destination positions
        int sourceRow = -1, sourceCol = -1, destRow = -1, destCol = -1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {  // Source
                    sourceRow = i;
                    sourceCol = j;
                }
                if (matrix[i][j] == 2) {  // Destination
                    destRow = i;
                    destCol = j;
                }
            }
        }
        
        // If source or destination is not found, return -1
        if (sourceRow == -1 || destRow == -1) {
            return -1;
        }
        
        // BFS initialization
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sourceRow, sourceCol, 0});  // row, col, distance
        visited[sourceRow][sourceCol] = true;
        
        // BFS loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], dist = current[2];
            
            // If we reached the destination, return the distance
            if (row == destRow && col == destCol) {
                return dist;
            }
            
            // Explore the 4 possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + rowDir[i];
                int newCol = col + colDir[i];
                
                // Check if the new position is valid and not visited
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N 
                    && !visited[newRow][newCol] && (matrix[newRow][newCol] == 3 || matrix[newRow][newCol] == 2)) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                }
            }
        }
        
        // If destination is not reachable
        return -1;
    }
    
    // Main function to test the code
    public static void main(String[] args) {
        int[][] matrix1 = {
            {0, 3, 2},
            {3, 3, 0},
            {1, 3, 0}
        };
        System.out.println(minMoves(matrix1));  // Expected Output: 4
        
        int[][] matrix2 = {
            {3, 3, 1, 0},
            {3, 0, 3, 3},
            {2, 3, 0, 3},
            {0, 3, 3, 3}
        };
        System.out.println(minMoves(matrix2));  // Expected Output: 4
    }
}

/* 
Time and Space Complexity Explanation:
1. Time Complexity:
   - The BFS algorithm explores each cell at most once, and for each cell, 
     we perform constant time operations (checking 4 possible directions). Therefore, the time complexity is O(N^2), where N is the size of the matrix.
2. Space Complexity:
   - We use a queue for BFS, which can store up to N^2 elements in the worst case. Additionally, 
     we use a visited matrix of size N x N. Therefore, the space complexity is O(N^2).

*/

/* 
For loop walkthrough:
1. The outer loop iterates through the matrix to find the positions of the source and destination.
2. The BFS loop processes each cell by exploring its 4 possible neighbors (up, down, left, right).
3. For each unvisited, valid cell (either a blank cell or destination), we add it to the queue and mark it as visited.
4. Once we reach the destination, we return the number of moves.

*/

/* 
Complete code walkthrough with applying the given input:
1. For matrix1:
   - Source (1) is at position (2, 0) and Destination (2) is at position (0, 2).
   - BFS starts from (2, 0) and moves through the grid in 4 moves (to (2, 1), (1, 1), (1, 2), and finally to (0, 2)).
   - The result is 4.

2. For matrix2:
   - Source (1) is at position (0, 2) and Destination (2) is at position (2, 0).
   - BFS starts from (0, 2) and moves through the grid in 4 moves (to (1, 2), (1, 1), (2, 1), and finally to (2, 0)).
   - The result is 4.
*/
