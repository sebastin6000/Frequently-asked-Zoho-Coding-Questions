
/* 
Question:
Given a string `s`, reverse the string without reversing its individual words. Words are separated by spaces. 
Note that there might be leading or trailing spaces or multiple spaces between two words.

The returned string should only have a single space separating the words, and no extra spaces should be included.

Examples:
Input: s = " i like this program very much "
Output: "much very program this like i"
Explanation: After removing extra spaces and reversing the whole string (not individual words), 
the input string becomes "much very program this like i".

Input: s = " pqr mno "
Output: "mno pqr"
Explanation: After removing extra spaces and reversing the whole string, the input string becomes "mno pqr".

Input: s = " a "
Output: "a"
Explanation: The input string contains only one word with extra spaces around it. After removing the extra spaces, the output is "a".

Your Task:
You don't need to read input or print anything. Your task is to complete the function reverseWords() 
which takes the string as input and returns the reversed string, ensuring no extra spaces.

Expected Time Complexity: O(n), where `n` is the size of the string.
Expected Auxiliary Space: O(n), as we use a list to store words.

Constraints:
1 ≤ s.size() ≤ 10^6
String s contains only lowercase English alphabets and spaces.
*/

/* 
Understanding the Problem Statement:
1. We are given a string `s` that contains words separated by spaces, with possible leading, trailing, or multiple spaces.
2. We need to reverse the entire string in such a way that the words appear in reverse order, but the individual words themselves are not reversed.
3. Additionally, we should eliminate any extra spaces, ensuring only one space exists between the words, and there are no leading or trailing spaces.

What is being asked:
- Reverse the string but preserve the order of words while removing any extra spaces.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A string `s` that may contain lowercase English letters and spaces.
2. Expected Output:
   - A string where the words are reversed in order, but the characters in the words remain in their original order, with no extra spaces.
3. Output return type:
   - A string with reversed words and single spaces between them.
4. Time complexity expectations:
   - Time complexity of O(n), where `n` is the length of the input string. 
     This is because we only need to traverse the string a few times, but no nested loops or complex operations are involved.
5. Constraints:
   - The string's length can be up to 10^6 characters, so the solution must be efficient in terms of both time and space.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This problem involves string manipulation and specifically word ordering. 
     The challenge is to reverse the order of the words without reversing the individual words themselves and managing spaces properly.

2. Destructuring:
   - Split the string into individual words by removing extra spaces.
   - Reverse the order of the words.
   - Join the reversed words with a single space and return the result.

3. Conversational solution into smaller subtask:
   - Step 1: Remove extra spaces by trimming the string and splitting it into words.
   - Step 2: Reverse the order of words.
   - Step 3: Join the reversed words with a single space to form the result.
   - Step 4: Return the result.

*/

/* 
Conversional Solution into Subtasks:
1. Trim the string to remove leading and trailing spaces.
2. Split the string by spaces to get all words, ignoring multiple consecutive spaces.
3. Reverse the list of words.
4. Join the reversed words with a single space and return the result.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Trim the input string and split it into words.
2. Reverse the words and join them with a single space.
3. Return the final result.

*/

/* 
Java Code according to conversational subtasks.
*/

public class ReverseWordsInString {

    // Function to reverse the words in a string
    public static String reverseWords(String s) {
        // Step 1: Trim the string and split it into words by spaces
        String[] words = s.trim().split("\\s+");
        
        // Step 2: Reverse the order of the words
        StringBuilder result = new StringBuilder();
        
        // Step 3: Join the words with a single space
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        
        // Step 4: Return the final reversed string
        return result.toString();
    }

    // Main function to test the reverseWords() function
    public static void main(String[] args) {
        // Test Case 1
        String s1 = " i like this program very much ";
        System.out.println(reverseWords(s1)); // Expected output: "much very program this like i"
        
        // Test Case 2
        String s2 = " pqr mno ";
        System.out.println(reverseWords(s2)); // Expected output: "mno pqr"
        
        // Test Case 3
        String s3 = " a ";
        System.out.println(reverseWords(s3)); // Expected output: "a"
        
        // Test Case 4
        String s4 = " hello   world ";
        System.out.println(reverseWords(s4)); // Expected output: "world hello"
    }
}

/* 
Time and Space Complexity Explanation:
1. Time Complexity:
   - Trimming the string takes O(n) time.
   - Splitting the string into words using `split("\\s+")` also takes O(n) time.
   - Reversing the array and joining the words takes O(n) time, where `n` is the length of the string.
   - Overall time complexity is O(n), which is optimal for this problem.

2. Space Complexity:
   - We use extra space to store the words (array of strings), which takes O(n) space.
   - The `StringBuilder` also takes O(n) space to store the final result.
   - Thus, the space complexity is O(n).

*/

/* 
For loop walkthrough:
- In the `reverseWords()` method:
   - We split the input string into words using `split("\\s+")`, which handles multiple spaces and trims any leading/trailing spaces.
   - We then traverse the words array in reverse order and append them to the `StringBuilder`, ensuring only one space separates the words.

Example for input " i like this program very much ":
1. After trimming and splitting: `["i", "like", "this", "program", "very", "much"]`
2. Reverse the order: `["much", "very", "program", "this", "like", "i"]`
3. Join the words: "much very program this like i"
4. Return the result.

*/

/* 
Complete code walkthrough:
- For input " i like this program very much ":
  1. First, we trim the input string and split it by spaces, yielding the words: `["i", "like", "this", "program", "very", "much"]`.
  2. Next, we reverse the order of the words to get: `["much", "very", "program", "this", "like", "i"]`.
  3. We join the words using a single space, resulting in: `"much very program this like i"`.
  4. The final string is returned.

*/ 
