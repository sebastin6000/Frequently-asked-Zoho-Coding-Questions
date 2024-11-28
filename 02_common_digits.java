// https://www.geeksforgeeks.org/problems/make-a-distinct-digit-array2007/1
/* 
Question:
Given an array nums of positive integers of size N, find all distinct digits present in the numbers of the array.
You need to return the list of distinct digits present in the array sorted in ascending order.

Example 1:
Input: nums = [131, 11, 48]
Output: 1 3 4 8
Explanation: 1, 3, 4, and 8 are the distinct digits that can be extracted from the numbers.

Example 2:
Input: nums = [111, 222, 333, 4444, 666]
Output: 1 2 3 4 6
Explanation: 1, 2, 3, 4, and 6 are the distinct digits that can be extracted from the numbers.

Your Task: 
You need to complete the function common_digits() 
that takes nums as input parameter and returns a list of digits which can be extracted from the given array in ascending order.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
1 <= N <= 10^5
1 <= nums[i] <= 10^9
*/

/* 
Understanding the Problem Statement:
We are given an array of positive integers. We need to extract all distinct digits from these integers and return them in ascending order.
We are required to complete the function common_digits() to solve this problem.
This function should process the array and return a list of distinct digits, ensuring no duplicates, sorted in ascending order.

Extracting Information from the Problem Statement:
- Input: An array `nums` of integers.
- Expected Output: A sorted list of distinct digits that appear in any of the integers of the array.
- The digits should be in ascending order.
- Time Complexity Expectation: O(N), where N is the size of the array.
- Space Complexity Expectation: O(N), for storing the distinct digits.
- Constraints:
   1 <= N <= 10^5: (10 x 10 x 10 x 10 x 10 = 100,000)
     This means the array nums can have up to 100,000 elements. 
     The size of the array can be quite large, so the algorithm must be efficient enough to handle the upper limit of 100,000 numbers.

   1 <= nums[i] <= 10^9: (10 × 10 × 10 × 10 × 10 × 10 × 10 × 10 × 10 = 1,000,000,000)
      Each integer in the array nums can be as large as 1 billion (10^9). 
      This means that each number can have at most 9 digits (since 10^9 has 9 digits).
  
Thinking Solution for the Problem Statement:
The task is to process the array, extract digits, remove duplicates, and return them sorted.
1. Input to output conversion in the question:
In input they have array inside the array they stored positive integers 
In that array Every integer is 2 digit integer or 3 digit integer. 
What they have done is They have extracted every single integer from the 2 digit integer or 3 digit integer.
And then they have only give the unique elements from all the extracted digits from the 2 digit integer or 3 digit integer.
       
2. So, How we are going to achieve this:
   - we also have to extract all the individual digits from the 2 digit integer and 3 digit integer.
   - Then we have to return only the unique elements from the 
2. Identify the task: The task is to extract distinct digits from an array of numbers.
3. We need to extract digits from each number in the array.
4. We will use a set to collect all the digits because a set automatically ensures no duplicates.
5. After collecting all digits, we can convert the set into a list, sort it, and return it.
6. This approach should be optimal because:
   - We only iterate through the numbers once to extract digits, making it O(N).
   - The set ensures no duplicates.
   - Sorting the digits (which are at most 10) is constant in terms of time complexity.

Input to Output conversion Subtasks into Code:
- Extracting digits: For each number in the array, split it into digits.
- Ensuring uniqueness: Use a set to avoid duplicates.
- Sorting the result: Convert the set to a list and sort it in ascending order.
- Returning the result: Return the sorted list of digits.

*/
import java.util.*;

public class StringTransformation {

    // Function to extract all distinct digits from the given array nums
    public static List<Integer> common_digits(int[] nums) {
        // Set to store unique digits
        Set<Integer> digitSet = new HashSet<>();
        
        // Iterate through each number in the array
        for (int num : nums) {
            while (num > 0) {
                // Extract the last digit
                int digit = num % 10;
                // Add it to the set
                digitSet.add(digit);
                // Remove the last digit
                num /= 10;
            }
        }
        
        // Convert the set to a list and sort it
        List<Integer> sortedDigits = new ArrayList<>(digitSet);
        Collections.sort(sortedDigits);
        
        return sortedDigits;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {131, 11, 48};
        List<Integer> result1 = common_digits(nums1);
        System.out.println(result1); // Expected Output: [1, 3, 4, 8]

        // Test Case 2
        int[] nums2 = {111, 222, 333, 4444, 666};
        List<Integer> result2 = common_digits(nums2);
        System.out.println(result2); // Expected Output: [1, 2, 3, 4, 6]
    }
}

/*
Time and Space Complexity Explanation:
- Time Complexity: O(N), where N is the size of the array `nums`.
  - Iterating through each number in the array takes O(N).
  - Extracting digits from each number takes O(log(num)) for each number, 
    but this is bounded by a constant factor since the maximum number of digits any number can have is 9 (since 10^9 has 9 digits).
  - Sorting the digits in the set takes O(1) time, as there are at most 10 digits (0-9).
  
- Space Complexity: O(N) for storing the unique digits in the set and the final sorted list.

Complete Code Walkthrough:
- We start by iterating through the input array `nums`.
- For each number, we extract its digits by repeatedly taking the remainder when divided by 10 (i.e., `num % 10`) and adding the digit to the set.
- After processing all the numbers, the set contains all unique digits.
- We convert the set to a list, sort it, and return the sorted list as the final result.
*/ 
