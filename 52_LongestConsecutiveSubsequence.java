/* 
Question:
Given an array arr of non-negative integers, find the length of the longest subsequence such that elements in the subsequence are consecutive integers. 
The consecutive numbers can be in any order.

Examples:
1. Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
   Output: 6
   Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsequence.

2. Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
   Output: 4
   Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.

3. Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
   Output: 7
   Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.

Constraints:
1 <= arr.size() <= 10^5
0 <= arr[i] <= 10^5
*/

/* 
Understanding the Problem Statement:
- We are given an array of non-negative integers.
- We need to find the length of the longest subsequence where the elements are consecutive integers, but they do not need to be in any specific order.
- A subsequence is a sequence derived from the array by deleting some or no elements without changing the order of the remaining elements.
- The consecutive integers should form the longest possible subsequence.

What is being asked:
- The goal is to find the length of the longest subsequence of consecutive integers. 
- We are not concerned with the order of the elements in the subsequence; only that they form a sequence of consecutive numbers.
*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is an array `arr[]` of non-negative integers.

2. Expected Output:
   - The length of the longest subsequence of consecutive integers.

3. Output return type:
   - An integer representing the length of the longest subsequence.

4. Time complexity expectations:
   - The problem specifies that the array size can be up to 10^5, so an efficient solution should run in O(n) time, where `n` is the size of the array.

5. Constraints:
   - The array can contain up to 100,000 elements, so a brute-force solution may not work efficiently within the given constraints.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - The problem asks for finding consecutive numbers in any order, so a simple sorting approach would not be the most efficient.
   - We need to check for the longest sequence of consecutive integers in an optimized way.

2. Destructuring:
   - One way to approach this is by leveraging a hash set or hash map. This allows for O(1) average time complexity for lookups, 
     making it efficient for checking consecutive numbers.
   - For each element, we can check if it can start a sequence (i.e., if `element - 1` is not present).
   - We can then expand the sequence by checking for `element + 1`, `element + 2`, etc., until we reach the end of the consecutive sequence.
   
3. Conversational solution into smaller subtask:
   - Subtask 1: Create a set to store all the unique elements in the array.
   - Subtask 2: For each element, check if it's the beginning of a sequence by checking if `element - 1` is not in the set.
   - Subtask 3: If it is the start of a sequence, count the length of the sequence by checking consecutive numbers.
   - Subtask 4: Track the maximum length of any sequence encountered.

*/

/* 
Conversional Solution into Subtasks:
1. Insert all elements into a hash set for fast lookups.
2. Iterate through each element in the array, checking if it can start a sequence.
3. If it can, count the consecutive elements.
4. Return the length of the longest sequence.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Insert all elements into a hash set.
2. Iterate through the array, and for each element, check if it is the start of a sequence (i.e., `element - 1` is not present).
3. If it's the start of a sequence, find the length of the sequence by checking consecutive elements.
4. Track the longest sequence length.
5. Return the longest sequence length.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class LongestConsecutiveSubsequence {

    // Function to find the length of the longest subsequence of consecutive integers
    public static int longestConsecutive(int[] arr) {
        // Create a set to store the unique elements
        Set<Integer> numsSet = new HashSet<>();
        
        // Add all elements to the set
        for (int num : arr) {
            numsSet.add(num);
        }
        
        int longestStreak = 0;
        
        // Iterate through each element in the set
        for (int num : numsSet) {
            // Check if this element is the start of a sequence
            if (!numsSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                // Count the length of the sequence
                while (numsSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                // Update the longest streak if the current streak is longer
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(arr1));  // Expected output: 6

        // Test case 2
        int[] arr2 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(longestConsecutive(arr2));  // Expected output: 4

        // Test case 3
        int[] arr3 = {15, 13, 12, 14, 11, 10, 9};
        System.out.println(longestConsecutive(arr3));  // Expected output: 7
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Inserting all elements into the hash set takes O(n), where n is the number of elements in the array.
  - For each element, in the worst case, we perform one iteration over the sequence, which also takes O(n). Therefore, the overall time complexity is O(n).

- Space Complexity:
  - We use a hash set to store all unique elements in the array, so the space complexity is O(n), where n is the number of elements in the array.

*/

/* 
Explanation of loops:
1. The first `for` loop iterates over the array `arr` to insert all elements into the hash set. This operation takes O(n) time.
2. The second `for` loop iterates over each element in the set to check if it is the start of a sequence. For each such element, 
   we check if it can form a consecutive sequence by checking the presence of subsequent numbers.

Example with input arr = {2, 6, 1, 9, 4, 5, 3}:
- Initially, the set will contain: {1, 2, 3, 4, 5, 6, 9}.
- We start with 1: Check for 2, 3, 4, 5, 6. Sequence length = 6.
- We then check 9: No consecutive numbers follow, so the sequence ends here with length 1.

So, the longest consecutive subsequence is of length 6.

*/

/* 
Complete code walkthrough with applying the given input in code and explanation:

For input:
arr = {2, 6, 1, 9, 4, 5, 3}

1. Insert elements into the hash set: {1, 2, 3, 4, 5, 6, 9}
2. Iterate through the set:
   - Start with 1: It is the start of a sequence, count 1, 2, 3, 4, 5, 6. Sequence length = 6.
   - Next, check 9: It is not the start of a sequence because 8 is not present. Sequence length = 1.
3. The longest consecutive subsequence length is 6.
Output: 6
*/ 
