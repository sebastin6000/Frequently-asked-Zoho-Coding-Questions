
/* 
Question Section: 
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
Understanding the Problem Statement:
The task requires converting a hexadecimal number to its binary equivalent. 
A hexadecimal number is a base-16 number, and binary is a base-2 number. Every hex digit corresponds to exactly four binary digits (bits). 
For example, in the given input `1AC5`, the hexadecimal digits `1`, `A`, `C`, and `5` need to be converted to their 4-bit binary representation.
The goal is to output the binary number as a string of bits.
*/

/*
Extracting Information from the Problem Statement:
1. Input data type or data structure:
    - The input is a string representing a hexadecimal number (e.g., "1AC5").
    
2. Expected Output:
    - The output should be a string that represents the binary equivalent of the hexadecimal input.

3. Output return data type:
    - The output is a string, specifically the binary representation of the hexadecimal number.

4. Constraints in the problem statement:
    - The hexadecimal input can contain upper-case letters (A-F) and digits (0-9).
    
5. Time complexity expectations:
    - The problem does not specify any strict time complexity expectations, but we assume we need to optimize the solution for large input sizes.
    - Given that the number of hexadecimal digits is typically smaller than binary digits, the complexity should be proportional to the length of the input string.

*/

/*
Thinking Solution for the Problem Statement:
To convert the hexadecimal number to binary:
1. We need to process each hexadecimal digit individually.
2. Every hexadecimal digit corresponds to a 4-bit binary representation.
3. We can use a predefined mapping of hexadecimal characters ('0' to 'F') to their 4-bit binary values.
4. We need to append each 4-bit binary representation to form the final result.
5. Leading zeros must be included to ensure each hexadecimal digit is represented as exactly 4 bits.
*/

/*
Input to Output Conversion Steps into Smaller Subtasks:
S. No. | Task                                                                 | Explanation
-------|----------------------------------------------------------------------|-----------------------------------------------------------
1      | Convert each Hexadecimal digit to its binary equivalent.             | Hexadecimal '1' -> '0001', 'A' -> '1010', 'C' -> '1100', etc.
2      | Concatenate the binary values into a final binary string.            | After converting each digit, we join them together.
3      | Handle leading zeros by ensuring each hex digit is                   |
       |  represented by exactly 4 bits. | For example, 'A' should be '1010', |
       |  not just 'A' without leading zeros.                                 |
-------|----------------------------------------------------------------------|-------------------------------------------------------------
*/

/*
Input to Output Conversion Subtasks into Code:
1. Convert each Hexadecimal digit to binary using a predefined map or manual conversion.
2. Append the binary strings to a result string.
3. Print the final binary string as the output.
*/

/*
Code Requirement to Complete the Subtasks:

1. Need a Loop: 
    - Yes, we need a loop to iterate through each character in the input hexadecimal string. 
      Each character needs to be processed individually to obtain its binary equivalent.

2. Need a Data Structure: 
    - We will use an array (or list) to store the binary representations of hexadecimal digits.
    - Specifically, a `String[]` can be used to store the predefined binary values for each hexadecimal digit (0-9, A-F). 
    - A `StringBuilder` will be used to accumulate the binary result as we loop through the hexadecimal digits.

3. Need an If Condition:
    - Yes, we need conditional checks to determine whether a given character is a digit ('0' to '9') or a letter ('A' to 'F'). 
    - If the character is a digit, we can directly map it to its binary equivalent. 
      If the character is a letter, we need to map it to its corresponding binary value based on the hexadecimal mapping (A -> 10, B -> 11, ..., F -> 15).

4. Binary Mapping:
    - We need to manually map each hexadecimal digit (0-9, A-F) to its 4-bit binary string. 
      This can be done using an array where the index corresponds to the integer value of the hexadecimal character.

5. Concatenation of Binary Values:
    - After converting each hexadecimal digit into its binary form, we will append the binary value to a result string. 
    - A `StringBuilder` is ideal for this task since it allows efficient string concatenation.

6. Efficiency Considerations:
    - We are processing each character of the input once, 
      so the algorithm is efficient with a time complexity of O(n), where `n` is the length of the hexadecimal input string.
    - Since each hexadecimal character maps directly to a fixed-length binary string (4 bits), there are no additional complexities in terms of space.

In summary, the required components are:
- A loop to process each character of the hexadecimal input.
- A data structure (array or list) to store the binary representations.
- Conditional checks (if statements) to handle both digits and letters in the hexadecimal string.
- A `StringBuilder` to efficiently accumulate the final binary result.
*/

public class HexToBinary {
    
    // Method to convert Hexadecimal to Binary
    public static String hexToBinary(String hex) {
        // Step 1: Create a map for Hex to Binary conversion
        String[] hexToBinaryMap = {
            "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", 
            "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
        };
        
        StringBuilder binaryResult = new StringBuilder();

        // Step 2: Loop through each character in the hexadecimal string
        for (int i = 0; i < hex.length(); i++) {
            // Convert the hex character to an index (0-15)
            char hexChar = hex.charAt(i);
            int index;
            if (Character.isDigit(hexChar)) {
                index = hexChar - '0'; // Convert digit to integer (e.g., '5' -> 5)
            } else {
                index = hexChar - 'A' + 10; // Convert letter A-F to integer (e.g., 'A' -> 10)
            }
            
            // Append the corresponding 4-bit binary string to the result
            binaryResult.append(hexToBinaryMap[index]);
        }
        
        // Step 3: Return the final binary string
        return binaryResult.toString();
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Test case 1
        String hex1 = "1AC5";
        String binary1 = hexToBinary(hex1);
        System.out.println("Hexadecimal: " + hex1 + " -> Binary: " + binary1);
        
        // Test case 2
        String hex2 = "5D1F";
        String binary2 = hexToBinary(hex2);
        System.out.println("Hexadecimal: " + hex2 + " -> Binary: " + binary2);
    }
}

/*
Time and Space Complexity Explanation:
Time Complexity:
- The time complexity of the algorithm is O(n), where n is the length of the hexadecimal input string.
- This is because we loop through each character of the hexadecimal string, which is a constant-time operation.

Space Complexity:
- The space complexity is also O(n), as we use a StringBuilder to store the binary result, which grows linearly with the number of hexadecimal digits.

*/

/*
For Loop Walkthrough:

For the first test case (hexadecimal input = "1AC5"):
- The loop will iterate over each character in the string.
1st Iteration: 
- Character = '1', corresponding binary = "0001"
2nd Iteration: 
- Character = 'A', corresponding binary = "1010"
3rd Iteration: 
- Character = 'C', corresponding binary = "1100"
4th Iteration: 
- Character = '5', corresponding binary = "0101"

Final binary string = "0001101011000101"

*/

/*
Complete Code Walkthrough with Explanation:

For the input hexadecimal string "1AC5", the process works as follows:

1. The input is "1AC5".
2. The method `hexToBinary()` is called with this input string.
3. The method initializes a map of hexadecimal digits to their binary equivalents.
4. The method loops through each character of the input string:
   - '1' is converted to "0001"
   - 'A' is converted to "1010"
   - 'C' is converted to "1100"
   - '5' is converted to "0101"
5. The binary strings are appended together to form the final result: "0001101011000101".
6. The output is printed: "Hexadecimal: 1AC5 -> Binary: 0001101011000101".

*/
