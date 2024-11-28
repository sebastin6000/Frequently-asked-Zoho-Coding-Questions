/*
TEMPLATE 

1.Understanding the Problem Statement:
2.Extracting Information from the Problem Statement:
2.1 Input data type or data structure - 
2.2 Expected Output - 
2.3 Output return data type (or) data structure type - 
2.4 Understanding the Constraints - 
2.5 Understanding Time complexity expectations if any in the given problem statement.

3.Thinking Solution for the Problem Statement:
3.1 Getting Solution from Input to Output conversion:

4.Input to Output convesion steps into smaller subtasks:
4.1 After finding the steps from input to output conversion convert the steps into subtasks

5.Input to Output conversion subtasks into Code:
5.1 Things needed to complete eash Subtask ? : For this go any IDE with the subtasks and start to code.
5.2 Do every subtask in an Efficient manner with efficient Data structure and Algorithm.
5.2.1 Efficient data structure - 
5.2.2 Efficient Algorithm / pattern - 

*/
/* 
Question:
Given an array arr[] of positive integers, your task is to sort the array such that:
1. The first part of the array contains odd numbers sorted in descending order.
2. The rest of the array contains even numbers sorted in ascending order.

Example 1:
Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]
Explanation: 7, 5, 3, 1 are odd numbers in descending order, and 2, 4, 10 are even numbers in ascending order.

Example 2:
Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
Output: [7, 5, 3, 1, 0, 2, 4]
Explanation: 7, 5, 3, 1 are odd numbers in descending order, and 0, 2, 4 are even numbers in ascending order.

Your Task:
Complete the function sortOddEven() 
that takes arr as input and returns the sorted array with odd numbers first (sorted in descending order) and even numbers second (sorted in ascending order).

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(1)

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^18
*/

/* 
Understanding the Problem Statement:
We need to rearrange the elements of the array such that all the odd numbers are grouped together at the start in descending order, 
and all the even numbers are grouped together at the end in ascending order.
The array should be sorted in a way where odd numbers are in descending order followed by even numbers in ascending order.

Extracting Information from the Problem Statement:
- Input: An array `arr[]` of positive integers.
- Expected Output: The array sorted with odd numbers in descending order followed by even numbers in ascending order.
- Time Complexity: O(n log n), where n is the size of the array.
- Space Complexity: O(1), we can do this in-place without using extra space.

Constraints:
- The size of the array can be up to 10^5.
- The integers can be as large as 10^18.

Thinking Solution for the Problem Statement:
1. Identify the odd and even numbers in the array.
2. Sort the odd numbers in descending order.
3. Sort the even numbers in ascending order.
4. Combine the sorted odd and even numbers into a single array.
5. Return the result.

Subtasks:
1. Extract odd numbers and even numbers from the array.
2. Sort odd numbers in descending order and even numbers in ascending order.
3. Merge the two sorted lists into the result array.

Subtasks of Conversional Solution into Code:
- Extract odd and even numbers: We can iterate through the array and separate the odd and even numbers.
- Sort the numbers: Use Java's built-in sorting functions to sort the odd and even numbers.
- Combine the sorted arrays: After sorting, we combine the two arrays (odd and even) into one.

Java Code according to Conversational Subtasks:

*/

import java.util.*;

public class StringTransformation {
  
    // Function to sort the odd and even numbers as per the requirement
    public static int[] sortOddEven(int[] arr) {
        // Lists to store odd and even numbers
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        
        // Step 1: Separate odd and even numbers
        for (int num : arr) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }
        
        // Step 2: Sort odd numbers in descending order
        Collections.sort(odds, Collections.reverseOrder());
        
        // Step 3: Sort even numbers in ascending order
        Collections.sort(evens);
        
        // Step 4: Combine the sorted odd and even numbers into the result
        int[] result = new int[arr.length];
        int i = 0;
        for (int odd : odds) {
            result[i++] = odd;
        }
        for (int even : evens) {
            result[i++] = even;
        }
        
        // Return the final sorted array
        return result;
    }
  
    // Main method to test the function
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, 5, 4, 7, 10};
        System.out.println(Arrays.toString(sortOddEven(arr1))); // Expected Output: [7, 5, 3, 1, 2, 4, 10]

        // Test Case 2
        int[] arr2 = {0, 4, 5, 3, 7, 2, 1};
        System.out.println(Arrays.toString(sortOddEven(arr2))); // Expected Output: [7, 5, 3, 1, 0, 2, 4]
    }
}

/*
Time and Space Complexity Explanation:
- **Time Complexity**: 
  - Separating odd and even numbers takes O(n), where n is the size of the array.
  - Sorting the odd numbers in descending order takes O(n log n).
  - Sorting the even numbers in ascending order also takes O(n log n).
  - Therefore, the total time complexity is O(n log n).
  
- **Space Complexity**: 
  - We use two lists (`odds` and `evens`) to store the odd and even numbers, which takes O(n) space.
  - The result array takes O(n) space as well, leading to a total space complexity of O(n).

Complete Code Walkthrough:
- First, we iterate through the array to separate odd and even numbers. We use two lists: `odds` for odd numbers and `evens` for even numbers.
- After that, we sort the `odds` list in descending order using `Collections.sort` with `Collections.reverseOrder()`, 
  and sort the `evens` list in ascending order using the default sorting behavior of `Collections.sort`.
- Finally, we combine the sorted odd and even numbers into the `result` array and return it.

Test Case 1:
- Input: [1, 2, 3, 5, 4, 7, 10]
- Odd numbers: [1, 3, 5, 7] (sorted in descending order: [7, 5, 3, 1])
- Even numbers: [2, 4, 10] (sorted in ascending order: [2, 4, 10])
- Combined result: [7, 5, 3, 1, 2, 4, 10]

Test Case 2:
- Input: [0, 4, 5, 3, 7, 2, 1]
- Odd numbers: [5, 3, 7, 1] (sorted in descending order: [7, 5, 3, 1])
- Even numbers: [0, 4, 2] (sorted in ascending order: [0, 2, 4])
- Combined result: [7, 5, 3, 1, 0, 2, 4]
*/ 


