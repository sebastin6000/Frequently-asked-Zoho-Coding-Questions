
/* 
Question:
Given a string `s` and a dictionary of words `dictionary`, find out if `s` can be segmented into a space-separated sequence of dictionary words. 
Return 1 if it is possible to break `s` into a sequence of dictionary words, else return 0. 

Note:
Each word in the dictionary can be used multiple times. 

Examples:
Input: n = 6, s = "ilike", dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
Output: 1
Explanation: The string can be segmented as "i like".

Input: n = 6, s = "ilikesamsung", dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
Output: 1
Explanation: The string can be segmented as "i like samsung" or "i like sam sung".

Expected Time Complexity: O(len(s)^2)
Expected Space Complexity: O(len(s))

Constraints:
1 ≤ n ≤ 12
1 ≤ len(s) ≤ 1100
*/

/* 
Understanding the Problem Statement:
We are asked to determine if a given string `s` can be segmented into a sequence of words that all belong to a provided dictionary.
The dictionary allows each word to be used multiple times, so the string can be split into multiple segments based on these words.
Our task is to check if such a segmentation exists and return 1 if it does, otherwise return 0.

We can approach this problem using dynamic programming 
where we maintain a DP array to store whether the string up to a certain index can be segmented using words from the dictionary.

*/

/* 
Extracting Information from the Problem Statement:
- Input Data Type: 
  - `n` is the number of words in the dictionary.
  - `s` is the string that needs to be segmented.
  - `dictionary` is a set containing words.
  
- Expected Output:
  - Return 1 if the string can be segmented, else return 0.

- Output Return Type:
  - Integer (1 or 0).
  
- Time Complexity Expectations:
  - The time complexity should be O(len(s)^2), meaning the solution should efficiently handle the string length up to 1100 characters.
  
- Constraints:
  - `1 ≤ n ≤ 12` (Number of words in the dictionary).
  - `1 ≤ len(s) ≤ 1100` (Length of the string `s`).
*/

/* 
Thinking Solution for the Problem Statement:
This problem can be solved using a dynamic programming (DP) approach. 
- We will maintain an array `dp` where `dp[i]` is `true` if the substring `s[0...i-1]` can be segmented into words from the dictionary.
- Initially, `dp[0]` is `true` because an empty string can trivially be segmented (it’s the base case).
- For each substring `s[j...i-1]`, we check if it is present in the dictionary and if the substring before it (`dp[j]`) is `true`. 
  If so, we mark `dp[i]` as `true`.
  
We need to check for all possible substrings of `s` to find if any of them matches a word in the dictionary 
and if the previous part of the string can be segmented.

*/

/* 
Conversional Solution into Subtasks:
1. Define a DP array `dp` of size `len(s) + 1` and initialize `dp[0] = true` (base case).
2. Iterate through each position `i` in the string `s`.
3. For each `i`, check all possible starting points `j` for a substring `s[j...i-1]`.
4. If `s[j...i-1]` is a valid word from the dictionary and `dp[j]` is `true`, then mark `dp[i]` as `true`.
5. After processing all characters of `s`, check `dp[len(s)]` to determine if the entire string can be segmented.
6. Return 1 if `dp[len(s)]` is `true`, otherwise return 0.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Initialize a `dp` array.
2. Iterate over the string to check possible valid segmentations.
3. For each substring, check if it's a valid dictionary word and if previous segments can be segmented.
4. Final check on the `dp` array to return the result.

*/

/* 
Java Code according to conversational subtasks:
*/

import java.util.HashSet;

public class WordSegmentation {

    // Function to check if the string s can be segmented into words from the dictionary
    public static int wordBreak(int n, String s, HashSet<String> dictionary) {
        // Step 1: Initialize a dp array of size len(s) + 1
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true; // Empty string can always be segmented

        // Step 2: Iterate over each position in the string
        for (int i = 1; i <= len; i++) {
            // Step 3: Check all possible starting points for a substring ending at position i
            for (int j = 0; j < i; j++) {
                // Step 4: If s[j...i-1] is a valid word and dp[j] is true, then mark dp[i] as true
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Once we find a valid segmentation, no need to check further
                }
            }
        }

        // Step 5: Return 1 if dp[len] is true (string can be segmented), otherwise return 0
        return dp[len] ? 1 : 0;
    }

    // Main method to test the code
    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("sam");
        dictionary.add("sung");
        dictionary.add("samsung");
        dictionary.add("mobile");

        String s1 = "ilike";
        System.out.println(wordBreak(6, s1, dictionary)); // Output: 1

        String s2 = "ilikesamsung";
        System.out.println(wordBreak(6, s2, dictionary)); // Output: 1
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:
- We iterate over the string `s` twice. The outer loop runs `len(s)` times, and the inner loop runs up to `len(s)` times as well.
- Thus, the time complexity is O(len(s)^2), which is acceptable given the constraints.

Space Complexity:
- We use a `dp` array of size `len(s) + 1` to store whether each substring can be segmented. 
- Therefore, the space complexity is O(len(s)).

*/

/* 
“for” loop walkthrough all  with every iteration with given input:

We use two loops in the code:
1. The outer loop iterates through each position `i` in the string `s`. For example, for `s = "ilike"`, the loop runs with `i` from 1 to 5 (the length of `s`).
2. The inner loop iterates over each possible starting point `j` for the substring `s[j...i-1]`. 
   It checks if the substring `s[j...i-1]` is a valid word in the dictionary and if `dp[j]` is true 
   (indicating the part of the string before this substring is segmentable).

For input `s = "ilike"` and the dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}, the loops work as follows:
- For `i = 1`: `dp[1]` is checked for all `j` from 0 to 0.
- For `i = 2`: `dp[2]` is checked for `j` from 0 to 1.
- And so on until `i = len(s)`.

*/
