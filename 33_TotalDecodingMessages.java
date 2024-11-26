/* 
Question:
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.

For example:

Input: s = "123"
Output: 3
Explanation: "123" can be decoded as "ABC" (123), "LC" (12 3), and "AW" (1 23).

Input: s = "90"
Output: 0
Explanation: "90" cannot be decoded as it's an invalid string and we cannot decode '0'.

Your task is to write a function to find the number of ways to decode the given string.

Constraints:
1 <= |s| <= 10^3
*/

 /* 
Understanding the Problem Statement:
- You are given a string `s` containing only digits. Each digit can represent a letter according to the mapping: '1' -> 'A', '2' -> 'B', ..., '26' -> 'Z'.
- The goal is to find the total number of possible ways to decode the string based on this mapping.
- The challenge is to handle cases where multiple valid decodings are possible, such as "123" which can be decoded as "ABC", "LC", or "AW".
- The problem becomes tricky when dealing with invalid cases like strings that include '0' since '0' has no valid mapping.
- The solution involves checking for both single and two-digit combinations and determining how many valid decodings can be formed.

What is being asked:
- We need to compute the total number of valid decodings of the given string `s`.
- We must handle invalid cases where '0' appears alone or in invalid combinations.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A string `s` consisting of digits ('0' through '9') representing the encoded message.
2. Expected Output:
   - An integer representing the total number of ways to decode the string.
3. Output return type:
   - Integer.
4. Time complexity expectations:
   - The solution should be efficient enough to handle strings with a length of up to 1000.
5. Constraints:
   - 1 <= |s| <= 1000
   - The input string may contain '0', but it must be properly handled since '0' does not have a direct mapping.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a dynamic programming problem. We need to determine how many ways the string can be decoded, 
     considering both one-digit and two-digit possibilities.
   - This problem can be solved using a bottom-up approach by maintaining a state that tracks the number of ways to decode substrings of the input string.

2. Destructuring:
   - If the current character is a valid one (i.e., between '1' and '9'), we can continue decoding it as a single character.
   - If the last two characters form a valid number (i.e., between '10' and '26'), we can decode it as a two-character combination.
   - We need to account for invalid cases, such as when a '0' appears without a valid leading digit.

3. Conversional solution into smaller subtask:
   - Subtask 1: Initialize a dynamic programming (DP) array where each element `dp[i]` represents the number of ways to decode the substring `s[0..i-1]`.
   - Subtask 2: Fill the DP array by iterating through the string and checking both one-character and two-character possibilities.
   - Subtask 3: Handle edge cases like '0' and strings starting with '0'.
   - Subtask 4: Return the value in the last element of the DP array, which gives the total number of ways to decode the entire string.

*/

/* 
Conversional Solution into Subtasks:
1. Initialize a DP array where dp[i] stores the number of ways to decode the substring `s[0..i-1]`.
2. Iterate through the string, for each character, check:
   - If it's a valid single digit, add the previous value of dp.
   - If it's a valid two-digit number, add the value of dp from two positions back.
3. Handle edge cases like '0' and ensure that invalid combinations are skipped.
4. Return dp[n], where n is the length of the string, representing the total number of valid decodings.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Initialize the DP array.
2. Iterate through the string and update the DP values based on one-character and two-character possibilities.
3. Return the final result from dp[n].
*/

/* 
Java Code according to conversational subtasks.
*/

public class DecodeWays {

    // Function to find the number of ways to decode the given string
    public static int numDecodings(String s) {
        // Handle edge case: if the string is empty or starts with '0'
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        
        // DP array to store the number of ways to decode up to the i-th index
        int[] dp = new int[n + 1];
        
        // Base case: there's one way to decode an empty string
        dp[0] = 1;
        
        // Base case: There's one way to decode the string of length 1 if it's not '0'
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        // Iterate over the string starting from index 2
        for (int i = 2; i <= n; i++) {
            // Check for valid single digit decoding (s[i-1])
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            // Check for valid two digit decoding (s[i-2] and s[i-1])
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        // Return the number of ways to decode the entire string
        return dp[n];
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        String s1 = "123";
        System.out.println(numDecodings(s1));  // Expected output: 3

        // Test case 2
        String s2 = "90";
        System.out.println(numDecodings(s2));  // Expected output: 0
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity: O(n), where n is the length of the input string `s`. 
  We iterate through the string once and perform constant time operations at each step.
- Space Complexity: O(n), where n is the length of the input string. We use a DP array of size n+1 to store the results for substrings of length up to n.

*/

/* 
If used any “for” loop or “while” loop you have walkthrough all the “for” loop or “while” loop used in the code with every iteration with given input and this section has to be inside this structure of comments.
*/

/* 
In the main loop (from i = 2 to n):
- At each iteration, we check two things:
  1. If the current digit is not '0', we add dp[i-1] to dp[i].
  2. If the last two digits form a valid number between 10 and 26, we add dp[i-2] to dp[i].
- For example, for the input "123", we have:
  - dp[2] = dp[1] (valid "3" as a single digit) + dp[0] (valid "12" as a two-digit number).
  - dp[3] = dp[2] (valid "2" as a single digit) + dp[1] (valid "23" as a two-digit number).
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input "123":
- Initialize dp array: dp = [1, 1, 0, 0].
- For i = 2:
  - s[1] = '2' is valid, so dp[2] += dp[1] → dp[2] = 1.
  - s[0] = '1' and s[1] = '2' form 12, which is valid, so dp[2] += dp[0] → dp[2] = 2.
- For i = 3:
  - s[2] = '3' is valid, so dp[3] += dp[2] → dp[3] = 2.
  - s[1] = '2' and s[2] = '3' form 23, which is valid, so dp[3] += dp[1] → dp[3] = 3.

Final result: dp[3] = 3.

For input "90":
- Initialize dp array: dp = [1, 1, 0].
- For i = 2:
  - s[1] = '0' is not valid, so dp[2] remains 0.
Final result: dp[2] = 0.
*/
