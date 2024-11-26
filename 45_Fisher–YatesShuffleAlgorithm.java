/* 
Question Section:
Given an array, write a program to generate a random permutation of array elements. 
This question is also referred to as “shuffle a deck of cards” or “randomize a given array”. 
The shuffle means that every permutation of array elements should be equally likely.

Example:
Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
Output: arr[] = {7, 8, 4, 6, 3, 1, 2, 5} 
(The output can be any random permutation of the input such that all permutations are equally likely.)
*/

/* 
Understanding the Problem Statement:
1. Shuffle the given array elements so that all possible permutations of the array are equally probable.
2. This can be applied to any array, such as shuffling cards in a deck.
3. The program should ensure unbiased randomness (every permutation is equally likely).

What is being asked?
Generate a random permutation of an array such that each possible permutation is equally likely.
*/

/*
Extracting Information from the Problem Statement:
1. Input data type: Integer array (arr[]).
2. Expected Output: Randomly shuffled integer array.
3. Output return type: Integer array (arr[]).
4. Time Complexity Expectation: Efficient solution, ideally O(n).
5. Constraints:
   - The input array has a finite number of elements.
   - The array can contain integers of any value.
*/

/*
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem relates to generating a random permutation.
   - A well-known algorithm for this is the **Fisher-Yates Shuffle** (or Knuth Shuffle), which ensures unbiased shuffling.
   
2. Destructuring:
   - Traverse the array from the last element to the first.
   - For each element, pick a random index in the range [0, current index].
   - Swap the current element with the randomly chosen element.
   
3. Conversional solution into smaller subtasks:
   Subtask 1: Traverse the array in reverse order.
   Subtask 2: Pick a random index in the valid range using a random number generator.
   Subtask 3: Swap the current element with the randomly chosen element.
   Subtask 4: Repeat the process for all elements.
*/

/*
Subtasks of Conversional Solution into Code:
1. Use a for loop to traverse the array in reverse.
2. Generate a random index in the valid range using `Math.random()`.
3. Swap the elements at the current index and the randomly generated index.
4. Print the shuffled array.
*/

import java.util.*;

public class RandomPermutation {
    /* Method to generate a random permutation */
    public static void shuffleArray(int[] arr) {
        Random random = new Random(); // Initialize random object

        // Traverse the array in reverse order
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Generate a random index between 0 and i (inclusive)
            
            // Swap elements at index i and index j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /* Main method to test the code */
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Original Array: " + Arrays.toString(arr1));
        shuffleArray(arr1); // Shuffle the array
        System.out.println("Shuffled Array: " + Arrays.toString(arr1));

        // Test Case 2
        int[] arr2 = {10, 20, 30, 40, 50};
        System.out.println("Original Array: " + Arrays.toString(arr2));
        shuffleArray(arr2); // Shuffle the array
        System.out.println("Shuffled Array: " + Arrays.toString(arr2));
    }
}

/*
Time and Space Complexity Explanation:
1. Time Complexity:
   - The algorithm involves traversing the array once, i.e., O(n), where n is the size of the array.

2. Space Complexity:
   - No additional space is used except for a few variables, so the space complexity is O(1).
*/

/*
Walkthrough of "for" loop:
- Input: arr = {1, 2, 3, 4}
- Iteration 1: i = 3
  - Randomly generate index j (0 to 3), say j = 2.
  - Swap arr[3] (4) with arr[2] (3). Array becomes {1, 2, 4, 3}.
- Iteration 2: i = 2
  - Randomly generate index j (0 to 2), say j = 0.
  - Swap arr[2] (4) with arr[0] (1). Array becomes {4, 2, 1, 3}.
- Iteration 3: i = 1
  - Randomly generate index j (0 to 1), say j = 1.
  - Swap arr[1] (2) with arr[1] (no change). Array becomes {4, 2, 1, 3}.
- Final shuffled array: {4, 2, 1, 3} (example).

Complete Code Walkthrough:
Input: arr = {1, 2, 3, 4}
Step 1: Start with last element and traverse backward.
Step 2: Generate a random index and swap.
Step 3: Repeat for each element.
Output: Randomly shuffled array.
*/
