/* 
Question:
Given an odd length word, 
your task is to complete the function `printPattern` 
that takes a string `s` as its argument and prints it from the middle of the word in such a way that it follows the given pattern.

Input: 
PROGRAM
Output: 
G$ GR$ GRA$ GRAM$ 
GRAMP$ GRAMPR$ GRAMPRO$

Input: 
RAT
Output: 
A$ AT$ ATR$

NOTE: 
Each row of the pattern is printed on a single line, and each word is separated by a "$". 

Constraints:
1 ≤ T ≤ 20
1 ≤ size of string(s) ≤ 20
*/

/* 
Understanding the Problem Statement:
- We are given a string of odd length `s` and need to print parts of the string, starting from the middle character.
- Each subsequent output should expand one character from the left until the full string is printed.
- Each part of the string should be followed by a `$` and printed in a single line.

What is being asked:
- We need to write a function that will take a string, extract substrings starting from the middle, 
  and progressively expand the substring, printing them in the required format.
*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input consists of a single string `s` of odd length.

2. Expected Output:
   - Print the substrings starting from the middle of the string, progressively expanding and separated by `$`.

3. Output return type:
   - The function should print the output directly (not return anything).

4. Time complexity expectations:
   - We should expect to process each character at least once, so the time complexity should be O(n), where n is the length of the string.

5. Constraints:
   - The string length is between 1 and 20.
   - The number of test cases (T) is between 1 and 20.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a pattern-based problem where we need to print substrings starting from the middle and progressively expanding the length.

2. Destructuring:
   - First, we identify the middle index of the string.
   - We then need to extract substrings starting from this middle index.
   - We print these substrings in a format where each is followed by `$`, and all substrings are printed on the same line.

3. Conversational solution into smaller subtask:
   - Step 1: Find the middle index of the string (since the length is odd, it's simply `length / 2`).
   - Step 2: Start from the middle and progressively expand the substring by one character to the left.
   - Step 3: Print each substring followed by a `$` sign, without a trailing `$` on the last substring.

*/

/* 
Conversional Solution into Subtasks:
1. Find the middle index of the string.
2. Start from the middle character and progressively include characters to the left.
3. For each substring, print it followed by a `$`.
4. Ensure that the format is correct and no extra `$` is printed after the last substring.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Calculate the middle index of the string.
2. Loop from the middle index to the start of the string.
3. For each index, create a substring and print it followed by a `$`.
4. The last substring should not be followed by a `$`.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.Scanner;

public class PrintPattern {

    // Function to print the pattern as described
    public static void printPattern(String s) {
        int n = s.length();          // length of the string
        int mid = n / 2;             // middle index of the string
        
        // Start from the middle and build the pattern
        for (int i = mid; i >= 0; i--) {
            // Create the substring from the middle to the current index
            String substring = s.substring(i, mid + 1);
            
            // Print the substring followed by "$"
            System.out.print(substring + "$");
        }
        
        // Newline after the first half of the pattern is printed
        System.out.println();
        
        // Start from the middle+1 and build the second half of the pattern
        for (int i = mid + 1; i < n; i++) {
            // Create the substring from the start to the current index
            String substring = s.substring(mid, i + 1);
            
            // Print the substring followed by "$"
            System.out.print(substring + "$");
        }
        
        // Newline after the second half of the pattern is printed
        System.out.println();
    }

    // Main function to test the pattern printing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Test case 1
        String s1 = "PROGRAM";
        printPattern(s1);   // Expected output: G$ GR$ GRA$ GRAM$ GRAMP$ GRAMPR$ GRAMPRO$

        // Test case 2
        String s2 = "RAT";
        printPattern(s2);   // Expected output: A$ AT$ ATR$
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:
- The function `printPattern()` loops over the string twice, once for the first half and once for the second half.
- Each operation in the loop involves creating a substring and printing it, both of which take O(n) time.
- Therefore, the overall time complexity is O(n), where n is the length of the string.

Space Complexity:
- We create substrings for each iteration, but we are only using space proportional to the size of the string (for storing substrings).
- Hence, the space complexity is O(n), where n is the length of the string.

*/

/* 
For Loop Walkthrough:
1. First loop:
   - This loop iterates over the string starting from the middle (`mid`) and prints substrings by progressively expanding to the left.
   - For example, starting from "G", then "GR", "GRA", "GRAM", and so on.
2. Second loop:
   - This loop iterates over the string starting from the middle+1 to the end of the string.
   - For example, starting from "GRAMP", "GRAMPR", "GRAMPRO" and so on.

Complete Code Walkthrough:
- In the main function, we define two test cases: "PROGRAM" and "RAT".
- The function `printPattern` starts by calculating the middle index (`mid`).
- It then uses two loops:
   - The first loop prints substrings from the middle towards the left.
   - The second loop prints substrings from the middle towards the right.
- Substrings are printed with `$` after each one, and each part of the string is printed on the same line.

*/
