
/* 
Section-1: Question Section
Question:
Given an array nums of positive integers of size N. Find all distinct digits present in nums.

Examples:
Input: nums = [131, 11, 48]
Output: 1 3 4 8
Explanation: The digits 1, 3, 4, and 8 are distinct in the array.

Input: nums = [111, 222, 333, 4444, 666]
Output: 1 2 3 4 6
Explanation: The digits 1, 2, 3, 4, and 6 are distinct in the array.

Your task is to implement the function common_digits() which takes nums as input parameter and returns a list of digits which can be extracted from the given array in ascending order.
*/

/* 
Section-2: Understanding the Problem Statement
The problem asks us to extract all distinct digits from a given array of integers. 
We need to find the digits that are present in the integers of the array, then return these digits in ascending order.

What is being asked?
We need to return a list of distinct digits that appear across all the integers in the input array.

Key points:
1. The digits should be distinct.
2. The digits must be sorted in ascending order.
3. The solution should be efficient due to the constraints (up to 10^5 elements in the array and integers up to 10^9).

*/

/* 
Section-3: Extracting Information from the Problem Statement
Input:
- nums: An array of positive integers.

Expected Output:
- A list of distinct digits sorted in ascending order.

Return Type:
- The return type should be a list of digits.

Constraints:
- 1 <= N <= 10^5 (The number of elements in the array).
- 1 <= numsi <= 10^9 (Each number can have at most 9 digits).

Time Complexity:
- The time complexity should be efficient enough to handle the input size N up to 10^5.

Space Complexity:
- The space complexity should be O(N) for storing digits and performing operations.

*/

/* 
Section-4: Thinking Solution for the Problem Statement
To solve the problem efficiently:
1. We need to extract digits from each number in the array.
2. Use a data structure like a `Set` to store digits, as it automatically handles uniqueness.
3. For each number, we will extract its digits and add them to the `Set`.
4. Finally, convert the `Set` to a sorted list and return it.

We need to process each number's digits, which will involve iterating over the digits of each number, but we only need to store the unique digits.

The expected time complexity is O(N), where N is the number of elements in the array, because we only traverse each number once and extract its digits.
*/

/* 
Section-5: Input to Output Conversion Steps into Smaller Subtasks
S.No | Subtask Description
1    | Iterate through each number in the array.
2    | For each number, extract its digits.
3    | Store the digits in a set to ensure uniqueness.
4    | Convert the set to a sorted list.
5    | Return the sorted list of distinct digits.

*/

/* 
Section-6: Input to Output Conversion Subtasks into Code
S.No | Subtask Description                                       | Code Approach
1    | Iterate through each number in the array.                 | Loop through each element in the `nums` array.
2    | Extract digits from the current number.                   | Convert the number to a string or extract digits using mod and division.
3    | Store digits in a set for uniqueness.                     | Use a `Set<Character>` to store unique digits.
4    | Convert the set to a sorted list.                         | Use `ArrayList` or `List` to store sorted digits.
5    | Return the sorted list.                                   | Return the list after sorting.

*/

/* 
Section-7: Code Requirement to Complete the Subtasks
- A loop to iterate through the array `nums`.
- A data structure (`Set`) to store unique digits.
- A loop to extract digits from each number in the array.
- Sorting and returning the result as a list of digits.

*/

/* 
Section-8: Explanation of Approach
1. Loop through the array: Iterate through each number in the array `nums`.
2. Extract digits: For each number, extract its digits one by one. This can be done by converting the number to a string or by using division and modulo operations.
3. Store in a set: To store digits uniquely, we use a `Set`. A `Set` is ideal because it automatically handles duplicate digits.
4. Sorting: Once all digits are collected in the set, we convert the set to a sorted list.
5. Return result: Finally, we return the sorted list of digits.

By using a `Set`, we ensure that only distinct digits are stored, and by using a `List` and sorting it, we ensure that the digits are returned in ascending order.

*/
import java.util.*;
public class CommonDigits {

    // Function to find and return distinct digits from the array in ascending order
    public static List < Integer > common_digits(int[] nums) {
        // Step 1: Create a set to store unique digits
        Set < Integer > digitSet = new HashSet < > ();

        // Step 2: Loop through each number in the array
        for (int num: nums) {
            // Step 3: Extract digits from the number
            while (num > 0) {
                digitSet.add(num % 10); // Add the last digit of the number to the set
                num /= 10; // Remove the last digit
            }
        }

        // Step 4: Convert the set to a list and sort it
        List < Integer > sortedDigits = new ArrayList < > (digitSet);
        Collections.sort(sortedDigits);

        // Step 5: Return the sorted list of digits
        return sortedDigits;
    }
    public static void main(String[] args) {
        // Example input
        int[] nums = {
            131,
            11,
            48
        };

        // Call the function and print the result
        List < Integer > result = common_digits(nums);
        System.out.println(result); // Output: [1, 3, 4, 8]
    }
}

/* 
Section-9: Java Code According to Input to Output Conversion Subtasks
The code follows the steps as discussed in the approach.
1. Iterate through the array `nums`.
2. For each number, extract its digits using modulo (`%`) and division (`/`).
3. Store each extracted digit in a `Set<Integer>` to ensure uniqueness.
4. After processing all numbers, convert the `Set` to a `List` and sort the list.
5. Return the sorted list of distinct digits.
*/

/* 
Section-10: Time and Space Complexity Explanation
- Time Complexity: 
   - Extracting digits from each number: For each number, we extract its digits using modulo and division, which takes O(log10(num)) time for each number. 
     In total, this is O(N log M), where N is the size of the array and M is the maximum value in the array.
   - Sorting the digits: Sorting the unique digits takes O(K log K) time, where K is the number of distinct digits (which is at most 10, since there are only 10 possible digits).
   - Overall time complexity is O(N log M + K log K). Since K is small (maximum 10), the complexity simplifies to O(N log M).
- Space Complexity: O(N), as we are storing up to N digits in a `Set`, and converting that into a sorted list.
*/

/* 
Section-11: Walkthrough of Loops and Iterations
For example, if the input is:
nums = [131, 11, 48]

- First Iteration (131): Extract digits 1, 3 (set becomes {1, 3}).
- Second Iteration (11): Extract digit 1 (no change in set, remains {1, 3}).
- Third Iteration (48): Extract digits 4, 8 (set becomes {1, 3, 4, 8}).

After processing all numbers, the `Set` contains {1, 3, 4, 8}. We then convert this `Set` into a list and sort it: [1, 3, 4, 8].
Finally, return this sorted list.
*/

/* 
Section-12: Complete Code Walkthrough with Example Input
Input: nums = [131, 11, 48]
1. Initialize an empty set `digitSet`.
2. Iterate through the numbers in the array.
- For 131, extract digits 1, 3 and add them to the set.
- For 11, extract digit 1 (already in set, no change).
- For 48, extract digits 4, 8 and add them to the set.
3. The set now contains {1, 3, 4, 8}.
4. Convert the set to a list and sort it: [1, 3, 4, 8].
5. Return the sorted list: [1, 3, 4, 8].
*/
