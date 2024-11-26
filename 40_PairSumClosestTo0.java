/* 
Question:
Given an integer array of N elements. You need to find the maximum sum of two elements such that the sum is closest to zero.

Example 1:
Input: 
N = 3
arr[] = {-8, -66, -60}
Output: -68
Explanation: The sum of two elements closest to zero is -68 using numbers -60 and -8.

Example 2:
Input: 
N = 6
arr[] = {-21, -67, -37, -18, 4, -65}
Output: -14
Explanation: The sum of two elements closest to zero is -14 using numbers -18 and 4.

Note: In case there are two or more ways to form the sum of two elements closest to zero, return the maximum sum.

*/

/* 
Understanding the Problem Statement:
- We are given an array of integers, and we need to find the maximum sum of any two distinct elements such that the sum is closest to zero.
- If there are multiple pairs with the same sum closest to zero, return the maximum sum.

What is being asked:
- We are asked to return the sum of two elements from the array that are closest to zero. In case of ties, return the maximum of those sums.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An integer array `arr[]` of length `N` where `2 ≤ N ≤ 5 * 10^5`.
2. Expected Output:
   - The maximum sum closest to zero that can be formed by summing any two elements in the array.
3. Output return type:
   - The result is an integer representing the maximum sum closest to zero.
4. Time complexity expectations:
   - The time complexity should ideally be O(N log N) or better.
5. Constraints:
   - The array has at least two elements (`N ≥ 2`).
   - Each element in the array is between `-10^6` and `10^6` inclusive.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - We are looking for two elements whose sum is closest to zero.
   - The sum closest to zero could be from:
     - Two negative numbers (their sum is negative but could be closest to zero).
     - One negative number and one positive number.
     - Two positive numbers (their sum will always be positive).

2. Destructuring:
   - If we sort the array, the two elements that sum closest to zero will be near each other, because:
     - Negative and positive numbers will have a smaller sum when combined with numbers close to zero.
     - Sorting helps us to efficiently compare pairs.

3. Conversional solution into smaller subtask:
   - Subtask 1: Sort the array.
   - Subtask 2: Use a two-pointer approach to find the pair with the sum closest to zero.
   - Subtask 3: If multiple pairs have the same sum, return the maximum sum.
   - Subtask 4: Return the result.

*/

/* 
Conversional Solution into Subtasks:
1. Sort the array.
2. Use a two-pointer approach:
   - One pointer at the start (left) and one at the end (right).
   - Compute the sum of the elements at the left and right pointers.
   - If the sum is closer to zero than the current closest sum, update the closest sum.
   - If the sum is less than zero, move the left pointer to the right (to increase the sum).
   - If the sum is greater than zero, move the right pointer to the left (to decrease the sum).
3. Return the maximum sum closest to zero.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Sort the array in ascending order.
2. Use a two-pointer technique to find the pair with the closest sum to zero.
3. Compare the sum and update the closest sum if necessary.
4. Return the closest sum.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.Arrays;

public class MaximumSumClosestToZero {
    
    // Function to find the maximum sum closest to zero
    public static int closestToZero(int[] arr, int n) {
        // Subtask 1: Sort the array in ascending order
        Arrays.sort(arr);
        
        // Subtask 2: Initialize two pointers
        int left = 0;
        int right = n - 1;
        
        // Variable to store the closest sum to zero
        int closestSum = Integer.MAX_VALUE;
        
        // Subtask 3: Two-pointer approach to find the sum closest to zero
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            // If this sum is closer to zero, update the closestSum
            if (Math.abs(sum) < Math.abs(closestSum) || (Math.abs(sum) == Math.abs(closestSum) && sum > closestSum)) {
                closestSum = sum;
            }
            
            // If the sum is negative, move the left pointer to the right to increase the sum
            if (sum < 0) {
                left++;
            }
            // If the sum is positive, move the right pointer to the left to decrease the sum
            else {
                right--;
            }
        }
        
        // Subtask 4: Return the closest sum
        return closestSum;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {-8, -66, -60};
        int n1 = arr1.length;
        System.out.println(closestToZero(arr1, n1)); // Expected output: -68
        
        // Test case 2
        int[] arr2 = {-21, -67, -37, -18, 4, -65};
        int n2 = arr2.length;
        System.out.println(closestToZero(arr2, n2)); // Expected output: -14
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Sorting the array takes O(N log N), where N is the number of elements in the array.
  - The two-pointer technique takes O(N) because we traverse the array only once.
  - Thus, the overall time complexity is O(N log N) due to the sorting step.
  
- Space Complexity:
  - The space complexity is O(1) as we are only using a few extra variables to store intermediate results.
  - We do not use any additional space except for the input array.

*/

/* 
“while” loop walkthrough with every iteration with given input.
*/

/* 
The code uses a `while` loop to implement the two-pointer technique:
- The loop continues as long as `left < right`, meaning we are checking pairs of elements from the two ends of the array.
- We calculate the sum of the elements at `arr[left]` and `arr[right]` and update the closest sum accordingly.
- Based on the value of the sum, we either increment `left` or decrement `right` to move toward a sum that is closer to zero.

For example, for the input `arr = {-21, -67, -37, -18, 4, -65}`, after sorting, the array is:
`arr = {-67, -65, -37, -21, -18, 4}`.
- The initial left pointer is at `arr[0] = -67` and the right pointer is at `arr[5] = 4`.
- The sum is `-67 + 4 = -63`. This is the closest sum to zero so far, so we update `closestSum = -63`.
- Then, we move the left pointer to `arr[1] = -65` and check again.

*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input `arr1 = {-8, -66, -60}`:
1. The array is sorted: `[-66, -60, -8]`.
2. The sum of `-66 + -8 = -74`. This is closest to zero so far.
3. Next, the sum of `-60 + -8 = -68` is closer to zero, so we update `closestSum = -68`.
4. The maximum sum closest to zero is `-68`, so the output is `-68`.

For input `arr2 = {-21, -67, -37, -18, 4, -65}`:
1. The array is sorted: `[-67, -65, -37, -21, -18, 4]`.
2. The sum of `-67 + 4 = -63`. This is closest to zero so far.
3. Then, the sum of `-65 + 4 = -61` is closer to zero, but we keep `-63` as it is closer.
4. Finally, the sum of `-18 + 4 = -14` is closer to zero than any other sum.
5. The output is `-14`.
*/
