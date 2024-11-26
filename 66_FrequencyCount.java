/* 
Question:
You are given an array arr[] containing positive integers. 
The elements in the array arr[] range from 1 to n (where n is the size of the array), and some numbers may be repeated or absent. 
Your task is to count the frequency of all numbers in the range 1 to n 
and return an array of size n such that result[i] represents the frequency of the number i (1-based indexing).

Examples:

Input: arr[] = [2, 3, 2, 3, 5]
Output: [0, 2, 2, 0, 1]
Explanation: We have: 1 occurring 0 times, 2 occurring 2 times, 3 occurring 2 times, 4 occurring 0 times, and 5 occurring 1 time.

Input: arr[] = [3, 3, 3, 3]
Output: [0, 0, 4, 0]
Explanation: We have: 1 occurring 0 times, 2 occurring 0 times, 3 occurring 4 times, and 4 occurring 0 times.

Input: arr[] = [1]
Output: [1]
Explanation: We have: 1 occurring 1 time, and there are no other numbers between 1 and the size of the array.

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ arr.size().
*/

/* 
Understanding the Problem Statement:
- We are given an array of integers where each integer is between 1 and n (inclusive), where n is the size of the array.
- Our task is to count the frequency of each number in the range [1, n] and return the frequency counts in a result array.
- The result array should have n elements, where result[i] denotes the frequency of the number i (1-based indexing).

What is being asked:
- Given an array `arr[]` where the elements are in the range [1, n] and may have repetitions or absences, 
  we need to calculate the frequency of each number between 1 and n and return this frequency in a new array.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - The input is an array `arr[]` containing positive integers. 
   - The size of the array is denoted as n, where 1 ≤ arr.size() ≤ 106.
   - Each element in the array `arr[]` is an integer between 1 and n (1 ≤ arr[i] ≤ arr.size()).

2. Expected Output:
   - The output should be an array of size n where each element represents the frequency of the number i (1-based index).

3. Output return type:
   - An array of size n representing the frequency of numbers from 1 to n.

4. Time complexity expectations:
   - The time complexity of the solution must be efficient enough to handle the constraint of array size up to 10^6.
   - The goal is to achieve a time complexity of O(n), where n is the size of the array.

5. Constraints:
   - Array size can go up to 10^6, which means that we need to use an O(n) time complexity solution for counting frequencies.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a counting problem, where we need to count how many times each integer from 1 to n appears in the given array `arr[]`.
   - Since the numbers are between 1 and n, the array can be viewed as a range where the frequency of each number can be tracked.

2. Destructuring:
   - We can use an array `freq[]` of size n to store the frequency of each number from 1 to n.
   - The idea is to iterate through the input array `arr[]`, for each number encountered, we increment its corresponding position in the frequency array.

3. Conversational solution into smaller subtask:
   - Step 1: Create an array `freq[]` of size n initialized to zero.
   - Step 2: Iterate through the input array `arr[]`, and for each element, increment the count in the corresponding position in the `freq[]` array.
   - Step 3: Return the frequency array `freq[]`.

*/

/* 
Conversional Solution into Subtasks:
1. Initialize an array `freq[]` of size n (with all elements initially 0).
2. Traverse through the input array `arr[]` and update the frequency array `freq[]`.
3. Return the frequency array `freq[]` as the result.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Create an array `freq[]` of size n, where each index represents the frequency of that number.
2. Traverse the input array and update the `freq[]` array based on the numbers encountered.
3. Return the result array.

*/

/* 
Java Code according to conversational subtasks.
*/

public class FrequencyCount {

    // Function to count frequency of each number in the array arr[]
    public static int[] frequencyCount(int[] arr) {
        int n = arr.length;
        // Create a result array to store the frequency of each number from 1 to n
        int[] freq = new int[n];

        // Traverse the input array and update frequency count
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            // Increment the frequency of the number in the freq array (adjust for 1-based index)
            freq[num - 1]++;
        }

        return freq;
    }

    // Main method to test the frequencyCount function
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {2, 3, 2, 3, 5};
        int[] result1 = frequencyCount(arr1);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();

        // Test Case 2
        int[] arr2 = {3, 3, 3, 3};
        int[] result2 = frequencyCount(arr2);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();

        // Test Case 3
        int[] arr3 = {1};
        int[] result3 = frequencyCount(arr3);
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + " ");
        }
        System.out.println();
    }
}

/* 
Time and Space Complexity Explanation:
1. Time Complexity:
   - The time complexity of the solution is O(n), where n is the size of the input array `arr[]`. 
     This is because we traverse the array once and update the frequency array in constant time for each element.
   
2. Space Complexity:
   - The space complexity is O(n), as we are using an additional array `freq[]` of size n to store the frequency counts.

*/

/* 
For loop walkthrough:
- In the `frequencyCount()` method, the first loop iterates over each element of the input array `arr[]`.
- For each element `arr[i]`, we increment the corresponding frequency count in the `freq[]` array at index `arr[i] - 1`.
- The second part of the code in the `main()` method prints the contents of the `freq[]` array.

Example for input `arr = [2, 3, 2, 3, 5]`:
1. Initialize freq[] as [0, 0, 0, 0, 0].
2. First, we encounter `2`, so `freq[1]` becomes 1. The array becomes [0, 1, 0, 0, 0].
3. Next, we encounter `3`, so `freq[2]` becomes 1. The array becomes [0, 1, 1, 0, 0].
4. Then, we encounter `2` again, so `freq[1]` becomes 2. The array becomes [0, 2, 1, 0, 0].
5. We encounter `3` again, so `freq[2]` becomes 2. The array becomes [0, 2, 2, 0, 0].
6. Finally, we encounter `5`, so `freq[4]` becomes 1. The array becomes [0, 2, 2, 0, 1].

So, the result is `[0, 2, 2, 0, 1]`.

*/

/* 
Complete code walkthrough:
- We initialize the frequency array `freq[]` to store counts for each number from 1 to n.
- We loop through the input array `arr[]`, incrementing the respective frequency count in the `freq[]` array for each element.
- After processing all elements, the result array `freq[]` is printed, showing the frequency of each number from 1 to n.

Output for input `arr = [2, 3, 2, 3, 5]` will be:
0 2 2 0 1
*/
