
/* 
Question Section:
Given an encoded string (s) with the format where an integer `n` followed by a substring `str` enclosed in square brackets, 
the task is to decode the string. The encoding pattern is that the occurrence of the string `str` is given by the integer before the opening bracket.

For example:
1. Input: s = "1[b]"
   Output: "b"
   Explanation: 'b' is repeated once, so the result is just "b".

2. Input: s = "3[b2[ca]]"
   Output: "bcacabcacabcaca"
   Explanation: '2[ca]' means 'ca' is repeated twice ("caca"), and this is prefixed by 'b'. This 'bcaca' is then repeated 3 times to form the result.

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function `decodedString()` which takes the string `s` as input and returns the decoded string.

*/

/* 
Understanding the Problem Statement:
The input string follows an encoding pattern where substrings are enclosed in square brackets `[]`. 
A number preceding the opening bracket indicates how many times the enclosed substring should be repeated. 
The challenge is to decode this encoded string while handling possible nested substrings.

What is being asked?
We need to implement a function `decodedString()` that:
1. Decodes the string according to the specified pattern.
2. Handles nested encodings (like `2[ca]` or `3[b2[ca]]`).

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input `s` is a string that contains both numbers and substrings enclosed in square brackets.

2. Expected Output:
   - The output is a decoded string where each encoded pattern is expanded according to the number before each bracket.

3. Output return type:
   - A string representing the decoded version of the encoded string.

4. Explanation of Time complexity expectations:
   - The expected time complexity is O(|s|), where |s| is the length of the input string. We traverse the string once, processing each character.

5. Explanation of given Constraints:
   - The input string length can be up to 1000 characters, so we need an efficient approach with linear time complexity.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification:
   - The problem follows a pattern where substrings are enclosed in square brackets 
     and a number preceding them indicates how many times the substring should be repeated. 
     This resembles a stack-based problem because we need to handle nested brackets.

2. Destructuring:
   - We need to handle cases with nested square brackets and numbers.
   - We should use a stack to store intermediate results as we encounter a substring to be repeated.
   - When encountering a closing bracket, we should decode the substring inside the current scope and then repeat it according to the preceding number.

3. Conversional solution into smaller subtask:
   - Subtask 1: Traverse through the string character by character.
   - Subtask 2: For numbers before a bracket, collect the number.
   - Subtask 3: On encountering an opening bracket, start a new context for repeating substrings.
   - Subtask 4: On encountering a closing bracket, decode the substring inside the brackets, repeat it, and push it back into the result.

*/

/* 
Conversional Solution into Subtasks:
1. Traverse the string to process characters.
2. Handle digits and number parsing.
3. Use a stack to keep track of current decoded strings.
4. Handle nested brackets by pushing and popping from the stack.
5. Build the final decoded string.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Traverse the string character by character.
2. Parse the number (if any) that appears before an opening bracket.
3. Handle the opening bracket by storing current context and starting a new decoding context.
4. Handle the closing bracket by applying the repetition and popping from the stack.
5. Continue until the whole string is decoded.

*/

import java.util.Stack;

public class DecodedString {

    /* 
    Function to decode the given string.
    We use a stack to keep track of substrings and numbers, handling nested encoding patterns.
    */
    public static String decodedString(String s) {
        // Stack to hold the current string and the number of times it should be repeated.
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder(); // To build the current string.
        int currentNum = 0; // To build the current number.

        // Traverse through each character in the string.
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // If we encounter a digit, build the number (this can be multiple digits).
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and string to their respective stacks.
                numStack.push(currentNum);
                strStack.push(currentStr.toString());
                currentStr = new StringBuilder(); // Reset current string.
                currentNum = 0; // Reset current number.
            } else if (c == ']') {
                // When encountering closing bracket, we process the encoded part.
                int repeatCount = numStack.pop(); // Get the repeat count.
                String prevStr = strStack.pop(); // Get the previous string context.
                // Repeat the current string and append to the previous string.
                StringBuilder decodedPart = new StringBuilder(prevStr);
                for (int i = 0; i < repeatCount; i++) {
                    decodedPart.append(currentStr);
                }
                currentStr = decodedPart; // Set the current string to the decoded part.
            } else {
                // If it's a character, just append it to the current string.
                currentStr.append(c);
            }
        }

        // The final decoded string will be in currentStr.
        return currentStr.toString();
    }
    public static void main(String[] args) {
        // Test case 1
        String s1 = "1[b]";
        System.out.println(decodedString(s1)); // Expected: "b"
        
        // Test case 2
        String s2 = "3[b2[ca]]";
        System.out.println(decodedString(s2)); // Expected: "bcacabcacabcaca"
        
        // Test case 3
        String s3 = "2[ab]3[cd]";
        System.out.println(decodedString(s3)); // Expected: "ababcdcdcd"
    }
}

    /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - We traverse through the entire string once. For each character, we either process it, add to a stack, 
      or append to the current string. Therefore, the time complexity is O(n), where n is the length of the input string.

    Space Complexity:
    - We use two stacks (`strStack` and `numStack`), and the space complexity is proportional to the maximum depth of nested brackets. 
      In the worst case, this can be O(n), where n is the length of the string.

    */

    /* 
    Code Walkthrough:
    Let's walk through the input `s = "3[b2[ca]]"`:
    1. We encounter '3', so we start building the number and push it to the stack.
    2. We encounter '[', so we push the current string and reset.
    3. We encounter 'b', which is added to the current string.
    4. We encounter '2', which represents the repeat count for the next encoded substring.
    5. We encounter '[', so we push the number '2' and the current string into the stack.
    6. We encounter 'c', which is added to the current string.
    7. We encounter 'a', which is added to the current string.
    8. We encounter ']', so we repeat "ca" twice to get "caca".
    9. The final decoded string becomes "bcacabcacabcaca".
    */
/*
### Explanation of the Code:

1. **`decodedString(String s)`**:
   - We use two stacks: `strStack` to hold intermediate results (decoded substrings) and `numStack` to hold the repeat counts for substrings.
   - We iterate through each character of the string:
     - If it's a digit, we construct the repeat count.
     - If it's an opening bracket `[`, we push the current number and string context into the stacks and reset.
     - If it's a closing bracket `]`, we pop from the stacks, repeat the substring according to the count, and update the current string.
     - If it's a letter, we simply append it to the current string being processed.
   - Finally, the result is built and returned.

### Time and Space Complexity:
- **Time Complexity**: O(n), where `n` is the length of the input string `s`. Each character is processed exactly once.
- **Space Complexity**: O(n), as we use stacks to store substrings and numbers, which in the worst case can grow to the size of the string.

### Example Runs:
1. **Input**: `"1[b]"` → **Output**: `"b"`
2. **Input**: `"3[b2[ca]]"` → **Output**: `"bcacabcacabcaca"`
3. **Input**: `"2[ab]3[cd]"` → **Output**: `"ababcdcdcd"`

This approach efficiently handles the decoding of strings, including nested encodings, and runs in linear time.
*/
