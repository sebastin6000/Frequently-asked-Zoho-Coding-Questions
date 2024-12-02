/* 
Section-1: Question Section
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
Explanation:
    Equivalent binary value of 5: 0101
    Equivalent binary value of D: 1101
    Equivalent binary value of 1: 0001
    Equivalent binary value of F: 1111

Your Task: 
You don't need to read or print anything. 
Your task is to complete the function `convertHexToBinary()` 
which takes a hexadecimal string as input and returns the corresponding binary string.

Expected Time Complexity: O(n), where n is the length of the input hexadecimal string.
Expected Space Complexity: O(n), where n is the length of the input hexadecimal string.

Constraints:
- The input hexadecimal string will be valid and consists of only valid hexadecimal characters.
*/

  
/* 
Section-2: Understanding the Problem Statement
The task requires converting a hexadecimal number (base-16) into a binary number (base-2). 
A hexadecimal digit can be mapped directly to a 4-bit binary representation. 

What is being asked?
You are required to take a hexadecimal number as input and convert it into its corresponding binary representation.

Key Points:
1. Each hexadecimal digit corresponds to a 4-bit binary value.
2. The output must be the concatenation of the binary equivalents of each hexadecimal digit.
3. The solution must be efficient enough to handle the input size of up to n hexadecimal digits.

*/


/* 
Section-3: Extracting Information from the Problem Statement
Input:
- hex: A hexadecimal string that needs to be converted to binary.

Expected Output:
- A binary string representing the equivalent binary number of the input hexadecimal.

Return Type:
- The return type should be a binary string.

Constraints:
- The length of the input hexadecimal string is up to n (1 ≤ n ≤ 10^5).
- The hexadecimal characters are limited to the characters in {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F}.

Time Complexity:
- The time complexity should be O(n) for processing each hexadecimal digit and converting it to its binary equivalent.

Space Complexity:
- The space complexity is O(n) for storing the resulting binary string and the intermediate data.
*/


/* 
Section-4: Thinking Solution for the Problem Statement
To solve the problem efficiently:
1. Map each hexadecimal digit to its corresponding 4-bit binary value.
2. Iterate over each digit of the hexadecimal number, converting it into binary and appending it to the result string.
3. Finally, return the concatenated binary string as the output.

By converting each hexadecimal digit into its fixed-length binary equivalent and storing it in a result string, 
we can handle the conversion process in O(n) time, where n is the length of the input string.

*/

  
/* 
Section-5: Input to Output Conversion Steps into Smaller Subtasks
S.No | Subtask Description
1    | Iterate through each hexadecimal character in the input string.
2    | For each hexadecimal character, convert it to its 4-bit binary equivalent.
3    | Append each binary equivalent to the result string.
4    | Return the final concatenated binary string as the output.

*/

  
/* 
Section-6: Input to Output Conversion Subtasks into Code
S.No | Subtask Description                                       | Code Approach
1    | Iterate through each hexadecimal character.               | Loop through each character in the input hexadecimal string.
2    | Convert hexadecimal digit to binary using a mapping.      | Use a predefined mapping (HashMap or array) for each hexadecimal character 
                                                                 | to its 4-bit binary equivalent.
3    | Concatenate the binary representations.                   | Append the binary string to a `StringBuilder` for efficient concatenation.
4    | Return the concatenated binary string.                    | Convert `StringBuilder` to string and return it.

*/

  
/* 
Section-7: Code Requirement to Complete the Subtasks
- A loop to iterate through each hexadecimal character.
- A data structure to store the mapping between hexadecimal digits and their binary equivalents.
- Efficient string concatenation to build the final binary string.
- Return the concatenated binary string as the result.
*/

  
/* 
Section-8: Explanation of Approach
1. Mapping: Use a predefined map or array that maps each hexadecimal character (0-9, A-F) to its corresponding 4-bit binary representation.
2. Iteration: Traverse each character in the input hexadecimal string. For each character, 
              retrieve its binary equivalent from the mapping and append it to the result string.
3. Efficient Concatenation: Using a `StringBuilder` is more efficient for concatenating strings in Java.
4. Return the result: After processing all hexadecimal digits, return the concatenated binary string as the output.

By following these steps, we can ensure that the solution is both efficient and straightforward.
*/

  
import java.util.HashMap;

public class HexToBinary {
    // Function to convert Hexadecimal to Binary
    public static String convertHexToBinary(String hex) {
        // Map of Hexadecimal digits to Binary equivalents
        HashMap<Character, String> hexToBinaryMap = new HashMap<>();
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
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            // Append the corresponding 4-bit binary value for the current hex character
            binaryResult.append(hexToBinaryMap.get(hexChar));
        }

        return binaryResult.toString();
    }

    public static void main(String[] args) {
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
Section-9: Java Code According to Input to Output Conversion Subtasks
The code follows the steps as discussed in the approach.
1. Iterate through the input string `hex`.
2. For each character, convert it to its binary equivalent using a predefined `HashMap`.
3. Append the binary string to a `StringBuilder` for efficient string concatenation.
4. Return the concatenated binary string after processing all characters.

*/

  
/* 
Section-10: Time and Space Complexity Explanation
Time Complexity: 
- The time complexity of the solution is O(n), where `n` is the length of the input hexadecimal string. 
  We iterate over each character once and perform constant-time operations (mapping and appending) for each character.

Space Complexity:
- The space complexity is O(n), as we store the resulting binary string, 
  which can be up to 4 times the length of the input hexadecimal string. 
  The space for the `HashMap` is constant since it only stores mappings for 16 hexadecimal digits.

*/

  
/* 
Section-11: Walkthrough of Loops and Iterations
For example, if the input is:
hex = "1AC5"

- First Iteration (1): The binary equivalent is "0001".
- Second Iteration (A): The binary equivalent is "1010".
- Third Iteration (C): The binary equivalent is "1100".
- Fourth Iteration (5): The binary equivalent is "0101".

The final binary string becomes: "0001101011000101".

*/

  
/* 
Section-12: Complete Code Walkthrough with Example Input
Input: hex = "1AC5"
1. Initialize an empty `StringBuilder`.
2. Iterate through each character in the string:
   - For '1', append "0001" to `StringBuilder`.
   - For 'A', append "1010" to `StringBuilder`.
   - For 'C', append "1100" to `StringBuilder`.
   - For '5', append "0101" to `StringBuilder`.
3. The final result is: "0001101011000101".
4. Return the binary string: "0001101011000101".

*/
