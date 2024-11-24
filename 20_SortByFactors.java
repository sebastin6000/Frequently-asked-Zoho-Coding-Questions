/* 
Question: 
Given an array of positive integers, sort the array in decreasing order of the number of factors of each element. 
That is, the element with the highest number of factors should be displayed first. 
If two elements have the same number of factors, they should retain their relative order as in the original array.

Examples: 
Input: {5, 11, 10, 20, 9, 16, 23}
Output: 20 16 10 9 5 11 23
Explanation: 
Number of factors:
- 20 has 6 factors: (1, 2, 4, 5, 10, 20)
- 16 has 5 factors: (1, 2, 4, 8, 16)
- 10 has 4 factors: (1, 2, 5, 10)
- 9 has 3 factors: (1, 3, 9)
- 5, 11, and 23 each have 2 factors: (1, 5), (1, 11), (1, 23)
Thus, the sorted order is 20, 16, 10, 9, 5, 11, 23.

Input: {104, 210, 315, 166, 441, 180}
Output: 180 210 315 441 104 166

*/
/* 
1.Understanding the Problem Statement: 

You are given an array of positive numbers. 
Your task is to sort the numbers in such a way that the number with the most factors (or divisors) comes first. 
If two numbers have the same number of factors, they should appear in the same order as they were originally in the array.

Examples: 
Input: {5, 11, 10, 20, 9, 16, 23}
Output: 20 16 10 9 5 11 23
Explanation: 
Number of factors:
- 20 has 6 factors: (1, 2, 4, 5, 10, 20)
- 16 has 5 factors: (1, 2, 4, 8, 16)
- 10 has 4 factors: (1, 2, 5, 10)
- 9 has 3 factors: (1, 3, 9)
- 5, 11, and 23 each have 2 factors: (1, 5), (1, 11), (1, 23)
Thus, the sorted order is 20, 16, 10, 9, 5, 11, 23.

Input: {104, 210, 315, 166, 441, 180}
Output: 180 210 315 441 104 166
*/

/* 
2.Extracting Information from the Problem Statement:
- Input Data Type: Array of positive integers (int[] or equivalent).
- Expected Output: Sorted array of integers based on the number of factors in decreasing order.
- Output Return Type: Array of integers (int[]).
- Time Complexity Expectations: 
- Understanding the Constraints:
  - Array size: 3 <= arr.size() <= 1000.
   -  Array Size (arr.size()): The number of elements in the input array can range from 3 to 1000.
      This means the array will always have at least 3 elements and no more than 1000 elements.
      Minimum size: 3 elements.
      Maximun size: 1000 elements.

  - Array elements: 1 <= arr[i] <= 1000.
    Array Elements (arr[i]): Each element of the array is a positive integer, 
    and it lies between 1 and 1000. This means every integer in the array will be between 1 and 1000, inclusive. 
    Minimum value: 1.
    Maximum value: 1000.
*/

/* 
3.Thinking Solution for the Problem Statement in conversational Manner:
4.Conversional Solution into Code:

*/
