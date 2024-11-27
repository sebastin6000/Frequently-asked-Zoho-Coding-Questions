/* 
Question Section:
Given a string S, containing special characters and all the alphabets, reverse the string without affecting the positions of the special characters.

You are required to reverse the string, but the positions of the special characters should remain fixed.

Examples:

Input: S = "A&B"
Output: "B&A"
Explanation: As we ignore '&' and then reverse, the result is "B&A".

Input: S = "A&x#"
Output: "x&A#"
Explanation: We swap only 'A' and 'x', leaving '&' and '#' in their original positions.

Your Task:
You don't need to read input or print anything. Your task is to complete the function `reverse()` 
which takes the string as input and returns the required reversed string.

*/

/* 
Understanding the Problem Statement:
- We are given a string that includes alphabets and special characters.
- Our goal is to reverse the alphabetic characters in the string while keeping the special characters in their original positions.
- Special characters should not be swapped or moved, they should only be ignored when reversing the alphabetic characters.

What is being asked?
- We need to implement a function `reverse()` that:
  1. Reverses only the alphabetic characters of the string.
  2. Leaves the positions of the special characters unchanged.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A string `S` consisting of alphabets and special characters.

2. Expected Output:
   - A string where alphabetic characters are reversed, but special characters remain in their original positions.

3. Output return type:
   - A string.

4. Explanation of Time complexity expectations:
   - The expected time complexity is O(n), where n is the length of the string, as we need to scan through the string, 
     reverse the alphabetic characters, and then place them back at their respective positions.

5. Explanation of given Constraints:
   - The string `S` can have a length of up to 10^5 characters, so we need an efficient solution.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification:
   - We need to reverse only the alphabetic characters while preserving the special characters' positions. 
     This means that the core task is to extract the alphabetic characters, reverse them, 
     and then place them back while skipping over the special characters.

2. Destructuring:
   - Extract the alphabetic characters from the string and store them in a list (or stack for reversing).
   - Traverse the string again, and for each character:
     - If it’s an alphabet, replace it with the reversed characters.
     - If it’s a special character, leave it unchanged.

3. Conversional solution into smaller subtask:
   - Subtask 1: Traverse the string to extract all alphabetic characters.
   - Subtask 2: Reverse the list of alphabetic characters.
   - Subtask 3: Rebuild the string by placing the reversed alphabetic characters in their original positions, skipping special characters.

*/

/* 
Conversional Solution into Subtasks:
1. Traverse the string and store all the alphabetic characters.
2. Reverse the collected alphabetic characters.
3. Rebuild the string by placing the reversed alphabetic characters in their original positions.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Traverse the string and collect the alphabetic characters.
2. Reverse the collected alphabetic characters.
3. Rebuild the string with the reversed alphabetic characters in place.

*/

import java.util.ArrayList;
import java.util.Collections;

public class ReverseStringWithoutAffectingSpecialChars {

    /* 
    Function to reverse the string while keeping special characters in their original positions.
    1. Traverse the string to collect all alphabetic characters.
    2. Reverse the alphabetic characters.
    3. Rebuild the string by placing the reversed alphabetic characters in their original positions.
    */
    public static String reverse(String S) {
        // Convert string to a char array for easy manipulation
        char[] arr = S.toCharArray();
        
        // List to hold all the alphabetic characters
        ArrayList<Character> letters = new ArrayList<>();
        
        // Extract all alphabetic characters from the string
        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i])) {
                letters.add(arr[i]);
            }
        }
        
        // Reverse the list of alphabetic characters
        Collections.reverse(letters);
        
        // Rebuild the string with the reversed alphabetic characters in place
        int letterIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i])) {
                arr[i] = letters.get(letterIndex++);
            }
        }
        // Return the new string formed from the character array
        return new String(arr);
    }
    public static void main(String[] args) {
        // Test case 1
        String S1 = "A&B";
        System.out.println(reverse(S1)); // Expected: "B&A"
        
        // Test case 2
        String S2 = "A&x#";
        System.out.println(reverse(S2)); // Expected: "x&A#"
        
        // Test case 3
        String S3 = "a&b#z";
        System.out.println(reverse(S3)); // Expected: "z&b#a"
    }
}

    /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - We traverse the string twice: once to collect the alphabetic characters and once to rebuild the string. Both traversals are O(n), where n is the length of the string.
    - Reversing the list of alphabetic characters takes O(k), where k is the number of alphabetic characters.
    - Overall time complexity is O(n), where n is the length of the string.

    Space Complexity:
    - We store the alphabetic characters in a list, so the space complexity is O(k), where k is the number of alphabetic characters.
    - In the worst case, the space complexity is O(n), where n is the length of the string.
    */

    /* 
    Code Walkthrough:
    Let's walk through the input `S = "A&B"`:
    1. We first extract the alphabetic characters: ['A', 'B'].
    2. We reverse the alphabetic characters: ['B', 'A'].
    3. We traverse the string again, replacing 'A' with 'B' and 'B' with 'A', leaving '&' unchanged.
    4. The result is `"B&A"`.

    Let's walk through the input `S = "A&x#"`:
    1. We first extract the alphabetic characters: ['A', 'x'].
    2. We reverse the alphabetic characters: ['x', 'A'].
    3. We traverse the string again, replacing 'A' with 'x' and 'x' with 'A', leaving '&' and '#' unchanged.
    4. The result is `"x&A#"`.
    */
/*
### Explanation of Changes:
1. **Imports Added**: 
   - `import java.util.ArrayList;` to use the `ArrayList` class.
   - `import java.util.Collections;` to use the `reverse()` method for the list.

2. **Functionality**: The rest of the code remains the same, but now it will correctly compile and run.

### Code Walkthrough:
- **`reverse(String S)`**:
  - We first convert the string `S` into a character array `arr` for easy manipulation.
  - We extract all alphabetic characters into the `letters` list and reverse them using `Collections.reverse()`.
  - We then reconstruct the string by iterating over the original string and replacing alphabetic characters with the reversed ones,
    while leaving special characters in their original positions.

### Time and Space Complexity:
- **Time Complexity**: O(n) — We iterate over the string twice, so the overall time complexity is linear in terms of the string length `n`.
- **Space Complexity**: O(k) — 
  The space complexity is dominated by the space required to store the alphabetic characters in the 
  `letters` list, where `k` is the number of alphabetic characters. In the worst case, `k = n`, so space complexity is O(n).

### Example Runs:
1. Input: `"A&B"` → Output: `"B&A"`
2. Input: `"A&x#"` → Output: `"x&A#"`
3. Input: `"a&b#z"` → Output: `"z&b#a"`

*/
