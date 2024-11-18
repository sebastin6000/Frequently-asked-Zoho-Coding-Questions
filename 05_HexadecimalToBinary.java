/* 
Question:
Given a Hexadecimal number as input, the task is to convert that number to a Binary number.

Examples:

Input: Hexadecimal = 1AC5
Output: Binary = 0001101011000101
Explanation:
    Equivalent binary value of 1: 0001
    Equivalent binary value of A: 1010
    Equivalent binary value of C: 1100
    Equivalent binary value of 5: 0101

Input: Hexadecimal = 5D1F
Output: Binary = 0101110100011111.

*/

/* 
Input-output explanation:
The input to the problem is a hexadecimal number, and the output is its binary equivalent. 
Each hexadecimal digit corresponds to a 4-bit binary number. 
For example:
- Hexadecimal '1' is equivalent to Binary '0001'.
- Hexadecimal 'A' is equivalent to Binary '1010' (in hexadecimal, A represents 10).
- Hexadecimal 'C' is equivalent to Binary '1100' (C represents 12 in hexadecimal).
- Hexadecimal '5' is equivalent to Binary '0101'.

The goal is to convert each individual hex digit into its binary form and concatenate them to get the full binary equivalent of the input.
*/

/* 
Constraints explanation:
- Hexadecimal digits range from 0-9 and A-F, where:
    - 0-9 represent decimal values 0-9.
    - A-F represent decimal values 10-15.
- We are tasked with converting any valid hexadecimal input string into a binary string.
- The length of the input hexadecimal number is not fixed and can vary.

Since each hexadecimal digit can be mapped directly to a 4-bit binary string, this is a straightforward conversion task where each digit is handled independently.
*/

/* 
Relatable analogy or real-world scenario: "Hexadecimal to Binary: Rebuilding the Colorful Blocks"

Think of a hexadecimal number as a set of color-coded blocks.
Each color represents a specific pattern of four smaller blocks (bits). For example:
- A hex digit '1' is like a small blue block that represents the binary value '0001'.
- A hex digit 'A' is like a red block representing '1010'.
- A hex digit 'C' is like a green block representing '1100'.
- A hex digit '5' is a yellow block representing '0101'.

To convert the whole number, we treat each hex digit as an individual block,
replace it with its corresponding pattern of smaller blocks (binary digits),
and then line them all up together to form the entire sequence of bits that represents the original number in binary.

Now, just like we would take one block and replace it with smaller blocks in a sequence,
we do the same in the program for each hex digit.
*/

/* 
Relatable analogy Java code step by step:

Step 1: We start by taking the hexadecimal string as input.
Step 2: For each character (hex digit) in the string, manually convert it into its decimal equivalent.
         - For instance, '1' becomes 1, 'A' becomes 10.
Step 3: Based on the decimal value, we manually convert it to a 4-bit binary string.
         - For example, 1 in decimal is "0001", 10 in decimal is "1010".
Step 4: Append each 4-bit binary string to a result.
Step 5: Finally, return the full binary string.
*/

public class HexadecimalToBinary {

  /* 
  Method to convert hexadecimal number to binary
  */
  public static String convertHexToBinary(String hex) {
    // Step 1: Initialize an empty string to store the result
    StringBuilder binary = new StringBuilder();

    // Hexadecimal-to-binary mapping manually
    String[] hexToBinaryMap = {
      "0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011", "1100","1101","1110","1111"
    };

    // Step 2: For each character in the hexadecimal string
    for (int i = 0; i < hex.length(); i++) {
      // Get the hexadecimal character
      char hexChar = hex.charAt(i);

      // Step 3: Convert the hexadecimal character to its decimal equivalent
      int decimal = -1;
      if (hexChar >= '0' && hexChar <= '9') {
        decimal = hexChar - '0'; // Convert '0'-'9' to 0-9

        /* 
        
        Great question! Let's break down the logic behind the expression:
        
        decimal = hexChar - '0';  // Convert '0'-'9' to 0-9
        In Java (and many other programming languages), **characters** are stored as **numeric values** based on their Unicode (or ASCII) encoding. 
        
        For example:
        - The character `'0'` has the Unicode (ASCII) value of **48**.
        - The character `'1'` has the Unicode (ASCII) value of **49**.
        - The character `'2'` has the Unicode (ASCII) value of **50**, and so on, up to `'9'`, which has the value **57**.
        
        When we subtract the character `'0'` from any character `'0'` to `'9'`, we're actually subtracting the numeric values (ASCII values) of these characters.
        
        ### How the conversion works:
        
        - `'0'` (character) has the ASCII value of 48.
        - `'1'` (character) has the ASCII value of 49.
        - `'2'` (character) has the ASCII value of 50.
        - ...
        - `'9'` (character) has the ASCII value of 57.
        
        Now, when we subtract `'0'` from a character like `'1'`, what happens is this:
        
        
        decimal = '1' - '0';  // 49 - 48 = 1
        
        
        This gives us the integer **1** because the difference between their ASCII values is **1**.
        
        Similarly:
        
        decimal = '2' - '0';  // 50 - 48 = 2
        decimal = '9' - '0';  // 57 - 48 = 9
        
        So, if `hexChar` is any character between `'0'` and `'9'`, 
        subtracting `'0'` from it gives us the actual **integer value** of that digit,
        i.e., `'0'` becomes `0`, `'1'` becomes `1`, and so on up to `'9'` which becomes `9`.
        
        Example:
        
        Let's look at an example with some code:
        
        public class HexToDecimal {
            public static void main(String[] args) {
                char hexChar = '3';  // Let's use the character '3'
                
                // Convert the hexadecimal character to its decimal equivalent
                int decimal = hexChar - '0';  // '3' - '0' = 51 - 48 = 3
                
                System.out.println("Hexadecimal Character: " + hexChar);
                System.out.println("Decimal Equivalent: " + decimal);
            }
        }
        
        **Output**:
        ```
        Hexadecimal Character: 3
        Decimal Equivalent: 3
        ```
        
        ### Why this works:
        
        This works because:
        1. The characters `'0'`, `'1'`, `'2'`, ..., `'9'` are contiguous in the ASCII table, meaning they are ordered sequentially.
        2. By subtracting the ASCII value of `'0'` from any numeric character, we can directly map the character to its integer value.
        
        ### In summary:
        When you do:
        decimal = hexChar - '0';
        You're subtracting the **ASCII value of the character `'0'`** from the ASCII value of the character `hexChar`. 
        The result is the **integer value** of that character.
        
        - If `hexChar = '3'`, then `'3' - '0'` results in `51 - 48 = 3`.
        - If `hexChar = '9'`, then `'9' - '0'` results in `57 - 48 = 9`.
        
        This is an efficient way to convert characters `'0'` through `'9'` into their corresponding numeric values from 0 to 9.
                */
      } else if (hexChar >= 'A' && hexChar <= 'F') {
        decimal = hexChar - 'A' + 10; // Convert 'A'-'F' to 10-15

        /* 
        The expression `hexChar - 'A' + 10` is used to convert the characters `'A'` through `'F'`
        into their corresponding decimal values (10 to 15) in hexadecimal representation. Let's break this down step by step:

        Hexadecimal Representation
        - Hexadecimal (or base 16) uses the digits `0-9` and letters `A-F` to represent values.
        - `0-9` represents the values 0 to 9.
        - `A-F` represents the values 10 to 15.
        
        So, in the context of hexadecimal, the character `'A'` represents the number 10,
        `'B'` represents 11,
        `'C'` represents 12,
        `'D'` represents 13,
        `'E'` represents 14,
        and `'F'` represents 15.
        
        The Expression: `hexChar - 'A' + 10`
        
        This expression works by using the ASCII values (or Unicode values) of the characters 
        and performing simple arithmetic to map each letter ('A' to 'F') to the corresponding decimal value.
        
        Step 1: Understanding ASCII/Unicode Values
        - 'A' has an ASCII (or Unicode) value of 65.
        - 'B' has an ASCII (or Unicode) value of 66.
        - 'C' has an ASCII (or Unicode) value of 67.
        - 'D' has an ASCII (or Unicode) value of 68.
        - 'E' has an ASCII (or Unicode) value of 69.
        - 'F' has an ASCII (or Unicode) value of 70.
        
        Step 2: Subtracting `'A'`
        When we subtract `'A'` from a hexadecimal character like `'A'`, `'B'`, `'C'`, etc., 
        we are subtracting their respective ASCII values from the ASCII value of `'A'`.
        
        - For example, if `hexChar` is `'A'`: 'A' - 'A' = 65 - 65 = 0
        This gives us `0` because `'A'` minus `'A'` is 0.
        
        - If `hexChar` is `'B'`: 'B' - 'A' = 66 - 65 = 1
        This gives us `1` because `'B'` is one character after `'A'` in the ASCII table.
        
        - Similarly:
        - `'C' - 'A'` results in `2`
        - `'D' - 'A'` results in `3`
        - `'E' - 'A'` results in `4`
        - `'F' - 'A'` results in `5`
        
        In essence, subtracting `'A'` from any of `'A'` to `'F'` gives us a number that represents the position of that letter in the sequence starting from `'A'`.
        
        Step 3: Adding 10
        Now, since in hexadecimal:
        - `'A'` corresponds to 10,
        - `'B'` corresponds to 11,
        - `'C'` corresponds to 12,
        - and so on up to `'F'` which corresponds to 15,
        
        we need to shift the range of numbers we obtained in Step 2 (which is 0 to 5) to the correct values of 10 to 15.
        By adding 10 to the result of the subtraction, we achieve this:
        
        - For `'A'`: ('A' - 'A') + 10 = 0 + 10 = 10 So `'A'` becomes 10.
        
        - For `'B'`: ('B' - 'A') + 10 = 1 + 10 = 11 So `'B'` becomes 11.
        
        - For `'C'`: ('C' - 'A') + 10 = 2 + 10 = 12 So `'C'` becomes 12.
        
        - For `'D'`: ('D' - 'A') + 10 = 3 + 10 = 13 So `'D'` becomes 13.
        
        - For `'E'`: ('E' - 'A') + 10 = 4 + 10 = 14 So `'E'` becomes 14.
        
        - For `'F'`: ('F' - 'A') + 10 = 5 + 10 = 15 So `'F'` becomes 15.
        
        Example Code Walkthrough:
        Here's how you would use this in code:
        
        public class HexToDecimal {
        public static void main(String[] args) {
        // Test with 'A' to 'F'
        char hexChar = 'B'; // Let's use 'B'
        
        // Convert the hex character 'A'-'F' to its decimal equivalent
        int decimal = hexChar - 'A' + 10; // 'B' - 'A' + 10 -> 66 - 65 + 10 = 11
        
        System.out.println("Hexadecimal Character: " + hexChar);
        System.out.println("Decimal Equivalent: " + decimal);
        }
        }
        
        
        Output:
        
        Hexadecimal Character: B
        Decimal Equivalent: 11
        
        
        ### In Summary:
        
        The expression `hexChar - 'A' + 10` works as follows:
        1. Subtract `'A'`: This gives us a value between `0` and `5` based on the position of the letter in the sequence `'A'` to `'F'`.
        2. Add 10: This shifts the result to the correct hexadecimal value, where `'A'` becomes `10`, `'B'` becomes `11`, and so on, up to `'F'` which becomes `15`.
        
        Thus, the expression efficiently converts hexadecimal letters ('A' to 'F') into their corresponding decimal values (10 to 15).
        
          /* 

        /*
        This code checks whether a character from the hexadecimal string (hexChar) 
        is a numeric digit (0-9) or a letter representing a hexadecimal value (A-F). 
        Here's how it works:
        
        Hexadecimal System Recap:
        
        The hexadecimal system uses digits 0-9 and letters A-F to represent numbers.
        The values 0-9 represent themselves as decimal values (0-9), 
        and A-F represent the values 10 to 15.
        hexChar >= '0' && hexChar <= '9':
        
        This condition checks if the character is a numeric digit between 0 and 9.
        In Java, characters are represented by their Unicode (ASCII) values.
        For example,
        the character '0' has a value of 48,
        '1' is 49, and so on up to '9' which has a value of 57.
        The expression hexChar - '0' converts the character '0' to 0, 
        '1' to 1, ..., and '9' to 9 by subtracting the Unicode value of '0' from hexChar.
        
        
        hexChar >= 'A' && hexChar <= 'F':
        This condition checks
        if the character is a letter between A and F (i.e., a valid hex digit representing values 10-15).
        The Unicode values of 'A' to 'F' are 65 to 70.
        The expression hexChar - 'A' + 10 converts 'A' to 10,
        'B' to 11, ..., and 'F' to 15 by subtracting the Unicode value of 'A' from hexChar and then adding 10 to shift the range to 10-15.
        Why it's done this way:
        In hexadecimal, each character (either a number or a letter) represents a value. The subtraction operation (hexChar - '0' or hexChar - 'A') makes it easy to convert these characters to their corresponding integer values directly without needing an explicit lookup table or complex conditional logic.
        
        For example:
        
        If hexChar is '9', then hexChar - '0' results in 9.
        If hexChar is 'A', then hexChar - 'A' + 10 results in 10.
        Improving and clarifying the code:
        Since we are confident that the input is always valid (i.e., it's a valid hexadecimal string containing characters between '0'-'9' and 'A'-'F'), this check suffices to convert hex characters to their corresponding decimal values. However, it's a good practice to ensure that the input is valid to avoid runtime errors in real-world applications, especially when user input is involved.
                    */
              }

        // Step 4: Use the decimal value to get the binary string
        if (decimal >= 0 && decimal <= 15) {
          // Get the corresponding binary string from the mapping
          binary.append(hexToBinaryMap[decimal]);
          
          /* 
                      Let 's break down how the following code works:
            if (decimal >= 0 && decimal <= 15) {
              // Get the corresponding binary string from the mapping
              binary.append(hexToBinaryMap[decimal]);
            }
            
            # # # 1. Understanding the Condition: `decimal >= 0 && decimal <= 15`
            This condition is checking if the `decimal` value is between 0 and 15(inclusive). -
            In the context of hexadecimal digits,
            Hexadecimal digits range from `0` to `15`
            the values `0-9` represent the digits `0-9`, 
            and the letters `A-F` represent the values `10-15`.
            
              -
             Why is this necessary ?
             We are dealing with hexadecimal digits,
             so the valid decimal values corresponding to a hexadecimal digit will always be in the range `0-15`. -
             This check ensures that `decimal` is a valid number(between 0 and 15),
            which guarantees that the mapping from hexadecimal to binary is accurate.
            
            # # # 2. Getting the Binary String Using the Mapping: `hexToBinaryMap[decimal]`
            
            Now that we 've validated that the `decimal` is a valid hexadecimal digit (i.e., it’s between 0 and 15), we need to convert this decimal value to its corresponding binary string representation.
            
            `hexToBinaryMap`is an array(or list) that maps each decimal value from 0 to 15 to its binary equivalent in a 4 - bit format.Here’ s how it works:
            
             String[] hexToBinaryMap = {
                  "0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"
                };
            
            Each index in the `hexToBinaryMap`
            array corresponds to the binary representation of the decimal value at that index.
            So: `hexToBinaryMap[0]` gives `"0000"`, which is the binary equivalent of decimal `0`.
                   `hexToBinaryMap[1]` gives `"0001"`, which is the binary equivalent of decimal `1`.
                   `hexToBinaryMap[10]`gives `"1010"`, which is the binary equivalent of decimal `10` (i.e., `'A'` in hexadecimal). -
                  `hexToBinaryMap[15]` gives `"1111"`, which is the binary equivalent of decimal `15`(i.e., `'F'` in hexadecimal).
            
            The `decimal` value will be used as an index into this `hexToBinaryMap` array to get the corresponding binary string.
            
            # # # 3. Appending the Binary String: `binary.append(hexToBinaryMap[decimal])`
             
             `binary.append()`: This method is used to add(or append) the binary string to a `StringBuilder`
            object(`binary` in this case).
            
              `hexToBinaryMap[decimal]`: This retrieves the binary string that corresponds to the decimal value. -
              For example, if `decimal = 10`(which corresponds to `'A'` in hexadecimal), then `hexToBinaryMap[10]`
              Would return the string `"1010"`. This string is then appended to the `StringBuilder` `binary`.
            
              Example Walkthrough:
              Suppose the input hexadecimal string is `"1AC5"`, and we want to convert it to binary.Let 's walk through the logic:
              Step - by - Step:
            
              1. Start with the first hexadecimal character `'1'`:
              -`'1'` corresponds to the decimal value `1`. -
                  The binary representation of `1`(from `hexToBinaryMap[1]`) is `"0001"`. -
                   We append `"0001" `to the `StringBuilder` `binary`.
            
            2. Next,
            for the character `'A'`:
              -`'A'` corresponds to the decimal value `10`. 
                 The binary representation of `10`(from `hexToBinaryMap[10]`) is `"1010"`. -
                 We append `"1010"`to the `StringBuilder` `binary`.
            
            3. Next,
            for the character `'C'`:
              -`'C'` corresponds to decimal value `12`. -
              The binary representation of `12`(from `hexToBinaryMap[12]`) is `"1100"`. -
              We append `"1100"` to the `StringBuilder` `binary`.
            
            4. Finally,
            for the character `'5'`:
              -`'5'` corresponds to the decimal value `5`. -
              The binary representation of `5`(from `hexToBinaryMap[5]`) is `"0101"`. -
              We append `"0101"` to the `StringBuilder` `binary`.
            
            So, the binary string would now look like this:  "0001" + "1010" + "1100" + "0101" = "0001101011000101"
            
            # # # Why This Works:
            
              -Hexadecimal to Decimal: The condition `decimal >= 0 && decimal <= 15`
            ensures we are only working with valid hexadecimal digits, which have corresponding decimal values between 0 and 15.
              -
              Using the Mapping Array: The `hexToBinaryMap`
            array is a simple and efficient way to get the binary equivalent of a decimal number(0 to 15).Each index in the array corresponds to a fixed 4 - bit binary value. -
              Efficient String Construction: The `StringBuilder`
            's `append()` method allows us to efficiently build the binary string by adding the 4-bit binary representation for each hexadecimal digit.
            
            # # # Final Example Code:
            
              Here 's how the whole process works in a program:
            
            public class HexadecimalToBinary {
              public static void main(String[] args) {
                // Example input
                String hex = "1AC5";
            
                // Call the method to convert hex to binary
                String binary = convertHexToBinary(hex);
            
                // Output the result
                System.out.println("Hexadecimal: " + hex);
                System.out.println("Binary: " + binary);
              }
            
              public static String convertHexToBinary(String hex) {
                // Hexadecimal-to-binary mapping manually
                String[] hexToBinaryMap = {
                  "0000",
                  "0001",
                  "0010",
                  "0011",
                  "0100",
                  "0101",
                  "0110",
                  "0111",
                  "1000",
                  "1001",
                  "1010",
                  "1011",
                  "1100",
                  "1101",
                  "1110",
                  "1111"
                };
            
                // StringBuilder to build the binary result
                StringBuilder binary = new StringBuilder();
            
                // Iterate through each character in the hexadecimal string
                for (int i = 0; i < hex.length(); i++) {
                  // Get the hexadecimal character
                  char hexChar = hex.charAt(i);
            
                  // Convert hexChar to a decimal value (0-15)
                  int decimal = -1; // Default invalid value
            
                  if (hexChar >= '0' && hexChar <= '9') {
                    decimal = hexChar - '0'; // Convert '0'-'9' to 0-9
                  } else if (hexChar >= 'A' && hexChar <= 'F') {
                    decimal = hexChar - 'A' + 10; // Convert 'A'-'F' to 10-15
                  }
            
                  // If the decimal value is valid (0 to 15), append the binary equivalent
                  if (decimal >= 0 && decimal <= 15) {
                    binary.append(hexToBinaryMap[decimal]);
                  }
                }
            
                // Return the resulting binary string
                return binary.toString();
              }
            }
            
            # # # Summary:
            
              -Condition Check: `decimal >= 0 && decimal <= 15`
            ensures we 're working with valid hexadecimal digits. -
              Mapping: The array `hexToBinaryMap`
            provides the 4 - bit binary string
            for each decimal value from `0`
            to `15`. -
              Efficient Appending: We append each 4 - bit binary string to the `StringBuilder`, constructing the full binary representation of the hexadecimal input.
            
            This is a clean and efficient way to convert hexadecimal values to their binary equivalents!
            
            

          */
        }
      }

      // Step 5: Return the resulting binary string
      return binary.toString();
    }

    /* 
    Main function to run the program
    */
    public static void main(String[] args) {
      // Example input
      String hex = "1AC5";

      // Convert hexadecimal to binary
      String binary = convertHexToBinary(hex);

      // Output the result
      System.out.println("Hexadecimal: " + hex);
      System.out.println("Binary: " + binary);
    }
  }

  /* 
  Time and Space Complexity Explanation:

  Time Complexity: 
  - The loop iterates through each hexadecimal character of the input string.
  - For each hexadecimal character, we perform constant time operations (i.e., checking the range and using the lookup array).
  - Therefore, the overall time complexity is O(n), where 'n' is the length of the input hexadecimal string.

  Space Complexity:
  - We use a StringBuilder to store the binary equivalent, which takes space proportional to the size of the binary result.
  - Since each hexadecimal digit maps to 4 binary digits, the space complexity is O(n), where 'n' is the length of the hexadecimal input string.
  */

  /* 
  FOR loop walkthrough with every iteration with given input:
  Let's walk through the input "1AC5" in the code:

  1. First, the loop starts with the first character '1'. 
     - Convert '1' to decimal -> 1.
     - Look up in the map -> "0001".
     - Append "0001" to the binary string.

  2. Next, the loop processes the character 'A'.
     - Convert 'A' to decimal -> 10.
     - Look up in the map -> "1010".
     - Append "1010" to the binary string.

  3. Next, the loop processes the character 'C'.
     - Convert 'C' to decimal -> 12.
     - Look up in the map -> "1100".
     - Append "1100" to the binary string.

  4. Finally, the loop processes the character '5'.
     - Convert '5' to decimal -> 5.
     - Look up in the map -> "0101".
     - Append "0101" to the binary string.

  The final binary string is "0001101011000101", which is the expected output.
  */

  /* 
  Complete code walkthrough with applying the given input in code:

  Input: "1AC5"

  1. The input hexadecimal string is "1AC5".
  2. The `convertHexToBinary` method starts with an empty StringBuilder.
  3. For each character in the string:
     - Convert the hex digit to its decimal equivalent.
     - Use a manually created mapping array (`hexToBinaryMap`) to get the corresponding 4-bit binary string.
     - Append the binary value to the result.
  4. After processing all characters, the final binary string is constructed.

  Output: "0001101011000101"
  */

  /* 
  Explanation of pattern used:

  - This solution uses a **Lookup Table** pattern to handle the conversion of each hexadecimal digit to its binary equivalent. 
  - Why this pattern? Because we have a direct and fixed mapping between hexadecimal digits and their binary representations (0-15 to 4-bit binary strings).
    
    Custom Pattern:
  - The custom pattern is creating a lookup array to map hexadecimal values to their binary equivalents, then iterating over the input and appending the corresponding binary values to the result string.
  */
