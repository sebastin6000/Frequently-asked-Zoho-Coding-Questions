### **QUESTION**
You are given an array arr of size n - 1 that contains distinct integers in the range from 1 to n (inclusive). 
This array represents a permutation of the integers from 1 to n with one element missing. 
Your task is to identify and return the missing element.

Examples:
Input: arr[] = [1, 2, 3, 5]
Output: 4
Explanation: All the numbers from 1 to 5 are present except 4.

Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
Output: 6
Explanation: All the numbers from 1 to 8 are present except 6.

Input: arr[] = [1]
Output: 2
Explanation: Only 1 is present so the missing element is 2.
*/

### **UNDERSTANDING THE QUESTION**                                       
In this task, we are given an array with n-1 integers, where the integers are distinct and range from 1 to n (inclusive). 
We need to find the one missing number from the array.

For example:
Input: [1, 2, 3, 5]
Output: 4
Here, the numbers 1 to 5 are expected, but the number 4 is missing, so the output is 4.

Input: [8, 2, 4, 5, 3, 7, 1]
Output: 6
All numbers from 1 to 8 are present except 6, so the missing number is 6.

Input: [1]
Output: 2
Since only 1 is present and the range is from 1 to 2, the missing number is 2.
*/

/* 
Constraints explanation:
1 ≤ arr.size() ≤ 10^6: The array can have up to 1 million elements.
1 ≤ arr[i] ≤ arr.size() + 1: The integers in the array are distinct and are within the range 1 to n, where n is the length of the array + 1.

Given these constraints, the solution must be efficient in both time and space.
*/

/* 
Relatable analogy or real-world scenario step by step:
Imagine you're hosting a birthday party, and you have a guest list with numbers assigned to each guest (1 to n). 
However, one guest didn't show up, and you have a list of the people who actually attended. Your task is to figure out who didn’t come. 
This is similar to finding the missing number in the array. The people who attended are like the numbers in the array, and the missing guest corresponds to the missing number.

Here’s how we can solve it:
1. You know the sum of all the guests that should have attended (from 1 to n). This is the total sum of the first n numbers, which can be calculated by the formula: 
   sum = n * (n + 1) / 2.
2. You also know the sum of all the numbers on your actual guest list (the numbers in the array).
3. The missing guest is simply the difference between the sum of all guests and the sum of the guests who actually came.

So, by calculating the sum of the complete list (1 to n) and subtracting the sum of the array, you can easily identify the missing guest.
*/

/* 
Relatable analogy Java code step by step:
Let’s write a step-by-step Java code to solve this problem.

Step 1: We will calculate the sum of the numbers from 1 to n (where n is the length of the array + 1).
Step 2: We will calculate the sum of the numbers that are present in the array.
Step 3: The missing number is the difference between the total sum and the sum of the array.

Here’s how the code works:
*/
public class MissingNumber {
    
    /* Step 1: Function to find the missing number */
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;  // n is the size of the full array, including the missing element.
        
        // Calculate the sum of the first n natural numbers (1 to n).
        int expectedSum = n * (n + 1) / 2;
        
        // Calculate the sum of the elements in the array.
        int actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];  // Add each element to the actualSum.
        }
        
        // The missing number is the difference between the expected sum and the actual sum.
        return expectedSum - actualSum;
    }
    
    /* Step 2: Main function to test the code */
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {1, 2, 3, 5}; // Missing 4
        System.out.println("Missing number: " + findMissingNumber(arr1)); // Output: 4
        
        // Example 2
        int[] arr2 = {8, 2, 4, 5, 3, 7, 1}; // Missing 6
        System.out.println("Missing number: " + findMissingNumber(arr2)); // Output: 6
        
        // Example 3
        int[] arr3 = {1}; // Missing 2
        System.out.println("Missing number: " + findMissingNumber(arr3)); // Output: 2
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:
- The time complexity is O(n) because we loop through the array once to compute the sum of the array elements. 
- Calculating the expected sum using the formula is constant time O(1).
Therefore, the overall time complexity is O(n).

Space Complexity:
- We are only using a few variables (expectedSum, actualSum, and n), so the space complexity is O(1) — constant space, regardless of the size of the input array.

In simple terms, this means the solution scales well for large inputs, handling arrays of up to 1 million elements efficiently.
*/

/* 
FOR loop walkthrough with every iteration with the given input, Complete code walkthrough with applying the given input in code and explanation has to in simple English because I have to explain the question and approach to my friends and this section has to be inside this structure of comments.

Example:
Let’s take the first example: arr[] = {1, 2, 3, 5}.
- n = 5 (because the array length is 4, and the missing number is in the range 1 to 5).
- The expected sum of numbers from 1 to 5 is: 
  expectedSum = 5 * (5 + 1) / 2 = 15.
- The sum of the numbers in the array is: 
  actualSum = 1 + 2 + 3 + 5 = 11.
- The missing number is: expectedSum - actualSum = 15 - 11 = 4.

The missing number is 4, and we return that as the output.

Complete code walkthrough:
1. We initialize n as the size of the array + 1, which gives us the complete range of numbers (1 to n).
2. We calculate the expected sum of numbers from 1 to n using the formula n * (n + 1) / 2.
3. We iterate through the array using a for loop and add each element to the actualSum.
4. After the loop, we subtract the actualSum from the expectedSum to find the missing number and return it.

*/

// Complete code: (as written above)
