/* 
Question: 
Given an integer array nums where every element appears three times except for one, 
which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99

*/

/* 
Input-output explanation:
- The given input array contains numbers where every element appears exactly 3 times, 
   except for one element which appears only once. 
- The task is to identify the element that appears only once.

Example 1:
Input: [2, 2, 3, 2]
- The number 2 appears three times, and the number 3 appears only once.
- So the output will be 3.

Example 2:
Input: [0, 1, 0, 1, 0, 1, 99]
- The number 0 appears three times, 1 appears three times, and 99 appears once.
- So the output will be 99.

*/

/* 
Constraints explanation:
1. The length of the input array can be as large as 30,000 elements.
2. Each number in the array lies within the range of [-2^31, 2^31-1].
3. Every number in the array will appear exactly three times, except for one which appears once. 
These constraints suggest that the solution should be highly efficient both in time and space.
*/

/* 
Relatable analogy or real-world scenario:
Imagine you're at a party and there are groups of people. 
Most of the people come in groups of three, but one person came alone. 
Your task is to identify who came alone.

- You can think of each group of three people as a number that appears three times in the array.
- The person who came alone represents the unique number that appears only once.

Now, here's the challenge: 
You must figure out who the "lonely" person is without writing down each name and keeping a count. 
Instead, you must use a clever trick to identify the lonely person by looking at everyone's name only once and using a minimal amount of space. 

To do this, you'll keep track of some numbers using a clever "bit manipulation" trick.
BITWISE OPERATOR : https://www.scaler.com/topics/java/bitwise-operators-in-java/
Instead of counting how many times each name appears,
you'll track the bits (the "individual characters") in the names and find the one that doesn't match the others.

*/

/* 
Relatable analogy Java code step by step:
Let's translate the analogy into code.

1. The goal is to find the number that appears only once, while all others appear three times.
2. We'll use a bit manipulation technique with three variables `ones`, `twos`, and `threes` to keep track of the bits for the numbers.
3. The variable `ones` will hold the bits that have appeared exactly once, while `twos` will hold the bits that have appeared exactly twice.
4. By using `ones` and `twos`, we can track the bits of the number that appeared only once.

The general idea is:
- When we encounter a number, we'll update `ones` and `twos` to track the bits that appeared once and twice.
- We will then use bitwise operations to find the bits that are repeated three times and remove them.

Let's now break down the solution with code.

*/
// WITHOUT EXPLANATION
public class FindSingleElement 
{
    /*We're using bitwise operators to keep track of bits that appeared once and twice.*/
    public int singleNumber(int[] nums) 
    {
        int ones = 0, twos = 0;
        // loop through all numbers in the array
        for (int i = 0; i < nums.length; i++) 
        {
            int num = nums[i];
            // Update twos to keep track of bits that appeared twice
            twos |= ones & num; 
            // Update ones to keep track of bits that appeared once
            ones ^= num;
            
            // Remove bits that appeared three times
            int threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        
        // The result will be stored in the variable 'ones'
        return ones;
    }    
    public static void main(String[] args) 
  {
        FindSingleElement solution = new FindSingleElement();
        
        // Test the function with an example
        int[] nums = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums)); // Output: 3
    }
}
------------------------------------------------------------
// WITH EXPLANATION
public class FindSingleElement 
{
    /*We're using bitwise operators to keep track of bits that appeared once and twice.*/
    public int singleNumber(int[] nums) 
    {
        int ones = 0, twos = 0;
        // loop through all numbers in the array
        for (int i = 0; i < nums.length; i++) 
        {
           // getting the current element 
           int num = nums[i];
            // Update twos to keep track of bits that appeared twice
            // shorthand version of twos = twos | (ones & num);
            twos |= ones & num; 
           /* 
             
              Yes, you're correct! The expression `twos |= ones & num;` is shorthand for:  
               ```
               twos = twos | (ones & num);
               ```      
                Explanation:
               
               Let's break down this expression:
               
               1. `ones & num`:
                  - The `&` operator is a bitwise AND operator. It compares each bit of `ones` and `num`, 
                     and the result is a number where a bit is `1` only if both corresponding bits in `ones` and `num` are `1`.
                  - In other words, `ones & num` gives us a number with bits that are `1` in both `ones` and `num`.
               
               2. `twos | (ones & num)`:
                  - The `|` operator is a bitwise OR operator. It compares each bit of `twos` and `(ones & num)`. 
                     The result is a number where a bit is `1` if either of the bits in `twos` or `(ones & num)` is `1`.
                  - Essentially, this operation updates `twos` by adding the bits that are `1` in both `ones` and `num`.
               
               3. `twos |= ones & num;`:
                  - This is shorthand for updating `twos`. The `|=` operator means "bitwise OR and assign.
                     " It performs the bitwise OR operation between `twos` and `(ones & num)` and then assigns the result back to `twos`.
                  - So, this line updates `twos` to reflect the bits that have appeared exactly twice in the array so far.
               
                Why Is This Important?
                 In the context of the problem, `ones` and `twos` are used to track the bits of numbers that have appeared once and twice:
               - `ones` holds the bits that have appeared exactly once.
               - `twos` holds the bits that have appeared exactly twice.
               
               When we encounter a number (`num`), we update `twos` using `twos |= ones & num;`
               because this step helps track bits that are appearing for the second time in the array.
               
                Example Walkthrough:
               
               Let’s assume the following:
               - `ones = 0b0101` (which is `5` in decimal)
               - `num = 0b0011` (which is `3` in decimal)
               - `twos = 0b0001` (which is `1` in decimal)
               
               Now, let’s perform the operation `twos |= ones & num`:
               - `ones & num`: 
                 - `0b0101 & 0b0011 = 0b0001`
                 - This means that both `ones` and `num` have a `1` at the rightmost bit position, so the result is `0b0001`.
               
               - `twos |= 0b0001`: 
                 - `0b0001 | 0b0001 = 0b0001`
                 - Since both `twos` and the result of `ones & num` have a `1` in the same position, the result of the OR operation is still `0b0001`.
               
               - Final `twos`: `0b0001` (which is `1` in decimal).
               
               Thus, `twos` is updated to `1`, which tracks the bit that has appeared twice.
               
                Conclusion:
               
               In short, the `|=` operator combines the current value of `twos` with the new information from `ones & num`. 
               This is how we keep track of the bits that have appeared exactly twice while processing the array.
               
*/
           /* 
               The line `twos |= ones & num;` 
               is an important part of the bitwise manipulation technique used to solve this problem. 
               Let’s break down exactly what this line does, step by step.
               
               Understanding Bitwise Operators:
               Before diving into the specific line of code, it's important to understand the bitwise operators being used here:
               - `&` (bitwise AND): 
                   This operator compares the bits of two numbers and results in `1` only when both corresponding bits are `1`.
                   Otherwise, the result is `0`.
               - `|` (bitwise OR): 
                   This operator compares the bits of two numbers and results in `1` if at least one of the corresponding bits is `1`. 
                   Otherwise, the result is `0`.
               - `^` (bitwise XOR): 
                   This operator compares the bits of two numbers and results in `1` if the corresponding bits are different. 
                    If they are the same, the result is `0`.
               - `~` (bitwise NOT): 
                   This operator inverts all bits of a number, turning `1` to `0` and `0` to `1`.
               
               Breaking Down `twos |= ones & num;`:
               Let’s understand this line by going through it step by step. 
               This operation is done inside a loop for every number in the array, 
               so it happens repeatedly for each element.
               
               1. `ones & num`: 
                  - This operation performs a bitwise AND between the `ones` variable 
                     (which keeps track of the bits that have appeared exactly once so far) and the current number `num`.
                  - If a bit is set in both `ones` and `num` 
                    (i.e., both have a `1` at the same bit position), that bit will remain `1`. If not, it will be `0`.
               
               2. `twos |= ones & num`:
                  - This operation performs a bitwise OR between the `twos` variable 
                    (which keeps track of the bits that have appeared exactly twice so far) and the result of `one's & num`.
                  - The result of `ones & num` captures the bits that have appeared both once and the current number. 
                     So, these bits will be added (set to `1`) in `twos`.
                  - The `|=` operator means that we are updating `twos` with the new bits that we calculated. 
                     This operation ensures that we maintain all the bits that have appeared exactly twice.
               
               What this line is doing in context:
               - The goal of this algorithm is to track the bits of the numbers that appear exactly once and exactly twice, 
                  using the `ones` and `twos` variables.
               - After processing a number `num`, we update `twos` to keep track of the bits that have been encountered exactly twice so far. 
                  This is done by setting the corresponding bits in `two's` when those bits are present in both `ones` and `num`.
               - In other words, this line ensures that the `twos` variable reflects all the bits that have appeared twice up to that point.
               
               Example Walkthrough:
               Let's walk through this with a simple example to illustrate what happens at each step.
               Assume the `ones = 2` (which is `0010` in binary) and the current `num = 3` (which is `0011` in binary).
               
               1. `ones & num` will be `0010 & 0011 = 0010`. This means that the second bit (from the right) is set in both `ones` and `num`.
               2. Now, `twos |= ones & num` will perform:
                  - `twos |= 0010`, which means the second bit of `twos` will be set to `1` (if it wasn’t already).
                  - If `twos` was initially `0000`, it will now become `0010`.
               
               Why it Works:
               - The key idea is that:
                 - `ones` stores the bits that have appeared exactly once.
                 - `twos` stores the bits that have appeared exactly twice.
                 - By updating `twos` with `ones & num`, we keep track of the bits that are appearing for the second time. 
                  This is important for eliminating numbers that have appeared three times.
               
               After we’ve processed all the numbers in the array, 
               any bits that have appeared three times will be removed from both `ones` and `twos`. 
               The remaining bits in `ones` will represent the number that appeared only once.
               
               Final Thought:
               In the context of the entire solution, the operation `twos |= ones & num;`
               is a critical step that helps keep track of the bits that have been seen twice. 
               This allows us to eventually isolate the single element that appears only once, 
               using bitwise operations efficiently without extra space or complex counting.
                */
           
            // Update ones to keep track of bits that appeared once
           // shorthand version of ones = ones ^ num;
            ones ^= num;
            
            // Remove bits that appeared three times
            int threes = ones & twos;
            // shorthand version of ones = ones & (~threes);
            ones &= ~threes;
            // shorthand version of twos = twos & (~threes);
            twos &= ~threes;
        }
        
        // The result will be stored in the variable 'ones'
        return ones;
    }    
    public static void main(String[] args) 
  {
        FindSingleElement solution = new FindSingleElement();
        
        // Test the function with an example
        int[] nums = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums)); // Output: 3
    }
} 
    /* 
    Code walkthrough:
    1. We initialize two variables `ones` and `twos` to keep track of bits that appeared once and twice.
    2. We loop through each number in the array using a normal for loop and update the `ones` and `twos` variables accordingly.
    3. After each iteration, we calculate `threes` to identify bits that appeared three times and remove them from `ones` and `twos`.
    4. The final answer will be stored in `ones` because only the bits of the number that appeared once will remain there.
    
    Now let's apply this solution to the given example [2, 2, 3, 2]:
    - After processing 2, `ones` will store bits for the number 2.
    - After processing the second 2, `twos` will store bits for the number 2.
    - After processing 3, `ones` will store bits for the number 3.
    - The final value in `ones` will be 3, which is the lonely number.
    */

/* 
Time and Space Complexity Explanation:

Time Complexity:
- The solution loops through the array once, processing each number in constant time.
- Therefore, the time complexity is O(n), where n is the length of the array.

Space Complexity:
- We only use a constant amount of space, as the solution uses only a few integer variables (`ones`, `twos`, `threes`).
- Therefore, the space complexity is O(1).

*/

/* 
FOR loop walkthrough with every iteration with given input, 
Complete code walkthrough with applying the given input in code and explanation:
Let's go through the loop with the example [2, 2, 3, 2]:

1. Initial values:
   ones = 0, twos = 0

2. Iteration 1 (i = 0, num = 2):
   twos |= ones & num;  -> twos = 0
   ones ^= num;  -> ones = 2

3. Iteration 2 (i = 1, num = 2):
   twos |= ones & num;  -> twos = 2
   ones ^= num;  -> ones = 0

4. Iteration 3 (i = 2, num = 3):
   twos |= ones & num;  -> twos = 2
   ones ^= num;  -> ones = 3

5. Iteration 4 (i = 3, num = 2):
   twos |= ones & num;  -> twos = 2
   ones ^= num;  -> ones = 3

6. Final result:
   After the loop, the value in `ones` is 3, which is the number that appears only once.

Complete Code Walkthrough:
- The code keeps track of bits that appeared once and twice using the `ones` and `twos` variables.
- It correctly identifies the lonely number by eliminating the bits that appeared three times.
*/


