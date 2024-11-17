
/* 

https://www.geeksforgeeks.org/program-print-diamond-shape/
https://youtu.be/xzstcj3Cuso?si=kdkskhAARlIIDztg 
https://simplycoding.in/star-pattern-programs-in-java/


 Two Basic Building blocks for Print any pattern is 
 1.Increasing triangle 
 2.Decreasing triangle
 
 Printing Basics
 
 
 Important things in Pattern
 1.The important thing in pattern is size(how many rows you want in the triangle)
 2.Putting together nested loops
 - Outer loop for row
 - Inner Loop for column
 
 */
 
 public class PatternPrinting
 {
    // pattern square
    public static void patternSquare(int n) {
        // outer loop for row 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // increasing triangle
    public static void incresingTrianglePattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void decreasingTrianglePattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // right sided triangle with decreasing space and increasing star
    public static void rightSidedTriangle(int n) {
        // outer loop for row
        for (int i = 1; i <= n; i++) {
            // to print the decreasing space
            //  space for loop has to come first
            for (int j = i; j <= n; j++) {
                // two blank space characters have to used if use two characters
                // inside the printing  System.out.print("* ");
                System.out.print("  ");
            }
            // to print the increasing star
            for (int j = 1; j <= i; j++) {
                // two characters used inside the print statement
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // right sided triangle with increasing space and decreasing star
    public static void rightSidedTriangleWithInSDrs(int n) {
        // outer loop
        for (int i = 1; i <= n; i++) {
            // "space" for loop has to come first
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");
            }

            // "star" for loop has to come second
            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // hill pattern
    public static void hillPattern(int n) {
        for (int i = 1; i <= n; i++) {
            // to print the decreasing space
            //  space for loop has to come first
            for (int j = i; j <= n; j++) {
                // two blank space characters have to used if use two characters
                // inside the printing  System.out.print("* ");
                System.out.print("  ");
            }
            // to print the increasing star
            for (int j = 1; j < i; j++) {
                // two characters used inside the print statement
                System.out.print("* ");
            }
            for (int j = 1; j <= i; j++) {
                // two characters used inside the print statement
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // reverse hill pattern
    public static void reverseHill(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");
            }

            for (int j = i; j < n; j++) {
                System.out.print("* ");
            }

            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void diamondPattern(int n) {
        for (int i = 1; i < n; i++) {
            // to print the decreasing space
            //  space for loop has to come first
            for (int j = i; j <= n; j++) {
                // two blank space characters have to used if use two characters
                // inside the printing  System.out.print("* ");
                System.out.print("  ");
            }
            // to print the increasing star
            for (int j = 1; j < i; j++) {
                // two characters used inside the print statement
                System.out.print("* ");
            }
            for (int j = 1; j <= i; j++) {
                // two characters used inside the print statement
                System.out.print("* ");
            }

            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");
            }

            for (int j = i; j < n; j++) {
                System.out.print("* ");
            }

            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        // patternSquare(5);
        // incresingTrianglePattern(5);
        // decreasingTrianglePattern(5);
        // rightSidedTriangle(5);
        // rightSidedTriangleWithInSDrs(5);
        // hillPattern(5);
        // reverseHill(5);
        diamondPattern(5);
    }
}
