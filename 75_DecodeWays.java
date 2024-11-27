/* 
Question:
You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:
"1" -> 'A', "2" -> 'B', ..., "25" -> 'Y', "26" -> 'Z'.
However, while decoding the message, 
you realize that there are many different ways you can decode the message because some codes are contained in other codes (e.g., "2" and "5" vs "25").

The task is to determine how many different ways the given string can be decoded based on the above mapping. If the entire string cannot be decoded, return 0.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). Thus, return 0.

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
*/

/* 
Understanding the Problem Statement:
- We need to decode a string of digits into possible alphabetic representations based on a given mapping.
- Each digit or combination of two digits can represent a letter ('A' for 1, 'B' for 2, ..., 'Z' for 26).
- The string can have multiple decoding options because of overlapping codes.
- Leading zeroes are invalid, so any sequence like "06" is not valid.
- Our task is to count how many different valid ways the string can be decoded.

The problem suggests dynamic programming because we need to count the possible ways while avoiding repeated calculations.
*/

/* 
Extracting Information from the Problem Statement:

2.1 Input data type:
- A string `s` containing only digits.

2.2 Expected Output:
- The number of different ways to decode the string.

2.3 Output return type:
- An integer representing the number of decoding possibilities.

2.4 Time Complexity Expectations:
- We expect a time complexity of O(n), where n is the length of the string, because we can use dynamic programming to solve the problem in linear time.

2.5 Explanation of Given Constraints:
- The string length is at most 100, so we need to ensure the solution can handle strings of this size efficiently.
- The string contains only digits, which simplifies input validation.
*/

/* 
Thinking Solution for the Problem Statement:

3.1 Identification Part:
- This is a dynamic programming problem where we need to count the number of ways to decode a string using previous results (i.e., subproblems).
- A substring of digits can either be interpreted as a single digit or a pair of digits, and the valid mappings need to be checked for both options.

3.2 Destructuring:
- At any point, we have two choices:
  1. Treat the current digit as a single number (e.g., "2" -> 'B').
  2. Treat the current and the previous digit together as a two-digit number (e.g., "12" -> 'L').
- We can use dynamic programming to calculate how many ways we can decode up to the current index, based on previous computations.

3.3 Conversional solution into smaller subtask:
- **Subtask 1**: Initialize a DP array `dp` where `dp[i]` represents the number of ways to decode the first `i` digits of the string.
- **Subtask 2**: For each digit, check if it forms a valid single digit or if the previous and current digits form a valid two-digit number.
- **Subtask 3**: Return the value of `dp[s.length()]` as the final answer, which will represent the total number of ways to decode the entire string.

*/

/* 
Conversional Solution into subtasks:

S.no  | Subtask Description
1     | Initialize a DP array to store the number of ways to decode substrings.
2     | Iterate through the string to fill the DP array based on valid single and two-digit mappings.
3     | Return the value at `dp[s.length()]` which will be the total number of decoding ways.
*/

/* 
Subtasks of Conversional Solution into Code:

1. Initialize the `dp` array with a size of `n + 1` (for handling edge cases like an empty string or one-digit string).
2. Fill in the `dp` array by iterating through the string and checking for valid one-digit and two-digit mappings.
3. Return the last value in the `dp` array as the result.

*/

/* 
Java Code according to conversational subtasks:
*/

public class DecodeWays {
    
    // Function to calculate number of ways to decode the string
    public static int numDecodings(String s) {
        // Base case: if the string is empty, return 0
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        
        // dp[i] will store the number of ways to decode the string up to index i-1
        int[] dp = new int[n + 1];
        
        // Initializing the dp array
        dp[0] = 1; // An empty string has 1 way to decode (i.e., do nothing).
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // If the first character is '0', there's no valid way to decode it.

        // Start filling the dp array from the second character
        for (int i = 2; i <= n; i++) {
            // Check if the current digit is a valid single digit (1-9)
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Check if the two previous digits form a valid two-digit number (10-26)
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        // The answer is the number of ways to decode the entire string
        return dp[n];
    }

    public static void main(String[] args) {
        // Test case examples
        String s1 = "12";
        String s2 = "226";
        String s3 = "06";

        System.out.println(numDecodings(s1)); // Output: 2
        System.out.println(numDecodings(s2)); // Output: 3
        System.out.println(numDecodings(s3)); // Output: 0
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- We iterate through the string once and perform constant time operations for each character, so the time complexity is O(n), 
  where n is the length of the string.

Space Complexity:
- The space complexity is O(n) because we are using a DP array to store the results for each substring.

*/

/* 
If used any “for” loop or “while” loop, you have walkthrough all the “for” loop or “while” loop used in the code:

- The first `for` loop (starting from `i = 2`) iterates through the string to calculate the number of ways to decode each substring of length `i`.
- At each step, it checks if the current character forms a valid one-digit code and if the two previous characters form a valid two-digit code.

Example walkthrough with `s = "226"`:

1. Initialize `dp = [1, 1, 0, 0]` (dp[0] = 1, dp[1] = 1 because "2" is valid).
2. Iterate through the string:
   - At `i = 2`, the substring is "22", which is valid. Update `dp[2]` to `dp[2] + dp[1] = 1`.
   - At `i = 3`, the substring is "6", which is valid. Update `dp[3]` to `dp[3] + dp[2] = 3`.

Final `dp` array: `[1, 1, 2, 3]`, so the total number of ways to decode "226" is 3.

*/

