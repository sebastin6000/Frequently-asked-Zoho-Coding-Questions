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

Expected Output: The output should be a sorted array where elements are sorted by frequency, and in case of ties, by value.


*/

/* 
Extracting Information from the Problem Statement:
- Input data type: The input consists of integers in an array for each test case.
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
2    | Sort the elements based on frequency, and if needed,   |
       by value.                                              | Use a Comparator to sort by frequency (descending) and by value (ascending).
3    | Print the sorted array.                                | Iterate through the sorted list and print the elements in the required order.

*/

/* 
Code Requirement to Complete the Subtasks:
- A loop to iterate through the array and calculate frequencies.
- A data structure (`HashMap`) to store frequencies.
- A sorting mechanism using a custom comparator to sort by frequency and value.
- A final loop to print the sorted elements.

*/

/* Java Code According to Conversational Subtasks: */

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
          // https://www.scaler.com/topics/getordefault-in-java/ 
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
/* 
break down the line of code you're asking about:
List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());

### Key Concepts:
1. `Map.Entry`: In Java, `Map` is an interface representing a collection of key-value pairs. 
   Each key-value pair in a map is called an **entry**. 
   The `Map.Entry` interface is used to represent these individual entries, which include both the key and the associated value.
   In your case, the `Map<Integer, Integer>` is a `HashMap`, 
   where the key is an integer (the element from the array) and the value is an integer (the frequency of that element in the array).

2.`frequencyMap.entrySet()`: 
  This method is called on the `frequencyMap`, which is a `HashMap<Integer, Integer>`. 
  The `entrySet()` method returns a **set of Map.Entry objects**, 
  where each `Map.Entry` object contains a key-value pair (the number from the array and its frequency).

3.`new ArrayList<>(...)`: 
This constructs a new `ArrayList` from the collection provided in the parentheses. In this case, 
it's converting the set of entries (from `frequencyMap.entrySet()`) into a list.

### Explanation of the Code:

- `frequencyMap.entrySet()`: 
  - This returns a **set** of entries (key-value pairs) from the map. 
    For example, if `frequencyMap` contains `{5=2, 4=2, 6=1}`, the `entrySet()` method will return a set like: `{5=2, 4=2, 6=1}`.

- `new ArrayList<>(frequencyMap.entrySet())`: 
  - This creates a **list** from the set returned by `entrySet()`. 
    A `List` is used here because a `List` provides better functionality for sorting, and we need to sort the entries by frequency and value.
  - By passing the set directly to the `ArrayList` constructor, you're essentially converting the set into a list of `Map.Entry` objects. 
    Each entry in this list will contain the element (key) and its frequency (value).

### Why do we need this?
The reason for converting the map entries into a list is that we need to **sort** the entries. 
You can't sort a `Map` directly, but you can sort a `List`, which is why the entries are first converted into a list.

Once converted into a list, the sorting logic (based on frequency and element value) can be applied using `Collections.sort()`.

### Example:
Suppose the `frequencyMap` is:
{5=3, 4=2, 6=1}

Calling `entrySet()` on `frequencyMap` would return a set like:
[{5=3}, {4=2}, {6=1}]

After creating the list from the set using `new ArrayList<>(...)`, you'd get:
[{5=3}, {4=2}, {6=1}]


This list of entries can then be sorted based on the specified criteria (first by frequency in descending order,
and in case of a tie, by element value in ascending order).

*/
/* 
This block of code is sorting the list of `Map.Entry<Integer, Integer>` objects. 
Let’s go through it step by step to explain what it's doing.

 Code Breakdown:
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


 Explanation:
1. `Collections.sort(list, ...)`:
   - `Collections.sort(list)` is a static method that sorts the list you provide (`list` in this case) in ascending order.
      However, because we want custom sorting (based on frequency and element value), 
      we provide a Comparator to specify the sorting logic.

2. Comparator:
   - The `Comparator<Map.Entry<Integer, Integer>>` is used to compare pairs of `Map.Entry<Integer, Integer>`. 
      Each `Map.Entry` contains two pieces of information:
     - Key: The number from the array (like 5, 4, 6).
     - Value: The frequency of that number in the array.

3. `compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)`:
   - The `compare` method is defined to compare two `Map.Entry` objects (denoted `o1` and `o2`).
   - `o1.getKey()` gives the number (element), and `o1.getValue()` gives its frequency (the same goes for `o2`).

4. Sorting Logic:
   - First, we check if the frequencies (`getValue()`) of the two entries are the same:
   
     if (o2.getValue().equals(o1.getValue())) { 
     - If the frequencies are equal, then we sort the entries by their key (the element itself) in ascending order:
    
       return Integer.compare(o1.getKey(), o2.getKey());
       - This means that if two elements have the same frequency, the smaller number will come before the larger number in the list.
   
   - If the frequencies are not equal, we compare them based on frequency in descending order:
     
     return Integer.compare(o2.getValue(), o1.getValue());
     
     - This means that the entry with the higher frequency will come before the one with the lower frequency in the sorted list. 
     - `Integer.compare(o2.getValue(), o1.getValue())` is used to ensure a descending order,
        because `o2.getValue()` is compared to `o1.getValue()`. 
        If the first value (`o2.getValue()`) is greater than the second (`o1.getValue()`), 
        it will return a positive value, indicating that `o2` should come before `o1`.

 Example:

Suppose we have the following `list` of entries (key-value pairs):
[{5=3}, {4=2}, {6=1}]

The sorting process would go as follows:
- Compare `{5=3}` and `{4=2}`:
  - The frequencies are different (3 vs. 2), so `{5=3}` comes first because 3 > 2.
  
- Compare `{5=3}` and `{6=1}`:
  - Again, the frequencies are different (3 vs. 1), so `{5=3}` stays before `{6=1}`.
  
- Now compare `{4=2}` and `{6=1}`:
  - The frequencies are different (2 vs. 1), so `{4=2}` comes before `{6=1}`.

The sorted list is:
[{5=3}, {4=2}, {6=1}]

If two entries have the same frequency, for example:
[{5=2}, {4=2}, {6=1}]

The sorting process would go as follows:
- `{5=2}` and `{4=2}` have the same frequency (2), so we compare their keys.
  - `Integer.compare(o1.getKey(), o2.getKey())` compares 5 and 4, and since 4 < 5, `{4=2}` will come before `{5=2}`.

The sorted list becomes:
[{4=2}, {5=2}, {6=1}]


 Summary:
The comparator sorts the entries:
- First by frequency: Higher frequencies come first (in descending order).
- Then by value: If frequencies are equal, the numbers are sorted in ascending order.

This ensures that numbers with higher frequencies are placed earlier in the list, and if there’s a tie in frequency,
the smaller numbers come first.

*/
/* 

Code Breakdown:
```java
for (Map.Entry<Integer, Integer> entry : list) {
    // Print the element entry.getValue() times
    for (int i = 0; i < entry.getValue(); i++) {
        System.out.print(entry.getKey() + " ");
    }
}
```
This code block is responsible for printing the sorted array based on the frequency 
and element values after the list of `Map.Entry<Integer, Integer>` objects has been sorted. Let me explain the logic step by step:

Explanation:
1. Outer `for` Loop:  
   ```java
   for (Map.Entry<Integer, Integer> entry : list)
   ```
   - This loop iterates over the sorted list of entries (`list`), where each entry is a `Map.Entry<Integer, Integer>`. 
   - The `entry` object represents a key-value pair where:
     - `entry.getKey()` is the element from the array.
     - `entry.getValue()` is the frequency (the number of times that element appeared in the array).
   
   For example, if the list looks like this (after sorting):
   ```java
   [{5=3}, {4=2}, {6=1}]
   ```
   - The loop will iterate through the three entries `{5=3}`, `{4=2}`, and `{6=1}` in this order.

2. Inner `for` Loop:
   ```java
   for (int i = 0; i < entry.getValue(); i++) {
       System.out.print(entry.getKey() + " ");
   }
   ```
   - For each `entry`, the inner loop prints the key (`entry.getKey()`) a number of times equal to its frequency (`entry.getValue()`).
   - `entry.getValue()` is the frequency of the current element, 
      so the inner loop runs that many times and prints the element (`entry.getKey()`).
   
   Let's break it down further:
   - If `entry.getValue()` is 3 (i.e., the frequency of the element is 3), 
     the inner loop will execute 3 times and print the key (the element) three times.
   - If `entry.getValue()` is 2 (i.e., the frequency is 2), the loop will print the key two times, and so on.

Example Walkthrough:
Consider the sorted list:

```java
[{5=3}, {4=2}, {6=1}]
```

1. First iteration: The first entry is `{5=3}`:
   - `entry.getKey()` is 5 (the element), and `entry.getValue()` is 3 (its frequency).
   - The inner loop will run 3 times, printing the element `5` three times:
     ```
     5 5 5
     ```

2. Second iteration: The second entry is `{4=2}`:
   - `entry.getKey()` is 4, and `entry.getValue()` is 2.
   - The inner loop will run 2 times, printing the element `4` two times:
     ```
     4 4
     ```

3. Third iteration: The third entry is `{6=1}`:
   - `entry.getKey()` is 6, and `entry.getValue()` is 1.
   - The inner loop will run 1 time, printing the element `6` once:
     ```
     6
     ```

Output:
After all iterations, the final printed result will be:

```
5 5 5 4 4 6
```

Summary:
- The outer loop iterates over the sorted list of elements and their frequencies.
- The inner loop prints each element (`entry.getKey()`) as many times as its frequency (`entry.getValue()`).
- This results in printing the elements in descending order of frequency, 
  and if two elements have the same frequency, they are printed in ascending order of the element's value.
*/
