/*
Question:
Given an array of integers `arr[]` representing non-negative integers, 
arrange them so that after concatenating all of them in order, it results in the largest possible number. 
Since the result may be very large, return it as a string.

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
0 ≤ arr[i] ≤ 10^5
*/

/*
Understanding the Problem Statement:
- We are given an array of integers and need to arrange them in such a way that when they are concatenated, 
  the result is the largest possible number.
- This implies we need to compare how to order two numbers such that their concatenation results in the larger number.

What is being asked:
- We need to return a string representing the largest number that can be formed by concatenating the integers in the input array.

*/

/*
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is an array of integers `arr[]`, where each integer is between 0 and 10^5.

2. Expected Output:
   - The output should be a string representing the largest possible number that can be formed by concatenating the integers in `arr[]`.

3. Output return type:
   - The function should return a string.

4. Time complexity expectations:
   - The solution should be efficient, as the input size can go up to 10^5.
   - Sorting the numbers and comparing concatenated values should ideally be O(n log n) for efficiency, where `n` is the size of the array.

5. Constraints:
   - The number of integers can be as large as 10^5.
   - Each number can be as large as 100,000 (5 digits).

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem can be solved by sorting the numbers in such a way that for two numbers `x` and `y`, if `x + y > y + x`, 
     then `x` should come before `y`. Otherwise, `y` should come before `x`.

2. Destructuring:
   - The main intuition here is to decide the order of two numbers by comparing the concatenation of both possible orders.
   - For example, given numbers `a = "9"` and `b = "34"`, 
     we compare the concatenated results `a + b` and `b + a`. We prefer the order that yields the larger number.

3. Conversational solution into smaller subtask:
   - Subtask 1: Convert each number to a string, as string concatenation is essential for this problem.
   - Subtask 2: Implement a custom comparator that sorts numbers based on their concatenated value.
   - Subtask 3: Sort the array using this custom comparator.
   - Subtask 4: Concatenate the sorted numbers into a single string and return it.

*/

/* 
Conversional Solution into Subtasks:
1. Convert each number to a string for easy concatenation.
2. Create a custom comparator that compares two strings based on the concatenated results of both possible orders.
3. Sort the array using the custom comparator.
4. Concatenate all the sorted strings and return the result.
5. Handle edge cases, such as when the result is all zeros.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Convert the integers in the array to strings.
2. Implement a custom comparator that compares two strings `x` and `y` based on the concatenated values `x + y` and `y + x`.
3. Use a sorting function that sorts the array based on the custom comparator.
4. Concatenate the sorted array of strings to form the largest number.
5. Check if the result is a number with leading zeros (e.g., "000"), and return just "0" if so.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class LargestNumber {

    // Custom comparator for sorting strings
    public static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            // Compare based on concatenated values x + y and y + x
            return (y + x).compareTo(x + y); // reversing the order to sort in descending order
        }
    }

    // Function to form the largest number
    public static String largestNumber(int[] arr) {
        // Convert integers to strings
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        // Sort the array using the custom comparator
        Arrays.sort(strArr, new CustomComparator());

        // If the largest number is "0", return "0"
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings
        StringBuilder result = new StringBuilder();
        for (String s : strArr) {
            result.append(s);
        }

        // Return the result as a string
        return result.toString();
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr1)); // Output: "9534330"

        // Test case 2
        int[] arr2 = {54, 546, 548, 60};
        System.out.println(largestNumber(arr2)); // Output: "6054854654"

        // Test case 3
        int[] arr3 = {3, 4, 6, 5, 9};
        System.out.println(largestNumber(arr3)); // Output: "96543"

        // Test case 4 (Edge case with all zeros)
        int[] arr4 = {0, 0, 0};
        System.out.println(largestNumber(arr4)); // Output: "0"
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Converting integers to strings takes O(n) time.
  - Sorting the strings takes O(n log n) time with respect to the number of elements. 
    Since the length of each string is at most 5 characters, the sorting complexity is dominated by the comparison of two strings, 
    which takes O(1) time. Thus, the overall time complexity is O(n log n).
  
- Space Complexity:
  - We need additional space to store the string representations of the numbers. 
    Thus, the space complexity is O(n), where `n` is the number of elements in the input array.

*/

/* 
Explanation of loops:
1. The first `for` loop is used to convert each integer in the array to a string representation.
   - For example, for `arr = {3, 30, 34, 5, 9}`, the loop converts the integers to `{"3", "30", "34", "5", "9"}`.
2. The sorting step uses the custom comparator to arrange the strings in the desired order. 
   The order is determined by comparing concatenated values like `x + y` and `y + x`.
   - For example, for strings `"9"` and `"34"`, 
     the comparator compares `34 + 9 = "349"` and `9 + 34 = "934"`. Since `"934" > "349"`, `"9"` comes before `"34"`.
3. After sorting, the final `for` loop concatenates the strings in the sorted order to form the largest number.

For input `arr = [3, 30, 34, 5, 9]`:
- After converting to strings: `{"3", "30", "34", "5", "9"}`
- After sorting based on the custom comparator: `{"9", "5", "34", "3", "30"}`
- Concatenating the sorted array results in `"9534330"`.

*/

/* 
Complete code walkthrough with applying the given input in code and explanation:

For input `arr = [3, 30, 34, 5, 9]`:
1. Convert integers to strings: `["3", "30", "34", "5", "9"]`.
2. Sort the strings using the custom comparator:
   - `"9"` + `"34"` = `"934"`, `"34"` + `"9"` = `"349"`, so `"9"` comes before `"34"`.
   - Similarly, sort the other strings: `"5"`, `"34"`, `"30"`, `"3"`.
   - Sorted order: `["9", "5", "34", "3", "30"]`.
3. Concatenate the sorted strings: `"9534330"`.
4. Return the result: `"9534330"`.
*/
