
    /* 
    * Section - 1: Question section
        Given a Binary Number, the task is to convert the given binary number to its equivalent hexadecimal number. 
        The input could be very large and may not fit even into an unsigned long long int.
  
        Examples: 
        Input: 110001110
        Output: 18E
        
        Input: 1111001010010100001.010110110011011
        Output: 794A1.5B36 794A1D9B

    */

    /* 
    * Section - 2: Understanding the Problem Statement
    * The task is to convert a binary number (which may be very large) into its equivalent hexadecimal number.
            An unsigned long long int is a data type with a range of values from 0 to 18,446,744,073,709,551,615 and takes up 8 bytes. 
            The maximum value for an unsigned long long int variable is ULLONG_MAX, which is 18,446,744,073,709,551,615.
    * We need to handle both integer and fractional parts of the binary number.
    */

    /* 
    * Section - 3: Extracting Information from the Problem Statement
    * Input: Binary number in string format.
    * Output: Equivalent hexadecimal number in string format.
    * The problem allows very large binary numbers, which require efficient handling using strings.
    * no contraints given 
    * no time complexity is mentioned
    */

    /* 
    * Section - 4: Thinking Solution for the Problem Statement
    * The basic idea is to group the binary digits into sets of four (starting from the right) and convert each group into its hexadecimal equivalent.
    * If the length of the binary string is not a multiple of four, pad it with leading zeros.
    * If the number has a fractional part, process the integer and fractional parts separately.
    */

    /* 
    * Section - 5: Input to Output conversion steps into smaller subtasks
    * 1. Pad the binary number with leading zeros if necessary.
    * 2. Split the binary number into 4-bit chunks.
    * 3. Convert each 4-bit chunk into its hexadecimal equivalent.
    * 4. If there is a fractional part, do the same with the fractional part.
    * 5. Combine the integer and fractional hexadecimal parts and return the result.
    */

    /* 
    * Section - 6: Input to Output conversion subtasks into Code
    * - Create a method to handle the conversion of binary to hexadecimal.
    * - Use a `HashMap` to map 4-bit binary values to their hexadecimal equivalents.
    * - Handle the integer part and fractional part separately.
    */

    /* 
    * Section - 7: Code Requirement to complete the subtasks
    * - A loop is required to process each group of 4 bits in the binary number.
    * - A HashMap to store binary-to-hexadecimal mappings.
    * - StringBuilder to efficiently build the final result string.
    */

    /* 
    * Section - 8: Explanation of Approach
    * We will first handle the integer part by grouping the binary digits in sets of four. Then, we will convert each set into a corresponding hexadecimal digit.
    * For the fractional part, we'll repeat the same approach but handle the digits after the binary point.
    * Finally, combine the results for the integer and fractional parts, if present.
    */

/* Section - 9: Java Code according to Input to Output conversion subtasks */

import java.util.HashMap;
public class BinaryToHex
{
    // Function to convert Binary to Hexadecimal
    public static String convertBinaryToHex(String binary)
    {
        // Split binary into integer and fractional parts
        String[] parts = binary.split("\\.");
        String integerPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";

        // Convert the integer part
        String hexIntegerPart = convertIntegerBinaryToHex(integerPart);

        // Convert the fractional part (if any)
        String hexFractionalPart = fractionalPart.isEmpty() ? "" : convertFractionalBinaryToHex(fractionalPart);

        // Combine the integer and fractional parts
        return hexIntegerPart + (hexFractionalPart.isEmpty() ? "" : "." + hexFractionalPart);
    }

    // Helper function to convert the integer part of the binary to hexadecimal
    private static String convertIntegerBinaryToHex(String binary)
    {
        // Pad the binary number to make its length a multiple of 4
        int paddingLength = (4 - binary.length() % 4) % 4;
        binary = "0".repeat(paddingLength) + binary;

        // Convert binary to hexadecimal
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 4)
        {
            String group = binary.substring(i, i + 4);
            hex.append(binaryToHexMap(group));
        }

        return hex.toString();
    }

    // Helper function to convert the fractional part of the binary to hexadecimal
    private static String convertFractionalBinaryToHex(String binary)
    {
        StringBuilder hex = new StringBuilder();
        while (binary.length() > 0)
        {
            // Group binary into sets of 4 bits
            int endIndex = Math.min(binary.length(), 4);
            String group = binary.substring(0, endIndex);
            hex.append(binaryToHexMap(group));
            binary = binary.substring(endIndex);
        }
        return hex.toString();
    }

    // Helper method to map 4-bit binary string to hexadecimal
    private static String binaryToHexMap(String binary)
    {
        HashMap < String, String > map = new HashMap < > ();
        map.put("0000", "0");
        map.put("0001", "1");
        map.put("0010", "2");
        map.put("0011", "3");
        map.put("0100", "4");
        map.put("0101", "5");
        map.put("0110", "6");
        map.put("0111", "7");
        map.put("1000", "8");
        map.put("1001", "9");
        map.put("1010", "A");
        map.put("1011", "B");
        map.put("1100", "C");
        map.put("1101", "D");
        map.put("1110", "E");
        map.put("1111", "F");

        return map.get(binary);
    }

    public static void main(String[] args)
    {
        // Test cases
        String binary1 = "110001110";
        String binary2 = "1111001010010100001.010110110011011";

        // Output the result for both test cases
        System.out.println("For Binary: " + binary1);
        System.out.println("Hexadecimal: " + convertBinaryToHex(binary1));

        System.out.println("\nFor Binary: " + binary2);
        System.out.println("Hexadecimal: " + convertBinaryToHex(binary2));
    }
}

 

/* 
* Section - 10: Time and Space Complexity Explanation
* Time Complexity: O(n), where n is the length of the binary string (integer part and fractional part combined). 
  We iterate over the binary string in chunks of 4 bits.
* Space Complexity: O(n), due to the storage used for the binary string and its corresponding hexadecimal result.
*/

/* 
* Section - 11: Loop walkthrough
* - Integer Part: The loop in `convertIntegerBinaryToHex` iterates over the binary string in steps of 4, performing the conversion for each group.
* - Fractional Part: The loop in `convertFractionalBinaryToHex` handles the fractional part in a similar way.
*/

/* 
* Section - 12: Complete code walkthrough
* Example 1: "110001110" -> The padded binary is "0001110001110" -> This is divided into chunks: "0001", "1100", "0111", "0001" -> Hexadecimal: "18E".
* Example 2: "1111001010010100001.010110110011011" -> Integer part "1111001010010100001" is divided into: "1111", "0010", "1001", "0100", "001" (padded) 
              -> Hexadecimal: "794A1". Fractional part is also processed similarly.
*/

}


/*
Key Points:
- Binary Padding: To ensure that the binary string has a length that is a multiple of 4, we add leading zeros as necessary.
- Mapping Binary to Hexadecimal: A `HashMap` is used to map every possible 4-bit binary group (from `0000` to `1111`) to its corresponding hexadecimal digit.
- Handling Integer and Fractional Parts: The binary number is split into integer and fractional parts. Each part is processed separately.
  
Time and Space Complexity:
- Time Complexity: O(n), where n is the length of the binary string. This is because we process the string in chunks of 4 bits and each chunk is converted in constant time.
- Space Complexity: O(n) for storing the binary input and its corresponding hexadecimal output.

The approach is efficient enough to handle very large binary numbers (including fractional parts), and the use of `StringBuilder` ensures optimal string concatenation.
*/

