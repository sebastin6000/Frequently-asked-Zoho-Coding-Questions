/* 
    Question Section:
    Given an array arr[], 
    return the modified array in such a way that if the current and next numbers are valid and equal, 
    then double the current number value and replace the next number with 0. After modification, 
    rearrange the array such that all 0's are shifted to the end. Assume '0' as the invalid number and all others as valid.

    Example 1:
    Input: arr[] = [2, 2, 0, 4, 0, 8]
    Output: [4, 4, 8, 0, 0, 0]
    Explanation: 2 and 2 are equal, so the first 2 becomes 4 and the second 2 becomes 0. Then we move all zeros to the end.

    Example 2:
    Input: arr[] = [0, 2, 2, 2, 0, 6, 6, 0, 0, 8]
    Output: [4, 2, 12, 8, 0, 0, 0, 0, 0, 0]
    Explanation: 2 and 2 are equal, so the first 2 becomes 4 and the second becomes 0. 
    Similarly, 6 and 6 become 12 and the second 6 becomes 0. Finally, all zeros are moved to the end.
*/

/* 
    Understanding the Problem Statement:
    - We need to process the array such that if adjacent valid numbers are the same, we double the first number and replace the second one with 0.
    - After all transformations, we need to shift all zeros to the end of the array, maintaining the order of valid numbers.
    - The valid numbers are all non-zero values and 0 is considered invalid.
*/

/* 
    Extracting Information from the Problem Statement:
    2.1 Input: An array of integers.
    2.2 Expected Output: A modified array where valid numbers are doubled when they are equal to the next valid number, 
    and all zeros are shifted to the end.
    2.3 Output type: Array of integers.
    2.4 Time Complexity: O(n), where n is the length of the array.
    2.5 Space Complexity: O(n), as we are using extra space for rearranging the array.
*/

/* 
    Thinking Solution for the Problem Statement:
    3.1 The problem requires checking adjacent numbers and performing actions based on whether they are equal. 
    After modifications, all zeros must be pushed to the end while maintaining the order of non-zero numbers.
    
    3.2 Solution Steps:
    - Traverse the array to check for adjacent equal valid numbers.
    - Modify the array by doubling the current number and setting the next number to 0.
    - After modifying the array, rearrange it to shift all zeros to the end.

    3.3 Breaking the problem into subtasks:
    - Step 1: Traverse the array and identify pairs of adjacent equal valid numbers.
    - Step 2: Modify the values as per the problem statement.
    - Step 3: Move all zeros to the end, maintaining the order of non-zero elements.
*/

/* 
    Conversional Solution into Subtasks:
    S.no    | Subtask Description
    --------|--------------------------------------------------------
    1       | Traverse the array to check for adjacent equal numbers.
    2       | Double the current number and set the next to 0.
    3       | Shift all zeros to the end.
*/

/* 
    Java Code According to Conversational Subtasks:
*/

import java.util.Arrays;

public class ArrayModification {

    public static int[] modifyArray(int[] arr) {
        int n = arr.length;
        
        // Step 1: Traverse the array and modify adjacent equal numbers.
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] *= 2; // Double the current number
                arr[i + 1] = 0; // Replace the next number with 0
            }
        }
        
        // Step 2: Rearrange the array to move zeros to the end
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i]; // Shift non-zero numbers forward
            }
        }
        
        // Step 3: Fill the remaining positions with 0
        while (index < n) {
            arr[index++] = 0;
        }
        
        return arr;
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {2, 2, 0, 4, 0, 8};
        System.out.println("Modified Array: " + Arrays.toString(modifyArray(arr1)));
        
        // Example 2
        int[] arr2 = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
        System.out.println("Modified Array: " + Arrays.toString(modifyArray(arr2)));
    }
}

/* 
    Time and Space Complexity Explanation:
    Time Complexity: O(n) 
    - We iterate through the array twice, once for modifying the values and once for shifting non-zero values. Hence, it is O(n).
    
    Space Complexity: O(n)
    - The space used is for storing the modified array, so it’s O(n).
*/

/* 
    For Loop Walkthrough:
    For the first example, arr1 = [2, 2, 0, 4, 0, 8]:
    - Iteration 1: i=0, arr[0] == arr[1], so arr[0] becomes 4 and arr[1] becomes 0.
    - Iteration 2: i=1, arr[1] is 0, so we skip.
    - Iteration 3: i=2, arr[2] is 0, so we skip.
    - Iteration 4: i=3, arr[3] is 4 and arr[4] is 0, no modification.
    - Iteration 5: i=4, arr[4] is 0, no modification.
    - Iteration 6: i=5, arr[5] is 8, no modification.

    After modification, we shift non-zero values forward and push zeros to the end, resulting in [4, 4, 8, 0, 0, 0].

    For the second example, arr2 = [0, 2, 2, 2, 0, 6, 6, 0, 0, 8]:
    - Iteration 1: i=1, arr[1] == arr[2], so arr[1] becomes 4 and arr[2] becomes 0.
    - Iteration 2: i=2, arr[2] is 0, so we skip.
    - Iteration 3: i=3, arr[3] == arr[4], so arr[3] becomes 12 and arr[4] becomes 0.
    - Iteration 4: i=5, arr[5] == arr[6], so arr[5] becomes 12 and arr[6] becomes 0.
    - Iteration 5: i=6, arr[6] is 0, so we skip.
    - Iteration 6: i=7, arr[7] is 8, no modification.

    After modification, we shift non-zero values forward and push zeros to the end, resulting in [4, 2, 12, 8, 0, 0, 0, 0, 0, 0].
*/

/* 
    Complete Code Walkthrough:
    - We traverse through the array, identifying adjacent equal non-zero numbers and doubling the first number while setting the second to 0.
    - We then shift all non-zero numbers forward and fill the remaining positions with zeros.
    - Finally, we return the modified array.
*/
