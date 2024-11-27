/*
Question:
Given a string that may contain duplicate characters, print all the distinct permutations of that string in lexicographical order.

Example:

Input: "ABCA"
Output: 
AABC AACB ABAC ABCA ACBA 
ACAB BAAC BACA BCAA CABA 
CAAB CBAA

*/

 /* 
Understanding the Problem Statement:
- The task is to generate all distinct permutations of a string, ensuring that duplicate permutations are not printed.
- For instance, the string "ABCA" will have multiple repeated permutations, so we need to make sure we only print distinct ones.
- The output should be the distinct permutations printed in lexicographical order.

What is being asked:
- The goal is to generate and print all unique permutations of the string, sorted in lexicographical order. 
- We need to ensure that no duplicate permutations are printed.
*/

/* 
Extracting Information from the Problem Statement:

2.1 Input Data Type:
- The input is a single string that may contain duplicate characters.

2.2 Expected Output:
- The output is a list of distinct permutations of the input string, printed in lexicographical order.

2.3 Output Return Type:
- The return type should be the distinct permutations, printed line by line.

2.4 Time Complexity Expectations:
- The time complexity is expected to be O(n! * n), where n is the length of the string, because generating all permutations takes O(n!) time, 
  and sorting them takes O(n log n) time. However, we are dealing with duplicates, 
  so using backtracking with a set to handle uniqueness can potentially improve the performance.

2.5 Explanation of Given Constraints:
- The input string may contain up to 10^3 characters, but due to factorial growth in the number of permutations, 
  it's likely that inputs of length > 10 will lead to excessive computational effort. 
  The approach needs to be efficient enough to handle typical cases within the problem's constraints.
*/

 /* 
Thinking Solution for the Problem Statement:

3.1 Identification Part:
- This is a backtracking problem where we need to generate all permutations, ensuring no duplicate permutations are included in the result.
- Backtracking is ideal for generating permutations, and we can prune the recursion tree to avoid repeating permutations by using a set to store permutations.

3.2 Destructuring:
- The task is essentially to generate all permutations and ensure that duplicates are removed.
- We can start with sorting the string, which helps in avoiding duplicate permutations. This way, 
  duplicates will naturally be adjacent, and we can skip them during the recursion process.
- We need to use a boolean array to track which characters have been used in the current permutation.

3.3 Conversional solution into smaller subtask:
- **Subtask 1**: Sort the string to ensure that duplicates are adjacent.
- **Subtask 2**: Use backtracking to generate all permutations, and track the characters that have been used.
- **Subtask 3**: Store the unique permutations in a set to avoid duplicates.

*/

/* 
Conversional Solution into subtasks:

S.no  | Subtask Description
1     | Sort the input string to facilitate easier handling of duplicates.
2     | Use backtracking to generate all possible permutations by selecting characters in sequence and marking them as used.
3     | Store each permutation in a set to ensure only distinct permutations are included.

*/

/* 
Subtasks of Conversional Solution into Code:

1. First, we need to sort the string to make it easier to handle duplicates.
2. Then, we'll use backtracking to generate all possible permutations, marking characters as used once we include them in the current permutation.
3. We'll store each unique permutation in a set, ensuring that no duplicates are printed.
4. Finally, we will sort the set and print the permutations.

*/

/* 
Java Code according to conversational subtasks:
*/

import java.util.*;

public class PrintDistinctPermutations {

    // Function to generate and print all distinct permutations
    public static void printPermutations(String str) {
        // Step 1: Convert the string to a character array and sort it
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        // Step 2: Use a set to store unique permutations
        Set<String> result = new TreeSet<>(); // TreeSet to maintain lexicographical order

        // Step 3: Backtracking function to generate permutations
        backtrack(arr, new StringBuilder(), new boolean[arr.length], result);

        // Step 4: Print all distinct permutations
        for (String perm : result) {
            System.out.println(perm);
        }
    }

    // Helper function for backtracking to generate permutations
    private static void backtrack(char[] arr, StringBuilder current, boolean[] used, Set<String> result) {
        // Base case: If the current string length equals the array length, we have a complete permutation
        if (current.length() == arr.length) {
            result.add(current.toString());
            return;
        }

        // Try each character at the current position
        for (int i = 0; i < arr.length; i++) {
            // Skip used characters or duplicates in the same position (to avoid redundant permutations)
            if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) {
                continue;
            }

            // Mark the current character as used
            used[i] = true;
            // Add the current character to the current permutation
            current.append(arr[i]);

            // Recursively generate the next character in the permutation
            backtrack(arr, current, used, result);

            // Backtrack: remove the last character and mark it as unused
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        // Example 1: Test case with duplicates
        String input1 = "ABCA";
        System.out.println("Distinct permutations of " + input1 + ":");
        printPermutations(input1);
        System.out.println();

        // Example 2: Another test case with duplicates
        String input2 = "AAB";
        System.out.println("Distinct permutations of " + input2 + ":");
        printPermutations(input2);
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- Sorting the array takes O(n log n) time, where n is the length of the string.
- Generating all permutations using backtracking will take O(n!) time in the worst case, where n is the length of the string.
- Adding to the set and printing the result also takes O(n!) time.
- Overall, the time complexity is O(n log n + n!) due to sorting and permutation generation.

Space Complexity:
- We use O(n) space for the recursive call stack in the backtracking function.
- The set `result` will store all distinct permutations, requiring O(n!) space in the worst case.
- Thus, the space complexity is O(n + n!) due to recursion and the space used by the set to store permutations.

*/

/* 
If used any “for” loop or “while” loop, you have walkthrough all the “for” loop used in the code:

1. The first `for` loop (`for (int i = 0; i < arr.length; i++)`) is used to try each character at the current position in the permutation.
2. The second `for` loop in the `backtrack` function 
   checks for duplicates and ensures that only distinct permutations are generated by skipping characters that have already been used 
   or are the same as the previous character (if not used).

Example walkthrough with input `"ABCA"`:

1. The string `"ABCA"` is sorted into `["A", "A", "B", "C"]`.
2. The backtracking function starts, and we try to build the permutation by selecting one character at a time. 
   If the character has already been used or is a duplicate and hasn't been used earlier, it is skipped.
3. The function generates distinct permutations and stores them in a `TreeSet` to automatically maintain lexicographical order.
4. The result is printed at the end.

*/

