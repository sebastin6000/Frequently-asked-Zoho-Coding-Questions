/* 
Question:
Given an integer `num`, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is:
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

Example 2:
Input: num = 0
Output: 0

Constraints:
0 <= num <= 2^31 - 1
*/

/* 
Understanding the Problem Statement:
- We are given an integer `num`.
- We are asked to repeatedly sum its digits until we get a single-digit result.
- If the number is already a single digit, it should be returned as is.
- This process should be continued until only a single-digit number remains.

What is being asked:
- We need to return the single-digit result after repeatedly summing the digits of the number.
- If the input number is 0, we should return 0 directly.
- The process is essentially a digital root computation.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An integer `num`, where 0 <= num <= 2^31 - 1.
2. Expected Output:
   - A single integer representing the result of repeatedly adding the digits until only one digit remains.
3. Output return type:
   - Integer.
4. Time complexity expectations:
   - The process should ideally be performed in constant time O(1) because summing digits repeatedly reduces the problem significantly.
5. Constraints:
   - 0 <= num <= 2^31 - 1, meaning that the number is between 0 and 2,147,483,647 (inclusive).
   - We are looking for a solution with a time complexity of O(1).

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is essentially about finding the "digital root" of the number.
   - The digital root can be found using properties of numbers modulo 9. This can be done using the formula:
     - Digital Root of a number `num` can be found as `1 + (num - 1) % 9` when `num > 0`.
     - If `num == 0`, the result is 0.
   - The digital root approach eliminates the need for iterative digit summing.

2. Destructuring:
   - If the number is 0, return 0 directly.
   - Otherwise, compute the digital root using modulo arithmetic.
   - This approach allows us to get the answer in constant time.

3. Conversional solution into smaller subtask:
   - Subtask 1: Check if the number is 0. If yes, return 0.
   - Subtask 2: For other numbers, compute the digital root using the formula: `1 + (num - 1) % 9`.
   - Subtask 3: Return the computed result.

*/

/* 
Conversional Solution into Subtasks:
1. Check if `num` is 0, return 0 immediately.
2. Use the formula `1 + (num - 1) % 9` to find the digital root for non-zero numbers.
3. Return the result.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Check if `num` equals 0.
2. If not, calculate the digital root using modulo arithmetic.
3. Return the result.

*/

/* 
Java Code according to conversational subtasks.
*/

public class AddDigits {
    
    // Function to compute the digital root (repeated sum of digits until one digit remains)
    public static int addDigits(int num) {
        // Subtask 1: Check if num is 0, return 0
        if (num == 0) {
            return 0;
        }
        
        // Subtask 2: Use the digital root formula
        return 1 + (num - 1) % 9;
    }
    
    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        int num1 = 38;
        System.out.println(addDigits(num1)); // Expected output: 2

        // Test case 2
        int num2 = 0;
        System.out.println(addDigits(num2)); // Expected output: 0
        
        // Test case 3
        int num3 = 12345;
        System.out.println(addDigits(num3)); // Expected output: 6
        
        // Test case 4
        int num4 = 999;
        System.out.println(addDigits(num4)); // Expected output: 9
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity: O(1), since we are performing constant time operations (simple arithmetic).
- Space Complexity: O(1), since we only use a fixed amount of space regardless of the input size.

*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For the input `num = 38`:
- We check if `num == 0` (it's not).
- We then compute the digital root as `1 + (38 - 1) % 9 = 1 + 37 % 9 = 1 + 1 = 2`.
- The output is 2.

For the input `num = 0`:
- We check if `num == 0` (it is).
- We return 0 immediately.

For the input `num = 12345`:
- We check if `num == 0` (it's not).
- We compute the digital root as `1 + (12345 - 1) % 9 = 1 + 12344 % 9 = 1 + 6 = 6`.
- The output is 6.

For the input `num = 999`:
- We check if `num == 0` (it's not).
- We compute the digital root as `1 + (999 - 1) % 9 = 1 + 998 % 9 = 1 + 0 = 9`.
- The output is 9.
*/
