/* 
Question:
Given an array `arr[]` of non-negative numbers, the task is to find the first equilibrium point in the array. 
The equilibrium point is an index such that the sum of all elements before that index is equal to the sum of elements after it.

For example:

Input: arr[] = [1, 3, 5, 2, 2]
Output: 3
Explanation: The equilibrium point is at position 3, as the sum of elements before it (1 + 3) = sum of elements after it (2 + 2).

Input: arr[] = [0, 1, 0]
Output: 2
Explanation: The equilibrium point is at position 2, as the sum of elements before 1 and after 1 are the same.

Input: arr[] = [1, 2, 3]
Output: -1
Explanation: There is no equilibrium point in the given array.

You need to return the equilibrium point in 1-based indexing. If no such point exists, return -1.

Constraints:
- 3 <= arr.size() <= 10^6
- 0 <= arr[i] <= 10^9
*/

 /* 
Understanding the Problem Statement:
- We are given an array of non-negative integers, and we need to find the first equilibrium point.
- The equilibrium point is defined as the index where the sum of elements to the left is equal to the sum of elements to the right.
- We are asked to return the 1-based index of the equilibrium point or -1 if no such point exists.

What is being asked:
- We need to compute the first equilibrium point of the array.
- The answer should be in 1-based indexing.
- If no equilibrium point exists, we should return -1.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An array `arr[]` of integers (non-negative).
2. Expected Output:
   - An integer representing the index of the first equilibrium point (1-based indexing).
   - Return -1 if no equilibrium point exists.
3. Output return type:
   - Integer.
4. Time complexity expectations:
   - The time complexity should be O(n), as the array can be large (up to 10^6 elements).
5. Constraints:
   - 3 <= arr.size() <= 10^6
   - 0 <= arr[i] <= 10^9
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem is about finding the equilibrium point in an array, 
     which is a common problem that can be solved using prefix and suffix sums or a running total approach.
   - The key is to keep track of the sum of the elements before and after each index efficiently, without needing to repeatedly compute sums from scratch.

2. Destructuring:
   - To find the equilibrium point, we can use a running sum from the left and right of the array.
   - For each index `i`, we can calculate the total sum of the elements 
     and use it to check if the sum of the elements before the index is equal to the sum of the elements after the index.
   - The problem can be solved in linear time by iterating through the array only once.

3. Conversional solution into smaller subtask:
   - Subtask 1: Calculate the total sum of the array.
   - Subtask 2: Use a variable `left_sum` to track the sum of elements before the current index.
   - Subtask 3: For each element at index `i`, check if `left_sum` is equal to `right_sum` (total sum minus `left_sum` minus the current element).
   - Subtask 4: Return the 1-based index of the first equilibrium point or -1 if no equilibrium point is found.

*/

/* 
Conversional Solution into Subtasks:
1. Calculate the total sum of the array.
2. Initialize `left_sum` to 0.
3. Iterate through the array:
   - For each element at index `i`, 
     calculate the sum of elements before it (`left_sum`) and check if it equals the sum of elements after it (`total_sum - left_sum - arr[i]`).
4. If such an index is found, return its 1-based index.
5. If no equilibrium point is found, return -1.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Compute the total sum of the array.
2. Use a running sum approach to check if the current element is the equilibrium point.
3. Return the equilibrium index (1-based) or -1 if no equilibrium exists.

*/

/* 
Java Code according to conversational subtasks.
*/

public class EquilibriumPoint {
    
    // Function to find the first equilibrium point
    public static int equilibriumPoint(int[] arr) {
        int n = arr.length;
        
        // Step 1: Calculate the total sum of the array
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        
        // Step 2: Initialize left_sum to 0
        long leftSum = 0;
        
        // Step 3: Iterate through the array to find the equilibrium point
        for (int i = 0; i < n; i++) {
            // Step 4: Calculate the right_sum (total_sum - left_sum - arr[i])
            long rightSum = totalSum - leftSum - arr[i];
            
            // Step 5: Check if left_sum equals right_sum
            if (leftSum == rightSum) {
                // Return the 1-based index of the equilibrium point
                return i + 1; // 1-based index
            }
            
            // Update left_sum for the next iteration
            leftSum += arr[i];
        }
        
        // Step 6: If no equilibrium point is found, return -1
        return -1;
    }
    
    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 3, 5, 2, 2};
        System.out.println(equilibriumPoint(arr1)); // Expected output: 3

        // Test case 2
        int[] arr2 = {0, 1, 0};
        System.out.println(equilibriumPoint(arr2)); // Expected output: 2

        // Test case 3
        int[] arr3 = {1, 2, 3};
        System.out.println(equilibriumPoint(arr3)); // Expected output: -1
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity: O(n), where n is the length of the array. 
  We traverse the array twice — once to calculate the total sum and once to check for the equilibrium point.
- Space Complexity: O(1), since we only use a few extra variables (`leftSum`, `totalSum`, and `rightSum`) and do not store additional data structures.

*/

/* 
“for” loop walkthrough with every iteration with given input.
*/

/* 
In the first for loop:
- We calculate the total sum of the array.
- For example, for `arr = [1, 3, 5, 2, 2]`, the total sum will be 13.

In the second for loop:
- We iterate over each element of the array.
- For example, when `i = 2` (element 5), we calculate `leftSum = 4` (sum of elements before index 2) and `rightSum = 4` (sum of elements after index 2).
- Since `leftSum == rightSum`, the equilibrium point is found at index 3 (1-based index).

*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input `arr = [1, 3, 5, 2, 2]`:
- First loop (to calculate total sum):
  - Total sum = 1 + 3 + 5 + 2 + 2 = 13.
- Second loop (to find equilibrium):
  - i = 0: leftSum = 0, rightSum = 13 - 0 - 1 = 12. No equilibrium.
  - i = 1: leftSum = 1, rightSum = 13 - 1 - 3 = 9. No equilibrium.
  - i = 2: leftSum = 4, rightSum = 13 - 4 - 5 = 4. Equilibrium found at index 3 (1-based).
  
Final result: 3.

For input `arr = [0, 1, 0]`:
- Total sum = 1.
- i = 0: leftSum = 0, rightSum = 1 - 0 - 0 = 1. No equilibrium.
- i = 1: leftSum = 0, rightSum = 1 - 0 - 1 = 0. Equilibrium found at index 2 (1-based).

Final result: 2.

For input `arr = [1, 2, 3]`:
- Total sum = 6.
- i = 0: leftSum = 0, rightSum = 6 - 0 - 1 = 5. No equilibrium.
- i = 1: leftSum = 1, rightSum = 6 - 1 - 2 = 3. No equilibrium.
- i = 2: leftSum = 3, rightSum = 6 - 3 - 3 = 0. No equilibrium.

Final result: -1.
*/
