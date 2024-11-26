/* 
Question:
Given a string consisting of lowercase English alphabets, reverse only the vowels present in it and print the resulting string.

Example 1:

Input:
S = "geeksforgeeks"
Output: geeksforgeeks
Explanation: The vowels are: e, e, o, e, e
Reverse of these is also e, e, o, e, e.

Example 2:

Input: 
S = "practice"
Output: prectica
Explanation: The vowels are a, i, e
Reverse of these is e, i, a.

Example 3: 
Input: 
S = "bcdfg"
Output: bcdfg
Explanation: There are no vowels in S.

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function modify() 
which takes the string S as input and returns the resultant string by reversing only the vowels present in S.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1 <= |S| <= 10^5
*/

/* 
Understanding the Problem Statement:
- You are given a string consisting of lowercase English alphabets.
- You need to reverse only the vowels in the string and leave the non-vowel characters as they are.
- The vowels in the string are `a, e, i, o, u`.
- If there are no vowels in the string, the string should remain unchanged.

What is being asked:
- Implement the function `modify()` that reverses only the vowels in the given string and returns the modified string.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is a string `S` consisting of lowercase English alphabets.
   
2. Expected Output:
   - The output is the same string, with only the vowels reversed, and the other characters unchanged.

3. Output return type:
   - The return type is a string.

4. Time complexity expectations:
   - The expected time complexity is O(|S|), where |S| is the length of the string.

5. Constraints:
   - The length of the string can be as large as 10^5, so the solution must be efficient in both time and space.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a problem of reversing certain characters (vowels) in the string while leaving others intact.
   - We need to identify vowels, collect them, and then place them back in their reversed order in the string.

2. Destructuring:
   - We need to:
     - Identify all vowels in the string.
     - Reverse only those vowels.
     - Replace the vowels in the original string with their reversed counterparts.

3. Conversational solution into smaller subtask:
   - Step 1: Traverse the string and extract all vowels.
   - Step 2: Reverse the list of vowels.
   - Step 3: Traverse the string again and replace the vowels with the reversed ones.

*/

/* 
Conversional Solution into Subtasks:
1. Loop through the string and store all vowels in a list.
2. Reverse the list of vowels.
3. Reconstruct the string by replacing the original vowels with the reversed vowels from the list.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a list to store the vowels from the string.
2. Reverse the list of vowels.
3. Iterate through the string and replace vowels with the reversed vowels.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class ReverseVowels {

    // Function to reverse vowels in a string
    public static String modify(String S) {
        // Define vowels
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // List to store vowels found in the string
        List<Character> vowelList = new ArrayList<>();

        // First pass to collect vowels from the string
        for (int i = 0; i < S.length(); i++) {
            if (vowels.contains(S.charAt(i))) {
                vowelList.add(S.charAt(i)); // Add vowel to the list
            }
        }

        // Reverse the list of vowels
        Collections.reverse(vowelList);

        // Convert the string to a character array for easy modification
        char[] result = S.toCharArray();

        // Second pass to replace vowels in the original string with reversed vowels
        int vowelIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            if (vowels.contains(S.charAt(i))) {
                result[i] = vowelList.get(vowelIndex++); // Replace with the reversed vowel
            }
        }

        // Return the new string after modification
        return new String(result);
    }

    // Main function to test the code
    public static void main(String[] args) {
        // Test case 1
        String test1 = "geeksforgeeks";
        System.out.println(modify(test1)); // Expected output: geeksforgeeks

        // Test case 2
        String test2 = "practice";
        System.out.println(modify(test2)); // Expected output: prectica

        // Test case 3
        String test3 = "bcdfg";
        System.out.println(modify(test3)); // Expected output: bcdfg
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:
- We traverse the string twice:
  1. First pass to collect vowels: O(|S|)
  2. Second pass to replace vowels: O(|S|)
- The overall time complexity is O(|S|), where |S| is the length of the string.

Space Complexity:
- We store the vowels in a list, which requires O(|S|) space in the worst case.
- The overall space complexity is O(|S|) as the string is modified in-place after reversing the vowels.

*/

/* 
For Loop Walkthrough:
1. The first `for` loop iterates through the string to collect all vowels.
   - It checks each character and if it is a vowel (present in the `vowels` set), it adds it to the `vowelList`.
   
2. The `Collections.reverse(vowelList)` reverses the list of vowels.
   
3. The second `for` loop iterates through the string again, replacing each vowel with the reversed vowels from `vowelList`.
   - It checks if the current character is a vowel and, if so, it replaces it with the corresponding vowel from the reversed list.

Complete Code Walkthrough:
- In the first pass, vowels are collected from the input string and stored in a list.
- In the second pass, the vowels are replaced in the original string with the reversed vowels.
- The final string is returned after modification.

For example, for the string "practice":
1. First pass collects vowels: ['a', 'i', 'e']
2. Reverse the list: ['e', 'i', 'a']
3. Replace vowels in the string: "prectica"
The output is "prectica".
*/
