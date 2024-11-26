/* 
Question:
Find out the maximum sub-array of non-negative numbers from an array.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:
a = [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3].

NOTE: If there is a tie, then compare with segment's length and return the segment which has the maximum length.
If there is still a tie, then return the segment with minimum starting index.
If no such subarray is present return "-1".

Examples:

Input:
n = 3
a[] = {1, 2, 3}
Output: 1 2 3
Explanation: In the given array every element is non-negative.
Input:
n = 2
a[] = {-1, 2}
Output: 2
Explanation: The only subarray [2] is the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
-105 ≤ A[i] ≤ 105.
*/

/* 
Understanding the Problem Statement:
1. We are given an array of integers, and the goal is to find the contiguous subarray consisting of non-negative numbers (numbers >= 0).
2. Among all such subarrays, we need to find the one with the maximum sum. If there is a tie in the sum, 
   we pick the longer subarray, and if there is still a tie, we pick the subarray that starts at the smallest index.
3. If no non-negative subarray is found, we return "-1".

What is being asked:
- We are asked to implement a solution that finds the contiguous subarray of non-negative numbers with the highest sum, 
  considering ties in the sum and length.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An integer `n`, representing the size of the array.
   - An array `a[]` of size `n` containing integers.

2. Expected Output:
   - The output is a contiguous subarray of non-negative numbers with the maximum sum, considering length and start index in case of ties.

3. Output return type:
   - A space-separated string containing the elements of the subarray that satisfies the given conditions.
   - If no such subarray exists, return "-1".

4. Time complexity expectations:
   - The expected time complexity is O(N), where N is the number of elements in the array. 
     This is because we want to iterate through the array once to find the solution.

5. Constraints:
   - The array size `N` can go up to 100,000, meaning the solution needs to be efficient (O(N) time complexity).
   - The elements of the array can range from -100,000 to 100,000.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem is about finding the maximum subarray sum under certain constraints. 
     It is similar to the well-known "maximum subarray sum" problem 
     but with the additional constraint that only non-negative elements can be part of the subarray.

2. Destructuring:
   - We will iterate through the array and keep track of the current subarray of non-negative numbers.
   - If we encounter a negative number, we compare the sum of the current subarray with the maximum sum found so far. If the current subarray is better, 
     we update the result.
   - We also need to handle ties in sum by comparing the lengths of the subarrays and, if necessary, the starting index.

3. Conversational solution into smaller subtask:
   - Step 1: Initialize variables to keep track of the best subarray found so far.
   - Step 2: Traverse the array. For each non-negative number, extend the current subarray. For negative numbers, finalize the current subarray and reset.
   - Step 3: At each step, compare the current subarray with the best one found so far, considering sum, length, and start index.
   - Step 4: After the loop, return the best subarray found.

*/

/* 
Conversional Solution into Subtasks:
1. Initialize variables for the best subarray, current subarray sum, length, and starting index.
2. Traverse the array and process each element:
   - If the element is non-negative, extend the current subarray.
   - If the element is negative, finalize the current subarray, update the best subarray if necessary, and reset for the next subarray.
3. After processing the entire array, print the best subarray.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Initialize variables:
   - `maxSum`, `maxLength`, `maxStartIndex` for the best subarray found so far.
   - `currentSum`, `currentLength`, `currentStartIndex` for the current subarray.
2. Traverse the array, updating the variables based on whether the current element is non-negative or negative.
3. Compare subarrays and update the result as necessary.
4. After the loop, output the best subarray or `-1` if no valid subarray exists.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class MaximumSubarrayOfNonNegativeNumbers {

    // Function to find the maximum subarray of non-negative numbers
    public static String maxSubArray(int[] a, int n) {
        // Variables to track the best subarray and the current subarray
        int maxSum = Integer.MIN_VALUE, maxLength = 0, maxStartIndex = -1;
        int currentSum = 0, currentLength = 0, currentStartIndex = 0;
        
        // Traverse through the array
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                // If the current element is non-negative, include it in the current subarray
                if (currentLength == 0) {
                    currentStartIndex = i; // Set start index when a new subarray starts
                }
                currentSum += a[i];
                currentLength++;
            } else {
                // If the current element is negative, finalize the current subarray
                if (currentLength > 0) {
                    // Compare with the best subarray found so far
                    if (currentSum > maxSum || (currentSum == maxSum && currentLength > maxLength) ||
                        (currentSum == maxSum && currentLength == maxLength && currentStartIndex < maxStartIndex)) {
                        maxSum = currentSum;
                        maxLength = currentLength;
                        maxStartIndex = currentStartIndex;
                    }
                }
                // Reset the current subarray
                currentSum = 0;
                currentLength = 0;
            }
        }
        
        // Final check after the loop in case the best subarray ends at the last element
        if (currentLength > 0) {
            if (currentSum > maxSum || (currentSum == maxSum && currentLength > maxLength) ||
                (currentSum == maxSum && currentLength == maxLength && currentStartIndex < maxStartIndex)) {
                maxSum = currentSum;
                maxLength = currentLength;
                maxStartIndex = currentStartIndex;
            }
        }
        
        // If no valid subarray was found, return "-1"
        if (maxStartIndex == -1) {
            return "-1";
        }
        
        // Return the best subarray as a space-separated string
        StringBuilder result = new StringBuilder();
        for (int i = maxStartIndex; i < maxStartIndex + maxLength; i++) {
            result.append(a[i]).append(" ");
        }
        return result.toString().trim();
    }

    // Main function to test the maxSubArray function
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 5, -7, 2, 3};
        System.out.println(maxSubArray(arr1, arr1.length)); // Expected output: 1 2 5
        
        // Test Case 2
        int[] arr2 = {1, 2, 3};
        System.out.println(maxSubArray(arr2, arr2.length)); // Expected output: 1 2 3
        
        // Test Case 3
        int[] arr3 = {-1, 2};
        System.out.println(maxSubArray(arr3, arr3.length)); // Expected output: 2
        
        // Test Case 4
        int[] arr4 = {-1, -2, -3};
        System.out.println(maxSubArray(arr4, arr4.length)); // Expected output: -1
    }
}

/* 
Time and Space Complexity Explanation:
1. Time Complexity:
   - The time complexity is O(N) because we are iterating over the array once, processing each element in constant time.
   
2. Space Complexity:
   - The space complexity is O(1) 
     because we are using only a few variables to store intermediate results and not using any additional data structures that grow with the input size.

*/

/* 
For loop walkthrough:
- In the `maxSubArray()` method:
   - We traverse the array once using a `for` loop.
   - For each element, we check if it's non-negative. If it is, we extend the current subarray.
   - If it's negative, we compare the current subarray with the best one found so far and reset the current subarray.
   
The loop processes each element and performs constant-time checks and updates.

*/

/* 
Complete code walkthrough:
- For input `{1, 2, 5, -7, 2, 3}`:
   1. Start with the first non-negative number, 1, extending the subarray to `[1, 2, 5]`.
   2. When encountering `-7`, finalize the subarray `[1, 2, 5]` and reset.
   3. The next subarray starts with `2` and ends at `3`, and its sum is less than `[1, 2, 5]`, so the best subarray remains `[1, 2, 5]`.
   4. Output: `1 2 5`.
*/
