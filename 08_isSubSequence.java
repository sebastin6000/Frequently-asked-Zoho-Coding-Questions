/* 
Question:
Given two strings A and B, find if A is a subsequence of B.

A subsequence is a sequence that appears in the same relative order, but not necessarily consecutively. For example, "abc" is a subsequence of "aebdc".

Your task is to implement a function `isSubSequence()` 
that takes two strings A and B as input parameters and returns a boolean value denoting if A is a subsequence of B or not.

Example 1:
Input:
A = "AXY"
B = "YADXCP"
Output: 0 
Explanation: A is not a subsequence of B as 'Y' appears before 'A'.

Example 2:
Input:
A = "gksrek"
B = "geeksforgeeks"
Output: 1
Explanation: A is a subsequence of B.

Constraints:
1 <= |A|, |B| <= 10^4
*/

 /* 
Understanding the Problem Statement:
The problem asks to check if string A is a subsequence of string B.
A subsequence means that we can remove some (or no) characters from B without changing the order of the remaining characters, 
and the resulting string should match A.

The task is to implement a method `isSubSequence()` that takes two strings as input and returns a boolean value indicating if A is a subsequence of B.

What is being asked?
We need to determine whether all characters of A appear in B in the same order, although not necessarily consecutively.

- Expected Output: A boolean value (1 for true, 0 for false) indicating if A is a subsequence of B.

*/

/* 
Extracting Information from the Problem Statement:
- Input data type: Two strings, A and B.
- Output return data type: A boolean indicating if A is a subsequence of B.
- Constraints:
  - Both A and B can have lengths up to 10^4, so we need an efficient solution.
  
The time complexity of the solution should be O(N), where N is the length of string B.

*/

/* 
Thinking Solution for the Problem Statement:
To solve this problem, we need to:
1. Traverse string B and try to match characters of string A in order.
2. Use two pointers: one to iterate over string A and another to iterate over string B.
3. If we find a character of A in B, move the pointer for A. If the pointer for A reaches the end of string A, we know A is a subsequence of B.
4. If we finish traversing string B without fully matching string A, return false.

*/

/* 
Input to Output Conversion Steps into Smaller Subtasks:
S.No | Subtask Description
1    | Traverse through string B with a pointer to match characters of A.
2    | If all characters of A are matched in order within B, return true.
3    | If the end of B is reached and A is not fully matched, return false.

*/

/* 
Input to Output Conversion Subtasks into Code:
S.No | Subtask Description                                    | Code Approach
1    | Traverse through string B and try 
       to match characters of A.                              | Use two pointers, one for A and one for B, to check if A is a subsequence of B.
2    | Return true if all characters of A are matched.        | If the pointer for A reaches the end of A while traversing B, return true.
3    | Return false if the end of B is reached 
       and A is not matched.                                  | If the pointer for B reaches the end and A is not fully matched, return false.

*/

/* 
Code Requirement to Complete the Subtasks:
- A loop to traverse through string B.
- A pointer to traverse through string A.
- Conditions to check if we match the characters of A in B and return the appropriate result.

*/

/* Java Code According to Conversational Subtasks: */

public class SubsequenceCheck {

    /* 
    Explanation of Approach:
    1. We initialize two pointers: `i` for string A and `j` for string B.
    2. We iterate through string B and try to match each character of A in B.
    3. If characters match, we move the pointer `i` for A forward.
    4. If pointer `i` reaches the end of A, that means all characters of A have been found in B in the same order.
    5. If we complete the iteration over B and haven't matched all of A, return false.

    */

    // Function to check if A is a subsequence of B
    public static int isSubSequence(String A, String B) {
        // Pointers for A and B
        int i = 0, j = 0;
        
        // Traverse through B
        while (j < B.length()) {
            // If characters match, move pointer of A
            if (A.charAt(i) == B.charAt(j)) {
                i++;
            }
            
            // If all characters of A are matched, return 1
            if (i == A.length()) {
                return 1;
            }
            j++;
        }
        
        // If we reached the end of B and haven't matched all characters of A, return 0
        return 0;
    }

    /* 
    Explanation of Default Method Used in Code:
    - The `isSubSequence()` method takes two strings as parameters.
    - It uses two pointers, one for string A and one for string B.
    - It traverses through string B, trying to match the characters of A in order.
    - If all characters of A are found in B, it returns 1, otherwise, it returns 0.

    */

    // Main method for testing
    public static void main(String[] args) {
        // Test Case 1
        String A1 = "AXY";
        String B1 = "YADXCP";
        System.out.println(isSubSequence(A1, B1));  // Output: 0 (A is not a subsequence of B)

        // Test Case 2
        String A2 = "gksrek";
        String B2 = "geeksforgeeks";
        System.out.println(isSubSequence(A2, B2));  // Output: 1 (A is a subsequence of B)
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity: O(N), where N is the length of string B. We only traverse string B once with a pointer for A moving as needed.
- Space Complexity: O(1), since we only use a few extra variables for pointers and no additional space is required for the input or output.

*/

/* 
Explanation of "for" or "while" loop used in the code:
- The `while` loop traverses through string B using pointer `j`.
- Inside the loop, we compare characters of A and B. If they match, pointer `i` for A is moved forward.
- If all characters of A are found (i.e., `i == A.length()`), the function returns 1.
- Once the loop finishes, if A hasn't been fully matched, the function returns 0.

Example Walkthrough:
For input A = "AXY" and B = "YADXCP":
- We start with i = 0 (A) and j = 0 (B).
- First, B[j] = "Y" does not match A[i] = "A", so we move j forward.
- Then, B[j] = "A" matches A[i] = "A", so we move both pointers (i = 1, j = 2).
- Next, B[j] = "X" matches A[i] = "X", so we move both pointers (i = 2, j = 3).
- Now, B[j] = "D" does not match A[i] = "Y", so we continue moving j forward until the end.
- Since we don't find "Y" after this point, we return 0.

For input A = "gksrek" and B = "geeksforgeeks":
- We start with i = 0 (A) and j = 0 (B).
- We keep finding characters of A in B in order, moving the pointer for A as we match.
- When i reaches the length of A, we return 1, as all characters of A are matched in order in B.

*/
