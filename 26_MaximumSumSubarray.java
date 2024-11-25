/* 
   QUESTION:

   Given an integer array arr[], you need to find the maximum sum of a subarray. 

   Examples:
   Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
   Output: 11
   Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.

   Input: arr[] = [-2, -4]
   Output: -2
   Explanation: The subarray {-2} has the largest sum -2.

   Input: arr[] = [5, 4, 1, 7, 8]
   Output: 25
   Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.

   Constraints:
   - 1 ≤ arr.size() ≤ 10^5
   - -10^9 ≤ arr[i] ≤ 10^4
*/
  
/* 
   UNDERSTANDING THE PROBLEM STATEMENT:

   We are tasked with finding the maximum sum of any contiguous subarray in a given array of integers. 

   A subarray is a contiguous portion of an array, and we need to find which subarray has the largest sum.
   Example: 
   - If arr[] = [2, 3, -8, 7, -1, 2, 3], the maximum subarray sum is 11, which corresponds to the subarray {7, -1, 2, 3}.

   The key points to focus on are:
   - We are dealing with an array of integers (which could be positive or negative).
   - We need to find the maximum sum of a contiguous subarray.

   What is being asked:
   - We need to return the maximum sum that can be obtained from any contiguous subarray within the given array.
*/
  
/* 
   EXTRACTING INFORMATION FROM THE PROBLEM STATEMENT:

   - Input data type:
     - The input is an array of integers (arr[]) where each element is an integer.
   
   - Expected Output:
     - The output should be a single integer, which is the maximum sum of any contiguous subarray.
   
   - Output return type:
     - Integer (int) representing the maximum sum.
   
   - Explanation of time complexity expectations:
     - Since the input size can go up to 100,000 elements, we need to come up with an efficient solution, 
       ideally with a time complexity of O(n), where n is the number of elements in the array.
   
   - Explanation of given constraints:
     - The array size can range from 1 to 100,000.
     - The elements of the array can range from -10^9 to 10^4.
     - So, we must ensure the solution handles negative numbers and large inputs efficiently.
*/
  
/* 
   THINKING SOLUTION FOR THE PROBLEM STATEMENT:

   We are asked to find the maximum sum of any contiguous subarray. 
   This problem is a classic one and can be efficiently solved using Kadane's Algorithm, which works in linear time, O(n).

   - The idea is to traverse the array and at each element, decide whether to:
     1. Start a new subarray with the current element.
     2. Or extend the existing subarray (i.e., add the current element to the sum so far).
   
   The decision is based on whether the sum of the current subarray will be greater by including the current element or not. 
    If not, we start a new subarray with the current element.

   The algorithm keeps track of two values:
   - `current_sum`: the sum of the subarray ending at the current element.
   - `max_sum`: the largest sum encountered so far.

   At the end, `max_sum` will contain the maximum sum of any contiguous subarray.
*/
  
/* 
   CONVERSIONAL SOLUTION INTO SUBTASKS:

   Subtask 1: Initialize two variables, `current_sum` and `max_sum`.
   - `current_sum` will keep track of the sum of the current subarray.
   - `max_sum` will store the maximum sum found so far.

   Subtask 2: Traverse the array and for each element:
   - Update `current_sum` to either:
     1. `current_sum + arr[i]` (extend the current subarray).
     2. `arr[i]` (start a new subarray with the current element).
   
   Subtask 3: Update `max_sum` whenever `current_sum` exceeds it.
   
   Subtask 4: After processing all elements, return `max_sum` as the result.
*/
  
/* 
   SUBTASKS OF CONVERSIONAL SOLUTION INTO CODE:

   1. Initialize `current_sum` and `max_sum` variables.
   2. Loop through the array using a regular for loop.
   3. For each element, update `current_sum`.
   4. Compare `current_sum` with `max_sum` and update if needed.
   5. After the loop ends, return `max_sum`.
*/
  
/* 
   JAVA CODE ACCORDING TO CONVERSATIONAL SUBTASKS:
*/

import java.util.*;

public class MaximumSumSubarray {

    // Function to find the maximum sum of a contiguous subarray
    public static int maxSubArraySum(int[] arr) {
        // Subtask 1: Initialize current_sum and max_sum
        int current_sum = arr[0];
        int max_sum = arr[0];

        // Subtask 2: Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Subtask 3: Update current_sum
            current_sum = Math.max(arr[i], current_sum + arr[i]);

            // Subtask 4: Update max_sum if current_sum is greater
            max_sum = Math.max(max_sum, current_sum);
        }

        // Subtask 5: Return the max_sum found
        return max_sum;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {2, 3, -8, 7, -1, 2, 3};
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(arr1));  // Output: 11

        int[] arr2 = {-2, -4};
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(arr2));  // Output: -2

        int[] arr3 = {5, 4, 1, 7, 8};
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(arr3));  // Output: 25
    }
}

/* 
   TIME AND SPACE COMPLEXITY EXPLANATION:

   Time Complexity: O(n)
   - The algorithm traverses the array exactly once, where n is the number of elements in the array.

   Space Complexity: O(1)
   - The algorithm uses only a constant amount of extra space for the variables `current_sum` and `max_sum`.

   Therefore, the solution is efficient in terms of both time and space.
*/
  
/* 
 "FOR" LOOP WALKTHROUGH ALL WITH EVERY ITERATION WITH GIVEN INPUT:

   Let's walk through the `for` loop with the input array arr[] = {2, 3, -8, 7, -1, 2, 3}:

   - Initial values: 
     - `current_sum = 2` (the first element)
     - `max_sum = 2`
   
   First iteration (i = 1):
   - `current_sum = Math.max(3, 2 + 3) = 5`
   - `max_sum = Math.max(2, 5) = 5`
   
   Second iteration (i = 2):
   - `current_sum = Math.max(-8, 5 + (-8)) = -3`
   - `max_sum = Math.max(5, -3) = 5`
   
   Third iteration (i = 3):
   - `current_sum = Math.max(7, -3 + 7) = 7`
   - `max_sum = Math.max(5, 7) = 7`
   
   Fourth iteration (i = 4):
   - `current_sum = Math.max(-1, 7 + (-1)) = 6`
   - `max_sum = Math.max(7, 6) = 7`
   
   Fifth iteration (i = 5):
   - `current_sum = Math.max(2, 6 + 2) = 8`
   - `max_sum = Math.max(7, 8) = 8`
   
   Sixth iteration (i = 6):
   - `current_sum = Math.max(3, 8 + 3) = 11`
   - `max_sum = Math.max(8, 11) = 11`

   After all iterations, the maximum subarray sum is 11. 



