
/* 
  Question:
  Given a string containing lower and uppercase alphabets, 
  the task is to find the maximum number of characters between any two same (case sensitivity) characters in the string.
  
  Example 1:
  Input:
  S = "socks"
  Output: 3
  Explanation: There are 3 characters between the two occurrences of 's'.

  Example 2:
  Input:
  S = "FoR"
  Output: -1
  Explanation: No repeating character present.

  Your Task:
  You don't need to read input or print anything. 
  Your task is to complete the function maxChars() 
  which takes the string S as input and returns the maximum number of characters between any two same characters in the string.

  Expected Time Complexity: O(|S|).
  Expected Auxiliary Space: O(1).
*/

 /* Understanding the Problem Statement:
  We are given a string of uppercase and lowercase characters.
  The objective is to find the maximum number of characters that appear between any two occurrences of the same character, keeping case sensitivity in mind.
  For example, in the string "socks", 
  the two occurrences of 's' are at indices 0 and 4, and there are 3 characters between them (i.e., "oc" between 's' at index 0 and 's' at index 4).
  If no repeating character is found, return -1.
*/

 /* Extracting Information from the Problem Statement:
    - Input: A string consisting of lowercase and uppercase alphabets.
    - Output: An integer representing the maximum number of characters between two identical characters. Return -1 if no such pair exists.
    - Expected Time Complexity: O(|S|), meaning we should process each character of the string in linear time.
    - Expected Auxiliary Space: O(1), implying that we should not use extra space proportional to the input size, aside from a few variables.
    - Constraints: The length of the string will be between 1 and 10^5.
*/

 /* Thinking Solution for the Problem Statement:
    1. We need to iterate through the string and track the indices of characters we've encountered.
    2. For each character, if it has been encountered before, we calculate the number of characters between its previous occurrence and the current index.
    3. If it's the first time we encounter the character, store its index.
    4. We need to find the maximum number of characters between any two occurrences.
    5. If no such pair exists, return -1.
*/

 /* Conversional Solution into Subtasks:
    1. Create a map (or array) to track the first occurrence index of each character.
    2. Initialize a variable to track the maximum number of characters between repeated characters.
    3. Iterate through the string and for each character:
       - If it's the first occurrence, store its index.
       - If it has appeared before, calculate the distance and update the maximum if necessary.
    4. Return the maximum distance found, or -1 if no repetition exists.
*/

 /* Subtasks of Conversional Solution into Code:
    1. Initialize a map (or an array) to store the first occurrence index of each character.
    2. Loop through the string:
        - For each character, check if it has been seen before.
        - If yes, compute the distance and update the result.
        - If no, store the current index.
    3. After the loop, return the result (the maximum number of characters found or -1 if no repetition).
*/

import java.util.HashMap;

public class MaxChars {

    // Function to find the maximum number of characters between two same characters
    public static int maxChars(String S) {
        // Step 1: Initialize a HashMap to store the first occurrence index of each character
        HashMap<Character, Integer> seen = new HashMap<>();
        
        // Step 2: Initialize a variable to store the maximum number of characters between two same characters
        int maxDistance = -1;
        
        // Step 3: Iterate through the string
        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            
            // Step 4: If the character is already seen, calculate the distance between the previous occurrence and the current position
            if (seen.containsKey(currentChar)) {
                int prevIndex = seen.get(currentChar);
                int distance = i - prevIndex - 1;  // Number of characters between the two same characters
                maxDistance = Math.max(maxDistance, distance);  // Update maxDistance if the current distance is greater
            }
            
            // Step 5: Store the first occurrence of the current character
            seen.put(currentChar, i);
        }
        
        // Step 6: Return the result, -1 if no repeating character was found
        return maxDistance;
    }

    // Main function to test the code with some examples
    public static void main(String[] args) {
        // Test 1
        String s1 = "socks";
        System.out.println(maxChars(s1));  // Expected Output: 3

        // Test 2
        String s2 = "FoR";
        System.out.println(maxChars(s2));  // Expected Output: -1
    }
}

 /* Time and Space Complexity Explanation:
    - Time Complexity: O(n), where n is the length of the string. We iterate through the string once, and for each character, 
       we either check or update the map, which takes constant time O(1).
    - Space Complexity: O(1),
      if we assume that the number of possible characters (lowercase and uppercase alphabets) is constant (i.e., 52 distinct characters),
      thus we use a constant amount of extra space for the map.
      If we account for the worst-case scenario of using a HashMap, the space complexity would be O(n) in the case of all distinct characters,
      but it is generally considered constant in the context of alphabetic characters.

 /* Loop walkthrough for the input "socks":
    1. 's' at index 0 is not seen before, so we store its index: seen = {'s': 0}.
    2. 'o' at index 1 is not seen before, so we store its index: seen = {'s': 0, 'o': 1}.
    3. 'c' at index 2 is not seen before, so we store its index: seen = {'s': 0, 'o': 1, 'c': 2}.
    4. 'k' at index 3 is not seen before, so we store its index: seen = {'s': 0, 'o': 1, 'c': 2, 'k': 3}.
    5. 's' at index 4 is seen before at index 0. We calculate the distance: 4 - 0 - 1 = 3. Update maxDistance: maxDistance = 3.
    Final result: maxDistance = 3.

  /* Complete code walkthrough:
    The function iterates through the string "socks". For each character:
    - 's' is encountered first, so it is stored with its index.
    - The next characters 'o', 'c', and 'k' are similarly processed, storing their indices.
    - When 's' is encountered again at index 4, 
      the function calculates the number of characters between the two 's' occurrences (3 characters), and updates the maximum distance.
    - The final result of 3 is returned.
*/
