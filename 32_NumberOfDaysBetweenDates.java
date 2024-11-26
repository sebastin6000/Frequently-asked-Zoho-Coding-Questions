/* 
Question:
Given two dates, find the total number of days between them. The system follows the Gregorian calendar from the beginning of time.
You need to write a function `noOfDays` which takes two dates as input: (d1, m1, y1) and (d2, m2, y2) and returns the number of days between them.

Example 1:
Input: d1 = 10, m1 = 2, y1 = 2014
       d2 = 10, m2 = 3, y2 = 2015
Output: 393

Example 2:
Input: d1 = 10, m1 = 2, y1 = 2001
       d2 = 10, m2 = 2, y2 = 2002
Output: 365

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ d1, d2 ≤ 31
1 ≤ m1, m2 ≤ 12
1 ≤ y1, y2 ≤ 3000
*/

/* 
Understanding the Problem Statement:
- We are given two dates, and we need to calculate the number of days between them.
- The dates are in the Gregorian calendar, which means we need to account for leap years when counting the number of days between two dates.
- The input consists of two dates in the format (d1, m1, y1) and (d2, m2, y2).
- The task is to compute the difference in days between these two dates, which may span across multiple years, including leap years.

What is being asked:
- We need to return the number of days between two given dates. 
- The solution must handle leap years and varying numbers of days in months.
- We must find a way to compute this difference efficiently without needing complex data structures or iterative loops.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - Integers representing two dates (day, month, year) in the format: (d1, m1, y1) and (d2, m2, y2).
2. Expected Output:
   - The total number of days between the two dates.
3. Output return type:
   - Integer (the number of days between the two dates).
4. Time complexity expectations:
   - The expected time complexity is O(1), meaning the solution should be constant time regardless of the input size.
5. Constraints:
   - 1 ≤ d1, d2 ≤ 31
   - 1 ≤ m1, m2 ≤ 12
   - 1 ≤ y1, y2 ≤ 3000
   - This implies we need to work with valid Gregorian calendar dates.
*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a simple date difference problem, but we need to account for leap years, varying days in months, and the range of years.
   - The problem is asking for a direct calculation of the difference between two dates.

2. Destructuring:
   - We need to compute the difference in days between two dates, 
     which can be easily done by leveraging built-in date-handling libraries such as Java's `java.time` package.
   - The logic will be based on computing the number of days between the two given dates, considering leap years and month lengths.

3. Conversional solution into smaller subtask:
   - Subtask 1: Convert the input dates into a format that allows for easy comparison (i.e., `LocalDate` objects).
   - Subtask 2: Calculate the difference between the two dates in days using the `ChronoUnit.DAYS.between` method.
   - Subtask 3: Return the absolute value of the difference to handle both cases where `d1 < d2` and `d2 < d1`.

*/

/* 
Conversional Solution into Subtasks:
1. Convert the given date (d1, m1, y1) and (d2, m2, y2) to `LocalDate` objects.
2. Use the `ChronoUnit.DAYS.between()` method to calculate the difference in days between the two dates.
3. Return the absolute value of the calculated days difference.
*/

/* 
Subtasks of Conversional Solution into Code:
1. Convert the date into `LocalDate` objects.
2. Use the `ChronoUnit.DAYS.between()` method to find the difference.
3. Return the absolute value of the difference to ensure a positive result.
*/

/* 
Java Code according to conversational subtasks.
*/

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NumberOfDaysBetweenDates {

    // Method to calculate the number of days between two given dates
    public static long noOfDays(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Step 1: Convert the dates into LocalDate objects
        LocalDate date1 = LocalDate.of(y1, m1, d1);
        LocalDate date2 = LocalDate.of(y2, m2, d2);

        // Step 2: Calculate the difference in days between the two dates
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);

        // Step 3: Return the absolute value of the difference
        return Math.abs(daysBetween);
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Test case 1
        int d1 = 10, m1 = 2, y1 = 2014;
        int d2 = 10, m2 = 3, y2 = 2015;
        System.out.println(noOfDays(d1, m1, y1, d2, m2, y2));  // Expected output: 393

        // Test case 2
        d1 = 10; m1 = 2; y1 = 2001;
        d2 = 10; m2 = 2; y2 = 2002;
        System.out.println(noOfDays(d1, m1, y1, d2, m2, y2));  // Expected output: 365
    }
}

/* 
Time and Space Complexity Explanation:
- Time Complexity: O(1). We are only converting the dates into `LocalDate` objects and calculating the difference using built-in methods. 
  These operations are constant time operations.
- Space Complexity: O(1). We are only using a few variables to store the dates and the result, so the space complexity is constant.

*/

/*
Step-by-step walkthrough with input d1 = 10, m1 = 2, y1 = 2014 and d2 = 10, m2 = 3, y2 = 2015:

1. We first convert both dates into `LocalDate` objects:
   - LocalDate date1 = LocalDate.of(2014, 2, 10);  // 10th February 2014
   - LocalDate date2 = LocalDate.of(2015, 3, 10);  // 10th March 2015

2. We calculate the difference in days between the two dates using `ChronoUnit.DAYS.between(date1, date2)`:
   - The difference in days is 393.

3. The result is printed as 393.

For the second test case with input d1 = 10, m1 = 2, y1 = 2001 and d2 = 10, m2 = 2, y2 = 2002:

1. We convert both dates into `LocalDate` objects:
   - LocalDate date1 = LocalDate.of(2001, 2, 10);
   - LocalDate date2 = LocalDate.of(2002, 2, 10);

2. The difference in days is calculated to be 365 (as 2001 was not a leap year).

3. The result is printed as 365.
*/
