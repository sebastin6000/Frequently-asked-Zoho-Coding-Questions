--------------------------UNFINISHED----------------------

/* 
Question: 
Given an unsorted integer array arr[], 
find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles.
A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

Example 1:
Input: arr[] = [3, 5, 4]
Output: 1
Explanation: A triangle is possible with all the elements 5, 3, and 4 (5 + 3 > 4, 5 + 4 > 3, 3 + 4 > 5)

Example 2:
Input: arr[] = [6, 4, 9, 7, 8]
Output: 10
Explanation: There are 10 triangles possible with the given elements like (6,4,9), (6,7,8), etc.

Constraints:
3 <= arr.size() <= 103
1 <= arr[i] <= 103
*/


/* 
Input-output explanation:

Input:
arr[] = [3, 5, 4]
Output:
1

Explanation: The input array has three elements: 3, 5, and 4. These three elements form a valid triangle since:
- 3 + 4 > 5
- 3 + 5 > 4
- 4 + 5 > 3
Therefore, the output is 1, indicating that exactly one triangle can be formed with these sides.

Input:
arr[] = [6, 4, 9, 7, 8]
Output:
10

Explanation: The input array has five elements: 6, 4, 9, 7, and 8. You can form 10 different triangles by choosing three different elements at a time:
Possible combinations:
- (6, 4, 9)
- (6, 7, 8)
- (6, 9, 7)
- (4, 7, 8)
- etc.

The output is 10 because there are 10 such combinations that satisfy the triangle condition.

*/

/* 
Constraints explanation:

- The size of the array, arr[], is between 3 and 1000 elements (3 <= arr.size() <= 103). 
- The values of the array elements are between 1 and 1000 (1 <= arr[i] <= 103).

Given these constraints, our approach should handle arrays of size up to 1000 efficiently. 
We will be using sorting and then checking combinations in a way that ensures the solution runs quickly within the given limits.
*/

/* 
Relatable analogy or real-world scenario:

Imagine you're organizing a team for a tug-of-war game. You want to select three players at a time from a group of friends, but for a fair game, you have a special rule:
- The combined strength of any two players must be greater than the strength of the third player.

So, you need to check all possible groups of three players and see if they meet the strength requirement. 
This is essentially checking all possible combinations of three numbers in the array to see if they form a valid triangle where:
- sum of any two sides > third side

Let's break this down:

1. **Group of Players**: These are the numbers in your array.
2. **Checking Combinations**: You need to check all possible combinations of three players (numbers), just like trying all combinations of three numbers from the array.
3. **Triangle Condition**: The sum of the strengths of any two players must be greater than the third player's strength (like forming a valid triangle).

We can check these combinations and count how many valid triangles we can form.

*/

/* 
Relatable analogy Java code step by step:

Step 1: 
We will first sort the array of players' strengths so that we can easily check the triangle condition (sum of two sides > third side).

Step 2: 
Then, we will use three nested loops to check every possible combination of three numbers.

Step 3:
For each combination, check if it satisfies the triangle condition (sum of any two sides > third side).

Step 4: 
Count how many valid triangles there are and return the count.

*/

import java.util.Arrays;

public class NumberOfTriangles {

    // Function to count the number of valid triangles
    public static int countTriangles(int[] arr) {
        int n = arr.length; // Get the size of the array
        int count = 0; // Initialize the counter for valid triangles
        
        // Step 1: Sort the array so that we can check the triangle condition easily
        Arrays.sort(arr);

        // Step 2: Iterate through all possible combinations of three elements
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Step 3: Check if the combination (arr[i], arr[j], arr[k]) forms a valid triangle
                    if (arr[i] + arr[j] > arr[k]) {
                        count++; // If valid, increment the count
                    }
                }
            }
        }

        // Step 4: Return the total number of valid triangles
        return count;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {3, 5, 4};
        System.out.println(countTriangles(arr1)); // Output: 1

        // Test case 2
        int[] arr2 = {6, 4, 9, 7, 8};
        System.out.println(countTriangles(arr2)); // Output: 10
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- Sorting the array takes O(n log n), where n is the size of the array.
- The three nested loops go through all combinations of three elements, which results in O(n^3) time complexity.

Thus, the overall time complexity is O(n^3). This is acceptable for smaller arrays, but may not be efficient enough for the largest possible input sizes (n = 1000).

Space Complexity:
- We are using only a constant amount of extra space, aside from the input array itself. So, the space complexity is O(1).

*/

/* 
FOR loop walkthrough with every iteration with given input, Complete code walkthrough with applying the given input in code and explanation:

Input: arr[] = [3, 5, 4]

1. Sorting the array: arr = [3, 4, 5]
2. First iteration:
   i = 0, j = 1, k = 2, arr[i] = 3, arr[j] = 4, arr[k] = 5
   Check if 3 + 4 > 5 -> True, so this forms a valid triangle.
   count = 1
3. No further valid triangles are found, so we return count = 1.

Input: arr[] = [6, 4, 9, 7, 8]

1. Sorting the array: arr = [4, 6, 7, 8, 9]
2. First iteration:
   i = 0, j = 1, k = 2, arr[i] = 4, arr[j] = 6, arr[k] = 7
   Check if 4 + 6 > 7 -> True, valid triangle.
   count = 1
   i = 0, j = 1, k = 3, arr[i] = 4, arr[j] = 6, arr[k] = 8
   Check if 4 + 6 > 8 -> True, valid triangle.
   count = 2
   And so on...
3. After checking all combinations, we return count = 10.
*/

/* Complete code walkthrough with applying the given input in code and explanation:
- First, the array is sorted, which helps simplify the triangle checks.
- Then, we loop through all possible combinations of three elements using nested loops.
- For each combination, we check if the triangle inequality holds, i.e., if the sum of any two sides is greater than the third.
- Finally, we count how many valid triangles we can form and return the count.
*/

