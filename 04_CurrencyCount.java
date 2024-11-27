--------------------------------------------------- WITH TEMPLATE --------------------------------------------------------------------
/* 
Question:
Given an amount, we need to find the minimum number of notes of different denominations that sum up to the given amount.
We have an infinite supply of notes of denominations {2000, 500, 200, 100, 50, 20, 10, 5, 1}.
Start from the highest denomination and try to use as many notes of that denomination as possible. 
Return the number of notes of each denomination used.

Examples:

Input: 800
Output:
Currency   Count 
500 : 1
200 : 1
100 : 1

Input: 2456
Output:
Currency   Count 
2000 : 1
200 : 2
50 : 1
5 : 1
1 : 1

Your Task:
Complete the function minNotes() that takes an integer amount and returns the number of notes needed for that amount using the least number of notes.

Expected Time Complexity: O(n), where n is the number of denominations.
Expected Space Complexity: O(1), as we are using a fixed number of denominations.

Constraints:
1 ≤ amount ≤ 10^18
The denominations are fixed and we can assume they will not change.
*/

/* 
Understanding the Problem Statement:
We are given an amount and need to determine the minimum number of currency notes from the available denominations that sum up to this amount. 
We start with the largest denomination and use as many notes of that denomination as possible, then move to the next smaller denomination, and so on.

Extracting Information from the Problem Statement:
- Input: An integer `amount` representing the total sum.
- Expected Output: The denominations and their respective counts in descending order, showing how many notes of each denomination are used.
- Time Complexity: O(n), where n is the number of denominations. We simply iterate through the fixed set of denominations.
- Space Complexity: O(1), as the space used does not scale with the input size, since the number of denominations is fixed.

Constraints:
- The amount is at most 10^18, but the number of denominations is fixed and small (9 denominations).
- We assume an infinite supply of notes of each denomination.

Thinking Solution for the Problem Statement:
1. Start with the largest denomination and use as many of that denomination as possible.
2. Subtract the value of the used notes from the total amount.
3. Move to the next smaller denomination and repeat the process.
4. Continue until the amount becomes 0, ensuring that we use the least number of notes.

Subtasks:
1. Initialize the array of denominations in descending order.
2. For each denomination, calculate how many notes can be used, and subtract the corresponding amount.
3. Continue this until the amount becomes 0.
4. Output the denominations used along with their counts.

Subtasks of Conversional Solution into Code:
- **Initialize denominations**: We will maintain an array of fixed denominations in descending order.
- **Calculate notes for each denomination**: For each denomination, 
    calculate how many notes are needed by dividing the remaining amount by the denomination value.
- **Reduce the amount**: After calculating the number of notes for a denomination, subtract the corresponding value from the amount.
- **Return the results**: After processing all denominations, return the list of denominations and their respective counts.

Java Code according to Conversational Subtasks:

*/

import java.util.*;

public class CurrencyNotes {
  
    // Function to find the minimum number of notes for a given amount
    public static void minNotes(long amount) {
        // Define the denominations in descending order
        long[] denominations = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        
        // List to store the results (denomination and count)
        List<String> result = new ArrayList<>();
        
        // Iterate over each denomination
        for (long denom : denominations) {
            // Calculate the number of notes for the current denomination
            long count = amount / denom;
            
            // If count is greater than 0, it means we can use some notes of this denomination
            if (count > 0) {
                // Add the denomination and its count to the result list
                result.add(denom + " : " + count);
                
                // Reduce the amount by the corresponding value
                amount -= count * denom;
            }
        }
        
        // Output the result
        System.out.println("Currency   Count");
        for (String line : result) {
            System.out.println(line);
        }
    }
  
    // Main method to test the function
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("For amount 800:");
        minNotes(800);  // Expected Output: Currency Count -> 500:1, 200:1, 100:1

        // Test Case 2
        System.out.println("\nFor amount 2456:");
        minNotes(2456); // Expected Output: Currency Count -> 2000:1, 200:2, 50:1, 5:1, 1:1
    }
}

/*
Time and Space Complexity Explanation:
- **Time Complexity**: O(n), where n is the number of denominations (which is 9). 
    We iterate through the fixed list of denominations once, performing constant time operations for each.
- **Space Complexity**: O(1), as the space used is constant. 
    The result list stores at most 9 entries, as there are 9 denominations, and no additional space is used for large inputs.

Complete Code Walkthrough:
- The function `minNotes(long amount)` starts by defining the available denominations in descending order.
- We then iterate through each denomination and calculate how many notes can be used by dividing the amount by the current denomination.
- For each denomination, if we can use some notes, we append the denomination and its count to the result list.
- After calculating the notes for a denomination, we subtract the corresponding value from the remaining amount.
- Finally, we print the denominations and their respective counts in the required format.

Test Case 1:
- Input: 800
- The denominations used are:
  - 1 note of 500 (remaining amount = 300)
  - 1 note of 200 (remaining amount = 100)
  - 1 note of 100 (remaining amount = 0)
- Expected Output: Currency Count -> 500:1, 200:1, 100:1

Test Case 2:
- Input: 2456
- The denominations used are:
  - 1 note of 2000 (remaining amount = 456)
  - 2 notes of 200 (remaining amount = 56)
  - 1 note of 50 (remaining amount = 6)
  - 1 note of 5 (remaining amount = 1)
  - 1 note of 1 (remaining amount = 0)
- Expected Output: Currency Count -> 2000:1, 200:2, 50:1, 5:1, 1:1
*/

--------------------------------------------------- WITHOUT TEMPLATE --------------------------------------------------------------------

/* 
Question: 
Given an amount, 
find the minimum number of notes of different denominations that sum up to the given amount. 
Starting from the highest denomination note,
try to accommodate as many notes as possible for a given amount. 
We may assume that we have infinite supply of notes of values {2000, 500, 200, 100, 50, 20, 10, 5, 1}

Examples:

Input: 800
Output: 
Currency  Count 
    500 : 1
    200 : 1
    100 : 1

Input: 2456
Output: 
Currency  Count
    2000 : 1
    200 : 2
    50 : 1
    5 : 1
    1 : 1
*/

/* 
Input-output explanation:
In the first example, the amount is 800. The optimal solution is to use one 500 note, one 200 note, and one 100 note, which totals up to 800.
In the second example, the amount is 2456. The optimal solution uses:
    - 1 note of 2000,
    - 2 notes of 200,
    - 1 note of 50,
    - 1 note of 5, and
    - 1 note of 1.
This totals to 2456.

Output format is a list of denominations and the respective count of notes.
*/

/* 
Constraints:
- The available denominations are {2000, 500, 200, 100, 50, 20, 10, 5, 1}.
- The amount is assumed to be a positive integer.
- We have an infinite supply of each denomination.
*/

/* 
Relatable analogy or real-world scenario: "The Cashier's Change Challenge: Minimizing Bills with the Fewest Notes"

Imagine you are a cashier who needs to give back the correct change to a customer. 
However, the available denominations of bills are fixed, 
and you want to minimize the number of notes you hand over. 
Starting with the largest bill and giving as many of those as possible, 
then moving to the next smaller bill, 
you continue this process until you reach the smallest denomination (the 1-note).
This strategy ensures you use the fewest bills possible.

Steps involved:
1. You begin with the largest denomination available, 2000.
2. For each denomination, check how many times it fits into the remaining amount.
3. Subtract the equivalent value from the remaining amount.
4. Repeat this process until the entire amount is broken down into denominations.

For example, if the amount is 2456:
- Start with 2000: 2456 // 2000 = 1. So, you use one 2000-note. Remaining amount = 2456 - 2000 = 456.
- Next, check how many 200s fit into 456: 456 // 200 = 2. So, use two 200-notes. Remaining amount = 456 - 400 = 56.
- Then, 50 fits into 56: 56 // 50 = 1. Use one 50-note. Remaining amount = 56 - 50 = 6.
- Next, 5 fits into 6: 6 // 5 = 1. Use one 5-note. Remaining amount = 6 - 5 = 1.
- Finally, 1 fits into 1: 1 // 1 = 1. Use one 1-note. Remaining amount = 1 - 1 = 0.

Thus, the optimal solution is to use:
- 1 note of 2000,
- 2 notes of 200,
- 1 note of 50,
- 1 note of 5,
- 1 note of 1.
*/

/* 
Relatable analogy Java code step by step:

1. Define the denominations array: 
We start by defining the denominations in descending order,
so that we can process the largest denomination first.
2. Initialize a result map or array: 
This will store the count of each denomination used.
3. Iterate through the denominations:
We check how many times each denomination fits into the remaining amount.
4. Update the amount: 
For each denomination, we subtract the corresponding value from the total amount.
5. Output the result:
After iterating through all denominations, we print the results in the required format.

Java Code Implementation:

*/

import java.util.*;

public class CurrencyCount {

    // Function to calculate the minimum number of notes
    public static void getCurrencyCount(int amount) {
        // Denominations available (sorted from largest to smallest)
        // types of notes you are having as a accountant
        int[] denominations = {
            2000, 500, 200, 100, 50, 20, 10, 5, 1
        };

        // Create a map to store the count of each denomination used
        Map<Integer, Integer> currencyMap = new LinkedHashMap<>();

        // Iterate over each denomination
        for (int i = 0; i < denominations.length; i++) {
            int denomination = denominations[i];
            // If the amount is greater than or equal to the denomination
            if (amount >= denomination) {
                // Find how many times this denomination can fit into the amount
                int count = amount / denomination;
                // Store the count in the map
                currencyMap.put(denomination, count);
                // Subtract the total value of these notes from the amount
                amount -= count * denomination;
            }
        }

        // Output the result using a normal for loop
        System.out.println("Currency  Count");
        // Convert the map to an array of entries to use a normal for loop
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(currencyMap.entrySet());
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<Integer, Integer> entry = entries.get(i);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Example input: 2456
        getCurrencyCount(2456);
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity: O(N), where N is the number of denominations (in this case, 9). 
This is because we iterate over all the denominations once to calculate the required count for each denomination.

Space Complexity: O(N), where N is the number of denominations, due to the space used to store the results in a map.

In this solution, the space is used to store the count of each denomination, and the time is spent iterating through the denominations to find the number of notes for each.

*/

/* 
FOR loop walkthrough with every iteration with given input, Complete code walkthrough with applying the given input in code and explanation:

Given the input amount 2456, the denominations are {2000, 500, 200, 100, 50, 20, 10, 5, 1}.

1. Start with the largest denomination (2000):
   - 2456 // 2000 = 1. So, we use one 2000-note.
   - Remaining amount = 2456 - 2000 = 456.

2. Next, check the denomination 500:
   - 456 // 500 = 0. So, we don't use any 500-notes.
   - Remaining amount = 456.

3. Then, check the denomination 200:
   - 456 // 200 = 2. So, we use two 200-notes.
   - Remaining amount = 456 - 400 = 56.

4. Then, check the denomination 100:
   - 56 // 100 = 0. So, we don't use any 100-notes.
   - Remaining amount = 56.

5. Next, check the denomination 50:
   - 56 // 50 = 1. So, we use one 50-note.
   - Remaining amount = 56 - 50 = 6.

6. Then, check the denomination 20:
   - 6 // 20 = 0. So, we don't use any 20-notes.
   - Remaining amount = 6.

7. Then, check the denomination 10:
   - 6 // 10 = 0. So, we don't use any 10-notes.
   - Remaining amount = 6.

8. Next, check the denomination 5:
   - 6 // 5 = 1. So, we use one 5-note.
   - Remaining amount = 6 - 5 = 1.

9. Finally, check the denomination 1:
   - 1 // 1 = 1. So, we use one 1-note.
   - Remaining amount = 1 - 1 = 0.

The amount is now zero, and the optimal solution is:
- 1 note of 2000,
- 2 notes of 200,
- 1 note of 50,
- 1 note of 5,
- 1 note of 1.

Complete Output:
Currency  Count
2000 : 1
200 : 2
50 : 1
5 : 1
1 : 1
*/

/* 
Pattern Walkthrough and Explanation:

This problem follows a greedy approach, where we prioritize the largest denominations first, 
and use as many of those as possible before moving to smaller denominations. The strategy ensures the fewest notes are used.

This pattern is well-suited for problems that involve optimization, like minimizing the number of notes or coins.

In this case, since we always move in decreasing order of denominations, we ensure we are using the maximum possible notes for each denomination.

This greedy algorithm is optimal because:
1. Larger denominations are always preferred, and we reduce the amount efficiently.
2. By iterating from largest to smallest denominations, we ensure that we always minimize the number of notes.

*/
