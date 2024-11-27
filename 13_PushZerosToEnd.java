--------------------------------------------------- WITH TEMPLATE --------------------------------------------------------------------
/* 
Question Section:
Given two sorted arrays `arr1[]` and `arr2[]` of distinct elements, where the first array has one extra element, 
the task is to find the index of the extra element in the first array.

Examples:

Input: arr1[] = [2,4,6,8,9,10,12], arr2[] = [2,4,6,8,10,12]
Output: 4
Explanation: In the first array, 9 is extra and its index is 4.

Input: arr1[] = [3,5,7,8,11,13], arr2[] = [3,5,7,11,13]
Output: 3
Explanation: In the first array, 8 is extra and its index is 3.

Input: arr1[] = [3,5], arr2[] = [3]
Output: 1
Explanation: In the first array, 5 is extra and its index is 1.

Constraints:
- 2 <= arr1.size() <= 10^5
- 1 <= arr1[i], arr2[i] <= 10^6
*/

/* 
Understanding the Problem Statement:
- We are given two sorted arrays `arr1` and `arr2`. 
- The first array `arr1` contains one additional element compared to the second array `arr2`.
- Both arrays are sorted in increasing order, and the extra element in `arr1` is the one that is missing from `arr2`.
- The task is to find the index of this extra element in `arr1`.

What is being asked?
- The objective is to return the index of the extra element in `arr1` that does not appear in `arr2`.
*/

 /* 
Extracting Information from the Problem Statement:
1. Input data type:
   - Two arrays of distinct integers `arr1` and `arr2`. 
   - Both arrays are sorted in ascending order.
2. Expected Output:
   - A single integer, which is the index of the extra element in `arr1`.
3. Output return type:
   - Integer (index of the extra element).
4. Explanation of Time complexity expectations:
   - The time complexity of this solution should be O(n), where `n` is the length of `arr1`.
   - We need to traverse both arrays at most once, which gives an efficient O(n) solution.
5. Explanation of given Constraints:
   - The size of `arr1` can be as large as 100,000, so an O(n) solution is necessary to ensure that the solution runs in reasonable time.
*/

 /* 
Thinking Solution for the Problem Statement:
1. Identification:
   - The problem is a "find the missing element" problem but with an extra element in a sorted array.
   - We need to find which element is extra in `arr1` by comparing it with `arr2`.

2. Destructuring:
   - Step 1: Both arrays are sorted, so we can use a simple comparison approach.
   - Step 2: We will iterate over both arrays, comparing corresponding elements.
   - Step 3: If the elements at the same index in both arrays differ, the extra element is found at that index in `arr1`.
   - Step 4: If the end of `arr2` is reached and no differences are found, then the extra element must be the last element of `arr1`.

3. Conversional solution into smaller subtask:
   - Subtask 1: Compare elements of `arr1` and `arr2` one by one.
   - Subtask 2: If any element in `arr1` is not the same as the corresponding element in `arr2`, return the index.
   - Subtask 3: If no discrepancy is found by the end of `arr2`, return the last index of `arr1`.

*/

 /* 
Conversional Solution into Subtasks:
1. Iterate through both arrays and compare elements.
2. If an element in `arr1` is not equal to the element in `arr2` at the same position, return the index of the differing element.
3. If the loop finishes and no discrepancy is found, return the last element's index in `arr1`.

*/

 /* 
Subtasks of Conversional Solution into Code:
1. Compare elements from both arrays.
2. If any elements are different, return the index of the extra element in `arr1`.
3. If no discrepancy is found, return the index of the last element in `arr1`.

*/

public class ExtraElementInArray {

    /* 
    Function to find the index of the extra element in arr1.
    We compare elements of arr1 and arr2. If they differ, arr1 has the extra element at that index.
    If no difference is found during the iteration, return the last index of arr1.
    */
    public static int findExtraElementIndex(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        
        // Traverse both arrays and compare each element
        for (int i = 0; i < m; i++) {
            if (arr1[i] != arr2[i]) {
                return i; // Found the extra element at index i in arr1
            }
        }
        
        // If no differences were found, the extra element must be at the last position of arr1
        return n - 1; 
    }
    public static void main(String[] args) {
        // Test case 1
        int[] arr1_1 = {2, 4, 6, 8, 9, 10, 12};
        int[] arr2_1 = {2, 4, 6, 8, 10, 12};
        System.out.println("Index of extra element: " + findExtraElementIndex(arr1_1, arr2_1)); // Expected output: 4

        // Test case 2
        int[] arr1_2 = {3, 5, 7, 8, 11, 13};
        int[] arr2_2 = {3, 5, 7, 11, 13};
        System.out.println("Index of extra element: " + findExtraElementIndex(arr1_2, arr2_2)); // Expected output: 3

        // Test case 3
        int[] arr1_3 = {3, 5};
        int[] arr2_3 = {3};
        System.out.println("Index of extra element: " + findExtraElementIndex(arr1_3, arr2_3)); // Expected output: 1
    }
}

 /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - The time complexity is O(n), where n is the size of the larger array `arr1`. We only need to traverse both arrays once, comparing elements.
    - In the worst case, we may compare all elements in `arr2`, which gives a linear time complexity.

    Space Complexity:
    - The space complexity is O(1), as we are only using a constant amount of space for the loop variables and no additional data structures.
    */

    /* 
    Code Walkthrough:
    Let's walk through the example with `arr1 = [2, 4, 6, 8, 9, 10, 12]` and `arr2 = [2, 4, 6, 8, 10, 12]`:

    1. We compare `arr1[0]` with `arr2[0]` (both are 2). No difference, continue.
    2. Compare `arr1[1]` with `arr2[1]` (both are 4). No difference, continue.
    3. Compare `arr1[2]` with `arr2[2]` (both are 6). No difference, continue.
    4. Compare `arr1[3]` with `arr2[3]` (both are 8). No difference, continue.
    5. Compare `arr1[4]` with `arr2[4]` (arr1 has 9, arr2 has 10). They differ, so the extra element is found at index 4 in `arr1`.

    Output: `4`
    */

/*

### Explanation:

1. **`findExtraElementIndex(int[] arr1, int[] arr2)`**:
   - This function compares each element in `arr1` with `arr2` (which is one element shorter). 
     The moment an element in `arr1` differs from `arr2`, it returns the index of the differing element.
   - If no differences are found by the end of `arr2`, the extra element must be the last element of `arr1`, and we return the index `n - 1`.

2. **Time and Space Complexity**:
   - **Time Complexity**: O(n), where `n` is the size of `arr1`. We traverse both arrays at most once.
   - **Space Complexity**: O(1), since we only use a few variables for iteration.

3. **Code Walkthrough**:
   - The function checks each index in both arrays, and if an element from `arr1` differs from the corresponding element in `arr2`, it returns that index. 
     If no differences are found by the end, the last element of `arr1` is returned.
*/
--------------------------------------------------- WITHOUT TEMPLATE --------------------------------------------------------------------
/* 
Question:
Given an array arr[]. 
Push all the zeros of the given array to the right end of the array while maintaining the order of non-zero elements. 
Do the mentioned change in the array in place.

Examples:
Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.

Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]
Explanation: No change in array as there are no 0s.

Input: arr[] = [0, 0]
Output: [0, 0]
Explanation: No change in array as there are all 0s.
*/

/* 
Input-Output Explanation:

Input 1: [1, 2, 0, 4, 3, 0, 5, 0]
- The array has 3 zeros. We want to move these zeros to the end while keeping the order of the non-zero elements.
- The output should be [1, 2, 4, 3, 5, 0, 0, 0].

Input 2: [10, 20, 30]
- This array has no zeros, so no changes are made.
- The output is [10, 20, 30].

Input 3: [0, 0]
- This array contains only zeros, so there is no need to change anything.
- The output is [0, 0].

*/

/* 
Constraints Explanation:

1 ≤ arr.size() ≤ 10^5
- The number of elements in the array can go up to 100,000, so our solution must work efficiently for large arrays.
0 ≤ arr[i] ≤ 10^5
- The elements of the array can be zero or positive integers, with a maximum value of 100,000.

We need to ensure that we move the zeros without changing the order of non-zero elements and do this in an efficient way.
*/

/* 
Relatable Analogy or Real-World Scenario:

Think of the task as cleaning up a row of chairs in a classroom.
- Non-zero elements are like students sitting on chairs.
- Zeros are like empty chairs.
  Your task is to move all the empty chairs (zeros) 
  to the back of the row without changing the order in which the students (non-zero elements) are sitting. 
- You can only move one chair at a time, and you need to do it efficiently. 
- The challenge is to ensure the students stay in the same order, 
  and all the empty chairs are pushed to the back without disrupting the row.

Now, let's go step by step:

1. You start by walking along the row of chairs (the array).
2. Every time you encounter a student (non-zero element), you make space for them at the front (shift the students forward).
3. Every time you encounter an empty chair (zero), you leave it for now and move forward.
4. In the end, all students are at the front, and all empty chairs are at the back.

*/

/* 
Relatable Analogy Java Code Step by Step:

1. Declare a variable `lastNonZeroIndex` to track the position of the last non-zero element.
2. Loop through the array from the beginning to the end.
   - For each non-zero element, we place it at the `lastNonZeroIndex` position and increment `lastNonZeroIndex`.
3. Once all non-zero elements are moved, the remaining positions from `lastNonZeroIndex` 
   to the end of the array should be filled with zeros.
4. We don't need extra space because the changes are made in-place, directly within the array.

Now let's look at how this works with the code:

*/

/* 
Time and Space Complexity Explanation:

Time Complexity:
- We only need one pass through the array to move non-zero elements and place zeros at the end. This takes O(n), where n is the size of the array.

Space Complexity:
- We don't use any extra space for storing elements. The operations are done in-place, so the space complexity is O(1) (constant space).
*/

/* 
FOR Loop Walkthrough with Every Iteration for Input [1, 2, 0, 4, 3, 0, 5, 0]:

Array: [1, 2, 0, 4, 3, 0, 5, 0]

1. Start with lastNonZeroIndex = 0.
2. First element is 1 (non-zero), so we place it at lastNonZeroIndex (position 0) and move lastNonZeroIndex to 1.
   Array becomes: [1, 2, 0, 4, 3, 0, 5, 0]

3. Second element is 2 (non-zero), place it at position 1 and move lastNonZeroIndex to 2.
   Array becomes: [1, 2, 0, 4, 3, 0, 5, 0]

4. Third element is 0 (zero), do nothing and move to the next element.

5. Fourth element is 4 (non-zero), place it at position 2 and move lastNonZeroIndex to 3.
   Array becomes: [1, 2, 4, 4, 3, 0, 5, 0]

6. Fifth element is 3 (non-zero), place it at position 3 and move lastNonZeroIndex to 4.
   Array becomes: [1, 2, 4, 3, 3, 0, 5, 0]

7. Sixth element is 0 (zero), do nothing and move to the next element.

8. Seventh element is 5 (non-zero), place it at position 4 and move lastNonZeroIndex to 5.
   Array becomes: [1, 2, 4, 3, 5, 0, 5, 0]

9. Eighth element is 0 (zero), do nothing.

Finally, all non-zero elements are at the front, and the remaining zeros are at the back. The final array is: [1, 2, 4, 3, 5, 0, 0, 0].

*/

// WUTHOUT EXPLANATION IN DETAIL

public class PushZerosToEnd
{
    // Step 1: Function to push zeros to the end
    public static void pushZerosToEnd(int[] arr)
    {
        int lastNonZeroIndex = 0; // Variable to track where the next non-zero element should go

        // Step 2: Loop through the array to move non-zero elements
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != 0)
            {
                arr[lastNonZeroIndex] = arr[i]; // Move non-zero element to the lastNonZeroIndex
                lastNonZeroIndex++; // Increment the position for the next non-zero element
            }
        }

        // Step 3: Fill the remaining positions with zeros
        for (int i = lastNonZeroIndex; i < arr.length; i++)
        {
            arr[i] = 0; // Fill remaining positions with zeros
        }
    }

    public static void main(String[] args)
    {
        // Input array for testing
        int[] arr = {
            1,
            2,
            0,
            4,
            3,
            0,
            5,
            0
        };

        // Step 4: Call the function to modify the array
        pushZerosToEnd(arr);

        // Print the result
        System.out.println("Array after pushing zeros to the end: " + java.util.Arrays.toString(arr));
    }
}

/* 
Code Walkthrough:

1. The `pushZerosToEnd` method performs the core task. 
   It first moves all non-zero elements to the front while keeping track of the position (`lastNonZeroIndex`).
2. The second loop fills the remaining spots with zeros.
3. The `main` method initializes the input array, calls the `pushZerosToEnd` method to modify the array, 
   and prints the modified array.

*/

/* 
Final Explanation:
- We move all non-zero elements to the front, ensuring that we maintain the order of the elements.
- Zeros are pushed to the end, and this is done in-place without using extra space.

*/


// WITH EXPLANATION IN DETAIL

public class PushZerosToEnd
{
    // Step 1: Function to push zeros to the end
    public static void pushZerosToEnd(int[] arr)
    {
        int lastNonZeroIndex = 0; // Variable to track where the next non-zero element should go

        // Step 2: Loop through the array to move non-zero elements
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != 0)
            {
                arr[lastNonZeroIndex] = arr[i]; // Move non-zero element to the lastNonZeroIndex
                lastNonZeroIndex++; // Increment the position for the next non-zero element
            }
            /* Sure! Let's go through each step of the code and break down how it works for the input `arr = [1, 2, 0, 4, 3, 0, 5, 0]`. 
        We will focus on each iteration of the loop to explain how the elements are processed and moved.
        
         Input:
        ```
        arr = [1, 2, 0, 4, 3, 0, 5, 0]
        ```
        
         Step-by-Step Explanation:
        
        # Initial Setup:
        We start with the input array and initialize the `lastNonZeroIndex` to `0`.
        
        ```
        int lastNonZeroIndex = 0;  // Variable to track where the next non-zero element should go
        ```
        
         Step 1: Loop through the array to move non-zero elements
        The first `for` loop iterates through each element of the array (`arr[i]`) to check if it is non-zero.
        If it is non-zero, we move it to the `lastNonZeroIndex` and increment `lastNonZeroIndex`.
        
         Iteration-by-Iteration Breakdown:
        
        # Iteration 1 (i = 0):
        - Current element: `arr[0] = 1`
        - Since `arr[0]` is non-zero, we move it to the `lastNonZeroIndex` (which is `0` initially):
          - `arr[lastNonZeroIndex] = arr[i]` → `arr[0] = 1` (no change, `1` stays in place).
        - We then increment `lastNonZeroIndex` to `1`.
        - Array after this iteration: `[1, 2, 0, 4, 3, 0, 5, 0]`
        - `lastNonZeroIndex = 1`
        
        # Iteration 2 (i = 1):
        - Current element: `arr[1] = 2`
        - Since `arr[1]` is non-zero, we move it to the `lastNonZeroIndex` (which is `1`):
          - `arr[lastNonZeroIndex] = arr[i]` → `arr[1] = 2` (no change, `2` stays in place).
        - We then increment `lastNonZeroIndex` to `2`.
        - Array after this iteration: `[1, 2, 0, 4, 3, 0, 5, 0]`
        - `lastNonZeroIndex = 2`
        
        # Iteration 3 (i = 2):
        - Current element: `arr[2] = 0`
        - Since `arr[2]` is zero, we do nothing and move to the next element.
        - Array remains unchanged: `[1, 2, 0, 4, 3, 0, 5, 0]`
        - `lastNonZeroIndex = 2`
        
        # Iteration 4 (i = 3):
        - Current element: `arr[3] = 4`
        - Since `arr[3]` is non-zero, we move it to the `lastNonZeroIndex` (which is `2`):
          - `arr[lastNonZeroIndex] = arr[i]` → `arr[2] = 4`.
        - We then increment `lastNonZeroIndex` to `3`.
        - Array after this iteration: `[1, 2, 4, 4, 3, 0, 5, 0]`
        - `lastNonZeroIndex = 3`
        
        # Iteration 5 (i = 4):
        - Current element: `arr[4] = 3`
        - Since `arr[4]` is non-zero, we move it to the `lastNonZeroIndex` (which is `3`):
          - `arr[lastNonZeroIndex] = arr[i]` → `arr[3] = 3`.
        - We then increment `lastNonZeroIndex` to `4`.
        - Array after this iteration: `[1, 2, 4, 3, 3, 0, 5, 0]`
        - `lastNonZeroIndex = 4`
        
        # Iteration 6 (i = 5):
        - Current element: `arr[5] = 0`
        - Since `arr[5]` is zero, we do nothing and move to the next element.
        - Array remains unchanged: `[1, 2, 4, 3, 3, 0, 5, 0]`
        - `lastNonZeroIndex = 4`
        
        # Iteration 7 (i = 6):
        - Current element: `arr[6] = 5`
        - Since `arr[6]` is non-zero, we move it to the `lastNonZeroIndex` (which is `4`):
          - `arr[lastNonZeroIndex] = arr[i]` → `arr[4] = 5`.
        - We then increment `lastNonZeroIndex` to `5`.
        - Array after this iteration: `[1, 2, 4, 3, 5, 0, 5, 0]`
        - `lastNonZeroIndex = 5`
        
        # Iteration 8 (i = 7):
        - Current element: `arr[7] = 0`
        - Since `arr[7]` is zero, we do nothing and finish the loop.
        - Array remains unchanged: `[1, 2, 4, 3, 5, 0, 5, 0]`
        - `lastNonZeroIndex = 5`
        */
        }

        // Step 3: Fill the remaining positions with zeros
        for (int i = lastNonZeroIndex; i < arr.length; i++)
        {
            arr[i] = 0; // Fill remaining positions with zeros
        }
        /*        
        Fill the remaining positions with zeros
        After the first loop, the non-zero elements are at the beginning of the array, and `lastNonZeroIndex` is now `5`.
        The next step is to fill the remaining positions (from `lastNonZeroIndex` to the end of the array) with zeros.
        
        - Start from `lastNonZeroIndex = 5` and fill the array with zeros.
        
        # Filling the remaining zeros:
        - Set `arr[5] = 0`
        - Set `arr[6] = 0`
        - Set `arr[7] = 0`
        
        Array after filling zeros: `[1, 2, 4, 3, 5, 0, 0, 0]`
        
        ---
        
         Final Output:
        After the loop finishes, the array is transformed as expected:
        ```
        arr = [1, 2, 4, 3, 5, 0, 0, 0]
        ```
        
         Summary of What Happened:
        - In the first loop, we moved all non-zero elements to the front, keeping their original order.
        - In the second loop, we filled the remaining positions with zeros, starting from where the last non-zero element was moved.
        
         Key Points:
        - Non-zero elements (`1, 2, 4, 3, 5`) were moved to the front in their original order.
        - Zero elements (`0, 0, 0`) were pushed to the back.
        
        
        
*/
    }

    public static void main(String[] args)
    {
        // Input array for testing
        int[] arr = 
        {
            1,
            2,
            0,
            4,
            3,
            0,
            5,
            0
        };

        // Step 4: Call the function to modify the array
        pushZerosToEnd(arr);

        // Print the result
        System.out.println("Array after pushing zeros to the end: " + java.util.Arrays.toString(arr));
    }
}
