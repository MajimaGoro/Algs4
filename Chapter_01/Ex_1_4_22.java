// Binary search with only addition and subtraction. [Mihai Patrascu] Write a program that, given an array of N distinct int values in ascending order, 
// determines whether a given integer is in the array. You may use only additions and subtractions and a constant amount of extra memory. The running 
// time of your program should be proportional to log N in the worst case.
// Answer: Instead of searching based on powers of two (binary search), use Fibonacci numbers (which also grow exponentially). Maintain the current search 
// range to be [i, i + F(k)] and keep F(k), F(k-1) in two variables. At each step compute F(k-2) via subtraction, check element i + F(k-2), and update the 
// range to either [i, i + F(k-2)] or [i + F(k-2), i + F(k-2) + F(k-1)].

import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;


public class Ex_1_4_22 {
    public static boolean search(int[] array, int value) {
        Arrays.sort(array);

        int f1 = 1;
        int f2 = 1;
        while (f2 < array.length) {
            int temp = f2;
            f2 += f1;
            f1 = temp;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = Math.min(low + f2 - f1 - 1, high);
            StdOut.println("low: " + low + " high: " + high + " mid: " + mid + " f1: " + f1 + " f2: " + f2);
            if (array[mid] < value) {
                low = mid + 1;
                int temp = f1;
                f1 = f2 - f1;
                f2 = temp;
            }
            else if (array[mid] > value) {
                high = mid - 1;
                f2 = f2 - f1;
                f1 = f1 - f2;
            }
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 10, 8, 7, 13, 9, 6};
        StdOut.println(search(a, 10));
        StdOut.println(search(a, 20));
        StdOut.println(search(a, -10));
    }
}