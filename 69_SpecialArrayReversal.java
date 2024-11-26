/* 
Question:
Given a string S, containing special characters and all the alphabets, 
reverse the string without affecting the positions of the special characters.

Example 1:
Input: S = "A&B"
Output: "B&A"
Explanation: As we ignore '&' and then reverse, so the answer is "B&A".

Example 2:
Input: S = "A&x#"
Output: "x&A#"
Explanation: we swap only A and x.

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function reverse() which takes the string as input and returns the required reversed string.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 ≤ |S| ≤ 10^5.
*/

/* 
Understanding the Problem Statement:
1. The input string contains both alphabets and special characters.
2. We need to reverse the string in such a way that the order of special characters remains unchanged, but the alphabetic characters are reversed.
3. The challenge is to preserve the positions of special characters while reversing the alphabetic characters in the string.

What is being asked:
- Reverse only the alphabetic characters in the string while keeping the special characters in the same positions.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A string `S` containing alphabets and special characters.
2. Expected Output:
   - A string that is reversed such that alphabetic characters are reversed and special characters remain in the same position.
3. Output return type:
   - A string containing the reversed alphabetic characters and unchanged special characters.
4. Time complexity expectations:
   - Time complexity of O(|S|), where |S| is the length of the string, because we need to traverse the string at least once to process each character.
5. Constraints:
   - The length of the string can be up to 100,000, so the solution should be efficient (O(n) time complexity).

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem is about reversing a string with constraints. 
     We need to reverse only the alphabetic characters and preserve the positions of special characters.

2. Destructuring:
   - We'll traverse the string and collect all alphabetic characters in a list.
   - Then, we'll create a new string, where for each position in the original string:
     - If the character is alphabetic, we pop an element from the list of alphabetic characters (to reverse the order).
     - If it's a special character, we keep it in its original position.

3. Conversational solution into smaller subtask:
   - Step 1: Traverse the string and collect all alphabetic characters in a list.
   - Step 2: Traverse the string again, building the result:
     - If the character is alphabetic, take an element from the list and place it in the result.
     - If the character is a special character, directly append it to the result.
   - Step 3: Return the result string.

*/

/* 
Conversional Solution into Subtasks:
1. Traverse the string to extract all alphabetic characters.
2. Traverse the string again to build the result string while placing the alphabetic characters in reverse order and keeping the special characters intact.
3. Return the modified string.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Collect all alphabetic characters from the string.
2. Traverse the string again and construct the output string by reversing the alphabetic characters and preserving special characters' positions.
3. Return the final result.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class ReverseStringWithoutAffectingSpecialCharacters {

    // Function to reverse the string while keeping special characters in place
    public static String reverse(String s) {
        // Step 1: Extract all alphabetic characters from the string and store them in a list
        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                letters.add(s.charAt(i));
            }
        }
        
        // Step 2: Traverse the string again and construct the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                // Pop from the list to get the reversed alphabetic characters
                result.append(letters.remove(letters.size() - 1));
            } else {
                // Special character, append it as is
                result.append(s.charAt(i));
            }
        }
        
        // Step 3: Return the final string
        return result.toString();
    }

    // Main function to test the reverse() function
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "A&B";
        System.out.println(reverse(s1)); // Expected output: "B&A"
        
        // Test Case 2
        String s2 = "A&x#";
        System.out.println(reverse(s2)); // Expected output: "x&A#"
        
        // Test Case 3
        String s3 = "A#C&D";
        System.out.println(reverse(s3)); // Expected output: "D#C&A"
        
        // Test Case 4
        String s4 = "a1b2c3";
        System.out.println(reverse(s4)); // Expected output: "c1b2a3"
    }
}

/* 
Time and Space Complexity Explanation:
1. Time Complexity:
   - We traverse the string twice: once to collect the alphabetic characters and once to construct the result string. 
     Thus, the time complexity is O(|S|), where |S| is the length of the string.

2. Space Complexity:
   - We store the alphabetic characters in a list, which requires O(|S|) space in the worst case (if the entire string consists of alphabetic characters).
   - Therefore, the space complexity is O(|S|).

*/

/* 
For loop walkthrough:
- In the `reverse()` method:
   - The first `for` loop collects all the alphabetic characters and stores them in the `letters` list.
   - The second `for` loop builds the result string by appending characters from `letters` (in reverse order) 
     or copying special characters directly to the result string.

Example for input "A&B":
1. In the first loop, the list `letters` becomes ['A', 'B'].
2. In the second loop:
   - 'A' is replaced by 'B' from the end of the list.
   - '&' remains in place.
   - 'B' is replaced by 'A' from the end of the list.
3. Result: "B&A".

*/

/* 
Complete code walkthrough:
- For input "A&B":
  1. In the first loop, we collect 'A' and 'B' into the list `letters`.
  2. In the second loop:
     - The first alphabetic character 'A' is replaced by 'B' from the list.
     - The special character '&' is unchanged.
     - The second alphabetic character 'B' is replaced by 'A' from the list.
  3. The final string becomes "B&A", which is the expected output.

*/ 
