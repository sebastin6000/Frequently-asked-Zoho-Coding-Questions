/* 
Question:
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
--------------------------------------------------------------------------------------------------------------------
*/

/* 
1.Understand the Problem Statement:
   we are given an array with n-1 integers(1 element missing from the array size n so its n-1), 
   where the integers are distinct and range from 1 to n (inclusive). 
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
   
--------------------------------------------------------------------------------------------------------------------
*/

/* 
2.Imformation Extracting:
  - Input data type - with this we can know about the function arguments.
  - Expected Output - have to return the missing integer in the integer array 
  - Output return type - integer
  - Time complexity expectations if any - no mentioned
  - Understanding the Constraints:
      1 ≤ arr.size() ≤ 10^6: The array can have up to 1 million elements.
      1 ≤ arr[i] ≤ arr.size() + 1: 
      The integers in the array are distinct and are within the range 1 to n, where n is the length of the array + 1.

      This implies the array size can be large, and our solution must be efficient in terms of both time and space.
      We need to ensure the solution works within the constraints and doesn’t exceed time or memory limits.
--------------------------------------------------------------------------------------------------------------------
*/

/*
3.Thinking Solution:
- To break down the problem into simpler words and build the intuition for solving it step-by-step,
  let's first ask the question: How am I going to solve this?

   Problem Understanding:
   - You have an array of size n - 1, where the integers are distinct and range from 1 to n.
   - You know that one number is missing from the array, and you need to figure out which number is missing.
   
   What am I given?
   - A list (arr[]) with n - 1 integers from the range 1 to n. One number is missing from this list.
   - You are tasked with finding which number is missing.
   
   What is the full range?
   - If the array was complete (without any missing number), it would contain every number from 1 to n.
   - This means that the total sum of numbers from 1 to n can be calculated using a simple formula.
   
   How can I find the missing number?
   - Imagine you are given a complete list of numbers from 1 to n. 
   - The sum of these numbers is well-known and can be calculated using the formula:
   - Sum of numbers from 1 to n, sum = n * (n + 1) / 2
   - You then calculate the sum of the numbers in the array (arr[]).
   - The missing number is simply the difference between the sum of the full list and the sum of the array.
   - Why this works? Because the only difference between the full list and the array is the missing number. The rest are exactly the same.
   
   Example to clarify:
   Say the array is [1, 2, 3, 5], and the range should be 1 to 5.The sum of 1 to 5 is 15 (because 5 * (5 + 1) / 2 = 15).
   The sum of the array is 1 + 2 + 3 + 5 = 11.
   The missing number is 15 - 11 = 4. Hence, the missing number is 4.
   
   How do I implement this?
   First, calculate the expected sum of numbers from 1 to n using the formula.
   Then, calculate the actual sum of the numbers in the array by looping through it.
   Finally, subtract the sum of the array from the expected sum to get the missing number.
--------------------------------------------------------------------------------------------------------------------
*/
/* 
3.1 Breaking the Conversational Solution into Smaller Subtasks:
   1.Find the range (n): The array arr[] is missing one element, so the full size of the list should be n = arr.length + 1.
   2.Calculate the expected sum: Use the formula n * (n + 1) / 2 to find the sum of numbers from 1 to n.
   3.Calculate the sum of the array:   
   4.Find the missing number: Subtract the sum of the array from the expected sum to get the missing number.
   5.Return the result:The difference is the number that is missing.
--------------------------------------------------------------------------------------------------------------------
*/
/*
4.Thinking into Code Converting:
Subtask 1: Calculate the expected sum of numbers from 1 to n
- Why? We need to know what the sum should be if all numbers from 1 to n were present. This helps us compare it with the sum of the array.
- How? Use the formula for the sum of the first n numbers: expectedSum = n * (n + 1) / 2.

Subtask 2: Calculate the sum of the elements in the given array
- Why? We need to know the sum of the elements actually present in the array.
- How? Iterate through the array, adding up each element.
  
Subtask 3: Find the missing number
- Why? We now know the expected sum and the actual sum. The difference between them will give us the missing number.
- How? The missing number is the difference between the expected sum and the actual sum
--------------------------------------------------------------------------------------------------------------------
*/

public class MissingNumber {
    
    /* Step 1: Function to find the missing number */
    public static int findMissingNumber(int[] arr) {
        // Step 1: Get the size of the complete array (with the missing element)
        int n = arr.length + 1;  // n is the size of the full array, including the missing element.
        
        // Step 2: Calculate the expected sum of the first n natural numbers (1 to n).
        int expectedSum = n * (n + 1) / 2;
        
        // Step 3: Calculate the sum of the elements present in the array using a FOR loop
        int actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];  // Add each element to the actualSum.
        }
        
        // Step 4: The missing number is the difference between the expected sum and the actual sum.
        return expectedSum - actualSum;
    }
    
    /* Step 2: Main function to test the code */
    public static void main(String[] args) {
        // Example 1: arr[] = {1, 2, 3, 5}, missing number is 4
        int[] arr1 = {1, 2, 3, 5};
        System.out.println("Missing number: " + findMissingNumber(arr1));  // Output: 4
        
        // Example 2: arr[] = {8, 2, 4, 5, 3, 7, 1}, missing number is 6
        int[] arr2 = {8, 2, 4, 5, 3, 7, 1};
        System.out.println("Missing number: " + findMissingNumber(arr2));  // Output: 6
        
        // Example 3: arr[] = {1}, missing number is 2
        int[] arr3 = {1};
        System.out.println("Missing number: " + findMissingNumber(arr3));  // Output: 2
    }
}

/* 
Explanation of Code:
1. In the `findMissingNumber` method, we first calculate `n`, the size of the full array (which is arr.length + 1 because one number is missing).
2. We calculate the expected sum of numbers from 1 to n using the formula `n * (n + 1) / 2`.
3. Then, we calculate the sum of the elements present in the array using a `for` loop, and accumulate the sum in `actualSum`.
4. Finally, we return the difference between the expected sum and the actual sum as the missing number.
5. The main method tests the solution with three examples: arr1, arr2, and arr3, printing the result for each.
*/
/* 
Time and Space Complexity Explanation:
Time Complexity:
- The time complexity is O(n) because we need to iterate through the array to calculate the sum of its elements. 
  The formula to calculate the expected sum (sum = n * (n + 1) / 2) takes constant time O(1).
- Therefore, the overall time complexity is O(n).

Space Complexity:
- We only use a few variables (expectedSum, actualSum, and n), so the space complexity is O(1).
  This means the space used does not depend on the size of the input array, and it remains constant regardless of the array size.
  In simple terms, this approach scales well with large input sizes (up to 1 million elements).
*/

/* 
FOR loop walkthrough with every iteration with the given input, 
Complete code walkthrough with applying the given input in code and explanation:
Let’s go through the code with an example, say: arr[] = {1, 2, 3, 5}.

Step-by-step:
1. The size of the array is 4, so n = 5 (because the range of numbers should be from 1 to 5, and one number is missing).
2. The expected sum of numbers from 1 to 5 is:
   expectedSum = 5 * (5 + 1) / 2 = 15.
3. We calculate the sum of the elements in the array:
   - Start with actualSum = 0.
   - First iteration: i = 0, arr[0] = 1, actualSum += 1 → actualSum = 1.
   - Second iteration: i = 1, arr[1] = 2, actualSum += 2 → actualSum = 3.
   - Third iteration: i = 2, arr[2] = 3, actualSum += 3 → actualSum = 6.
   - Fourth iteration: i = 3, arr[3] = 5, actualSum += 5 → actualSum = 11.
4. Now, we calculate the missing number:
   missingNumber = expectedSum - actualSum = 15 - 11 = 4.
   So, the missing number is 4, and we return 4.

The same approach works for other inputs as well, just with different values for arr[].
*/
