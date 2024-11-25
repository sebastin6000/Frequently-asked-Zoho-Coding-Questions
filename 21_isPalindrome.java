/* 
-----------------------------
Question Section
-----------------------------
Given an integer, check whether it is a palindrome or not.

Note: Strings which read the same backwards as forwards, e.g. MADAM, MOM etc.

Example 1:
Input: n = 555
Output: Yes

Example 2:
Input: n = 123
Output: No

Your Task:
You don't need to read or print anything. Your task is to complete the function is_palindrome() which takes the number as input parameter and returns "Yes" if it is palindrome otherwise returns "No" (Without quotes).

Expected Time Complexity: O(x)
Expected Space Complexity: O(x) where x is number of digits in n.

Constraints:
1 <= n <= 1000.
*/

/* 
-----------------------------
Understanding the Problem Statement
-----------------------------
The task is to check if a given integer is a palindrome. A number is a palindrome if it reads the same backward as it does forward. For example:
- 555 is a palindrome (reads the same forward and backward).
- 123 is not a palindrome (it is 321 when reversed).

We are required to implement a method is_palindrome() that will return "Yes" if the number is a palindrome, otherwise return "No".
*/

/* 
-----------------------------
Extracting Information from the Problem Statement
-----------------------------
- Input: A single integer n.
- Output: "Yes" if the number is a palindrome, "No" if it is not.
- Time complexity: O(x), where x is the number of digits in n. This is because we are comparing the digits of the number.
- Space complexity: O(x), as we need to store the digits in a string or reverse it.
- Constraints: The integer n will be between 1 and 1000.
*/

/* 
-----------------------------
Thinking Solution for the Problem Statement
-----------------------------
To check if a number is a palindrome:
1. We can convert the integer into a string.
2. Compare the string with its reverse.
3. If both are equal, the number is a palindrome; otherwise, it is not.

Steps:
1. Convert the integer to a string.
2. Reverse the string.
3. Compare the original string with the reversed one.
4. If they are the same, return "Yes", otherwise return "No".
*/

/* 
-----------------------------
Conversional Solution into Subtasks
-----------------------------
S.no | Subtask Description
1    | Convert the integer to a string representation.
2    | Reverse the string.
3    | Compare the original string and the reversed string.
4    | Return "Yes" if they are the same, else return "No".
*/

/* 
-----------------------------
Subtasks of Conversional Solution into Code
-----------------------------
1. Convert the integer to a string using Integer.toString().
2. Reverse the string using StringBuilder.
3. Compare the original string with the reversed string.
4. Return "Yes" if the comparison is true, else "No".
*/

/* 
-----------------------------
Java Code According to Conversational Subtasks
-----------------------------
*/

public class Palindrome {

    // Function to check if a number is a palindrome
    public static String is_palindrome(int n) {
        // Step 1: Convert the integer to a string
        String numStr = Integer.toString(n);
        
        // Step 2: Reverse the string using StringBuilder
        String reversedStr = new StringBuilder(numStr).reverse().toString();
        
        // Step 3: Compare the original string with the reversed string
        if (numStr.equals(reversedStr)) {
            return "Yes";  // If both are the same, return "Yes"
        } else {
            return "No";   // Otherwise, return "No"
        }
    }

    // Main method for testing the function
    public static void main(String[] args) {
        System.out.println(is_palindrome(555));  // Output: Yes
        System.out.println(is_palindrome(123));  // Output: No
    }
}


/* 
-----------------------------
Time and Space Complexity Explanation
-----------------------------
- Time Complexity: O(x), where x is the number of digits in the integer n. This is because we are converting the number to a string, and reversing it, both of which take linear time relative to the number of digits.
- Space Complexity: O(x), because we are storing the string representation of the number and its reversed version.

For example:
For n = 123, there are 3 digits, so the time and space complexity will be O(3).
*/

/* 
-----------------------------
Walkthrough of the "for" loop or "while" loop used in the code
-----------------------------
The code does not explicitly use any "for" or "while" loops. Instead, we use built-in methods from Java's StringBuilder class to reverse the string.

Here's the breakdown:
1. Convert the number to a string: `String numStr = Integer.toString(n);`
2. Reverse the string using StringBuilder: `String reversedStr = new StringBuilder(numStr).reverse().toString();`
3. Compare the original string with the reversed string using `numStr.equals(reversedStr)`.

This is a simple and efficient way to check if the number is a palindrome without the need for explicit loops.
*/


/* 
-----------------------------
Complete Code Walkthrough with Explanation
-----------------------------
Let's go through the code step by step:

1. The function `is_palindrome()` takes an integer n as input.
2. First, the integer is converted into a string using `Integer.toString(n)`.
3. Then, we reverse the string using `new StringBuilder(numStr).reverse().toString()`.
4. We compare the original string with the reversed string using the `.equals()` method.
5. If they are equal, it means the number is a palindrome, so the function returns "Yes".
6. If not, it returns "No".

For example:
If we call `is_palindrome(555)`, the integer 555 will be converted into the string "555", which is the same when reversed. Thus, it will return "Yes".
For `is_palindrome(123)`, the string "123" is not the same as its reverse "321", so the function will return "No".
*/

