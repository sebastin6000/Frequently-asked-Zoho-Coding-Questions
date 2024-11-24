/* 
Question: 
Given an array of positive integers, sort the array in decreasing order of the number of factors of each element. 
That is, the element with the highest number of factors should be displayed first. If two elements have the same number of factors, they should retain their relative order as in the original array.

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
Input-output explanation:

Input:
arr[] = {5, 11, 10, 20, 9, 16, 23}
Output:
20 16 10 9 5 11 23

Explanation:
- The array is sorted based on the number of factors each number has. 
- 20 has the most factors (6), followed by 16 (5), 10 (4), and so on. 
- For numbers with the same number of factors (like 5, 11, 23), they remain in their original relative order.

Input:
arr[] = {104, 210, 315, 166, 441, 180}
Output:
180 210 315 441 104 166

Explanation:
- Similar sorting process based on the number of factors for each number.
*/

 /* 
Constraints explanation:

- The array contains positive integers. 
- We need to count the factors of each number, which means for each element in the array, we must calculate how many numbers divide it.
- We are to sort based on the count of factors, and in case of ties (same number of factors), the elements should retain their relative position in the original array.

The constraints are such that we will likely need to perform a factor count for each number in the array. 
This can be done efficiently by limiting the divisor checks to the square root of each number.

 */

/* 
Relatable analogy or real-world scenario:

Imagine you're organizing a race where each participant (element in the array) has a certain "speed" (number of factors). 
You want to rank the participants in decreasing order of their speed. 
However, participants with the same speed should stay in the same order as they were originally in the line. 

The "speed" of each participant is determined by how many different ways their number can be "divided" evenly, i.e., the number of factors of that number. 

For example, for number 6, the factors are {1, 2, 3, 6}, so the speed of participant 6 is 4 (since it has 4 factors). 
If two participants have the same number of factors (same speed), they should still appear in the same order as they started in the race.

The solution is to:
1. Count how many factors each number has.
2. Sort the numbers based on the number of factors, from highest to lowest.
3. Keep the relative order of elements with the same number of factors.

*/

/* 
Relatable analogy Java code step by step:

Step 1: 
We define a method to count the number of factors of a number. For each number, we find divisors from 1 to the square root of the number.

Step 2: 
Sort the numbers based on the count of their factors in descending order. 
We can achieve this by using a custom comparator while sorting.

Step 3: 
If two numbers have the same number of factors, their relative order should be maintained. Java's built-in sorting ensures this when two numbers are considered equal by the comparator.

Step 4: 
Return or print the sorted array.

*/

import java.util.Arrays;
import java.util.Comparator;

public class SortByFactors {

    // Helper function to count the number of factors of a number
    public static int countFactors(int n) {
        int count = 0;
        // We only need to check divisors up to the square root of n
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; // i is a divisor
                if (i != n / i) {
                    count++; // n / i is also a divisor, unless i == n / i
                }
            }
        }
        return count;
    }

    // Function to sort the array based on number of factors in descending order
    public static void sortByFactors(int[] arr) {
        // Create an array of objects to store the value and its original index
        Integer[] arrWithFactors = new Integer[arr.length];
        
        // Initialize the array with values from arr
        for (int i = 0; i < arr.length; i++) {
            arrWithFactors[i] = arr[i];
        }
        
        // Sort the array using a custom comparator based on the number of factors
        Arrays.sort(arrWithFactors, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int factorsA = countFactors(a);
                int factorsB = countFactors(b);
                
                // First, compare by number of factors (descending order)
                if (factorsA != factorsB) {
                    return factorsB - factorsA;
                } else {
                    // If number of factors is the same, keep original order
                    return 0;
                }
            }
        });

        // Print the sorted array
        for (int i = 0; i < arrWithFactors.length; i++) {
            System.out.print(arrWithFactors[i] + " ");
        }
    }

    // Main function to test the sorting logic
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {5, 11, 10, 20, 9, 16, 23};
        sortByFactors(arr1); // Output: 20 16 10 9 5 11 23
        
        // Test case 2
        System.out.println();
        int[] arr2 = {104, 210, 315, 166, 441, 180};
        sortByFactors(arr2); // Output: 180 210 315 441 104 166
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- Counting factors for each number takes O(√n) time, where n is the number for which we're counting factors.
- Since we count factors for each element in the array, the time complexity for counting factors for all elements is O(m * √n), where m is the number of elements in the array and n is the largest element.
- Sorting the array takes O(m log m), where m is the number of elements in the array.
- Therefore, the overall time complexity is O(m log m + m * √n).

Space Complexity:
- We create a new array to store the elements and their factors, so the space complexity is O(m), where m is the number of elements in the array.

*/

/* 
FOR loop walkthrough with every iteration with given input, Complete code walkthrough with applying the given input in code and explanation:

Input: arr[] = {5, 11, 10, 20, 9, 16, 23}

1. First, the countFactors function will be called for each element in the array:
   - For 5: Factors are {1, 5}, count = 2
   - For 11: Factors are {1, 11}, count = 2
   - For 10: Factors are {1, 2, 5, 10}, count = 4
   - For 20: Factors are {1, 2, 4, 5, 10, 20}, count = 6
   - For 9: Factors are {1, 3, 9}, count = 3
   - For 16: Factors are {1, 2, 4, 8, 16}, count = 5
   - For 23: Factors are {1, 23}, count = 2

2. After counting factors, the array is sorted by the number of factors in descending order. The sorting function uses a custom comparator that compares the number of factors of each element. 
3. The output after sorting is: 20 16 10 9 5 11 23.
*/

/* Complete code walkthrough with applying the given input in code and explanation:
- First, we count the number of factors for each element in the array using the countFactors function.
- Next, we use a custom comparator to sort the array based on the number of factors, keeping the relative order intact when two numbers have the same number of factors.
- Finally, we print the sorted array.
*/
