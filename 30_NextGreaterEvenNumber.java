/* 
Question:
Given a positive integer x. The task is to find the smallest even number e such that e > x and all digits in x and e are the same.
Note: If no possible number exists, return -1.

Examples:

Input: x = 34722641
Output: 34724126
Explanation: Next greater number with the same digits as in the input is 34724126.

Input: x = 111
Output: -1
Explanation: You can't rearrange the digits to get an answer.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ x.size() ≤ 10
*/

/* 
Understanding the Problem Statement:
- The task is to find the smallest even number greater than the given integer `x` that can be formed by rearranging the digits of `x`.
- The result must be an even number, which means the last digit must be an even digit (0, 2, 4, 6, or 8).
- If no such number can be formed, return -1.

What is being asked:
- Given the integer `x`, find the next permutation of `x` that is an even number and greater than `x`. 
- If no such number can be formed, return -1.

This is essentially a problem of finding the "next greater permutation" of the digits of `x` but with the constraint that the next permutation must be an even number.
*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A positive integer `x`.
2. Expected Output:
   - A positive integer which is the next greater permutation of `x` that is even, or -1 if no such number exists.
3. Output return type:
   - Integer (either the next permutation or -1).
4. Time complexity expectations:
   - The time complexity is expected to be O(logn), where n is the size of `x` (since the maximum size of `x` is 10).
5. Constraints:
   - The number of digits in `x` can range from 1 to 10.
   - We need to handle integers in the range of up to 10 digits.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a "next greater permutation" problem but with the added constraint that the number must be even. 
      We need to find the next permutation of the digits of `x` such that it is greater than `x` and ends in an even digit.
   
2. Destructuring:
   - We can think of the solution as:
     - Find the next greater permutation of digits.
     - Check if the last digit is even.
     - If the number is valid (greater than `x` and ends in an even digit), return it.
     - If no valid number can be formed, return -1.

3. Conversional solution into smaller subtask:
   - Subtask 1: Convert the integer `x` into a list of digits to work with.
   - Subtask 2: Find the next greater permutation of these digits.
   - Subtask 3: Ensure the number is even (last digit is one of 0, 2, 4, 6, 8).
   - Subtask 4: If no valid number is found, return -1.
*/

/* 
Conversional Solution into Subtasks:
1. Convert the integer into a list of digits.
2. Find the next permutation of the digits.
3. Check if the permutation ends with an even digit.
4. If it's valid, return the number formed by the permutation.
5. If no valid number exists, return -1.
*/

/* 
Subtasks of Conversional Solution into Code:
1. Convert the integer into a list of digits.
2. Implement the logic to find the next permutation of the digits.
3. Check if the resulting permutation ends in an even digit.
4. Return the resulting number if valid, otherwise -1.
*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class NextGreaterEvenPermutation {

    public static int findNextGreaterEvenPermutation(int x) {
        // Step 1: Convert the integer into a list of digits
        String str = Integer.toString(x);
        char[] digits = str.toCharArray();
        int n = digits.length;

        // Step 2: Find the next permutation
        int i = n - 1;
        while (i > 0 && digits[i - 1] >= digits[i]) {
            i--;
        }

        if (i == 0) {
            // No greater permutation is possible
            return -1;
        }

        int j = n - 1;
        while (digits[j] <= digits[i - 1]) {
            j--;
        }

        // Swap the digits[i-1] and digits[j]
        char temp = digits[i - 1];
        digits[i - 1] = digits[j];
        digits[j] = temp;

        // Reverse the sequence after i-1
        reverse(digits, i, n - 1);

        // Step 3: Check if the last digit is even
        if (digits[n - 1] % 2 != 0) {
            // If the last digit is not even, try to find the next possible even number
            for (int k = n - 2; k >= 0; k--) {
                if (digits[k] % 2 == 0) {
                    // Swap digits[k] with digits[n-1]
                    temp = digits[k];
                    digits[k] = digits[n - 1];
                    digits[n - 1] = temp;
                    break;
                }
            }
        }

        // If the last digit is still not even, return -1
        if (digits[n - 1] % 2 != 0) {
            return -1;
        }

        // Step 4: Convert the char array back to an integer and return it
        return Integer.parseInt(new String(digits));
    }

    // Helper method to reverse the portion of the array
    private static void reverse(char[] digits, int start, int end) {
        while (start < end) {
            char temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        int x = 34722641;
        int result = findNextGreaterEvenPermutation(x);
        System.out.println(result);  // Expected output: 34724126

        int y = 111;
        result = findNextGreaterEvenPermutation(y);
        System.out.println(result);  // Expected output: -1
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity: O(n), where n is the number of digits in `x`. The main operations involve finding the next permutation, 
  which requires scanning the digits and reversing portions of the array, both of which take linear time.
- Space Complexity: O(n), due to the space required to store the digits in an array.

This solution works efficiently even for the upper constraint where `x` has 10 digits because all operations are linear with respect to the size of the number.

*/

/* 
“while” loop walkthrough with every iteration with given input
*/

/*
Walkthrough of the "while" loop used to find the next permutation:
- We start from the rightmost digit and try to find the first pair of digits where the previous digit is smaller than the current digit.
- Once we find such a pair, we swap them and reverse the remaining digits to the right of that position.
- For example, with the input `34722641`:
    - We find that 1 is smaller than 4, so we swap them, resulting in `34724126`.
    - This is the next permutation that is greater than the original number.

Walkthrough of the "for" loop used to check for the even number:
- After obtaining the next permutation, we check if the last digit is even.
- If it is not, we swap it with the first even digit found in the remainder of the number.
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

 /*
Step-by-step walkthrough with input 34722641:

- Convert `x = 34722641` to a list of digits: `['3', '4', '7', '2', '2', '6', '4', '1']`.
- Start finding the next greater permutation:
  - Compare 1 with 4, 4 with 6, 6 with 2, 2 with 2... until we find 1 is smaller than 4.
  - Swap the digits: `34724126`.
- Check if the last digit 6 is even. It is, so the result is `34724126`.

Step-by-step walkthrough with input 111:

- Convert `x = 111` to a list of digits: `['1', '1', '1']`.
- There are no greater permutations available since all digits are the same.
- Therefore, return -1.
*/
