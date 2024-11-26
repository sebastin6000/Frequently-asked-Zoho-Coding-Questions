/* 
Question:
Given an array of strings arr[] of length N, the task is to sort the strings in Lexicographical order.

Examples:

Input: arr[] = {"batman", "bat", "apple"}
Output: 
apple
bat 
batman
Explanation: 
The lexicographical order of string is “apple”, “bat”, “batman”

Input: arr[] = {"geeks", "for", "geeksforgeeks"}
Output: 
for
geeks
geeksforgeeks
*/

/* 
Understanding the Problem Statement:
- The goal is to sort an array of strings in lexicographical (dictionary) order.
- Lexicographical order means the order in which words are arranged in a dictionary. 
  For example, "apple" comes before "banana", and "bat" comes before "batman".

What is being asked:
- We need to take an array of strings and sort it in ascending lexicographical order.
- Once sorted, the strings should be printed, each on a new line.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An array of strings.
2. Expected Output:
   - Strings sorted in lexicographical order, printed one per line.
3. Output return type:
   - No return value is specified; the strings are printed.
4. Time complexity expectations:
   - The time complexity of sorting should be considered (likely O(N log N) for sorting).
5. Constraints:
   - There are no specific constraints on the size of the array (N) or the length of the strings, 
     but since sorting takes O(N log N), it is important to keep that in mind for large arrays.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - The problem asks for sorting the array of strings in lexicographical order, which is a standard task in string processing.
   - We need to leverage the sorting function to achieve this.

2. Destructuring:
   - We will convert the array into strings, then apply sorting, and finally print the sorted result.

3. Conversional solution into smaller subtask:
   - Subtask 1: Parse the input string array.
   - Subtask 2: Sort the array of strings in lexicographical order.
   - Subtask 3: Print the sorted strings one by one.

*/

/* 
Conversional Solution into Subtasks:
1. Parse the input string array.
2. Sort the array of strings in lexicographical order.
3. Print the sorted strings.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Convert the input array into strings.
2. Use a built-in sorting method to sort the strings.
3. Print the sorted strings.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.Arrays;

public class LexicographicalSort {

    // Function to sort the strings lexicographically and print them
    public static void sortStrings(String[] arr) {
        // Subtask 1: Sort the array of strings in lexicographical order
        Arrays.sort(arr);
        
        // Subtask 2: Print the sorted array of strings one by one
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        String[] arr1 = {"batman", "bat", "apple"};
        sortStrings(arr1); // Expected output: apple, bat, batman

        // Test case 2
        String[] arr2 = {"geeks", "for", "geeksforgeeks"};
        sortStrings(arr2); // Expected output: for, geeks, geeksforgeeks
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Sorting the array takes O(N log N), where N is the number of strings in the array.
  - The space complexity is O(N) for storing the array of strings.
  - Thus, the overall time complexity is dominated by the sorting step: O(N log N).
- Space Complexity:
  - The space complexity is O(N) as we store the input array of strings.

*/

/* 
“for” loop walkthrough  with every iteration with given input.
*/

/* 
The main loop in the code is the loop used to print the sorted strings:
- For the input `arr1 = {"batman", "bat", "apple"}`, after sorting the array using `Arrays.sort()`, the array becomes `["apple", "bat", "batman"]`.
- We then loop through the sorted array to print each string on a new line:
  1. First iteration: Print "apple".
  2. Second iteration: Print "bat".
  3. Third iteration: Print "batman".
  
For the input `arr2 = {"geeks", "for", "geeksforgeeks"}`:
- After sorting, the array becomes `["for", "geeks", "geeksforgeeks"]`.
- The output will be printed in the order: "for", "geeks", "geeksforgeeks".
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

/* 
For the input `arr1 = {"batman", "bat", "apple"}`:
1. We pass the array to `sortStrings()` function.
2. The array is sorted using `Arrays.sort()`, resulting in `["apple", "bat", "batman"]`.
3. We print each string:
   - First, "apple" is printed.
   - Then, "bat" is printed.
   - Finally, "batman" is printed.

For the input `arr2 = {"geeks", "for", "geeksforgeeks"}`:
1. The array is sorted, resulting in `["for", "geeks", "geeksforgeeks"]`.
2. The strings are printed:
   - "for" is printed first.
   - "geeks" is printed next.
   - "geeksforgeeks" is printed last.
*/
