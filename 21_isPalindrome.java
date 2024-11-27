/* 
Question Section:
Given an integer, check whether it is a palindrome or not.
A number is a palindrome if it reads the same forwards and backwards, e.g., 121, 555, etc.

Examples:

Input: n = 555
Output: Yes

Input: n = 123
Output: No

Your Task:
You don't need to read or print anything. 
Your task is to complete the function `is_palindrome()` which takes the number as input parameter and returns "Yes" 
if it is a palindrome otherwise returns "No" (Without quotes).
*/

/* 
Understanding the Problem Statement:
- A palindrome number is one that remains the same when reversed. For example:
  - 555 → when reversed, it is still 555, so it is a palindrome.
  - 123 → when reversed, it becomes 321, which is not equal to 123, so it is not a palindrome.
- We are asked to implement a function `is_palindrome()` that checks if a given integer `n` is a palindrome.
- The function should return "Yes" if `n` is a palindrome and "No" otherwise.

What is being asked?
- We need to return a string ("Yes" or "No") based on whether the integer `n` is a palindrome or not.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An integer `n`.

2. Expected Output:
   - A string: "Yes" if `n` is a palindrome, otherwise "No".

3. Output return type:
   - String.

4. Explanation of Time complexity expectations:
   - Time complexity should be O(x), where x is the number of digits in `n`, 
     because we will reverse the number and compare it with the original number.
   
5. Explanation of given Constraints:
   - The given number `n` will be between 1 and 1000, meaning it will have at most 4 digits.
   - The function must efficiently handle this constraint.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification:
   - We need to check if a number reads the same forwards and backwards.
   - A simple approach is to reverse the digits of the number and check if it matches the original number.
   
2. Destructuring:
   - Convert the number to a string to facilitate comparison.
   - Reverse the string and compare it with the original string.

3. Conversional solution into smaller subtask:
   - Subtask 1: Convert the number to a string.
   - Subtask 2: Reverse the string.
   - Subtask 3: Compare the original string and the reversed string.
   - Subtask 4: Return "Yes" if they are the same, otherwise return "No".

*/

/* 
Conversional Solution into Subtasks:
1. Convert the integer into a string representation.
2. Reverse the string.
3. Compare the original string and the reversed string.
4. Return "Yes" if they are equal, otherwise return "No".

*/

/* 
Subtasks of Conversional Solution into Code:
1. Convert the integer to a string.
2. Reverse the string and compare it with the original string.
3. Return "Yes" if the reversed string matches the original string, otherwise return "No".

*/

public class PalindromeNumber {

    /* 
    Function to check if a given number is a palindrome.
    1. Convert the number to a string.
    2. Reverse the string.
    3. Compare the original string and the reversed string.
    4. Return "Yes" if they are the same, otherwise return "No".
    */
    public static String is_palindrome(int n) {
        // Convert the integer to a string
        String original = Integer.toString(n);
        
        // Reverse the string
        String reversed = new StringBuilder(original).reverse().toString();
        
        // Check if the original string is equal to the reversed string
        if (original.equals(reversed)) {
            return "Yes";
        } else {
            return "No";
        }
    }
    public static void main(String[] args) {
        // Test case 1
        int n1 = 555;
        System.out.println(is_palindrome(n1)); // Expected: "Yes"
        
        // Test case 2
        int n2 = 123;
        System.out.println(is_palindrome(n2)); // Expected: "No"
    }
}
    /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - Converting the number to a string takes O(x), where x is the number of digits in the number `n`.
    - Reversing the string also takes O(x).
    - Comparing the original and reversed strings takes O(x).
    - So the overall time complexity is O(x), where x is the number of digits in `n`.

    Space Complexity:
    - The space complexity is O(x) because we are storing the original and reversed string, where x is the number of digits in `n`.
    */

    /* 
    Code Walkthrough:
    Let's walk through the input `n = 555`:
    1. Convert `n` to a string: `"555"`.
    2. Reverse the string: `"555"`.
    3. Compare the original string `"555"` with the reversed string `"555"`.
    4. Since they are the same, return "Yes".

    Let's walk through the input `n = 123`:
    1. Convert `n` to a string: `"123"`.
    2. Reverse the string: `"321"`.
    3. Compare the original string `"123"` with the reversed string `"321"`.
    4. Since they are not the same, return "No".
    */
/*
### Explanation:

1. **`is_palindrome(int n)`**:
   - The function first converts the integer `n` to a string using `Integer.toString(n)`.
   - Then, it reverses the string using `new StringBuilder(original).reverse().toString()`.
   - It compares the original string with the reversed string. If they are the same, the number is a palindrome, and it returns "Yes". 
     Otherwise, it returns "No".

2. **Time and Space Complexity**:
   - **Time Complexity**: O(x), 
     where `x` is the number of digits in the number `n`. 
     The operations of converting the number to a string, reversing the string, 
     and comparing the original and reversed strings all take linear time relative to the number of digits.
     
   - **Space Complexity**: O(x), since we store the original string and the reversed string.

3. **Code Walkthrough**:
   - For `n = 555`: The string representation is `"555"`, and when reversed, it remains `"555"`, so the function returns "Yes".
   - For `n = 123`: The string representation is `"123"`, and when reversed, it becomes `"321"`, so the function returns "No".

### Output:

For the given test cases:
1. `n = 555` → Output: `"Yes"`
2. `n = 123` → Output: `"No"`

*/
