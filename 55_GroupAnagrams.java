/*
Question:
Given an array of strings `strs`, group the anagrams together. 
You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
*/

/*
Understanding the Problem Statement:
- We are given an array of strings, and we need to group strings that are anagrams.
- An anagram is a word or phrase formed by rearranging the letters of a different word, using all the original letters exactly once.
- We are expected to return these anagrams grouped together in any order.

What is being asked:
- The task is to group the strings in such a way that anagrams are grouped together in separate lists. We can return the result in any order, and it should be a list of lists.

*/

/*
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is an array of strings `strs`.

2. Expected Output:
   - The output should be a list of lists of strings, where each sublist contains strings that are anagrams of each other.

3. Output return type:
   - The function should return a List<List<String>>.

4. Time complexity expectations:
   - Given that the size of the array can be as large as 10^4 and the length of each string can be up to 100, 
     the solution needs to handle these constraints efficiently. 
     The time complexity should ideally be O(n * k), where `n` is the number of strings and `k` is the average length of the strings.

5. Constraints:
   - The number of strings is between 1 and 10^4.
   - The length of each string is between 0 and 100.
   - Each string contains lowercase English letters.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - To identify anagrams, we can sort each string alphabetically. If two strings are anagrams, their sorted versions will be the same.
   - A more efficient way would be to use a frequency count of characters (since there are only 26 lowercase English letters) 
     which can uniquely identify anagrams.

2. Destructuring:
   - We will map each string to a key that is unique for its anagram group.
   - The key can be the sorted string or a tuple of character frequencies.
   - We can use a HashMap to store the anagram groups, where the key is the sorted version of the string (or the frequency array), 
     and the value is a list of strings that are anagrams.

3. Conversational solution into smaller subtask:
   - Subtask 1: Sort each string and use the sorted string as a key in a map.
   - Subtask 2: For each string, insert it into the corresponding list in the map.
   - Subtask 3: Return the values of the map as the result.

*/

/* 
Conversional Solution into Subtasks:
1. Iterate through each string in the array.
2. For each string, sort the characters alphabetically and use the sorted string as the key in a map.
3. If the key already exists in the map, add the string to the corresponding list. If not, create a new list for that key.
4. Return the lists of anagrams (map values).

*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a HashMap to store lists of anagrams.
2. Iterate through the input list of strings and for each string:
   - Sort the string.
   - Check if the sorted string is already a key in the map. If so, add the string to the corresponding list.
   - If not, create a new entry in the map with the sorted string as the key and a new list as the value.
3. Return the map's values as the result.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class GroupAnagrams {

    // Function to group anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map to store the anagram groups
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        // Iterate over the strings in the input array
        for (String str : strs) {
            // Sort the characters of the string and use it as a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // If the key doesn't exist, create a new list
            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            
            // Add the current string to the appropriate list
            anagramGroups.get(sortedStr).add(str);
        }
        
        // Return the grouped anagrams (values of the map)
        return new ArrayList<>(anagramGroups.values());
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs1));

        // Test case 2
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));

        // Test case 3
        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Sorting each string takes O(k log k), where `k` is the length of the string.
  - We perform this operation for each string, so the time complexity is O(n * k log k), where `n` is the number of strings.
  - In the worst case, `k` can be up to 100 (the length of each string), so the time complexity is manageable for the given constraints.
  
- Space Complexity:
  - We are storing the anagram groups in a HashMap, and each string is stored in one of the lists, 
    so the space complexity is O(n * k), where `n` is the number of strings and `k` is the average length of the strings.

*/

/* 
Explanation of loops:
1. In the `for` loop:
   - For each string in the input array:
     - We sort the string's characters.
     - Check if the sorted string exists in the map.
     - If it doesn't exist, create a new list.
     - Add the current string to the corresponding list.
   - After processing all the strings, the map contains lists of anagrams grouped together.

For input `strs = ["eat", "tea", "tan", "ate", "nat", "bat"]`:
- Iteration 1: "eat" -> sorted as "aet", added to map with key "aet".
- Iteration 2: "tea" -> sorted as "aet", added to list for "aet".
- Iteration 3: "tan" -> sorted as "ant", added to map with key "ant".
- Iteration 4: "ate" -> sorted as "aet", added to list for "aet".
- Iteration 5: "nat" -> sorted as "ant", added to list for "ant".
- Iteration 6: "bat" -> sorted as "abt", added to map with key "abt".

Finally, the map contains:
- "aet" -> ["eat", "tea", "ate"]
- "ant" -> ["tan", "nat"]
- "abt" -> ["bat"]

The result is: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]].

*/

/* 
Complete code walkthrough with applying the given input in code and explanation:

For input `strs = ["eat", "tea", "tan", "ate", "nat", "bat"]`:
1. Base case: initialize an empty map.
2. For each string:
   - Sort the string and use the sorted string as a key in the map.
   - Add the original string to the corresponding list.
3. After processing all strings, return the grouped anagrams.
Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]].
*/
