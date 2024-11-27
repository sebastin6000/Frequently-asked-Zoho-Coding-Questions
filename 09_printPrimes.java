--------------------------------------------------- WITH TEMPLATE --------------------------------------------------------------------
/* 
Question Section:
Given a number N, the task is to print the prime numbers from 1 to N.

Example 1:
Input: N = 10
Output: 2, 3, 5, 7
Explanation : The output “2, 3, 5, 7” for input N = 10 represents the list of the prime numbers less than or equal to 10.

Example 2:
Input: N = 5
Output: 2, 3, 5
Explanation : The output “2, 3, 5” for input N = 5 represents the list of the prime numbers less than or equal to 5.
*/

/* 
Understanding the Problem Statement:
We are tasked with identifying all prime numbers from 1 to N. A prime number is a number greater than 1 that has no divisors other than 1 and itself.

Given an integer N, the objective is to print all prime numbers from 1 to N, in ascending order, separated by spaces.

Prime numbers have the following properties:
- They are greater than 1.
- They are only divisible by 1 and themselves.

We are expected to find and print all primes less than or equal to N efficiently, as N can be quite large (up to 10^6 or more).
*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A single integer N, where N is the upper limit up to which prime numbers are to be found.
2. Expected Output:
   - A list of prime numbers from 1 to N, printed in ascending order, separated by spaces.
3. Output return type:
   - Void (The program prints the results directly and does not return anything).
4. Explanation of Time complexity expectations:
   - We need an efficient solution to find primes up to N.
   - The expected time complexity should be O(N log log N) or better to handle large values of N.
5. Explanation of given Constraints:
   - N will be at least 2 (since the smallest prime is 2).
   - The algorithm should be optimized to handle N up to 10^6 or larger.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification:
   - This is a classic problem of generating all prime numbers up to N.
   - A brute force solution would check each number individually for primality, but this is inefficient for large N.

2. Destructuring:
   - We need to identify which numbers from 2 to N are prime.
   - A prime number is only divisible by 1 and itself.
   - We can use the **Sieve of Eratosthenes** algorithm to efficiently identify all primes up to N.

3. Conversional Solution into smaller subtask:
   - Step 1: Implement the Sieve of Eratosthenes algorithm.
   - Step 2: Use the sieve to mark non-prime numbers.
   - Step 3: Print the remaining numbers that are marked as prime.
   - The Sieve of Eratosthenes is optimal for this task with a time complexity of O(N log log N), 
     which is much faster than checking each number individually.

*/

/* 
Conversional Solution into Subtasks:
1. Initialize a boolean array to mark prime numbers.
2. For each number starting from 2, mark its multiples as non-prime.
3. After marking the non-prime numbers, print the numbers that are still marked as prime.
*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a boolean array `isPrime` to store whether each number from 0 to N is prime.
2. Set `isPrime[0]` and `isPrime[1]` to false because 0 and 1 are not prime.
3. Use the Sieve of Eratosthenes to mark all multiples of each number starting from 2 as non-prime.
4. Finally, print all the indices of the array that are still marked as true (those are the prime numbers).
*/

public class PrimeNumbers {

    /* 
    This function prints all prime numbers from 1 to N using the Sieve of Eratosthenes.
    */
    public static void printPrimes(int N) {
        // Step 1: Create a boolean array to mark prime numbers
        boolean[] isPrime = new boolean[N + 1];
        
        // Step 2: Initialize the array; assume all numbers are prime
        for (int i = 0; i <= N; i++) {
            isPrime[i] = true;
        }
        
        // Step 3: 0 and 1 are not prime numbers
        isPrime[0] = isPrime[1] = false;

        // Step 4: Implement the Sieve of Eratosthenes
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Step 5: Print all prime numbers
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        // Testing with some sample inputs
        printPrimes(10); // Output: 2 3 5 7
        System.out.println();
        printPrimes(5);  // Output: 2 3 5
    }
}
 /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - The Sieve of Eratosthenes algorithm runs in O(N log log N). This is because for each prime number `p`, 
       we mark all of its multiples as non-prime, and the total number of such operations grows much slower than N.
    
    Space Complexity:
    - We use a boolean array of size N+1 to track whether each number is prime, so the space complexity is O(N).
    */

    /* 
    Code Walkthrough:
    Given input N = 10:

    1. Initialize the `isPrime[]` array of size 11, with all values set to true.
    2. Set `isPrime[0] = false` and `isPrime[1] = false` because 0 and 1 are not prime.
    3. Use the Sieve of Eratosthenes to mark multiples of each number as non-prime:
       - For i = 2, mark multiples of 2 (i.e., 4, 6, 8, 10) as non-prime.
       - For i = 3, mark multiples of 3 (i.e., 9) as non-prime.
    4. After processing, print the numbers that remain marked as prime: 2, 3, 5, and 7.

    Output: 2 3 5 7
    */
--------------------------------------------------- WITHOUT TEMPLATE --------------------------------------------------------------------
/* 
Question: Given a number N, the task is to print the prime numbers from 1 to N.
Examples: 

Input: N = 10
Output: 2, 3, 5, 7
Explanation: The output "2, 3, 5, 7" for input N = 10 represents the list of prime numbers less than or equal to 10. 

Input: N = 5
Output: 2, 3, 5
Explanation: The output "2, 3, 5" for input N = 5 represents the list of prime numbers less than or equal to 5.
*/

/* 
Input-output explanation:

The task is to print all the prime numbers from 1 to a given number N.
- If N = 10, we should output the prime numbers less than or equal to 10: 2, 3, 5, and 7.
- If N = 5, we should output the prime numbers less than or equal to 5: 2, 3, and 5.
*/

/* 
Constraints explanation:

- N is a positive integer.
- We need to ensure that the solution efficiently handles values of N up to large numbers (e.g., 10^6 or higher).
- Time and space complexity should be considered for optimal performance, avoiding brute-force checks for each number.
*/

/* 
Relatable analogy or real-world scenario:

Imagine you're hosting a party, and you've invited all the numbers from 1 to N. But, you're only allowing numbers that are "special" — numbers that can't be divided evenly by anyone except for 1 and themselves. These are your "prime" numbers! You have to go through each number one by one, and for each number, check if it is divisible by any number other than 1 and itself. If it isn't, you can invite it to the party. 

In simpler terms:
1. The number 1 isn’t prime because it only divides by itself.
2. The number 2 is prime because it can only be divided by 1 and 2.
3. Numbers like 4 or 6 are not prime because they can be divided by numbers other than 1 and themselves (e.g., 4 is divisible by 2).
4. If a number passes the "prime check," it gets invited to the party (added to the list of primes).

We need to repeat this process until we’ve checked all numbers up to N.
*/

/* 
Relatable analogy Java code step by step:

1. We'll first take the number N as input, the limit up to which we need to find prime numbers.
2. We'll create a loop to check each number from 2 to N.
3. For each number, we will check if it can be divided by any number other than 1 and itself. If it can, it's not prime.
4. If a number is prime (it can't be divided by any number except 1 and itself), we'll add it to our list.
5. Finally, we'll print out all the prime numbers.

Here’s the breakdown of the Java code:
1. Start by reading the input number N.
2. Use a loop to check numbers from 2 to N.
3. For each number, check if it's divisible by any number from 2 to the square root of the number.
4. If no divisors are found, mark the number as prime.
5. After checking all numbers, print the primes.
*/

/* 
Time and Space Complexity Explanation:

- **Time Complexity**: The time complexity is O(N * sqrt(N)) because for each number up to N, we check divisibility up to the square root of that number.
   - Checking divisibility up to the square root reduces the number of checks.
   - For example, to check if 30 is prime, we only check divisibility from 2 to √30 (about 5.5), not all numbers up to 30.
   - This makes it much faster than checking divisibility for every number up to N.

- **Space Complexity**: The space complexity is O(N), since we need to store the list of prime numbers up to N.
   - If N is large, we may store many primes, but the space usage is proportional to N.
*/

/* 
FOR loop walkthrough with every iteration with given input, Complete code walkthrough with applying the given input in code and explanation:

Let’s walk through the code step by step for N = 10:

1. Input: N = 10
2. We need to check numbers from 2 to 10.
3. For number 2:
   - We check if 2 is divisible by any number from 2 to √2 (no numbers to check), so 2 is prime.
4. For number 3:
   - We check if 3 is divisible by any number from 2 to √3 (no divisors), so 3 is prime.
5. For number 4:
   - We check divisibility by numbers from 2 to √4. 4 is divisible by 2, so 4 is not prime.
6. For number 5:
   - We check if 5 is divisible by numbers from 2 to √5 (no divisors), so 5 is prime.
7. For number 6:
   - We check divisibility by 2 and 3. 6 is divisible by 2 and 3, so 6 is not prime.
8. For number 7:
   - We check divisibility by 2 and 3. 7 is not divisible by any, so 7 is prime.
9. For number 8:
   - We check divisibility by 2. 8 is divisible by 2, so 8 is not prime.
10. For number 9:
    - We check divisibility by 2 and 3. 9 is divisible by 3, so 9 is not prime.
11. For number 10:
    - We check divisibility by 2 and 3. 10 is divisible by 2, so 10 is not prime.
12. Output: 2, 3, 5, 7 (prime numbers from 1 to 10).

Now, let's see the complete code implementation.
*/

 // Complete code walkthrough with applying the given input in code and explanation:

// WITHOUT EXPLANATION
public class PrimeNumbers
{
    // Step 1: Create a function to print prime numbers up to N
    public static void printPrimes(int N) 
   {
        // Step 2: Loop through numbers from 2 to N
        for (int i = 2; i <= N; i++)
        {
            boolean isPrime = true; // Assume the number is prime
            // Step 3: Check if the current number i is divisible by 
           // any number(the input given number is 10 so we have to check from 2 to the input number) i am right?
            // from 2 to sqrt(i)
            for (int j = 2; j * j <= i; j++)    
            {
                if (i % j == 0)
                {
                    isPrime = false; // If i is divisible by j, it's not prime
                    break;
                }
            }
            // Step 4: If the number is prime, print it
            if (isPrime)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // To move to the next line after printing all primes
    }

    public static void main(String[] args)
    {
        // Sample inputs
        int N1 = 10; // First sample input
        int N2 = 5; // Second sample input

        // Step 3: Call the printPrimes function to print primes up to N
        System.out.print("Prime numbers from 1 to " + N1 + ": ");
        printPrimes(N1); // Test with N1

        System.out.print("Prime numbers from 1 to " + N2 + ": ");
        printPrimes(N2); // Test with N2
    }
}

// ------------------------------------------------------------------------------------------------------------

// WITH EXPLANATION OF CODE 
public class PrimeNumbers 
{
  // Step 1: Create a function to print prime numbers up to N
    public static void printPrimes(int N)
   {
        // Step 2: Loop through numbers from 2 to N
        // The outer loop starts with i = 2 (since 1 is not prime) and goes up to N.
        // The purpose of this loop is to check each number from 2 to N to determine whether it's prime.
        for (int i = 2; i <= N; i++) 
        {
            boolean isPrime = true; // Assume the number is prime
            
            // Step 3: Check if the current number i is divisible by any number from 2 to sqrt(i)
            for (int j = 2; j * j <= i; j++)
            {
                if (i % j == 0) 
                {
                    isPrime = false; // If i is divisible by j, it's not prime
                    break;
                }
                /* 
               
               how the inner loop checks divisibility and how the condition `j * j <= i` works for each value of `i` from `2` to `N = 10`.
               
               Let's walk through each iteration, 
               showing how the inner loop works and how `j * j <= i` 
               helps determine whether to continue checking divisibility or skip further checks.
               
               ### Problem Recap:
               We are trying to print all prime numbers from `1` to `N` (where `N = 10` in this case). 
               The inner loop checks for divisibility of the current number `i` (in the outer loop) by numbers `j` starting from `2` up to `√i`.
               
               ### Breakdown of Each Iteration for `N = 10`:
               
               Let's walk through the outer loop (`i = 2` to `10`) and the inner loop (`j = 2` to `√i`) for each value of `i`.
               
               ### Iteration 1: `i = 2`
               - Outer Loop: `i = 2`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `2` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 2`, `j * j <= 2`, so `j = 2` is checked:
                   - `2 * 2 = 4`, and `4 <= 2` is false, so the inner loop doesn't run.
                 - Result: No divisors found, so `isPrime` remains `true`, and `2` is printed.
               Output: `2`
               
               ---
               ### Iteration 2: `i = 3`
               - Outer Loop: `i = 3`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `3` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 3`, `j * j <= 3`, so `j = 2` is checked:
                   - `2 * 2 = 4`, and `4 <= 3` is false, so the inner loop doesn't run.
                 - Result: No divisors found, so `isPrime` remains `true`, and `3` is printed.
               Output: `3`
               
               ---
               ### Iteration 3: `i = 4`
               - Outer Loop: `i = 4`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `4` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 4`, `j * j <= 4`, so `j = 2` is checked:
                   - `2 * 2 = 4`, and `4 <= 4` is true, so we check if `4 % 2 == 0`.
                   - `4 % 2 == 0`, so `isPrime = false`, and we break the inner loop.
                 - Result: Since `isPrime` is `false`, `4` is not printed.
               Output: (No output for `i = 4`)
               
               ---
               ### Iteration 4: `i = 5`
               - Outer Loop: `i = 5`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `5` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 5`, `j * j <= 5`, so `j = 2` is checked:
                   - `2 * 2 = 4`, and `4 <= 5` is true, so we check if `5 % 2 == 0`.
                   - `5 % 2 != 0`, so we continue with the next value of `j`.
                 - The next value for `j` is `3`, and we check the condition `j * j <= 5`:
                   - `3 * 3 = 9`, and `9 <= 5` is false, so the inner loop stops.
                 - Result: No divisors found, so `isPrime` remains `true`, and `5` is printed.
               Output: `5`
               
               ---
               ### Iteration 5: `i = 6`
               - Outer Loop: `i = 6`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `6` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 6`, `j * j <= 6`, so `j = 2` is checked:
                   - `2 * 2 = 4`, and `4 <= 6` is true, so we check if `6 % 2 == 0`.
                   - `6 % 2 == 0`, so `isPrime = false`, and we break the inner loop.
                 - Result: Since `isPrime` is `false`, `6` is not printed.
               Output: (No output for `i = 6`)
               
               ---
               ### Iteration 6: `i = 7`
               - Outer Loop: `i = 7`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `7` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 7`, `j * j <= 7`, so `j = 2` is checked:
                   - `2 * 2 = 4`, and `4 <= 7` is true, so we check if `7 % 2 == 0`.
                   - `7 % 2 != 0`, so we continue with the next value of `j`.
                 - The next value for `j` is `3`, and we check the condition `j * j <= 7`:
                   - `3 * 3 = 9`, and `9 <= 7` is false, so the inner loop stops.
                 - Result: No divisors found, so `isPrime` remains `true`, and `7` is printed.
               Output: `7`
               
               ---
               ### Iteration 7: `i = 8`
               - Outer Loop: `i = 8`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `8` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 8`, `j * j <= 8`, so `j = 2` is checked:
                   - `2 * 2 = 4`, and `4 <= 8` is true, so we check if `8 % 2 == 0`.
                   - `8 % 2 == 0`, so `isPrime = false`, and we break the inner loop.
                 - Result: Since `isPrime` is `false`, `8` is not printed.
               Output: (No output for `i = 8`)
               
               ---
               ### Iteration 8: `i = 9`
               - Outer Loop: `i = 9`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `9` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 9`, `j * j <= 9`, so `j = 2` is checked:
                   - `2 *
               
                2 = 4`, and `4 <= 9` is true, so we check if `9 % 2 == 0`.
                   - `9 % 2 != 0`, so we continue with the next value of `j`.
                 - The next value for `j` is `3`, and we check the condition `j * j <= 9`:
                   - `3 * 3 = 9`, and `9 <= 9` is true, so we check if `9 % 3 == 0`.
                   - `9 % 3 == 0`, so `isPrime = false`, and we break the inner loop.
                 - Result: Since `isPrime` is `false`, `9` is not printed.
               Output: (No output for `i = 9`)
               
               ---
               ### Iteration 9: `i = 10`
               - Outer Loop: `i = 10`
               - Initial value of `isPrime`: `true`
               - Inner Loop: Check divisibility of `10` by `j` starting from `2`:
                 - The condition for the inner loop is `j * j <= i`. For `i = 10`, `j * j <= 10`, so `j = 2` is checked:
                   - `2 * 2 = 4`, and `4 <= 10` is true, so we check if `10 % 2 == 0`.
                   - `10 % 2 == 0`, so `isPrime = false`, and we break the inner loop.
                 - Result: Since `isPrime` is `false`, `10` is not printed.
               Output: (No output for `i = 10`)
               
               ---
               ### Final Output:
               
               Prime numbers from 1 to 10: 2 3 5 7
               
               ### Summary:
               - In each iteration, the inner loop checks divisibility of `i` by numbers `j` starting from `2` up to `√i`. 
                 If a divisor is found, `isPrime` is set to `false`, and we break out of the loop.
               - If no divisors are found (i.e., `isPrime` remains `true`), the number `i` is printed as a prime number.
               */
            }
            
            // Step 4: If the number is prime, print it
            if (isPrime) 
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        /* 
        The line System.out.println(); 
        is used to print a newline after all the prime numbers are printed. Without this line, 
        after printing all the prime numbers on the same line, the cursor would stay at the end of the line, 
        and if you print anything later, it would continue from the same line.

        The System.out.println(); ensures that the output is formatted properly. For example, 
        if you run this program multiple times or have other print statements afterward, 
        the newline guarantees the output stays clean and properly formatted.
        */
    }
    
    public static void main(String[] args)
   {
        // Sample inputs
        int N1 = 10;  // First sample input
        int N2 = 5;   // Second sample input

        // Step 3: Call the printPrimes function to print primes up to N
        System.out.print("Prime numbers from 1 to " + N1 + ": ");
        printPrimes(N1);  // Test with N1
        
        System.out.print("Prime numbers from 1 to " + N2 + ": ");
        printPrimes(N2);  // Test with N2
    }
}
