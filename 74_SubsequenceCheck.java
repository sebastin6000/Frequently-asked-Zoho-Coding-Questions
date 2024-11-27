/* 
Question:
Given two strings s1 and s2, find out if the first string (s1) is a subsequence of the second string (s2).
A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.

Example 1: 
Input: s1 = "AXY", s2 = "ADXCPY" 
Output: True 
Explanation: All characters of s1 are in s2 in the same order.

Example 2: 
Input: s1 = "AXY", s2 = "YADXCP"
Output: False 
Explanation: All characters are present, but order is not same.

Example 3: 
Input: s1 = "gksrek", s2 = "geeksforgeeks"
Output: True
*/
  
/* 
Understanding the Problem Statement:

We are asked to check if the first string (s1) is a subsequence of the second string (s2). 
A subsequence is formed by deleting some characters from the second string while preserving the order of characters that remain. 

The task is to check if we can find all characters of s1 in s2 while maintaining the same relative order.

The question is asking us to:
- Compare s1 and s2.
- Check if we can match all characters of s1 in the same order in s2.
- Return True if s1 is a subsequence of s2, else return False.

*/
  
/* 
Extracting Information from the Problem Statement:

2.1 Input data type:
- String s1 (The first string to be checked).
- String s2 (The string in which we need to check if s1 is a subsequence).

2.2 Expected Output:
- A boolean value: 
  - True if s1 is a subsequence of s2.
  - False otherwise.

2.3 Output return type:
- Boolean (True/False).

2.4 Time Complexity Expectations:
- We expect a time complexity of O(n), where n is the length of string s2, 
  because we may need to iterate through s2 at most once to check for the subsequence.

2.5 Explanation of given Constraints:
- No explicit constraints are provided, but we can assume that the input strings will be of moderate length (up to a few thousand characters). 
  Therefore, the solution should be efficient enough to handle such inputs.
*/

  
/* 
Thinking Solution for the Problem Statement:

3.1 Identification Part:
- This is a typical "subsequence check" problem. We need to determine if we can traverse string s2 and match each character of string s1 in order.

3.2 Destructuring:
- To check if s1 is a subsequence of s2, we can iterate over s2 and try to match the characters of s1 in order.
  For every character of s1, we check if it appears in the same order in s2.

3.3 Conversional solution into smaller subtask:
- Subtask 1: Start with two pointers, one for each string, initialized to the beginning.
- Subtask 2: Iterate through s2 with a pointer. If the current character of s2 matches the current character of s1, 
             move the pointer of s1 to the next character.
- Subtask 3: If we have successfully matched all characters of s1, return True. 
             If we finish iterating through s2 without matching all characters of s1, return False.

*/

  
/* 
Conversional Solution into subtasks:

S.no  | Subtask Description
1     | Initialize two pointers: one for s1 and one for s2.
2     | Iterate through s2, trying to match characters with s1.
3     | Move the pointer on s1 when a match is found.
4     | Check if all characters of s1 have been matched by the end.
5     | Return True or False based on the result.

*/

  
/* 
Subtasks of Conversional Solution into Code:

1. Initialize two pointers: one for s1 and one for s2.
2. Use a loop to iterate through s2 and check for matches.
3. Move the pointer for s1 when a match is found.
4. If we match all characters of s1 by the end of s2, return True.
5. If not, return False.

*/

  
/* 
Java Code according to conversational subtasks:
*/

import java.util.Scanner;

public class SubsequenceCheck {

    // Function to check if s1 is a subsequence of s2
    public static boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0;
        
        // Step 1: Initialize two pointers i for s1 and j for s2.
        // We will iterate through s2 and try to match s1.
        
        while (i < s1.length() && j < s2.length()) {
            // Step 2: If characters match, move pointer i for s1
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;  // Move pointer i to the next character in s1
            }
            j++;  // Move pointer j to the next character in s2
            
            // Step 3: If we have matched all characters of s1, return true
            if (i == s1.length()) {
                return true;
            }
        }
        
        // Step 4: If we exit the loop without matching all characters of s1, return false
        return false;
    }

    public static void main(String[] args) {
        // Step 5: Test the function with different inputs
        
        Scanner sc = new Scanner(System.in);
        
        // Example Input 1: s1 = "AXY", s2 = "ADXCPY"
        String s1 = "AXY";
        String s2 = "ADXCPY";
        System.out.println(isSubsequence(s1, s2));  // Output: True
        
        // Example Input 2: s1 = "AXY", s2 = "YADXCP"
        s1 = "AXY";
        s2 = "YADXCP";
        System.out.println(isSubsequence(s1, s2));  // Output: False
        
        // Example Input 3: s1 = "gksrek", s2 = "geeksforgeeks"
        s1 = "gksrek";
        s2 = "geeksforgeeks";
        System.out.println(isSubsequence(s1, s2));  // Output: True
    }
}
  
/* 
Time and Space Complexity Explanation:

Time Complexity:
- We iterate through s2 once, so the time complexity is O(n), where n is the length of s2.
- The length of s1 doesn't affect the worst-case time complexity much, as we stop searching once all characters of s1 are matched.

Space Complexity:
- The space complexity is O(1) as we are only using a couple of pointers and no extra space proportional to the input size.

*/

  
/* 
If used any “for” loop or “while” loop, you have walkthrough all the “for” loop or “while” loop used in the code:

- The loop in the `isSubsequence` function is a `while` loop:
  - The condition `i < s1.length() && j < s2.length()` ensures we continue iterating until we've either matched all characters of s1 or exhausted s2.
  - Inside the loop, we compare the current characters of s1 and s2. 
    If they match, we move to the next character of s1 by incrementing `i`. We always move `j` to the next character of s2, 
    regardless of whether there's a match.

  Example walkthrough with s1 = "AXY" and s2 = "ADXCPY":
  - Iteration 1: i = 0, j = 0; compare 'A' with 'A' (match). Move i to 1.
  - Iteration 2: i = 1, j = 1; compare 'X' with 'D' (no match). Move j to 2.
  - Iteration 3: i = 1, j = 2; compare 'X' with 'X' (match). Move i to 2.
  - Iteration 4: i = 2, j = 3; compare 'Y' with 'C' (no match). Move j to 4.
  - Iteration 5: i = 2, j = 4; compare 'Y' with 'P' (no match). Move j to 5.
  - Iteration 6: i = 2, j = 5; compare 'Y' with 'Y' (match). Move i to 3, and since i == s1.length(), we return True.

*/

  
/* 
Complete code walkthrough with applying the given input in code and explanation:

Input 1:
- s1 = "AXY", s2 = "ADXCPY"
- The function successfully matches all characters of s1 in the same order in s2, so it returns True.

Input 2:
- s1 = "AXY", s2 = "YADXCP"
- The function fails to match all characters of s1 in the same order in s2, so it returns False.

Input 3:
- s1 = "gksrek", s2 = "geeksforgeeks"
- The function successfully matches all characters of s1 in the same order in s2, so it returns True.

*/
