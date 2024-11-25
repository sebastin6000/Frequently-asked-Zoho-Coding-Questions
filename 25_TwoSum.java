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
The problem requires determining if there are two distinct elements in the array arr that sum up to the given target value. 
If such a pair exists, return true, else return false.
We are expected to solve the problem with an optimal time complexity of O(n) and space complexity of O(n).

*/

/* 
Extracting Information from the Problem Statement:

2.1- Input data type:
- An array of positive integers, arr[].
- A positive integer target.

2.2- Expected Output: 
- A boolean value: true if two distinct elements exist whose sum is equal to the target, otherwise false.

2.3- Output return type:
- boolean (true or false)

2.4- Explanation of Time complexity expectations:
- The expected time complexity is O(n), which means that we need to solve this problem in linear time.

2.5- Explanation of given Constraints:
- The array size can be as large as 100,000, which means the solution should be efficient (linear time complexity).
- Array elements are positive integers and can be as large as 100,000.

*/

/* 
Thinking Solution for the Problem Statement:
The task is to find two elements in the array whose sum equals the target. We need to solve this efficiently in O(n) time and O(n) space.

To do this:
- We can use a HashSet to store the elements we've seen so far.
- For each element `x` in the array, check if `target - x` is already in the HashSet.
  - If yes, return true, because `x` and `target - x` form a valid pair.
  - If no, add `x` to the HashSet and continue checking the next elements.
- If we go through the entire array and find no such pair, return false.

*/

/* 
Conversional Solution into subtasks:

Subtask 1: Initialize an empty HashSet to store elements we have visited so far.
Subtask 2: Loop through each element in the array.
Subtask 3: For each element `x`, check if `target - x` is already in the HashSet.
    - If true, return true because we've found the pair.
Subtask 4: If not found, add `x` to the HashSet and move to the next element.
Subtask 5: If no pair is found after looping through the entire array, return false.

*/

/* 
Subtasks of Conversional Solution into Code:

1. Initialize a HashSet to keep track of elements visited so far.
2. Iterate over the array and for each element:
    - Check if the difference between target and the current element exists in the HashSet.
    - If found, return true.
3. Add the current element to the HashSet.
4. If no pair is found after the loop, return false.

*/

import java.util.HashSet;

public class TwoSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        // Create a HashSet to store the elements we have already visited.
        HashSet<Integer> seen = new HashSet<>();
        
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Calculate the required pair complement
            int complement = target - arr[i];
            
            // If the complement is already in the HashSet, we have found the pair
            if (seen.contains(complement)) {
                return true;
            }
            
            // Otherwise, add the current element to the HashSet
            seen.add(arr[i]);
        }
        
        // If no pair is found, return false
        return false;
    }

    public static void main(String[] args) {
        // Test the code with sample input
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        int target1 = 16;
        System.out.println(hasPairWithSum(arr1, target1)); // Expected Output: true
        
        int[] arr2 = {1, 2, 4, 3, 6};
        int target2 = 11;
        System.out.println(hasPairWithSum(arr2, target2)); // Expected Output: false
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- We loop through the array once, which takes O(n) time.
- For each element, checking whether its complement exists in the HashSet and adding the element to the HashSet both take constant time O(1).
- Thus, the overall time complexity is O(n), where n is the size of the array.

Space Complexity:
- The space complexity is determined by the HashSet that we use to store the elements we've seen. In the worst case, 
   we may store all n elements in the HashSet, so the space complexity is O(n).

*/

/* 
If used any “for” loop or “while” loop, you have walkthrough all the “for” loop used in the code with every iteration with the given input:

For the input arr = [1, 4, 45, 6, 10, 8] and target = 16:

1st iteration (i=0):
- Current element = 1
- Complement = target - current element = 16 - 1 = 15
- HashSet is empty, so we add 1 to the HashSet.
- HashSet: {1}

2nd iteration (i=1):
- Current element = 4
- Complement = 16 - 4 = 12
- HashSet does not contain 12, so we add 4 to the HashSet.
- HashSet: {1, 4}

3rd iteration (i=2):
- Current element = 45
- Complement = 16 - 45 = -29
- HashSet does not contain -29, so we add 45 to the HashSet.
- HashSet: {1, 4, 45}

4th iteration (i=3):
- Current element = 6
- Complement = 16 - 6 = 10
- HashSet does not contain 10, so we add 6 to the HashSet.
- HashSet: {1, 4, 45, 6}

5th iteration (i=4):
- Current element = 10
- Complement = 16 - 10 = 6
- HashSet contains 6, so we return true (found a pair).

*/

