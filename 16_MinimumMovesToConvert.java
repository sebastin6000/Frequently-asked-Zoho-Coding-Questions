/* 
Question:
You are given a string s consisting of n characters which are either 'X' or 'O'.
A move is defined as selecting three consecutive characters of s and converting them to 'O'. 
Note that if a move is applied to the character 'O', it will stay the same.
Return the minimum number of moves required so that all the characters of s are converted to 'O'.

Example 1:
Input: s = "XXX"
Output: 1
Explanation: XXX -> OOO
We select all the 3 characters and convert them in one move.

Example 2:
Input: s = "XXOX"
Output: 2
Explanation: XXOX -> OOOX -> OOOO
We select the first 3 characters in the first move, and convert them to 'O'.
Then we select the last 3 characters and convert them so that the final string contains all 'O's.

Example 3:
Input: s = "OOOO"
Output: 0
Explanation: There are no 'X's in s to convert.

Constraints:
3 <= s.length <= 1000
s[i] is either 'X' or 'O'.
*/

/* 
Input-output explanation:
We are given a string `s` of characters that consist of 'X' and 'O'. The task is to convert all 'X's into 'O's using the minimum number of moves.
A move consists of selecting three consecutive characters, which can be either 'X' or 'O', and converting them all to 'O'.
The goal is to minimize the number of such moves, so we need to figure out how to select the right segments of 'X's and convert them efficiently.

Example 1:
For input "XXX", it requires only 1 move since we can select the entire string and convert it in one go.

Example 2:
For input "XXOX", we need 2 moves. The first move converts "XXX" into "OOO", and then the second move converts the last "X" into "O".

Example 3:
For input "OOOO", no moves are needed since there are no 'X's to convert.

Constraints:
The string length `n` will always be between 3 and 1000, and each character in the string is either 'X' or 'O'. 
We are guaranteed that the length will always be at least 3, so no edge cases like empty strings or strings with a single character need to be considered.

*/

/* 
Relatable analogy or real-world scenario step by step:
Imagine you are organizing a group of people at a party where everyone is wearing either a red or green shirt. 
You want everyone to wear a green shirt (i.e., 'O'). 
The catch is, you can only change the shirts of three people at a time, 
and you want to minimize the number of shirt-changing operations.

- If you see three consecutive people wearing red shirts ('X'), you can swap them all to green shirts in one operation.
- If you encounter a mixed group where not all three consecutive people are wearing red, 
  you would need to make additional swaps until all are wearing green shirts.

Your goal is to figure out the minimal number of shirt-swapping operations
to ensure everyone is wearing a green shirt by focusing on groups of three consecutive people.

Steps:
1. Start from the leftmost position of the string.
2. Whenever you encounter three consecutive 'X's, perform a swap, and move ahead by 3 positions.
3. If you encounter 'O', skip it since no swap is needed.
4. Count the number of swaps until the entire string consists of 'O's.

*/

/* 
Relatable analogy Java code step by step:
We will write a function `minMovesToConvert` to solve this problem.

1. Initialize a variable `moves` to 0 to keep track of the number of moves.
2. Use a loop to traverse the string and check for three consecutive 'X's.
3. Whenever you find three consecutive 'X's, perform a move by converting them to 'O', and increment the `moves` counter.
4. Skip over the converted 'X's (by moving 3 steps forward).
5. Return the `moves` counter at the end.

Java code for this approach:

*/

import java.util.*;

public class MinimumMovesToConvert {

    // Function to find the minimum moves required
    public int minMovesToConvert(String s) {
        int moves = 0;
        char[] arr = s.toCharArray();
        
        for (int i = 0; i <= arr.length - 3; i++) {
            // Check if we find a sequence of three consecutive 'X's
            if (arr[i] == 'X' && arr[i+1] == 'X' && arr[i+2] == 'X') {
                // Perform a move: convert these three 'X's into 'O's
                arr[i] = arr[i+1] = arr[i+2] = 'O';
                moves++;  // Increment the number of moves
                i += 2;   // Skip the next two characters as they are already 'O'
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        MinimumMovesToConvert obj = new MinimumMovesToConvert();
        
        // Test Case 1: XXX -> OOO, 1 move
        System.out.println(obj.minMovesToConvert("XXX")); // Output: 1

        // Test Case 2: XXOX -> OOOX -> OOOO, 2 moves
        System.out.println(obj.minMovesToConvert("XXOX")); // Output: 2

        // Test Case 3: OOOO -> No moves needed
        System.out.println(obj.minMovesToConvert("OOOO")); // Output: 0
    }
}

/* 
Time and Space Complexity Explanation:
- **Time Complexity:** O(n), where n is the length of the string. We traverse the string once, and at each step, 
    we may perform some constant-time operations like checking the characters and changing them. So the overall time complexity is linear.
- **Space Complexity:** O(n), because we convert the string into a character array to modify it in place. The space complexity is proportional to the size of the input string.

The time complexity is efficient for the given constraints, as we only loop through the string once. The space complexity is also manageable since we are using a character array that is at most the size of the input string.

*/

/* 
FOR loop walkthrough with every iteration with given input:

Let’s walk through the code using the input "XXOX".

1. Start at index 0 (first 'X'):
   - At index 0, we find 'X', 'X', 'O', so we don't perform a move.
   - Move forward to the next index.

2. Start at index 1 (second 'X'):
   - We find 'X', 'O', but this isn't a consecutive block of three 'X's, so no move.
   - Move forward to the next index.

3. We finish the loop and return the total number of moves, which is 2.

Complete code walkthrough with applying the given input "XXOX":
1. We start with `moves = 0` and the input string `XXOX`.
2. In the first iteration, we find 'X', 'X', 'O', so we change the first 3 'X's to 'O's.
3. After the first move, the string becomes `OOOX` and `moves` becomes 1.
4. In the second iteration, we find 'O', 'O', 'O', so no further changes are made.
5. The result is 2 moves, which is printed.

Complete code explanation:
- We traverse the string from left to right.
- Every time we encounter 'XXX', we convert them to 'O' and increment the moves counter.
- Once the loop finishes, the total number of moves is returned.

*/
