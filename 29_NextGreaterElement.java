/* 
Question:
Given an array arr[] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array. 
The next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. 
For example, next greater of the last element is always -1.

Examples

Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.

Input: arr[] = [6, 8, 0, 1, 3]
Output: [8, -1, 1, 3, -1]
Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1 , 
for 1 it is 3 and then for 3 there is no larger element on right and hence -1.

Input: arr[] = [10, 20, 30, 50]
Output: [20, 30, 50, -1]
Explanation: For a sorted array, the next element is next greater element also except for the last element.

Input: arr[] = [50, 40, 30, 10]
Output: [-1, -1, -1, -1]
Explanation: There is no greater element for any of the elements in the array, so all are -1.

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 109
*/

/* 
Understanding the Problem Statement:
- We are given an array of integers.
- For each integer in the array, we need to find the next element to its right which is greater than it.
- If no greater element exists to the right, return -1 for that element.
- The last element in the array always has -1 as its next greater element because there are no elements to its right.
*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is an integer array `arr[]` of size n.
2. Expected Output:
   - An array where each element is the next greater element for each corresponding element in the input array.
   - If no greater element exists for an element, the output for that element is -1.
3. Output return type:
   - The output will be an integer array (same size as input array).
4. Time complexity expectations:
   - The problem requires an efficient solution due to constraints (array size up to 10^6). 
     A brute-force solution that checks each element for every other element on its right will be too slow (O(n^2)).
5. Constraints:
   - 1 ≤ arr.size() ≤ 10^6
   - 0 ≤ arr[i] ≤ 10^9
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a "Next Greater Element" problem, which can be solved efficiently using a stack.
   - We need to find the next greater element for each element of the array.
   
2. Destructuring:
   - We will iterate through the array from left to right.
   - Use a stack to keep track of elements for which we haven't found the next greater element yet.
   - When a larger element is found, we can pop elements from the stack and assign them the larger element as their next greater element.

3. Conversional Solution into smaller subtask:
   - Subtask 1: Iterate through the array from left to right.
   - Subtask 2: For each element, check if it's greater than the element stored in the stack. If yes, update the output and pop the stack.
   - Subtask 3: If the stack is empty, append -1 as the next greater element for the current element.
*/

/* 
Conversional Solution into Subtasks:
1. Start by creating an empty stack to hold the indices of the elements for which we need to find the next greater element.
2. Traverse the array:
   - For each element, check if the current element is greater than the element represented by the index at the top of the stack.
   - If it is, pop the stack and set the current element as the next greater element for the popped element.
   - Push the index of the current element onto the stack.
3. After traversing the array, for any remaining elements in the stack, set their next greater element to -1.
*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a result array to store the next greater elements.
2. Traverse the array while using a stack to keep track of indices.
3. For each element, check the stack and update the result array accordingly.
4. Print the result array at the end.
*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.Stack;

public class NextGreaterElement {
    
    public static int[] findNextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Initialize result array with -1 (default value)
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current element is greater than the element at the index of the top of the stack
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                // Pop the index and set the result for that index
                int index = stack.pop();
                result[index] = arr[i];
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        // The remaining elements in the stack have no greater element, so they are already set to -1 in the result array
        return result;
    }

    // Main method to test the code
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] result = findNextGreater(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity: O(n), where n is the size of the input array. Each element is pushed and popped from the stack at most once.
- Space Complexity: O(n), for storing the result array and the stack (which can contain at most n elements).

If we consider the time complexity of the algorithm, it is optimal because we are only making a single pass over the input array, 
and each element is processed once by pushing it to the stack and potentially popping it.

*/

/* 
“for” loop  walkthrough with every iteration with given input:
*/

 /*
 Walkthrough of the "for" loop:
 We are iterating over each element of the array and using the stack to find the next greater element.

 Initial array: [6, 8, 0, 1, 3]
 Result array (initially filled with -1): [-1, -1, -1, -1, -1]
 Stack: []

 1. First iteration (i = 0, element = 6):
    - The stack is empty, so we push index 0 onto the stack.
    Stack: [0]

 2. Second iteration (i = 1, element = 8):
    - 8 is greater than 6 (arr[stack.peek()] = arr[0] = 6), so we pop the stack and set result[0] = 8.
    Result array: [8, -1, -1, -1, -1]
    - Now we push index 1 onto the stack.
    Stack: [1]

 3. Third iteration (i = 2, element = 0):
    - 0 is not greater than 8 (arr[stack.peek()] = arr[1] = 8), so we just push index 2 onto the stack.
    Stack: [1, 2]

 4. Fourth iteration (i = 3, element = 1):
    - 1 is not greater than 8 or 0 (arr[stack.peek()] = arr[2] = 0), so we just push index 3 onto the stack.
    Stack: [1, 2, 3]

 5. Fifth iteration (i = 4, element = 3):
    - 3 is greater than 0 (arr[stack.peek()] = arr[3] = 1), so we pop index 3 and set result[3] = 3.
    Result array: [8, -1, -1, 3, -1]
    - 3 is greater than 1, so we pop index 2 and set result[2] = 3.
    Result array: [8, -1, 3, 3, -1]
    - Now we push index 4 onto the stack.
    Stack: [1, 4]

 Final result array: [8, -1, 3, 3, -1]
 */

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

 /*
 Step-by-step walkthrough of the code with input [6, 8, 0, 1, 3]:
 
 - We initialize the stack and the result array as discussed.
 - The first element 6 is pushed to the stack.
 - The second element 8 is greater than 6, so we pop 6 from the stack and set result[0] = 8.
 - We continue processing each element of the array:
   - For 0, 1, and 3, we keep updating the result array as we find greater elements.
   - At the end, the result array is [8, -1, 3, 3, -1], which is the correct answer.
 */
