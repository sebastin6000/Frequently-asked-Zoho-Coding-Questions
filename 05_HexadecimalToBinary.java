/* 
Section -1 (Question section)
Problem Statement:
Given a Hexadecimal number as an input, the task is to convert that number to a Binary number.

Examples:

Input: Hexadecimal = 1AC5
Output: Binary = 0001101011000101
Explanation:
    Equivalent binary value of 1: 0001
    Equivalent binary value of A: 1010
    Equivalent binary value of C: 1100
    Equivalent binary value of 5: 0101

Input: Hexadecimal = 5D1F
Output: Binary = 0101110100011111
*/

 /* 
Section - 2 (Understanding the Problem Statement section)
The task is to take a hexadecimal number as input and convert it into its binary representation. A hexadecimal number uses base-16, 
while binary uses base-2. Every digit in the hexadecimal system can be represented by 4 binary digits (bits).

In this problem:
1. We are given a hexadecimal string.
2. We need to convert each hexadecimal character to its binary equivalent, ensuring that each binary representation is exactly 4 bits long.
3. We will then concatenate the binary values of each hexadecimal character to form the final binary number.

The goal is to implement this conversion and output the binary equivalent of the given hexadecimal number.
*/

 /* 
Section - 3 (Extracting Information from the Problem Statement section)
1. Input:
   - A hexadecimal string (e.g., "1AC5", "5D1F") that we need to convert to binary.
   - The hexadecimal string consists of characters from the set {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F}.

2. Output:
   - A string representing the binary equivalent of the given hexadecimal input.
   - The binary output should be a concatenation of 4-bit binary representations for each hexadecimal digit.

3. Constraints:
   - The input hexadecimal string will be valid and consist of only valid hexadecimal characters.
   - The length of the input string is not specified but is assumed to be reasonable for conversion.

4. Time Complexity:
   - For a given input string of length `n`, the algorithm iterates over each character once, converting it to binary, so the time complexity is O(n).

5. Space Complexity:
   - We use a string to store the resulting binary number, and the space complexity is O(n), where `n` is the length of the input hexadecimal string.
 */

 /* 
Section - 4 (Thinking Solution for the Problem Statement section)
To solve the problem, we can follow these steps:
1. First, create a mapping for each hexadecimal character to its 4-bit binary equivalent.
2. Then, iterate over the given hexadecimal string.
3. For each hexadecimal character, retrieve its corresponding 4-bit binary value and concatenate it to a result string.
4. Finally, return the concatenated binary string as the output.

Each hexadecimal character corresponds to exactly 4 binary digits, 
so we need to ensure that the binary string for each character is padded with leading zeros if necessary (i.e., ensure it's always 4 bits).
 */

 /* 
Section - 5 (Input to Output conversion steps into smaller subtasks section)
Subtask 1: Create a mapping of hexadecimal characters to their binary equivalents.
Subtask 2: Iterate over the input hexadecimal string.
Subtask 3: For each character, get its binary equivalent and ensure it's 4 bits long.
Subtask 4: Concatenate the binary strings together to form the final result.
Subtask 5: Output the final binary string.
 */

 /* 
Section - 6 (Input to Output conversion subtasks into Code section)
Subtask 1: We need a mapping between hexadecimal characters and their binary equivalents.
Subtask 2: We need a loop to iterate through each character in the hexadecimal string.
Subtask 3: For each character, convert it to binary using the mapping.
Subtask 4: Concatenate the binary representations and return the final result.
 */

 /* 
Section - 7 (Code Requirement to complete the subtasks section)
We will use:
1. A `HashMap` to store the hexadecimal to binary mapping.
2. A loop to iterate through each character in the hexadecimal input string.
3. String concatenation to form the final binary number.
4. The `String.format` method or `Integer.toBinaryString` to ensure 4-bit binary representation.
 */

 /* 
Section - 8 (Explanation of Approach section)
1. Mapping: A `HashMap` is used to store the conversion from hexadecimal digits to their 4-bit binary equivalents.
2. Iterating through input: We iterate through the hexadecimal string, convert each character to binary, and ensure it's exactly 4 bits using `String.format`.
3. String concatenation: For each binary conversion, we append it to the result string.
4. Output: Once all hexadecimal characters have been processed, the concatenated binary string is printed as the result.
 */

 /* 
Section - 9 (Java Code according to Input to Output conversion subtasks)
*/
import java.util.HashMap;

public class HexToBinary 
{
    // Function to convert Hexadecimal to Binary
    public static String convertHexToBinary(String hex) 
    {
        // Map of Hexadecimal digits to Binary equivalents
        HashMap < Character, String > hexToBinaryMap = new HashMap < > ();
        hexToBinaryMap.put('0', "0000");
        hexToBinaryMap.put('1', "0001");
        hexToBinaryMap.put('2', "0010");
        hexToBinaryMap.put('3', "0011");
        hexToBinaryMap.put('4', "0100");
        hexToBinaryMap.put('5', "0101");
        hexToBinaryMap.put('6', "0110");
        hexToBinaryMap.put('7', "0111");
        hexToBinaryMap.put('8', "1000");
        hexToBinaryMap.put('9', "1001");
        hexToBinaryMap.put('A', "1010");
        hexToBinaryMap.put('B', "1011");
        hexToBinaryMap.put('C', "1100");
        hexToBinaryMap.put('D', "1101");
        hexToBinaryMap.put('E', "1110");
        hexToBinaryMap.put('F', "1111");

        // StringBuilder to store the binary result
        StringBuilder binaryResult = new StringBuilder();

        // Iterate over each character in the hex string
        for (int i = 0; i < hex.length(); i++) 
        {
            char hexChar = hex.charAt(i);
            // Append the corresponding 4-bit binary value for the current hex character
            binaryResult.append(hexToBinaryMap.get(hexChar));
        }
        return binaryResult.toString();
    }
    public static void main(String[] args) 
    {
        // Test cases
        String hex1 = "1AC5";
        String hex2 = "5D1F";

        // Output the result for both test cases
        System.out.println("For Hexadecimal: " + hex1);
        System.out.println("Binary: " + convertHexToBinary(hex1));

        System.out.println("\nFor Hexadecimal: " + hex2);
        System.out.println("Binary: " + convertHexToBinary(hex2));
    }
}

/* 
Section - 10 (Time and Space Complexity Explanation)
Time Complexity:
- The time complexity of the solution is O(n), where `n` is the length of the input hexadecimal string. 
  We iterate over each character in the string and perform constant-time operations to convert it to binary.

Space Complexity:
- The space complexity is O(n) because we store the resulting binary string, 
  which can be at most 4 times the length of the input hexadecimal string. 
  The space for the `HashMap` is constant, as it stores the binary representation for the 16 possible hexadecimal digits.
 */

/* 
Section - 11 (If “for” loop or “while” loop are used in the code you have to walkthrough all the(more than 1)
              “for” loop or “while” loop used in the code with every iteration with given input and this section has to be inside this structure of comments)

Explanation of loops:

Loop 1 (Iterating through the hexadecimal string):
- In this loop, we iterate over each character in the hexadecimal string and convert it to its binary equivalent using the `hexToBinaryMap`.
- Example for `hex = "1AC5"`:
    - For '1', the binary value is "0001".
    - For 'A', the binary value is "1010".
    - For 'C', the binary value is "1100".
    - For '5', the binary value is "0101".
    - The final binary string becomes: "0001101011000101".

Loop 2 (Building the result):
- The binary values are appended to the `StringBuilder` and the result is returned after the loop finishes.
 */

 /* 
Section - 12 (Complete code walkthrough with applying the given input in code and explanation)

For `hex = "1AC5"`:
1. Start with '1', binary equivalent is "0001".
2. Move to 'A', binary equivalent is "1010".
3. Move to 'C', binary equivalent is "1100".
4. Move to '5', binary equivalent is "0101".
5. Concatenate all the binary strings to get "0001101011000101".

For `hex = "5D1F"`:
1

. Start with '5', binary equivalent is "0101". 2. Move to 'D', binary equivalent is "1101". 3. Move to '1', 
  binary equivalent is "0001". 4. Move to 'F', binary equivalent is "1111". 5. Concatenate all the binary strings to get "0101110100011111". */


/*
 Key Points:
- The algorithm uses a simple mapping of hexadecimal digits to their binary equivalents.
- The loop goes through each character of the hexadecimal string and appends the corresponding 4-bit binary string to the result.
- The result is built using `StringBuilder`, which is efficient for concatenating strings in Java.

This approach ensures that we can convert any valid hexadecimal number into a binary number while maintaining O(n) time and space complexity.
*/


