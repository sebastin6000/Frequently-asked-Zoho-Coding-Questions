/* 
Question:
Given an integer num, return a string of its base 7 representation. 
For example:
Input: num = 100
Output: "202"

Input: num = -7
Output: "-10"

Constraints:
-107 <= num <= 107
*/

/* 
Understanding the Problem Statement:
- We are given an integer `num`.
- Our task is to convert this integer to its representation in base 7.
- Base 7 means that the number is represented using digits 0 through 6, and each digit corresponds to powers of 7 (7^0, 7^1, etc).
- The result should be a string that represents the number in base 7.
- If the number is negative, we must include a minus sign.

What is being asked:
- The objective is to convert the given number to its base 7 representation.
- We need to consider both positive and negative numbers.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - Integer `num`.

2. Expected Output:
   - A string that represents the number in base 7.

3. Output return type:
   - String.

4. Time complexity expectations:
   - The time complexity is O(log(num)) for converting the number to base 7, since we keep dividing the number by 7 until it becomes 0.
   
5. Constraints:
   - The number `num` is between -107 and 107, inclusive. This is a relatively small range, so performance is not a major concern for this problem.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a base conversion problem where we need to convert a number into its base 7 equivalent.
   - We need to repeatedly divide the number by 7 and store the remainders.
   - The remainders correspond to the digits of the base 7 number, starting from the least significant digit (rightmost).
   
2. Destructuring:
   - Convert `num` to base 7 by dividing it by 7.
   - Keep track of the remainders and build the base 7 string from right to left.
   - Handle the sign of the number separately to ensure that a negative number returns the correct result.

3. Conversational solution into smaller subtask:
   - Subtask 1: Handle the negative sign if `num` is negative.
   - Subtask 2: Repeatedly divide `num` by 7 and collect the remainders to construct the base 7 number.
   - Subtask 3: Return the final base 7 representation as a string.
   
*/

/* 
Conversional Solution into Subtasks:
1. If the number is negative, mark it and work with its positive counterpart.
2. Use a loop to divide the absolute value of the number by 7 and collect the remainders.
3. Once the loop ends, reverse the collected digits and prepend a negative sign if the number was negative.
4. Return the resulting string.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Handle negative numbers by checking if `num` is negative and working with its absolute value.
2. Perform the base conversion by dividing `num` by 7 and collecting remainders.
3. Construct the final string by reversing the collected digits and adding a negative sign if necessary.

*/

/* 
Java Code according to conversational subtasks.
*/

public class Base7Conversion {

    // Function to convert the number to base 7
    public static String convertToBase7(int num) {
        // If the number is 0, return "0" immediately
        if (num == 0) {
            return "0";
        }

        // Check if the number is negative
        boolean isNegative = num < 0;
        num = Math.abs(num);  // Work with the absolute value of the number

        StringBuilder result = new StringBuilder();

        // Perform the base conversion by dividing the number by 7
        while (num > 0) {
            int remainder = num % 7;
            result.append(remainder);
            num /= 7;
        }

        // If the number was negative, prepend a minus sign
        if (isNegative) {
            result.append('-');
        }

        // Reverse the result since we are appending digits from least significant to most
        return result.reverse().toString();
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        System.out.println(convertToBase7(100));  // Expected output: "202"

        // Test case 2
        System.out.println(convertToBase7(-7));   // Expected output: "-10"
        
        // Test case 3 (edge case for 0)
        System.out.println(convertToBase7(0));    // Expected output: "0"
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - The time complexity is O(log(num)) because we divide `num` by 7 in each iteration, 
    and the number of iterations is proportional to the logarithm of `num` in base 7.
  - Therefore, the time complexity is logarithmic with respect to the input number.

- Space Complexity:
  - The space complexity is O(log(num)) due to the use of the StringBuilder to store the digits of the result, 
    which grows with the logarithmic number of digits in base 7.

*/

/* 
“for” loop or “while” loop walkthrough with every iteration with given input.
*/

/* 
In this solution, we used a `while` loop to repeatedly divide the number by 7.
For input `num = 100`:
1. First iteration: 100 % 7 = 2, result = "2", num = 100 / 7 = 14
2. Second iteration: 14 % 7 = 0, result = "20", num = 14 / 7 = 2
3. Third iteration: 2 % 7 = 2, result = "202", num = 2 / 7 = 0

The loop stops when `num` becomes 0. We then reverse the string to get "202".
*/

 /* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

 /* 
For input:
num = 100
1. The number is positive, so we proceed with its absolute value (100).
2. In the first iteration, 100 % 7 = 2 (append "2"), and num = 14.
3. In the second iteration, 14 % 7 = 0 (append "0"), and num = 2.
4. In the third iteration, 2 % 7 = 2 (append "2"), and num = 0. Now the loop ends.
5. The result is "202". No negative sign is needed since the number is positive.
6. The final result is "202".

For input:
num = -7
1. The number is negative, so we work with the absolute value (7) and remember to prepend a negative sign at the end.
2. In the first iteration, 7 % 7 = 0 (append "0"), and num = 1.
3. In the second iteration, 1 % 7 = 1 (append "1"), and num = 0. Now the loop ends.
4. The result is "10". We prepend the minus sign because the number was negative.
5. The final result is "-10".
*/
