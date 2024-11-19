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

Imagine you're hosting a party, and you've invited all the numbers from 1 to N.
But, you're only allowing numbers that are "special" — numbers that can't be divided evenly by anyone except for 1 and themselves. 
These are your "prime" numbers! You have to go through each number one by one, and for each number, 
check if it is divisible by any number other than 1 and itself. If it isn't, you can invite it to the party. 

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

- Time Complexity: The time complexity is O(N * sqrt(N)) because for each number up to N, we check divisibility up to the square root of that number.
   - Checking divisibility up to the square root reduces the number of checks.
   - For example, to check if 30 is prime, we only check divisibility from 2 to √30 (about 5.5), not all numbers up to 30.
   - This makes it much faster than checking divisibility for every number up to N.

- Space Complexity: The space complexity is O(N), since we need to store the list of prime numbers up to N.
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

public class PrimeNumbers {
    // Step 1: Create a function to print prime numbers up to N
    public static void printPrimes(int N) {
        // Step 2: Loop through numbers from 2 to N
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true; // Assume the number is prime
            
            // Step 3: Check if the current number i is divisible by any number from 2 to sqrt(i)
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false; // If i is divisible by j, it's not prime
                    break;
                }
            }  
            // Step 4: If the number is prime, print it
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // To move to the next line after printing all primes
    }
    
    public static void main(String[] args) {
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



