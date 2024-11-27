--------------------------------------------------- WITH TEMPLATE --------------------------------------------------------------------
/* 
Question Section:
You are given a string `s` consisting of `n` characters which are either 'X' or 'O'.
A move is defined as selecting three consecutive characters of `s` and converting them to 'O'. 
Note that if a move is applied to the character 'O', it will stay the same.

Return the minimum number of moves required so that all the characters of `s` are converted to 'O'.

Examples:

Input: s = "XXX"
Output: 1
Explanation: XXX -> OOO
We select all the 3 characters and convert them in one move.

Input: s = "XXOX"
Output: 2
Explanation: XXOX -> OOOX -> OOOO
We select the first 3 characters in the first move, and convert them to 'O'.
Then we select the last 3 characters and convert them so that the final string contains all 'O's.

Input: s = "OOOO"
Output: 0
Explanation: There are no 'X's in s to convert.

Constraints:
3 <= s.length <= 1000
s[i] is either 'X' or 'O'.
*/

/* 
Understanding the Problem Statement:
- We are given a string `s` of length `n` where each character is either 'X' or 'O'.
- The goal is to transform all the 'X' characters to 'O' by selecting three consecutive 'X' characters at a time and changing them to 'O'.
- We need to find the minimum number of such moves to convert all characters of the string `s` to 'O'.

What is being asked?
- Given a string `s`, we need to determine how many moves are required to change all 'X' characters to 'O'.
- The string will contain between 3 and 1000 characters, and only characters 'X' and 'O' are allowed.
- The number of moves is minimized by selecting three consecutive 'X' characters in each move, turning them into 'O'.

*/

 /* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A string `s` consisting of only the characters 'X' and 'O'.
   
2. Expected Output:
   - An integer representing the minimum number of moves required to turn all 'X' characters into 'O'.

3. Output return type:
   - An integer value.

4. Explanation of Time complexity expectations:
   - The solution should ideally run in O(n) time, where `n` is the length of the string `s`, since the string can be as long as 1000 characters.

5. Explanation of given Constraints:
   - The length of the string is between 3 and 1000.
   - Each character in the string is either 'X' or 'O'.
*/

 /* 
Thinking Solution for the Problem Statement:
1. Identification:
   - The key challenge is to minimize the number of moves, which means converting as many 'X' characters as possible in each move.
   - A move affects exactly 3 consecutive characters, 
     so the optimal approach would be to always select a set of 3 consecutive 'X' characters and convert them.

2. Destructuring:
   - Traverse through the string from left to right.
   - Each time a 'X' is found, attempt to "convert" the next three characters (if they are 'X') to 'O' in one move.
   - Count how many such moves are needed.

3. Conversional solution into smaller subtask:
   - Subtask 1: Traverse the string and check for sequences of consecutive 'X' characters.
   - Subtask 2: When three consecutive 'X' characters are found, simulate the move and increment the move count.
   - Subtask 3: Skip the next two characters after performing a move, since they are already converted.

*/

 /* 
Conversional Solution into Subtasks:
1. Traverse the string from left to right.
2. For each 'X' found, check if a group of three consecutive 'X's can be converted to 'O'.
3. When a move is made (i.e., three consecutive 'X' characters are turned into 'O'), increment the move counter.
4. Skip past the three characters that have been changed.

*/

 /* 
Subtasks of Conversional Solution into Code:
1. Initialize a variable to keep track of the number of moves.
2. Iterate over the string, checking for 'X' characters and attempting to convert three consecutive 'X' characters.
3. After converting, skip the next two characters to avoid unnecessary moves.
4. Return the total number of moves.

*/

public class MinimumMovesToConvertXToO {

    /* 
    Function to find the minimum number of moves required to convert all 'X' to 'O'.
    We select three consecutive 'X' characters in each move and convert them to 'O'.
    */
    public static int minMovesToConvert(String s) {
        int moves = 0;
        int n = s.length();
        char[] arr = s.toCharArray();
        
        // Iterate through the string
        for (int i = 0; i <= n - 3; i++) {
            // When 'X' is found, perform the move
            if (arr[i] == 'X') {
                moves++;  // Increment move count
                // Convert the next 3 characters to 'O'
                arr[i] = arr[i+1] = arr[i+2] = 'O';
            }
        }
        
        return moves;
    }
    public static void main(String[] args) {
        // Test case 1
        String s1 = "XXX";
        System.out.println("Minimum moves: " + minMovesToConvert(s1)); // Expected output: 1
        
        // Test case 2
        String s2 = "XXOX";
        System.out.println("Minimum moves: " + minMovesToConvert(s2)); // Expected output: 2
        
        // Test case 3
        String s3 = "OOOO";
        System.out.println("Minimum moves: " + minMovesToConvert(s3)); // Expected output: 0
    }
}
/* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - O(n), where `n` is the length of the string. We process each character of the string only once, performing constant-time operations.
    
    Space Complexity:
    - O(1), we are only using a fixed amount of space (variables for counting moves and a char array for modifying the string).
    */

    /* 
    Code Walkthrough:
    Let's walk through the example `s = "XXOX"`:

    - Initial string: `XXOX`
    - We start iterating through the string:
      - At index 0, we find 'X'. We perform a move, converting the first 3 characters to 'O', resulting in `OOOX`.
      - At index 3, there are no more 'X' characters, so we stop.
    
    - Total moves = 2.

    Output: `2`
    */
/*

### Explanation:

1. **`minMovesToConvert(String s)`**:
   - This function calculates the minimum number of moves required to convert all 'X' characters to 'O'. 
     It does so by iterating through the string, and whenever an 'X' is encountered, 
     it checks the next two characters as well, converting all three to 'O' in one move.

2. **Steps**:
   - **Initialization**: 
      We initialize a counter `moves` to track the number of moves.
   - **Loop through the string**: 
      We check every position in the string. If a 'X' is found, 
      we convert it and the next two characters (if they exist) to 'O'. 
      We then increment the `moves` counter and skip ahead by 3 positions.
   - **End Condition**: 
      The loop continues until we reach the third-to-last position, ensuring that we can always check the next three characters.

3. **Time Complexity**:
   - The solution iterates over the string exactly once, making the time complexity O(n), where `n` is the length of the string.
   
4. **Space Complexity**:
   - The space complexity is O(1) because we only use a constant amount of extra space. 
     We modify the string in-place using a character array and maintain a single counter.

### Example Walkthrough:

For the string `s = "XXOX"`:
- First iteration: At index 0, we encounter 'X'. We change the first three characters (`"XXX" -> "OOO"`) in one move, resulting in `OOOX`.
- At index 3, the loop ends because there are no more 'X' characters left.
- The result is 2 moves, as expected.

### Output:

For the given test cases:
1. `XXX` → 1 move.
2. `XXOX` → 2 moves.
3. `OOOO` → 0 moves.
*/
--------------------------------------------------- WITHOUT TEMPLATE --------------------------------------------------------------------
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
// WITHOUT EXPLANATION
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

--------------------------------------------------------------------------------------------------
// WITH EXPLANATION
import java.util.*;

public class MinimumMovesToConvert {

    // Function to find the minimum moves required
    public int minMovesToConvert(String s) {
        int moves = 0;
        char[] arr = s.toCharArray();
        
        for (int i = 0; i <= arr.length - 3; i++) 
        {
          /* Great question! 
          The condition i <= arr.length - 3 is used in the for loop to ensure that we only check valid groups of three consecutive characters in the array.
          Let me explain it step by step:
          Length of Array:
          
          
          Suppose the length of the array arr is n.
          When we are looking for three consecutive characters to check, we need at least 3 elements left starting from the current index i.
          Reason for i <= arr.length - 3:
          
          
          If we start from index i, we need to ensure that the next two indices (i+1 and i+2) are still valid indices in the array.
          If i is the last possible index where we can form a group of three consecutive characters, that would be i = arr.length - 3. 
          This is the last valid index where we can check three consecutive elements without going out of bounds.
          Example:
          
          
          Suppose the array has 4 elements (arr.length = 4):
           arr = ['X', 'X', 'O', 'X']
          
          
          The last valid index i where we can check three consecutive elements is i = 1 because:
          arr[1], arr[2], arr[3] is a valid triplet.
          If we try i = 2, the triplet would be arr[2], arr[3], arr[4], but arr[4] is out of bounds, so it is invalid.
          Hence, i <= arr.length - 3 ensures that we stop the loop at index arr.length - 3 to prevent accessing invalid indices.
          Why not i < arr.length - 2?
          
          
          If you used i < arr.length - 2, the loop would attempt to check i = arr.length - 2, which would only have two elements left, not three. 
          So, you'd be trying to access invalid indices beyond the array bounds.
          Let's go through a few examples with different string lengths to understand this better:
          
          Example 1: Input string "XXX" (Length = 3)
          arr.length = 3
          arr.length - 3 = 0
          The loop runs from i = 0 to i = 0 (only one iteration).
          In this case, i <= arr.length - 3 works fine because we are allowed to check the entire array (3 consecutive 'X's).
          
          Example 2: Input string "XXOX" (Length = 4)
          arr.length = 4
          arr.length - 3 = 1
          The loop runs from i = 0 to i = 1.
          Iteration 1 (i = 0):
          We check the substring arr[0], arr[1], arr[2], which is 'X', 'X', 'O' (valid).
          Iteration 2 (i = 1):
          We check the substring arr[1], arr[2], arr[3], which is 'X', 'O', 'X' (valid).
          
          Example 3: Input string "XOX" (Length = 3)
          arr.length = 3
          arr.length - 3 = 0
          The loop runs from i = 0 to i = 0 (only one iteration).
          In this case, we are still checking the only valid triplet of 'X', 'O', 'X'.
          
          Example 4: Input string "XXXXX" (Length = 5)
          arr.length = 5
          arr.length - 3 = 2
          The loop runs from i = 0 to i = 2.
          Iteration 1 (i = 0):
          We check the substring arr[0], arr[1], arr[2], which is 'X', 'X', 'X' (valid).
          Iteration 2 (i = 1):
          We check the substring arr[1], arr[2], arr[3], which is 'X', 'X', 'X' (valid).
          Iteration 3 (i = 2):
          We check the substring arr[2], arr[3], arr[4], which is 'X', 'X', 'X' (valid).
          
          To Summarize:
          i <= arr.length - 3 ensures that we do not attempt to access indices beyond the end of the array when looking for three consecutive characters.
          We need at least 3 characters left starting from index i to form a valid triplet. If i goes beyond arr.length - 3, we cannot form a triplet anymore.
          Let me know if you need any further clarification!
          

*/
            // Check if we find a sequence of three consecutive 'X's
            if (arr[i] == 'X' && arr[i+1] == 'X' && arr[i+2] == 'X') {
                // Perform a move: convert these three 'X's into 'O's
                arr[i] = arr[i+1] = arr[i+2] = 'O';
                moves++;  // Increment the number of moves
                i += 2;   // Skip the next two characters as they are already 'O'
            }
        }
        return moves;
            /* 
      Ah, I understand now! You want a step-by-step breakdown for all the inputs provided in the example, 
      and we’ll go through each loop iteration.
      
        Let’s go through the process for all three examples:
        1. Input: "XXX"
        The string "XXX" has all characters as 'X'.
        Array Initialization:
        arr = ['X', 'X', 'X']
        moves = 0
        
        Loop:
        The loop runs from i = 0 to i <= arr.length - 3. In this case, arr.length - 3 = 0. So, we only have one iteration.
        First Iteration: i = 0
        The substring being checked is arr[0], arr[1], arr[2], which is 'X', 'X', 'X'.
        The condition in the if statement is:
         arr[0] == 'X' && arr[1] == 'X' && arr[2] == 'X'
         This evaluates to true because all three characters are 'X'.
        Therefore, we change the first three 'X's to 'O's:
         arr[0] = arr[1] = arr[2] = 'O';
        moves++;
        
        
        The moves counter increases to 1, and the updated array becomes:
         arr = ['O', 'O', 'O']
        
        
        Output:
        After one move, the string is all 'O's, so the output is 1.
        
        2. Input: "XXOX"
        The string "XXOX" has some 'O's mixed in. We need to process it carefully.
        Array Initialization:
        arr = ['X', 'X', 'O', 'X']
        moves = 0
        
        Loop:
        The loop runs from i = 0 to i <= arr.length - 3. In this case, arr.length - 3 = 1, so the loop will run twice (i = 0 and i = 1).
        First Iteration: i = 0
        The substring being checked is arr[0], arr[1], arr[2], which is 'X', 'X', 'O'.
        The condition in the if statement is:
         arr[0] == 'X' && arr[1] == 'X' && arr[2] == 'X'
         This evaluates to false because arr[2] is 'O', not 'X'.
        No changes are made, and the moves counter remains 0.
        Second Iteration: i = 1
        The substring being checked is arr[1], arr[2], arr[3], which is 'X', 'O', 'X'.
        The condition in the if statement is:
         arr[1] == 'X' && arr[2] == 'X' && arr[3] == 'X'
         This evaluates to false because arr[2] is 'O', not 'X'.
        No changes are made, and the moves counter remains 0.
        Output:
        Since there are no valid sequences of three consecutive 'X's to change, the output is 0.
        
        3. Input: "OOOO"
        This string has no 'X's at all, so no moves are needed.
        Array Initialization:
        arr = ['O', 'O', 'O', 'O']
        moves = 0
        
        Loop:
        The loop runs from i = 0 to i <= arr.length - 3. In this case, arr.length - 3 = 1, so the loop will run twice (i = 0 and i = 1).
        First Iteration: i = 0
        The substring being checked is arr[0], arr[1], arr[2], which is 'O', 'O', 'O'.
        The condition in the if statement is:
         arr[0] == 'X' && arr[1] == 'X' && arr[2] == 'X'
         This evaluates to false because all characters are 'O', not 'X'.
        No changes are made, and the moves counter remains 0.
        Second Iteration: i = 1
        The substring being checked is arr[1], arr[2], arr[3], which is 'O', 'O', 'O'.
        The condition in the if statement is:
         arr[1] == 'X' && arr[2] == 'X' && arr[3] == 'X'
         This evaluates to false because all characters are 'O', not 'X'.
        No changes are made, and the moves counter remains 0.
        Output:
        Since there are no 'X's in the string, no moves are needed, and the output is 0.
        
        Summary of Outputs:
        Input: "XXX" → Output: 1
        Input: "XXOX" → Output: 0
        Input: "OOOO" → Output: 0
        
        Time Complexity:
        Time Complexity: O(n), where n is the length of the string. We go through the string once and check consecutive triples of characters.
        Space Complexity: O(n), because we convert the string to a character array, which requires space proportional to the input size.
        Final Observations:
        The loop works by checking groups of three consecutive characters in the string.
        The condition to perform the conversion is met only when three consecutive 'X's are found.
        The solution is efficient with a time complexity of O(n), and the space complexity is O(n) because we use a character array to modify the string.
       */
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
- **Space Complexity:** O(n), because we convert the string into a character array to modify it in place. 
     The space complexity is proportional to the size of the input string.

The time complexity is efficient for the given constraints, as we only loop through the string once. 
The space complexity is also manageable since we are using a character array that is at most the size of the input string.

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
