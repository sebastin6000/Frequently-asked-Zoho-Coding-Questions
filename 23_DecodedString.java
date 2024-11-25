/* 
-------------------------------
Question Section:
-------------------------------
Given an encoded string s, where the encoding pattern follows the format: 
- A number followed by a string enclosed in square brackets. 
- The number represents the number of times the string inside the brackets must be repeated. 
- Decode the string and return the decoded string.

Example 1:
Input: s = "1[b]"
Output: "b"
Explanation: The string "b" is repeated 1 time.

Example 2:
Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation: 2[ca] means 'ca' is repeated twice, which becomes 'caca'. When combined with 'b', it forms 'bcaca'. This is repeated 3 times to give the final output.

Task:
You need to implement a function `decodedString()` that takes the encoded string `s` as input and returns the decoded string.

-------------------------------
*/

/* 
-------------------------------
Understanding the Problem Statement Section:
-------------------------------
The given string follows a pattern where:
- A number appears first, followed by a string in square brackets.
- The number indicates how many times the string inside the brackets should be repeated.
- The goal is to decode this pattern and return the final expanded string.

For example:
- "1[b]" means repeat "b" 1 time → "b"
- "3[b2[ca]]" means: repeat "b" 3 times with "ca" repeated 2 times in each repetition of "b" → "bcacabcacabcaca"

We need to handle multiple levels of nested encodings. 

The approach to decode the string should work efficiently for strings as long as 1000 characters.

-------------------------------
*/

/* 
-------------------------------
Extracting Information from the Problem Statement Section:
-------------------------------
- Input: A string `s` that follows the encoded pattern described.
- Output: A decoded string after applying all the repetitions.
- Function: `decodedString(s)` should decode the input string and return the result.
- Constraints: 
  - The length of the string |s| is between 1 and 1000.
  - Each number indicates how many times a string is repeated, and there can be multiple levels of nested brackets.
- Time Complexity: O(|s|), where |s| is the length of the string.
- Space Complexity: O(|s|) for storing intermediate results during decoding.

-------------------------------
*/

/* 
-------------------------------
Thinking Solution for the Problem Statement Section:
-------------------------------
To decode the string efficiently:
1. We need to iterate through the string and handle numbers, characters, and brackets.
2. When we encounter a number, it indicates how many times to repeat the string inside the brackets.
3. We will use a stack to keep track of the characters and numbers as we parse through the string.
4. When encountering a closing bracket, we will pop the elements from the stack and repeat the substring based on the number before the bracket.
5. We will continue this process until the entire string is decoded.

-------------------------------
*/

/* 
-------------------------------
Conversional Solution into Subtasks Section:
-------------------------------
The solution can be broken into the following subtasks:

Subtask 1: Handle parsing of the string to extract numbers and substrings.
Subtask 2: Use a stack to store the decoded results.
Subtask 3: Handle nested encoded patterns by iterating over the string and applying the repetition.
Subtask 4: Build the final decoded string by concatenating the results from the stack.

-------------------------------
*/

/* 
-------------------------------
Subtasks of Conversional Solution into Code Section:
-------------------------------
Subtask 1: 
- Parse the string and handle numbers.
Subtask 2:
- Use a stack to store the characters as they are processed.
Subtask 3:
- Handle nested encoded patterns by repeating substrings.
Subtask 4:
- Combine the substrings and return the final result.

-------------------------------
*/

/* 
-------------------------------
Java Code according to Conversational Subtasks Section:
-------------------------------
*/
import java.util.Stack;

public class DecodedString {
    
    // Subtask 1: Decoding the string
    public String decodedString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder current = new StringBuilder();
        int currentNum = 0;
        
        // Subtask 2: Loop through the string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // If digit, calculate the number of repetitions
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                // Subtask 3: Push current number and string to stack, and reset for new substring
                counts.push(currentNum);
                result.push(current);
                current = new StringBuilder();
                currentNum = 0;
            } else if (c == ']') {
                // Subtask 3: Pop from stack and repeat the current substring
                StringBuilder temp = current;
                current = result.pop();
                int repeatTimes = counts.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    current.append(temp);
                }
            } else {
                // Add characters to the current substring
                current.append(c);
            }
        }
        
        // Subtask 4: Return the final decoded string
        return current.toString();
    }
    
    // Subtask 4: Main method for testing
    public static void main(String[] args) {
        DecodedString decoder = new DecodedString();
        System.out.println(decoder.decodedString("3[b2[ca]]")); // Output: bcacabcacabcaca
    }
}

/* 
-------------------------------
Time and Space Complexity Explanation Section:
-------------------------------
Time Complexity:
- We are iterating through each character in the string exactly once, so the time complexity is O(|s|), where |s| is the length of the input string.

Space Complexity:
- The space complexity is O(|s|) because we are using stacks to store intermediate results. In the worst case, the size of the stack could be proportional to the length of the input string.

-------------------------------
*/

/* 
-------------------------------
If used any “for” loop or “while” loop you have walkthrough all the “for” loop or “while” loop used in the code with every iteration with given input and this section has to be inside this structure of comments:
-------------------------------
For loop walkthrough:
In the main function, we call `decoder.decodedString("3[b2[ca]]")`.
We iterate through each character in the string "3[b2[ca]]".

- '3' is a digit, we calculate currentNum = 3.
- '[' indicates the start of an encoded section, we push currentNum (3) to the stack and reset currentNum.
- 'b' is a regular character, we append it to the current substring.
- '2' is a digit, we calculate currentNum = 2.
- '[' indicates the start of another encoded section, we push currentNum (2) to the stack and reset currentNum.
- 'c' is a regular character, we append it to the current substring.
- 'a' is a regular character, we append it to the current substring.
- ']' indicates the end of the inner encoding, we pop 2 from the stack, repeat the string "ca" twice, and append the result to the previous string.
- ']' indicates the end of the outer encoding, we pop 3 from the stack, repeat the string "bcaca" three times, and return the final decoded string.

-------------------------------
*/

/* 
-------------------------------
Complete code walkthrough with applying the given input in code and explanation has to be in simple English because I have to explain the question and approach my friends and this section has to be inside this structure of comments:
-------------------------------
Let's take the example "3[b2[ca]]".
- We start by reading the string, and at the beginning, we see "3", so we know that the string inside the brackets will be repeated 3 times.
- Next, we encounter "b", which is a regular character, so we add it to our current result.
- We then encounter "[", which indicates the start of an inner encoded string.
- Inside the inner encoded string, we find "2", meaning the string inside the brackets should be repeated 2 times.
- We encounter "c" and "a", forming the substring "ca", which we repeat twice to get "caca".
- After closing the inner bracket, we append "bcaca" to the previous result.
- Finally, the outer encoded string is completed by repeating "bcaca" 3 times to form the result "bcacabcacabcaca".

This solution is efficient and works for all encoded strings within the given constraints.

-------------------------------
*/
```
