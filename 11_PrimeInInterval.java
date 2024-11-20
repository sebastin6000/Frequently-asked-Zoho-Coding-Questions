/* 
Question: 
Given two numbers a and b as an interval range, the task is to find the prime numbers in between this interval.

Examples: 
Input: a = 1, b = 10
Output: 2, 3, 5, 7

Input: a = 10, b = 20
Output: 11, 13, 17, 19.
*/

/* 
Input-output explanation:
The input consists of two numbers `a` and `b`, which represent the starting and ending values of an interval.
You need to find all prime numbers that lie between these two numbers, inclusive of `a` and `b`.

For example:
- Input: a = 1, b = 10
  Output: 2, 3, 5, 7
  Explanation: The prime numbers between 1 and 10 are 2, 3, 5, and 7.

- Input: a = 10, b = 20
  Output: 11, 13, 17, 19
  Explanation: The prime numbers between 10 and 20 are 11, 13, 17, and 19.
*/

/* 
Constraints explanation:
1. a and b are integers, where a <= b.
2. We need to check for primes in the interval from `a` to `b`.
3. The number `1` is not considered a prime number.
4. The code should efficiently find primes without unnecessarily checking every number.
5. The function should consider edge cases like when `a` and `b` are small or large.

*/

/* 
Relatable analogy or real-world scenario:
Imagine you are at a party with people standing in a line, 
and you need to find out which of them are "prime party guests.
" A "prime party guest" is someone who can only be divided evenly by themselves or the number 1. 

Your task is to go down the line and check each guest (number) one by one.
You don't need to check guests that have already been proven to be "prime" 
(those who can't be divided by any number other than themselves and 1).
You start by checking the first person in the line (the smallest number in the range)
and continue until you reach the last person (the largest number in the range). 
Only the "prime" guests (prime numbers) should be invited to the special prime party. 

Step-by-step:
1. Start at the first guest (the number `a`), and check if they are a "prime guest."
2. Move to the next person (next number) and check if they're also a "prime guest."
3. Repeat the process until you reach the last person (the number `b`).
4. For each person, you check if they are divisible by any number other than themselves and 1.
   If they are, they are not a "prime guest" and you move on to the next one.

By following this method, you can find all the prime guests at the party!

*/

/* 
Relatable analogy Java code step by step:

1. We need to create a function that takes two numbers `a` and `b` as parameters.
2. Inside this function, we'll loop through all numbers in the interval `[a, b]`.
3. For each number, check if it is prime.
4. A number is prime if it is only divisible by 1 and itself. To check this, 
   we'll check divisibility from 2 up to the square root of the number.
5. If the number is prime, we will add it to our result.
6. Once the loop finishes, we print all the prime numbers.

*/
// WITHOUT EXP
public class PrimeInInterval {
  
    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;  // 0 and 1 are not prime
        for (int i = 2; i * i <= n; i++) {  // Check divisibility up to the square root of n
            if (n % i == 0) return false;  // If divisible by any number, not prime
        }
        return true;  // If no divisors found, number is prime
    }

    // Function to find all prime numbers in the given range [a, b]
    public static void findPrimesInRange(int a, int b) {
        // Loop through the numbers in the interval [a, b]
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {  // If the number is prime, print it
                System.out.print(i + " ");
            }
        }
        System.out.println();  // Print a new line after the list of primes
    }

    // Main function to test the logic
    public static void main(String[] args) {
        int a = 1, b = 10;  // Example input
        System.out.print("Prime numbers between " + a + " and " + b + ": ");
        findPrimesInRange(a, b);  // Call the function to find and print primes

        a = 10; b = 20;  // Example input
        System.out.print("Prime numbers between " + a + " and " + b + ": ");
        findPrimesInRange(a, b);  // Call the function to find and print primes
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- For each number in the range `[a, b]`, we check if it's prime.
- Checking if a number is prime takes up to √n iterations (where n is the number being checked).
- So, in the worst case, if we check every number from `a` to `b`, the time complexity will be O((b - a + 1) * √b).

Space Complexity:
- The space complexity is O(1), since we only use a constant amount of extra space (for variables like `i` and the result of the prime check). We don't store any large data structures.

*/

/* 
FOR loop walkthrough with every iteration with the given input, Complete code walkthrough with applying the given input in code:

1. For input a = 1 and b = 10:
   - We start with `i = 1` and check if it's prime. Since 1 is not prime, we move to the next number.
   - For `i = 2`, we check if it's prime. It is, so we print 2.
   - Continue for numbers 3, 4, 5, 6, 7, 8, 9, and 10, checking primality and printing primes (3, 5, 7).
   
2. For input a = 10 and b = 20:
   - We start with `i = 10` and check if it's prime. It isn't, so we move to the next number.
   - For `i = 11`, we check if it's prime. It is, so we print 11.
   - Continue for numbers 12, 13, 14, 15, 16, 17, 18, 19, and 20, checking primality and printing primes (13, 17, 19).

This walkthrough ensures we identify prime numbers efficiently within the given range.

*/
