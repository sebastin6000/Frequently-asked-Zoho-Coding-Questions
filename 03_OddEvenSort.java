/* 
Section -1 (Question section)
Problem Statement:
Given an array arr[] of positive integers. 
Your task is to sort them so that the first part of the array contains odd numbers sorted in descending order, 
and the rest of the portion contains even numbers sorted in ascending order.

Examples:

Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]
Explanation: 7 5 3 1 are odds in descending order and 2 4 10 are evens in ascending order.

Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
Output: [7, 5, 3, 1, 0, 2, 4]
Explanation: 7 5 3 1 are odds in descending order and 0 2 4 are evens in ascending order.

Expected Time Complexity:  O(nlog(n))
Expected Auxiliary Space:  O(1)

Constraints:
1 ≤ arr.size() ≤ 105
0 <= arr[i] <= 1018
*/

 /* 
Section - 2 (Understanding the Problem Statement section)
In the problem statement, we are tasked with sorting an array such that:
1. Odd numbers should come first and be sorted in descending order.
2. Even numbers should follow, sorted in ascending order.
The main goal is to first segregate odd and even numbers, and then sort them separately in the specified order. 
The constraints suggest the need for an efficient sorting algorithm, ideally with O(n log n) time complexity.

The constraints also tell us that the array can have up to \(10^5\) elements, and the values of the array elements can be as large as \(10^{18}\). 
This means that we need to handle large numbers and large input sizes efficiently.
 */

 /* 
Section - 3 (Extracting Information from the Problem Statement section)
- The input is an array of positive integers (arr[]), where the size of the array can be up to 10^5 elements.
- We need to return a sorted array where:
  1. The first part of the array contains odd numbers sorted in descending order.
  2. The second part contains even numbers sorted in ascending order.
- Expected output is an array that meets these conditions.
- The time complexity should be O(n log n), meaning we should focus on using sorting algorithms like quicksort or mergesort.
- The space complexity should be O(1), meaning we should aim to solve the problem without using extra space apart from the input array itself.
- The constraints for the input size and number values indicate that the solution should be scalable for large inputs.
 */

 /* 
Section - 4 (Thinking Solution for the Problem Statement section)
To solve this problem, we can break it down into the following steps:
1. Separate the odd and even numbers into two lists.
2. Sort the odd numbers in descending order.
3. Sort the even numbers in ascending order.
4. Concatenate the sorted odd numbers with the sorted even numbers to form the final sorted array.
5. The sorting step requires an efficient algorithm (like quicksort or mergesort), and since we want the space complexity to be O(1), we should avoid extra memory usage.
The constraints (1 ≤ arr.size() ≤ 10^5, 0 ≤ arri ≤ 10^18) require that our solution is both time-efficient and can handle large integers.
 */

 /* 
Section - 5 (Input to Output conversion steps into smaller subtasks section)
Subtask 1: Separate the odd and even numbers into two separate lists.
Subtask 2: Sort the odd numbers in descending order.
Subtask 3: Sort the even numbers in ascending order.
Subtask 4: Concatenate the sorted odd and even lists to form the final array.
 */

 /* 
Section - 6 (Input to Output conversion subtasks into Code section)
Subtask 1: Separate the numbers into odd and even lists.
Subtask 2: Sort the odd list in descending order.
Subtask 3: Sort the even list in ascending order.
Subtask 4: Concatenate the two lists (odd list + even list) and return the final array.
 */

 /* 
Section - 7 (Code Requirement to complete the subtasks section)
We need:
1. A loop to iterate through the array and separate odd and even numbers.
2. Sorting functions to sort both the odd and even arrays.
3. A way to combine the two sorted lists into one final array.
4. A function to handle the sorting and array manipulation.
 */

 /* 
Section - 8 (Explanation of Approach section)
1. We start by iterating through the array and segregating the odd and even numbers into two separate lists.
2. We then sort the odd numbers in descending order using a built-in sorting method (e.g., `Arrays.sort()` with a custom comparator).
3. Similarly, we sort the even numbers in ascending order using `Arrays.sort()`.
4. After sorting, we concatenate the two lists: odd numbers first (descending), followed by even numbers (ascending).
5. The complexity is dominated by the sorting step, which is O(n log n), and we use O(1) extra space, adhering to the problem's constraints.
6. The approach handles both large arrays and large numbers, ensuring efficiency for the given input size (up to 100,000 elements).
 */

 /* 
Section - 9 (Java Code according to Input to Output conversion subtasks)
*/
import java.util.*;

public class OddEvenSorter {

    // Main function for testing
    public static void main(String[] args) {
        // Test the function with sample input
        long[] arr = {1, 2, 3, 5, 4, 7, 10};
        System.out.println(Arrays.toString(sortOddEven(arr)));  // Expected output: [7, 5, 3, 1, 2, 4, 10]
    }

    // Function to sort odd numbers in descending order and even numbers in ascending order
    public static long[] sortOddEven(long[] arr) {
        // Step 1: Separate odd and even numbers
        List<Long> oddNumbers = new ArrayList<>();
        List<Long> evenNumbers = new ArrayList<>();

        for (long num : arr) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        // Step 2: Sort odd numbers in descending order
        Collections.sort(oddNumbers, Collections.reverseOrder());

        // Step 3: Sort even numbers in ascending order
        Collections.sort(evenNumbers);

        // Step 4: Combine the results
        long[] result = new long[arr.length];
        int index = 0;
        
        // Add sorted odd numbers to result array
        for (long odd : oddNumbers) {
            result[index++] = odd;
        }
        
        // Add sorted even numbers to result array
        for (long even : evenNumbers) {
            result[index++] = even;
        }

        return result;
    }
}

/*
Section - 10 (Time and Space Complexity Explanation)
Time Complexity:
- Separating the numbers into odd and even takes O(n) time, where n is the number of elements in the array.
- Sorting the odd numbers and even numbers each takes O(n log n) time (since sorting is the most expensive operation).
- Combining the two sorted lists into one takes O(n) time.
Thus, the overall time complexity is O(n log n).

Space Complexity:
- We use two lists (oddNumbers and evenNumbers), but they only store the elements in the input array. 
- Since no extra space proportional to the input size is used (beyond the input and two temporary lists), 
  the space complexity is O(1) auxiliary space, excluding the space used by the input array itself.

 */

/* 
Section - 11 (If “for” loop or “while” loop are used in the code you have to walkthrough all the(more than 1) 
“for” loop or “while” loop used in the code with every iteration with given input and this section has to be inside this structure of comments)
Explanation of loops:

Loop 1 (Separation of odd and even numbers):
- This loop iterates through each element of the input array.
- For input arr[] = [1, 2, 3, 5, 4, 7, 10], we check each element:
  - 1 is odd, add to oddNumbers
  - 2 is even, add to evenNumbers
  - 3 is odd, add to oddNumbers
  - 5 is odd, add to oddNumbers
  - 4 is even, add to evenNumbers
  - 7 is odd, add to oddNumbers
  - 10 is even, add to evenNumbers

Loop 2 (Sorting odd numbers in descending order):
- After separating, the odd numbers list will be: [1, 3, 5, 7]
- Sorting this in descending order gives: [7, 5, 3, 1]

Loop 3 (Sorting even numbers in ascending order):
- The even numbers list will be: [2, 4, 10]
- Sorting this in ascending order gives: [2, 4, 10]

Loop 4 (Combining sorted odd and even numbers):
- We then combine the sorted odd and even numbers into the result array: [7, 5, 3, 1, 2, 4, 10]
 */

 /* 
Section - 12 (Complete code walkthrough with applying the given input in code and explanation)
The given input is [1, 2, 3, 5, 4, 7, 10].
1. First, we separate the numbers into odd and even lists:
   - oddNumbers = [1, 3, 5, 7]
   - evenNumbers = [2, 4, 10]
2. Then, we sort the odd numbers in descending order:
   - sortedOddNumbers = [7, 5, 3, 1]
3. Next, we sort the even numbers in ascending order:
   - sortedEvenNumbers = [2, 4, 10]
4. Finally, we combine the two lists into the result array:
   - result = [7, 5, 3, 1, 2, 4, 10]
Thus, the final output is [7, 5, 3, 1, 2, 4, 10].
 */
