/*
Question:
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Examples:
1. Input: n = 2
   Output: 2
   Explanation: There are two ways to climb to the top:
   1. 1 step + 1 step
   2. 2 steps

2. Input: n = 3
   Output: 3
   Explanation: There are three ways to climb to the top:
   1. 1 step + 1 step + 1 step
   2. 1 step + 2 steps
   3. 2 steps + 1 step

Constraints:
1 <= n <= 45
*/

/*
Understanding the Problem Statement:
- You are given an integer `n`, representing the number of steps you need to climb.
- At each step, you can either move 1 step or 2 steps forward.
- You need to find how many distinct ways you can reach the nth step.

What is being asked:
- The task is to return the number of distinct ways to climb to the top, considering the combinations of 1-step and 2-step moves.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is an integer `n`, representing the number of steps in the staircase.

2. Expected Output:
   - The output should be an integer, which is the number of distinct ways to reach the top of the staircase.

3. Output return type:
   - The function should return an integer.

4. Time complexity expectations:
   - Since n can be as large as 45, the solution should ideally run in O(n) time or better.

5. Constraints:
   - The value of `n` is between 1 and 45, so we need an efficient approach to solve the problem.
*/

 /*
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a variation of the Fibonacci sequence problem, 
     where each step is the sum of the two previous steps (because you can reach a step either from the previous step or from two steps behind).
   - If `dp[i]` represents the number of ways to reach the i-th step, then:
     - `dp[i] = dp[i-1] + dp[i-2]`
   - Base cases:
     - `dp[0] = 1` (1 way to be at the start: do nothing)
     - `dp[1] = 1` (1 way to reach the first step: 1 step)

2. Destructuring:
   - We need to calculate the number of ways to reach the nth step by building from the base cases up to `n`.

3. Conversational solution into smaller subtask:
   - Subtask 1: Define base cases `dp[0] = 1` and `dp[1] = 1`.
   - Subtask 2: Use dynamic programming to calculate the number of ways for each subsequent step up to `n`.
   - Subtask 3: Return `dp[n]` as the result.
*/

 /*
Conversional Solution into Subtasks:
1. Define an array `dp[]` to store the number of ways to reach each step.
2. Set the base cases `dp[0] = 1` and `dp[1] = 1`.
3. For each step from 2 to `n`, calculate `dp[i] = dp[i-1] + dp[i-2]`.
4. Return `dp[n]` as the result.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a `dp` array to store the number of ways to reach each step.
2. Set `dp[0] = 1` and `dp[1] = 1`.
3. Iterate from 2 to `n`, and calculate `dp[i] = dp[i-1] + dp[i-2]` at each step.
4. Return `dp[n]`.

*/

/* 
Java Code according to conversational subtasks.
*/

public class ClimbingStairs {

    // Function to calculate the number of ways to climb to the top
    public static int climbStairs(int n) {
        // Base cases
        if (n == 1) return 1;
        
        // Initialize dp array to store the number of ways to reach each step
        int[] dp = new int[n + 1];
        
        // Base case: There is 1 way to reach step 0 (do nothing)
        dp[0] = 1;
        // Base case: There is 1 way to reach step 1 (1 step)
        dp[1] = 1;
        
        // Fill the dp array for each step from 2 to n
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // The number of ways to reach i-th step
        }
        
        // Return the number of ways to reach the nth step
        return dp[n];
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        System.out.println(climbStairs(2));  // Expected output: 2

        // Test case 2
        System.out.println(climbStairs(3));  // Expected output: 3

        // Test case 3
        System.out.println(climbStairs(4));  // Expected output: 5

        // Test case 4
        System.out.println(climbStairs(5));  // Expected output: 8
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - The solution runs in O(n) time because we iterate through the array from 2 to `n` and perform a constant amount of work (adding two numbers).
  
- Space Complexity:
  - The space complexity is O(n) because we use an array `dp[]` to store the number of ways to reach each step up to `n`.

*/

/* 
Explanation of loops:
1. The `for` loop starts from 2 and goes up to `n`, calculating the number of ways to reach each step:
   - For `n = 4`, the iterations will be:
     - `i = 2`: dp[2] = dp[1] + dp[0] = 1 + 1 = 2
     - `i = 3`: dp[3] = dp[2] + dp[1] = 2 + 1 = 3
     - `i = 4`: dp[4] = dp[3] + dp[2] = 3 + 2 = 5
     
   The final answer is dp[4] = 5, which is the number of ways to reach the 4th step.

*/

/* 
Complete code walkthrough with applying the given input in code and explanation:

For input `n = 4`:
1. Base cases: dp[0] = 1, dp[1] = 1
2. Iteration:
   - i = 2: dp[2] = dp[1] + dp[0] = 1 + 1 = 2
   - i = 3: dp[3] = dp[2] + dp[1] = 2 + 1 = 3
   - i = 4: dp[4] = dp[3] + dp[2] = 3 + 2 = 5
3. The final answer is dp[4] = 5.
Output: 5
*/
