/* 
Question:
Given the weights and values of items, and a knapsack with a given capacity, 
you are required to find the maximum value that can be achieved by filling the knapsack. Each item can be included or excluded from the knapsack, 
but cannot be broken into fractions (0-1 Knapsack Problem).

You are given two integer arrays:
- val[]: an array of values representing the value of each item.
- wt[]: an array of weights representing the weight of each item.
You are also given an integer capacity, which represents the knapsack's capacity. 
The task is to find the maximum total value that can be placed in the knapsack without exceeding its capacity.

Examples:

Input: 
capacity = 4, 
val[] = [1, 2, 3], 
wt[] = [4, 5, 1] 

Output: 3 
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.

Input: 
capacity = 3, 
val[] = [1, 2, 3], 
wt[] = [4, 5, 6] 

Output: 0 
Explanation: Every item has a weight exceeding the knapsack's capacity.

Input: 
capacity = 5, 
val[] = [10, 40, 30, 50], 
wt[] = [5, 4, 6, 3] 

Output: 50 
Explanation: Choose the second item (value 40, weight 4) and the fourth item (value 50, weight 3) for a total value of 90, 
but the weight exceeds the capacity. The best choice is to pick the fourth item (value 50, weight 3).

Expected Time Complexity: O(n*capacity)
Expected Auxiliary Space: O(n*capacity)

Constraints:
- 2 ≤ val.size() = wt.size() ≤ 103
- 1 ≤ capacity ≤ 103
- 1 ≤ val[i] ≤ 103
- 1 ≤ wt[i] ≤ 103
*/

/* 
Understanding the Problem Statement:
- The task is to maximize the value in the knapsack, given that we can pick or not pick each item. This is a 0-1 Knapsack problem, where:
  - Each item has a weight and a value.
  - We need to select a subset of items such that their total weight does not exceed the knapsack's capacity, and the total value is maximized.
  - We cannot take fractional parts of items (0-1 property).

What is being asked:
- We are to return the maximum total value that can be obtained without exceeding the given capacity.
- If no items can fit, the answer should be 0.

*/

/* 
Extracting Information from the Problem Statement:

2.1 Input Data Type:
- `val[]`: An array of integers representing the values of the items.
- `wt[]`: An array of integers representing the weights of the items.
- `capacity`: An integer representing the capacity of the knapsack.

2.2 Expected Output:
- A single integer representing the maximum value that can be achieved within the given knapsack capacity.

2.3 Output Return Type:
- Integer.

2.4 Time Complexity Expectations:
- The expected time complexity is O(n * capacity), where `n` is the number of items and `capacity` is the knapsack's capacity.

2.5 Explanation of Given Constraints:
- The maximum number of items (`n`) and the maximum knapsack capacity are 1000 each, so an O(n * capacity) solution is feasible.
*/

 /* 
Thinking Solution for the Problem Statement:

3.1 Identification Part:
- This is a classic dynamic programming (DP) problem where we need to compute the maximum value we can fit in the knapsack, considering each item one by one.
- The DP table will store the maximum value achievable for each possible knapsack capacity from 0 to `capacity`.

3.2 Destructuring:
- The problem is essentially asking us to solve the 0-1 Knapsack problem using dynamic programming.
- For each item, we have two choices: include it in the knapsack or exclude it.
- We will iterate through all the items, and for each item, 
  check the maximum value we can achieve for each possible knapsack capacity, from 0 to the given `capacity`.

3.3 Conversional solution into smaller subtask:
- **Subtask 1**: Initialize a DP table of size `(capacity + 1)` to store the maximum value for each capacity.
- **Subtask 2**: For each item, update the DP table by checking if including the item would result in a higher value.
- **Subtask 3**: After processing all items, the maximum value for the given `capacity` will be in the last position of the DP table.

 */

/* 
Conversional Solution into subtasks:

S.no  | Subtask Description
1     | Create a DP array `dp[]` of size `capacity + 1` to store the maximum value for each possible knapsack capacity.
2     | For each item, check whether including it results in a higher value for any capacity from `capacity` down to the item's weight.
3     | After processing all items, the last entry in the `dp[]` array contains the maximum value achievable.

*/

/* 
Subtasks of Conversional Solution into Code:

1. Create a DP array of size `capacity + 1` initialized to 0.
2. For each item, iterate through all capacities from `capacity` down to the weight of the item, 
   updating the DP table based on whether including the item results in a higher value.
3. The value at `dp[capacity]` will give the maximum value that can be obtained.

*/

/* 
Java Code according to conversational subtasks:
*/

public class KnapsackProblem {

    // Function to find the maximum value that can be put in a knapsack of given capacity
    public static int knapSack(int capacity, int[] val, int[] wt, int n) {
        // Create a DP array to store the maximum value for each possible capacity
        int[] dp = new int[capacity + 1];
        
        // Iterate through all items
        for (int i = 0; i < n; i++) {
            // Traverse the capacities in reverse order to ensure we do not use the same item twice
            for (int w = capacity; w >= wt[i]; w--) {
                // Update the dp array for the current capacity
                dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }
        
        // The maximum value that can be achieved is stored in dp[capacity]
        return dp[capacity];
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        // Test case examples
        int capacity1 = 4;
        int[] val1 = {1, 2, 3};
        int[] wt1 = {4, 5, 1};
        System.out.println(knapSack(capacity1, val1, wt1, val1.length)); // Output: 3

        int capacity2 = 3;
        int[] val2 = {1, 2, 3};
        int[] wt2 = {4, 5, 6};
        System.out.println(knapSack(capacity2, val2, wt2, val2.length)); // Output: 0

        int capacity3 = 5;
        int[] val3 = {10, 40, 30, 50};
        int[] wt3 = {5, 4, 6, 3};
        System.out.println(knapSack(capacity3, val3, wt3, val3.length)); // Output: 50
    }
}

/* 
Time and Space Complexity Explanation:

Time Complexity:
- The time complexity is O(n * capacity), where `n` is the number of items and `capacity` is the knapsack's capacity. 
- We process each item and for each item, we update the `dp[]` array for all possible capacities.

Space Complexity:
- The space complexity is O(capacity), as we are using a single array `dp[]` to store the maximum value for each capacity.

*/

/* 
If used any “for” loop or “while” loop, you have walkthrough all the “for” loop used in the code:

1. The first loop (`for (int i = 0; i < n; i++)`) iterates through each item.
2. The second loop (`for (int w = capacity; w >= wt[i]; w--)`) updates the `dp[]` array for the current item, 
   considering all possible knapsack capacities from `capacity` down to the item's weight.

Example walkthrough with input `capacity = 4`, `val = [1, 2, 3]`, and `wt = [4, 5, 1]`:

1. Initially, `dp[] = {0, 0, 0, 0, 0}`.
2. Process item 1 (`wt = 4`, `val = 1`): `dp[]` is updated to `{0, 0, 0, 0, 1}`.
3. Process item 2 (`wt = 5`, `val = 2`): No update, as the capacity is too small to fit item 2.
4. Process item 3 (`wt = 1`, `val = 3`): `dp[]` is updated to `{0, 3, 3, 3, 3}`.
5. The maximum value is `dp[4] = 3`.

*/

