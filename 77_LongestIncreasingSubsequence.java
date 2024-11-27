/* 
Question:
Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
*/

/* 
Understanding the Problem Statement:
- We need to find the length of the longest strictly increasing subsequence in an integer array.
- The subsequence does not have to be contiguous, but the numbers must be in strictly increasing order.
- The answer should give the length of this subsequence.
- The challenge is to do this in O(n log n) time complexity.

What is being asked:
- We are required to return the length of the longest strictly increasing subsequence.
- The subsequence is strictly increasing, meaning each element is greater than the previous one.
*/

/* 
Extracting Information from the Problem Statement:

2.1 Input data type:
- `nums`: an array of integers of length `n`, where 1 <= n <= 2500, and each element is between -10^4 and 10^4.

2.2 Expected Output:
- An integer representing the length of the longest strictly increasing subsequence.

2.3 Output return type:
- An integer representing the length of the longest strictly increasing subsequence.

2.4 Time Complexity Expectations:
- The problem expects an efficient solution with a time complexity of O(n log n), where n is the length of the `nums` array.

2.5 Explanation of Given Constraints:
- The array length can be as large as 2500, which necessitates an efficient solution to avoid brute force approaches.
*/

/* 
Thinking Solution for the Problem Statement:

3.1 Identification Part:
- This is a dynamic programming problem, where we need to track the longest subsequence. However, brute force would be too slow.
- We need an optimized solution that uses binary search to achieve O(n log n) time complexity.

3.2 Destructuring:
- The idea is to use dynamic programming with binary search. For each element, we try to place it in the longest increasing subsequence (LIS) so far.
- We will maintain a list where the elements represent the smallest possible element at the end of an increasing subsequence of length i.

3.3 Conversional solution into smaller subtask:
- **Subtask 1**: For each number in the array, find its position in the current longest subsequence list using binary search.
- **Subtask 2**: If the number can extend the longest subsequence, append it. 
                 If it can replace an element (to maintain the smallest possible element for subsequences of a given length), replace it.
- **Subtask 3**: At the end, the length of the list represents the length of the longest increasing subsequence.

*/

/* 
Conversional Solution into subtasks:

S.no  | Subtask Description
1     | For each element in the array, find its position in the subsequence list using binary search.
2     | Append the element if it extends the subsequence, or replace an element to maintain the smallest possible end.
3     | The length of the subsequence list will be the length of the longest increasing subsequence.

*/

/* 
Subtasks of Conversional Solution into Code:

1. Use binary search to find the position where each element should be placed in the subsequence list.
2. Maintain a list to track the current smallest elements at the end of subsequences of each length.
3. At the end of the iteration, the length of this list gives the length of the longest increasing subsequence.
*/

/* 
Java Code according to conversational subtasks:
*/

import java.util.*;

public class LongestIncreasingSubsequence {
    
    // Function to return the length of the longest increasing subsequence
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        // Subtask 1, 2, 3: Binary search and maintaining the subsequence list
        List<Integer> lis = new ArrayList<>();
        
        for (int num : nums) {
            // Find the position where the current number can be placed using binary search
            int index = binarySearch(lis, num);
            
            // If the number can be placed at the end of the list (extending the subsequence)
            if (index == lis.size()) {
                lis.add(num);
            } else {
                // If the number replaces an element to maintain the smallest possible element at that length
                lis.set(index, num);
            }
        }
        
        // The length of the list is the length of the longest increasing subsequence
        return lis.size();
    }
    
    // Helper function to perform binary search
    private static int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) == target) return mid;
            else if (lis.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return left; // Return the insertion point for the target
    }
    
    public static void main(String[] args) {
        // Test case examples
        int[] nums1 = {10,9,2,5,3,7,101,18};
        int[] nums2 = {0,1,0,3,2,3};
        int[] nums3 = {7,7,7,7,7,7,7};
        
        System.out.println(lengthOfLIS(nums1)); // Output: 4
        System.out.println(lengthOfLIS(nums2)); // Output: 4
        System.out.println(lengthOfLIS(nums3)); // Output: 1
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- The binary search takes O(log n) time for each element.
- We iterate over each element of the array, so the total time complexity is O(n log n).

Space Complexity:
- The space complexity is O(n) because we are maintaining a list (`lis`) to store the subsequence.

*/

/* 
If used any “for” loop or “while” loop, you have walkthrough all the “for” loop used in the code:

1. The first loop (`for (int num : nums)`) iterates through the array `nums`, and for each element, we use binary search to find its position in the `lis` list.
2. The second loop (`while (left <= right)`) is used in the binary search to find the correct position for the current element in the `lis` list.

Example walkthrough with input nums = [10,9,2,5,3,7,101,18]:

1. First, we start with an empty list: `lis = []`.
2. Process `10`: It's placed at the end. `lis = [10]`.
3. Process `9`: Replaces `10` in `lis`. `lis = [9]`.
4. Process `2`: Replaces `9` in `lis`. `lis = [2]`.
5. Process `5`: It's placed after `2`. `lis = [2, 5]`.
6. Process `3`: Replaces `5` in `lis`. `lis = [2, 3]`.
7. Process `7`: It's placed after `3`. `lis = [2, 3, 7]`.
8. Process `101`: It's placed after `7`. `lis = [2, 3, 7, 101]`.
9. Process `18`: Replaces `101` in `lis`. `lis = [2, 3, 7, 18]`.

At the end, the length of `lis` is 4, which is the length of the longest increasing subsequence.

*/

