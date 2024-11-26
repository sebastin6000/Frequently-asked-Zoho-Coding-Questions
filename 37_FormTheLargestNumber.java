/* 
Question:
Given an array of integers arr[] representing non-negative integers, 
arrange them so that after concatenating all of them in order, 
it results in the largest possible number. Since the result may be very large, return it as a string.

Examples:

Input: arr[] = [3, 30, 34, 5, 9]
Output: "9534330"
Explanation: Given numbers are [3, 30, 34, 5, 9], the arrangement "9534330" gives the largest value.

Input: arr[] = [54, 546, 548, 60]
Output: "6054854654"
Explanation: Given numbers are [54, 546, 548, 60], the arrangement "6054854654" gives the largest value.

Input: arr[] = [3, 4, 6, 5, 9]
Output: "96543"
Explanation: Given numbers are [3, 4, 6, 5, 9], the arrangement "96543" gives the largest value.

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^5.
*/

/* 
Understanding the Problem Statement:
- The task is to arrange the given numbers such that when concatenated, the resulting number is the largest possible.
- The output should be the largest number represented as a string because it could be very large.
- We need to determine the order in which to concatenate the numbers to form the largest possible number.

What is being asked:
- Given an array of integers, find the arrangement that forms the largest number when concatenated.
- Return the result as a string.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An array of integers where each integer is a non-negative number.
2. Expected Output:
   - The largest possible number formed by concatenating the integers from the input array.
3. Output return type:
   - String (since the number may be very large).
4. Time complexity expectations:
   - The solution should be efficient, ideally with a time complexity of O(n log n) due to sorting.
5. Constraints:
   - 1 ≤ arr.size() ≤ 10^5.
   - 0 ≤ arr[i] ≤ 10^5, meaning the elements are non-negative integers within the range of 0 to 100,000.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem is about ordering integers to form the largest number when concatenated.
   - This is a string comparison problem, where we need to determine the correct order of strings.

2. Destructuring:
   - If we compare two numbers as strings, for example "3" and "30", we can see that "330" is greater than "303". So, "3" should come before "30".
   - We need to sort the integers (converted to strings) based on this type of comparison.

3. Conversional solution into smaller subtask:
   - Subtask 1: Convert each integer in the array to a string.
   - Subtask 2: Define a custom comparison function that determines which string combination produces the larger number.
   - Subtask 3: Sort the array of strings using the custom comparator.
   - Subtask 4: Concatenate the sorted strings and return the result.
   - Subtask 5: Handle the edge case where the result might contain leading zeros (e.g., [0, 0, 0] should return "0").

*/

/* 
Conversional Solution into Subtasks:
1. Convert each integer to a string.
2. Define a custom comparator to compare two strings based on concatenation.
3. Sort the array of strings using the custom comparator.
4. Concatenate the sorted strings.
5. Handle edge cases like when all elements are zeros.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Convert each integer to a string.
2. Define a custom comparator for sorting the strings based on concatenation.
3. Sort the strings.
4. Concatenate the sorted strings and handle edge cases (like leading zeros).

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    // Custom comparator for sorting the numbers in descending order based on concatenation
    public static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            // Compare concatenated strings: a + b and b + a
            return (b + a).compareTo(a + b);
        }
    }

    // Function to find the largest number by arranging the elements
    public static String largestNumber(int[] nums) {
        // Subtask 1: Convert the integers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Subtask 2: Sort the strings using custom comparator
        Arrays.sort(strNums, new CustomComparator());

        // Subtask 3: Handle the case where the largest number is "0"
        if (strNums[0].equals("0")) {
            return "0";  // All numbers were 0
        }

        // Subtask 4: Concatenate the sorted strings
        StringBuilder largestNum = new StringBuilder();
        for (String num : strNums) {
            largestNum.append(num);
        }

        // Return the final concatenated result
        return largestNum.toString();
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums1));  // Expected output: "9534330"

        // Test case 2
        int[] nums2 = {54, 546, 548, 60};
        System.out.println(largestNumber(nums2));  // Expected output: "6054854654"

        // Test case 3
        int[] nums3 = {3, 4, 6, 5, 9};
        System.out.println(largestNumber(nums3));  // Expected output: "96543"

        // Test case 4
        int[] nums4 = {0, 0};
        System.out.println(largestNumber(nums4));  // Expected output: "0"
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Sorting the array takes O(n log n), where n is the size of the input array.
  - The comparison in the custom comparator takes O(k), where k is the average length of the numbers (approximately 6 for the largest number 100,000).
  - Thus, the overall time complexity is O(n log n * k).
- Space Complexity:
  - We use O(n) space to store the string representations of the integers.

*/

/* 
“for” loop walkthrough with every iteration with given input.
*/

/* 
The main loop in the code is for converting the integers into strings:
- For the input `nums = {3, 30, 34, 5, 9}`, we iterate through each element and convert it to a string:
    - 3 -> "3"
    - 30 -> "30"
    - 34 -> "34"
    - 5 -> "5"
    - 9 -> "9"

The sorting step uses the custom comparator to compare the concatenated strings:
- The sorted order would be ["9", "5", "34", "3", "30"] based on the concatenation comparison.

Finally, we concatenate the sorted strings:
- The result would be "9534330".
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For the input `nums = {3, 30, 34, 5, 9}`:
1. We convert the integers into strings: ["3", "30", "34", "5", "9"].
2. We sort them using the custom comparator:
   - "9" + "5" = "95", "5" + "9" = "59". So, "9" should come first.
   - "34" + "3" = "343", "3" + "34" = "334". So, "34" should come before "3".
   - The sorted order will be ["9", "5", "34", "3", "30"].
3. We concatenate the strings to form "9534330".
4. The result is returned as "9534330".
*/
