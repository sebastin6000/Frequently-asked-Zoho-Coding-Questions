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
// WITHOUT EXPLANATION:
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
----------------------------------
// WITH EXPLANATION
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
        /* Let's explain how the `for` loop will look in both functions 
        (`isPrime` and `findPrimesInRange`) with each iteration for the given input, `a = 1` and `b = 10`.
        ---
         Function 1: `isPrime(n)`
        
        The function `isPrime(n)` checks whether a number `n` is prime by checking 
        if it can be divided by any number between `2` and `sqrt(n)`. 
        Here is the breakdown of how the `for` loop inside the `isPrime(n)` function works during each iteration:
        
         Input: `n = 1 to 10` (we will call `isPrime(n)` for each number in the range)
        
        1. Iteration 1: `n = 1`
           - The `isPrime(1)` function is called.
           - Check: The first condition `if (n <= 1)` is true, so the function immediately returns `false`.
           - No further iterations inside the loop, as the function returns early.
           
        2. Iteration 2: `n = 2`
           - The `isPrime(2)` function is called.
           - Check: The first condition `if (n <= 1)` is false.
           - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(2) ≈ 1.41`.
             - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 2`) is false, so the loop doesn't run.
             - Since no divisors are found, the function returns `true`, indicating 2 is prime.
        
        3. Iteration 3: `n = 3`
           - The `isPrime(3)` function is called.
           - Check: The first condition `if (n <= 1)` is false.
           - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(3) ≈ 1.73`.
             - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 3`) is true, so the loop executes.
             - The loop checks if `3 % 2 == 0`. Since `3 % 2 = 1`, it's not divisible by 2.
             - Since no divisors are found, the function returns `true`, indicating 3 is prime.
        
        4. Iteration 4: `n = 4`
           - The `isPrime(4)` function is called.
           - Check: The first condition `if (n <= 1)` is false.
           - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(4) = 2`.
             - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 4`) is true, so the loop executes.
             - The loop checks if `4 % 2 == 0`. Since `4 % 2 = 0`, it is divisible by 2.
             - The function immediately returns `false`, indicating 4 is not prime.
        
        5. Iteration 5: `n = 5`
           - The `isPrime(5)` function is called.
           - Check: The first condition `if (n <= 1)` is false.
           - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(5) ≈ 2.23`.
             - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 5`) is true, so the loop executes.
             - The loop checks if `5 % 2 == 0`. Since `5 % 2 = 1`, it's not divisible by 2.
             - For `i = 3`: The condition `i * i <= n` (`3 * 3 <= 5`) is false, so the loop terminates.
             - Since no divisors are found, the function returns `true`, indicating 5 is prime.
        
        6. Iteration 6: `n = 6`
           - The `isPrime(6)` function is called.
           - Check: The first condition `if (n <= 1)` is false.
           - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(6) ≈ 2.45`.
             - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 6`) is true, so the loop executes.
             - The loop checks if `6 % 2 == 0`. Since `6 % 2 = 0`, it's divisible by 2.
             - The function immediately returns `false`, indicating 6 is not prime.
        
        7. Iteration 7: `n = 7`
           - The `isPrime(7)` function is called.
           - Check: The first condition `if (n <= 1)` is false.
           - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(7) ≈ 2.65`.
             - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 7`) is true, so the loop executes.
             - The loop checks if `7 % 2 == 0`. Since `7 % 2 = 1`, it's not divisible by 2.
             - For `i = 3`: The condition `i * i <= n` (`3 * 3 <= 7`) is false, so the loop terminates.
             - Since no divisors are found, the function returns `true`, indicating 7 is prime.
        
        8. Iteration 8: `n = 8`
           - The `isPrime(8)` function is called.
           - Check: The first condition `if (n <= 1)` is false.
           - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(8) ≈ 2.83`.
             - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 8`) is true, so the loop executes.
             - The loop checks if `8 % 2 == 0`. Since `8 % 2 = 0`, it's divisible by 2.
             - The function immediately returns `false`, indicating 8 is not prime.
        
        9. Iteration 9: `n = 9`
           - The `isPrime(9)` function is called.
           - Check: The first condition `if (n <= 1)` is false.
           - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(9) = 3`.
             - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 9`) is true, so the loop executes.
             - The loop checks if `9 % 2 == 0`. Since `9 % 2 = 1`, it's not divisible by 2.
             - For `i = 3`: The condition `i * i <= n` (`3 * 3 <= 9`) is true, so the loop executes.
             - The loop checks if `9 % 3 == 0`. Since `9 % 3 = 0`, it's divisible by 3.
             - The function immediately returns `false`, indicating 9 is not prime.
        
        10. Iteration 10: `n = 10`
            - The `isPrime(10)` function is called.
            - Check: The first condition `if (n <= 1)` is false.
            - The `for` loop will check divisibility for values of `i` starting from 2 up to `sqrt(10) ≈ 3.16`.
              - For `i = 2`: The condition `i * i <= n` (`2 * 2 <= 10`) is true, so the loop executes.
              - The loop checks if `10 % 2 == 0`. Since `10 % 2 = 0`, it's divisible by 2.
              - The function immediately returns `false`, indicating 10 is not prime.
        
        ---
        
         Function 2: `findPrimesInRange(a, b)`
        
        The `findPrimesInRange(a, b)` function iterates over the range `[a, b]` and calls the `isPrime(n)` function
        to check if each number is prime. If the number is prime, it prints it.
        
        Input: `a = 1` and `b = 10`
        
        1. Iteration 1: `i = 1`
           - `isPrime(1)` is called (as explained earlier, 1 is not prime).
           - Output: Nothing is printed.
        
        2. Iteration 2: `i = 2`
           - `isPrime(2)` is called (as explained earlier, 2 is prime).
           - Output: `2` is printed.
        
        3. Iteration 3: `
        
        i = 3`
           - `isPrime(3)` is called (as explained earlier, 3 is prime).
           - Output: `3` is printed.
        
        4. Iteration 4: `i = 4`
           - `isPrime(4)` is called (as explained earlier, 4 is not prime).
           - Output: Nothing is printed.
        
        5. Iteration 5: `i = 5`
           - `isPrime(5)` is called (as explained earlier, 5 is prime).
           - Output: `5` is printed.
        
        6. Iteration 6: `i = 6`
           - `isPrime(6)` is called (as explained earlier, 6 is not prime).
           - Output: Nothing is printed.
        
        7. Iteration 7: `i = 7`
           - `isPrime(7)` is called (as explained earlier, 7 is prime).
           - Output: `7` is printed.
        
        8. Iteration 8: `i = 8`
           - `isPrime(8)` is called (as explained earlier, 8 is not prime).
           - Output: Nothing is printed.
        
        9. Iteration 9: `i = 9`
           - `isPrime(9)` is called (as explained earlier, 9 is not prime).
           - Output: Nothing is printed.
        
        10. Iteration 10: `i = 10`
            - `isPrime(10)` is called (as explained earlier, 10 is not prime).
            - Output: Nothing is printed.
        
        ---
        
         Summary:
        The `for` loop in both functions iterates through the numbers in the range `[a, b]` 
        and checks for primality using the logic described above. 
        The prime numbers printed by `findPrimesInRange(a, b)` for the input `a = 1` and `b = 10` are: `2, 3, 5, 7`.
        
        
 */
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
