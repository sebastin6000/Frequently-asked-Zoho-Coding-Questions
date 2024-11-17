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
