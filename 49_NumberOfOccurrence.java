/* 
Question:
Given a sorted array arr[] and a number target, you need to find the number of occurrences of target in arr[].

Examples:

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.

Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.

Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
1 ≤ target ≤ 10^6
*/

/* 
Understanding the Problem Statement:
- We are given a sorted array of integers `arr[]` and a number `target`.
- We need to find how many times the `target` appears in the array `arr[]`.
- Since the array is sorted, there is a faster way to count occurrences using binary search.

What is being asked:
- We are asked to find the number of occurrences of `target` in `arr[]` in an efficient manner.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - `arr[]`: A sorted array of integers.
   - `target`: An integer whose occurrences in the array need to be counted.

2. Expected Output:
   - The number of occurrences of the `target` in the array `arr[]`.

3. Output return type:
   - Integer representing the count of occurrences of the `target`.

4. Time complexity expectations:
   - The array is sorted, so we can use binary search to find the range of `target` in O(log n) time, 
     making the solution more efficient than linear search (which would take O(n) time).

5. Constraints:
   - The array size can go up to 10^6, so a solution with a time complexity of O(n) might be too slow.
   - The values in the array are distinct and sorted, making it suitable for binary search.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - We need to count the occurrences of `target` in a sorted array `arr[]`.
   - A linear search approach would work, but we can optimize it by using binary search because the array is sorted.

2. Destructuring:
   - Since the array is sorted, we can efficiently find the first and last occurrence of the `target` using binary search.
   - The total count of `target` can be determined by the difference in indices between the first and last occurrences (inclusive).

3. Conversational solution into smaller subtask:
   - Subtask 1: Find the first occurrence of `target` using binary search.
   - Subtask 2: Find the last occurrence of `target` using binary search.
   - Subtask 3: Calculate the number of occurrences as the difference between the indices of the first and last occurrences.

*/

/* 
Conversional Solution into Subtasks:
1. Use binary search to find the first occurrence of `target`.
2. Use binary search to find the last occurrence of `target`.
3. Calculate the count by subtracting the indices of the first and last occurrence, and add 1 (to include both occurrences).

*/

/* 
Subtasks of Conversional Solution into Code:
1. Implement a helper function for binary search to find the first occurrence.
2. Implement a helper function for binary search to find the last occurrence.
3. Implement a function to calculate the total count of occurrences by subtracting the first and last occurrence indices.

*/

/* 
Java Code according to conversational subtasks.
*/

public class TargetOccurrences {

    // Helper function to find the first occurrence of the target
    public static int binarySearchFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching on the left side for the first occurrence
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Helper function to find the last occurrence of the target
    public static int binarySearchLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching on the right side for the last occurrence
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Function to count the occurrences of target in arr[]
    public static int countOccurrences(int[] arr, int target) {
        int first = binarySearchFirst(arr, target);
        if (first == -1) return 0; // target is not found

        int last = binarySearchLast(arr, target);

        return last - first + 1; // Count is the difference between last and first indices plus 1
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 1, 2, 2, 2, 2, 3};
        int target1 = 2;
        System.out.println(countOccurrences(arr1, target1));  // Expected output: 4

        // Test case 2
        int[] arr2 = {1, 1, 2, 2, 2, 2, 3};
        int target2 = 4;
        System.out.println(countOccurrences(arr2, target2));  // Expected output: 0

        // Test case 3
        int[] arr3 = {8, 9, 10, 12, 12, 12};
        int target3 = 12;
        System.out.println(countOccurrences(arr3, target3));  // Expected output: 3
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - The binary search for the first occurrence takes O(log n) time.
  - The binary search for the last occurrence also takes O(log n) time.
  - The total time complexity is O(log n), where `n` is the size of the array.

- Space Complexity:
  - The space complexity is O(1) because the algorithm uses a constant amount of space, only storing a few variables.

*/

/* 
We used two binary search loops:
1. The first binary search loop (`binarySearchFirst`) finds the first occurrence of `target`. It runs in O(log n) time, and the logic is:
   - Compare `arr[mid]` with `target`.
   - If equal, move left to find the first occurrence.
   - Continue until the first occurrence is found.

2. The second binary search loop (`binarySearchLast`) finds the last occurrence of `target`. It runs in O(log n) time as well:
   - Compare `arr[mid]` with `target`.
   - If equal, move right to find the last occurrence.
   - Continue until the last occurrence is found.

For input:
arr = [1, 1, 2, 2, 2, 2, 3], target = 2

1. First binary search finds the first occurrence of 2 at index 2.
2. Second binary search finds the last occurrence of 2 at index 5.

So, the total count of 2 is `5 - 2 + 1 = 4`.
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input:
arr = [1, 1, 2, 2, 2, 2, 3], target = 2

1. The first binary search finds the first occurrence of target `2` at index 2.
2. The second binary search finds the last occurrence of target `2` at index 5.
3. Therefore, the total count of `2` is `5 - 2 + 1 = 4`.

The output is 4.
*/

