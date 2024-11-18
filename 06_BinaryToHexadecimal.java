/* 
Question: Given a Binary Number, the task is to convert the given binary number to its equivalent hexadecimal number. 
The input could be very large and may not fit even into an unsigned long long int.

Input: 110001110
Output: 18E

Input: 1111001010010100001.010110110011011
Output: 794A1.5B36 794A1D9B.
*/

/* 
Input-output explanation:
For the binary input '110001110', the hexadecimal output is '18E'. 
In the second example, the input '1111001010010100001.010110110011011' gives the output '794A1.5B36' and '794A1D9B'.
The conversion involves translating groups of four binary digits into a single hexadecimal digit.
*/

/* 
Constraints explanation:
- The binary input can be very large, potentially exceeding typical integer limits.
- The input may also contain a fractional part, denoted by a '.'.
- We need to handle both integral and fractional parts separately.
*/

/* 
Relatable analogy or real-world scenario: "The Library Catalog: Grouping Binary Books into Hex Codes"
Imagine you are a librarian converting a long list of book titles (binary digits) into a more manageable format (hexadecimal). 
Each book title can be represented by a group of four letters (binary digits). 
You take each group of four letters and assign it a unique code (hexadecimal digit). 
If you have a decimal point, it separates two sections of titles (integral and fractional parts) that you treat separately.
*/

/* 
Relatable analogy Java code step by step:
1. Start with reading the binary input.
2. Split the input into integral and fractional parts if there's a '.'.
3. For each part, process the digits in chunks of four (like grouping titles).
4. Convert each group of four binary digits to its hexadecimal equivalent.
5. Combine the results back, adding the decimal point if needed.
*/

import java.util.HashMap;

public class BinaryToHexadecimal {

    // Step 1: Create a mapping from binary strings to hexadecimal characters
    private static final HashMap<String, Character> binaryToHexMap = new HashMap<>();
    
    static {
        binaryToHexMap.put("0000", '0');
        binaryToHexMap.put("0001", '1');
        binaryToHexMap.put("0010", '2');
        binaryToHexMap.put("0011", '3');
        binaryToHexMap.put("0100", '4');
        binaryToHexMap.put("0101", '5');
        binaryToHexMap.put("0110", '6');
        binaryToHexMap.put("0111", '7');
        binaryToHexMap.put("1000", '8');
        binaryToHexMap.put("1001", '9');
        binaryToHexMap.put("1010", 'A');
        binaryToHexMap.put("1011", 'B');
        binaryToHexMap.put("1100", 'C');
        binaryToHexMap.put("1101", 'D');
        binaryToHexMap.put("1110", 'E');
        binaryToHexMap.put("1111", 'F');
        
        /*
        In Java, the `static` keyword has specific meanings depending on where it is applied. 
        When used in a static block, it indicates that the block belongs to the class itself
        rather than any particular instance of the class.
        Here’s why using `static` is beneficial in this context:
        
        ### Reasons for Using `static`
        
        1. **Class-Level Initialization**: 
           - The static block runs when the class is loaded, 
           which means that the `binaryToHexMap` is initialized only once, 
           regardless of how many instances of the class are created. 
           This is efficient because it avoids repeated initialization.
        
        2. **Shared Resource**: 
           - Since `binaryToHexMap` is static, 
           it is shared across all instances of the class. 
           This is suitable for resources that don’t need to be unique to each instance,
           such as a mapping of binary strings to hexadecimal values.
        
        3. **Performance**: 
           - Initializing the map once and reusing it for all method calls improves performance.
           If the map were initialized in a method,
           it would incur overhead each time the method is called.
        
        4. **Accessibility**: 
           - Static members can be accessed without needing to create an instance of the class.
           This is particularly useful if the map is used in static methods,
           allowing for straightforward access.
        
        ### Example Scenario
        Suppose you are creating a large application that frequently converts binary to hexadecimal.
        By using a static map, you ensure that the mapping is set up only once at the start, 
        which saves time and resources compared to recreating the map every time a conversion is needed.
        
        ### Summary
        In summary, using `static` for the initialization block and the `binaryToHexMap` enhances efficiency,
        ensures shared access, and simplifies the design of the class. 
        */
    }

    public static void main(String[] args) {
        String binaryInput = "1111001010010100001.010110110011011";
        String result = convertBinaryToHexadecimal(binaryInput);
        System.out.println(result);
    }

    // Step 2: Convert the binary string to hexadecimal
    public static String convertBinaryToHexadecimal(String binary) {
        StringBuilder hexResult = new StringBuilder();
        
        // Step 3: Split the binary string into integral and fractional parts
        String[] parts = binary.split("\\.");
        String integralPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";
        /* 
    
        The line of code you provided is used to handle the fractional part of a binary number when converting it to hexadecimal. 
        Let's break it down step by step:

        ### Explanation of the Code

        String fractionalPart = parts.length > 1 ? parts[1] : "";
        
        1. **Splitting the Input**:
           - Prior to this line, the binary input string is split using the `split("\\.")` method,
             which separates the integral and fractional parts based on the decimal point (`.`).
             This results in an array called `parts`.
        
        2. **Array Length Check**:
           - The `parts.length > 1` check determines if there is a fractional part present. 
           - If the input string contains a decimal point,
            `parts` will have at least two elements: `parts[0]` will be the integral part, and `parts[1]` will be the fractional part.
        
        3. **Ternary Operator**:
           - The line uses the ternary operator `? :` to assign a value to `fractionalPart`.
           - If `parts.length` is greater than 1, it means there is a fractional part, and `parts[1]` is assigned to `fractionalPart`.
           - If there is no fractional part (i.e., `parts.length` is 1), an empty string `""` is assigned to `fractionalPart`.
        
        ### Purpose of This Line
        
        - **Robust Handling**: This line ensures that the code can handle both cases: binary inputs with and without a fractional part.
        - **Prevention of Null Pointer Exceptions**: By checking the length of the `parts` array, 
            the code avoids potential errors when trying to access an index that doesn’t exist.
        
        ### Example Scenarios
        
        1. **With Fractional Part**:
           - Input: `111100101.0101`
           - After splitting: `parts[0]` = `111100101`, `parts[1]` = `0101`
           - Result: `fractionalPart` = `0101`
        
        2. **Without Fractional Part**:
           - Input: `111100101`
           - After splitting: `parts[0]` = `111100101`, `parts.length` = 1
           - Result: `fractionalPart` = `""`

        */

        // Step 4: Process the integral part
        hexResult.append(processBinaryPart(integralPart));

        // Step 5: Process the fractional part if exists
        if (!fractionalPart.isEmpty()) {
            hexResult.append(".");
            hexResult.append(processBinaryPart(fractionalPart));
        }

        return hexResult.toString();
    }

    // Helper method to convert binary part to hexadecimal
    private static String processBinaryPart(String binaryPart) {
        StringBuilder hexPart = new StringBuilder();
        
        // Padding the binary string to make its length a multiple of 4
        int paddingLength = (4 - (binaryPart.length() % 4)) % 4;
        binaryPart = "0".repeat(paddingLength) + binaryPart;

        // Step 6: Convert each group of 4 binary digits
        for (int i = 0; i < binaryPart.length(); i += 4) {
            String binaryChunk = binaryPart.substring(i, i + 4);
            hexPart.append(binaryToHexMap.get(binaryChunk));
        }

        return hexPart.toString();
    }
}

        /* 
        Time and Space Complexity Explanation:
        - Time Complexity: O(n), where n is the number of bits in the binary input. 
        We iterate over the binary input and process each 4-bit group once.
        - Space Complexity: O(1) for the hex map, but O(m) for the resulting hexadecimal string where m is its length.
        */
        
        /* 
        FOR loop walkthrough with every iteration with given input:
        For the input "1111001010010100001", the loop processes as follows:
        - After padding: "00001111001010010100001"
        - 1st iteration (i=0): takes "0000" → '0'
        - 2nd iteration (i=4): takes "1111" → 'F'
        - 3rd iteration (i=8): takes "0010" → '2'
        - 4th iteration (i=12): takes "1001" → '9'
        - 5th iteration (i=16): takes "0100" → '4'
        - 6th iteration (i=20): takes "0001" → '1'
        - Final integral hex: "F29" → appending '.' and continuing to process the fractional part.
        */
        
        /* 
        Complete code walkthrough with applying the given input in code:
        - We define a map for binary to hexadecimal conversion.
        - We split the input into integral and fractional parts.
        - We pad the integral part to make its length a multiple of 4, then process each chunk to convert to hex.
        - We do the same for the fractional part if it exists.
        - Finally, we print the resulting hexadecimal string.
        */
