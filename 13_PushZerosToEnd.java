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

public class PushZerosToEnd {
    // Step 1: Function to push zeros to the end
    public static void pushZerosToEnd(int[] arr) {
        int lastNonZeroIndex = 0;  // Variable to track where the next non-zero element should go

        // Step 2: Loop through the array to move non-zero elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[lastNonZeroIndex] = arr[i];  // Move non-zero element to the lastNonZeroIndex
                lastNonZeroIndex++;  // Increment the position for the next non-zero element
            }
        }

        // Step 3: Fill the remaining positions with zeros
        for (int i = lastNonZeroIndex; i < arr.length; i++) {
            arr[i] = 0;  // Fill remaining positions with zeros
        }
    }

    public static void main(String[] args) {
        // Input array for testing
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};

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

public class PushZerosToEnd {
    // Step 1: Function to push zeros to the end
    public static void pushZerosToEnd(int[] arr) {
        int lastNonZeroIndex = 0;  // Variable to track where the next non-zero element should go

        // Step 2: Loop through the array to move non-zero elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[lastNonZeroIndex] = arr[i];  // Move non-zero element to the lastNonZeroIndex
                lastNonZeroIndex++;  // Increment the position for the next non-zero element
            }
        }

        // Step 3: Fill the remaining positions with zeros
        for (int i = lastNonZeroIndex; i < arr.length; i++) {
            arr[i] = 0;  // Fill remaining positions with zeros
        }
    }

    public static void main(String[] args) {
        // Input array for testing
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};

        // Step 4: Call the function to modify the array
        pushZerosToEnd(arr);

        // Print the result
        System.out.println("Array after pushing zeros to the end: " + java.util.Arrays.toString(arr));
    }
}
