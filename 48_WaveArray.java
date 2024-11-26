/* 
Question:
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array (in place).
In other words, arrange the elements into a sequence such that:
arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
If there are multiple solutions, find the lexicographically smallest one.

Note: The given array is sorted in ascending order, and you don't need to return anything to change the original array.

Examples:

Input: arr[] = [1, 2, 3, 4, 5]
Output: [2, 1, 4, 3, 5]
Explanation: Array elements after sorting it in the waveform are 2, 1, 4, 3, 5.

Input: arr[] = [2, 4, 7, 8, 9, 10]
Output: [4, 2, 8, 7, 10, 9]
Explanation: Array elements after sorting it in the waveform are 4, 2, 8, 7, 10, 9.

Input: arr[] = [1]
Output: [1]

Constraints:
1 ≤ arr.size ≤ 10^6
0 ≤ arr[i] ≤ 10^7
*/

/* 
Understanding the Problem Statement:
- We are given a sorted array of distinct integers.
- Our task is to rearrange the elements in a "wave-like" manner, where:
  - arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5] ...
- We need to ensure that the rearrangement is done in place (i.e., we modify the original array directly).
- If there are multiple possible waveforms, we need to return the lexicographically smallest one.
- A sorted array is already provided, so the main task is about finding a rearrangement that satisfies the wave condition.

What is being asked:
- We need to reorder the elements in the array so that the "wave-like" pattern is satisfied. The pattern is:
  - For every even index `i`, arr[i] >= arr[i+1]
  - For every odd index `i`, arr[i] <= arr[i+1]

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An array of distinct integers, `arr[]`.

2. Expected Output:
   - The same array `arr[]` rearranged into a "wave-like" sequence.

3. Output return type:
   - No explicit return since the task modifies the input array in place.

4. Time complexity expectations:
   - The time complexity should be O(n), where `n` is the number of elements in the array, since the rearrangement must be done in-place and efficiently.
   - We must avoid using extra space and work directly on the array.

5. Constraints:
   - The number of elements in the array is between 1 and 10^6.
   - The elements themselves are distinct integers ranging from 0 to 10^7.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - The problem is asking us to rearrange the array into a wave-like pattern.
   - A wave-like sequence alternates between increasing and decreasing values:
     - arr[0] >= arr[1] <= arr[2] >= arr[3]...
   - The array is already sorted in ascending order, so we just need to swap adjacent elements in pairs.

2. Destructuring:
   - We can achieve this pattern by swapping every pair of adjacent elements.
   - Specifically, for every even index `i`, we want to swap the element at index `i` with the element at index `i+1`. This guarantees that:
     - arr[0] >= arr[1], arr[2] >= arr[3], arr[4] >= arr[5], etc.
   - By swapping adjacent elements in this way, we ensure that the elements follow the required wave pattern.

3. Conversational solution into smaller subtask:
   - Subtask 1: Iterate through the array, swapping every pair of adjacent elements.
   - Subtask 2: Handle the edge case when the array has an odd number of elements, ensuring the last element remains in place.

*/

/* 
Conversional Solution into Subtasks:
1. Traverse the array in steps of 2, starting from index 0.
2. For each even index `i`, swap `arr[i]` and `arr[i+1]`.
3. If the array has an odd number of elements, the last element will automatically satisfy the wave condition without modification.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Traverse the array and swap adjacent elements, starting from the first element.
2. If the array has an odd number of elements, leave the last element as it is.

*/

/* 
Java Code according to conversational subtasks.
*/

public class WaveArray {

    // Function to convert the given sorted array into a wave-like array
    public static void convertToWave(int[] arr) {
        int n = arr.length;

        // Iterate through the array in steps of 2
        for (int i = 0; i < n - 1; i += 2) {
            // Swap arr[i] and arr[i+1]
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        convertToWave(arr1);
        System.out.println(java.util.Arrays.toString(arr1));  // Expected output: [2, 1, 4, 3, 5]

        // Test case 2
        int[] arr2 = {2, 4, 7, 8, 9, 10};
        convertToWave(arr2);
        System.out.println(java.util.Arrays.toString(arr2));  // Expected output: [4, 2, 8, 7, 10, 9]

        // Test case 3 (edge case with a single element)
        int[] arr3 = {1};
        convertToWave(arr3);
        System.out.println(java.util.Arrays.toString(arr3));  // Expected output: [1]
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - The time complexity is O(n), where `n` is the size of the input array. 
    This is because we loop through the array once, and in each iteration, we perform constant time operations (swapping adjacent elements).
  
- Space Complexity:
  - The space complexity is O(1) because the solution modifies the array in place without requiring any extra space for another array or data structure.

*/

/* 
“for” loop or “while” loop walkthrough with every iteration with given input.
*/

/* 
In this solution, we used a `for` loop that iterates through the array in steps of 2:
For input:
arr = [1, 2, 3, 4, 5]

- First iteration (i = 0):
  - We swap arr[0] and arr[1], resulting in arr = [2, 1, 3, 4, 5].
  
- Second iteration (i = 2):
  - We swap arr[2] and arr[3], resulting in arr = [2, 1, 4, 3, 5].

- Third iteration (i = 4):
  - No swap needed for the last element, so we stop here.

The final result is [2, 1, 4, 3, 5], which satisfies the wave condition.

*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input:
arr = [1, 2, 3, 4, 5]
1. We start with the first element arr[0] = 1 and swap it with arr[1] = 2. This results in [2, 1, 3, 4, 5].
2. Next, we swap arr[2] = 3 with arr[3] = 4. This results in [2, 1, 4, 3, 5].
3. Since the array has an odd number of elements, no swap is needed for arr[4] = 5.

Final output: [2, 1, 4, 3, 5]
*/

