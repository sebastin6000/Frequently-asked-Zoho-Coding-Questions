
/* 
Section-1: Question Section
Question:
Given a number N, the task is to print the prime numbers from 1 to N.
A prime number is a number greater than 1 that has no divisors other than 1 and itself. 
Your task is to print all the prime numbers less than or equal to N.

Examples:
Input: N = 10
Output: 2, 3, 5, 7
Explanation: The output “2, 3, 5, 7” for input N = 10 represents the list of prime numbers less than or equal to 10.

Input: N = 5
Output: 2, 3, 5
Explanation: The output “2, 3, 5” for input N = 5 represents the list of prime numbers less than or equal to 5.
*/

/* 
Section-2: Understanding the Problem Statement
The problem requires us to print all prime numbers from 1 to N (inclusive), where N is a positive integer.

Prime numbers are numbers greater than 1 that cannot be divided evenly by any number other than 1 and themselves. 
The task is to identify and print these prime numbers up to a given number N.

What is being asked?
We need to print all prime numbers from 1 to N. The solution needs to be efficient enough to handle large values of N (up to 10^4).

Expected Output:
- A sequence of prime numbers less than or equal to N.
*/

/* 
Section-3: Extracting Information from the Problem Statement
Input:
- N: An integer representing the upper limit up to which prime numbers are to be printed.
Return Type:
- Void, as we are expected to print the prime numbers directly.
Constraints:
1 <= N <= 10^4
Time Complexity:
- We need to find all prime numbers up to N. The expected time complexity should be efficient for large values of N (up to 10^4).
*/

 /* 
Section-4: Thinking Solution for the Problem Statement
To solve the problem, we need to:
1. Identify prime numbers in the range from 1 to N.
2. A simple approach would be checking each number from 2 to N and checking if it has any divisors other than 1 and itself.
3. A more efficient method is the Sieve of Eratosthenes, which marks non-prime numbers in a boolean array. This allows us to efficiently find all primes up to N.

We will implement the Sieve of Eratosthenes, which has a time complexity of O(N log log N), making it suitable for large values of N (up to 10^4).

*/

/* 
Section-5: Input to Output Conversion Steps into Smaller Subtasks
S.No | Subtask Description
1    | Initialize a boolean array of size N+1 to mark numbers as prime or non-prime.
2    | Use the Sieve of Eratosthenes to mark non-prime numbers.
3    | Loop through the array and print the numbers marked as prime.

*/

/* 
Section-6: Input to Output Conversion Subtasks into Code
S.No | Subtask Description                                       | Code Approach
1    | Initialize a boolean array to mark primes and non-primes. | Use a boolean array to mark whether a number is prime or not.
2    | Implement the Sieve of Eratosthenes to mark non-primes.   | Use the sieve algorithm to efficiently mark non-prime numbers.
3    | Loop through the array and print all prime numbers.       | Print numbers marked as prime.

*/

/* 
Section-7: Code Requirement to Complete the Subtasks
- A loop to traverse the range of numbers up to N.
- A boolean array to track prime numbers.
- A sieve algorithm to mark non-prime numbers.
- A loop to print the prime numbers.

*/

/* 
Section-8: Explanation of Approach
1. We initialize a boolean array `isPrime[]` of size N+1, where all entries are initially set to `true`. The value `isPrime[i]` will be `true` if `i` is prime.
2. We set `isPrime[0]` and `isPrime[1]` to `false`, as 0 and 1 are not prime numbers.
3. We start from the first prime number, 2, and mark all its multiples as non-prime (set them to `false`).
4. We continue with the next number that is still marked as `true` and mark all its multiples as non-prime.
5. We repeat the process for numbers up to the square root of N.
6. After marking the non-prime numbers, we simply print all numbers `i` where `isPrime[i]` is `true`.

This approach is efficient with a time complexity of O(N log log N).

*/

/* Section-9: Java Code According to Input to Output Conversion Subtasks */
public class PrimeNumbers {

    // Function to print all prime numbers from 1 to N
    public static void printPrimes(int N) {
        // Step 1: Initialize a boolean array isPrime[] to mark primes
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            isPrime[i] = true; // Assume all numbers are prime initially
        }

        // Step 2: Implement the Sieve of Eratosthenes to mark non-primes
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime numbers
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false; // Mark multiples of i as non-prime
                }
            }
        }
        // Step 3: Print all prime numbers
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Test the function with N = 10
        printPrimes(10); // Output: 2 3 5 7
    }
}
    
/* 
Section-10: Time and Space Complexity Explanation
- Time Complexity: O(N log log N)
The Sieve of Eratosthenes runs in O(N log log N) time, which is efficient for large values of N (up to 10^4).

- Space Complexity: O(N)
We use a boolean array of size N+1 to store the primality of each number up to N.
*/

/* 
Section-11: Explanation of Loops and Iterations
- We have two loops in the code:
1. The outer loop in the Sieve of Eratosthenes runs from 2 to sqrt(N). For each prime number `i`, it marks all multiples of `i` as non-prime.
2. The second loop prints the numbers from 2 to N that are marked as prime in the `isPrime[]` array.

For example, with N = 10:
- We start with i = 2 and mark multiples of 2 as non-prime (4, 6, 8, 10).
- Then we move to i = 3 and mark multiples of 3 as non-prime (6, 9).
- We stop when i reaches sqrt(10).
- Finally, the second loop prints all numbers marked as true in the `isPrime[]` array (2, 3, 5, 7).

Example Walkthrough:
For N = 10:
- The `isPrime[]` array starts as: [true, true, true, true, true, true, true, true, true, true, true].
- After marking non-primes with the sieve, `isPrime[]` becomes: [false, false, true, true, false, true, false, true, false, false, false].
- The final output is: 2 3 5 7.
*/

/* 
Section-12: Complete Code Walkthrough with Example Input
Input: N = 10
1. The `isPrime[]` array is initialized with all values set to `true`, except `isPrime[0]` and `isPrime[1]`.
2. We start with i = 2 and mark its multiples (4, 6, 8, 10) as `false`.
3. Then we move to i = 3 and mark its multiples (6, 9) as `false`.
4. We continue until i reaches sqrt(10).
5. The second loop prints the prime numbers: 2 3 5 7.
*/

/*
Key Concepts:
1. Prime Numbers: Numbers greater than 1 that are divisible only by 1 and themselves.
2. Sieve of Eratosthenes: An efficient algorithm to find all primes up to a number `N` by marking multiples of each prime number starting from 2.
3. Time Complexity: O(N log log N) due to the sieve algorithm, which is efficient for large N (up to 10^4).
4. Space Complexity: O(N)
*/
