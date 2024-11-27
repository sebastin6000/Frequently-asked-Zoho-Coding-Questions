/*
Question Section:
1. A N x N chessboard has a Queen positioned at (x, y). The Queen can move any number of squares horizontally, 
   vertically, or diagonally, but cannot move through obstacles placed on the board. 
2. Given:
    - Board size (N),
    - Position of the Queen (x, y),
    - Number of obstacles (K) and their positions,
   Find the total number of cells the Queen can move to.

Examples:
Input 1: N = 8, x = 4, y = 4, K = 0
Output 1: 27

Input 2: N = 8, x = 4, y = 4, K = 1, kx1 = 3, ky1 = 5
Output 2: 24
*/

/*
Understanding the Problem Statement Section:
1. The objective is to determine the Queen's possible moves on the board, considering obstacles.
2. The Queen's moves are restricted by board boundaries and the presence of obstacles.

Key Observations:
- The Queen moves in 8 possible directions:
    1. Up, Down
    2. Left, Right
    3. 4 Diagonals (Top-Left, Top-Right, Bottom-Left, Bottom-Right)
- An obstacle blocks further movement in its direction.
*/

/*
Extracting Information from the Problem Statement Section:
1. Input Data Type:
    - N (int): Size of the chessboard.
    - x, y (int): Queen's initial position.
    - K (int): Number of obstacles.
    - Array of K pairs (kx, ky): Positions of obstacles.
2. Expected Output:
    - Number of cells the Queen can move to.
3. Output Data Type:
    - int (number of possible moves).
4. Constraints:
    - 1 <= N <= 1000
    - 1 <= x, y <= N
    - 0 <= K <= N^2
    - Obstacles are within the chessboard.
5. Time Complexity Expectations:
    - O(K + N), where K is the number of obstacles and N is the board size.
*/

/*
Thinking Solution for the Problem Statement Section:
1. Recognize the Problem Type:
    - The Queen's moves can be calculated directionally by simulating movement until a boundary or obstacle is hit.
2. Decompose the Problem:
    - Use directional arrays to simulate the Queen's movements.
    - Stop movement in a direction if an obstacle or board edge is reached.
3. Subtasks:
    - Initialize valid move count.
    - Simulate Queen's movement in all 8 directions.
    - For each move, check if it is within bounds and not blocked by obstacles.
    - Update the valid move count.
*/
/*
Conversional Solution into Subtasks Section:
Subtasks:
1. Parse the input: N, (x, y), K, and the K obstacles.
2. Represent obstacles in a fast lookup structure (HashSet).
3. Simulate Queen's movement in each direction:
    a. Count cells until a boundary or obstacle is hit.
4. Return the total count of valid cells.
*/

import java.util.HashSet;

public class ChessboardQueenObstacles {
    public static int countQueenMoves(int N, int x, int y, int[][] obstacles) {
        // Subtask 1: Parse Input
        // Create a HashSet to store obstacle positions for quick access
        HashSet<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Subtask 2: Define directions for Queen's movement
        // Each pair represents (dx, dy) for one of the 8 directions
        int[][] directions = {
            {0, 1}, {0, -1},   // Right, Left
            {1, 0}, {-1, 0},   // Down, Up
            {1, 1}, {-1, -1},  // Bottom-right, Top-left
            {1, -1}, {-1, 1}   // Bottom-left, Top-right
        };

        // Subtask 3: Count valid moves
        int validMoves = 0;

        // Loop through each direction
        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            int nx = x, ny = y;

            // Simulate movement in the current direction
            while (true) {
                nx += dx;
                ny += dy;

                // Check if the move is within bounds
                if (nx < 1 || nx > N || ny < 1 || ny > N) break;

                // Check if the move is blocked by an obstacle
                if (obstacleSet.contains(nx + "," + ny)) break;

                // Count the valid move
                validMoves++;
            }
        }

        return validMoves;
    }

    public static void main(String[] args) {
        // Test Case 1
        int N = 8, x = 4, y = 4;
        int[][] obstacles1 = {};
        System.out.println("Output 1: " + countQueenMoves(N, x, y, obstacles1)); // Expected: 27

        // Test Case 2
        int[][] obstacles2 = {{3, 5}};
        System.out.println("Output 2: " + countQueenMoves(N, x, y, obstacles2)); // Expected: 24
    }
}

/*
Time and Space Complexity Explanation Section:
1. Time Complexity:
    - O(K + N): 
        - O(K) for processing obstacles into a HashSet.
        - O(N) for simulating Queen's movement in each direction (up to N steps).
2. Space Complexity:
    - O(K) for storing obstacles in the HashSet.

Code Walkthrough:
1. Input: N = 8, x = 4, y = 4, obstacles = {}
   - Initialize validMoves = 0.
   - Simulate each of the 8 directions.
   - For each direction, count moves until an edge or obstacle is reached.
2. Output the total valid moves: 27.

3. Input: N = 8, x = 4, y = 4, obstacles = {{3, 5}}
   - Initialize validMoves = 0.
   - Simulate each of the 8 directions, stopping early for the obstacle.
   - Output the total valid moves: 24.
*/
