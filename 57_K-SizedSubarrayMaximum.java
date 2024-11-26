/* 
Question:
Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k. 
The output should be an array of maximum values corresponding to each contiguous subarray.

Examples:

Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
Output: [3, 3, 4, 5, 5, 5, 6] 
Explanation: 
1st contiguous subarray = [1 2 3] max = 3
2nd contiguous subarray = [2 3 1] max = 3
3rd contiguous subarray = [3 1 4] max = 4
4th contiguous subarray = [1 4 5] max = 5
5th contiguous subarray = [4 5 2] max = 5
6th contiguous subarray = [5 2 3] max = 5
7th contiguous subarray = [2 3 6] max = 6

Input: arr[] = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13], k = 4
Output: [10, 10, 10, 15, 15, 90, 90]
Explanation: 
1st contiguous subarray = [8 5 10 7], max = 10
2nd contiguous subarray = [5 10 7 9], max = 10
3rd contiguous subarray = [10 7 9 4], max = 10
4th contiguous subarray = [7 9 4 15], max = 15
5th contiguous subarray = [9 4 15 12], max = 15
6th contiguous subarray = [4 15 12 90], max = 90
7th contiguous subarray = [15 12 90 13], max = 90

Input: arr[] = [5, 1, 3, 4, 2, 6], k = 1
Output: [5, 1, 3, 4, 2, 6]
Explanation: 
When k = 1, each element in the array is its own subarray, so the output is simply the same array

Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ k ≤ arr.size()
0 ≤ arr[i] ≤ 10^9.
*/

/* 
Understanding the Problem Statement:
- We are given an array of integers, and our goal is to find the maximum value in every contiguous subarray of size `k`.
- For example, if `arr = [1, 2, 3, 1, 4, 5, 2, 3, 6]` and `k = 3`, the first contiguous subarray of size `3` is `[1, 2, 3]`, 
  and its maximum is `3`. Similarly, we need to find the maximum for every other subarray of size `k`.

What is being asked:
- We need to return an array containing the maximum value of each contiguous subarray of size `k`.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input consists of an array `arr[]` of integers, where each integer is between 0 and 10^9, 
     and an integer `k` that represents the size of the subarrays.

2. Expected Output:
   - The output should be an array of integers where each element is the maximum value from a contiguous subarray of size `k`.

3. Output return type:
   - The function should return an array of integers.

4. Time complexity expectations:
   - The solution should handle large input sizes efficiently. 
     The array size can be up to 10^6, and we need an optimized approach that avoids recalculating the maximum from scratch for every subarray.

5. Constraints:
   - The number of elements in the array can be very large (up to 10^6).
   - The size of each subarray, `k`, is always less than or equal to the size of the array.
   - Each element of the array can be as large as 10^9.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a sliding window problem where we need to compute the maximum of each sliding window of size `k` efficiently.

2. Destructuring:
   - For each subarray of size `k`, we want to find the maximum value. 
     A naive approach would be to check every subarray of size `k`, but that would be inefficient with large inputs.
   - To optimize, 
     we can use a deque (double-ended queue) to store indices of the array in such a way that the maximum of the window is always at the front of the deque.

3. Conversational solution into smaller subtask:
   - Subtask 1: Initialize an empty deque to store indices of the array.
   - Subtask 2: Iterate through the array and maintain the deque such that it always stores indices in decreasing order of their corresponding values.
   - Subtask 3: For each element, add it to the deque and ensure that elements outside the current window (of size `k`) are removed.
   - Subtask 4: The element at the front of the deque is always the maximum of the current window.
   - Subtask 5: Append the maximum for each window to the result array.

*/

/* 
Conversional Solution into Subtasks:
1. Initialize an empty deque.
2. Iterate over each element of the array:
   - Remove elements from the back of the deque if they are smaller than the current element (since they cannot be the maximum in future windows).
   - Remove elements from the front of the deque if they are out of the current window.
3. Add the current element's index to the deque.
4. For every window after the first `k-1` elements, append the element at the front of the deque to the result array.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Initialize an empty deque.
2. Iterate through the array:
   - For each element, remove elements from the deque that are smaller or out of the window.
   - Add the current element's index to the deque.
   - If the current index is greater than or equal to `k-1`, add the maximum (element at the front of the deque) to the result list.
3. Return the result array.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class MaximumOfSubarrays {

    // Function to find maximum of each contiguous subarray of size k
    public static int[] maxSlidingWindow(int[] arr, int k) {
        // Deque to store indices of array elements
        Deque<Integer> deque = new LinkedList<>();
        // Result list to store maximum of each window
        int[] result = new int[arr.length - k + 1];

        for (int i = 0; i < arr.length; i++) {
            // Remove indices of elements not in the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from the back of the deque if they are smaller than the current element
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // If we've processed at least k elements, add the max (first element of deque) to result
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k1 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr1, k1))); // Output: [3, 3, 4, 5, 5, 5, 6]

        // Test case 2
        int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k2 = 4;
        System.out.println(Arrays.toString(maxSlidingWindow(arr2, k2))); // Output: [10, 10, 10, 15, 15, 90, 90]

        // Test case 3
        int[] arr3 = {5, 1, 3, 4, 2, 6};
        int k3 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(arr3, k3))); // Output: [5, 1, 3, 4, 2, 6]
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - We process each element in the array exactly once. For each element, we either add it to the deque or remove it from the deque.
    The total time complexity is O(n), where `n` is the size of the array.
  
- Space Complexity:
  - The deque stores at most `k` elements at any given time, and the result array stores `n - k + 1` elements. 
    Therefore, the space complexity is O(n), where `n` is the size of the array.

*/

/* 
For loop walkthrough:
- The `for` loop iterates over each element in the array `arr[]`:
   1. For each element `arr[i]`, we check and remove elements from the back of the deque that are smaller than the current element.
   2. We then remove the elements that are out of the current window of size `k` from the front of the deque.
   3. We add the index of the current element to the deque.
   4. If the current index is greater than or equal to `k-1`, 
      we add the maximum value (element at the front of the deque) to the result list.

Complete code walkthrough:
- We initialize an empty deque and iterate over the array.
- For each element, we remove smaller elements from the back of the deque to maintain a decreasing order.
- We also remove any indices from the front of the deque if they are outside the current window of size `k`.
- After processing each element, we check if we've processed at least `k` elements, and if so, 
  we add the maximum of the window (deque's front element) to the result array.
*/
