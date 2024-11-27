// https://www.geeksforgeeks.org/problems/make-a-distinct-digit-array2007/1
// WITH TEMPLATE 
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
   1 <= N <= 10^5: 
     This means the array nums can have up to 100,000 elements. 
     The size of the array can be quite large, so the algorithm must be efficient enough to handle the upper limit of 100,000 numbers.

   1 <= nums[i] <= 10^9: 
      Each integer in the array nums can be as large as 1 billion (10^9). 
      This means that each number can have at most 9 digits (since 10^9 has 9 digits).
  
The task is to process the array, extract digits, remove duplicates, and return them sorted.

Thinking Solution for the Problem Statement:
1. Identify the task: The task is to extract distinct digits from an array of numbers.
2. We need to extract digits from each number in the array.
3. We will use a set to collect all the digits because a set automatically ensures no duplicates.
4. After collecting all digits, we can convert the set into a list, sort it, and return it.
5. This approach should be optimal because:
   - We only iterate through the numbers once to extract digits, making it O(N).
   - The set ensures no duplicates.
   - Sorting the digits (which are at most 10) is constant in terms of time complexity.

Conversional Solution into Subtasks:
1. Iterate through the given array.
2. For each number, extract its digits.
3. Add each digit to a set (to ensure distinct digits).
4. Convert the set of digits into a sorted list.
5. Return the sorted list of digits.

Subtasks of Conversional Solution into Code:
- **Extracting digits**: For each number in the array, split it into digits.
- **Ensuring uniqueness**: Use a set to avoid duplicates.
- **Sorting the result**: Convert the set to a list and sort it in ascending order.
- **Returning the result**: Return the sorted list of digits.

Java Code according to Conversational Subtasks:

*/
import java.util.*;

public class StringTransformation {

    // Function to extract all distinct digits from the given array nums
    public static List<Integer> common_digits(int[] nums) {
        // Set to store unique digits
        Set<Integer> digitSet = new HashSet<>();
        
        // Iterate through each number in the array
        for (int num : nums) {
            // Convert the number to string to easily access each digit
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
- **Time Complexity**: O(N), where N is the size of the array `nums`.
  - Iterating through each number in the array takes O(N).
  - Extracting digits from each number takes O(log(num)) for each number, but this is bounded by a constant factor since the maximum number of digits any number can have is 9 (since 10^9 has 9 digits).
  - Sorting the digits in the set takes O(1) time, as there are at most 10 digits (0-9).
  
- **Space Complexity**: O(N) for storing the unique digits in the set and the final sorted list.

Complete Code Walkthrough:
- We start by iterating through the input array `nums`.
- For each number, we extract its digits by repeatedly taking the remainder when divided by 10 (i.e., `num % 10`) and adding the digit to the set.
- After processing all the numbers, the set contains all unique digits.
- We convert the set to a list, sort it, and return the sorted list as the final result.
*/ 

--------------------------------------------------------------------------------------------
// WITHOUT PROBLEM SOLVING TEMPLATE
/* 
Question:

Given an array nums of positive integers of size N, find all distinct digits present in nums.

Example 1:
Input: nums = [131, 11, 48]
Output: 1 3 4 8
Explanation: 1, 3, 4, and 8 are the only distinct digits that can be extracted from the numbers of the array.

Example 2:
Input: nums = [111, 222, 333, 4444, 666]
Output: 1 2 3 4 6
Explanation: 1, 2, 3, 4, and 6 are the only distinct digits that can be extracted from the numbers of the array.

Your Task:
You need to implement a function `common_digits()` which takes nums as input parameter and returns a list of distinct digits which can be extracted from the given array in ascending order.
*/

/* 
Input-output explanation:

Input: nums = [131, 11, 48]
Output: [1, 3, 4, 8]

Explanation:
- The digits in the number 131 are 1, 3.
- The digits in the number 11 are 1.
- The digits in the number 48 are 4, 8.
- The distinct digits from all these numbers are 1, 3, 4, and 8.

Input: nums = [111, 222, 333, 4444, 666]
Output: [1, 2, 3, 4, 6]

Explanation:
- The digits in the number 111 are 1.
- The digits in the number 222 are 2.
- The digits in the number 333 are 3.
- The digits in the number 4444 are 4.
- The digits in the number 666 are 6.
- The distinct digits are 1, 2, 3, 4, and 6.
*/

/* 
Constraints explanation: 

1 <= N <= 10^5 (N is the number of elements in the array, meaning we could have up to 100,000 numbers)
1 <= nums[i] <= 10^9 (Each number can be as large as 1 billion)

This means we need an approach that works efficiently even for large arrays with numbers that have up to 9 digits each.
*/

/* 
Relatable analogy or real-world scenario: Collecting Unique Digits from Tickets

Imagine you're hosting a party and there are multiple guests.
Each guest brings a collection of numbered tickets (think of them as the numbers in the array).
You want to know which digits appear on these tickets across all guests.

For example:
- One guest might bring a ticket with the number 131.
- Another might bring a ticket with the number 11.
- Another might bring 48.

To solve this,
- you need to gather all unique digits from all the tickets,
- but you only care about each distinct digit, 
- no duplicates. So from the numbers 131, 11, and 48, you collect the digits: 1, 3, 4, and 8.
- You don’t need to count how many times each digit appears; 
- just knowing that these digits appear is enough. Finally,
- you want to list the digits in order from smallest to largest.

Steps:
1. Look at each guest’s ticket (each number).
2. Gather all the digits in that number.
3. Make sure to keep only unique digits.
4. Sort the digits in ascending order and return the result.

This approach ensures you don’t repeat any digits and gives you an efficient way to find all the distinct digits across all the tickets.
*/

/* 
Relatable analogy Java code step by step: 

Step 1: We’ll first create a set to hold the distinct digits. A set is perfect because it automatically ensures uniqueness.
Step 2: Loop through each number in the array.
Step 3: Convert each number to a string to easily extract each digit.
Step 4: For each number, add its digits to the set.
Step 5: After processing all the numbers, we’ll convert the set to a list and sort it in ascending order.
Step 6: Finally, we return the sorted list of digits.

Now let’s look at the actual code for this.
*/

import java.util.*;

public class common_digits {

    // Step 1: Function to get all distinct digits from the list of numbers.
    public static List<Integer> common_digits(int[] nums) {
        Set<Integer> digits = new HashSet<>();  // Step 2: A set to store unique digits.

        // Step 3: Loop through each number in the array using traditional for loop.
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // Step 4: Convert number to string to extract each digit.
            while (num > 0) {
                digits.add(num % 10);  // Add the last digit to the set.
                num /= 10;  // Remove the last digit from the number.
            }

            /* 
            int[] nums = {131, 11, 48}; -- input array
            For each number, the code extracts its digits one by one:

            For 131:
            131 % 10 = 1 → Adds 1 to the set.
            131 / 10 = 13
            13 % 10 = 3 → Adds 3 to the set.
            13 / 10 = 1
            1 % 10 = 1 → 1 is already in the set, so nothing changes.
            The set after processing 131 is {1, 3}.
            
            For 11:
            11 % 10 = 1 → 1 is already in the set.
            11 / 10 = 1
            1 % 10 = 1 → 1 is already in the set.
            The set remains {1, 3} after processing 11.
            
            For 48:
            48 % 10 = 8 → Adds 8 to the set.
            48 / 10 = 4
            4 % 10 = 4 → Adds 4 to the set.
            The set after processing 48 is {1, 3, 4, 8}.
            */
        }

        // Step 5: Convert the set of digits to a sorted list.
        List<Integer> result = new ArrayList<>(digits);
        Collections.sort(result);  // Sort the digits in ascending order.
        return result;
    }

    /* 
    Time and Space Complexity Explanation:

    Time Complexity:
    - Looping through each number: O(N) where N is the number of numbers in the input array.
    - Extracting digits from each number: This involves dividing the number by 10 until it becomes 0. Since each number can have at most 9 digits (because the max value is 10^9), the loop will run at most 9 times per number.
    - Sorting the set of digits: Since the set can have at most 10 unique digits (0 to 9), the sorting step takes constant time, O(10), which is effectively O(1).
    Overall, the time complexity is O(N), where N is the number of elements in the array.

    Space Complexity:
    - The space used by the set and list is O(1) because the set can store at most 10 digits (0 to 9), and the list of digits will also have at most 10 elements.
    Hence, the space complexity is O(1), which is constant, as the number of unique digits doesn’t depend on the input size.
    */

    /* 
    FOR loop walkthrough with every iteration:

    Example input: nums = [131, 11, 48]

    1. Start with an empty set: {}
    2. First number: 131
       - Digits are 1, 3.
       - Set after processing: {1, 3}.
    3. Second number: 11
       - Digits are 1 (already in set).
       - Set remains: {1, 3}.
    4. Third number: 48
       - Digits are 4, 8.
       - Set after processing: {1, 3, 4, 8}.
    5. Convert the set to a sorted list: [1, 3, 4, 8].
    6. Return the sorted list as the final output: [1, 3, 4, 8].

    The result is the distinct digits sorted in ascending order.
    */

    /* 
    Complete code walkthrough with applying the given input in code and explanation:

    Given the input nums = [131, 11, 48]:
    - We initialize a set called `digits` to hold the unique digits.
    - The first number is 131. We extract the digits 1 and 3 and add them to the set.
    - The second number is 11. We extract the digit 1, but it is already in the set, so nothing changes.
    - The third number is 48. We extract the digits 4 and 8 and add them to the set.
    - After processing all numbers, the set contains the digits {1, 3, 4, 8}.
    - We convert this set to a list and sort it to get [1, 3, 4, 8].
    - The final output is [1, 3, 4, 8].
    */

    public static void main(String[] args) {
        int[] nums = {131, 11, 48};
        List<Integer> result = common_digits(nums);
        System.out.println(result);  // Output: [1, 3, 4, 8]
    }
}
/* 
THIS CODE IS WITH THE INTERGER ARRAY RETURN TYPE 
   // created a function with correct name, return type and arguments 
    public int[] common_digits(int[] nums) {
        Set<Integer> uniqueNumberSet = new HashSet<>(); // Set to store unique digits
        
        // Loop through each number in the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // Extract digits from the number and add them to the set
            while (num > 0) {
                uniqueNumberSet.add(num % 10); // Add the last digit to the set
                num /= 10; // Remove the last digit from the number
            }
        }
        
        // Convert the set of digits to an array
        List<Integer> sortedList = new ArrayList<>(uniqueNumberSet); // Convert to List
        Collections.sort(sortedList); // Sort the list in ascending order
        
        // Convert List back to int[]
        int[] result = new int[sortedList.size()];
        for (int i = 0; i < sortedList.size(); i++) {
            result[i] = sortedList.get(i); // Fill the result array
        }
        
        return result; // Return the sorted array of unique digits
    }

*/
