/* 
Question:
Given a string `s` without spaces, a character `ch`, and an integer `count`, your task is to return the substring that remains after the character `ch` has appeared `count` number of times.
Note: Assume upper case and lower case alphabets are different. An empty string should be returned if it is not possible or the remaining substring is empty.

Examples:

Input: s = "Thisisdemostring", ch = 'i', count = 3
Output: "ng"
Explanation: The remaining substring of s after the 3rd occurrence of 'i' is "ng", hence the output is ng.

Input: s = "Thisisdemostri", ch = 'i', count = 3
Output: ""
Explanation: The 3rd occurrence of 'i' is at the last index. In this case, the remaining substring is empty, hence we return empty string.

Input: s = "abcd", ch = 'x', count = 2
Output: ""
Explanation: The character 'x' is not present in the string, hence we return empty string.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(1)

Constraints:
1 <= s.length() <= 10^5
1 <= count <= s.length()
s[i] is both upper case and lower case.
*/

/* 
Understanding the Problem Statement:
- We are given a string `s` that does not contain spaces, a character `ch`, and an integer `count`.
- Our task is to return the substring that starts after the `count`-th occurrence of the character `ch` in the string `s`.
- If the `ch` does not appear `count` times or if the remaining string after the `count`-th occurrence is empty, we should return an empty string.

What is being asked:
- We are asked to find and return the substring that comes after the `count`-th occurrence of a given character `ch`.
- If `ch` does not appear `count` times or the remaining substring is empty, return an empty string.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - `s`: A string containing lowercase and uppercase characters, with length in the range [1, 10^5].
   - `ch`: A character to search for in the string `s`.
   - `count`: An integer representing the number of occurrences of `ch` to count in `s`.

2. Expected Output:
   - A string representing the substring starting after the `count`-th occurrence of `ch`.
   - If the substring is empty, return an empty string.

3. Output return type:
   - A string.

4. Time complexity expectations:
   - The expected time complexity is O(n), where `n` is the length of the string `s`, 
     since we need to process each character of the string at least once to count occurrences.

5. Constraints:
   - `1 <= s.length() <= 10^5`: We must ensure the solution works efficiently for large strings, i.e., within linear time complexity.
   - `1 <= count <= s.length()`: We are guaranteed that `count` is valid for the length of the string.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a string processing problem where we need to find the `count`-th occurrence of a given character and return the substring after that occurrence.
   - The problem involves linear traversal of the string and checking each character.

2. Destructuring:
   - We need to loop through the string and count the occurrences of the character `ch`.
   - Once we reach the `count`-th occurrence, the substring from the next index onwards will be our answer.
   - If the `count`-th occurrence is not found, or if the remaining string is empty, we return an empty string.

3. Conversational solution into smaller subtask:
   - Subtask 1: Traverse the string character by character, counting occurrences of `ch`.
   - Subtask 2: If the `count`-th occurrence is found, return the substring from the next index.
   - Subtask 3: If no such occurrence is found or if the remaining substring is empty, return an empty string.

*/

/* 
Conversional Solution into Subtasks:
1. Traverse the string `s` and count occurrences of `ch`.
2. Once the `count`-th occurrence is found, return the substring that starts from the next character.
3. If the character does not appear `count` times, or the substring is empty, return an empty string.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Iterate over the string `s` and count occurrences of `ch`.
2. When we reach the `count`-th occurrence, return the substring starting from the next character.
3. If we finish the loop without finding the `count`-th occurrence, or if the substring is empty, return an empty string.

*/

/* 
Java Code according to conversational subtasks.
*/

public class SubstringAfterCountOccurrence {

    // Function to return the substring after the count-th occurrence of ch
    public static String getSubstringAfterCountOccurrence(String s, char ch, int count) {
        int occurrenceCount = 0;
        // Traverse through the string character by character
        for (int i = 0; i < s.length(); i++) {
            // If we find the character 'ch', increment the occurrence count
            if (s.charAt(i) == ch) {
                occurrenceCount++;
            }

            // If we have found the 'count'-th occurrence of 'ch', return the substring from the next index
            if (occurrenceCount == count) {
                return s.substring(i + 1);
            }
        }

        // If we exit the loop without finding 'count' occurrences, return an empty string
        return "";
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        String s1 = "Thisisdemostring";
        char ch1 = 'i';
        int count1 = 3;
        System.out.println(getSubstringAfterCountOccurrence(s1, ch1, count1));  // Expected output: "ng"

        // Test case 2
        String s2 = "Thisisdemostri";
        char ch2 = 'i';
        int count2 = 3;
        System.out.println(getSubstringAfterCountOccurrence(s2, ch2, count2));  // Expected output: ""

        // Test case 3
        String s3 = "abcd";
        char ch3 = 'x';
        int count3 = 2;
        System.out.println(getSubstringAfterCountOccurrence(s3, ch3, count3));  // Expected output: ""
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - The algorithm processes each character of the string `s` exactly once. Therefore, the time complexity is O(n), 
     where `n` is the length of the string `s`.

- Space Complexity:
  - The space complexity is O(1) because we are not using any additional space that grows with the input size, except for a few integer variables.

*/

/* 
“for” loop or “while” loop walkthrough with every iteration with given input.
*/

/* 
We use a for loop to traverse the string `s` and count the occurrences of the character `ch`:
1. Start with `i = 0` and initialize `occurrenceCount = 0`.
2. Traverse each character in `s`:
   - If `s.charAt(i) == ch`, increment `occurrenceCount`.
   - If `occurrenceCount` equals `count`, return the substring starting from index `i + 1`.
3. If the loop ends without finding the `count`-th occurrence, return an empty string.

For input:
s = "Thisisdemostring", ch = 'i', count = 3

1. i=0, s.charAt(0) = 'T' (no match)
2. i=1, s.charAt(1) = 'h' (no match)
3. i=2, s.charAt(2) = 'i' (occurrenceCount=1)
4. i=3, s.charAt(3) = 's' (no match)
5. i=4, s.charAt(4) = 'i' (occurrenceCount=2)
6. i=5, s.charAt(5) = 's' (no match)
7. i=6, s.charAt(6) = 'd' (no match)
8. i=7, s.charAt(7) = 'e' (no match)
9. i=8, s.charAt(8) = 'm' (no match)
10. i=9, s.charAt(9) = 'o' (no match)
11. i=10, s.charAt(10) = 's' (no match)
12. i=11, s.charAt(11) = 't' (no match)
13. i=12, s.charAt(12) = 'r' (no match)
14. i=13, s.charAt(13) = 'i' (occurrenceCount=3) --> return substring starting from index 14 ("ng").

Output: "ng"
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input:
s = "Thisisdemostring", ch = 'i', count = 3

1. We traverse the string and count the occurrences of 'i':
   - 'i' appears at indices 2, 4, and 13. The 3rd occurrence is at index 13.
2. The substring after the 3rd occurrence of 'i' starts from index 14, which is "ng".
3. The output is "ng".
*/

