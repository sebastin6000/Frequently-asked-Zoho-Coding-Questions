/* 
Question:
You are given a string `s` in the form of an IPv4 Address. Your task is to validate the IPv4 address.
A valid IPv4 Address is of the form `x1.x2.x3.x4` where 0 <= (x1, x2, x3, x4) <= 255. 
Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255)

Note:
- Any additional leading zeros in each number make it invalid. For example, "01" is invalid.
- An address is valid if it contains exactly four octets separated by dots.

Examples:

Input: 
s = "222.111.111.111"
Output: 
true
Explanation: Here, the IPv4 address is as per the criteria mentioned, and each part lies in the range 0-255.

Input:
s = "5555..555"
Output: 
false
Explanation: The middle two portions are missing, so it is not a valid IPv4 address.

Input:
s = "0.0.0.255"
Output:
false
Explanation: The segment "0.0.0.255" is not valid as "255" exceeds the acceptable range for IPv4.

Constraints:
1 <= |s| <= 15
*/

/* 
Understanding the Problem Statement:
- The given string `s` represents an IPv4 address.
- An IPv4 address consists of four numbers separated by dots.
- Each number must lie between 0 and 255, inclusive.
- The number should not have leading zeros unless it is exactly "0".
- We need to validate whether the string `s` forms a valid IPv4 address or not.

What is being asked:
- We are asked to return `true` if the string represents a valid IPv4 address and `false` otherwise.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is a string `s` representing an IPv4 address.

2. Expected Output:
   - Return `true` if the string is a valid IPv4 address and `false` otherwise.

3. Output return type:
   - The return type is a boolean (`true` or `false`).

4. Time complexity expectations:
   - We will process each part of the string, so the time complexity should be O(n), where n is the length of the string.

5. Constraints:
   - The length of the string is between 1 and 15 characters.
   - The string will contain valid IPv4 address format if the input is correct (four parts, separated by dots).
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a string validation problem where we need to ensure the string follows the pattern of an IPv4 address.
   - We need to split the string into four parts using the `.` separator, and each part should represent a number between 0 and 255.

2. Destructuring:
   - Split the string based on the `.` character.
   - Ensure there are exactly four parts.
   - Each part should be a number between 0 and 255, and no part should have leading zeros unless it is exactly "0".

3. Conversational solution into smaller subtask:
   - Step 1: Split the string into parts using the `.` separator.
   - Step 2: Check if there are exactly four parts.
   - Step 3: Validate each part: it must be a valid number (not empty, within the range 0-255, and not have leading zeros).
   - Step 4: Return `true` if all parts are valid; otherwise, return `false`.

*/

/* 
Conversional Solution into Subtasks:
1. Split the string into four parts using the `.` separator.
2. Validate the length of the resulting list of parts.
3. For each part:
   - Check if it is a valid number.
   - Ensure the number is between 0 and 255.
   - Ensure it does not contain leading zeros unless it is "0".
4. Return `true` if all parts are valid, otherwise `false`.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Use the `split()` function to divide the string based on the dots.
2. Validate that the resulting array has exactly four parts.
3. Validate each part:
   - Check that each part is numeric.
   - Check if it lies within the range 0-255.
   - Ensure no leading zeros are present unless the part is "0".
4. Return the appropriate boolean value based on validation.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class ValidateIPv4 {

    // Function to validate an IPv4 address
    public static boolean isValidIPv4(String s) {
        // Step 1: Split the string by dot
        String[] parts = s.split("\\.");

        // Step 2: Check if there are exactly four parts
        if (parts.length != 4) {
            return false;
        }

        // Step 3: Validate each part
        for (String part : parts) {
            // Check if the part is empty or not a valid number
            if (part.isEmpty() || !part.matches("\\d+")) {
                return false;
            }

            // Check if the part is within the range 0-255
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return false;
            }

            // Check if the part has leading zeros
            if (part.length() > 1 && part.startsWith("0")) {
                return false;
            }
        }

        // If all parts are valid
        return true;
    }

    // Main function to test the validation
    public static void main(String[] args) {
        // Test case 1
        String s1 = "222.111.111.111";
        System.out.println(isValidIPv4(s1));  // Expected output: true

        // Test case 2
        String s2 = "5555..555";
        System.out.println(isValidIPv4(s2));  // Expected output: false

        // Test case 3
        String s3 = "0.0.0.255";
        System.out.println(isValidIPv4(s3));  // Expected output: false
    }
}

/* 
Time and Space Complexity Explanation:
Time Complexity:
- The function `split()` splits the string by dot, which takes O(n) where n is the length of the string.
- The subsequent loop checks each part, which involves comparing strings and parsing integers, all of which take constant time for each part.
- Overall, the time complexity is O(n), where n is the length of the string.

Space Complexity:
- We are storing the parts in an array, which takes O(n) space, where n is the number of characters in the string.
- Hence, the space complexity is O(n).

*/

/* 
For Loop Walkthrough:
1. The first loop splits the string into four parts using the dot `.` separator.
2. The second loop iterates through each of the four parts, checking:
   - If the part is empty or contains non-numeric characters.
   - If the part is within the valid range (0-255).
   - If the part has leading zeros (except "0").

Complete Code Walkthrough:
- The string is split by the dot separator into parts.
- The length of the resulting array is checked to ensure there are exactly four parts.
- Each part is validated to ensure it is numeric, within the valid range, and does not have leading zeros (unless it is "0").
- The function returns `true` if all parts are valid; otherwise, it returns `false`.
*/
