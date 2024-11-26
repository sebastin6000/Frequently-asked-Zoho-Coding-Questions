/* 
Question:
Given an array arr of positive integers and another number target. 
Determine whether two elements exist in arr whose sum is exactly target or not. 
Return a boolean value true if two elements exist in arr else return false.

Examples:

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16

Input: arr[] = [1, 2, 4, 3, 6], target = 11
Output: false
Explanation: None of the pair makes a sum of 11

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size ≤ 10^5
1 ≤ arr[i] ≤ 10^5
*/

/* 
Understanding the Problem Statement:
- We are given an array of positive integers and a target value.
- The goal is to determine if there are two elements in the array whose sum equals the target.
- If such a pair exists, return true; otherwise, return false.

What is being asked:
- We need to check if there exists a pair of elements whose sum is equal to the given target.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input consists of an array of positive integers `arr[]` and an integer `target`.

2. Expected Output:
   - A boolean value indicating whether there exists a pair of elements in `arr[]` whose sum equals `target`.

3. Output return type:
   - The return type is a boolean value: true if a pair exists, false if no such pair exists.

4. Time complexity expectations:
   - The expected time complexity is O(n), where n is the size of the array `arr[]`, 
     since the solution needs to process each element at most once.

5. Constraints:
   - The array can have up to 10^5 elements, so the solution must handle large arrays efficiently.
   - The elements in the array are positive integers between 1 and 10^5, so there are no negative numbers or zeros.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem can be recognized as a variant of the "two-sum" problem, which is commonly solved using hash sets.
   - We are trying to find two numbers that add up to the target.

2. Destructuring:
   - We can maintain a hash set to store the elements we've seen so far as we traverse the array.
   - For each element `arr[i]`, we check if `target - arr[i]` exists in the set. If it does, then we've found a pair that sums to the target.
   - If no pair is found by the end of the traversal, we return false.

3. Conversational solution into smaller subtask:
   - Step 1: Initialize an empty hash set.
   - Step 2: Loop through each element of the array.
   - Step 3: For each element `arr[i]`, check if `target - arr[i]` exists in the set.
   - Step 4: If a match is found, return true.
   - Step 5: If no match is found by the end of the loop, return false.

*/

/* 
Conversional Solution into Subtasks:
1. Loop through the array and check if the complement of each element (i.e., target - element) exists in the hash set.
2. If a complement exists, return true.
3. If no complement is found after the loop finishes, return false.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Initialize an empty hash set to store elements.
2. Traverse the array and for each element, check if the complement (target - element) exists in the set.
3. If a match is found, return true; otherwise, continue the loop.
4. If no pair is found by the end of the loop, return false.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.HashSet;

public class FindPairWithSum {
    
    // Function to determine if two elements whose sum equals the target exist
    public static boolean findPairWithSum(int[] arr, int target) {
        // Create a hash set to store elements we've seen
        HashSet<Integer> seen = new HashSet<>();
        
        // Traverse through each element in the array
        for (int num : arr) {
            // Check if the complement (target - num) is in the hash set
            if (seen.contains(target - num)) {
                return true; // If we find the complement, return true
            }
            // Otherwise, add the current number to the set
            seen.add(num);
        }
        
        // If no pair is found by the end, return false
        return false;
    }

    // Main function to test the code
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        int target1 = 16;
        System.out.println(findPairWithSum(arr1, target1)); // Expected output: true

        // Test case 2
        int[] arr2 = {1, 2, 4, 3, 6};
        int target2 = 11;
        System.out.println(findPairWithSum(arr2, target2)); // Expected output: false
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:
- We loop through each element of the array once, performing O(1) operations for each element (insertion and lookup in the hash set).
- Therefore, the time complexity is O(n), where n is the size of the array `arr[]`.

Space Complexity:
- We use a hash set to store the elements we have seen so far, which can contain at most n elements.
- Therefore, the space complexity is O(n), where n is the size of the array.

*/

/* 
For Loop Walkthrough:
1. The `for` loop iterates over each element `num` in the array `arr[]`.
2. For each element `num`, we check if `target - num` exists in the hash set.
   - If `target - num` is found, that means we have found a pair that sums to `target`, so we return true.
   - Otherwise, we add `num` to the hash set and continue to the next element.

Complete Code Walkthrough:
- The function `findPairWithSum()` starts by initializing an empty hash set called `seen`.
- It then loops through the array `arr[]`:
   - For each element `num`, it checks if `target - num` is already in the hash set.
   - If so, it returns true because we've found a pair of numbers that sum to the target.
   - If not, it adds `num` to the hash set.
- If the loop completes without finding a pair, the function returns false, indicating no such pair exists.

*/
