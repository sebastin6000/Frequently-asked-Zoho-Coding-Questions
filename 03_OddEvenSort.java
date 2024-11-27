--------------------------------------------------- WITH TEMPLATE --------------------------------------------------------------------
/* 
Question:
Given an array arr[] of positive integers, your task is to sort the array such that:
1. The first part of the array contains odd numbers sorted in descending order.
2. The rest of the array contains even numbers sorted in ascending order.

Example 1:
Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]
Explanation: 7, 5, 3, 1 are odd numbers in descending order, and 2, 4, 10 are even numbers in ascending order.

Example 2:
Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
Output: [7, 5, 3, 1, 0, 2, 4]
Explanation: 7, 5, 3, 1 are odd numbers in descending order, and 0, 2, 4 are even numbers in ascending order.

Your Task:
Complete the function sortOddEven() 
that takes arr as input and returns the sorted array with odd numbers first (sorted in descending order) and even numbers second (sorted in ascending order).

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(1)

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^18
*/

/* 
Understanding the Problem Statement:
We need to rearrange the elements of the array such that all the odd numbers are grouped together at the start in descending order, 
and all the even numbers are grouped together at the end in ascending order.
The array should be sorted in a way where odd numbers are in descending order followed by even numbers in ascending order.

Extracting Information from the Problem Statement:
- Input: An array `arr[]` of positive integers.
- Expected Output: The array sorted with odd numbers in descending order followed by even numbers in ascending order.
- Time Complexity: O(n log n), where n is the size of the array.
- Space Complexity: O(1), we can do this in-place without using extra space.

Constraints:
- The size of the array can be up to 10^5.
- The integers can be as large as 10^18.

Thinking Solution for the Problem Statement:
1. Identify the odd and even numbers in the array.
2. Sort the odd numbers in descending order.
3. Sort the even numbers in ascending order.
4. Combine the sorted odd and even numbers into a single array.
5. Return the result.

Subtasks:
1. Extract odd numbers and even numbers from the array.
2. Sort odd numbers in descending order and even numbers in ascending order.
3. Merge the two sorted lists into the result array.

Subtasks of Conversional Solution into Code:
- **Extract odd and even numbers**: We can iterate through the array and separate the odd and even numbers.
- **Sort the numbers**: Use Java's built-in sorting functions to sort the odd and even numbers.
- **Combine the sorted arrays**: After sorting, we combine the two arrays (odd and even) into one.

Java Code according to Conversational Subtasks:

*/

import java.util.*;

public class StringTransformation {
  
    // Function to sort the odd and even numbers as per the requirement
    public static int[] sortOddEven(int[] arr) {
        // Lists to store odd and even numbers
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        
        // Step 1: Separate odd and even numbers
        for (int num : arr) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }
        
        // Step 2: Sort odd numbers in descending order
        Collections.sort(odds, Collections.reverseOrder());
        
        // Step 3: Sort even numbers in ascending order
        Collections.sort(evens);
        
        // Step 4: Combine the sorted odd and even numbers into the result
        int[] result = new int[arr.length];
        int i = 0;
        for (int odd : odds) {
            result[i++] = odd;
        }
        for (int even : evens) {
            result[i++] = even;
        }
        
        // Return the final sorted array
        return result;
    }
  
    // Main method to test the function
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, 5, 4, 7, 10};
        System.out.println(Arrays.toString(sortOddEven(arr1))); // Expected Output: [7, 5, 3, 1, 2, 4, 10]

        // Test Case 2
        int[] arr2 = {0, 4, 5, 3, 7, 2, 1};
        System.out.println(Arrays.toString(sortOddEven(arr2))); // Expected Output: [7, 5, 3, 1, 0, 2, 4]
    }
}

/*
Time and Space Complexity Explanation:
- **Time Complexity**: 
  - Separating odd and even numbers takes O(n), where n is the size of the array.
  - Sorting the odd numbers in descending order takes O(n log n).
  - Sorting the even numbers in ascending order also takes O(n log n).
  - Therefore, the total time complexity is O(n log n).
  
- **Space Complexity**: 
  - We use two lists (`odds` and `evens`) to store the odd and even numbers, which takes O(n) space.
  - The result array takes O(n) space as well, leading to a total space complexity of O(n).

Complete Code Walkthrough:
- First, we iterate through the array to separate odd and even numbers. We use two lists: `odds` for odd numbers and `evens` for even numbers.
- After that, we sort the `odds` list in descending order using `Collections.sort` with `Collections.reverseOrder()`, 
  and sort the `evens` list in ascending order using the default sorting behavior of `Collections.sort`.
- Finally, we combine the sorted odd and even numbers into the `result` array and return it.

Test Case 1:
- Input: [1, 2, 3, 5, 4, 7, 10]
- Odd numbers: [1, 3, 5, 7] (sorted in descending order: [7, 5, 3, 1])
- Even numbers: [2, 4, 10] (sorted in ascending order: [2, 4, 10])
- Combined result: [7, 5, 3, 1, 2, 4, 10]

Test Case 2:
- Input: [0, 4, 5, 3, 7, 2, 1]
- Odd numbers: [5, 3, 7, 1] (sorted in descending order: [7, 5, 3, 1])
- Even numbers: [0, 4, 2] (sorted in ascending order: [0, 2, 4])
- Combined result: [7, 5, 3, 1, 0, 2, 4]
*/ 

---------------------------------------------------- WITHOUT TEMPLATE -----------------------------------------------------------------
/* 
QUESTION:
Given an array arr[] of positive integers.
Your task is to sort them so that the first part of the array contains odd numbers sorted in descending order,
and the rest of the portion contains even numbers sorted in ascending order.

Examples:
Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]

Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
Output: [7, 5, 3, 1, 0, 2, 4]

Expected Time Complexity: O(n log n)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^18
*/

/* 
INPUT-OUTPUT EXPLANATION:
Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]
Explanation: The odd numbers (1, 3, 5, 7) are sorted in descending order, and the even numbers (2, 4, 10) are sorted in ascending order.

Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
Output: [7, 5, 3, 1, 0, 2, 4]
Explanation: The odd numbers (1, 3, 5, 7) are sorted in descending order, and the even numbers (0, 2, 4) are sorted in ascending order.
*/

/* 
CONSTRAINTS EXPLANATION:
- The input array has between 1 and 100,000 elements.
- Each element can be as large as 10^18, meaning we may have very large numbers to handle.
- We need to sort the odd numbers in descending order and even numbers in ascending order, so efficient sorting methods are required to meet the time complexity of O(n log n).
*/

/* 
RELATABLE ANALOGY OR REAL-WORLD SCENARIO: "Sorting Friends by Height in Odd and Even Positions"
Imagine you're organizing a set of friends into two lines:
1. One line for "odd-numbered" friends (i.e., odd positions), and another line for "even-numbered" friends (i.e., even positions).
2. However, the "odd-numbered" friends want to stand in a specific order: they want to be in the front in descending order of their height (tallest first).
3. The "even-numbered" friends are okay with standing in the back, but they want to be arranged in ascending order of height (shortest first).

Your job is to first gather all the odd-numbered friends,
sort them from tallest to shortest,
then gather all the even-numbered friends and sort them from shortest to tallest.
After sorting, you simply line them up: first the sorted odd-numbered friends, then the sorted even-numbered friends.

Step-by-step:
1. Identify the odd and even friends.
2. Sort the odd friends in descending order.
3. Sort the even friends in ascending order.
4. Combine the two groups together, with the odd friends first, followed by the even friends.
*/

/* 
RELATABLE ANALOGY JAVA CODE STEP BY STEP:
Step 1: Create two lists to hold odd and even numbers.
Step 2: Traverse the given array. For each number, if it’s odd, add it to the odd list; if it’s even, add it to the even list.
Step 3: Sort the odd list in descending order using a sorting method like Arrays.sort with a custom comparator.
Step 4: Sort the even list in ascending order using Arrays.sort.
Step 5: Concatenate both sorted lists, with the odd list first.
Step 6: Return the combined result.

Here’s the Java code that implements this approach:

*/

import java.util.ArrayList;
import java.util.List;

public class OddEvenSort {

    public static void main(String[] args) {
        // Example input
        long[] arr = {1, 2, 3, 5, 4, 7, 10};
        
        // Call the sorting method and get the result
        List<Long> sortedArray = sortOddEven(arr);
        
        // Print the result as the final sorted array
        System.out.println(sortedArray);  // Output: [7, 5, 3, 1, 2, 4, 10]
    }

    // Method that sorts the array with odd numbers in descending order and even numbers in ascending order
    public static List<Long> sortOddEven(long[] arr) {
        // Step 1: Create two separate lists for odd and even numbers
        ArrayList<Long> oddList = new ArrayList<>();
        ArrayList<Long> evenList = new ArrayList<>();
        
        // Step 2: Traverse the array using a normal for loop and classify numbers as odd or even
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddList.add(arr[i]);  // Odd numbers go into oddList
            } else {
                evenList.add(arr[i]);  // Even numbers go into evenList
            }
        }
        
        // Step 3: Sort the oddList in descending order
        oddList.sort((a, b) -> Long.compare(b, a));  // Sort by descending order
        /* 
            Let's break down the code `oddList.sort((a, b) -> Long.compare(b, a));`
            in detail, using the provided sample input.

            The `sort()` method is being applied to an `ArrayList<Long>` called `oddList`.
            The sorting uses a **lambda expression** `(a, b) -> Long.compare(b, a)` which is acting as a **custom comparator**. 
            
            The purpose of this line is to sort the `oddList` in descending order**. 
            
            Here’s how it works step by step:
            1. Lambda Expression: `(a, b) -> Long.compare(b, a)`
               - `a` and `b`: These are two elements from the `oddList` that will be compared against each other.
               - `Long.compare(b, a)`: This is a method that compares two `long` values.
                 - It compares `b` to `a` (in reverse order compared to the default ascending order), which will result in a descending sort (larger values first).
                 - `Long.compare(b, a)` returns:
                   - Negative value if `b < a` (meaning `b` should appear before `a`).
                   - Positive value if `b > a` (meaning `b` should appear after `a`).
                   - Zero if both are equal (no change in order).
                 
               So, this line is saying "compare `b` to `a` in reverse order," which results in a descending sort.
            
            Let's use the sample input `arr[] = {1, 2, 3, 5, 4, 7, 10}`.
            
            - We will first separate the odd and even numbers. 
            - **Odd numbers** from the array are: `[1, 3, 5, 7]`.
            - **Even numbers** from the array are: `[2, 4, 10]`.
            
            oddList = [1, 3, 5, 7]
            Step-by-step sorting using `Long.compare(b, a)`:
            
            1. **Initial List**: `[1, 3, 5, 7]`.
            
            2. **Comparison (Step 1)**: First, the algorithm compares `1` and `3`:
               - Compare `b = 3` and `a = 1`: Since `3 > 1`, the result is positive, so `3` should come before `1`.
            
            3. **Comparison (Step 2)**: Next, the algorithm compares `1` and `5`:
               - Compare `b = 5` and `a = 1`: Since `5 > 1`, the result is positive, so `5` should come before `1`.
            
            4. **Comparison (Step 3)**: Next, the algorithm compares `1` and `7`:
               - Compare `b = 7` and `a = 1`: Since `7 > 1`, the result is positive, so `7` should come before `1`.
            
               So far, the result list is `[7, 5, 3, 1]`.
            
            At this point, the sorting algorithm has completed sorting the `oddList` in descending order. The final `oddList` after sorting is:
            
            oddList = [7, 5, 3, 1]
            
            ### Summary of the Sorting Mechanism:
            - The comparator `Long.compare(b, a)` compares each pair of elements in reverse order, resulting in a descending order sort.
            - The odd numbers are sorted from highest to lowest: `[7, 5, 3, 1]`.
            
            ### Full Code Context:
            
            The final sorted `oddList` (after the above sorting) will be:
            
            ```
            oddList = [7, 5, 3, 1]
            ```
            
            And, when combined with the even numbers (`[2, 4, 10]` sorted in ascending order), the final result will be:
            
            ```
            final result = [7, 5, 3, 1, 2, 4, 10]
            ```
            
            ### Recap:
            - The `oddList.sort((a, b) -> Long.compare(b, a));` sorts the odd numbers in **descending order** by reversing the usual order of comparison.
            - It ensures the largest odd number comes first, followed by the next largest, and so on.
            */
        
        // Step 4: Sort the evenList in ascending order
        evenList.sort(Long::compareTo);  // Sort by ascending order
        /* 
         Sure! Let's break down the code `evenList.sort(Long::compareTo);` step-by-step with the given input.
        
         Code Explanation:
        - `evenList` is an `ArrayList<Long>` that contains even numbers from the input array.
        - `sort(Long::compareTo)` is a method call that sorts `evenList` in ascending order. 
        
        Let's look at how this works:
        1. `Long::compareTo`:
           - `Long::compareTo` is a method reference that refers to the `compareTo` method of the `Long` class.
           - The `compareTo` method is used to compare two `Long` values.
             
           - The method returns:
             - Negative value if the current `Long` is less than the argument.
             - Zero if both `Long` values are equal.
             - Positive value if the current `Long` is greater than the argument.
        
        2. `sort(Long::compareTo)`:
           - This uses the `compareTo` method to compare the elements in `evenList`.
           - The default behaviour of `compareTo` sorts numbers in ascending order (smallest to largest).
           
        So, `evenList.sort(Long::compareTo)` sorts the list in ascending order using `compareTo` for the comparison of `Long` values.
        Let’s use the provided sample input : arr[] = {1, 2, 3, 5, 4, 7, 10}
        - We first separate the even numbers from the array: `[2, 4, 10]`.
        
        So, initially : evenList = [2, 4, 10]
        Step-by-Step Sorting:
        Now, let's apply the `sort(Long::compareTo)` on the `evenList`.
        
        1. Initial List: evenList = [2, 4, 10]
        2. Comparison of 2 and 4:
           - `compareTo(4)` compares `2` and `4`.
           - Since `2 < 4`, the result will be negative (i.e., `2` should come before `4`).
        
        3. Comparison of 4 and 10:
           - `compareTo(10)` compares `4` and `10`.
           - Since `4 < 10`, the result will be negative (i.e., `4` should come before `10`).
        
        So, after sorting, the list `evenList` becomes: evenList = [2, 4, 10]
        
        Final Result:
        The `evenList` is now sorted in ascending order
        (which, in this case, is the same as the original order because the numbers were already in ascending order).
        
        The final sorted `evenList` is : evenList = [2, 4, 10]
        
        Full Code Context:
        After sorting the odd numbers in descending order and the even numbers in ascending order,
         the final result is:
        - Sorted odd numbers: `[7, 5, 3, 1]`
        - Sorted even numbers: `[2, 4, 10]`
        
        Now, when you combine the two lists (odd numbers first, followed by even numbers), the final result will be:
        result = [7, 5, 3, 1, 2, 4, 10].
        */
        
        // Step 5: Combine both lists (oddList first, then evenList)
        ArrayList<Long> result = new ArrayList<>();
        result.addAll(oddList);
        result.addAll(evenList);
        
        // Return the combined result
        return result;
    }
}


/* 
TIME AND SPACE COMPLEXITY EXPLANATION:
- Time Complexity: O(n log n), where n is the number of elements in the input array. This is because we perform two sorts:
  - Sorting the odd list: O(n log n) in the worst case.
  - Sorting the even list: O(n log n) in the worst case.
- Space Complexity: O(n), because we use two additional lists (oddList and evenList) to store the odd and even numbers. This space is proportional to the size of the input array.

In the real-world analogy, you are sorting two groups of friends (odd and even), and the time complexity reflects how long it takes to organize each group, while the space complexity reflects the memory used to store the two groups temporarily.
*/

/* 
FOR LOOP WALKTHROUGH WITH EACH ITERATION:
Input: arr[] = {1, 2, 3, 5, 4, 7, 10}
- We will classify numbers as odd or even and add them to the respective lists.
1st iteration: arr[0] = 1, which is odd, so it goes into oddList.
2nd iteration: arr[1] = 2, which is even, so it goes into evenList.
3rd iteration: arr[2] = 3, which is odd, so it goes into oddList.
4th iteration: arr[3] = 5, which is odd, so it goes into oddList.
5th iteration: arr[4] = 4, which is even, so it goes into evenList.
6th iteration: arr[5] = 7, which is odd, so it goes into oddList.
7th iteration: arr[6] = 10, which is even, so it goes into evenList.

After the loop:
oddList = [1, 3, 5, 7]
evenList = [2, 4, 10]

Next, we will sort the lists:
oddList after sorting in descending order = [7, 5, 3, 1]
evenList after sorting in ascending order = [2, 4, 10]

Finally, we combine the lists:
result = [7, 5, 3, 1, 2, 4, 10]

Complete code walkthrough:
- The `for` loop divides the array into two categories: odd and even.
- After classifying, we sort the odd list in descending order and the even list in ascending order.
- Finally, we concatenate the sorted odd and even lists to get the desired result.
*/

/* 
COMPLETE CODE WALKTHROUGH WITH APPLYING THE GIVEN INPUT:

Here’s the code to solve the problem step by step with the given input:

import java.util.Arrays;
import java.util.ArrayList;

public class OddEvenSort {
    public static void main(String[] args) {
        // Example input
        long[] arr = {1, 2, 3, 5, 4, 7, 10};
        
        // Step 1: Create two separate lists for odd and even numbers
        ArrayList<Long> oddList = new ArrayList<>();
        ArrayList<Long> evenList = new ArrayList<>();
        
        // Step 2: Traverse the array and classify numbers as odd or even
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddList.add(arr[i]);  // Odd numbers go into oddList
            } else {
                evenList.add(arr[i]);  // Even numbers go into evenList
            }
        }
        
        // Step 3: Sort the oddList in descending order
        oddList.sort((a, b) -> Long.compare(b, a));  // Sort by descending order
        
        // Step 4: Sort the evenList in ascending order
        evenList.sort(Long::compareTo);  // Sort by ascending order
        
        // Step 5: Combine both lists (oddList first, then evenList)
        ArrayList<Long> result = new ArrayList<>();
        result.addAll(oddList);
        result.addAll(evenList);
        
        // Step 6: Print the result as the final sorted array
        System.out.println(result);
    }
}
*/
