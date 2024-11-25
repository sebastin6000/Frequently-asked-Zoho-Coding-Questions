/* 
Question:
Given two strings string1 and string2, remove those characters from the first string (string1) which are present in the second string (string2).
Both the strings are different and contain only lowercase characters. 
NOTE: The size of the first string is always greater than the size of the second string (|string1| > |string2|).

Example 1:
Input:
string1 = "computer"
string2 = "cat"
Output: "ompuer"
Explanation: After removing characters (c, a, t) from string1, we get "ompuer".

Example 2:
Input:
string1 = "occurrence"
string2 = "car"
Output: "ouene"
Explanation: After removing characters (c, a, r) from string1, we get "ouene".

Your Task: 
You don't need to read input or print anything. Complete the function removeChars() which takes string1 and string2 as input parameters and returns the result string after removing characters from string2 from string1.

Expected Time Complexity: O(|String1| + |String2|)
Expected Auxiliary Space: O(|String1|)

Constraints:
1 <= |String1| , |String2| <= 50
*/

/* 
Understanding the Problem Statement:
We are given two strings: string1 and string2.
The task is to remove all the characters from string1 that appear in string2.
After removing, we need to return the modified version of string1.

We are expected to implement the solution in a function `removeChars()` that will return the modified string.
The time complexity for this task is expected to be O(|string1| + |string2|), where |string1| and |string2| are the lengths of string1 and string2 respectively.

We will iterate over string1 and check if each character is present in string2. If a character is found in string2, we will skip it. If it is not in string2, we will keep it in the result.

*/

 /* 
Extracting Information from the Problem Statement:

- Input:
  string1: A string where characters will be removed if they are present in string2.
  string2: A string that contains the characters to be removed from string1.

- Output:
  We need to return a string which is a modified version of string1 after removing all characters present in string2.

- Output return type: String
  
- Time Complexity: O(|string1| + |string2|). This means we are iterating through both strings.

- Constraints: The lengths of both strings are between 1 and 50, so the approach should be efficient within this range.

*/

 /* 
Thinking Solution for the Problem Statement:

To solve this problem, we need to:
1. Iterate through each character of string1.
2. For each character in string1, check if it exists in string2.
3. If the character exists in string2, we ignore it. If not, we include it in the result.

The check can be efficiently done by converting string2 into a set, as checking membership in a set is faster (O(1) on average) than checking membership in a string (O(n)).

Plan:
1. Convert string2 into a set of characters.
2. Iterate over string1 and for each character, check if it's in the set of string2.
3. If it's not in the set, add it to the result string.
4. Return the final result.

*/

 /* 
Conversional Solution into Subtasks:

Subtask 1: Convert string2 into a set of characters. This will allow for faster membership checks.
Subtask 2: Iterate over string1 and for each character, check if it's in the set from Subtask 1.
Subtask 3: Construct a result string by adding characters from string1 that are not in string2.
Subtask 4: Return the result string.

*/

/* 
Subtasks of Conversional Solution into Code:

1. Convert string2 into a set of characters to ensure fast lookup.
2. Iterate over string1 and check if each character is in the set.
3. Construct the final result string by appending valid characters.
4. Return the modified string after processing all characters in string1.

*/
 
Java Code according to conversational subtasks:


import java.util.HashSet;
import java.util.Set;

public class RemoveChars {

    // Subtask 1: Convert string2 into a set for faster membership checking
    public static String removeChars(String string1, String string2) {
        // Step 1: Create a set from string2
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < string2.length(); i++) {
            charSet.add(string2.charAt(i)); // Adding characters from string2 to the set
        }

        // Step 2: Initialize an empty StringBuilder for result
        StringBuilder result = new StringBuilder();

        // Subtask 2: Iterate over string1 and check membership in the set
        for (int i = 0; i < string1.length(); i++) {
            // Subtask 3: If the character is not in string2, add it to the result
            if (!charSet.contains(string1.charAt(i))) {
                result.append(string1.charAt(i));
            }
        }

        // Subtask 4: Return the result as a string
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases for the function
        System.out.println(removeChars("computer", "cat")); // Output: "ompuer"
        System.out.println(removeChars("occurrence", "car")); // Output: "ouene"
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:


Converting string2 into a set takes O(|string2|), where |string2| is the length of string2.
Iterating over string1 and checking membership for each character in the set takes O(|string1|) time.
Thus, the overall time complexity is O(|string1| + |string2|).
Space Complexity:


We are using a set to store characters of string2, which takes O(|string2|) space.
We also use a StringBuilder to construct the result, which could take up to O(|string1|) space in the worst case.
Hence, the overall space complexity is O(|string1| + |string2|).
*/
/* 
for loop walkthrough:

We loop through string2 to add each character to the set. This ensures we can quickly check whether a character exists in string2 during the next loop.
For example, if string2 = "car", we will add 'c', 'a', and 'r' to the set.
Loop for iterating through string1:


For each character in string1, we check if it exists in the set.
If the character is not found in the set, we add it to the result.
For example, if string1 = "computer", after checking each character against the set {'c', 'a', 'r'}, we build the result "ompuer".
*/
/* Complete code walkthrough with applying the given input in code and explanation:
Test Case 1: Input: string1 = "computer" string2 = "cat"
Convert string2 ("cat") to a set: {'c', 'a', 't'}.
Iterate over string1 ("computer"):
'c' is in the set, so skip it.
'o' is not in the set, so add it to the result.
'm' is not in the set, so add it to the result.
'p' is not in the set, so add it to the result.
'u' is not in the set, so add it to the result.
't' is in the set, so skip it.
'e' is not in the set, so add it to the result.
'r' is not in the set, so add it to the result.
Final result: "ompuer".
Test Case 2: Input: string1 = "occurrence" string2 = "car"
Convert string2 ("car") to a set: {'c', 'a', 'r'}.
Iterate over string1 ("occurrence"):
'o' is not in the set, so add it to the result.
'c' is in the set, so skip it.
'c' is in the set, so skip it.
'u' is not in the set, so add it to the result.
'r' is in the set, so skip it.
'r' is in the set, so skip it.
'e' is not in the set, so add it to the result.
'n' is not in the set, so add it to the result.
'c' is in the set, so skip it.
'e' is not in the set, so add it to the result.
Final result: "ouene".
*/


