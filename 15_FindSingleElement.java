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

public class FindSingleElement 
{
    /*
    We're using bitwise operators to keep track of bits that appeared once and twice.
    */
    public int singleNumber(int[] nums) 
     {
        int ones = 0, twos = 0;
        
        // Normal for loop to loop through all numbers in the array
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
FOR loop walkthrough with every iteration with given input, Complete code walkthrough with applying the given input in code and explanation:
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


