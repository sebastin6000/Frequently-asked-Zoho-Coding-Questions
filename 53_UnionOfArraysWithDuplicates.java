/*
Question:
Given two arrays a[] and b[], the task is to find the number of elements in the union between these two arrays.
The Union of the two arrays can be defined as the set containing distinct elements from both arrays. If there are repetitions, 
then only one element occurrence should be there in the union.

Examples:
1. Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3]
   Output: 5
   Explanation: 1, 2, 3, 4 and 5 are the elements which come in the union set of both arrays. So the count is 5.

2. Input: a[] = [85, 25, 1, 32, 54, 6], b[] = [85, 2]
   Output: 7
   Explanation: 85, 25, 1, 32, 54, 6, and 2 are the elements which come in the union set of both arrays. So the count is 7.

3. Input: a[] = [1, 2, 1, 1, 2], b[] = [2, 2, 1, 2, 1]
   Output: 2
   Explanation: We need to consider only distinct elements. So the count is 2.

Constraints:
1 ≤ a.size(), b.size() ≤ 10^6
0 ≤ a[i], b[i] < 10^5
*/

/*
Understanding the Problem Statement:
- We are given two arrays `a[]` and `b[]`, and we are tasked with finding the number of distinct elements in the union of both arrays.
- The union of the arrays should only include unique elements. If an element appears multiple times in one or both arrays, 
  it should only be counted once.

What is being asked:
- The task is to return the number of distinct elements in the union of the two arrays.
- Elements from both arrays need to be considered, but duplicates across arrays should only be counted once.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - We are given two arrays `a[]` and `b[]`, where both arrays consist of non-negative integers.

2. Expected Output:
   - The output should be an integer that represents the number of distinct elements in the union of the two arrays.

3. Output return type:
   - An integer representing the count of unique elements in the union of the two arrays.

4. Time complexity expectations:
   - The input arrays can have sizes up to 10^6, so the solution should be optimized to run in O(n) or O(n + m) time, 
     where n and m are the sizes of arrays `a[]` and `b[]`.

5. Constraints:
   - The arrays have sizes between 1 and 10^6.
   - The elements in the arrays are integers ranging from 0 to 100,000.
*/

 /*
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a problem related to finding the union of two sets. We need to count distinct elements from both arrays, without duplicates.
   - Using a data structure like a `HashSet` 
     is ideal since it only stores unique elements and allows O(1) average time complexity for insertions and lookups.

2. Destructuring:
   - We can insert all elements from both arrays into a hash set.
   - The size of the hash set at the end will give us the number of distinct elements in the union.

3. Conversational solution into smaller subtask:
   - Subtask 1: Create a `HashSet` to store the unique elements.
   - Subtask 2: Iterate over both arrays and add their elements to the set.
   - Subtask 3: After inserting all elements, the size of the set will give the number of distinct elements.
*/

 /*
Conversional Solution into Subtasks:
1. Create a hash set.
2. Iterate through both arrays and add their elements to the set.
3. The result will be the size of the hash set, which gives the number of distinct elements in the union of both arrays.
*/

/* 
Subtasks of Conversional Solution into Code:
1. Create an empty hash set to store unique elements.
2. Iterate through both arrays and add each element to the hash set.
3. The size of the set at the end is the answer, which is the number of unique elements in the union.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class UnionOfArrays {
    
    // Function to find the number of distinct elements in the union of two arrays
    public static int findUnion(int[] a, int[] b) {
        // Step 1: Create a hash set to store unique elements
        Set<Integer> uniqueElements = new HashSet<>();
        
        // Step 2: Add elements of array 'a' to the set
        for (int i = 0; i < a.length; i++) {
            uniqueElements.add(a[i]);
        }
        
        // Step 3: Add elements of array 'b' to the set
        for (int i = 0; i < b.length; i++) {
            uniqueElements.add(b[i]);
        }
        
        // Step 4: The size of the set gives the number of unique elements in the union
        return uniqueElements.size();
    }
    
    // Main function to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {1, 2, 3};
        System.out.println(findUnion(a1, b1));  // Expected output: 5

        // Test case 2
        int[] a2 = {85, 25, 1, 32, 54, 6};
        int[] b2 = {85, 2};
        System.out.println(findUnion(a2, b2));  // Expected output: 7

        // Test case 3
        int[] a3 = {1, 2, 1, 1, 2};
        int[] b3 = {2, 2, 1, 2, 1};
        System.out.println(findUnion(a3, b3));  // Expected output: 2
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Inserting elements from both arrays into the hash set takes O(n) for array `a` and O(m) for array `b`, where `n` and `m` are the lengths of the arrays.
  - Thus, the total time complexity is O(n + m), where n is the size of array `a` and m is the size of array `b`.

- Space Complexity:
  - The space complexity is O(n + m) since we are storing all the elements from both arrays in the hash set.

*/

/* 
Explanation of loops:
1. The first `for` loop iterates over array `a[]` and adds each element to the hash set `uniqueElements`.
   - In the first test case, it adds {1, 2, 3, 4, 5} to the set.
2. The second `for` loop iterates over array `b[]` and adds each element to the hash set.
   - In the first test case, it adds {1, 2, 3} to the set. Since the elements are already in the set, they are not added again.
3. The result is the size of the set, which gives the number of distinct elements in the union of the two arrays.

Example with input a = {1, 2, 3, 4, 5} and b = {1, 2, 3}:
1. After the first loop, `uniqueElements = {1, 2, 3, 4, 5}`.
2. After the second loop, `uniqueElements = {1, 2, 3, 4, 5}` (no new elements added).
3. The size of the set is 5, which is the number of distinct elements in the union.
Output: 5
*/

/* 
Complete code walkthrough with applying the given input in code and explanation:

For input:
a = {1, 2, 3, 4, 5}
b = {1, 2, 3}

1. After inserting elements of array `a[]`, the set `uniqueElements` becomes: {1, 2, 3, 4, 5}.
2. After inserting elements of array `b[]`, the set remains: {1, 2, 3, 4, 5} (no new elements added).
3. The size of the set is 5, so the output is 5.
Output: 5
*/
