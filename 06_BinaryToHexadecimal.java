/* 
Question:
Given a Binary Number, the task is to convert the given binary number to its equivalent hexadecimal number. 
The input could be very large and may not fit even into an unsigned long long int.

Examples: 

Input: 110001110
Output: 18E

Input: 1111001010010100001.010110110011011
Output: 794A1.5B36 794A1D9B
*/

/* 
Understanding the Problem Statement:
The problem requires us to convert a binary number (which may be very large) into its hexadecimal representation. 
The binary number can be either an integer or a floating-point number.

What is being asked?
We are asked to convert the given binary string into hexadecimal. We need to handle both integer and fractional binary parts, as described in the example.

The binary number is provided as a string, and we need to convert it efficiently into hexadecimal.
*/

/* 
Extracting Information from the Problem Statement:
- Input data type: Binary number provided as a string. 
  The string can be very large and may contain both an integer and a fractional part (represented as '1.0101' or similar).
- Expected Output: The output should be a hexadecimal representation of the binary number.
- Output return data type: String, where the hexadecimal equivalent of the binary number is returned.
- Constraints:
  - The binary number can be very large and should be handled as a string.
  - The number can have a fractional part.
- Time complexity expectations: Efficient conversion of a potentially large binary number into its hexadecimal form is expected. 
  The overall time complexity should depend on the size of the input binary number.
*/

/* 
Thinking Solution for the Problem Statement:
1. The binary number can be split into two parts: the integer part and the fractional part (if any).
2. The conversion from binary to hexadecimal is straightforward:
   - First, group the binary number into chunks of 4 bits from right to left (for integer part).
   - Convert each 4-bit group to its hexadecimal equivalent.
   - Similarly, for the fractional part, group the bits in chunks of 4 from left to right, and convert each group to hexadecimal.
3. For handling large binary numbers, we will work with strings to avoid overflow issues.
4. The conversion is done in two stages:
   - Integer part to hexadecimal.
   - Fractional part to hexadecimal (if present).
5. We need to manage precision for the fractional part and stop the conversion at a reasonable point to avoid precision loss.
*/

/* 
Input to Output conversion steps into smaller subtasks:
S.No | Subtask Description
1    | Split the input binary string into integer and fractional parts.
2    | Convert the integer part from binary to hexadecimal.
3    | Convert the fractional part from binary to hexadecimal.
4    | Concatenate both parts to form the final hexadecimal representation.
5    | Handle the edge cases where the fractional part is missing or the input is empty.
*/

/* 
Input to Output conversion subtasks into Code:
S.No | Subtask Description                                     | Code Approach
1    | Split binary number into integer and fractional parts.  | Split input using '.' to separate the integer and fractional parts.
2    | Convert integer part to hexadecimal.                    | Group the binary integer part in chunks of 4 and convert each to hexadecimal.
3    | Convert fractional part to hexadecimal.                 | Group the binary fractional part in chunks of 4, convert, 
                                                                 and append until no more significant bits.
4    | Concatenate the integer and fractional results.         | Combine the results for the final output.
5    | Handle edge cases.                                      | Handle cases where either part might be empty.
*/

/* 
Code Requirement to complete the subtasks:
- We will use a loop to iterate over the binary string.
- A helper function to convert binary to hexadecimal will be necessary.
- A string data structure will be used to store the final output.
- We will also need some string manipulation for splitting the binary number and handling the fractional part.
*/

/* 
Java Code according to conversational subtasks:
*/
import java.math.BigInteger;

public class BinaryToHexadecimal {
    
    /* 
    Explanation of Approach:
    - First, we will split the input binary number into integer and fractional parts.
    - We will then convert the integer part from binary to hexadecimal.
    - After that, we will convert the fractional part from binary to hexadecimal.
    - If no fractional part exists, we will skip that step.
    - Finally, we will combine both parts and output the result.
    */

    // Helper function to convert binary string to hexadecimal string
    public static String binaryToHex(String binary) {
        // Check if the binary string is empty
        if (binary.isEmpty()) {
            return "0";
        }

        // Use BigInteger to handle very large binary numbers
        BigInteger number = new BigInteger(binary, 2);
        return number.toString(16).toUpperCase(); // Convert to hexadecimal and convert to uppercase
    }

    // Function to convert binary number (with fractional part) to hexadecimal
    public static String convertBinaryToHexadecimal(String binary) {
        // Split the input binary number into integer and fractional parts
        String[] parts = binary.split("\\.");
        String integerPart = parts[0];
        String fractionalPart = (parts.length > 1) ? parts[1] : "";

        // Convert integer part to hexadecimal
        String hexInteger = binaryToHex(integerPart);

        // Convert fractional part to hexadecimal (if it exists)
        String hexFractional = "";
        if (!fractionalPart.isEmpty()) {
            // Loop to process the fractional part in chunks of 4 binary digits
            StringBuilder sb = new StringBuilder();
            while (!fractionalPart.isEmpty()) {
                // Take the first 4 digits from fractional part
                if (fractionalPart.length() >= 4) {
                    sb.append(binaryToHex(fractionalPart.substring(0, 4)));
                    fractionalPart = fractionalPart.substring(4); // Remove processed part
                } else {
                    // For remaining bits that are less than 4
                    sb.append(binaryToHex(fractionalPart));
                    break;
                }
            }
            hexFractional = sb.toString();
        }

        // If the fractional part exists, concatenate integer and fractional parts with a dot
        if (!hexFractional.isEmpty()) {
            return hexInteger + "." + hexFractional;
        }

        return hexInteger; // Return integer part only if no fractional part
    }

    // Main function to test the code
    public static void main(String[] args) {
        String binaryInput1 = "110001110";
        String binaryInput2 = "1111001010010100001.010110110011011";
        
        System.out.println("Binary: " + binaryInput1 + " => Hexadecimal: " + convertBinaryToHexadecimal(binaryInput1));
        System.out.println("Binary: " + binaryInput2 + " => Hexadecimal: " + convertBinaryToHexadecimal(binaryInput2));
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Splitting the binary string: O(n), where n is the length of the binary string.
  - Converting the integer part using BigInteger: O(n).
  - Converting the fractional part involves splitting into chunks and processing each chunk, leading to O(m) time, where m is the length of the fractional part.
  - Overall time complexity: O(n + m), where n is the integer part's length and m is the fractional part's length.

- Space Complexity:
  - We store the result of the conversion, which takes O(n + m) space.
  - Overall space complexity: O(n + m), where n is the integer part's length and m is the fractional part's length.
*/

/* 
Explanation of "for" and "while" loops used in the code:
- In the code, a loop is used to handle the fractional part. We take the first 4 digits of the fractional part and convert them. 
  The loop continues until there are no more bits left in the fractional part.
  - For example, if the input is "1111001010010100001.010110110011011", 
    the loop processes the fractional part in chunks of 4 digits, converting each chunk into its hexadecimal equivalent.

Iterations for the example "1111001010010100001.010110110011011":
- First iteration: Takes "0101", converts to "5".
- Second iteration: Takes "1011", converts to "B".
- Third iteration: Takes "0110", converts to "6".
- Final result for the fractional part: ".5B36".
*/

/* 
Complete code walkthrough with applying the given input:
- The input binary "110001110" is split into the integer part "110001110" and no fractional part. It is then converted to hexadecimal as "18E".
- The input binary "1111001010010100001.010110110011011" is split into integer part "1111001010010100001" and fractional part "010110110011011". 
  The integer part is converted to hexadecimal as "794A1", and the fractional part is converted to "5B36", giving the final result "794A1.5B36".
*/
