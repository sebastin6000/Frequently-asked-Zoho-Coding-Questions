/* 
Question Section:
Given an unsorted integer array arr[], 
find the number of triangles that can be formed with three different array elements as the lengths of three sides of triangles.
A triangle with three given sides is only possible if the sum of any two sides is greater than the third side.

Examples:

Input: arr[] = [3, 5, 4]
Output: 1
Explanation: A triangle is possible with all the elements 5, 3, and 4 (5+3>4, 5+4>3, 3+4>5).

Input: arr[] = [6, 4, 9, 7, 8]
Output: 10
Explanation: There are 10 triangles possible with the given elements like (6, 4, 9), (6, 7, 8),...

Constraints:
3 <= arr.size() <= 10^3
1 <= arr[i] <= 10^3
*/

/* 
Understanding the Problem Statement:
- The problem involves finding the number of valid triangles that can be formed with the given sides.
- A valid triangle can be formed when the sum of the lengths of any two sides is greater than the third side (Triangle Inequality Theorem).
- We need to determine how many such valid triangles can be formed with three distinct sides from the given unsorted array.

What is being asked?
- We need to count the number of distinct triangles that can be formed from the given array where each triangle satisfies the triangle inequality condition.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A single array `arr` consisting of integers representing possible side lengths.

2. Expected Output:
   - A single integer representing the number of valid triangles that can be formed with three elements from the array.

3. Output return type:
   - Integer value (the count of valid triangles).

4. Explanation of Time complexity expectations:
   - We are expected to solve the problem efficiently, 
     likely with a time complexity of O(n^2) or O(n^3), given the constraints on array size (up to 1000 elements).

5. Explanation of given Constraints:
   - The array has a length between 3 and 1000, and each element is between 1 and 1000.
   - The approach must efficiently handle arrays of size up to 1000 while checking the triangle inequality conditions.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification:
   - The problem involves checking every combination of three distinct elements 
     and verifying if they can form a valid triangle using the triangle inequality theorem.

2. Destructuring:
   - A valid triangle requires three sides such that:
     - sum of any two sides > the third side.
   - This means for three sides `a`, `b`, and `c`, they form a valid triangle if:
     - a + b > c
     - a + c > b
     - b + c > a
     
3. Conversional solution into smaller subtask:
   - Subtask 1: Sort the array `arr[]` to simplify the checking of the triangle inequality.
   - Subtask 2: Iterate over all possible triplets of distinct elements in the array and check if they satisfy the triangle inequality.
   - Subtask 3: Count how many valid triangles can be formed and return that count.

*/

/* 
Conversional Solution into Subtasks:
1. Sort the array to make it easier to check the triangle inequality.
2. Use a triple nested loop to check all possible triplets of distinct elements in the array.
3. For each triplet, verify if they satisfy the triangle inequality theorem.
4. Count and return the number of valid triangles.

*/

 /* 
Subtasks of Conversional Solution into Code:
1. Sort the array `arr[]` in non-decreasing order.
2. Iterate through all triplets of elements in the array using three nested loops.
3. For each triplet, check the triangle inequality conditions.
4. If the conditions are met, increment the count of valid triangles.
5. Return the final count.

*/

public class TriangleCount {

    /* 
    Function to count the number of valid triangles that can be formed.
    This function sorts the array, then uses three nested loops to check every triplet of elements to see if they form a valid triangle.
    */
    public static int countTriangles(int[] arr) {
        // Step 1: Sort the array to make checking easier
        java.util.Arrays.sort(arr);
        
        int n = arr.length;
        int count = 0;
        
        // Step 2: Use three nested loops to check every triplet
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Step 3: Check the triangle inequality
                    if (arr[i] + arr[j] > arr[k] && arr[i] + arr[k] > arr[j] && arr[j] + arr[k] > arr[i]) {
                        count++;
                    }
                }
            }
        }
        
        // Step 4: Return the final count of valid triangles
        return count;
    }
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {3, 5, 4};
        System.out.println("Number of triangles: " + countTriangles(arr1)); // Expected output: 1
        
        // Test case 2
        int[] arr2 = {6, 4, 9, 7, 8};
        System.out.println("Number of triangles: " + countTriangles(arr2)); // Expected output: 10
    }
}

    /* 
    Time and Space Complexity Explanation:
    Time Complexity:
    - O(n^3), where `n` is the number of elements in the array. This is because we are checking all possible triplets using three nested loops.
    - Sorting the array takes O(n log n), but this is dominated by the O(n^3) complexity from the triple loop.
    
    Space Complexity:
    - O(1), since we only use a constant amount of extra space (apart from the input array).
    */

    /* 
    Code Walkthrough:
    Let's walk through the example `arr = [6, 4, 9, 7, 8]`:

    1. The array is sorted to become `[4, 6, 7, 8, 9]`.
    2. We check all triplets using three nested loops:
       - For `i = 0`, `j = 1`, `k = 2`, we check if the sum of the first two sides is greater than the third side, and so on for other triplets.
    3. After checking all the triplets, we count the valid ones.
    
    Output: `10` valid triangles.
    */

/*

### Explanation:

1. **`countTriangles(int[] arr)`**:
   - The function first sorts the array to simplify the triangle inequality check.
   - It then uses three nested loops to check every possible combination of three elements.
   - For each triplet, the function verifies if the sides satisfy the triangle inequality conditions (i.e., 
     the sum of any two sides must be greater than the third side).
   - If the condition holds true, the count is incremented.

2. **Time Complexity**:
   - Sorting the array takes \( O(n \log n) \).
   - The triple nested loops checking all triplets have a time complexity of \( O(n^3) \), where \( n \) is the length of the array.
   - Thus, the overall time complexity is \( O(n^3) \), which is feasible for \( n \) up to 1000.

3. **Space Complexity**:
   - The space complexity is \( O(1) \), apart from the input array.

### Example Walkthrough:

For the input `arr = [6, 4, 9, 7, 8]`:
1. After sorting, the array becomes `[4, 6, 7, 8, 9]`.
2. The valid triangles formed are:
   - (4, 6, 7), (4, 6, 8), (4, 6, 9), (4, 7, 8), (4, 7, 9), (4, 8, 9), (6, 7, 8), (6, 7, 9), (6, 8, 9), (7, 8, 9).
3. Thus, there are 10 valid triangles.

### Output:

For the given test cases:
1. `[3, 5, 4]` → Number of triangles: `1`.
2. `[6, 4, 9, 7, 8]` → Number of triangles: `10`.

*/
