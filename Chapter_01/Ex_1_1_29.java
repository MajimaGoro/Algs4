// 1.1.29  等值键。为BinarySearch 类添加一个静态方法rank()，它接受一个键和一个整型有序数组（可能存在重复键）作为参数并返回数组中小于该键的元素数量，
// 以及一个类似的方法count() 来返回数组中等于该键的元素的数量。注意：如果i 和j 分别是rank(key,a) 和count(key,a)的返回值，
// 那么a[i..i+j-1] 就是数组中所有和key 相等的元素。

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class Ex_1_1_29 {
    public static void main(String[] args) {
        In in = new In("tinyW.txt");
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);
        
        String indices = "",
               values = "";
        for (int i = 0; i < whitelist.length; i++)
        {
            indices += String.format("%4d", i);
            values += String.format("%4d", whitelist[i]);
        }
        StdOut.println(indices + "\n" + values);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int r = rank(key, whitelist);
            int c = count(key, whitelist);
            StdOut.printf("(%d, %d)\n", r, c);
        }
    }

    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (key > a[mid]) {
                low = mid + 1;
            }
            else if (key < a[mid]) {
                high = mid - 1;
            }
            else {
                while (--mid >= 0 && key == a[mid]);
                return mid + 1;
            }
        }
        return 0;
    }

    public static int count(int key, int[] a) {
        int c = 0;
        for (int i = rank(key, a); i < a.length && key == a[i]; i++) {
            c++;
        }
        return c;
    }
}