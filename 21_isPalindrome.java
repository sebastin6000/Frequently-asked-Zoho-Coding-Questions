/* 
https://www.geeksforgeeks.org/problems/palindrome0746/1

Given an integer, check whether it is a palindrome or not.
Note : Strings which read the same backwards as forwards , eg - MADAM, MOM etc.

Example 1:
Input: n = 555
Output: Yes

Example 2:
Input: n = 123
Output: No
 

Your Task:
You don't need to read or print anything. 
Your task is to complete the function is_palindrome() which takes the number as input parameter 
and returns "Yes" if it is palindrome otherwise returns "No"(Without quotes).
 

Expected Time Complexity: O(x)
Expected Space Complexity: O(x) where x is number of digits in n.
 

Constraints:
1 <= n <= 1000
----------------------------------------------------------------------------------------------------------------------------------------
*/
/*
The question asks you to determine if a given integer is a palindrome or not. 
A palindrome is a number (or a word) that reads the same forwards as it does backwards.

 Problem Breakdown:
1. Input: A positive integer `n`.
2. Output: 
   - If `n` is a palindrome, return the string `"Yes"`.
   - If `n` is not a palindrome, return the string `"No"`.

 Example 1:
- Input: `n = 555`
- Output: `"Yes"` because the number `555` reads the same forwards and backwards.

 Example 2:
- Input: `n = 123`
- Output: `"No"` because the number `123` reads differently forwards (`123`) and backwards (`321`).
----------------------------------------------------------------------------------------------------------------------------------------
*/

/* 
2.Extracting Information from the Problem Statement:
 1. Input Data Type:
   - The input is an integer (`n`), which is a positive number. 
   - Specifically, the integer is constrained by `1 <= n <= 1000`. This means the number will be between 1 and 1000 (inclusive).
   
   Input data type: Integer (`n`).

 2. Expected Output:
   - The output is a string that indicates whether the input number is a palindrome or not.
     - If the number is a palindrome, the output is `"Yes"`.
     - If the number is not a palindrome, the output is `"No"`.
   
   Expected Output: String (`"Yes"` or `"No"`).

 3. Output Return Type:
   - The function should return a string.
     - The return values are either `"Yes"` or `"No"`.
   
   Output return type: String.

 4. Understanding Time Complexity Expectations:
   - The time complexity is expected to be O(x), where `x` is the number of digits in the input number `n`. 
     - This is because to check if the number is a palindrome, we may need to reverse the digits or compare them, 
        which takes time proportional to the number of digits.
     - Since `n` can have at most 4 digits (as `n <= 1000`), this operation is efficient and manageable within the constraint.

   Time Complexity: O(x), where `x` is the number of digits in `n`.

 5. Understanding the Constraints:
   - The input number `n` is guaranteed to be in the range `1 <= n <= 1000`.
     - This means the input number will always have at least 1 digit and at most 4 digits.
     - Therefore, you don't need to worry about extremely large numbers, and the algorithm's complexity is manageable.
   
   Constraints:
   - `1 <= n <= 1000` — this limits the number of digits in `n` to a maximum of 4 digits.
----------------------------------------------------------------------------------------------------------------------------------------
*/
/* 
3.Thinking Solution for the Problem Statement:
3.1 Identification Part: Identify the Type of Problem - Recognize patterns

3.2 Destructuring:
    Destructure the given problem statement into simple words to get the intution for conversional solution by asking how.
1. Convert the number to a string:
   - By converting the number to a string, 
     we can access each digit individually and compare them from front to back.
   
2. Reverse the string:
   - We can easily reverse a string in most programming languages. 
     For example, in Python, you can use slicing to reverse a string: `str[::-1]`.

3. Compare the original string and the reversed string:
   - If the two strings are equal, the number is a palindrome.

4. Return the Result:
   - If the comparison is true, return `"Yes"`.
   - Otherwise, return `"No"`.


3.3 Conversional solution into smaller subtask :
 Subtask 1: Convert the Number to a String  
 Subtask 2: Reverse the String  
 Subtask 3: Compare the Original String with the Reversed String  
 Subtask 4: Return the Result  

*/
/* 
4.Conversional Solution into Code:
Convert the integer to a string:

To avoid using built-in methods like String.valueOf(), we can extract each digit from the integer using mathematical operations.
Reverse the number:

We'll reverse the number by extracting the digits and constructing the reversed number from the last digit to the first.
Compare the original and reversed numbers:

We compare the reversed number with the original number. If they are equal, the number is a palindrome.
Return the result:

If the comparison is true, return "Yes", otherwise return "No".
*/

public class Palindrome {

    // Step 1: Function to check if the number is a palindrome
    public static String isPalindrome(int n) {
        int originalNumber = n; // Store the original number for later comparison
        int reversedNumber = 0; // Variable to store the reversed number

        // Step 2: Reverse the number manually
        while (n > 0) {
            int lastDigit = n % 10; // Get the last digit
            reversedNumber = reversedNumber * 10 + lastDigit; // Append the digit to reversedNumber
            n = n / 10; // Remove the last digit from the original number
        }

        // Step 3: Compare the original number with the reversed number
        if (originalNumber == reversedNumber) {
            // Step 4: Return "Yes" if the numbers match
            return "Yes";
        } else {
            // Step 4: Return "No" if the numbers do not match
            return "No";
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Example test cases
        System.out.println(isPalindrome(555));  // Output: Yes
        System.out.println(isPalindrome(123));  // Output: No
    }
}
/* 
Explanation of the Java Code:
1. Convert the number to a string (Manually):
    Instead of using String.valueOf() or any other built-in function, 
    we break down the integer into individual digits using modulus and division:
    n % 10 gives us the last digit of the number.
    n = n / 10 removes the last digit, reducing the number for the next iteration.

2. Reverse the number manually:
    We construct the reversed number by taking the last digit of n (obtained by n % 10), 
    appending it to reversedNumber after multiplying reversedNumber by 10, and then reducing n by dividing it by 10.
  
3. Compare the original and reversed numbers:
    After reversing the number, we compare the reversed number with the original number. 
    If they are the same, then the number is a palindrome.

4. Return the result:
If the comparison is true, we return "Yes", meaning the number is a palindrome.
If the comparison is false, we return "No", meaning the number is not a palindrome.

Example Walkthrough:
Test Case 1: n = 555
Original number: 555
Reversing process:
Last digit: 5, so reversedNumber = 5, remaining number n = 55
Last digit: 5, so reversedNumber = 55, remaining number n = 5
Last digit: 5, so reversedNumber = 555, remaining number n = 0

Comparison: originalNumber = 555, reversedNumber = 555
Since both are equal, return "Yes".
Test Case 2: n = 123
Original number: 123

Reversing process:
Last digit: 3, so reversedNumber = 3, remaining number n = 12
Last digit: 2, so reversedNumber = 32, remaining number n = 1
Last digit: 1, so reversedNumber = 321, remaining number n = 0
Comparison: originalNumber = 123, reversedNumber = 321
Since both are not equal, return "No".

Time and Space Complexity:

Time Complexity:
The while loop runs until n becomes 0. 
In each iteration, we reduce the number by one digit (i.e., n / 10), 
so the number of iterations is proportional to the number of digits in n. 
Hence, the time complexity is O(d), where d is the number of digits in the number.
In the worst case (for the number 1000), d = 4, so this is a very efficient solution.

Space Complexity:
The space complexity is O(1) because we only need a constant amount of extra space to store variables (originalNumber and reversedNumber).
*/
