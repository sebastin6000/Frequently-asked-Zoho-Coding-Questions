https://www.geeksforgeeks.org/problems/make-a-distinct-digit-array2007/1

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
