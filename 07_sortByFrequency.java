/* 
Question:
Given an array A[] of integers, sort the array according to the frequency of elements. 
That is, elements with higher frequency should come first. If two elements have the same frequency, the smaller number should come first.

Input:
- The first line of input contains an integer T, denoting the number of test cases. The description of T test cases follows.
- The first line of each test case contains a single integer N, denoting the size of the array.
- The second line contains N space-separated integers A1, A2, ..., AN, denoting the elements of the array.

Output:
For each test case, print the sorted array on a new line. In each array, the numbers should be separated by a space.

Constraints:
1 ≤ T ≤ 70
1 ≤ N ≤ 130
1 ≤ Ai ≤ 60

Example:

Input:
2
5
5 5 4 6 4
5
9 9 9 2 5

Output:
4 4 5 5 6
9 9 9 2 5

Explanation:
Testcase 1:
- 5 and 4 both appear twice, but since 4 is smaller than 5, 4 should appear first. The final sorted array is: 4 4 5 5 6.
Testcase 2:
- 9 appears 3 times, so it comes first. Both 2 and 5 appear once, so the smaller one (2) comes before 5. The final sorted array is: 9 9 9 2 5.
*/

/* 
Understanding the Problem Statement:
The goal is to sort an array of integers based on their frequency of occurrence. 
If two numbers have the same frequency, the smaller number should appear first. This task should be repeated for each test case.

What is being asked?
We need to sort arrays of integers by frequency, and in case of a tie in frequency, by value.

The input consists of multiple test cases, and for each test case, we are given a size of an array and the array elements. 
The output for each test case should be the sorted array.

*/

/* 
Extracting Information from the Problem Statement:
- Input data type: The input consists of integers in an array for each test case.
- Expected Output: The output should be a sorted array where elements are sorted by frequency, and in case of ties, by value.
- Output return data type: The output is a space-separated list of integers in sorted order for each test case.
- Constraints:
  - There can be multiple test cases (T up to 70).
  - The length of each array (N) can go up to 130.
  - The elements in the array are between 1 and 60.

*/

/* 
Thinking Solution for the Problem Statement:
1. We need to determine the frequency of each element in the array.
2. After determining the frequency, 
   we need to sort the array first by frequency (in descending order), and in case of ties, by the element value (in ascending order).
3. We will use a `HashMap` to store the frequency of each element.
4. The sorted array can be derived by creating a list of pairs (element, frequency), 
   sorting by frequency and then by element value if frequencies are the same.
5. The final result should be the array printed in the required order for each test case.

*/

/* 
Input to Output Conversion Steps into Smaller Subtasks:
S.No | Subtask Description
1    | Calculate the frequency of each element in the array.
2    | Sort the elements based on frequency, and if frequencies are the same, by value.
3    | Print the sorted array in the specified format.

*/

/* 
Input to Output Conversion Subtasks into Code:
S.No | Subtask Description                                    | Code Approach
1    | Calculate the frequency of each element.               | Use a HashMap to store the frequency of each element in the array.
2    | Sort the elements based on frequency, and if needed, by value. | Use a Comparator to sort by frequency (descending) and by value (ascending).
3    | Print the sorted array.                                | Iterate through the sorted list and print the elements in the required order.

*/

/* 
Code Requirement to Complete the Subtasks:
- A loop to iterate through the array and calculate frequencies.
- A data structure (`HashMap`) to store frequencies.
- A sorting mechanism using a custom comparator to sort by frequency and value.
- A final loop to print the sorted elements.

*/

/* 
Java Code According to Conversational Subtasks:
*/

import java.util.*;

public class SortArrayByFrequency {
    
    /* 
    Explanation of Approach:
    1. First, we define the inputs directly in the code (no user input).
    2. For each test case, we calculate the frequency of each element in the array using a `HashMap`.
    3. After calculating the frequencies, we sort the elements based on two criteria: 
       - First by frequency in descending order.
       - If frequencies are the same, by element value in ascending order.
    4. We print the sorted array for each test case.

    */

    // Function to sort array by frequency and value
    public static void sortByFrequency(int[] arr) {
        // Step 1: Calculate frequencies using a HashMap
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert map to a list of pairs (element, frequency)
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());

        // Step 3: Sort the list by frequency (desc) and by value (asc)
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // First compare by frequency in descending order
                if (o2.getValue().equals(o1.getValue())) {
                    // If frequencies are the same, compare by element value in ascending order
                    return Integer.compare(o1.getKey(), o2.getKey());
                }
                // Otherwise, compare by frequency in descending order
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        // Step 4: Print the sorted array
        for (Map.Entry<Integer, Integer> entry : list) {
            // Print the element entry.getValue() times
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }

    // Main function to test the code with predefined inputs
    public static void main(String[] args) {
        
        // Test cases
        int[][] testCases = {
            {5, 5, 4, 6, 4},  // Test case 1
            {9, 9, 9, 2, 5}   // Test case 2
        };
        
        // Process each test case
        for (int[] arr : testCases) {
            // Sort the array by frequency and print the result
            sortByFrequency(arr);
            System.out.println();  // Print a new line after each test case
        }
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity:
  - Calculating the frequency of elements using the `HashMap` takes O(N), where N is the size of the array.
  - Sorting the frequency list takes O(M log M), where M is the number of distinct elements in the array. In the worst case,
    M = N, so the time complexity for sorting is O(N log N).
  - Overall, the time complexity for each test case is O(N log N).
  
- Space Complexity:
  - We use O(N) space for storing the frequency map and the list of entries. Therefore, the space complexity is O(N).
*/

/* 
Explanation of "for" and "while" loops used in the code:
- The first loop in the `main` function processes each test case, calling `sortByFrequency` and printing the sorted result.
- The `for` loop inside the `sortByFrequency` method iterates through the frequency list and prints the sorted elements.
- The nested `for` loop inside the `sortByFrequency` method prints each element as many times as its frequency.

Iterations for input `5 5 4 6 4`:
- Frequency map: {5=2, 4=2, 6=1}
- Sorted list: [(4, 2), (5, 2), (6, 1)]
- Output: "4 4 5 5 6"

*/

/* 
Complete Code Walkthrough with Applying Given Input:
For input:
2
5
5 5 4 6 4
5
9 9 9 2 5

Test Case 1:
- Frequency map: {5=2, 4=2, 6=1}
- Sorted list: [(4, 2), (5, 2), (6, 1)]
- Output: "4 4 5 5 6"

Test Case 2:
- Frequency map: {9=3, 2=1, 5=1}
- Sorted list: [(9, 3), (2, 1), (5, 1)]
- Output: "9 9 9 2 5"
*/
