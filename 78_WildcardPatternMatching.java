/* 
Question:
Given two strings `pat` and `txt`, which may be of different sizes, return true if the wildcard pattern `pat` matches the string `txt`, 
else return false. The pattern `pat` can include the characters '?' and '*':
- '?' matches any single character.
- '*' matches any sequence of characters (including the empty sequence).
The matching should cover the entire `txt` (not partial matching).

Example 1:
Input: txt = "abcde", pat = "a?c*"
Output: true
Explanation: '?' matches with 'b' and '*' matches with "de".

Example 2:
Input: txt = "baaabab", pat = "a*ab"
Output: false
Explanation: Because in string `pat` character 'a' at first position, `pat` and `txt` can't be matched.

Example 3:
Input: txt = "abc", pat = "*"
Output: true
Explanation: '*' matches with whole text "abc".

Constraints:
1 <= txt.size(), pat.size() <= 200.
*/

/* 
Understanding the Problem Statement:
- The goal is to match a given string `txt` against a pattern `pat` that can contain wildcards `?` and `*`.
- The wildcard `?` matches any single character, and `*` matches any sequence of characters (including an empty sequence).
- The task requires checking whether the entire string `txt` can be matched by the pattern `pat`, not just a partial match.

What is being asked:
- Return true if `pat` matches `txt`, considering the wildcards, else return false.
- Wildcards must be handled with care, where `?` can match a single character, and `*` can match any number of characters (even zero).

*/

/* 
Extracting Information from the Problem Statement:

2.1 Input data type:
- `txt`: A string of length `n` (1 <= n <= 200).
- `pat`: A string of length `m` (1 <= m <= 200).

2.2 Expected Output:
- A boolean indicating whether `pat` matches `txt`.

2.3 Output return type:
- Boolean (`true` or `false`).

2.4 Time Complexity Expectations:
- We are not given an explicit time complexity, but based on the constraints, the solution should ideally be O(n*m) or better.

2.5 Explanation of Given Constraints:
- The input size is manageable (up to 200 characters), so an approach with O(n*m) time complexity should be feasible.
*/

 /* 
Thinking Solution for the Problem Statement:

3.1 Identification Part:
- This is a classic problem of pattern matching with wildcards. We need to match `pat` to `txt`, considering `?` and `*`.
- A dynamic programming (DP) approach works well for this problem to consider all subproblems efficiently.

3.2 Destructuring:
- If the pattern `pat` contains `*`, it can either match no characters, or match multiple characters, 
  so we need to check all possible scenarios recursively or iteratively.
- If `pat` contains `?`, it will match exactly one character from `txt`.
- We need to ensure the entire string is matched, not just part of it.

3.3 Conversional solution into smaller subtask:
- **Subtask 1**: Define a DP table where `dp[i][j]` will represent whether `txt[0..i-1]` matches `pat[0..j-1]`.
- **Subtask 2**: Handle the `?` wildcard by checking if the previous character matched.
- **Subtask 3**: Handle the `*` wildcard by considering both cases: matching no characters (skip `*`) 
                 and matching one or more characters (move to the next character in `txt`).
- **Subtask 4**: Fill the DP table based on these rules and return the value of `dp[n][m]`.

 */

/* 
Conversional Solution into subtasks:

S.no  | Subtask Description
1     | Create a DP table where each cell represents if the current substring of `txt` matches the current substring of `pat`.
2     | Handle the `?` wildcard by ensuring it matches exactly one character from `txt`.
3     | Handle the `*` wildcard by considering both possibilities: matching no characters or matching multiple characters.
4     | Fill the DP table based on these rules and return the result in the last cell.

*/

/* 
Subtasks of Conversional Solution into Code:

1. Create a DP table `dp` of size `(n+1) x (m+1)` where `n` is the length of `txt` and `m` is the length of `pat`.
2. Initialize the base case where both `txt` and `pat` are empty strings.
3. Handle `?` by matching exactly one character.
4. Handle `*` by either matching no characters or multiple characters.
5. Return the result stored in `dp[n][m]`.

*/

/* 
Java Code according to conversational subtasks:
*/

public class WildcardPatternMatch {

    // Function to check if the pattern matches the text
    public static boolean isMatch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        
        // Initialize a DP table with false values
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        // Base case: empty pattern matches empty string
        dp[0][0] = true;
        
        // Initialize the first row for patterns like "*" which can match an empty string
        for (int j = 1; j <= m; j++) {
            if (pat.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pat.charAt(j - 1) == txt.charAt(i - 1) || pat.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1]; // Match the character or '?' matches one character
                } else if (pat.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' matches either empty or one or more characters
                }
            }
        }
        
        // The result is stored in the bottom-right corner of the DP table
        return dp[n][m];
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        // Test case examples
        String txt1 = "abcde";
        String pat1 = "a?c*";
        System.out.println(isMatch(txt1, pat1)); // Output: true

        String txt2 = "baaabab";
        String pat2 = "a*ab";
        System.out.println(isMatch(txt2, pat2)); // Output: false

        String txt3 = "abc";
        String pat3 = "*";
        System.out.println(isMatch(txt3, pat3)); // Output: true
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- The time complexity of this solution is O(n * m), where `n` is the length of `txt` and `m` is the length of `pat`. 
  This is because we are filling a DP table of size `(n+1) x (m+1)` and each entry requires constant time to compute.

Space Complexity:
- The space complexity is O(n * m) due to the DP table, which requires storing a boolean value for each combination of substrings of `txt` and `pat`.

*/

/* 
If used any “for” loop or “while” loop, you have walkthrough all the “for” loop used in the code:

1. The first loop (`for (int j = 1; j <= m; j++)`) initializes the first row of the DP table for patterns that can match an empty string.
2. The second loop (`for (int i = 1; i <= n; i++)`) iterates through each character in `txt`.
3. The inner loop (`for (int j = 1; j <= m; j++)`) iterates through each character in `pat`, 
   updating the DP table based on whether the current character in `pat` matches the current character in `txt`.

Example walkthrough with input `txt = "abcde"` and `pat = "a?c*"`:

1. Initialize `dp[0][0] = true` because empty pattern matches empty text.
2. Process `*` in the first row, updating the DP table to handle the case of `*` matching an empty string.
3. Process the rest of the string `txt` and pattern `pat`, filling the DP table based on the matching rules.
4. The final answer is in `dp[5][4]` (bottom-right corner), which is `true` in this case.

*/
