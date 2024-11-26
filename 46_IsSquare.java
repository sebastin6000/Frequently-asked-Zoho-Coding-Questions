/* 
Question:
Given four different points in space, determine whether these points can form a square. 

For example:
Input: 
x1 = 20, y1 = 10, x2 = 10, y2 = 20, 
x3 = 20, y3 = 20, x4 = 10, y4 = 10 
Output: Yes
Explanation: The points (20,10), (10,20), (20,20), (10,10) form a square.

Input:
x1 = 2, y1 = 1, x2 = 10, y2 = 20, 
x3 = 5, y3 = 6, x4 = 10, y4 = 10 
Output: No
Explanation: The points (2,1), (10,20), (5,6), (10,10) don't form a square.

Your task is to implement a function `isSquare()` that takes eight integers as input (x1, y1, x2, y2, x3, y3, x4, y4) 
and returns whether these points form a square.

*/

/* 
Understanding the Problem Statement:
- The task is to check if four given points form a square.
- A square has four equal-length sides and two equal-length diagonals that intersect at right angles.
- We are given four points in a 2D plane, and we need to determine if they can form a square.
- We need to return "Yes" if the points form a square, and "No" otherwise.

What is being asked:
- We are asked to return whether four given points can form a square. To determine if a set of points forms a square, we need to check:
  1. If the four sides are of equal length.
  2. If the two diagonals are of equal length.
  3. If the diagonals intersect at right angles.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - Eight integers representing the coordinates of four points in a 2D plane (x1, y1, x2, y2, x3, y3, x4, y4).
   
2. Expected Output:
   - A string, either "Yes" or "No", indicating whether the points form a square.

3. Output return type:
   - String.

4. Time complexity expectations:
   - The solution should work in constant time O(1), since we are only checking the distance between a fixed number of points (four points).
   
5. Constraints:
   - The coordinates of the points will be integers in the range -103 ≤ x, y ≤ 103.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - The problem is essentially checking whether the four points can form a square. To do this, we need to:
     1. Compute the distances between all pairs of points.
     2. Check if there are 4 equal distances (sides of the square) and 2 equal distances (diagonals of the square).
     3. The diagonals should be longer than the sides, and they should intersect at right angles.
     
2. Destructuring:
   - To check if four points form a square:
     1. Calculate the squared distances between all pairs of points.
     2. The four smallest distances should be equal (the sides).
     3. The two largest distances should be equal (the diagonals).
     4. The diagonals must be longer than the sides.

3. Conversational solution into smaller subtask:
   - Subtask 1: Calculate the squared distances between all pairs of points.
   - Subtask 2: Sort these distances and check the conditions for forming a square.
   - Subtask 3: Return "Yes" if the points form a square, otherwise return "No".

*/

/* 
Conversional Solution into Subtasks:
1. Calculate the squared Euclidean distance between all pairs of points.
2. Sort the distances and check if the four smallest distances are equal (sides of the square) and the two largest distances are equal (diagonals).
3. Ensure that the diagonals are longer than the sides, as diagonals in a square are always longer than the sides.
4. Return "Yes" if the conditions are met, otherwise "No".

*/

/* 
Subtasks of Conversional Solution into Code:
1. Calculate the squared distances between each pair of points to avoid dealing with floating-point numbers.
2. Sort the distances and check if the four smallest are equal (the sides) and the two largest are equal (the diagonals).
3. Return the result based on the checks above.

*/

/* 
Java Code according to conversational subtasks.
*/

public class SquareCheck {

    // Function to calculate the squared distance between two points
    private static int distanceSquared(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }

    // Function to check if the four points can form a square
    public static String isSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // Step 1: Calculate squared distances between all pairs of points
        int[] distances = new int[6];
        distances[0] = distanceSquared(x1, y1, x2, y2);
        distances[1] = distanceSquared(x1, y1, x3, y3);
        distances[2] = distanceSquared(x1, y1, x4, y4);
        distances[3] = distanceSquared(x2, y2, x3, y3);
        distances[4] = distanceSquared(x2, y2, x4, y4);
        distances[5] = distanceSquared(x3, y3, x4, y4);
        
        // Step 2: Sort the distances
        java.util.Arrays.sort(distances);
        
        // Step 3: Check if the first 4 distances are equal (sides of square) and last 2 are equal (diagonals)
        if (distances[0] > 0 && distances[0] == distances[1] && distances[0] == distances[2] && distances[0] == distances[3]
            && distances[4] == distances[5]) {
            // Step 4: Check if diagonals are longer than sides
            return "Yes";
        }
        
        // If conditions are not met, return "No"
        return "No";
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        System.out.println(isSquare(20, 10, 10, 20, 20, 20, 10, 10));  // Expected output: Yes

        // Test case 2
        System.out.println(isSquare(2, 1, 10, 20, 5, 6, 10, 10));  // Expected output: No
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Calculating the squared distances takes O(1) because we have only 6 pairs of points.
  - Sorting the distances takes O(1) because the array size is fixed (6 elements).
  - Overall, the time complexity is O(1).

- Space Complexity:
  - We use a fixed amount of space to store the distances (an array of size 6).
  - The space complexity is O(1).

*/

/* 
If used any “for” loop or “while” loop you have walkthrough all the “for” loop used in the code with every iteration with given input and this section has to be inside this structure of comments.
*/

/* 
In this case, the code does not use a loop to process distances because we are only dealing with a fixed number of pairs (6).
The sorted distances array is checked directly for the conditions using simple comparison operators.
*/

 /* 
For input:
x1 = 20, y1 = 10, x2 = 10, y2 = 20, 
x3 = 20, y3 = 20, x4 = 10, y4 = 10

1. Calculate squared distances between all pairs of points:
   - distance1 (x1, y1) to (x2, y2) = (20-10)^2 + (10-20)^2 = 100 + 100 = 200
   - distance2 (x1, y1) to (x3, y3) = (20-20)^2 + (10-20)^2 = 0 + 100 = 100
   - distance3 (x1, y1) to (x4, y4) = (20-10)^2 + (10-10)^2 = 100 + 0 = 100
   - distance4 (x2, y2) to (x3, y3) = (10-20)^2 + (20-20)^2 = 100 + 0 = 100
   - distance5 (x2, y2) to (x4, y4) = (10-10)^2 + (20-10)^2 = 0 + 100 = 100
   - distance6 (x3, y3) to (x4, y4) = (20-10)^2 + (20-10)^2 = 100 + 100 = 200

2. Sort the distances:
   distances = [100, 100, 100, 100, 200, 200]

3. Check if the first 4 distances are equal and the last 2 are equal:
   - The first 4 distances are equal and the last 2 distances are equal.
   - Thus, return "Yes".
*/

