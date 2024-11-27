/*
Question:
We are given an array of jobs, where each job has the following attributes: jobid, deadline, and profit. 
Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. 
We earn the profit associated with a job if and only if it is completed by its deadline. 
The objective is to find the maximum number of jobs that can be completed and the maximum profit.

Example:

Input: jobs[] = [(1,4,20), (2,1,1), (3,1,40), (4,1,30)]
Output: [2, 60]
Explanation: Job1 and Job3 can be done, yielding a maximum profit of 60 (20 + 40).

Input: jobs[] = [(1,2,100), (2,1,19), (3,2,27), (4,1,25), (5,1,15)]
Output: [2, 127]
Explanation: Job 1 (profit 100) and Job 3 (profit 27) are completed for a total profit of 127.

*/

 /* 
Understanding the Problem Statement:

1.1 Explanation of the Problem Statement:
- Each job consists of a jobid, deadline, and profit. 
- The job must be completed by its deadline to earn the profit.
- Jobs are completed one by one, and each job takes exactly 1 unit of time.
- We are asked to maximize the number of jobs completed and the total profit.
- Jobs that can be completed before or by their deadlines must be selected such that the profit is maximized.

1.2 What is being asked:
- The task is to find the maximum number of jobs that can be scheduled before their respective deadlines and also compute the total profit for the selected jobs.

*/

 /* 
Extracting Information from the Problem Statement:

2.1 Input Data Type:
- The input is an array of jobs, where each job is represented by a tuple (jobid, deadline, profit).

2.2 Expected Output:
- The expected output is a list of two integers:
  1. The number of jobs completed.
  2. The maximum profit obtained by completing those jobs.

2.3 Output Return Type:
- The output will be an array of integers of size 2, where the first element is the number of jobs done and the second is the total profit.

2.4 Explanation of Time Complexity Expectations:
- The expected time complexity of the solution should be around O(n log n) to O(n^2), depending on how we choose to solve the problem.
- Sorting the jobs will take O(n log n), and the scheduling process will depend on how we select the job for each time slot.

2.5 Explanation of Given Constraints:
- Jobs can range up to 10^5 in size.
- The problem suggests efficient use of sorting or greedy approaches for selection.
*/

 /* 
Thinking Solution for the Problem Statement:

3.1 Identification Part:
- This is a "Job Scheduling" problem, which is usually solved using a greedy approach.
- The key to solving this problem is sorting the jobs by profit in descending order and attempting to schedule the jobs starting from the highest profit.

3.2 Destructuring:
- We can schedule the jobs by iterating over them in decreasing order of profit, 
  and at each step, we will try to schedule the job in the latest available slot before its deadline.

3.3 Conversional solution into smaller subtask:
- **Subtask 1**: Sort the jobs by profit in descending order.
- **Subtask 2**: Use a greedy approach to schedule jobs. For each job, check if a slot is available before or at its deadline.
- **Subtask 3**: Track the number of jobs done and accumulate the profit from successfully scheduled jobs.

*/

 /* 
Conversional Solution into subtasks:

S.no  | Subtask Description
1     | Sort the jobs by profit in descending order.
2     | Iterate through the sorted jobs and try to schedule each job in the latest available slot before its deadline.
3     | Keep track of the number of jobs done and the total profit.

*/

 /* 
Subtasks of Conversional Solution into Code:

1. Sort the array of jobs by profit in descending order.
2. Use a boolean array or a set to track the slots that are already occupied.
3. Iterate over the jobs and try to schedule them in the available slots.
4. For each scheduled job, update the count of jobs and accumulate the total profit.
5. Print the total number of jobs done and the maximum profit.

*/

 /* 
Java Code according to conversational subtasks:
*/

import java.util.*;

class Job {
    int jobid;
    int deadline;
    int profit;

    // Constructor to initialize the job
    public Job(int jobid, int deadline, int profit) {
        this.jobid = jobid;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {

    // Function to find the maximum number of jobs and maximum profit
    public static int[] jobScheduling(Job[] jobs, int n) {
        // Step 1: Sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Initialize an array to track available slots
        boolean[] slot = new boolean[n];
        Arrays.fill(slot, false); // All slots are initially empty

        int countJobs = 0; // Number of jobs completed
        int totalProfit = 0; // Total profit accumulated

        // Step 3: Iterate through the jobs and try to schedule them
        for (int i = 0; i < n; i++) {
            // Find a slot for the job
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                // If the slot is empty, schedule the job here
                if (!slot[j]) {
                    slot[j] = true; // Mark the slot as occupied
                    countJobs++; // Increment the job count
                    totalProfit += jobs[i].profit; // Add the profit
                    break; // Move on to the next job
                }
            }
        }

        // Step 4: Return the number of jobs done and the maximum profit
        return new int[]{countJobs, totalProfit};
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Example 1
        Job[] jobs1 = {
            new Job(1, 4, 20),
            new Job(2, 1, 1),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };
        int[] result1 = jobScheduling(jobs1, jobs1.length);
        System.out.println(Arrays.toString(result1)); // Output: [2, 60]

        // Example 2
        Job[] jobs2 = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 1, 15)
        };
        int[] result2 = jobScheduling(jobs2, jobs2.length);
        System.out.println(Arrays.toString(result2)); // Output: [2, 127]

        // Example 3
        Job[] jobs3 = {
            new Job(1, 3, 50),
            new Job(2, 1, 10),
            new Job(3, 2, 20),
            new Job(4, 2, 30)
        };
        int[] result3 = jobScheduling(jobs3, jobs3.length);
        System.out.println(Arrays.toString(result3)); // Output: [2, 80]
    }
}

 /* 
Time and Space Complexity Explanation:

Time Complexity:
- Sorting the jobs takes O(n log n), where n is the number of jobs.
- For each job, we try to find a suitable slot, which in the worst case takes O(n) time.
- Thus, the total time complexity is O(n log n + n^2), but since n is bounded by 10^5, this approach will work efficiently within the problem's constraints.

Space Complexity:
- The space complexity is O(n) due to the additional space used by the `slot` array to track available time slots.

*/

 /* 
If used any "for" loop or "while" loop, you have walkthrough all the "for" loop used in the code:

1. The first `for` loop is used to iterate through the jobs array and sort the jobs by profit in descending order.
2. The second `for` loop is used to check for available slots for each job. 
   For each job, we start from the last possible time slot before its deadline and try to find the first available slot.
3. Inside the second `for` loop, we attempt to assign each job to the latest available slot, 
   ensuring that jobs are scheduled as close to their deadlines as possible.

Example walkthrough with input `[(1, 4, 20), (2, 1, 1), (3, 1, 40), (4, 1, 30)]`:

1. The jobs are first sorted by profit: `[(3, 1, 40), (1, 4, 20), (4, 1, 30), (2, 1, 1)]`.
2. The first job (job 3) is assigned to slot 0, then job 1 is assigned to slot 3.
3. The result is that two jobs are completed, yielding a profit of 60.

*/

 /* 
Complete code walkthrough with applying the given input in code and explanation:

1. The jobs array is sorted by profit in descending order.
2. The scheduling process attempts to assign jobs starting from the highest profit to the latest possible slot before their deadline.
3. After all jobs are processed, the number of jobs completed and the total profit are returned.

For input `[(1, 4, 20), (2, 1, 1), (3, 1, 40), (4, 1, 30)]`:
- Jobs sorted by profit: [(3, 1, 40), (1, 4, 20), (4, 1, 30), (2, 1, 1)].
- Job 3 is scheduled at time slot 0 (profit 40), and Job 1 is scheduled at time slot 3 (profit 20).
- The total profit is 60, and two jobs are completed.

*/

