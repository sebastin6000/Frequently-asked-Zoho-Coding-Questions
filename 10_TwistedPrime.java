/* 
Question:
Given a number N. Check whether N is a Twisted Prime number or not.
Note: A number is called Twisted Prime if it is a prime and its reverse is also a prime.

Example 1:
Input: N = 97
Output: 1
Explanation: 97 is a prime number. Its reverse 79 is also a prime number. Thus 97 is a twisted Prime and so, answer is 1.

Example 2:
Input: N = 43
Output: 0
Explanation: 43 is a prime number but its reverse 34 is not a prime. So, 43 is not a twisted prime and thus, answer is 0.

Your Task: You don't need to read input or print anything. Your task is to complete the function isTwistedPrime() which takes a number N as input parameter and returns 1 if it is a twisted prime number. Otherwise, it returns 0.
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
1. **Prime Checking**: 
    - We need a method to check if a number is prime. This is done by checking divisibility of the number from 2 to sqrt(N).
2. **Reverse the Number**: 
    - We reverse the number by converting it to a string, reversing the string, and converting it back to an integer.
3. **Twisted Prime Check**: 
    - First, we check if the original number is prime.
    - Then, we reverse the number and check if the reversed number is prime.
4. **Return the Result**: 
    - If both numbers are prime, we return 1 (indicating it’s a twisted prime), else we return 0.
*/

/* 
Time and Space Complexity Explanation section:
- **Time Complexity**: The time complexity for checking if a number N is prime is O(sqrt(N)). Reversing the number takes O(log(N)) due to the number of digits. Therefore, the total time complexity is O(sqrt(N) + log(N)).
- **Space Complexity**: The space complexity is O(1) because we are using a constant amount of space, only storing a few variables for checks.

In the worst case, we would check up to sqrt(N) for primality, and since we are working with numbers up to 10^9, this is efficient enough.
*/

/* 
FOR loop walkthrough with every iteration with given input, Complete code walkthrough with applying the given input in code and explanation has to in simple English because I have to explain the question and approach my friends and this section has to be inside this structure of comments.

Steps in the code:
1. **Prime Check Function (isPrime)**:
   - We check if N is divisible by any number from 2 to sqrt(N). If it is, then it is not a prime.
   - If no such divisor is found, it is prime.

2. **Reverse Function (reverseNumber)**:
   - We convert the number to a string, reverse it, and convert it back to an integer.
   
3. **Main Function (isTwistedPrime)**:
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

public class TwistedPrime {

    /* Function to check if a number is prime */
    public static boolean isPrime(int N) {
        if (N <= 1) return false;
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    /* Function to reverse the number */
    public static int reverseNumber(int N) {
        int reversed = 0;
        while (N > 0) {
            reversed = reversed * 10 + (N % 10);
            N /= 10;
        }
        return reversed;
    }

    /* Function to check if the number is Twisted Prime */
    public static int isTwistedPrime(int N) {
        // Check if N is prime and its reverse is also prime
        if (isPrime(N) && isPrime(reverseNumber(N))) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
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
1. **isPrime Function**: This function checks whether a number is prime by trying to divide it by numbers from 2 to sqrt(N). If any number divides it exactly, the function returns false.
2. **reverseNumber Function**: This function reverses the digits of the number using a while loop. It extracts the last digit of N using `N % 10` and adds it to the reversed number. Then, it removes the last digit of N by dividing N by 10.
3. **isTwistedPrime Function**: This is the main function that checks if the number N is a twisted prime. It first checks if N is prime using `isPrime`. Then, it checks if the reverse of N is also prime by calling `reverseNumber` and checking if the reversed number is prime.
4. **Main Method**: In the `main` method, we take hardcoded integer values for `N` (such as 97 and 43) and print the result of `isTwistedPrime(N)`.

Test the code with an input like 97 and it will output `1` (indicating that 97 is a twisted prime), or try 43, and it will output `0` (since 34 is not a prime).
*/ 

/* 
Time and Space Complexity Explanation:
- **Time Complexity**: The time complexity of the `isPrime` function is O(sqrt(N)), as we check divisibility from 2 to sqrt(N). Reversing the number takes O(log(N)) because it involves manipulating the digits of N. Thus, the total complexity is O(sqrt(N) + log(N)).
- **Space Complexity**: The space complexity is O(1) because we only use a few integer variables (no data structures that grow with input size).

*/ 
