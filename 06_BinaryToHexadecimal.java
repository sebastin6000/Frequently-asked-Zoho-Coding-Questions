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
// Code without Explanation

import java.util.HashMap;

public class BinaryToHexadecimal
{
    private static final HashMap < String, Character > binaryToHexMap = new HashMap < > ();

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
    }

    public static String convertBinaryToHexadecimal(String binary) {
        StringBuilder hexResult = new StringBuilder();

        String[] parts = binary.split("\\.");
        String integralPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";

        hexResult.append(processBinaryPart(integralPart));

        if (!fractionalPart.isEmpty()) {
            hexResult.append(".");
            hexResult.append(processBinaryPart(fractionalPart));
        }

        return hexResult.toString();
    }

    private static String processBinaryPart(String binaryPart) {
        StringBuilder hexPart = new StringBuilder();


        int paddingLength = (4 - (binaryPart.length() % 4)) % 4;
        binaryPart = "0".repeat(paddingLength) + binaryPart;


        for (int i = 0; i < binaryPart.length(); i += 4) {
            String binaryChunk = binaryPart.substring(i, i + 4);
            hexPart.append(binaryToHexMap.get(binaryChunk));
        }

        return hexPart.toString();
    }

    public static void main(String[] args) {
        String binaryInput = "1111001010010100001.010110110011011";
        String result = convertBinaryToHexadecimal(binaryInput);
        System.out.println(result);
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------
// Code with Explanation
    
import java.util.HashMap;

public class BinaryToHexadecimal {

    // Step 1: Create a mapping from binary strings to hexadecimal characters
    private static final HashMap<String, Character> binaryToHexMap = new HashMap<>();
    /* 
    The line: private static final HashMap<String, Character> binaryToHexMap = new HashMap<>();
    declares and initializes a `HashMap` in Java that is used to map 4-bit binary strings 
    (e.g., `"0000"`, `"0001"`, `"1111"`) to their corresponding hexadecimal characters (e.g., `'0'`, `'1'`, `'F'`).

 1. `private` Access Modifier
   - The `private` keyword means that this `HashMap` can only be accessed from within the `BinaryToHexadecimal` class.
   - It cannot be accessed or modified from other classes, 
      which is typical for utility structures that don't need to be exposed outside of their class.

 2. `static` Keyword
   - The `static` keyword means that the `HashMap` is shared among all instances of the `BinaryToHexadecimal` class, 
      rather than being specific to any one instance.
   - Since the `HashMap` is used as a constant and initialized once, it makes sense to declare it as `static`.

 3. `final` Keyword
   - The `final` keyword means that once this `HashMap` is assigned a value (in this case, 
      initialized with key-value pairs), it cannot be reassigned to point to a different `HashMap` object.
   - However, the contents of the `HashMap` (the mappings) can still be modified
       (like adding or removing key-value pairs), but the reference to the `HashMap` itself is fixed.

 4. `HashMap<String, Character>`
   - `HashMap`: A `HashMap` is a data structure in Java that stores key-value pairs. It allows you to efficiently look up values by their keys.
   - `String`: This is the type of the key in the map. In this case, each key is a 4-bit binary string (e.g., `"0000"`, `"0010"`, `"1111"`).
   - `Character`: This is the type of the value in the map.
      In this case, each value is a hexadecimal character corresponding to the 4-bit binary string (e.g., `'0'`, `'A'`, `'F'`).

 5. Initialization with `new HashMap<>()`
   - This creates a new, empty `HashMap` that will hold key-value pairs where:
     - The key is a binary string of 4 characters (e.g., `"0000"`).
     - The value is a hexadecimal character (e.g., `'0'`, `'A'`).
   - The `<>` (diamond operator) infers the types from the declaration, so you don’t need to repeat `String` and `Character` on the right-hand side.

 Usage of `binaryToHexMap`
 The `binaryToHexMap` is used to convert binary strings to hexadecimal characters by associating 4-bit binary strings with their corresponding hexadecimal digits.

For example, the map might contain entries like:

- `"0000"` maps to `'0'`
- `"0001"` maps to `'1'`
- `"1010"` maps to `'A'`
- `"1111"` maps to `'F'`

When you process a 4-bit segment of a binary number, you can quickly look up its hexadecimal equivalent by querying this map.

Example of Populating the `HashMap`

In your code, the `binaryToHexMap` is populated inside a `static` block, 
which is a special block that runs once when the class is loaded. Here’s an example of what that looks like:


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
}
How the `binaryToHexMap` is Used
The `binaryToHexMap` is used inside your method `processBinaryPart(String binaryPart)` 
to convert 4-bit chunks of the binary string into their hexadecimal equivalents:

1. First, the binary string is padded (if necessary) so its length is a multiple of 4.
2. Then, the string is processed in chunks of 4 bits.
3. For each chunk, the program looks up the corresponding hexadecimal character from the `binaryToHexMap`.

For example:
- If the 4-bit binary chunk is `"1010"`, the map lookup would be `binaryToHexMap.get("1010")`, which returns `'A'`.

 Summary:
- `binaryToHexMap` is a `HashMap` used to map 4-bit binary strings to their corresponding hexadecimal characters.
- This map is initialized  once using a `static` block when the class is loaded.
- The `binaryToHexMap` is then used to look up the hexadecimal equivalent of each 4-bit chunk of the binary string during the conversion process.

    */
    
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
        // using Tenory operator "condition ? value_if_true : value_if_false;"
        // Explaination : 
        //    if parts.length is greater than 1 means, fractionalPart will be parts array index 1 element
        //       parts.length is lesser than 1 means, "" this will the value in fractionalPart
        String fractionalPart = parts.length > 1 ? parts[1] : "";
        /* 
    
        The line of code you provided is used to handle the fractional part of a binary number
        when converting it to hexadecimal. 
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
            `parts` will have at least two elements: `parts[0]` will be the integral part, 
            and `parts[1]` will be the fractional part.
        
        3. **Ternary Operator**:
           - The line uses the ternary operator `? :` to assign a value to `fractionalPart`.
           - If `parts.length` is greater than 1, it means there is a fractional part,
           and `parts[1]` is assigned to `fractionalPart`.
           - If there is no fractional part (i.e., `parts.length` is 1),
           an empty string `""` is assigned to `fractionalPart`.
        
        ### Purpose of This Line
        
        - **Robust Handling**: This line ensures that the code can handle both cases: 
            binary inputs with and without a fractional part.
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
        /* 
        The lines:
        int paddingLength = (4 - (binaryPart.length() % 4)) % 4;
        binaryPart = "0".repeat(paddingLength) + binaryPart;
      
        are used to pad the binary string (`binaryPart`) to make its length a multiple of 4. 
        This is necessary because each hexadecimal digit corresponds to exactly 4 binary digits (bits).
        If the length of the binary part is not a multiple of 4,
        padding with zeros ensures that it can be split into 4-bit chunks for conversion to hexadecimal.
      
        Let me explain each part in detail:
      
           1. `binaryPart.length() % 4`: 
             - This expression calculates the remainder when the length of the binary string (`binaryPart.length()`) is divided by 4. 
             - For example, if `binaryPart` has a length of 7, `binaryPart.length() % 4` would be `7 % 4 = 3`.
          
           2. `(4 - (binaryPart.length() % 4)) % 4`: 
             - This part calculates how many zeros need to be added to the front of the binary string to make its length a multiple of 4.
             - The formula works like this:
               - If the remainder is 0 (`binaryPart.length() % 4 == 0`), it means the length is already a multiple of 4, so no padding is needed, and `paddingLength` will be `0`.
               - If the remainder is 1, 2, or 3, this formula calculates how many zeros need to be added to make the total length divisible by 4.
             
             For example:
             - If `binaryPart.length() % 4 = 3` (i.e., the length is 7), the formula calculates `4 - 3 = 1`, so 1 zero will be added to make the total length 8.
             - If `binaryPart.length() % 4 = 2` (i.e., the length is 6), the formula calculates `4 - 2 = 2`, so 2 zeros will be added to make the total length 8.
             - If `binaryPart.length() % 4 = 1` (i.e., the length is 5), the formula calculates `4 - 1 = 3`, so 3 zeros will be added to make the total length 8.
             - If `binaryPart.length() % 4 = 0` (i.e., the length is already a multiple of 4), the formula calculates `4 - 0 = 0`, so no zeros are added.
          
           3. `binaryPart = "0".repeat(paddingLength) + binaryPart;`:
             - This line creates a string of zeros of length `paddingLength` (calculated in the previous step) and prepends it to the `binaryPart`.
             - The `"0".repeat(paddingLength)` method creates a string consisting of `paddingLength` zeros.
               This string is then concatenated with the original `binaryPart`, ensuring that the binary string now has a length that is a multiple of 4.
             
             For example:
             - If `paddingLength = 2` and `binaryPart = "1101"`, it will result in `"001101"`.
             - If `paddingLength = 0` and `binaryPart = "1101"`, it will remain `"1101"`.
             
          Let’s go through a concrete example to see how this works:
          
           Example 1: `binaryPart = "1101"` (already a multiple of 4)
             - `binaryPart.length() = 4`
             - `binaryPart.length() % 4 = 0`
             - `paddingLength = (4 - 0) % 4 = 0`
             - No padding is needed. The final `binaryPart` remains `"1101"`.
          
           Example 2: `binaryPart = "110"` (length = 3, not a multiple of 4)
             - `binaryPart.length() = 3`
             - `binaryPart.length() % 4 = 3`
             - `paddingLength = (4 - 3) % 4 = 1`
             - `"0".repeat(1)` results in `"0"`.
             - Prepending `"0"` to `"110"` results in `"0110"`. Now the length is 4, which is divisible by 4.
          
           Example 3: `binaryPart = "101"` (length = 3, not a multiple of 4)
             - `binaryPart.length() = 3`
             - `binaryPart.length() % 4 = 3`
             - `paddingLength = (4 - 3) % 4 = 1`
             - `"0".repeat(1)` results in `"0"`.
             - Prepending `"0"` to `"101"` results in `"0101"`. Now the length is 4.
          
           Why Do We Need This Padding?
          
          Hexadecimal (base 16) uses 4 bits to represent each digit:
          - 1 hex digit = 4 bits (binary digits).
          - If the binary string isn’t a multiple of 4, 
            we need to pad it with zeros at the front to ensure that the final string can be divided into 4-bit chunks.
          
          For example:
          - Binary `101` (length 3) becomes `0101` (length 4), so it can be correctly mapped to hexadecimal.
          - Binary `111` (length 3) becomes `0111` (length 4), which can then be converted to hexadecimal.
          
          Without padding, the binary string would be incomplete when mapped to hexadecimal, resulting in incorrect conversions.
          
           Summary:
          The code:
          int paddingLength = (4 - (binaryPart.length() % 4)) % 4;
          binaryPart = "0".repeat(paddingLength) + binaryPart;
          
          1. Calculates how many zeros are needed to pad the binary string to a multiple of 4 bits.
          2. Prepares the string by prepending the necessary number of zeros to the original `binaryPart`.
          3. Ensures that the binary string can be split into groups of 4 bits, 
              each of which will then be converted to a hexadecimal digit.
          
          This is crucial for correctly converting binary numbers to hexadecimal, 
           especially for cases where the binary string is not already a multiple of 4 in length.         
        */

        // Step 6: Convert each group of 4 binary digits
        for (int i = 0; i < binaryPart.length(); i += 4) {
            String binaryChunk = binaryPart.substring(i, i + 4);
            hexPart.append(binaryToHexMap.get(binaryChunk));
        }
        /*
        The code snippet you've posted:

        for (int i = 0; i < binaryPart.length(); i += 4) {
            String binaryChunk = binaryPart.substring(i, i + 4);
            hexPart.append(binaryToHexMap.get(binaryChunk));
        }
        
        is part of the method that converts binary strings into hexadecimal. 
        This loop processes the binary string (`binaryPart`) in 4-bit chunks and uses the `binaryToHexMap` to look up each chunk's corresponding hexadecimal value.
        
         Let’s break it down:
        1. The `for` loop:
             for (int i = 0; i < binaryPart.length(); i += 4)
             - This loop iterates over the `binaryPart` string.
             - `i += 4` ensures that the loop moves by 4 positions in each iteration, effectively processing each 4-bit chunk of the binary string.
             - The condition `i < binaryPart.length()` ensures that the loop runs until all the binary digits are processed.
        
         2. Extracting a 4-bit chunk:
             String binaryChunk = binaryPart.substring(i, i + 4);
        - `binaryPart.substring(i, i + 4)` extracts a substring of length 4, starting at position `i` and ending at position `i + 4`.
        - This represents a 4-bit chunk from the binary string.
        - Example:
          - If `binaryPart` is `"11010111"`, on the first iteration when `i = 0`, `binaryChunk` will be `"1101"`.
          - On the second iteration when `i = 4`, `binaryChunk` will be `"0111"`.
        
         3. Looking up the hexadecimal value:
             hexPart.append(binaryToHexMap.get(binaryChunk));
        - `binaryToHexMap.get(binaryChunk)` uses the `binaryToHexMap` `HashMap`
            to find the hexadecimal character that corresponds to the current 4-bit chunk.
        - The `binaryToHexMap` stores the relationship between a 4-bit binary string (the key)
           and its corresponding hexadecimal character (the value).
          
        For example:
        - `"0000"` maps to `'0'`
        - `"0001"` maps to `'1'`
        - `"1010"` maps to `'A'`
        - `"1111"` maps to `'F'`
        
        - `hexPart.append(...)` appends the hexadecimal character to the `StringBuilder` (`hexPart`), which is used to build the final hexadecimal string.
        
        Let’s go through an example to see how this works.
        
         Input:
        Let’s say `binaryPart` is `"11010111"`. The goal is to convert this binary string into its hexadecimal representation.
        
         Iteration 1 (i = 0):
        - `binaryChunk` is `"1101"`.
        - Look up `"1101"` in the `binaryToHexMap`, which gives `'D'`.
        - Append `'D'` to `hexPart`.
        
         Iteration 2 (i = 4):
        - `binaryChunk` is `"0111"`.
        - Look up `"0111"` in the `binaryToHexMap`, which gives `'7'`.
        - Append `'7'` to `hexPart`.
        
         Final `hexPart`:
        - After the loop completes, `hexPart` will contain the string `"D7"`.
        So, the binary string `"11010111"` is successfully converted to the hexadecimal string `"D7"`.
        
         Considerations:
        - Padding: Before entering this loop, it's important that the `binaryPart` has a length that is a multiple of 4.
           If it's not, the binary string is padded with leading zeros (as described in a previous part of the code) to ensure that each 4-bit chunk is complete. 
        - Fractional Part: If you have a binary string that includes a fractional part (after a decimal point),
           The same process applies to both the integral and fractional parts, handling each part separately.
        
        Code Recap:
        The full method where this snippet is used (in your code) looks like this:
        private static String processBinaryPart(String binaryPart) {
            StringBuilder hexPart = new StringBuilder();
        
            // Padding the binary string to make its length a multiple of 4
            int paddingLength = (4 - (binaryPart.length() % 4)) % 4;
            binaryPart = "0".repeat(paddingLength) + binaryPart;
        
            // Convert each group of 4 binary digits
            for (int i = 0; i < binaryPart.length(); i += 4) {
                String binaryChunk = binaryPart.substring(i, i + 4);
                hexPart.append(binaryToHexMap.get(binaryChunk));
            }
            return hexPart.toString();
        }
        
        This method:
        1. Pads the binary string if necessary to ensure its length is a multiple of 4.
        2. Splits the padded binary string into 4-bit chunks.
        3. Converts each 4-bit chunk to its corresponding hexadecimal character using the `binaryToHexMap`.
        4. Returns the hexadecimal string.
        
         Summary:
        - The `for` loop is responsible for splitting the binary string into 4-bit chunks.
        - Each chunk is then looked up in the `binaryToHexMap` to get the corresponding hexadecimal value.
        - The `StringBuilder` (`hexPart`) is used to build the final hexadecimal string by appending the hexadecimal characters for each 4-bit chunk.
        */
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
