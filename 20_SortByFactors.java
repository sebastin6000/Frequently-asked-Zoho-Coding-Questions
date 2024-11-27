
/* 
Question Section:
Given an array of positive integers, sort the array in decreasing order of the number of factors of each element. 
An element with the highest number of factors should be displayed first. 
If two elements have the same number of factors, they should retain their relative order as in the original array.

Examples:

Input: {5, 11, 10, 20, 9, 16, 23}
Output: 20 16 10 9 5 11 23
Explanation:
- The number of distinct factors:
  - For 20 = 6, For 16 = 5, For 10 = 4, For 9 = 3
  - For 5, 11, 23 = 2 (same number of factors, therefore sorted in increasing order of index)

Input: {104, 210, 315, 166, 441, 180}
Output: 180 210 315 441 104 166
*/

/* 
Understanding the Problem Statement:
- The problem requires sorting an array of positive integers based on the number of factors of each element.
- The number of factors (divisors) of a number is a key metric for sorting.
- After sorting by the number of factors in decreasing order, if two elements have the same number of factors, 
  they should maintain their original relative order.
- We need to find an efficient way to calculate the number of factors of each number and then perform the sorting.

What is being asked?
- We need to return the sorted array based on the number of factors in each element in descending order. 
- For elements with the same number of factors, they should appear in the order they originally appeared.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A single array `arr[]` containing positive integers.

2. Expected Output:
   - A single array sorted in decreasing order based on the number of factors of each element.

3. Output return type:
   - Array of integers.

4. Explanation of Time complexity expectations:
   - The time complexity will be influenced by both the factor counting step and the sorting step.
   - Sorting the array should take O(n log n) time, 
     and calculating the number of factors for each element might take O(sqrt(x)) where x is the element's value.
   - Given that there are n elements and each element could be as large as 10^3, 
     the overall time complexity should ideally not exceed O(n log n * sqrt(x)).

5. Explanation of given Constraints:
   - Array size is between 3 and 10^3, and each element is a positive integer.
   - The problem can be solved efficiently within these constraints using a combination of sorting and factor counting.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification:
   - The problem involves sorting based on a custom metric (number of factors of an element).
   - It can be reduced to calculating the number of factors of each element and sorting the array based on these values.
   
2. Destructuring:
   - The number of factors for each number needs to be calculated. A number's factors are its divisors.
   - Sorting needs to be done based on the number of factors in descending order, 
     while preserving the relative order for numbers with the same number of factors.

3. Conversional solution into smaller subtask:
   - Subtask 1: Implement a function to calculate the number of factors of a given integer.
   - Subtask 2: Create a function to sort the array based on the number of factors, 
                ensuring stability (maintaining the relative order of elements with the same number of factors).
   - Subtask 3: Test the function with multiple test cases to verify correctness.

*/

/* 
Conversional Solution into Subtasks:
1. We will create a helper function to count the number of factors for a given number.
2. We will use Java's `Arrays.sort` with a custom comparator to sort the array based on the number of factors, ensuring that the relative order of elements with the same number of factors is preserved.
3. The result will be printed after sorting.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a helper function `countFactors(int num)` to calculate the number of factors of a number.
2. Create a function to sort the array based on the number of factors using a custom comparator.
3. Implement the `main` method to test the function with example inputs and outputs.

*/

import java.util.*;

public class SortByNumberOfFactors {

    /* 
    Function to calculate the number of factors of a number.
    A factor of a number is any integer that divides it completely (leaving no remainder).
    We iterate up to the square root of the number to find all factors, which ensures an efficient calculation.
    */
    public static int countFactors(int num) {
        int count = 0;
        // Iterate from 1 to sqrt(num) to find all factors
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) { // i is a factor
                count++;
                if (i != num / i) { // If i is not the square root, count the pair (i, num/i)
                    count++;
                }
            }
        }
        return count;
    }

    /* 
    Custom Comparator to sort based on the number of factors in descending order.
    The comparator sorts primarily by the number of factors (in descending order), and for elements with the same number of factors,
    it preserves their relative order using their original index.
    */
    public static void sortByFactors(int[] arr) {
        // List to store elements along with their number of factors
        List<int[]> list = new ArrayList<>();
        
        // Fill the list with each element and its corresponding number of factors
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[] {arr[i], countFactors(arr[i])});
        }
        
        // Sort the list by number of factors (descending), stable sort preserves original order for equal factors
        Collections.sort(list, (a, b) -> Integer.compare(b[1], a[1]));
        
        // Extract the sorted elements from the list
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i)[0];
        }
    }


    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {5, 11, 10, 20, 9, 16, 23};
        sortByFactors(arr1);
        System.out.println("Sorted array by number of factors: " + Arrays.toString(arr1)); // Expected: [20, 16, 10, 9, 5, 11, 23]
        
        // Test case 2
        int[] arr2 = {104, 210, 315, 166, 441, 180};
        sortByFactors(arr2);
        System.out.println("Sorted array by number of factors: " + Arrays.toString(arr2)); // Expected: [180, 210, 315, 441, 104, 166]
    }
}

    /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - `countFactors(int num)` function takes O(sqrt(num)) for each element to count its factors.
    - Sorting the array takes O(n log n) using `Collections.sort`.
    - So the overall time complexity is O(n log n * sqrt(x)), where n is the size of the array and x is the value of the largest element.
    
    Space Complexity:
    - We use extra space for the list to store elements with their factor counts, so the space complexity is O(n).
    */

    /* 
    Code Walkthrough:
    Let's walk through the input `{5, 11, 10, 20, 9, 16, 23}`:

    1. The number of factors of each element is calculated:
       - 5: 2 factors (1, 5)
       - 11: 2 factors (1, 11)
       - 10: 4 factors (1, 2, 5, 10)
       - 20: 6 factors (1, 2, 4, 5, 10, 20)
       - 9: 3 factors (1, 3, 9)
       - 16: 5 factors (1, 2, 4, 8, 16)
       - 23: 2 factors (1, 23)
    
    2. The array is sorted by the number of factors in descending order:
       - 20, 16, 10, 9, 5, 11, 23
    */

/*

### Explanation:

1. **`countFactors(int num)`**:
   - This function calculates the number of divisors (factors) of a number `num`.
   - It iterates from `1` to `sqrt(num)`, and for each divisor `i`, it counts both `i` and `num/i` as factors if they are distinct.

2. **`sortByFactors(int[] arr)`**:
   - The function first computes the number of factors for each element in the array.
   - Then, it sorts the array using `Collections.sort` with a custom comparator that sorts by the number of factors in descending order.
   - For elements with the same number of factors, the sort is stable, so their original order is preserved.

3. **Time and Space Complexity**:
   - **Time Complexity**: `O(n log n * sqrt(x))

`, where `n` is the length of the array and `x` is the largest element in the array. Sorting takes `O(n log n)`, 
   and counting the factors for each element takes `O(sqrt(x))`.
   
   - **Space Complexity**: `O(n)`, as we use a list to store elements along with their factor counts.

4. **Walkthrough**:
   - For the input `{5, 11, 10, 20, 9, 16, 23}`, the number of factors for each element is computed, 
     and the array is sorted based on the number of factors, resulting in the output `[20, 16, 10, 9, 5, 11, 23]`.

### Output:
For the given test cases:
1. `[5, 11, 10, 20, 9, 16, 23]` → Sorted array: `[20, 16, 10, 9, 5, 11, 23]`
2. `[104, 210, 315, 166, 441, 180]` → Sorted array: `[180, 210, 315, 441, 104, 166]`

*/
