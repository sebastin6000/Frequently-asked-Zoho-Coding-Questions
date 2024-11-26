/* 
Question:
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string `sentence` containing only lowercase English letters, return true if the sentence is a pangram, or false otherwise.

Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: The sentence contains at least one of every letter of the English alphabet.

Example 2:
Input: sentence = "leetcode"
Output: false
Explanation: The sentence does not contain all the letters from 'a' to 'z'.

*/

/* 
Understanding the Problem Statement:
- We are given a string of lowercase English letters.
- A pangram is a sentence that contains every letter of the alphabet at least once. 
- The goal is to check if the string contains all 26 letters of the English alphabet.
- If all 26 letters are present, return true; otherwise, return false.

What is being asked:
- We need to determine if the given string is a pangram.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A string `sentence` containing only lowercase English letters.
2. Expected Output:
   - A boolean value: `true` if the sentence is a pangram, `false` otherwise.
3. Output return type:
   - A boolean value (true or false).
4. Time complexity expectations:
   - The time complexity should be O(n), where n is the length of the sentence, as we need to process each character.
5. Constraints:
   - 1 <= sentence.length <= 1000
   - sentence consists of lowercase English letters (no need to handle other characters).

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - A pangram requires that every letter from 'a' to 'z' must appear at least once in the string.
   - We can use a set to track the characters we've seen in the sentence.
   
2. Destructuring:
   - We can iterate over the sentence and add each character to a set.
   - The set will automatically handle duplicates (i.e., the same character appearing multiple times will only be counted once).
   - If the size of the set reaches 26 (the number of letters in the alphabet), we can conclude that the sentence is a pangram.
   - If we finish processing the string and the set's size is less than 26, the sentence is not a pangram.

3. Conversional solution into smaller subtask:
   - Subtask 1: Initialize an empty set.
   - Subtask 2: Iterate through each character in the string and add it to the set.
   - Subtask 3: If the set's size reaches 26 at any point, return true.
   - Subtask 4: After processing the string, check if the set size is 26 and return true if so, otherwise return false.

*/

/* 
Conversional Solution into Subtasks:
1. Initialize an empty set to store unique characters.
2. Loop through the string and add each character to the set.
3. If the set contains 26 characters at any point, return true.
4. After processing all characters, check if the set size is 26.
5. Return the result based on the size of the set.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Initialize a set to store characters.
2. Iterate over the characters in the string and add them to the set.
3. Check the size of the set during the iteration.
4. Return true if the set contains 26 characters, otherwise return false.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    // Function to check if a sentence is a pangram
    public static boolean checkIfPangram(String sentence) {
        // Subtask 1: Initialize a set to store unique characters
        Set<Character> uniqueChars = new HashSet<>();
        
        // Subtask 2: Iterate through each character in the string
        for (int i = 0; i < sentence.length(); i++) {
            // Add each character to the set
            uniqueChars.add(sentence.charAt(i));
            
            // Subtask 3: If the set size reaches 26, return true
            if (uniqueChars.size() == 26) {
                return true;
            }
        }

        // Subtask 4: If the set size is less than 26 after processing the string, return false
        return false;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        String input1 = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(input1));  // Expected output: true

        // Test case 2
        String input2 = "leetcode";
        System.out.println(checkIfPangram(input2));  // Expected output: false
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - We iterate through the string once. For each character, 
    we perform a constant time operation (adding it to the set), which takes O(1) time. 
    Therefore, the time complexity is O(n), where n is the length of the sentence.
  
- Space Complexity:
  - The space complexity is O(1) 
    in terms of the set size because the set can only store up to 26 distinct characters (the number of letters in the English alphabet). 
    This is constant space, regardless of the length of the string.

*/

/* 
“for” loop or “while” loop walkthrough with every iteration with given input.
*/

/* 
The `for` loop in the `checkIfPangram` function iterates through each character in the string:
- For each character, we add it to the set.
- If at any point the set contains 26 unique characters, the loop terminates early and returns true.
- If we reach the end of the string and the set contains fewer than 26 characters, we return false.
*/

 /* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input: "thequickbrownfoxjumpsoverthelazydog"
1. We initialize an empty set.
2. We iterate through the string and add each character to the set:
   - 't' -> set = {'t'}
   - 'h' -> set = {'t', 'h'}
   - 'e' -> set = {'t', 'h', 'e'}
   - ...
   - After processing all characters, the set contains all 26 unique letters of the alphabet.
3. Since the set contains 26 characters, we return true.

For input: "leetcode"
1. We initialize an empty set.
2. We iterate through the string and add each character to the set:
   - 'l' -> set = {'l'}
   - 'e' -> set = {'l', 'e'}
   - 't' -> set = {'l', 'e', 't'}
   - ...
   - After processing all characters, the set contains fewer than 26 characters (only 6).
3. Since the set size is less than 26, we return false.
*/
