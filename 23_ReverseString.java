/* 
-------------------------------
Question Section:
-------------------------------
Given a string `S` containing special characters and all the alphabets, the task is to reverse the string without affecting the positions of the special characters. We need to swap only the alphabets and ignore the special characters during the reversal process.

For example:
Example 1:
Input: "A&B"
Output: "B&A"
Explanation: We reverse the alphabetic characters while keeping the special character '&' in its original position.

Example 2:
Input: "A&x#"
Output: "x&A#"
Explanation: We reverse the alphabetic characters, so "A" and "x" are swapped, while '&' and '#' remain in their positions.

Your task is to implement the function `reverse()` that takes the string `S` as input and returns the required reversed string.

-------------------------------
*/

/* 
-------------------------------
Understanding the Problem Statement Section:
-------------------------------
The problem asks us to reverse a string such that only the alphabetic characters are reversed while keeping the special characters in their original positions. 
For example:
- In "A&B", we reverse the alphabetic characters 'A' and 'B', but the special character '&' stays in place.
- In "A&x#", we swap 'A' and 'x', but '&' and '#' remain unchanged.

This involves:
1. Identifying and isolating the alphabetic characters from the special characters.
2. Reversing the alphabetic characters.
3. Reconstructing the string while placing the reversed characters back into their original positions, preserving the special characters.

-------------------------------
*/

/* 
-------------------------------
Extracting Information from the Problem Statement Section:
-------------------------------
- Input: A string `S` which contains alphabetic characters and special characters.
- Output: A string where the alphabetic characters are reversed, and the special characters remain at their original positions.
- Constraints: The length of the string |S| is between 1 and 100,000.
- Time Complexity: O(|S|), where |S| is the length of the input string, since we must traverse the string to separate the characters and then reconstruct it.
- Space Complexity: O(|S|), since we are storing the reversed characters and the original string in auxiliary space.

-------------------------------
*/

/* 
-------------------------------
Thinking Solution for the Problem Statement Section:
-------------------------------
To solve the problem efficiently:
1. Identify all the alphabetic characters in the string and store them in a separate list or stack.
2. Traverse the string again and for each character:
   - If it's an alphabetic character, replace it with the next character from the list (in reverse order).
   - If it's a special character, leave it as is.
3. This approach ensures that we only reverse the alphabetic characters while preserving the special character positions.

-------------------------------
*/

/* 
-------------------------------
Conversional Solution into Subtasks Section:
-------------------------------
The solution can be broken down into the following subtasks:

Subtask 1: Identify and separate the alphabetic characters.
Subtask 2: Store the alphabetic characters in a stack or list so that they can be reversed.
Subtask 3: Traverse the string again and reconstruct the string by placing the reversed alphabetic characters and leaving the special characters untouched.
Subtask 4: Return the reconstructed string.

-------------------------------
*/

/* 
-------------------------------
Subtasks of Conversional Solution into Code Section:
-------------------------------
Subtask 1:
- Iterate through the string and collect all alphabetic characters.
Subtask 2:
- Use a stack to reverse the alphabetic characters.
Subtask 3:
- Reconstruct the string, replacing alphabetic characters with the reversed ones, and keeping special characters in their original positions.
Subtask 4:
- Return the final reconstructed string.

-------------------------------
*/

/* 
-------------------------------
Java Code according to Conversational Subtasks Section:
-------------------------------
*/
public class ReverseString {

    // Subtask 1: Reverse the string while keeping special characters in place.
    public String reverse(String S) {
        // Step 1: Collect all the alphabetic characters in a stack.
        StringBuilder alphabets = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                alphabets.append(c);
            }
        }
        
        // Step 2: Use a StringBuilder to build the final result.
        StringBuilder result = new StringBuilder();
        
        // Step 3: Traverse the original string and place the reversed alphabetic characters in the result.
        for (char c : S.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                // Pop the last alphabetic character from the stack (reverse order)
                result.append(alphabets.charAt(alphabets.length() - 1));
                alphabets.deleteCharAt(alphabets.length() - 1); // Remove the used character
            } else {
                // Special character, just append it.
                result.append(c);
            }
        }
        
        // Step 4: Return the result.
        return result.toString();
    }

    // Subtask 4: Main method for testing
    public static void main(String[] args) {
        ReverseString reverser = new ReverseString();
        System.out.println(reverser.reverse("A&B")); // Output: B&A
        System.out.println(reverser.reverse("A&x#")); // Output: x&A#
    }
}

/* 
-------------------------------
Time and Space Complexity Explanation Section:
-------------------------------
Time Complexity:
- The time complexity is O(|S|), where |S| is the length of the input string. This is because:
  - We traverse the string once to collect the alphabetic characters.
  - We traverse the string again to reconstruct it with the reversed alphabetic characters.
  Thus, we make two passes over the string, each of which takes O(|S|) time.

Space Complexity:
- The space complexity is O(|S|) because we are storing the alphabetic characters separately in a `StringBuilder` and constructing the final result in another `StringBuilder`.

-------------------------------
*/

/* 
-------------------------------
If used any “for” loop or “while” loop you have walkthrough all the “for” loop or “while” loop used in the code with every iteration with given input and this section has to be inside this structure of comments:
-------------------------------
For loop walkthrough:

For input "A&B":
1. First, we iterate over the string to collect the alphabetic characters:
   - 'A' is alphabetic, so we add it to `alphabets`. Now `alphabets = "A"`.
   - '&' is a special character, so we skip it.
   - 'B' is alphabetic, so we add it to `alphabets`. Now `alphabets = "AB"`.
   
2. Next, we traverse the string again to construct the result:
   - 'A' is alphabetic, so we append the last character from `alphabets` ("B") to the result. Now `result = "B"`.
   - '&' is a special character, so we append it unchanged. Now `result = "B&"`.
   - 'B' is alphabetic, so we append the last character from `alphabets` ("A") to the result. Now `result = "B&A"`.
   
Thus, the final output is "B&A".

-------------------------------
*/

/* 
-------------------------------
Complete code walkthrough with applying the given input in code and explanation has to be in simple English because I have to explain the question and approach my friends and this section has to be inside this structure of comments:
-------------------------------
The input string "A&B" is processed in two main steps:
1. First, we extract the alphabetic characters 'A' and 'B' into a separate string or stack.
2. Then, we reconstruct the string while keeping special characters in their original positions. The alphabetic characters are placed in reverse order.

For input "A&B", the alphabetic characters are reversed to "B&A", while the special character '&' remains in its original place. The final output is "B&A".

This approach ensures that we only reverse the alphabetic characters while preserving the positions of the special characters.

-------------------------------
*/
