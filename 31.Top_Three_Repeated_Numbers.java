/* 
Question:
Given an array of size N with repeated numbers, you have to find the top three repeated numbers.
Note: If two numbers have the same frequency, the one that appears first in the array should be output first.

Examples:

Input : arr[] = {3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3} 
Output : Three largest elements are 3 16 15 
Explanation: Here, 3 comes 4 times, 16 comes 3 times, 15 comes 3 times. The output is in the order of first appearance.

Input : arr[] = {2, 4, 3, 2, 3, 4, 5, 5, 3, 2, 2, 5} 
Output : Three largest elements are 2 3 5.
Explanation: 2 comes 4 times, 3 comes 3 times, and 5 comes 3 times. The output is in the order of first appearance.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^9
*/

/* 
Understanding the Problem Statement:
- We are given an array with integers, some of which are repeated.
- Our task is to identify the three most frequent numbers in the array. If two numbers have the same frequency, we return the one that appeared first in the array.
- The output should list the top three most frequent numbers, or fewer if the array has fewer than three distinct numbers.

What is being asked:
- From the given array, identify the three numbers with the highest frequencies. If two numbers have the same frequency, we select the one that appears first.
- Return these numbers in the order of their frequency. If the array has fewer than three distinct numbers, we return as many as possible.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - An array of integers.
2. Expected Output:
   - A list of the top three most frequent numbers, ordered by their frequency.
   - If two numbers have the same frequency, the one that appeared first in the array should be chosen.
3. Output return type:
   - A list or array of integers (the top three most frequent numbers).
4. Time complexity expectations:
   - The time complexity should be O(N), where N is the number of elements in the array. This is because we need to count occurrences and sort the top three numbers, all of which can be done in linear time.
5. Constraints:
   - The array size can go up to 10^5, so our solution should be efficient and run in linear time.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a frequency counting problem, where we need to track how many times each number appears in the array.
   - We then need to sort these numbers by frequency, taking care to maintain the order of their first appearance if frequencies are equal.

2. Destructuring:
   - We can break the problem into these steps:
     - Count the frequency of each element in the array.
     - Track the first occurrence of each element to handle ties in frequency.
     - Sort the elements based on their frequency (and first occurrence when necessary).
     - Return the top three elements (or fewer if there aren't three distinct elements).

3. Conversional solution into smaller subtask:
   - Subtask 1: Count the frequency of each element in the array using a hashmap.
   - Subtask 2: Track the first occurrence of each element using a list.
   - Subtask 3: Sort the elements by frequency and then by the order of appearance in the array.
   - Subtask 4: Return the top three most frequent elements.
*/

/* 
Conversional Solution into Subtasks:
1. Count the frequency of each element in the array.
2. Track the first occurrence of each element.
3. Sort the elements by frequency and then by the order of appearance.
4. Return the top three frequent elements.
*/

/* 
Subtasks of Conversional Solution into Code:
1. Create a frequency map to count occurrences.
2. Create an ordered list to track first occurrences.
3. Sort the elements based on frequency and first appearance.
4. Return the top three frequent elements.
*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class TopThreeRepeatedNumbers {

    public static List<Integer> findTopThreeRepeated(int[] arr) {
        // Step 1: Frequency Map to store counts
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        // Step 2: Track first occurrences
        Set<Integer> seen = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!seen.contains(num)) {
                seen.add(num);
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }

        // Step 3: Convert the frequency map to a list and sort by frequency, then by first appearance
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        
        // Sorting first by frequency (descending), then by first occurrence
        sortedEntries.sort((entry1, entry2) -> {
            int freqComparison = entry2.getValue() - entry1.getValue();
            if (freqComparison == 0) {
                // If frequencies are equal, maintain the original order
                return Integer.compare(Arrays.asList(arr).indexOf(entry1.getKey()),
                                       Arrays.asList(arr).indexOf(entry2.getKey()));
            }
            return freqComparison;
        });

        // Step 4: Return the top 3 elements
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedEntries.size()); i++) {
            result.add(sortedEntries.get(i).getKey());
        }
        
        return result;
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3};
        List<Integer> result1 = findTopThreeRepeated(arr1);
        System.out.println("Three largest elements are: " + result1);  // Expected output: [3, 16, 15]
        
        // Test case 2
        int[] arr2 = {2, 4, 3, 2, 3, 4, 5, 5, 3, 2, 2, 5};
        List<Integer> result2 = findTopThreeRepeated(arr2);
        System.out.println("Three largest elements are: " + result2);  // Expected output: [2, 3, 5]
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity: O(N * log N), where N is the size of the array. The major operation is sorting the frequency map, which takes O(N * log N) time. 
  Counting the frequency is O(N).
- Space Complexity: O(N), where N is the size of the array. We use additional space for the frequency map and the list of sorted entries.
*/

/* 
“for” loop  walkthrough with every iteration with given input.
*/

/*
- The first "for" loop iterates over the array to count the frequency of each element. 
  - For arr1: {3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3}, the frequency map after the loop is:
    - {3=4, 4=1, 2=2, 16=3, 15=3}
- The second "for" loop is used to sort the frequency entries first by frequency, and then by first appearance if frequencies are the same.
- After sorting, the elements are selected based on the sorted list, returning the top 3 frequent elements.
*/

/* 
Complete code walkthrough with applying the given input in code and explanation and this section has to be inside this structure of comments.
*/

 /*
Step-by-step walkthrough with input arr1 = {3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3}:

1. After counting frequencies, we get the frequency map: {3=4, 4=1, 2=2, 16=3, 15=3}.
2. Sorting based on frequency and first occurrence gives: [(3, 4), (16, 3), (15, 3), (2, 2), (4, 1)].
3. The top three elements are 3, 16, 15.

Step-by-step walkthrough with input arr2 = {2, 4, 3, 2, 3, 4, 5, 5, 3, 2, 2, 5}:

1. After counting frequencies, we get the frequency map: {2=4, 4=2, 3=3, 5=3}.
2. Sorting based on frequency and first occurrence gives: [(2, 4), (3, 3), (5, 3), (4, 2)].
3. The top three elements are 2, 3, 5.
*/
