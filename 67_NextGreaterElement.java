/* 
Question:
Given an array A of N length. We need to calculate the next smallest greater element for each element in the given array. 
If the next greater element is not available in a given array then we need to fill -10000000 at that index place.

Example 1:
Input : arr[] = {13, 6, 7, 12}
Output : _ 7 12 13 
Explanation: 
Here, at index 0, 13 is the greatest value in given array and no other array element is greater from 13. So at index 0 we fill '-10000000'.

Example 2:
Input : arr[] = {6, 3, 9, 8, 10, 2, 1, 15, 7} 
Output :  7 6 10 9 15 3 2 _ 8
Explanation: 
Here, at index 7, 15 is the greatest value in the given array and no other array element is greater than 15. So at index 7 we fill '-10000000'.

Your Task:
This is a function problem. The input is already taken care of by the driver code. 
You only need to complete the function greaterElement() that takes an array (arr), sizeOfArray (n), 
and return an array that displays the next greater element to the element at that index. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
-106 ≤ Ai ≤ 106.
*/

/* 
Understanding the Problem Statement:
1. We are given an array A of size N, and for each element in the array, 
   we need to determine the next element in the array that is greater than the current element.
2. If no such greater element exists for a number, we place `-10000000` at that index.
3. The result array should have the same length as the input array, 
   where each index holds the next greater element, or `-10000000` if no such element exists.

What is being asked:
- We are asked to implement the function `greaterElement()` that computes the next greater element for each element in the array.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is an array `arr[]` of size `N`.
   - Elements in the array `arr[]` are integers, and the size of the array is between 1 and 10^5.

2. Expected Output:
   - The output is an array of the same size `N`, 
     where each element represents the next greater element of the corresponding element in the input array `arr[]`.
   - If no next greater element exists for an element, the corresponding output is `-10000000`.

3. Output return type:
   - The function should return an array of integers containing the next greater element for each index, or `-10000000` if there is no greater element.

4. Time complexity expectations:
   - The time complexity should be efficient enough to handle the input size up to 10^5. 
     A solution with O(N * log(N)) complexity is expected, which indicates the use of efficient algorithms like stacks and sorting.

5. Constraints:
   - Array size can go up to 10^5, which requires an optimized solution in terms of both time and space.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem is similar to the "next greater element" problem, where we need to find the next larger element for each element in the array.
   - A brute force approach would involve checking every element for each index, leading to O(N^2) time complexity, 
    which is not efficient enough for large arrays.

2. Destructuring:
   - We need to find a more efficient solution. 
     A stack-based approach is ideal because we can use a stack to keep track of elements for which we have not yet found a greater element.

3. Conversational solution into smaller subtask:
   - Step 1: Use a stack to store elements while traversing the array.
   - Step 2: For each element, if it is greater than the top of the stack,
             pop elements from the stack and set the popped element's next greater element as the current element.
   - Step 3: If no greater element is found, the default value `-10000000` will remain.
   - Step 4: Continue until all elements are processed.

*/

/* 
Conversional Solution into Subtasks:
1. Initialize an empty stack.
2. Iterate through the array from left to right:
   - For each element, check if it is greater than the top of the stack.
   - If it is, pop the stack and assign the current element as the "next greater" element for the popped elements.
3. After processing the entire array, any remaining elements in the stack have no greater element, so assign `-10000000` for them.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Initialize the stack and the result array.
2. Traverse the array, updating the result array by finding the next greater element using the stack.
3. Return the result array.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class NextGreaterElement {

    // Function to find next greater element for each element in the array
    public static int[] greaterElement(int[] arr, int n) {
        // Initialize an array to store the result
        int[] result = new int[n];
        // Initialize the result array with default value -10000000
        Arrays.fill(result, -10000000);
        
        // Stack to store elements for which we haven't found the next greater element yet
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the array from left to right
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current element is greater than the top element of the stack
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                result[index] = arr[i]; // Assign the next greater element for the popped index
            }
            // Push the current index to the stack
            stack.push(i);
        }
        
        // Elements left in the stack have no next greater element, so they are already assigned -10000000
        return result;
    }

    // Main function to test the greaterElement function
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {13, 6, 7, 12};
        int[] result1 = greaterElement(arr1, arr1.length);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();

        // Test Case 2
        int[] arr2 = {6, 3, 9, 8, 10, 2, 1, 15, 7};
        int[] result2 = greaterElement(arr2, arr2.length);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();
    }
}

/* 
Time and Space Complexity Explanation:
1. Time Complexity:
   - The time complexity of the solution is O(N) because each element is pushed and popped from the stack at most once. 
     Therefore, the overall time complexity is linear with respect to the size of the array.
   
2. Space Complexity:
   - The space complexity is O(N) due to the stack used for storing indices and the result array, both of which can hold up to N elements.

*/

/* 
For loop walkthrough:
- In the `greaterElement()` method:
   - We iterate over the array with the loop `for (int i = 0; i < n; i++)`.
   - For each element `arr[i]`, we check if it's greater than the element at the top of the stack. 
     If it is, we pop from the stack and update the result array for the corresponding index with the current element.
   - Once we finish processing the current element, we push its index to the stack.
   - After completing the loop, any remaining elements in the stack are assigned `-10000000` in the result array.

Example for input `arr = {6, 3, 9, 8, 10, 2, 1, 15, 7}`:
1. Initialize result array: `[-10000000, -10000000, -10000000, -10000000, -10000000, -10000000, -10000000, -10000000, -10000000]`
2. Traverse the array and update the result array:
   - `6` has `7` as the next greater element.
   - `3` has `6` as the next greater element.
   - `9` has `10` as the next greater element.
   - `8` has `9` as the next greater element.
   - `10` has `15` as the next greater element.
   - `2` has `3` as the next greater element.
   - `1` has `2` as the next greater element.
   - `15` has no greater element, so `-10000000` is retained.

The final result for this input is: `7 6 10 9 15 3 2 -10000000 8`.

*/

/* 
Complete code walkthrough:
- The `greaterElement()` method uses a stack to find the next greater element for each element in the input array.
- We fill the result array with `-10000000` by default, and as we process the array, we update the result array whenever we find a next greater element.
- The stack is used to keep track of elements for which we haven't found the next greater element yet, and each time we find one, we pop from the stack and update the result array.
- The time complexity is O(N), and the space complexity is O(N), which ensures that the solution works efficiently even for large inputs.
*/
