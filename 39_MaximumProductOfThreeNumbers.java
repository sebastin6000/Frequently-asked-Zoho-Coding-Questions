/* 
Question:
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Examples:

Input: nums = [1,2,3]
Output: 6

Input: nums = [1,2,3,4]
Output: 24

Input: nums = [-1,-2,-3]
Output: -6

*/

/* 
Understanding the Problem Statement:
- The task is to find the maximum product of three numbers in a given integer array `nums`.
- We need to consider the possibility of negative numbers, as the product of two negative numbers can be positive. 
  This could potentially create a larger product if the third number is large.

What is being asked:
- We are asked to return the maximum product of any three numbers in the array.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An integer array `nums[]` of length `N`.
2. Expected Output:
   - The maximum product of any three numbers from the array.
3. Output return type:
   - The result is an integer representing the maximum product.
4. Time complexity expectations:
   - The time complexity should ideally be O(N log N) or better, since sorting the array is one potential approach.
5. Constraints:
   - The array contains at least 3 elements (`3 <= nums.length <= 10^4`).
   - Each element is between -1000 and 1000, inclusive (`-1000 <= nums[i] <= 1000`).

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - The problem requires finding the maximum product of three numbers from an array.
   - A brute-force solution would involve checking all combinations of three numbers, but this would take too long (O(N^3)).
   - Instead, we can exploit the fact that the product of the largest values (either positive or negative) will give the maximum product.

2. Destructuring:
   - First, we need to identify the potential candidates for the maximum product:
     - The product of the three largest positive numbers.
     - The product of the two smallest (most negative) numbers and the largest positive number.
   - We can sort the array and compare these two possible products to find the maximum.

3. Conversional solution into smaller subtask:
   - Subtask 1: Sort the array.
   - Subtask 2: Compute the product of the three largest numbers.
   - Subtask 3: Compute the product of the two smallest numbers and the largest positive number.
   - Subtask 4: Return the maximum of these two products.

*/

/* 
Conversional Solution into Subtasks:
1. Sort the array to easily access the largest and smallest values.
2. Calculate two possible products:
   - Product of the three largest numbers.
   - Product of the two smallest (most negative) numbers and the largest positive number.
3. Return the maximum of these two products.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Sort the array in ascending order.
2. Calculate the product of the three largest numbers.
3. Calculate the product of the two smallest numbers and the largest positive number.
4. Return the maximum of these two products.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.Arrays;

public class MaximumProduct {

    // Function to find the maximum product of three numbers
    public static int maximumProduct(int[] nums) {
        // Subtask 1: Sort the array in ascending order
        Arrays.sort(nums);
        
        // Subtask 2: Calculate the product of the three largest numbers
        int product1 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        
        // Subtask 3: Calculate the product of the two smallest numbers and the largest positive number
        int product2 = nums[0] * nums[1] * nums[nums.length - 1];
        
        // Subtask 4: Return the maximum of the two products
        return Math.max(product1, product2);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 3};
        System.out.println(maximumProduct(nums1)); // Expected output: 6
        
        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(maximumProduct(nums2)); // Expected output: 24
        
        // Test case 3
        int[] nums3 = {-1, -2, -3};
        System.out.println(maximumProduct(nums3)); // Expected output: -6
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Sorting the array takes O(N log N) time, where N is the length of the array.
  - Calculating the two products and comparing them takes constant time O(1).
  - Thus, the overall time complexity is O(N log N) due to the sorting step.
  
- Space Complexity:
  - The space complexity is O(1) as we are only using a few extra variables to store intermediate results.
  - The space complexity for sorting is typically O(log N) for the recursive stack of quicksort or mergesort,
     but in practice, it is O(1) for this specific implementation since we're only using in-place sorting.

*/

/* 
There are no loops in the main logic of the code as the sorting function handles all iterations internally.
- `Arrays.sort(nums)` internally uses a sorting algorithm (like quicksort) to arrange the elements in ascending order.
- After sorting, we simply calculate two potential products (one from the largest values and one from the smallest values) and return the larger of the two.
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For the input `nums1 = {1, 2, 3}`:
1. The array is already sorted: [1, 2, 3].
2. We calculate the product of the three largest numbers: `3 * 2 * 1 = 6`.
3. There are no negative numbers, so the second product is not relevant in this case.
4. The maximum product is 6, so the output is 6.

For the input `nums2 = {1, 2, 3, 4}`:
1. The array is sorted: [1, 2, 3, 4].
2. The product of the three largest numbers: `4 * 3 * 2 = 24`.
3. The product of the two smallest and the largest number: `1 * 2 * 4 = 8`.
4. The maximum product is 24, so the output is 24.

For the input `nums3 = {-1, -2, -3}`:
1. The array is sorted: [-3, -2, -1].
2. The product of the three largest numbers: `-1 * -2 * -3 = -6`.
3. The second product of two smallest and the largest positive number is not relevant here since all numbers are negative.
4. The maximum product is -6, so the output is -6.
*/
