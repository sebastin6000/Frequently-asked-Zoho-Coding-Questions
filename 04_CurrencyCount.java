/* 
Section -1 (Question section)
Problem Statement:
Given an amount, find the minimum number of notes of different denominations that sum up to the given amount. Starting from the highest denomination note, try to accommodate as many notes as possible for a given amount. We may assume that we have an infinite supply of notes of values {2000, 500, 200, 100, 50, 20, 10, 5, 1}. 

Examples:

Input : 800
Output : 
Currency  Count 
         500 : 1
         200 : 1
         100 : 1

Input : 2456
Output : 
Currency  Count
         2000 : 1
         200 : 2
         50 : 1
         5 : 1
         1 : 1
*/

 /* 
Section - 2 (Understanding the Problem Statement section)
The problem asks for the minimum number of notes needed to make up a given amount using denominations of {2000, 500, 200, 100, 50, 20, 10, 5, 1}.
The objective is to use the highest denomination possible first, and then proceed with smaller denominations, trying to use as many notes as possible for the remaining amount.

The task is to:
1. Start from the largest denomination.
2. Use as many notes of that denomination as possible.
3. Subtract the value of the notes used from the amount.
4. Repeat until the amount becomes zero.

The key requirement is to minimize the number of notes, and this can be achieved using a greedy approach.
 */

 /* 
Section - 3 (Extracting Information from the Problem Statement section)
1. Input:
   - A positive integer amount that needs to be converted into the minimum number of notes.
   - The available denominations are {2000, 500, 200, 100, 50, 20, 10, 5, 1}.
2. Output:
   - A list of denominations and their respective counts that sum up to the given amount.
   - The count for each denomination should be printed on the same line as the denomination.

3. Expected Output:
   - A sorted list of denominations and counts for each denomination used.

4. Constraints:
   - No constraints are explicitly mentioned, but it can be assumed that the amount will be a positive integer and the denominations are predefined as given.

5. Time Complexity:
   - The time complexity of the solution is O(d), where d is the number of denominations (in this case, 9). Since we are iterating over the denominations once, 
      this is the most efficient way to solve the problem.

6. Space Complexity:
   - The space complexity is O(1) since we do not use any additional data structures proportional to the input size, aside from variables to store the count of notes.
 */

 /* 
Section - 4 (Thinking Solution for the Problem Statement section)
The approach for this problem is straightforward using a greedy algorithm:
1. Start with the largest denomination (2000) and see how many of them can fit into the given amount.
2. Subtract the total value of these notes from the given amount.
3. Move to the next smaller denomination (500) and repeat the process.
4. Continue this until we exhaust the denominations or the amount becomes zero.
5. For each denomination, print the number of notes used.

The key observation here is that by starting with the largest denomination and using as many notes as possible, we ensure the minimum number of notes required.

Since the denominations are fixed, there are only 9 denominations, so the solution is efficient with constant time complexity related to the number of denominations.
 */

 /* 
Section - 5 (Input to Output conversion steps into smaller subtasks section)
Subtask 1: Start with the largest denomination (2000) and calculate how many notes are needed for the given amount.
Subtask 2: Subtract the value of these notes from the amount.
Subtask 3: Move to the next smaller denomination and repeat the process.
Subtask 4: Continue until the amount is reduced to zero.
Subtask 5: Print the denomination and the count of notes used.
 */

 /* 
Section - 6 (Input to Output conversion subtasks into Code section)
Subtask 1: We need to start with the largest denomination, and for each denomination, calculate how many notes can fit into the remaining amount.
Subtask 2: After calculating the number of notes for each denomination, subtract the value of those notes from the remaining amount.
Subtask 3: Repeat for each denomination until the amount becomes zero.
Subtask 4: For each denomination used, print the denomination and the number of notes used.
 */

 /* 
Section - 7 (Code Requirement to complete the subtasks section)
We will use:
1. A loop to iterate through the denominations.
2. A variable to keep track of the remaining amount.
3. A print statement to output the denomination and count for each denomination used.
 */

 /* 
Section - 8 (Explanation of Approach section)
1. The denominations are fixed and sorted in descending order.
2. We iterate through the denominations from highest to lowest.
3. For each denomination, we check how many times it can fit into the remaining amount.
4. After determining the number of notes for the current denomination, we subtract the corresponding value from the remaining amount.
5. We continue this process for the next smaller denomination until the remaining amount is zero.
6. The result is printed in the format: denomination and the count of notes used.
 */

 /* 
Section - 9 (Java Code according to Input to Output conversion subtasks)
*/
import java.util.*;

public class MinimumNotes {

    // Main function to test the solution
    public static void main(String[] args) {
        // Test cases
        int amount1 = 800;
        int amount2 = 2456;

        // Output the result for both test cases
        System.out.println("For amount: " + amount1);
        calculateMinNotes(amount1);

        System.out.println("\nFor amount: " + amount2);
        calculateMinNotes(amount2);
    }

    // Function to calculate the minimum notes required
    public static void calculateMinNotes(int amount) {
        // List of denominations in descending order
        int[] denominations = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        
        // Iterate through each denomination
        for (int denom : denominations) {
            if (amount >= denom) {  // If the amount is greater than or equal to the denomination
                int count = amount / denom;  // Calculate how many notes of this denomination
                amount = amount % denom;  // Subtract the value of these notes from the amount
                System.out.println("Currency " + denom + " : " + count);
            }
        }
    }
}

/*
Section - 10 (Time and Space Complexity Explanation)
Time Complexity:
- The solution iterates through each of the 9 denominations exactly once.
- For each denomination, we perform a simple division and modulus operation to calculate the number of notes.
- Thus, the time complexity is O(d), where d is the number of denominations (in this case, 9).

Space Complexity:
- We use a fixed array of denominations and a few variables to store the remaining amount and note counts.
- No additional space is used that grows with the input size, so the space complexity is O(1).
 */

/* 
Section - 11 (If “for” loop or “while” loop are used in the code you have to walkthrough all the(more than 1) 
             “for” loop or “while” loop used in the code with every iteration with given input and this section has to be inside this structure of comments)

Explanation of loops:

Loop 1 (Iterating through the denominations):
- The `for` loop iterates through each denomination in the array from highest to lowest.
  - For amount = 800:
    - For denomination 2000: 800 < 2000, so skip.
    - For denomination 500: 800 / 500 = 1 note. Remaining amount = 800 % 500 = 300.
    - For denomination 200: 300 / 200 = 1 note. Remaining amount = 300 % 200 = 100.
    - For denomination 100: 100 / 100 = 1 note. Remaining amount = 100 % 100 = 0.
    - Since the remaining amount is now 0, we stop.

Loop 2 (Iterating through the denominations for amount 2456):
- For amount = 2456:
    - For denomination 2000: 2456 / 2000 = 1 note. Remaining amount = 2456 % 2000 = 456.
    - For denomination 200: 456 / 200 = 2 notes. Remaining amount = 456 % 200 = 56.
    - For denomination 50: 56 / 50 = 1 note. Remaining amount = 56 % 50 = 6.
    - For denomination 5: 6 / 5 = 1 note. Remaining amount = 6 % 5 = 1.
    - For denomination 1: 1 / 1 = 1 note. Remaining amount = 1 % 1 = 0.
    - Since the remaining amount is now 0, we stop.
 */

 /* 
Section - 12 (Complete code walkthrough with applying the given input in code and explanation)

Given input: 800
- First, we start with the largest denomination (200

0) and find that it doesn't fit into 800, so we move to 500.
- 800 / 500 = 1, so 1 note of 500 is used. Remaining amount = 800 % 500 = 300.
- 300 / 200 = 1, so 1 note of 200 is used. Remaining amount = 300 % 200 = 100.
- 100 / 100 = 1, so 1 note of 100 is used. Remaining amount = 100 % 100 = 0.
- Result: [500: 1, 200: 1, 100: 1]

Given input: 2456
- Start with 2000: 2456 / 2000 = 1, Remaining amount = 456.
- Next, 456 / 200 = 2, Remaining amount = 56.
- Then, 56 / 50 = 1, Remaining amount = 6.
- After that, 6 / 5 = 1, Remaining amount = 1.
- Finally, 1 / 1 = 1, Remaining amount = 0.
- Result: [2000: 1, 200: 2, 50: 1, 5: 1, 1: 1]
 */

/*
Summary of Approach:
The solution uses a greedy approach to minimize the number of notes. 
    It iterates through the denominations starting from the largest, 
    calculates how many notes can fit into the given amount, subtracts the value, 
    and repeats the process for smaller denominations. 
    The code efficiently calculates the minimum number of notes required for any given amount.
*/
