/* 
Given two strings A and B, find if A is a subsequence of B.

Example 1:
Input: 
A = "AXY", B = "YADXCP"
Output: 0
Explanation: A is not a subsequence of B because 'Y' appears before 'A'.

Example 2:
Input:
A = "gksrek", B = "geeksforgeeks"
Output: 1
Explanation: A is a subsequence of B.

Your Task:
You don't need to read input or print anything. 
Complete the function isSubSequence() 
which takes A and B as input parameters and returns a boolean value denoting if A is a subsequence of B or not.

Expected Time Complexity: O(N) where N is the length of string B.
Expected Auxiliary Space: O(1)
Constraints: 1 <= |A|, |B| <= 10^4.
*/
  
/* 
Explanation of Input and Output:

Input:
A = "AXY", B = "YADXCP"
Output: 0 (A is NOT a subsequence of B)

Input:
A = "gksrek", B = "geeksforgeeks"
Output: 1 (A is a subsequence of B)
*/

  
/* 
Constraints:
1. The lengths of both strings A and B are between 1 and 10,000 characters.
2. A subsequence means that the characters of A appear in B in the same order, but not necessarily consecutively.

For example:
- In the strings "AXY" and "YADXCP", "AXY" is NOT a subsequence of "YADXCP" because the 'A' comes after 'X' in the string B, but not in the correct order.
- In the strings "gksrek" and "geeksforgeeks", "gksrek" is a subsequence of "geeksforgeeks" because all characters appear in order in the larger string.
*/

  
/* 
Relatable Analogy - Treasure Hunt:

Imagine you are on a treasure hunt with a "list of clues" (string A) and a "map" (string B).
Your goal is to check if you can find the clues in order on the map.

- The "list of clues" A must be followed in sequence on the "map" B, but you don't need to follow them consecutively, just in the correct order.
- For example, if A = "AXY" and B = "YADXCP", you can't find 'A' before 'X' on the map, so A is not a subsequence of B.
- But if A = "gksrek" and B = "geeksforgeeks", you can find the characters of A in order on the map, so A is a subsequence of B.

We will use two pointers to check if we can trace A's clues in B's map.
*/


  
/* 
Relatable Analogy Java Code Step by Step:

1. Define a function `isSubSequence(A, B)` that accepts two strings A and B.
2. Initialize two pointers, `i` for A and `j` for B, both starting from the beginning of their respective strings.
3. Iterate through B using the pointer `j`.
If the character in A matches the character in B,
move to the next character in A (increment pointer `i`).
4. Always move the pointer `j` in B to the next character.
5. If you reach the end of A (i.e., `i == A.length()`), return true,
indicating that A is a subsequence of B.
6. If you reach the end of B and haven't matched all characters of A, return false.
*/

public class Solution {
    public int isSubSequence(String A, String B) {
        // Step 1: Initialize two pointers for A and B
        int i = 0, j = 0;
        
        // Step 2: Traverse B and try to match characters of A in order
        while (i < A.length() && j < B.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                i++; // Move pointer in A
            }
            j++; // Move pointer in B
            
            /*  
                 Sure! Let me break down the specific part of the code you're referring to and explain it in simple terms.

                Here’s the code snippet you're talking about:
                
                while (i < A.length() && j < B.length()) {
                    if (A.charAt(i) == B.charAt(j)) {
                        i++; // Move pointer in A
                    }
                    j++; // Always move pointer in B
                }
                
                Explanation:
                
                This section of the code is part of the two-pointer approach we're using to check if string `A` is a subsequence of string `B`.
                
                What does this part do?
                
                1. `while (i < A.length() && j < B.length())`:
                    - This loop continues as long as both pointers (`i` for string A, and `j` for string B)
                      haven't gone past the end of their respective strings. 
                    - We need to check every character in `A` to see if it appears in order within `B`,
                      so the loop runs until either we finish checking all characters of `A` or `B`.
                
                2. `if (A.charAt(i) == B.charAt(j))`:
                    - Inside the loop,
                      we check if the current character of `A` (pointed to by `i`) matches the current character of `B` (pointed to by `j`).
                    - If the characters match,
                      it means that the current character in `A` has been found in `B` at the correct position. 
                      This is a key condition because, in a subsequence, the order of characters must be preserved.
                
                3. `i++`:
                    - If the characters match (`A.charAt(i) == B.charAt(j)`), we move the pointer `i` in `A` to the next character.
                    - This indicates that we've successfully matched the character at position `i` in `A` with a character in `B`, 
                      so we now need to check the next character in `A`.
                
                4. `j++`:
                    - Regardless of whether there was a match or not, we always move the pointer `j` in `B` to the next character.
                    - This ensures that we continue scanning through string `B` looking for matches for the next character in `A`.
                
                 Key Points:
                
                - The purpose of this loop is to check if all characters of `A` can be found in `B` in the same order. 
                  It doesn’t require the characters to be adjacent, but they must be in the correct sequence.
                  
                - We increment the pointer `i` only when we find a match in `B` for the current character of `A`.
                  If there is no match, we just move the pointer `j` to the next character in `B` without changing `i`.
                
                 Example Walkthrough:
                
                Let’s take an example:
                
                - `A = "gksrek"`
                - `B = "geeksforgeeks"`
                
                We will walk through this part of the code with these inputs:
                
                1. Initial values:
                   - `i = 0` (pointing to 'g' in A)
                   - `j = 0` (pointing to 'g' in B)
                
                2. First iteration (i = 0, j = 0):
                   - `A.charAt(0) = 'g'` and `B.charAt(0) = 'g'`
                   - The characters match, so we increment `i` to 1 (`i++`), and move `j` to 1 (`j++`).
                
                3. Second iteration (i = 1, j = 1):
                   - `A.charAt(1) = 'k'` and `B.charAt(1) = 'e'`
                   - No match, so we move `j` to 2 (`j++`), but `i` stays the same.
                
                4. Third iteration (i = 1, j = 2):
                   - `A.charAt(1) = 'k'` and `B.charAt(2) = 'e'`
                   - No match, so we move `j` to 3 (`j++`).
                
                5. Fourth iteration (i = 1, j = 3):
                   - `A.charAt(1) = 'k'` and `B.charAt(3) = 'k'`
                   - The characters match, so we increment `i` to 2 (`i++`) and move `j` to 4 (`j++`).
                
                6. Fifth iteration (i = 2, j = 4):
                   - `A.charAt(2) = 's'` and `B.charAt(4) = 's'`
                   - The characters match, so we increment `i` to 3 (`i++`) and move `j` to 5 (`j++`).
                
                7. And so on...
                
                By the end of the loop, if `i` equals the length of `A`, 
                we know we've matched every character of `A` in `B`, which means `A` is a subsequence of `B`.
                
                ---
                
                 Why is this part of the code important?
                
                - This two-pointer technique ensures that
                  we efficiently check if `A` is a subsequence of `B` without needing to repeatedly search through `B` for each character in `A`. 
                - The key is that we only need to go through `B` once,
                  which makes this approach very efficient (O(N) time complexity).
                
                 In summary:
                
                - Pointer `i` tracks our progress through string `A`.
                - Pointer `j` tracks our progress through string `B`.
                - We move `i` only when a character from `A` matches a character from `B`.
                - We always move `j` because we need to keep searching through `B` for matching characters from `A`.
 */
            
            // Step 3: If all characters of A are matched, return true
            if (i == A.length()) {
                return 1; // A is a subsequence of B
            }
        }
        
        // Step 4: If we haven't matched all characters of A, return false
        return 0; // A is NOT a subsequence of B
    }

    // Main function for testing the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1
        String A1 = "AXY";
        String B1 = "YADXCP";
        System.out.println(sol.isSubSequence(A1, B1)); // Expected output: 0
        
        // Test case 2
        String A2 = "gksrek";
        String B2 = "geeksforgeeks";
        System.out.println(sol.isSubSequence(A2, B2)); // Expected output: 1
    }
}


  
/* 
Time and Space Complexity Explanation:

Time Complexity:
- The time complexity is O(N), where N is the length of string B. This is because we are only traversing string B once and checking if characters match with A.
- In the worst case, we will go through all characters of B and A, which makes it linear in terms of the size of B.

Space Complexity:
- The space complexity is O(1), since we are only using a constant amount of space for the two pointers (i and j).
- We are not using any extra data structures like arrays or lists, so the space usage is constant.
*/


  
/* 
FOR Loop Walkthrough:

For the input:
A = "AXY"
B = "YADXCP"

Iteration 1:
- i = 0, j = 0, A[i] = 'A', B[j] = 'Y'
- No match, increment j -> j = 1

Iteration 2:
- i = 0, j = 1, A[i] = 'A', B[j] = 'A'
- Match found, increment i -> i = 1, increment j -> j = 2

Iteration 3:
- i = 1, j = 2, A[i] = 'X', B[j] = 'D'
- No match, increment j -> j = 3

Iteration 4:
- i = 1, j = 3, A[i] = 'X', B[j] = 'X'
- Match found, increment i -> i = 2, increment j -> j = 4

Iteration 5:
- i = 2, j = 4, A[i] = 'Y', B[j] = 'C'
- No match, increment j -> j = 5

Iteration 6:
- i = 2, j = 5, A[i] = 'Y', B[j] = 'P'
- No match, increment j -> j = 6

Iteration 7:
- i = 2, j = 6, A[i] = 'Y', B[j] = 'P'
- No match, loop ends. Return 0, since A is not fully matched.

Expected output is 0 because A is not a subsequence of B.
*/


  
/* 
Complete Code Walkthrough with Applying Input:

For the input:
A = "gksrek"
B = "geeksforgeeks"

Iteration 1:
- i = 0, j = 0, A[i] = 'g', B[j] = 'g'
- Match found, increment i -> i = 1, increment j -> j = 1

Iteration 2:
- i = 1, j = 1, A[i] = 'k', B[j] = 'e'
- No match, increment j -> j = 2

Iteration 3:
- i = 1, j = 2, A[i] = 'k', B[j] = 'e'
- No match, increment j -> j = 3

Iteration 4:
- i = 1, j = 3, A[i] = 'k', B[j] = 'k'
- Match found, increment i -> i = 2, increment j -> j = 4

Iteration 5:
- i = 2, j = 4, A[i] = 's', B[j] = 's'
- Match found, increment i -> i = 3, increment j -> j = 5

Iteration 6:
- i = 3, j = 5, A[i] = 'r', B[j] = 'f'
- No match, increment j -> j = 6

Iteration 7:
- i = 3, j = 6, A[i] = 'r', B[j] = 'o'
- No match, increment j -> j = 7

... continue through all the characters.

At the end of the loop, we have matched all characters of A in B. So we return 1, indicating A is a subsequence of B.

Expected output is 1 because A is a subsequence of B.
*/

  
/* 
Code Pattern Explanation:

We used the "Two Pointers" pattern for this problem:
1. We used two pointers, one for each string (A and B), to efficiently check if A is a subsequence of B.
2. By iterating over B and trying to match the characters of A in order, we ensured that we only checked the minimum necessary characters.

Why this pattern works:
- The two-pointer approach is optimal because we only need to traverse string B once. This reduces the time complexity to O(N), which is efficient enough given the constraints.
*/
