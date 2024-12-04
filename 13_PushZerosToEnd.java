--------------------------------------------------- WITH TEMPLATE --------------------------------------------------------------------

/* 
Question Section:
Given an array `arr[]`, the task is to push all the zeros to the right end of the array while maintaining the order of non-zero elements. 
Perform the operation in place, i.e., modify the array itself.

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

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^5
*/

/* 
Understanding the Problem Statement:
- We are given an array `arr[]` and need to rearrange the array such that all zeros are moved to the end while maintaining the order of non-zero elements.
- The operation needs to be done in place, which means no additional arrays or data structures should be used for the rearrangement.
- The array may contain any number of zeros, and we are guaranteed to have at least one non-zero element since the size of the array is at least 1.

What is being asked?
- We need to write a function that takes an array as input, modifies it in place, 
  and returns the array with all zeros moved to the right end, while the order of non-zero elements is preserved.
*/

 /* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A single array `arr[]` containing integers.
2. Expected Output:
   - The same array `arr[]` after modification, with all zeros moved to the right while maintaining the order of non-zero elements.
3. Output return type:
   - The array `arr[]` itself is modified in place, and the function does not need to return anything explicitly.
4. Explanation of Time complexity expectations:
   - We need to achieve the task with a time complexity of O(n), where `n` is the size of the array. 
     This is because we are performing operations in place and should only traverse the array once.
5. Explanation of given Constraints:
   - The maximum size of the array is `10^5`, so we must ensure the solution works efficiently even for large arrays (up to 100,000 elements).
*/

 /* 
Thinking Solution for the Problem Statement:
1. Identification:
   - The problem is about rearranging the array by pushing zeros to the end while maintaining the order of non-zero elements.
   - A common approach for such problems is using two pointers or a similar technique to shift elements efficiently.
   
2. Destructuring:
   - We need to traverse the array from left to right.
   - Whenever we find a non-zero element, we move it to the front of the array.
   - We use a pointer `index` to keep track of where the next non-zero element should go.
   - After the traversal, all the positions from `index` to the end of the array will be filled with zeros.

3. Conversional solution into smaller subtask:
   - Subtask 1: Iterate through the array, and for every non-zero element, move it to the next available position.
   - Subtask 2: After the iteration, fill all remaining positions with zeros.

*/

 /* 
Conversional Solution into Subtasks:
1. Iterate through the array and push non-zero elements to the front.
2. After processing all elements, fill any remaining positions with zeros.
3. Ensure that the operation is done in place without using additional memory.

*/

 /* 
Subtasks of Conversional Solution into Code:
1. Initialize a pointer `index` to track the position where the next non-zero element should be moved.
2. Traverse the array and for every non-zero element, move it to the `index` position and increment the `index`.
3. Once the traversal is complete, all positions from `index` to the end of the array should be set to zero.

*/
public class PushZerosToEnd
{
    public static void pushZerosToEnd(int[] arr)
    {
        int n = arr.length;
        int index = 0; // Pointer to track the next non-zero position

        // Traverse the array
        for (int i = 0; i < n; i++)
        {
            // If the current element is non-zero, move it to the 'index' position
            if (arr[i] != 0)
            {
                arr[index] = arr[i];
                if (index != i) 
                { // Only increment index if it is moved
                    arr[i] = 0; // Set the current position to zero
                }
                index++; // Increment the position for the next non-zero element
            }
        }
    }
    public static void main(String[] args) 
    {
        // Test case 1
        int[] arr1 = {1,2,0,4,3,0,5,0};
        
        pushZerosToEnd(arr1);
        System.out.println("After pushing zeros to the end: " + java.util.Arrays.toString(arr1));
        // Expected output: [1, 2, 4, 3, 5, 0, 0, 0]

        // Test case 2
        int[] arr2 = {
            10,
            20,
            30
        };
        pushZerosToEnd(arr2);
        System.out.println("After pushing zeros to the end: " + java.util.Arrays.toString(arr2));
        // Expected output: [10, 20, 30]

        // Test case 3
        int[] arr3 = {
            0,
            0
        };
        pushZerosToEnd(arr3);
        System.out.println("After pushing zeros to the end: " + java.util.Arrays.toString(arr3));
        // Expected output: [0, 0]
    }
}
  /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - O(n), where n is the size of the array. 
      We only need to make one pass through the array to move the non-zero elements and fill the remaining positions with zeros.
    - This is efficient because we traverse the array once and perform constant-time operations inside the loop.

    Space Complexity:
    - O(1), because we are modifying the array in place and not using any extra space except for a few variables (`index` and `i`).
    */

    /* 
    Code Walkthrough:
    Let's walk through the example with `arr = [1, 2, 0, 4, 3, 0, 5, 0]`:

    1. Initially, `arr = [1, 2, 0, 4, 3, 0, 5, 0]` and `index = 0`.
    2. Traverse the array:
       - `arr[0] = 1` is non-zero, so we place `1` at index 0 (no change) and increment `index` to 1.
       - `arr[1] = 2` is non-zero, so we place `2` at index 1 (no change) and increment `index` to 2.
       - `arr[2] = 0`, so we skip it.
       - `arr[3] = 4` is non-zero, so we place `4` at index 2 (replaces the 0) and increment `index` to 3.
       - `arr[4] = 3` is non-zero, so we place `3` at index 3 (no change) and increment `index` to 4.
       - `arr[5] = 0`, so we skip it.
       - `arr[6] = 5` is non-zero, so we place `5` at index 4 (replaces the 0) and increment `index` to 5.
       - `arr[7] = 0`, so we skip it.

    3. After the loop finishes, `arr = [1, 2, 4, 3, 5, 0, 0, 0]`.

    Final result: `arr = [1, 2, 4, 3, 5, 0, 0, 0]`.

    Output: `[1, 2, 4, 3, 5, 0, 0, 0]`
    */


/* 

### Explanation:

1. **`pushZerosToEnd(int[] arr)`**:
   - This function traverses the array from left to right. For each non-zero element, it places it at the current `index` position and increments `index`.
   - After placing a non-zero element, the original position is set to zero.
   - This ensures that all non-zero elements are moved to the front, and all zeros are pushed to the end.

2. **Time and Space Complexity**:
   - **Time Complexity**: O(n), where `n` is the size of the array. We traverse the array once, and all operations inside the loop are constant time.
   - **Space Complexity**: O(1), as we

 only use a few variables for iteration (`index`, `i`).

3. **Code Walkthrough**:
   - The function processes each element, shifting non-zero elements to the front while setting zeros at the back. 
     It does so in a single pass through the array, making it efficient.
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
