/* 
Question:
Given two strings denoting non-negative numbers X and Y. Calculate the sum of X and Y.

Example 1:

Input:
X = "25", Y = "23"
Output:
48
Explanation:
The sum of 25 and 23 is 48.

Example 2:

Input:
X = "2500", Y = "23"
Output:
2523
Explanation:
The sum of 2500 and 23 is 2523.

Your Task:
Your task is to complete the function findSum()
which takes two strings as inputs and returns the string without leading zeros. You do not need to take any input or print anything.

Expected Time Complexity: O(|X| + |Y|)
Expected Auxiliary Space: O(1)

Constraints:
1 <= |X|, |Y| <= 10^5
*/

/* 
Understanding the Problem Statement:
- We are given two strings `X` and `Y` representing non-negative numbers.
- We need to compute the sum of these two numbers and return the result as a string.
- The result should not contain leading zeros unless the result is exactly "0".
- We are asked to implement a function `findSum()` that takes two strings as inputs and returns the sum in string form.

What is being asked:
- We are asked to compute the sum of two strings (which represent large numbers) and return the result as a string without any leading zeros.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - Two strings `X` and `Y` representing non-negative numbers.

2. Expected Output:
   - The sum of `X` and `Y`, returned as a string without leading zeros.

3. Output return type:
   - The return type is a string.

4. Time complexity expectations:
   - The expected time complexity is O(|X| + |Y|), where |X| and |Y| are the lengths of the input strings.
   - This is because we process each character in both strings once.

5. Constraints:
   - The length of both strings can be up to 10^5, meaning our solution must be efficient in both time and space.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem is essentially about adding two large numbers represented as strings.
   - We need to handle the addition of individual digits while taking care of carries.
   - After performing the addition, we should remove any leading zeros from the result.

2. Destructuring:
   - To add two strings representing numbers:
     - Traverse both strings from the least significant digit (rightmost) to the most significant (leftmost).
     - Add corresponding digits, considering any carry from the previous addition.
     - Append the sum to a result string and handle the carry.

3. Conversational solution into smaller subtask:
   - Step 1: Traverse both strings from right to left, adding corresponding digits.
   - Step 2: Handle the carry from each addition.
   - Step 3: If there is any remaining carry after processing both strings, append it.
   - Step 4: Reverse the result string to get the correct sum.
   - Step 5: Remove leading zeros and return the final result.

*/

/* 
Conversional Solution into Subtasks:
1. Convert both strings into integers.
2. Add the integers.
3. Convert the result back to a string and remove leading zeros if any.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Loop through the digits of both strings starting from the rightmost end.
2. Perform addition of corresponding digits and account for carry.
3. Construct the final result string and remove leading zeros.

*/

/* 
Java Code according to conversational subtasks.
*/

public class FindSum {
    
    // Function to calculate the sum of two strings
    public static String findSum(String X, String Y) {
        // Initialize pointers for both strings from the last digit
        int i = X.length() - 1;
        int j = Y.length() - 1;
        
        // Resultant string to store the sum
        StringBuilder result = new StringBuilder();
        
        // Carry to store the carry over from addition
        int carry = 0;
        
        // Traverse both strings from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry; // Start with the carry value
            
            // Add the corresponding digits of X if i >= 0
            if (i >= 0) {
                sum += X.charAt(i) - '0';
                i--;
            }
            
            // Add the corresponding digits of Y if j >= 0
            if (j >= 0) {
                sum += Y.charAt(j) - '0';
                j--;
            }
            
            // Compute the new carry and the digit to add to the result
            carry = sum / 10;
            result.append(sum % 10);
        }
        
        // The result string is in reverse order, so reverse it to get the final sum
        result.reverse();
        
        // Remove leading zeros, if any
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        
        // Return the result after removing leading zeros (if any)
        return index == result.length() ? "0" : result.substring(index);
    }

    // Main function to test the code
    public static void main(String[] args) {
        // Test case 1
        String X1 = "25";
        String Y1 = "23";
        System.out.println(findSum(X1, Y1)); // Expected output: 48

        // Test case 2
        String X2 = "2500";
        String Y2 = "23";
        System.out.println(findSum(X2, Y2)); // Expected output: 2523
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:
- We traverse both strings once, with a total of O(|X| + |Y|) iterations.
- Since we use StringBuilder for result construction and reversing the result, the time complexity remains O(|X| + |Y|).
- Thus, the time complexity is O(|X| + |Y|).

Space Complexity:
- We use a StringBuilder to store the result, which requires O(max(|X|, |Y|)) space.
- The overall space complexity is O(max(|X|, |Y|)).

*/

/* 
For Loop Walkthrough:
1. The while loop continues as long as there are digits to process in either of the strings X or Y, or there is a carry left.
   - The loop processes the digits of X and Y from right to left.
   - If the string has no more digits to process, it adds 0 as a placeholder for that string.
   - For each iteration, we add the digits, compute the carry, and append the result digit.

2. After the loop completes, we reverse the result string to get the sum in correct order.
3. We remove any leading zeros by iterating through the result string.
4. Finally, we return the processed result.

Complete Code Walkthrough:
- The function `findSum()` first initializes pointers to the last digit of each string.
- Then, it performs the addition, starting from the least significant digits and considering the carry at each step.
- The result is built in reverse order, so it's reversed before returning.
- The function handles leading zeros by checking if the result starts with '0' and removes them if necessary.
*/
