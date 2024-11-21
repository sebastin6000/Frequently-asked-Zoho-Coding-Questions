/* 
    Question: 
    You have given two sorted arrays arr1[] & arr2[] of distinct elements. The first array has one element extra added in between. 
    Return the index of the extra element.

    Note: 0-based indexing is followed.
    
    Examples:

    Input: arr1[] = [2,4,6,8,9,10,12], arr2[] = [2,4,6,8,10,12]
    Output: 4
    Explanation: In the first array, 9 is extra added and it's index is 4.

    Input: arr1[] = [3,5,7,8,11,13], arr2[] = [3,5,7,11,13]
    Output: 3
    Explanation: In the first array, 8 is extra and it's index is 3.

    Input: arr1[] = [3,5], arr2[] = [3]
    Output: 1
    Explanation: In the first array, 5 is extra and it's index is 1.

*/

/* 
    Input-output explanation:
    
    - Input: arr1[] and arr2[] are two arrays where arr1 has one more element than arr2.
    - Output: You need to find the index of the extra element present in arr1, which is missing in arr2.
    
    Example 1:
    Input: arr1[] = [2,4,6,8,9,10,12], arr2[] = [2,4,6,8,10,12]
    - In arr1, the element "9" is extra and it is present at index 4.
    - Output: 4
    
    Example 2:
    Input: arr1[] = [3,5,7,8,11,13], arr2[] = [3,5,7,11,13]
    - In arr1, the element "8" is extra and it is present at index 3.
    - Output: 3
    
    Example 3:
    Input: arr1[] = [3,5], arr2[] = [3]
    - In arr1, the element "5" is extra and it is present at index 1.
    - Output: 1
*/

/*
    Constraints Explanation:

    - 2 <= arr1.size() <= 10^5: This means that arr1 will have between 2 and 100,000 elements.
    - 1 <= arr1[i], arr2[i] <= 10^6: The elements in both arrays are positive integers within the range of 1 to 1 million.
    - arr1 has one element extra compared to arr2.
*/

/*
    Relatable analogy or real-world scenario:

    Imagine you're in a scavenger hunt game with two groups of friends. 
    Both groups are given a list of items to find, 
    and both are supposed to have found identical items, but one group accidentally added an extra item to their list. 
    Your job is to figure out which item is extra by comparing the lists.

    - Group 1: Has one more item in their list than Group 2. 
    - Group 2: Has a perfect list of found items. 
    - Your task: You need to find out which item appears in Group 1’s list 
      but is missing in Group 2’s list, and also return the index where that extra item is located.

    Steps:
    1. Start by comparing both lists from the start.
    2. For each item in Group 2’s list, check if it matches the corresponding item in Group 1’s list.
    3. If they match, move to the next item.
    4. If they don’t match, the item in Group 1 is the extra item.
    5. The position of that extra item is the answer (the index).
*/

/* 
    Relatable analogy Java code step by step:

    Step 1: We define the arrays `arr1` and `arr2`, where arr1 has one extra element.
    Step 2: Use a loop to iterate through both arrays simultaneously.
    Step 3: Compare elements at the same index in both arrays.
    Step 4: If the elements match, move on to the next index.
    Step 5: If the elements do not match, we found the extra element in `arr1` at the current index.
    Step 6: Return the index where the extra element is located.
*/
// WITH-OUT EXPLANATION
public class FindExtraElement {

    // Step 1: Function to find the index of the extra element
    public static int findExtraElementIndex(int[] arr1, int[] arr2) {
        // Step 2: Iterate through the arrays
        for (int i = 0; i < arr2.length; i++) {
            // Step 3: Compare elements at the same index in both arrays
            if (arr1[i] != arr2[i]) {
                // Step 4: If they don't match, return the index of the extra element
                return i;
            }
        }
        // Step 5: If all elements match, the extra element is the last one in arr1
        return arr1.length - 1;
    }

    // Step 6: Main function to test the code
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 9, 10, 12};
        int[] arr2 = {2, 4, 6, 8, 10, 12};
        
        // Step 7: Call the function and print the result
        System.out.println("The index of the extra element is: " + findExtraElementIndex(arr1, arr2));
    }
}

---------------------------------------

// WITH EXPLANATION
public class FindExtraElement {

    // Step 1: Function to find the index of the extra element
    public static int findExtraElementIndex(int[] arr1, int[] arr2) {
        // Step 2: Iterate through the arrays
        for (int i = 0; i < arr2.length; i++) {
            // Step 3: Compare elements at the same index in both arrays
            if (arr1[i] != arr2[i]) {
                // Step 4: If they don't match, return the index of the extra element
                return i;
            }
        }
        // Step 5: If all elements match, the extra element is the last one in arr1
        return arr1.length - 1;
        
        /* 
            The line `return arr1.length - 1;` in the code serves to return the index of the last element in the array `arr1` 
            when no differences are found between the two arrays up to the last element of `arr2`. Let's break this down further:
            
             Why is it used?
            
            In the code, the goal is to find the index of the extra element that is present in `arr1` but not in `arr2`.
            
            Here’s the reasoning:
            
            - Scenario: If `arr2` is missing one element compared to `arr1`, 
               and all elements in `arr2` match exactly with the beginning of `arr1`, 
               the extra element will naturally be the last element in `arr1`. 
               For example, if `arr1` has one more element than `arr2`, 
               the last element in `arr1` is the extra element.
            
             Example:
            
            Consider the following arrays:
            
            ```
            int[] arr1 = {2, 4, 6, 8, 9, 10, 12};
            int[] arr2 = {2, 4, 6, 8, 9, 10};
            ```
            
            - The arrays are almost identical, but `arr2` is missing the element `12` at the end, which is present in `arr1`.
            - The loop iterates through `arr2` (which has 6 elements), 
               comparing elements in both arrays until the loop finishes because no mismatch is found. 
            - The moment the loop finishes without returning, we know the missing element is the last element of `arr1`.
            
             Why `arr1.length - 1`?
            
            - `arr1.length` gives the total number of elements in `arr1`. For example, `arr1` has 7 elements, so `arr1.length` is `7`.
            - The indices of arrays in Java are 0-based, meaning the index of the first element is `0`, the second element is `1`, and so on.
            - So, the index of the last element in the array `arr1` is `arr1.length - 1`. 
            
            In this example, `arr1.length` is `7`, and the last index is `7 - 1 = 6`. Therefore, `return arr1.length - 1;` returns `6`, 
            which is the index of the extra element `12` in `arr1`.
            
             General Use Case:
            
            If the loop completes without finding any differences (i.e., if all elements in `arr2` match those in `arr1`), 
            the extra element must be the last one in `arr1`, and `arr1.length - 1` is used to get the index of that element.
            
             Key Points:
            - `arr1.length - 1` gives the index of the last element in `arr1`.
            - This is used when all elements in `arr2` match the corresponding elements in `arr1`, and the extra element is the last one in `arr1`.
            - In situations where there is a mismatch (as in earlier iterations of the loop), 
               the function returns the index of the mismatch, so this line is only reached if no mismatch is found during the loop..
            
             Example:
            Let's go through a case where all elements in `arr2` are identical to `arr1` except for the last element:
            
            Example Scenario:
            
            ```
            int[] arr1 = {2, 4, 6, 8, 9, 10, 12};
            int[] arr2 = {2, 4, 6, 8, 9, 10};
            ```
            
             Walkthrough:
            
            - Step 1: Comparing elements in the `for` loop
            
            The `for` loop iterates through the elements of both arrays, comparing the values at each index.
            
             Iteration 1: `i = 0`
            - Compare `arr1[0]` and `arr2[0]`
              - `arr1[0] = 2`, `arr2[0] = 2`
              - The elements match, so the loop continues to the next iteration.
            
             Iteration 2: `i = 1`
            - Compare `arr1[1]` and `arr2[1]`
              - `arr1[1] = 4`, `arr2[1] = 4`
              - The elements match, so the loop continues to the next iteration.
            
             Iteration 3: `i = 2`
            - Compare `arr1[2]` and `arr2[2]`
              - `arr1[2] = 6`, `arr2[2] = 6`
              - The elements match, so the loop continues to the next iteration.
            
             Iteration 4: `i = 3`
            - Compare `arr1[3]` and `arr2[3]`
              - `arr1[3] = 8`, `arr2[3] = 8`
              - The elements match, so the loop continues to the next iteration.
            
             Iteration 5: `i = 4`
            - Compare `arr1[4]` and `arr2[4]`
              - `arr1[4] = 9`, `arr2[4] = 9`
              - The elements match, so the loop continues to the next iteration.
            
             Iteration 6: `i = 5`
            - Compare `arr1[5]` and `arr2[5]`
              - `arr1[5] = 10`, `arr2[5] = 10`
              - The elements match, so the loop completes without finding any differences.
            
            - Step 2: After the loop completes
            
            Since all elements in `arr2` matched the corresponding elements in `arr1`, 
            the loop does not return early. Instead, the method proceeds to the final step:
            
            ```
            return arr1.length - 1;
            ```
            
            - `arr1.length = 7`, so the extra element is at index `7 - 1 = 6`.
            
             Conclusion:
            - The function returns `6`, which is the index of the extra element in `arr1`.
            - The extra element in `arr1` is `arr1[6] = 12`.
            
             Final Output:
            ```
            The index of the extra element is: 6
            ```
            This demonstrates how the line `return arr1.length - 1;` is used when all elements in `arr2` 
            match the corresponding elements in `arr1`, and the extra element is the last one in `arr1`.
        */
    }

    // Step 6: Main function to test the code
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 9, 10, 12};
        int[] arr2 = {2, 4, 6, 8, 10, 12};
        
        // Step 7: Call the function and print the result
        System.out.println("The index of the extra element is: " + findExtraElementIndex(arr1, arr2));
    }
}

/*
    Time and Space Complexity Explanation:

    - Time Complexity: O(n)
    - Reason: We iterate through both arrays (arr1 and arr2) once, where n is the size of arr2. 
      Since the only extra element is at the point where the lists diverge, we only compare the elements once.
    
    - Space Complexity: O(1)
    - Reason: We are only using a few variables to track the iteration index and perform the comparison.
      We do not use any extra space that grows with the input size.

*/

/* 
    FOR loop walkthrough with every iteration with given input:

    Input: arr1 = [2, 4, 6, 8, 9, 10, 12], arr2 = [2, 4, 6, 8, 10, 12]

    Iteration 1:
    i = 0, arr1[0] = 2, arr2[0] = 2
    They match, so move to the next iteration.

    Iteration 2:
    i = 1, arr1[1] = 4, arr2[1] = 4
    They match, so move to the next iteration.

    Iteration 3:
    i = 2, arr1[2] = 6, arr2[2] = 6
    They match, so move to the next iteration.

    Iteration 4:
    i = 3, arr1[3] = 8, arr2[3] = 8
    They match, so move to the next iteration.

    Iteration 5:
    i = 4, arr1[4] = 9, arr2[4] = 10
    They don't match! So, return index 4 as the extra element is 9 in arr1.

    Output: 4
*/

/* 
    Complete code walkthrough with applying the given input:

    - We define the two arrays: arr1 = [2, 4, 6, 8, 9, 10, 12] and arr2 = [2, 4, 6, 8, 10, 12].
    - We call the `findExtraElementIndex` function with arr1 and arr2 as parameters.
    - The function iterates over both arrays:
      - At index 0, 2 matches 2.
      - At index 1, 4 matches 4.
      - At index 2, 6 matches 6.
      - At index 3, 8 matches 8.
      - At index 4, 9 doesn't match 10, so it returns index 4.
    - The output is: "The index of the extra element is: 4".
*/
