/* 
Question:
Given a string `str`, the task is to count the number of palindrome words present in the string `str`.

Example 1:
Input : "Madam Arora teaches malayalam"
Output : 3
Explanation: The string contains three palindrome words (i.e., Madam, Arora, malayalam) so the count is three.

Example 2:
Input : "Nitin speaks malayalam"
Output : 2
Explanation: The string contains two palindrome words (i.e., Nitin, malayalam) so the count is two.

*/

/* 
Understanding the Problem Statement:
- A palindrome is a word that reads the same backward as forward (e.g., "madam", "racecar").
- We are given a string and are required to find how many words in that string are palindromes.
- Words in the string are separated by spaces, 
  and the case of the letters doesn't matter (i.e., "Madam" and "madam" should both be considered palindromes).

What is being asked:
- We need to return the count of palindrome words in the given string.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A string `str`.
2. Expected Output:
   - The number of palindrome words in the string.
3. Output return type:
   - An integer, the count of palindrome words.
4. Time complexity expectations:
   - No explicit time complexity given, but we should strive for an efficient solution.
5. Constraints:
   - No explicit constraints are given regarding string length, but since no constraints are mentioned, we'll assume reasonable input size.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - We need to check if each word in the string is a palindrome.
   - A palindrome can be checked by comparing the word with its reverse.
   - We also need to handle case sensitivity, so we should convert the string to lowercase for comparison.
   
2. Destructuring:
   - Split the input string by spaces to get individual words.
   - For each word, check if it reads the same forward and backward.
   - Count how many such palindrome words there are.

3. Conversional solution into smaller subtask:
   - Subtask 1: Split the input string into words.
   - Subtask 2: Convert each word to lowercase.
   - Subtask 3: Check if the word is a palindrome.
   - Subtask 4: Count the palindrome words and return the result.

*/

/* 
Conversional Solution into Subtasks:
1. Split the input string into words using spaces.
2. For each word, convert it to lowercase.
3. Check if the word is a palindrome by comparing it with its reverse.
4. Count the palindrome words.
5. Return the final count.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Split the input string into words.
2. Convert each word to lowercase.
3. Check if the word is a palindrome.
4. Count the palindrome words.
5. Return the count of palindrome words.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.StringTokenizer;

public class PalindromeWordCounter {
    
    // Function to count palindrome words in a string
    public static int countPalindromeWords(String str) {
        // Subtask 1: Split the string into words
        StringTokenizer tokenizer = new StringTokenizer(str);
        int palindromeCount = 0;

        // Subtask 2 & 3: Iterate over each word
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            
            // Convert word to lowercase for case insensitive comparison
            String lowerCaseWord = word.toLowerCase();
            
            // Subtask 3: Check if the word is a palindrome
            if (isPalindrome(lowerCaseWord)) {
                palindromeCount++;  // Increment count for palindrome word
            }
        }

        // Subtask 4: Return the count of palindrome words
        return palindromeCount;
    }

    // Helper function to check if a word is a palindrome
    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        // Check if the word is the same when read from both ends
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;  // Not a palindrome
            }
            left++;
            right--;
        }
        return true;  // It's a palindrome
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        String input1 = "Madam Arora teaches malayalam";
        System.out.println(countPalindromeWords(input1));  // Expected output: 3

        // Test case 2
        String input2 = "Nitin speaks malayalam";
        System.out.println(countPalindromeWords(input2));  // Expected output: 2
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - The `StringTokenizer` splits the string into words, which takes O(N), where N is the length of the string.
  - For each word, we check if it is a palindrome, which takes O(L) where L is the length of the word. 
    Since we process all words, the time complexity is O(N) in total, where N is the length of the string.
  
- Space Complexity:
  - We use a `StringTokenizer` which consumes O(N) space for splitting the string into words.
  - In addition, we use a small amount of extra space for storing the current word and its lowercase form, which is O(L) per word.
  - Therefore, the space complexity is O(N), where N is the length of the input string.

*/

/* 
“for” loop or “while” loop walkthrough with every iteration with given input.
*/

/* 
The main loop in the function `countPalindromeWords` iterates over each word in the string using `StringTokenizer`:
- For each word, we check if it is a palindrome using the `isPalindrome` helper function.
- The helper function uses a `while` loop to check if the word reads the same from both ends, comparing characters at the start and the end.
- The loop continues until the left index is greater than or equal to the right index.
- If a mismatch is found, the function returns false, indicating the word is not a palindrome.
- If no mismatch is found, the function returns true, indicating the word is a palindrome.
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For input: "Madam Arora teaches malayalam"
1. The `StringTokenizer` splits the string into words: ["Madam", "Arora", "teaches", "malayalam"].
2. We process each word:
   - "Madam": Converted to "madam", it is a palindrome, so count = 1.
   - "Arora": Converted to "arora", it is a palindrome, so count = 2.
   - "teaches": Converted to "teaches", it is not a palindrome, count remains 2.
   - "malayalam": Converted to "malayalam", it is a palindrome, so count = 3.
3. The output is 3.

For input: "Nitin speaks malayalam"
1. The `StringTokenizer` splits the string into words: ["Nitin", "speaks", "malayalam"].
2. We process each word:
   - "Nitin": Converted to "nitin", it is a palindrome, so count = 1.
   - "speaks": Converted to "speaks", it is not a palindrome, count remains 1.
   - "malayalam": Converted to "malayalam", it is a palindrome, so count = 2.
3. The output is 2.
*/
