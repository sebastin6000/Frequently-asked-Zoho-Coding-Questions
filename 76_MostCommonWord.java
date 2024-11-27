/* 
Question:
Given a string `paragraph` and an array of `banned` words, return the most frequent word that is not banned.
The words in `paragraph` are case-insensitive and should be considered lowercase. Punctuation should be ignored. 
You need to find the most frequent word that is **not** in the banned list.

Example 1:
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: "hit" occurs 3 times, but it is a banned word. "ball" occurs twice, and is the most frequent non-banned word.

Example 2:
Input: paragraph = "a.", banned = []
Output: "a"

Constraints:
1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or punctuation symbols: "!?',;."
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
*/

/* 
Understanding the Problem Statement:
- We need to find the most frequent non-banned word in a paragraph. 
- Words are case-insensitive and punctuation should be ignored. 
- The word that occurs most frequently and is not banned will be the result.
- Banned words should be excluded from the frequency count.
- The paragraph can contain various punctuation marks, so we need to clean the words before counting.

What is being asked:
- We are to return the most frequent non-banned word in lowercase.
- If there is a tie in frequency, the word that appears first in the paragraph is chosen.

*/

/* 
Extracting Information from the Problem Statement:

2.1 Input data type:
- The input consists of a string `paragraph` and an array `banned` containing banned words.
- `paragraph` is a string with a length between 1 and 1000 characters.
- `banned` is an array of strings, each containing one or more lowercase characters.

2.2 Expected Output:
- The most frequent word in the `paragraph` that is **not banned**.

2.3 Output return type:
- A string representing the most frequent non-banned word.

2.4 Time Complexity Expectations:
- The problem expects a solution that processes the `paragraph` efficiently (likely O(n)).

2.5 Explanation of Given Constraints:
- We need to process a string with a length of up to 1000 characters. 
- The banned list can have up to 100 banned words, each with a length of up to 10 characters.
*/

/* 
Thinking Solution for the Problem Statement:

3.1 Identification Part:
- This is a string and frequency counting problem.
- The key here is handling punctuation and converting everything to lowercase for uniform comparison.

3.2 Destructuring:
- We can break down the solution into:
  1. Cleaning up the paragraph to remove punctuation and split it into words.
  2. Converting each word to lowercase.
  3. Counting the frequency of each word that is **not banned**.
  4. Finding the word with the highest frequency that is not in the banned list.

3.3 Conversional solution into smaller subtask:
- **Subtask 1**: Clean the paragraph (remove punctuation and split it into words).
- **Subtask 2**: Convert all words to lowercase.
- **Subtask 3**: Filter out banned words.
- **Subtask 4**: Count the frequency of the remaining words.
- **Subtask 5**: Find the word with the highest frequency.
*/

/* 
Conversional Solution into subtasks:

S.no  | Subtask Description
1     | Clean the paragraph (remove punctuation and split it into words).
2     | Convert all words to lowercase.
3     | Filter out the banned words from the word list.
4     | Count the frequency of the words that are not banned.
5     | Return the most frequent word that is not banned.
*/

/* 
Subtasks of Conversional Solution into Code:

1. Use regular expressions to clean the paragraph and split it into words.
2. Convert words to lowercase using `toLowerCase()`.
3. Use a `HashSet` to store banned words for efficient checking.
4. Use a `HashMap` to count the frequency of each word.
5. Iterate through the `HashMap` to find the most frequent word that is not banned.
*/

/* 
Java Code according to conversational subtasks:
*/

import java.util.*;

public class MostFrequentWord {
    
    // Function to clean the paragraph and find the most frequent non-banned word
    public static String mostFrequent(String paragraph, String[] banned) {
        // Subtask 1: Clean the paragraph and split it into words
        paragraph = paragraph.replaceAll("[!?',;.]","").toLowerCase();
        String[] words = paragraph.split("\\s+");
        
        // Subtask 2: Create a HashSet for banned words for quick lookup
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        
        // Subtask 3: Create a map to store the frequency of non-banned words
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Subtask 4: Count the frequency of each non-banned word
        for (String word : words) {
            if (!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        // Subtask 5: Find the most frequent word that is not banned
        String mostFrequentWord = "";
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        
        // Return the most frequent non-banned word
        return mostFrequentWord;
    }
    
    public static void main(String[] args) {
        // Test case examples
        String paragraph1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned1 = {"hit"};
        String paragraph2 = "a.";
        String[] banned2 = {};
        
        System.out.println(mostFrequent(paragraph1, banned1)); // Output: "ball"
        System.out.println(mostFrequent(paragraph2, banned2)); // Output: "a"
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- Cleaning the paragraph using `replaceAll` and `split` takes O(n), where n is the length of the paragraph.
- Building the set of banned words and counting word frequencies each take O(m), where m is the number of words in the paragraph.
- Iterating through the words in the paragraph also takes O(m).
Thus, the overall time complexity is O(n + m).

Space Complexity:
- The space complexity is O(m) for storing the word frequencies and O(k) for storing the banned words, where k is the number of banned words. 

*/

/* 
If used any “for” loop or “while” loop, you have walkthrough all the “for” loop used in the code:

1. The first loop (`for (String word : words)`) iterates over all words in the cleaned paragraph to count their frequencies. It skips banned words.
2. The second loop (`for (Map.Entry<String, 
   Integer> entry : wordCount.entrySet())`) iterates over the map of word frequencies to find the word with the highest frequency.

Example walkthrough with input paragraph = "Bob hit a ball, the hit BALL flew far after it was hit." and banned = ["hit"]:

1. After cleaning and splitting, words are: ["bob", "hit", "a", "ball", "the", "hit", "ball", "flew", "far", "after", "it", "was", "hit"]
2. After processing the banned list, the map of word frequencies is:
   - "bob": 1
   - "a": 1
   - "ball": 2
   - "the": 1
   - "flew": 1
   - "far": 1
   - "after": 1
   - "it": 1
   - "was": 1
3. "ball" is the most frequent non-banned word.

*/

