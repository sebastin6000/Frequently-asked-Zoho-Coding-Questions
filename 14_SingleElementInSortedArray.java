--------------------------------------------------- WITH TEMPLATE --------------------------------------------------------------------
/* 
Question Section:
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Examples:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
*/

/* 
Understanding the Problem Statement:
- We are given a sorted array where all elements except one appear exactly twice. Our task is to identify the element that appears only once.
- The array is sorted, which is a crucial detail that allows us to optimize our solution.
- We must solve this in O(log n) time complexity, which suggests that a binary search approach could be an appropriate solution.
- We are also required to use O(1) space, meaning no extra space should be used beyond a few variables.

What is being asked?
- We need to find the element that appears only once in a sorted array of integers, where all other elements appear exactly twice.
- We need to do this in O(log n) time and O(1) space.
*/

 /* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A sorted array of integers `nums[]`.
2. Expected Output:
   - A single integer, the one element that appears only once in the array.
3. Output return type:
   - An integer that represents the element that appears exactly once.
4. Explanation of Time complexity expectations:
   - The solution must run in O(log n) time, which typically suggests using a binary search approach.
5. Explanation of given Constraints:
   - The size of the array can be as large as 10^5, so the solution must be efficient, 
     especially considering the time complexity constraint of O(log n).
*/

 /* 
Thinking Solution for the Problem Statement:
1. Identification:
   - The array is sorted, and all elements except one appear exactly twice.
   - The property of the sorted array allows us to apply binary search to solve this problem in O(log n) time.
   
2. Destructuring:
   - We need to identify a pattern where, when the array is divided into two halves, 
     the element that appears only once will disrupt the paired pattern.
   - If the number of elements in the left half is even, then the single element must be in the right half (or vice versa). 
     This is the key observation that allows us to use binary search.

3. Conversional solution into smaller subtask:
   - Subtask 1: Use binary search to divide the array into two halves.
   - Subtask 2: Check the pattern of the elements to determine which half contains the single element.
   - Subtask 3: Continue the binary search on the half where the single element is located, until the result is found.

*/

 /* 
Conversional Solution into Subtasks:
1. Start by performing a binary search on the sorted array.
2. For each mid-point, check if the element at the mid-point forms a pair with its neighbor.
3. If the mid element forms a pair with the next or previous element, 
   adjust the search range to the half where the anomaly (the single element) is located.
4. Continue halving the search space until the single element is found.

*/

 /* 
Subtasks of Conversional Solution into Code:
1. Initialize two pointers: `low` at the start of the array and `high` at the end.
2. Perform a binary search: Find the middle element and check the pairing with its neighbors.
3. If the pair is correct, move the search range accordingly.
4. If the pair is broken, the single element is in that part of the array.
5. Repeat until the single element is identified.

*/

public class SingleElementInSortedArray {

    /* 
    Function to find the single element in a sorted array where every element appears twice except one.
    We use binary search to find the element in O(log n) time.
    */
    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Ensure mid is always pointing to the first element in the pair
            if (mid % 2 == 1) {
                mid--;  // Make mid even, so that mid and mid+1 are a pair
            }
            
            // Compare pairs: if mid and mid+1 are equal, the single element is in the right half
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;  // Discard left half
            } else {
                high = mid;  // The single element is in the left half
            }
        }
        
        // When the loop ends, low == high and points to the single element
        return nums[low];
    }
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Single element: " + singleNonDuplicate(nums1)); // Expected output: 2
        
        // Test case 2
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println("Single element: " + singleNonDuplicate(nums2)); // Expected output: 10
        
        // Test case 3
        int[] nums3 = {1, 2, 2};
        System.out.println("Single element: " + singleNonDuplicate(nums3)); // Expected output: 1
    }
}

    /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - O(log n), where n is the size of the array. This is because we are performing a binary search, which halves the search space at each step.
    
    Space Complexity:
    - O(1), because we are using only a constant amount of space (no additional arrays or data structures are used).
    */

    /* 
    Code Walkthrough:
    Let's walk through the example `nums = [1,1,2,3,3,4,4,8,8]`:

    - Initial pointers: `low = 0`, `high = 8`.
    - First iteration:
      - `mid = (0 + 8) / 2 = 4`.
      - Since `mid` is even, we check if `nums[4] == nums[5]` (i.e., `3 == 3`).
      - Since they are equal, we move `low = mid + 2 = 6`.
    
    - Second iteration:
      - `low = 6`, `high = 8`, so `mid = 7`.
      - Since `mid` is odd, we adjust `mid = 6`.
      - Now, we check if `nums[6] == nums[7]` (i.e., `4 == 8`), which is false.
      - Since they are not equal, we move `high = mid = 6`.
    
    - The loop ends with `low == high == 2`, so the single element is `nums[2] = 2`.

    Output: `2`
    */
/*

### Explanation:

1. **`singleNonDuplicate(int[] nums)`**:
   - This function uses binary search to find the single element. 
     The idea is to exploit the fact that the array is sorted and that all elements except one are paired. 
     By checking whether the middle element is paired with the next or previous element, 
     we can decide whether the single element lies in the left half or the right half of the array.
   
2. **Binary Search**:
   - In each iteration of the binary search, we check whether the middle element is paired with its neighbor. 
     If the pair is valid, we discard the left half of the array; otherwise, we discard the right half. 
     This continues until we narrow down the search to a single element.
   
3. **Time and Space Complexity**:
   - **Time Complexity**: O(log n) due to the binary search, which reduces the problem size by half at each step.
   - **Space Complexity**: O(1), as we only use a constant amount of space for the variables `low`, `high`, and `mid`.

4. **Code Walkthrough**:
   - The example `nums = [1,1,2,3,3,4,4,8,8]` 
     illustrates how the binary search works by progressively halving the search space based on whether the middle element is paired or not.

*/
--------------------------------------------------- WITHOUT TEMPLATE --------------------------------------------------------------------
/* 
Question: 

You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

*/

 /* 
Input-output explanation section:

The input is an array where every number except one occurs twice. 
The task is to find that one number that appears only once. 
The solution should return the number that appears once. 
For example:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Explanation: All numbers except 2 appear twice. So, 2 is the single element.

*/

 /* 
Constraints explanation section:

1 <= nums.length <= 10^5 : The number of elements in the array can be very large, up to 100,000 elements.
0 <= nums[i] <= 10^5 : The elements in the array are integers between 0 and 100,000.
We need to find a way to solve the problem efficiently due to the large input size.

*/

 /* 
Relatable analogy or real-world scenario section:

Imagine you are at a party with a group of people. Every person has a twin, 
and the twins are always standing next to each other, chatting. 
But there is one person in the room who is not paired with anyone – they are standing alone, chatting by themselves. 
Your task is to find this one lonely person who doesn't have a twin.

Now, imagine the party is organized in a line, and everyone is sorted by height. 
You can quickly scan the room from left to right and identify the lonely person by observing the pattern. 
If you look at every pair of people, you'll see that if they are standing together, their heights match. 
The person without a twin is the one whose height does not match the person standing next to them.

You want to find that lonely person, 
and you're allowed to use a clever trick: because the party is sorted (in this case, by height), 
you can use a "binary search" strategy to quickly find the one who is alone, without having to check everyone one by one.

So, just like in a party, if you divide the room in half, 
you'll notice that the lonely person will always be in the half where the pairing rule is broken. 
This can help you find them much faster than checking each person individually.

*/

 /* 
Relatable analogy Java code step by step section:

Now, let’s use this analogy in code. We're going to apply binary search to find the lonely person.
[Binary Seatch](https://youtu.be/jYH43Z13GvU?si=CTD9-v0j80Q8htTq)
https://youtu.be/xrMppTpoqdw?si=pdw8Wgq25_eM2OT-
https://youtu.be/eVuPCG5eIr4?si=PAvV92g4ugHAw6je
https://youtu.be/NFhOrxtXXcM?si=-jiIHrvyK9qItdQE

1. We'll start by checking the middle of the list.
2. If the middle number is paired with the number next to it (either to the left or right), 
   the lonely person must be on the other side of the array,  
   because the pairs are broken at one point, and that’s where the single element resides.
3. If the middle number is not paired correctly, we know the lonely person is in the half where the pattern is broken.

Here’s the step-by-step breakdown in code:

Step 1: Initialize pointers. We start with two pointers: left = 0 and right = nums.length - 1 (these represent the ends of the array).
Step 2: Perform binary search. We calculate the middle index (mid) and check if mid is the lonely number.
Step 3: Narrow down the search based on whether we find a pair or not.

*/

 /* 
Time and Space Complexity Explanation and this section has to be inside this structure of comments:

Time Complexity:
- We are using binary search, which splits the array in half at each step. 
  Since we are halving the search space each time, the time complexity is O(log n), 
  where n is the number of elements in the array.

Space Complexity:
- We are only using a few variables (left, right, mid), 
  so we are not using any additional memory that grows with the input size. Thus, the space complexity is O(1).

*/

 /* 
FOR loop walkthrough with every iteration with given input, 
Here’s how the loop works, step by step:

1. Initial array: nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]
2. Initialize left = 0, right = 8 (start and end of the array).
3. First iteration: Mid = (0 + 8) / 2 = 4 (index). Check if nums[4] is correctly paired with nums[5].
     nums[4] = 3, nums[5] = 3. They are paired, so the lonely number must be on the left side of the array.
4. Update the right pointer: Now set right = mid - 1 = 3.
5. Second iteration: Mid = (0 + 3) / 2 = 1. Check if nums[1] is paired with nums[2]. 
     nums[1] = 1, nums[2] = 2. They are not paired, so the lonely number must be at index 2.
6. Return result: The lonely number is nums[2] = 2.

By splitting the array and narrowing the search, we found the lonely number in O(log n) time.

*/

 /* 
Complete code walkthrough with applying the given input in code and explanation has to in simple English:

Here is the complete solution:

*/
// WITHOUT EXPLANATION

import java.util.*;

public class SingleElementInSortedArray 
{

    // Function to find the single element
    public int singleNonDuplicate(int[] nums) 
  {
        // Initialize the left and right pointers
        int left = 0, right = nums.length - 1;

        // Use binary search to find the single element
        while (left < right) 
        {
            // Calculate the mid index
            int mid = left + (right - left) / 2;
            
            // Check if the mid element is odd or even 
            // if its odd means we will goes into this condition
            if (mid % 2 == 1) 
            {
                mid--; // Ensure mid is even
            }

            // Check if the pair is valid
            if (nums[mid] == nums[mid + 1]) 
            {
                // If the pair is valid, the lonely element is in the right half
                left = mid + 2;
            } else 
            {
                // If the pair is invalid, the lonely element is in the left half
                right = mid;
            }
        }

        // The single element is found when left == right
        return nums[left];
    }

    // Main method to test the function
    public static void main(String[] args) 
    {
        // Initialize the input array
        SingleElementInSortedArray solution = new SingleElementInSortedArray();
        
        // Test cases
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(solution.singleNonDuplicate(nums1)); // Output: 2

        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(solution.singleNonDuplicate(nums2)); // Output: 10
    }
}
-----------------------------------------
// WITH EXPLANATION
  import java.util.*;

public class SingleElementInSortedArray 
{

    // Function to find the single element
    public int singleNonDuplicate(int[] nums) 
  {
        // Initialize the left and right pointers
        int left = 0, right = nums.length - 1;

        // Use binary search to find the single element
        while (left < right) 
        {
            // Calculate the mid index
            int mid = left + (right - left) / 2;

            // Check if the mid element is odd or even 
            // if its odd means we will goes into this condition
            if (mid % 2 == 1) 
            {
                mid--; 
                /* 
               The condition mid % 2 == 1 checks if the index is odd, 
               not the value at nums[mid]. In your example  int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
               the index mid = 4 refers to the 4th element, which is 3. The value 3 is odd, 
               but what we're actually checking is whether the index itself (mid) is odd.
               */ 
            }

            // Check if the pair is valid
            if (nums[mid] == nums[mid + 1]) 
            {
                // If the pair is valid, the lonely element is in the right half
                left = mid + 2;
            } else 
            {
                // If the pair is invalid, the lonely element is in the left half
                right = mid;
            }
              /* 
              Sure! Let's walk through the execution of your singleNonDuplicate function with the input nums = [1, 1, 2, 3, 3, 4, 4, 8, 8] step-by-step. 
              We will show how the binary search loop works, and how the left, right, and mid pointers change at each iteration.
              Input: nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]
              
              Initial Setup:
              left = 0
              right = nums.length - 1 = 8 (the last index)
              
              1st Iteration:
              Step 1: Initial values:
              left = 0
              right = 8
              
              Step 2: Calculate mid:
              mid = left + (right - left) / 2 = 0 + (8 - 0) / 2 = 4
              
              Step 3: Check if mid is odd:
              mid % 2 == 1 is false (since mid = 4, which is even), so no adjustment to mid is made.
              
              Step 4: Check if the pair is valid:
              nums[mid] == nums[mid + 1]: nums[4] == nums[5] is 3 == 4, which is false.
              
              Step 5: Update right:
              Since the pair is not valid, we update right to mid.
              right = 4
              End of 1st iteration:
              left = 0, right = 4
              ---------------------------------------------------------------
              2nd Iteration:
              Step 1: Initial values:
              left = 0
              right = 4
              
              Step 2: Calculate mid:
              mid = left + (right - left) / 2 = 0 + (4 - 0) / 2 = 2
              
              Step 3: Check if mid is odd:
              mid % 2 == 1 is false (since mid = 2, which is even), so no adjustment to mid is made.
              
              Step 4: Check if the pair is valid:
              nums[mid] == nums[mid + 1]: nums[2] == nums[3] is 2 == 3, which is false.
              
              Step 5: Update right:
              Since the pair is not valid, we update right to mid.
              right = 2
              End of 2nd iteration:
              left = 0, right = 2
              --------------------------------------------------------------
              3rd Iteration:
              Step 1: Initial values:
              left = 0
              right = 2
              
              Step 2: Calculate mid:
              mid = left + (right - left) / 2 = 0 + (2 - 0) / 2 = 1
              
              Step 3: Check if mid is odd:
              mid % 2 == 1 is true (since mid = 1, which is odd), so we adjust mid to mid--.
              mid = 0
              
              Step 4: Check if the pair is valid:
              nums[mid] == nums[mid + 1]: nums[0] == nums[1] is 1 == 1, which is true.
              
              Step 5: Update left:
              Since the pair is valid, the lonely element is in the right half. We update left to mid + 2.
              left = 2
              End of 3rd iteration:
              left = 2, right = 2
              ------------------------------------------
              Final Step:
              The while loop exits because left == right.
              We return nums[left], which is nums[2] = 2.
              Final Result:
              The unique element is 2.
              Summary of the Iterations:
              1st Iteration: left = 0, right = 8, mid = 4, right = 4
              2nd Iteration: left = 0, right = 4, mid = 2, right = 2
              3rd Iteration: left = 0, right = 2, mid = 1, left = 2
              Result: The unique element is 2.
              This binary search approach efficiently narrows down the range to find the single non-duplicate element in the sorted array in O(log n) time.
          */ 
        }

        // The single element is found when left == right
        return nums[left];
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Initialize the input array
        SingleElementInSortedArray solution = new SingleElementInSortedArray();
        
        // Test cases
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(solution.singleNonDuplicate(nums1)); // Output: 2

        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(solution.singleNonDuplicate(nums2)); // Output: 10
    }
}
 /* 
Explanation of the code:

- The method `singleNonDuplicate()` implements the binary search approach to find the unique number in the sorted array.
- We use two pointers `left` and `right` to track the current search range.
- At each iteration, we calculate the `mid` index. We adjust `mid` to ensure it's even (since we want to compare pairs), 
  then check if the pair is valid. If it's valid, the lonely number must be in the right half; otherwise, it's in the left half.
- The loop continues until `left == right`, at which point we return the number at `nums[left]`, which is the single number.

*/



