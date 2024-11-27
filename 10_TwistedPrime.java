--------------------------------------------------- WITH TEMPLATE --------------------------------------------------------------------
/* 
Question Section:
Given a number N, check whether N is a Twisted Prime number or not.
A number is called a Twisted Prime if it is a prime and its reverse is also a prime.

Example 1:
Input: N = 97
Output: 1
Explanation: 97 is a prime number, and its reverse, 79, is also a prime number. Thus, 97 is a twisted prime.

Example 2:
Input: N = 43
Output: 0
Explanation: 43 is a prime number, but its reverse, 34, is not a prime. Thus, 43 is not a twisted prime.
*/

/* 
Understanding the Problem Statement:
We need to determine if a given number N is a Twisted Prime. A Twisted Prime has two characteristics:
1. The number itself is a prime number.
2. Its reverse is also a prime number.

We need to return:
- 1 if N is a Twisted Prime.
- 0 if N is not a Twisted Prime.

To check whether a number is prime, we can use an efficient primality test. We also need to reverse the number and check if the reversed number is also prime.

*/

 /* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A single integer N.
2. Expected Output:
   - 1 if N is a Twisted Prime.
   - 0 if N is not a Twisted Prime.
3. Output return type:
   - An integer: 1 for Twisted Prime, 0 for non-Twisted Prime.
4. Explanation of Time complexity expectations:
   - We need to check both the primality of N and the primality of its reverse.
   - The expected time complexity is O(sqrt(N)) for checking the primality of N and its reverse.
   - Given that N can be as large as 10^9, we need an efficient primality check to ensure the solution runs within time limits.
5. Explanation of given Constraints:
   - 1 <= N <= 10^9, meaning the input number can be very large, so we need efficient algorithms for both primality testing and number reversal.
*/

 /* 
Thinking Solution for the Problem Statement:
1. Identification:
   - This problem involves checking if a number is a prime and if its reverse is also prime.
   - We need two functions: one for checking primality and another to reverse the number.

2. Destructuring:
   - Step 1: Check if N is prime.
   - Step 2: Reverse N and check if the reversed number is prime.
   - Step 3: If both N and its reverse are prime, return 1 (Twisted Prime).
   - Step 4: Otherwise, return 0 (not a Twisted Prime).

3. Conversional solution into smaller subtask:
   - Subtask 1: Implement a function to check whether a number is prime.
   - Subtask 2: Implement a function to reverse the digits of a number.
   - Subtask 3: Check if both N and its reversed value are prime and return the appropriate result.

*/

 /* 
Conversional Solution into Subtasks:
1. Prime checking function: 
   - Use a primality test function that checks if a number N is divisible by any integer up to √N.
2. Reverse the number:
   - Reverse the digits of N and convert the reversed digits back into an integer.
3. Check both N and the reversed number for primality:
   - If both are prime, return 1; otherwise, return 0.

*/

 /* 
Subtasks of Conversional Solution into Code:
1. Create a `isPrime(int num)` function to check if a number is prime.
2. Create a `reverseNumber(int num)` function to reverse the digits of the number.
3. In the `isTwistedPrime(int N)` function:
   - Check if both N and its reverse are prime numbers.
   - If both are prime, return 1 (Twisted Prime).
   - Otherwise, return 0 (not a Twisted Prime).
*/

public class TwistedPrime {

    /* 
    Function to check if a number is prime.
    A prime number is only divisible by 1 and itself.
    */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        if (num == 2) {
            return true; // 2 is a prime number
        }
        if (num % 2 == 0) {
            return false; // even numbers other than 2 are not prime
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false; // num is divisible by i, so it's not prime
            }
        }
        return true; // num is prime if no divisor is found
    }

    /* 
    Function to reverse the digits of a number.
    */
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + (num % 10); // Add last digit of num to reversed
            num /= 10; // Remove last digit from num
        }
        return reversed;
    }

    /* 
    Function to check if a number is a Twisted Prime.
    A number is a Twisted Prime if both the number and its reverse are prime numbers.
    */
    public static int isTwistedPrime(int N) {
        // Step 1: Check if N is prime
        if (isPrime(N)) {
            // Step 2: Reverse N and check if the reverse is prime
            int reversedN = reverseNumber(N);
            if (isPrime(reversedN)) {
                return 1; // Both N and its reverse are prime, so it's a Twisted Prime
            }
        }
        return 0; // Either N is not prime or its reverse is not prime
    }
    public static void main(String[] args) {
        // Testing with some sample inputs
        System.out.println(isTwistedPrime(97)); // Output: 1
        System.out.println(isTwistedPrime(43)); // Output: 0
    }
}
  /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - The `isPrime()` function runs in O(sqrt(N)) time, as we check divisibility from 2 up to √N.
    - The `reverseNumber()` function runs in O(d), where d is the number of digits in N, which is O(log N).
    - So, the total time complexity is O(sqrt(N)) for prime checking and O(log N) for reversing the number.
    - Therefore, the time complexity for the solution is O(sqrt(N) + log N).

    Space Complexity:
    - The space complexity is O(1), as we use a constant amount of extra space for variables.
    */

    /* 
    Code Walkthrough:
    Let's walk through the example with N = 97:

    1. Call `isTwistedPrime(97)`:
        - `isPrime(97)` returns true, since 97 is a prime number.
        - Reverse 97 to get 79.
        - `isPrime(79)` returns true, since 79 is also a prime number.
    2. Since both 97 and 79 are prime, return 1 (Twisted Prime).

    Let's walk through the example with N = 43:

    1. Call `isTwistedPrime(43)`:
        - `isPrime(43)` returns true, since 43 is a prime number.
        - Reverse 43 to get 34.
        - `isPrime(34)` returns false, since 34 is not a prime number.
    2. Since the reverse of 43 is not prime, return 0 (not a Twisted Prime).
    */

/*
Explanation:

1.`isPrime(int num)`: This function checks whether a number is prime by testing divisibility from 2 up to the square root of the number. 
                           It returns `true` if the number is prime and `false` otherwise.

2. `reverseNumber(int num)`: This function reverses the digits of a number by repeatedly taking the last digit and appending it to the reversed result.

3. `isTwistedPrime(int N)`: This function checks whether a number N is a Twisted Prime. 
                                It first checks if N is prime. Then, it reverses N and checks if the reversed number is also prime. 
                                If both are prime, it returns 1, indicating that N is a Twisted Prime. Otherwise, it returns 0.

4. Time Complexity:
   - The time complexity for checking if a number is prime is O(sqrt(N)).
   - The time complexity for reversing the number is O(log N), as the number of digits in N is proportional to log N.
   - Thus, the total time complexity for checking a Twisted Prime is O(sqrt(N) + log N), which is efficient for N up to 10^9.

5. Space Complexity: The space complexity is O(1), as we use a constant amount of space for storing intermediate results and variables.

This solution should work efficiently within the problem constraints.
*?
--------------------------------------------------- WITHOUT TEMPLATE --------------------------------------------------------------------
/* 
Question:
Given a number N. Check whether N is a Twisted Prime number or not.
Note: A number is called Twisted Prime if it is a prime and its reverse is also a prime.

Example 1:
Input: N = 97
Output: 1
Explanation: 97 is a prime number. Its reverse 79 is also a prime number.
Thus 97 is a twisted Prime and so, the answer is 1.

Example 2:
Input: N = 43
Output: 0
Explanation: 43 is a prime number but its reverse 34 is not a prime. 
So, 43 is not a twisted prime and thus, the answer is 0.

Your Task: You don't need to read input or print anything.
Your task is to complete the function isTwistedPrime() 
which takes a number N as input parameter and returns 1 if it is a twisted prime number. Otherwise, it returns 0.
*/

/* 
Input-output explanation section:
Input: N is an integer number between 1 and 10^9 (inclusive).
Output: If the number is a twisted prime, return 1, else return 0.
Example 1: 
Input: N = 97
Output: 1
Explanation: 97 is a prime number, and its reverse (79) is also a prime number.
Example 2:
Input: N = 43
Output: 0
Explanation: 43 is a prime number, but its reverse (34) is not a prime number.
*/

/* 
Constraints explanation section:
- The value of N lies between 1 and 10^9, so the solution should be efficient enough to handle such large numbers.
- Checking for prime numbers should ideally be done in O(sqrt(N)) time to ensure efficiency.
- The reversal of the number N should also be efficient to avoid unnecessary overhead.
*/

/* 
Relatable analogy or real-world scenario section:
Imagine you’re at a party and you want to find the "coolest" person. 
- First, you check if the person is cool (prime check). 
- If they are, you then check if their "mirror image" (reverse of their number) is also cool.
- If both are cool, this person is a "Twisted Cool" person (Twisted Prime).
- If either the person or their reverse isn't cool, they're not considered "Twisted Cool."

To check if a number is a Twisted Prime:
1. Check if N is a prime number.
2. Reverse the number and check if the reversed number is also prime.
3. If both are prime, the number is a Twisted Prime.
4. Otherwise, it’s not.

Let's break down the task:
1. Prime Check: We check if a number is prime by checking divisibility from 2 to sqrt(N).
2. Reversal of the number: We reverse the digits of the number and perform a prime check on the reversed number.
*/

/* 
Relatable analogy Java code step by step section:
1. Prime Checking: 
    - We need a method to check if a number is prime. This is done by checking divisibility of the number from 2 to sqrt(N).
2. Reverse the Number: 
    - We reverse the number by converting it to a string, reversing the string, and converting it back to an integer.
3. Twisted Prime Check: 
    - First, we check if the original number is prime.
    - Then, we reverse the number and check if the reversed number is prime.
4. Return the Result: 
    - If both numbers are prime, we return 1 (indicating it’s a twisted prime), else we return 0.
*/

/* 
Time and Space Complexity Explanation section:
- Time Complexity: The time complexity for checking if a number N is prime is O(sqrt(N)). 
   Reversing the number takes O(log(N)) due to the number of digits. Therefore, the total time complexity is O(sqrt(N) + log(N)).
- Space Complexity: The space complexity is O(1) because we are using a constant amount of space,
   only storing a few variables for checks.

In the worst case, we would check up to sqrt(N) for primality, 
and since we are working with numbers up to 10^9, this is efficient enough.
*/

/* 
FOR loop walkthrough with every iteration with given input,
Steps in the code:
1. Prime Check Function (isPrime):
   - We check if N is divisible by any number from 2 to sqrt(N). If it is, then it is not a prime.
   - If no such divisor is found, it is prime.

2. Reverse Function (reverseNumber):
   - We convert the number to a string, reverse it, and convert it back to an integer.
   
3. Main Function (isTwistedPrime):
   - First, check if the number N is prime.
   - Reverse N and check if the reversed number is also prime.
   - Return 1 if both numbers are prime, otherwise return 0.

Let's consider input N = 97:
1. We check if 97 is prime. It is prime.
2. We reverse 97 to get 79 and check if 79 is prime. It is prime.
3. Both numbers are prime, so the result is 1.

For N = 43:
1. We check if 43 is prime. It is prime.
2. We reverse 43 to get 34 and check if 34 is prime. It is not prime.
3. Since 34 is not prime, the result is 0.

*/

/* Complete Java Code Implementation */

// WITHOUT EXPLANATION
public class TwistedPrime 
{
    /* Function to check if a number is prime */
    public static boolean isPrime(int N) 
    {
        if (N <= 1) return false;
        for (int i = 2; i * i <= N; i++) 
        {
            if (N % i == 0) return false;
        }
        return true;
    }

    /* Function to reverse the number */
    public static int reverseNumber(int N) 
    {
        int reversed = 0;
        while (N > 0) 
        {
            reversed = reversed * 10 + (N % 10);
            N /= 10;
        }
        return reversed;
    }

    /* Function to check if the number is Twisted Prime */
    public static int isTwistedPrime(int N) 
    {
        // Check if N is prime and its reverse is also prime
        if (isPrime(N) && isPrime(reverseNumber(N))) 
        {
            return 1;
        } else 
        {
            return 0;
        }
    }

    public static void main(String[] args) 
    {
        // Test with sample input N = 97 (Hardcoded input)
        int N = 97;
        System.out.println(isTwistedPrime(N));  // Output should be 1

        // Test with another sample input N = 43 (Hardcoded input)
        N = 43;
        System.out.println(isTwistedPrime(N));  // Output should be 0
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------

// WITH EXPLANATION
public class TwistedPrime 
{
    /* Function to check if a number is prime */
    public static boolean isPrime(int N) 
    {
        if (N <= 1) return false;
        /* 
         The line of code `if (N <= 1) return false;` is part of the prime checking logic and serves a very specific purpose. Let's break it down:
         Purpose of `if (N <= 1) return false;`
        
        - Why does it check `N <= 1`?
          - In mathematics, prime numbers are defined as numbers greater than 1 that are only divisible by 1 and themselves.
          - The prime number sequence starts from 2, which is the smallest prime number. 
          - Numbers like 0 and 1 are not prime because:
            - 0 is divisible by every number, so it doesn't meet the definition of a prime.
            - 1 is only divisible by itself and doesn’t satisfy the condition of having exactly two distinct positive divisors (1 and the number itself).
        
        - How does this line help in prime checking?
          - This line is a quick check to immediately rule out numbers less than or equal to 1.
          - If `N` is less than or equal to 1 (like 0 or 1), it directly returns `false` because those numbers aren't prime.
          - This saves unnecessary computation for numbers that can never be prime.
        
         Example:
        
        - If you input `N = 0` or `N = 1`, the function will immediately return `false` without proceeding to check for divisibility, saving time.
        - If you input `N = 2` or any higher number, 
           the function will continue and check whether the number is divisible by any other number (using the rest of the logic in the prime check function).
        
         Let's see the entire prime check function for better clarity:
    
        public static boolean isPrime(int N) {
            // Step 1: Handle edge cases
            if (N <= 1) return false;  // Numbers <= 1 are not prime
        
            // Step 2: Check divisibility from 2 to sqrt(N)
            for (int i = 2; i * i <= N; i++) {  // Only go up to sqrt(N)
                if (N % i == 0) return false;  // If divisible by any number, it's not prime
            }
        
            // Step 3: If no divisor found, N is prime
            return true;
        }

         Step-by-Step Explanation of `isPrime`:
        
        1. Edge case handling:
           - `if (N <= 1) return false;`: If `N` is less than or equal to 1, immediately return `false`, as 0 and 1 are not prime.
        
        2. Divisibility Check:
           - We start checking divisibility from 2, up to the square root of `N`. 
              This is because any factor larger than the square root would have a corresponding smaller factor already checked.
           - If `N % i == 0` at any point, it means `N` is divisible by `i`, so it's not a prime.
        
        3. Prime Confirmation:
           - If no divisors are found from 2 to sqrt(N), `N` is a prime number, and the function returns `true`.
        
         Time Complexity:
        - The prime checking function runs in O(sqrt(N)) time, as it checks divisibility from 2 to sqrt(N).
        
         Space Complexity:
        - The space complexity is O(1) because we're using a constant amount of space (just a few variables for `i` and `N`).
        
         In Summary:
        The line `if (N <= 1) return false;` is essential for quickly filtering out non-prime numbers
        and improving the performance of the `isPrime` function by avoiding unnecessary checks for values like 0 and 1.
         */
        
        for (int i = 2; i * i <= N; i++) 
        {
            if (N % i == 0) return false;
            /* 
            how to find Square root - https://www.youtube.com/watch?v=6AzDU6RuocQ
            Certainly! Let's break down how the prime-checking logic works using the loop `for (int i = 2; i * i <= N; i++)` when the input is `N = 97`.
            
            Step-by-Step Explanation for `N = 97`
            The code we are analyzing is:
            
            for (int i = 2; i * i <= N; i++) {
                if (N % i == 0) return false;
            }
            return true;
            
             Initial Setup:
            - `N = 97`
            - We are checking if 97 is divisible by any integer starting from 2, up to the square root of `97`.
            
            The condition in the `for` loop is `i * i <= N`, 
            which means the loop will run as long as `i` squared is less than or equal to `N`. 
            In other words, we only need to check divisibility for `i` values from 2 up to the integer part of `sqrt(97)` 
            (which is approximately `9.8`, so we will check up to `i = 9`).
            
             Here's how the loop will iterate:
            
            1. First iteration (`i = 2`):
               - `i * i = 2 * 2 = 4`, which is less than `97`, so the loop continues.
               - Check: `97 % 2 == 0` → 97 is not divisible by 2 (since 97 is odd), so the loop moves to the next iteration.
               
            2. Second iteration (`i = 3`):
               - `i * i = 3 * 3 = 9`, which is still less than `97`, so the loop continues.
               - Check: `97 % 3 == 0` → 97 is not divisible by 3 (97 ÷ 3 ≈ 32.33), so the loop moves to the next iteration.
            
            3. Third iteration (`i = 4`):
               - `i * i = 4 * 4 = 16`, which is still less than `97`, so the loop continues.
               - Check: `97 % 4 == 0` → 97 is not divisible by 4 (97 ÷ 4 ≈ 24.25), so the loop moves to the next iteration.
            
            4. Fourth iteration (`i = 5`):
               - `i * i = 5 * 5 = 25`, which is still less than `97`, so the loop continues.
               - Check: `97 % 5 == 0` → 97 is not divisible by 5 (97 ÷ 5 = 19.4), so the loop moves to the next iteration.
            
            5. Fifth iteration (`i = 6`):
               - `i * i = 6 * 6 = 36`, which is still less than `97`, so the loop continues.
               - Check: `97 % 6 == 0` → 97 is not divisible by 6 (97 ÷ 6 ≈ 16.17), so the loop moves to the next iteration.
            
            6. Sixth iteration (`i = 7`):
               - `i * i = 7 * 7 = 49`, which is still less than `97`, so the loop continues.
               - Check: `97 % 7 == 0` → 97 is not divisible by 7 (97 ÷ 7 ≈ 13.857), so the loop moves to the next iteration.
            
            7. Seventh iteration (`i = 8`):
               - `i * i = 8 * 8 = 64`, which is still less than `97`, so the loop continues.
               - Check: `97 % 8 == 0` → 97 is not divisible by 8 (97 ÷ 8 = 12.125), so the loop moves to the next iteration.
            
            8. Eighth iteration (`i = 9`):
               - `i * i = 9 * 9 = 81`, which is still less than `97`, so the loop continues.
               - Check: `97 % 9 == 0` → 97 is not divisible by 9 (97 ÷ 9 ≈ 10.78), so the loop moves to the next iteration.
            
            9. Termination of the loop:
               - The next value of `i` would be 10, but `i * i = 10 * 10 = 100`, which is greater than 97, so the loop stops.
            
             Conclusion:
            Since 97 is not divisible by any number from 2 through 9, the loop terminates without returning `false`.
            
            Thus, the function will return `true`, indicating that `97` is a prime number.
            
             Final Summary of Iterations:
            
            | Iteration | i   | i * i | N % i == 0 | Explanation                   |
            |-----------|-----|-------|------------|-------------------------------|
            | 1         | 2   | 4     | No         | 97 is not divisible by 2      |
            | 2         | 3   | 9     | No         | 97 is not divisible by 3      |
            | 3         | 4   | 16    | No         | 97 is not divisible by 4      |
            | 4         | 5   | 25    | No         | 97 is not divisible by 5      |
            | 5         | 6   | 36    | No         | 97 is not divisible by 6      |
            | 6         | 7   | 49    | No         | 97 is not divisible by 7      |
            | 7         | 8   | 64    | No         | 97 is not divisible by 8      |
            | 8         | 9   | 81    | No         | 97 is not divisible by 9      |
            
            Since none of the conditions are true, the function concludes that `97` is a prime number and returns `true`.
            
            Summary of Output:
            - For `N = 97`, the output is `true`, indicating that `97` is a prime number. 
           */
        }
        return true;
    }

    /* Function to reverse the number */
    public static int reverseNumber(int N) 
    {
        // this variable will hold the reversed of the given input number 
        // that's why we created this variable
        int reversed = 0;
        while (N > 0) 
        {
            reversed = reversed * 10 + (N % 10);
            N /= 10;
            /* 
        Certainly! Let's break down the process of reversing the number using the following code:
        ----------------------
        int reversed = 0;
        while (N > 0) {
            reversed = reversed * 10 + (N % 10); // Get the last digit of N and add it to reversed
            N /= 10; // Remove the last digit from N
        }
        return reversed;
        ---------------------
         Purpose of the Code:
        This code reverses a given integer `N`. 
        It repeatedly extracts the last digit of `N` and adds it to the reversed number. 
        It continues this process until all digits of `N` are processed.
        
         Let's explain the process step by step for `N = 97`:
        - Initial Setup:
          - `N = 97`
          - `reversed = 0` (We start with an empty reversed number).
        —
        
         Step-by-Step Execution:
        1. First Iteration:
           - Current value of N: `97`
           - Step 1 (`reversed = reversed * 10 + (N % 10)`):
             - `N % 10 = 97 % 10 = 7` (The last digit of 97 is `7`) uses the Modulo operator. 
             - `reversed = 0 * 10 + 7 = 7` (We now have the reversed number as `7`).
           - Step 2 (`N /= 10`): uses division operator.
             - `N = 97 / 10 = 9` (We remove the last digit, so now `N` becomes 9).
        
        2. Second Iteration:
           - Current value of N: `9`
           - Step 1 (`reversed = reversed * 10 + (N % 10)`):
             - `N % 10 = 9 % 10 = 9` (The last digit of 9 is `9`) uses the Modulo operator.
             - `reversed = 7 * 10 + 9 = 79` (Now the reversed number becomes `79`).
           - Step 2 (`N /= 10`): uses division operator.
             - `N = 9 / 10 = 0` (We remove the last digit, so now `N` becomes 0).
        —
        
         Exit the loop:
        - The condition for the loop is `while (N > 0)`.
           Since `N = 0` after the second iteration, the loop exits.
          
         Final Value:
        - The value of `reversed` is `79`.
        
         Explanation of the Code Logic:
        - In the first iteration, the last digit of `97` (which is `7`) is added to `reversed`.
        - In the second iteration, the last digit of the remaining number `9` (which is `9`) is added to `reversed`, which already has `7` from the previous iteration.
        - After both iterations, the value of `reversed` becomes `79`, which is the reverse of `97`.
        
         Summary:
        For the input `N = 97`, after running this code, the output of `reversed` will be `79`.
        
         Visual Breakdown:
        
        | Iteration | N   | Last Digit (N % 10) | Reversed Calculation       | Reversed | N after division |
        |-----------|-----|---------------------|---------------------------|----------|------------------|
        | 1         | 97  | 7                   | 0 * 10 + 7 = 7            | 7        | 9                |
        | 2         | 9   | 9                   | 7 * 10 + 9 = 79           | 79       | 0                |
        
        After the loop ends, `reversed = 79`, which is the reverse of the original number `97`.
        */
        }
        return reversed;
    }

    /* Function to check if the number is Twisted Prime */
    public static int isTwistedPrime(int N) 
    {
        // Check if N is prime and its reverse is also prime
        if (isPrime(N) && isPrime(reverseNumber(N))) 
        {
            return 1;
        } else 
        {
            return 0;
        }
        /* 
            Let's walk through the logic of the code you've provided, 
            which checks if a number \( N \) is both a prime number and Its reverse is also a prime number. We will use the input `N = 97` for this explanation.
            
            The code in question:
            
            ```
            if (isPrime(N) && isPrime(reverseNumber(N))) {
                return 1;
            } else {
                return 0;
            }
            ```
            This code snippet is evaluating whether a number \( N \) is a Twisted Prime. 
            A Twisted Prime is a number that is prime and whose reverse is also prime.
            
            Let's break it down step by step, using \( N = 97 \) as the input.
            
             Step 1: Check if \( N \) is Prime (`isPrime(N)`)
            The first condition checks if \( N \) itself is a prime number. To do this, it calls the function `isPrime(N)`.
            
            # Prime Check for \( N = 97 \):
            - The function `isPrime(97)` will check whether `97` is divisible by any integer between 2 and \( \sqrt{97} \), 
               which is approximately 9.8 (so we check divisibility for integers from 2 to 9).
              
            - Iterations:
              1. \( 97 \mod 2 = 1 \) (97 is not divisible by 2).
              2. \( 97 \mod 3 = 1 \) (97 is not divisible by 3).
              3. \( 97 \mod 4 = 1 \) (97 is not divisible by 4).
              4. \( 97 \mod 5 = 2 \) (97 is not divisible by 5).
              5. \( 97 \mod 6 = 1 \) (97 is not divisible by 6).
              6. \( 97 \mod 7 = 6 \) (97 is not divisible by 7).
              7. \( 97 \mod 8 = 1 \) (97 is not divisible by 8).
              8. \( 97 \mod 9 = 7 \) (97 is not divisible by 9).
              
            - Since 97 is not divisible by any number between 2 and 9, we conclude that 97 is a prime number.
            Thus, `isPrime(97)` returns `true`.
            
             Step 2: Reverse the Number (`reverseNumber(N)`)
            Next, the code calls the function `reverseNumber(N)` to get the reverse of \( N \).
            
            # Reverse the number \( N = 97 \):
            - The reverse of `97` is `79`. This is achieved by extracting the last digit of `97` (which is `7`), 
               moving it to the front, and then extracting the next digit (`9`).
            - So, `reverseNumber(97)` returns `79`.
            
             Step 3: Check if the Reverse is Prime (`isPrime(reverseNumber(N))`)
            Now, the code checks if the reverse of \( N \) (which is `79`) is also a prime number. It calls `isPrime(79)`.
            
            # Prime Check for \( N = 79 \):
            - The function `isPrime(79)` will check whether `79` is divisible by any integer between 2 and \( \sqrt{79} \), 
               which is approximately 8.9 (so we check divisibility for integers from 2 to 8).
            
            - Iterations:
              1. \( 79 \mod 2 = 1 \) (79 is not divisible by 2).
              2. \( 79 \mod 3 = 1 \) (79 is not divisible by 3).
              3. \( 79 \mod 4 = 3 \) (79 is not divisible by 4).
              4. \( 79 \mod 5 = 4 \) (79 is not divisible by 5).
              5. \( 79 \mod 6 = 1 \) (79 is not divisible by 6).
              6. \( 79 \mod 7 = 2 \) (79 is not divisible by 7).
              7. \( 79 \mod 8 = 7 \) (79 is not divisible by 8).
            
            - Since 79 is not divisible by any number between 2 and 8, we conclude that 79 is a prime number.
            Thus, `isPrime(79)` returns `true`.
            
             Step 4: Combine the Results
            The overall condition is:
            ```
            if (isPrime(N) && isPrime(reverseNumber(N))) {
                return 1;
            } else {
                return 0;
            }
            ```
            Now, let's combine the results from Steps 1 and 2:
            - `isPrime(97)` is true.
            - `isPrime(79)` is true.
            
            Since both conditions are true, the code executes the block inside the `if` statement:
            
            ```
            return 1;
            ```
            
             Final Output:
            The function will return 1, 
            indicating that `97` is a Twisted Prime because both `97` and its reverse `79` are prime numbers.
            
             Summary:
            For the input `N = 97`:
            - `97` is a prime number.
            - The reverse of `97` is `79`, and `79` is also a prime number.
            - Since both conditions are true, the function returns `1`, indicating that `97` is a Twisted Prime.
             */
    }

    public static void main(String[] args) 
    {
        // Test with sample input N = 97 (Hardcoded input)
        int N = 97;
        System.out.println(isTwistedPrime(N));  // Output should be 1

        // Test with another sample input N = 43 (Hardcoded input)
        N = 43;
        System.out.println(isTwistedPrime(N));  // Output should be 0
    }
}
/* 
Explanation of the code:
1. isPrime Function: 
       This function checks whether a number is prime by trying to divide it by numbers from 2 to sqrt(N). 
        If any number divides it exactly, the function returns false.
2. reverseNumber Function: 
        This function reverses the digits of the number using a while loop.
         It extracts the last digit of N using `N % 10` and adds it to the reversed number. 
         Then, it removes the last digit of N by dividing N by 10.
3. isTwistedPrime Function: 
        This is the main function that checks if the number N is a twisted prime. 
         It first checks if N is prime using `isPrime`. 
         Then, it checks if the reverse of N is also prime by calling `reverseNumber` and checking if the reversed number is prime.
4. Main Method: 
        In the `main` method, we take hard coded integer values for `N` (such as 97 and 43) and print the result of `isTwistedPrime(N)`.

Test the code with an input like 97 and it will output `1` (indicating that 97 is a twisted prime), or try 43, and it will output `0` (since 34 is not a prime).
*/ 

/* 
Time and Space Complexity Explanation:
- Time Complexity: The time complexity of the `isPrime` function is O(sqrt(N)), as we check divisibility from 2 to sqrt(N). 
   Reversing the number takes O(log(N)) because it involves manipulating the digits of N. Thus, the total complexity is O(sqrt(N) + log(N)).
- Space Complexity: The space complexity is O(1) because we only use a few integer variables (no data structures that grow with input size).

*/ 
