/* 
Question: 
Given an array of positive integers, sort the array in decreasing order of the number of factors of each element. 
That is, the element with the highest number of factors should be displayed first. 
If two elements have the same number of factors, they should retain their relative order as in the original array.

Examples: 
Input: {5, 11, 10, 20, 9, 16, 23}
Output: 20 16 10 9 5 11 23
Explanation: 
Number of factors:
- 20 has 6 factors: (1, 2, 4, 5, 10, 20)
- 16 has 5 factors: (1, 2, 4, 8, 16)
- 10 has 4 factors: (1, 2, 5, 10)
- 9 has 3 factors: (1, 3, 9)
- 5, 11, and 23 each have 2 factors: (1, 5), (1, 11), (1, 23)
Thus, the sorted order is 20, 16, 10, 9, 5, 11, 23.

Input: {104, 210, 315, 166, 441, 180}
Output: 180 210 315 441 104 166

*/
/* 
1.Understanding the Problem Statement: 

You are given an array of positive numbers. 
Your task is to sort the numbers in such a way that the number with the most factors (or divisors) comes first. 
If two numbers have the same number of factors, they should appear in the same order as they were originally in the array.

Examples: 
Input: {5, 11, 10, 20, 9, 16, 23}
Output: 20 16 10 9 5 11 23
Explanation: 
Number of factors:
- 20 has 6 factors: (1, 2, 4, 5, 10, 20)
- 16 has 5 factors: (1, 2, 4, 8, 16)
- 10 has 4 factors: (1, 2, 5, 10)
- 9 has 3 factors: (1, 3, 9)
- 5, 11, and 23 each have 2 factors: (1, 5), (1, 11), (1, 23)
Thus, the sorted order is 20, 16, 10, 9, 5, 11, 23.

Input: {104, 210, 315, 166, 441, 180}
Output: 180 210 315 441 104 166
*/

/* 
2.Extracting Information from the Problem Statement:
- Input Data Type: Array of positive integers (int[] or equivalent).
- Expected Output: Sorted array of integers based on the number of factors in decreasing order.
- Output Return Type: Array of integers (int[]).
- Time Complexity Expectations: 
   Approximately O(m * sqrt(n) + m log m) where m is the number of elements and n is the maximum value in the array.
- Understanding the Constraints:
  - Array size: 3 <= arr.size() <= 1000.
   -  Array Size (arr.size()): The number of elements in the input array can range from 3 to 1000.
      This means the array will always have at least 3 elements and no more than 1000 elements.
      Minimum size: 3 elements.
      Maximun size: 1000 elements.

  - Array elements: 1 <= arr[i] <= 1000.
    Array Elements (arr[i]): Each element of the array is a positive integer, 
    and it lies between 1 and 1000. This means every integer in the array will be between 1 and 1000, inclusive. 
    Minimum value: 1.
    Maximum value: 1000.
*/

/* 
3.Thinking Solution for the Problem Statement in conversational Manner:
Step 1: Counting the number of factors for each number in the array
        You need to find how many divisors (or factors) each number in the array has.
        For each number, find all the integers from 1 up to that number (or better, up to its square root) 
        and check if they divide the number without leaving a remainder.

       Why up to square root?
        For each number, if x is a factor, then n/x is also a factor. 
        This means that you only need to check divisibility up to the square root of the number 
        because any factor larger than the square root will already have been found as the "paired" factor.
        For example, for 36:
        We know that 6 * 6 = 36, so we only need to check up to 6.

Step 2: Sorting the numbers based on their factor count
        Once you know how many factors each number has, you need to sort the array.
        Primary sorting criterion: 
         Sort by the number of factors in decreasing order (highest factor count comes first).
        Secondary sorting criterion: 
         If two numbers have the same number of factors, keep them in the same order they appeared in the original list (this is stable sorting).

*/

/* 
4.Conversional Solution into Code:

Subtask 1: Count the Number of Divisors for a Single Number
 - Goal: Write a function that takes a number and returns the count of its divisors.
 - Approach:
    Loop through integers from 1 to the square root of the number (because factors come in pairs).
    For each integer, check if it divides the number evenly. If it does, increment the divisor count.
    Ensure to count both i and n // i as divisors, 
    but avoid double-counting when i equals n // i (i.e., when the number is a perfect square).
            
Subtask 2: Count Divisors for Each Number in an Array
  - Goal: For each number in the array, calculate how many divisors it has by using the function from Subtask 1.
  - Approach:
     Iterate over the array.
     For each number, call the function from Subtask 1 and store the number of divisors along with the number itself.
     
Subtask 3: Sort the Numbers Based on Divisor Count
  - Goal: Sort the numbers based on the number of divisors in descending order.
  - Approach:
     Sort the list of numbers by the divisor count using a custom sorting key (the number of divisors).
     Ensure that if two numbers have the same divisor count, the relative order remains the same (i.e., stable sorting).

Subtask 4: Return the Sorted List
Goal: Extract the sorted numbers from the list of tuples (number, divisor count) and return only the numbers in sorted order.
*/
// WITHOUT MUCH EXPLANATION
import java.util.*;

public class DivisorSorting {

    // Subtask 1: Count divisors for a single number
    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // i is a divisor
                count++;
                if (i != n / i) { // Avoid counting square roots twice
                    count++;
                }
            }
        }
        return count;
    }

    // Subtask 2: Count divisors for each number in the array
public static List<int[]> countDivisorsForAll(int[] arr) {
    List<int[]> numWithFactors = new ArrayList<>();  // Initialize an empty list to store the results

    // Normal for loop to iterate over each element in the array 'arr'
    for (int i = 0; i < arr.length; i++) {
        int num = arr[i];  // Get the current number from the array
        int divisorCount = countDivisors(num);  // Call countDivisors to get the count of divisors
        numWithFactors.add(new int[]{num, divisorCount});  // Add the number and its divisor count as an array to the list
    }

    return numWithFactors;  // Return the list of numbers with their divisor counts
}


    // Subtask 3: Sort the numbers by divisor count (descending)
    public static int[] sortByDivisors(int[] arr) {
        List<int[]> numWithFactors = countDivisorsForAll(arr);

        // Sort the list by number of divisors in descending order (stable sort)
        numWithFactors.sort((a, b) -> Integer.compare(b[1], a[1]));

        // Extract the sorted numbers from the list
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < numWithFactors.size(); i++) {
            sortedArr[i] = numWithFactors.get(i)[0];
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = {36, 12, 15, 6, 28};
        int[] sortedArr = sortByDivisors(arr);
        
        // Print the sorted array
        System.out.println("Sorted array by number of divisors:");
        System.out.println(Arrays.toString(sortedArr));
    }
}
------------------------------------------------------------------------------------------------------------------------------------------
// WITH EXPLANATION
import java.util.*;

public class DivisorSorting {

    // Subtask 1: Count divisors for a single number
    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // i is a divisor
                count++;
                if (i != n / i) { // Avoid counting square roots twice
                    count++;
                }
            }
        }
        return count;
     /* 
     Let's walk through the `countDivisors` method, particularly the for-loop, 
     using a sample input. We'll take `n = 36` as an example and explain how the loop works in each iteration.

     ### Code:
     ```java
     int count = 0;
     for (int i = 1; i <= Math.sqrt(n); i++) {
         if (n % i == 0) { // i is a divisor
             count++;
             if (i != n / i) { // Avoid counting square roots twice
                 count++;
             }
         }
     }
     return count;
     ```

### Understanding the Code:
1. **`Math.sqrt(n)`**: This calculates the square root of `n` and helps us know the range of values we need to check for divisibility. 
   We only need to loop from `1` to the square root of `n` because divisors come in pairs.
2. **`n % i == 0`**: This checks if `i` divides `n` evenly (i.e., `i` is a divisor of `n`).
3. **`i != n / i`**: If `i` and `n / i` are the same (e.g., for perfect squares), we don't want to count it twice.

### Let's take `n = 36` and walk through the loop:

#### Initial Setup:
- **`n = 36`**
- **`Math.sqrt(36) = 6`**, so the loop will run from `i = 1` to `i = 6`.

#### Iterations:

1. **Iteration 1: `i = 1`**
   - `36 % 1 == 0`: Yes, 1 is a divisor of 36.
   - `count++` → `count = 1`
   - `i != n / i` → `1 != 36 / 1` (True, `1 != 36`)
     - So, `count++` → `count = 2`
   - Now, the divisors are `1` and `36`.

2. **Iteration 2: `i = 2`**
   - `36 % 2 == 0`: Yes, 2 is a divisor of 36.
   - `count++` → `count = 3`
   - `i != n / i` → `2 != 36 / 2` (True, `2 != 18`)
     - So, `count++` → `count = 4`
   - Now, the divisors are `1, 36, 2, 18`.

3. **Iteration 3: `i = 3`**
   - `36 % 3 == 0`: Yes, 3 is a divisor of 36.
   - `count++` → `count = 5`
   - `i != n / i` → `3 != 36 / 3` (True, `3 != 12`)
     - So, `count++` → `count = 6`
   - Now, the divisors are `1, 36, 2, 18, 3, 12`.

4. **Iteration 4: `i = 4`**
   - `36 % 4 == 0`: Yes, 4 is a divisor of 36.
   - `count++` → `count = 7`
   - `i != n / i` → `4 != 36 / 4` (True, `4 != 9`)
     - So, `count++` → `count = 8`
   - Now, the divisors are `1, 36, 2, 18, 3, 12, 4, 9`.

5. **Iteration 5: `i = 5`**
   - `36 % 5 == 0`: No, 5 is not a divisor of 36, so the loop continues without any changes.

6. **Iteration 6: `i = 6`**
   - `36 % 6 == 0`: Yes, 6 is a divisor of 36.
   - `count++` → `count = 9`
   - `i != n / i` → `6 != 36 / 6` (False, `6 == 6`)
     - We **don't** increment the count again because we would be counting the square root twice.
   - Now, the divisors are `1, 36, 2, 18, 3, 12, 4, 9, 6`.

#### Final Result:
- After the loop completes, the total number of divisors is `count = 9`.
- The divisors of 36 are: `1, 36, 2, 18, 3, 12, 4, 9, 6`.

### Summary of Key Points:
- We loop from `1` to `sqrt(n)` (inclusive).
- For each `i`, if `i` divides `n` (`n % i == 0`), we count both `i` and `n / i` as divisors.
- If `i` equals `n / i` (i.e., when `i` is the square root of `n`), we count it only once.
- For `n = 36`, the total number of divisors is 9, and they are `1, 36, 2, 18, 3, 12, 4, 9, 6`.*/
    }

    // Subtask 2: Count divisors for each number in the array
public static List<int[]> countDivisorsForAll(int[] arr) {
    List<int[]> numWithFactors = new ArrayList<>();  // Initialize an empty list to store the results

    // Normal for loop to iterate over each element in the array 'arr'
    for (int i = 0; i < arr.length; i++) {
        int num = arr[i];  // Get the current number from the array
        int divisorCount = countDivisors(num);  // Call countDivisors to get the count of divisors
        numWithFactors.add(new int[]{num, divisorCount});  // Add the number and its divisor count as an array to the list
    }

    return numWithFactors;  // Return the list of numbers with their divisor counts
}
 
    // Subtask 3: Sort the numbers by divisor count (descending)
    public static int[] sortByDivisors(int[] arr) {
        List<int[]> numWithFactors = countDivisorsForAll(arr);

        // Sort the list by number of divisors in descending order (stable sort)
        numWithFactors.sort((a, b) -> Integer.compare(b[1], a[1]));

        // Extract the sorted numbers from the list
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < numWithFactors.size(); i++) {
            sortedArr[i] = numWithFactors.get(i)[0];
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = {36, 12, 15, 6, 28};
        int[] sortedArr = sortByDivisors(arr);
        
        // Print the sorted array
        System.out.println("Sorted array by number of divisors:");
        System.out.println(Arrays.toString(sortedArr));
    }
}

/* Let's walk through the `countDivisors` method, particularly the for-loop, using a sample input. We'll take `n = 36` as an example and explain how the loop works in each iteration.

### Code:
```java
int count = 0;
for (int i = 1; i <= Math.sqrt(n); i++) {
    if (n % i == 0) { // i is a divisor
        count++;
        if (i != n / i) { // Avoid counting square roots twice
            count++;
        }
    }
}
return count;
```

### Understanding the Code:
1. **`Math.sqrt(n)`**: This calculates the square root of `n` and helps us know the range of values we need to check for divisibility. We only need to loop from `1` to the square root of `n` because divisors come in pairs.
2. **`n % i == 0`**: This checks if `i` divides `n` evenly (i.e., `i` is a divisor of `n`).
3. **`i != n / i`**: If `i` and `n / i` are the same (e.g., for perfect squares), we don't want to count it twice.

### Let's take `n = 36` and walk through the loop:

#### Initial Setup:
- **`n = 36`**
- **`Math.sqrt(36) = 6`**, so the loop will run from `i = 1` to `i = 6`.

#### Iterations:

1. **Iteration 1: `i = 1`**
   - `36 % 1 == 0`: Yes, 1 is a divisor of 36.
   - `count++` → `count = 1`
   - `i != n / i` → `1 != 36 / 1` (True, `1 != 36`)
     - So, `count++` → `count = 2`
   - Now, the divisors are `1` and `36`.

2. **Iteration 2: `i = 2`**
   - `36 % 2 == 0`: Yes, 2 is a divisor of 36.
   - `count++` → `count = 3`
   - `i != n / i` → `2 != 36 / 2` (True, `2 != 18`)
     - So, `count++` → `count = 4`
   - Now, the divisors are `1, 36, 2, 18`.

3. **Iteration 3: `i = 3`**
   - `36 % 3 == 0`: Yes, 3 is a divisor of 36.
   - `count++` → `count = 5`
   - `i != n / i` → `3 != 36 / 3` (True, `3 != 12`)
     - So, `count++` → `count = 6`
   - Now, the divisors are `1, 36, 2, 18, 3, 12`.

4. **Iteration 4: `i = 4`**
   - `36 % 4 == 0`: Yes, 4 is a divisor of 36.
   - `count++` → `count = 7`
   - `i != n / i` → `4 != 36 / 4` (True, `4 != 9`)
     - So, `count++` → `count = 8`
   - Now, the divisors are `1, 36, 2, 18, 3, 12, 4, 9`.

5. **Iteration 5: `i = 5`**
   - `36 % 5 == 0`: No, 5 is not a divisor of 36, so the loop continues without any changes.

6. **Iteration 6: `i = 6`**
   - `36 % 6 == 0`: Yes, 6 is a divisor of 36.
   - `count++` → `count = 9`
   - `i != n / i` → `6 != 36 / 6` (False, `6 == 6`)
     - We **don't** increment the count again because we would be counting the square root twice.
   - Now, the divisors are `1, 36, 2, 18, 3, 12, 4, 9, 6`.

#### Final Result:
- After the loop completes, the total number of divisors is `count = 9`.
- The divisors of 36 are: `1, 36, 2, 18, 3, 12, 4, 9, 6`.

### Summary of Key Points:
- We loop from `1` to `sqrt(n)` (inclusive).
- For each `i`, if `i` divides `n` (`n % i == 0`), we count both `i` and `n / i` as divisors.
- If `i` equals `n / i` (i.e., when `i` is the square root of `n`), we count it only once.
- For `n = 36`, the total number of divisors is 9, and they are `1, 36, 2, 18, 3, 12, 4, 9, 6`.*/
